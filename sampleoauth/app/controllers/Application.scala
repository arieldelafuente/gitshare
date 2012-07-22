package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.Play._
import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Testing Google Authentication: Index", GoogleOAuth.getgoogauthurl))
  }

  def auth = Action {
    implicit request =>
      println("--------------")

      val authcode = GoogleOAuth.getauthcode(request)

      val googletoken = authcode match {
        case Some(a) => Some(GoogleOAuth.gettoken(a))
        case _ => None
      }

      if (googletoken.isDefined) {

        println("email: " + GoogleOAuth.getuserinfo(googletoken, "email"))
        println("name: " + GoogleOAuth.getuserinfo(googletoken, "name"))
        println("given_name: " + GoogleOAuth.getuserinfo(googletoken, "given_name"))
        println("family_name: " + GoogleOAuth.getuserinfo(googletoken, "family_name"))
      } else {
        println("Access denied")
      }

      Ok(views.html.results("Testing Google Authentication: Result"))
  }

}