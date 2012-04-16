package models

import scala.collection.immutable.Map
import com.mongodb.casbah.Imports._

object ContactRepos {
  def allContacts: List[Contact] = {
    val conn = MongoConnection()
    var l: List[Contact] = Nil
    for (cn <- conn("learn")("contacts")) {
      l = new Contact(
        cn.get("_id").toString,
        cn.get("fname").toString,
        cn.get("lname").toString,
        cn.get("emal").toString,
        cn.get("fon").toString,
        cn.get("nota").toString) :: l
    }
    conn.close
    return l
  }

  def findContacts(searchKey: String): List[Contact] = {
    val conn = MongoConnection()
    val coll = conn("learn")("contacts")
    conn.close
    return Nil
  }
  
  def updateContact(c: Contact): Int = {
    val conn = MongoConnection()
    val coll = conn("learn")("contacts")
     
    val updcontact = MongoDBObject(
        "_id" -> new ObjectId(c.id.asInstanceOf[String]), 
        "fname" -> c.firstName,
        "lname" -> c.lastName,
        "emal" -> c.emailAddy,
        "fon" -> c.phoneNo,
        "nota" -> c.personNotes)
    coll.update(coll.findOne(MongoDBObject("_id" -> new ObjectId(c.id.asInstanceOf[String]))).head,updcontact)
    
    return 0
  }

  def insertContact(c: Contact): Int = {
    val conn = MongoConnection()
    val coll = conn("learn")("contacts")
     
    val inscontact = MongoDBObject(
        "fname" -> c.firstName,
        "lname" -> c.lastName,
        "emal" -> c.emailAddy,
        "fon" -> c.phoneNo,
        "nota" -> c.personNotes)
    coll.insert(inscontact)
        
    return 0
  }
  
  def deleteContact(id: String): Int = {
    val conn = MongoConnection()
    val coll = conn("learn")("contacts")
    
    coll.remove(MongoDBObject("_id" -> new ObjectId(id.asInstanceOf[String])))
    return 0
  }

  def mongoObjToString(obj: Option[Any]): String =
    obj match {
      case None => ""
      case Some(x) => x.toString
    }

  def getContact(id: String): Contact = {
    val conn = MongoConnection()
    val coll = conn("learn")("contacts")
    val objectId: ObjectId = new ObjectId(id.asInstanceOf[String])

    val results = coll.findOne(MongoDBObject("_id" -> objectId))
    val elem = results.head

    val rid = mongoObjToString(elem.getAs[ObjectId]("_id"))
    val fname = mongoObjToString(elem.getAs[String]("fname"))
    val lname = mongoObjToString(elem.getAs[String]("lname"))
    val emal = mongoObjToString(elem.getAs[String]("emal"))
    val fon = mongoObjToString(elem.getAs[String]("fon"))
    val nota = mongoObjToString(elem.getAs[String]("nota"))

    val cn = new Contact(rid, fname, lname, emal, fon, nota)

    return cn
  }
}