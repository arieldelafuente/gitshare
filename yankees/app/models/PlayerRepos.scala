package models

import com.mongodb.casbah.Imports._

object PlayerRepos {
  def allPlayers: List[Player] = {
    val conn = MongoConnection()("yankees")("players")

    return conn.map(pt => new Player(
      pt.getAs[String]("_id"),
      pt.getAs[String]("playerId"),
      pt.getAs[String]("firstName"),
      pt.getAs[String]("lastName"),
      pt.getAs[String]("hometown"))).toList
  }
}