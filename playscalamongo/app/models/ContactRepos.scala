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

  def insertContact(c: Contact): Int = {
    return 0
  }

  def deleteContact: Int = {
    return 0
  }

  def getContact(id: String): Contact = {

    //val oid = id.asInstanceOf[Option[String]]
    val conn = MongoConnection()
    val coll = conn("learn")("contacts")
    val objectId: ObjectId = new ObjectId(id.asInstanceOf[String])

    val results = coll.findOne(MongoDBObject("_id" -> objectId))
    val elem = results.head

    val rid = elem.getAs[ObjectId]("_id") match { case Some(x) => x.toString }
    val fname = elem.getAs[String]("fname") match { case Some(x) => x.toString }
    val lname = elem.getAs[String]("lname") match { case Some(x) => x.toString }
    val emal = elem.getAs[String]("emal") match { case Some(x) => x.toString }
    val fon = elem.getAs[String]("fon") match { case Some(x) => x.toString }
    val nota = elem.getAs[String]("nota") match { case Some(x) => x.toString }

    val cn = new Contact(rid, fname, lname, emal, fon, nota)

    return cn
  }

}