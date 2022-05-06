package com.ebookfrenzy.contactsproject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var contactId: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null
    var quantity: Int = 0
    constructor() {}
    constructor(id: Int, contactname: String, quantity: Int) {
        this.contactName = contactname
        this.quantity = quantity
    }
    constructor(contactname: String, quantity: Int) {
        this.contactName = contactname
        this.quantity = quantity
    }
}