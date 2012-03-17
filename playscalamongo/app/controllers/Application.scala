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
      "phoneNos" -> text,
      "personNotes" -> text)(Contact.apply)(Contact.unapply))

  def contactform = Action {
    Ok(views.html.contactshowform(aContactForm))
  }

  def sayHello = Action {
    println("HELLO HELLO HELLO")
    println("HELLO HELLO HELLO")
    
    val c = new Contact("Greg","DelPilar","greg@tirad.com","555-111-2222","Little Gen111")
    c.insertContact
    
    Ok(views.html.contactshowform(aContactForm))

  }

  def contactsubmit = Action {
    implicit request =>
      aContactForm.bindFromRequest.fold(
        haserrors => {
          println("we have errors")
          Ok(views.html.showmeerrors(haserrors))
        },
        contact => {
          savingtodatabase(contact)
          Ok(views.html.contactsaveresults(contact))
        })
  }

  def savingtodatabase(c: Contact) {
    println("Saving these to the database...")
    println(c.firstName)
    println(c.lastName)
    println(c.emailAddy)
    println(c.phoneNo)
    println(c.personNotes)
  }

}