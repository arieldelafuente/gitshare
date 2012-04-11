package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._

object Contacts extends Controller {

  def save(contactId: String) = Action {
    println("Contacts.save: " + contactId)
    Application.index
  }
}