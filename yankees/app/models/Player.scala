package models

case class Player (
  Id: Option[String],
  playerNumber: Option[String],
  firstName: Option[String],
  lastName: Option[String],
  hometown: Option[String]){
  
  def getMongoObjectId = Id.get
  def getPlayerName = (firstName.getOrElse("") + " " + lastName.getOrElse("")).trim
  def getAddress = hometown.getOrElse("Not available")
  def getPlayerNumber = playerNumber.getOrElse("unknown") 
  
}