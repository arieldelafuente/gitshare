package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._

object Contacts extends Controller {
  val aContactForm: Form[Contact] = Form(
    mapping(
      "id" -> text,
      "firstName" -> text,
      "lastName" -> text,
      "emailAddy" -> text,
      "phoneNo" -> text,
      "personNotes" -> text)(Contact.apply)(Contact.unapply))

  def contactform(id: String) = Action {
    val cn = ContactRepos.getContact(id)
    val an = Map("id" -> cn.id,
    				"firstName" -> cn.firstName,
    				"lastName" -> cn.lastName,
    				"emailAddy" -> cn.emailAddy,
    				"phoneNo" -> cn.phoneNo,
    				"personNotes" -> cn.personNotes)
    Ok(views.html.contactform(aContactForm.bind(an)))
  }

  def contacttable = Action {
    Ok(views.html.contacttable(ContactRepos.allContacts))
  }

  def contactsubmit = Action {
    implicit request =>
      aContactForm.bindFromRequest.fold(
        haserrors => {
          Ok(views.html.contacttable(ContactRepos.findContacts("")))
        },
        contact => {
          Ok(views.html.contacttable(ContactRepos.findContacts("")))
        })
  }
}