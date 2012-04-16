package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._

object Contacts extends Controller {

  val contactForm: Form[Contact] = Form(
    mapping(
      "id" -> text,
      "firstName" -> text,
      "lastName" -> text,
      "emailAddy" -> text,
      "phoneNo" -> text,
      "personNotes" -> text)(Contact.apply)(Contact.unapply))
      
  def submit = Action { implicit request => 
    contactForm.bindFromRequest.fold(
        formWithErrors => {println("formWithErrors:" + formWithErrors)
          BadRequest},
        contact => {
          ContactRepos.updateContact(contact)
          Ok(views.html.contacttable(ContactRepos.allContacts))
        })
  }

  def delete(id: String) = Action { implicit request => 
    ContactRepos.deleteContact(id)
    Ok(views.html.contacttable(ContactRepos.allContacts))
  }  
  

  def seldelete = Action { implicit request => 
    request.body.asFormUrlEncoded match {
      case Some(m1) => for ((id,on) <- m1) ContactRepos.deleteContact(id)
      case _ => 
    }
    Ok(views.html.contacttable(ContactRepos.allContacts)) 
  }

  
  def insert = Action { implicit request => 
    contactForm.bindFromRequest.fold(
        formWithErrors => {println("formWithErrors:" + formWithErrors)
          BadRequest},
        contact => {
          ContactRepos.insertContact(contact)
          Ok(views.html.contacttable(ContactRepos.allContacts))
        })    
  }  
   
}
