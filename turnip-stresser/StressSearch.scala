/**
 * Copyright 2011-2018 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package turnip.stress

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class StressSearch extends Simulation {

  val terms = Array(
    "bed",
    "before",
    "begin",
    "behavior",
    "behind",
    "believe",
    "benefit",
    "best",
    "better",
    "between",
    "beyond",
    "big",
    "bill",
    "billion",
    "bit",
    "black",
    "blood",
    "blue",
    "board",
    "chair",
    "challenge",
    "chance",
    "change",
    "character",
    "charge",
    "check",
    "child",
    "choice",
    "choose",
    "church",
    "citizen",
    "city",
    "civil",
    "claim",
    "class",
    "clear",
    "clearly",
    "close",
    "coach",
    "cold",
    "collection",
    "college",
    "color",
    "come",
    "commercial",
    "common",
    "community",
    "go",
    "goal",
    "good",
    "government",
    "great",
    "green",
    "ground",
    "group",
    "grow",
    "growth",
    "guess",
    "gun",
    "guy",
    "hair",
    "half",
    "hand",
    "hang",
    "happen",
    "happy",
    "hard",
    "have",
    "he",
    "head",
    "health",
    "hear",
    "heart",
    "heat",
    "heavy",
    "help",
    "her",
    "here",
    "herself",
    "high",
    "him",
    "himself",
    "his",
    "maintain",
    "major",
    "majority",
    "make",
    "man",
    "manage",
    "management",
    "manager",
    "many",
    "market",
    "marriage",
    "material",
    "matter",
    "may",
    "maybe",
    "me",
    "mean",
    "measure",
    "media",
    "medical",
    "meet",
    "meeting",
    "member",
    "memory",
    "mention",
    "message",
    "method",
    "middle",
    "might",
    "military",
    "million",
    "mind",
    "minute",
    "miss",
    "mission",
    "model",
    "modern",
    "moment",
    "money",
    "month",
    "more",
    "morning",
    "most",
    "mother",
    "mouth",
    "move",
    "movement",
    "movie",
    "Mr",
    "Mrs",
    "much",
    "music",
    "must",
    "my",
    "myself",
    "name",
    "nation",
    "national",
    "natural",
    "nature",
    "near",
    "nearly",
    "necessary",
    "need",
    "network",
    "never",
    "new",
    "news",
    "newspaper",
    "next",
    "nice",
    "night",
    "no",
    "none",
    "nor",
    "north",
    "not",
    "note",
    "nothing",
    "notice",
    "now",
    "number",
    "occur",
    "of",
    "off",
    "offer",
    "office",
    "officer",
    "official",
    "often",
    "oh",
    "oil",
    "ok",
    "old",
    "on",
    "once",
    "one",
    "only",
    "onto",
    "open",
    "operation",
    "opportunity",
    "option",
    "or",
    "order",
    "organization",
    "other",
    "others",
    "our",
    "out",
    "outside",
    "over",
    "own",
    "owner",
    "page",
    "pain",
    "painting",
    "paper",
    "parent",
    "part",
    "participant",
    "particular",
    "particularly",
    "partner",
    "party",
    "pass",
    "past",
    "patient",
    "pattern",
    "pay",
    "peace",
    "people",
    "per",
    "perform",
    "performance",
    "perhaps",
    "period",
    "person",
    "persona",
    "phone",
    "physical",
    "pick",
    "picture",
    "piece",
    "place",
    "plan",
    "plant",
    "play",
    "player",
    "PM",
    "point",
    "project",
    "property",
    "protect",
    "prove",
    "provide",
    "public",
    "pull",
    "purpose",
    "push",
    "put",
    "quality",
    "size",
    "skill",
    "skin",
    "small",
    "smile",
    "so",
    "social",
    "society",
    "soldier",
    "some",
    "somebody",
    "someone",
    "something",
    "sometimes",
    "son",
    "song",
    "soon",
    "surface",
    "system",
    "table",
    "take",
    "talk",
    "task",
    "tax",
    "teach",
    "teacher"
  )

  val httpConf = http
    .baseURL("http://localhost:3000")

  val scn = scenario("Search")
    .exec(http("request_1")
      .get(_ => "/search?q=" + terms(scala.util.Random.nextInt(terms.size))))

  setUp(scn.inject(rampUsers(6000) over (20 seconds)).protocols(httpConf))
}








