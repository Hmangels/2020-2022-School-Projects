<?php
function displayTable(){
require_once './classes/Pdo_methods.php';

$sql = "SELECT * FROM final";

$pdo = new PdoMethods();
$output="";
if(isset($_POST['delete'])){
    $output = deleteNames($_POST);
  }


$records = $pdo->selectNotBinded($sql);
if($records === 'error'){
    return ["Error: Unable to display table",""];
}




$table = "<form method='post' action='index.php?page=display'>";
$table .= "<input class='btn btn-danger' type='submit' name='delete' value='Delete'>";
$table .= '<style>
table, th, td {
  border: 1px solid black;
}

th, td {
  padding: 10px;
}
</style>';
$table .=  "<table>
<tr>
<th>Name</th>
<th>Address</th>
<th>Phone</th>
<th>Email</th>
<th>DOB</th>
<th>Contact</th>
<th>Age</th>
<th>City</th>
<th>State</th>
<th>DELETE</th>

</tr>";





foreach ($records as $row)
{
$table .= "<tr>";
$table .=  "<td>" . $row['name'] . "</td>";
$table .=  "<td>" . $row['address'] . "</td>";
$table .=  "<td>" . $row['phone'] . "</td>";
$table .=  "<td>" . $row['email'] . "</td>";
$table .=  "<td>" . $row['dob'] . "</td>";
$table .=  "<td>" . $row['contact'] . "</td>";
$table .=  "<td>" . $row['age'] . "</td>";
$table .=  "<td>" . $row['city'] . "</td>";
$table .=  "<td>" . $row['state'] . "</td>";
$table .=  "<td>" . "<input type='checkbox' name='inputDeleteChk[]' value='{$row['id']}'></td>";
$table .=  "</tr>";
}
$table .=  "</table></form>";


return [$output,$table];
}

function deleteNames($post){
    $error = false;
    if(isset($post['inputDeleteChk'])){
        foreach($post['inputDeleteChk'] as $id){
            $pdo = new PdoMethods();

            $sql = "DELETE FROM final WHERE id=:id";
            
            $bindings = [
                [':id', $id, 'int'],
            ];


            $result = $pdo->otherBinded($sql, $bindings);

            if($result === 'error'){
                $error = true;
                break;
            }
        }
        if($error){
            return "There was an error in deleting a name or names";
        }
        else {
            return "Selected names deleted";
        }

    }
    else {
        return "No names selected to delete";
    }

}

?>