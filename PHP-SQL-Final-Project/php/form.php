<?php

//WRITE YOUR CODE HERE
require_once('classes/StickyForm.php');
$stickyForm = new StickyForm();

function init(){
    global $elementsArr, $stickyForm;
  
    /* IF THE FORM WAS SUBMITTED DO THE FOLLOWING  */
    if(isset($_POST['submit'])){
  
      /*THIS METHODS TAKE THE POST ARRAY AND THE ELEMENTS ARRAY (SEE BELOW) AND PASSES THEM TO THE VALIDATION FORM METHOD OF THE STICKY FORM CLASS.  IT UPDATES THE ELEMENTS ARRAY AND RETURNS IT, THIS IS STORED IN THE $postArr VARIABLE */
      $postArr = $stickyForm->validateForm($_POST, $elementsArr);
  
      /* THE ELEMENTS ARRAY HAS A MASTER STATUS AREA. IF THERE ARE ANY ERRORS FOUND THE STATUS IS CHANGED TO "ERRORS" FROM THE DEFAULT OF "NOERRORS".  DEPENDING ON WHAT IS RETURNED DEPENDS ON WHAT HAPPENS NEXT.  IN THIS CASE THE RETURN MESSAGE HAS "NO ERRORS" SO WE HAVE NO PROBLEMS WITH OUR VALIDATION AND WE CAN SUBMIT THE FORM */
      if($postArr['masterStatus']['status'] == "noerrors"){
        
        /*addData() IS THE METHOD TO CALL TO ADD THE FORM INFORMATION TO THE DATABASE (NOT WRITTEN IN THIS EXAMPLE) THEN WE CALL THE GETFORM METHOD WHICH RETURNS AND ACKNOWLEDGEMENT AND THE ORGINAL ARRAY (NOT MODIFIED). THE ACKNOWLEDGEMENT IS THE FIRST PARAMETER THE ELEMENTS ARRAY IS THE ELEMENTS ARRAY WE CREATE (AGAIN SEE BELOW) */
        return addData();
  
      }
      else{
        /* IF THERE WAS A PROBLEM WITH THE FORM VALIDATION THEN THE MODIFIED ARRAY ($postArr) WILL BE SENT AS THE SECOND PARAMETER.  THIS MODIFIED ARRAY IS THE SAME AS THE ELEMENTS ARRAY BUT ERROR MESSAGES AND VALUES HAVE BEEN ADDED TO DISPLAY ERRORS AND MAKE IT STICKY */
        return getForm("",$postArr);
      }
      
    }
  
    /* THIS CREATES THE FORM BASED ON THE ORIGINAL ARRAY THIS IS CALLED WHEN THE PAGE FIRST LOADS BEFORE A FORM HAS BEEN SUBMITTED */
    else {
        return getForm("", $elementsArr);
      } 
  }
  
  /* THIS IS THE DATA OF THE FORM.  IT IS A MULTI-DIMENTIONAL ASSOCIATIVE ARRAY THAT IS USED TO CONTAIN FORM DATA AND ERROR MESSAGES.   EACH SUB ARRAY IS NAMED BASED UPON WHAT FORM FIELD IT IS ATTACHED TO. FOR EXAMPLE, "NAME" GOES TO THE TEXT FIELDS WITH THE NAME ATTRIBUTE THAT HAS THE VALUE OF "NAME". NOTICE THE TYPE IS "TEXT" FOR TEXT FIELD.  DEPENDING ON WHAT HAPPENS THIS ASSOCIATE ARRAY IS UPDATED.*/
  $elementsArr = [
    "masterStatus"=>[
      "status"=>"noerrors",
      "type"=>"masterStatus"
    ],
      "name"=>[
        "errorMessage"=>"<span style='color: red; margin-left: 15px;'>Name cannot be blank and must be a standard name</span>",
      "errorOutput"=>"",
      "type"=>"text",
      "value"=>"Bruce Wayne",
          "regex"=>"name"
      ],
      "phone"=>[
          "errorMessage"=>"<span style='color: red; margin-left: 15px;'>Phone cannot be blank and must be a valid phone number</span>",
      "errorOutput"=>"",
      "type"=>"text",
          "value"=>"999.999.9999",
          "regex"=>"phone"
    ],
        "address"=>[
            "errorMessage"=>"<span style='color: red; margin-left: 15px;'>Address cannot be blank and must be in a number street format</span>",
        "errorOutput"=>"",
        "type"=>"text",
            "value"=>"1007 Mountain Drive",
            "regex"=>"address"
    ],
        "city"=>[
            "errorMessage"=>"<span style='color: red; margin-left: 15px;'>City cannot be blank and must be a valid city</span>",
        "errorOutput"=>"",
        "type"=>"text",
            "value"=>"Gotham City",
            "regex"=>"city"
    ],
        "email"=>[
            "errorMessage"=>"<span style='color: red; margin-left: 15px;'>Email Address cannot be blank and must be a valid email</span>",
        "errorOutput"=>"",
        "type"=>"text",
            "value"=>"batman@dc.com",
            "regex"=>"email"
    ],
        "date"=>[
            "errorMessage"=>"<span style='color: red; margin-left: 15px;'>Date cannot be blank and must in a mm/dd/yyyy or mm/dd/yy format</span>",
        "errorOutput"=>"",
        "type"=>"text",
            "value"=>"02/19/1963",
            "regex"=>"date"
    ],
    "state"=>[
    "type"=>"select",
    "options"=>["MI"=>"Michigan","OH"=>"Ohio","PA"=>"Pennslyvania","TX"=>"Texas","NY"=>"New York"],
        "selected"=>"ny",
        "regex"=>"name"
    ],
    "contact"=>[
      "type"=>"checkbox",
      "action"=>"notRequired",
      "status"=>["News Letter"=>"", "Email Updates"=>"", "Text Updates"=>""]
    ],
    "age"=>[
    "errorMessage"=>"<span style='color: red; margin-left: 15px;'>You must select at least one option</span>",
      "errorOutput"=>"",
      "action"=>"required",
      "type"=>"radio",
      "value"=>["10-18"=>"", "19-30"=>"", "30-50"=>"", "51+"=>"", "other"=>""]
    ]
  ];
  
  
  /*THIS FUNCTION CAN BE CALLED TO ADD DATA TO THE DATABASE */
  function addData(){
    global $elementsArr;  
    /* IF EVERYTHING WORKS ADD THE DATA HERE TO THE DATABASE HERE USING THE $_POST SUPER GLOBAL ARRAY */
        

        ////////////////////////////////////////////////////////////////////////////////
        
        require_once 'classes/Pdo_methods.php';
        $pdo = new PdoMethods();

        $contactPOST = "";

        if(!empty($_POST['contact'])) {
          foreach($_POST['contact'] as $contact) {
              $contactPOST .= $contact . ", "; 
          }
          $contactPOST = substr($contactPOST, 0, -2);
        }
        

        $sql = "INSERT INTO final (name, address, phone, email, dob, contact, age, city, state) VALUES (:name, :address, :phone, :email, :dob, :contact, :age, :city, :state)";
        $bindings = [
            [':name',$_POST['name'],'str'],
            [':address',$_POST['address'],'str'],
            [':phone',$_POST['phone'],'str'],
            [':email',$_POST['email'],'str'],
            [':dob',$_POST['date'],'str'],
            [':contact',$contactPOST,'str'],
            [':age',$_POST['age'],'str'],
            [':city',$_POST['city'],'str'],
            [':state',$_POST['state'],'str']
        
        ];

        $result = $pdo->otherBinded($sql, $bindings);

        if($result === 'error'){
            $result = 'There was an error adding to the DataBase';
        }
        else {
            $result = "Contact Information Added";
        }
        ///////////////////////////////////////////////////////////////////////////////
      
        /* ONCE THE DATA HAS BEEN ADDED THE RETURN STATEMENT WILL FIRE.  */
  
        return getForm($result, $elementsArr);
        //return getForm("Contact Information Added", $elementsArr);
  }
     
  
  /*THIS IS THEGET FROM FUCTION WHICH WILL BUILD THE FORM BASED UPON UPON THE (UNMODIFIED OF MODIFIED) ELEMENTS ARRAY. */
  function getForm($acknowledgement, $elementsArr){
  
  global $stickyForm;
  $options = $stickyForm->createOptions($elementsArr['state']);
  
  /* THIS IS A HEREDOC STRING WHICH CREATES THE FORM AND ADD THE APPROPRIATE VALUES AND ERROR MESSAGES */
  $form = <<<HTML
      <form method="post" action="index.php?page=form">
      <div class="form-group">
        <label for="name">Name (Letters Only){$elementsArr['name']['errorOutput']}</label>
        <input type="text" class="form-control" id="name" name="name" value="{$elementsArr['name']['value']}" >
      </div>
      <div class="form-group">
        <label for="address">Address (Number and Street){$elementsArr['address']['errorOutput']}</label>
        <input type="text" class="form-control" id="address" name="address" value="{$elementsArr['address']['value']}" >
      </div>
      <div class="form-group">
        <label for="city">City {$elementsArr['city']['errorOutput']}</label>
        <input type="text" class="form-control" id="city" name="city" value="{$elementsArr['city']['value']}" >
      </div>
      <div class="form-group">
        <label for="state">State</label>
        <select class="form-control" id="state" name="state">
          $options
        </select>
      </div>
      <div class="form-group">
        <label for="phone">Phone (Format: 999.999.9999) {$elementsArr['phone']['errorOutput']}</label>
        <input type="text" class="form-control" id="phone" name="phone" value="{$elementsArr['phone']['value']}" >
      </div>
      <div class="form-group">
        <label for="email">Email Address {$elementsArr['email']['errorOutput']}</label>
        <input type="text" class="form-control" id="email" name="email" value="{$elementsArr['email']['value']}" >
      </div>
      <div class="form-group">
        <label for="date">Date Of Birth (Format: mm/dd/yyyy ) {$elementsArr['date']['errorOutput']}</label>
        <input type="text" class="form-control" id="date" name="date" value="{$elementsArr['date']['value']}" >
      </div>
      
      
      <p>Please check all contact types you would like (optional):</p>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" name="contact[]" id="contact1" value="News Letter" {$elementsArr['contact']['status']['News Letter']}>
        <label class="form-check-label" for="contact1">News Letter</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" name="contact[]" id="contact2" value="Email Updates" {$elementsArr['contact']['status']['Email Updates']}>
        <label class="form-check-label" for="contact2">Email Updates</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" name="contact[]" id="contact3" value="Text Updates" {$elementsArr['contact']['status']['Text Updates']}>
        <label class="form-check-label" for="contact3">Text Updates</label>
      </div>
          
      <p>Please select an age range (you must select one):{$elementsArr['age']['errorOutput']}</p>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="age" id="age1" value="10-18"  {$elementsArr['age']['value']['10-18']}>
        <label class="form-check-label" for="age1">10-18</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="age" id="age2" value="19-30"  {$elementsArr['age']['value']['19-30']}>
        <label class="form-check-label" for="age2">19-30</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="age" id="age3" value="30-50"  {$elementsArr['age']['value']['30-50']}>
        <label class="form-check-label" for="age3">30-50</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="age" id="age4" value="51+"  {$elementsArr['age']['value']['51+']}>
        <label class="form-check-label" for="age4">51+</label>
      </div>
      <div>
      <button type="submit" name="submit" class="btn btn-primary">Submit</button>
      </div>
    </form>
  HTML;
  
  /* HERE I RETURN AN ARRAY THAT CONTAINS AN ACKNOWLEDGEMENT AND THE FORM.  THIS IS DISPLAYED ON THE INDEX PAGE. */
  return [$acknowledgement, $form];
  
  }
  
  
?>