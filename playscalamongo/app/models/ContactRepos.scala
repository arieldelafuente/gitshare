package models

import scala.collection.immutable.Map

object ContactRepos {
  def findContacts(searchKey: String): List[Contact] = {
    val aContact = new Contact("1","Martin", "Odersky", "scala@too.com", "555", "")
    val bContact = new Contact("2","Barack", "Obama", "mrprez@too.com", "444", "")
    val cContact = new Contact("3","John", "Smith", "john@too.com", "222", "")
    val dContact = new Contact("4","Tim", "Conway", "tim@too.com", "333", "")
    val eContact = new Contact("5","Frank", "Bach", "frank@too.com", "111", "")
    val fContact = new Contact("6","Cel", "Dela Fuente", "cel@too.com", "777", "")

    return List(aContact, bContact, cContact, dContact, eContact, fContact)
  }

  def insertContact(c: Contact): Int = {
    return 0
  }

  def deleteContact: Int = {
    return 0
  }

  def getContact(id: String): Contact = {
    return new Contact("6","Cel", "Dela Fuente", "cel@too.com", "777", "")
  }

  /*
  import com.mongodb.casbah.Imports._
   
  def insertContact: Int = {
    val conn = MongoConnection()
    val coll = conn("learn")("contacts")
    
    val newCont = MongoDBObject("fname" -> firstName,
    					"lname" -> lastName,
    					"emal" -> emailAddy,
    					"fon" -> phoneNo,
    					"nota" -> personNotes)
    	coll.save(newCont)
    	return 0
  }

  */

}