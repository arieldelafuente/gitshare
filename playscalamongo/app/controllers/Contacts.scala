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
    Ok(views.html.contactform(ContactRepos.getContact(id), aContactForm))
  }

  def contacttable = Action {
    Ok(views.html.contacttable(ContactRepos.findContacts("")))
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