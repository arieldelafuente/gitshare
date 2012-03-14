package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._

object Application extends Controller {

  def index = Action {
    contactform()
  }

  val aContactForm: Form[Contact] = Form(
    mapping(
      "firstName" -> text,
      "lastName" -> text,
      "emailAddy" -> text,
      "personNotes" -> text)(Contact.apply)(Contact.unapply))

  def contactform = Action {
    Ok(views.html.contactform(aContactForm))
  }

  def savecontact = Action {
    implicit request =>
      aContactForm.bindFromRequest.fold(
        haserrors => {
          println("we have errors")
          Ok(views.html.showmeerrors(haserrors))
        },
        contact => {
          dbcrunchingtime(contact)
          Ok(views.html.contactsave(contact))
        })
  }

  def dbcrunchingtime(c: Contact) {
    println(c.firstName)
    println(c.lastName)
    println(c.emailAddy)
    println(c.personNotes)
  }

}