$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("createBooking.feature");
formatter.feature({
  "line": 1,
  "name": "Create Booking",
  "description": "",
  "id": "create-booking",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Create booking",
  "description": "",
  "id": "create-booking;create-booking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have a list of packages from SOLR and want to book one of them in Nurvis",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I request SOLR for existing packages",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "make price request to nurvis NL endpoint",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "request extras to package",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "booking created",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.java:31"
});
