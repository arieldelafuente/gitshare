package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._

object Application extends Controller {

  def index = Action {
    contacttable
  }

  val parmContactForm: Form[Contact] = Form(
    mapping(
      "id" -> text,
      "firstName" -> text,
      "lastName" -> text,
      "emailAddy" -> text,
      "phoneNo" -> text,
      "personNotes" -> text)(Contact.apply)(Contact.unapply))

  def contacttoformobj(cn: Contact): Form[Contact] = {
    val an = Map(
      "id" -> cn.id,
      "firstName" -> cn.firstName,
      "lastName" -> cn.lastName,
      "emailAddy" -> cn.emailAddy,
      "phoneNo" -> cn.phoneNo,
      "personNotes" -> cn.personNotes)
    return parmContactForm.bind(an)
  }

  def newcontactform = Action {
    Ok(views.html.newcontactform(parmContactForm))
  }

  def viewcontactform(id: String) = contactform(id, "VIEW")

  def delcontactform(id: String) = contactform(id, "DELETE")

  def contactform(id: String, crud: String) = Action {
    Ok(views.html.contactform(contacttoformobj(ContactRepos.getContact(id)), id, crud))
  }

  def contacttable = Action {
    Ok(views.html.contacttable(ContactRepos.allContacts))
  }

}