package models

import com.mongodb.casbah.Imports._

case class Contact(
    firstName: String, 
    lastName: String, 
    emailAddy: String, 
    phoneNo: String, 
    personNotes: String) {
  
  def insertContact: Int = {
    val conn = MongoConnection()
    val learndb = conn("learn")
    val coll = conn("learn")("contacts")
    
    val newCont = MongoDBObject("fname" -> firstName,
    					"lname" -> lastName,
    					"emal" -> emailAddy,
    					"fon" -> phoneNo,
    					"nota" -> personNotes)
    	coll.save(newCont)
    	return 0
  }
  
}