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
  "name": "SOLR is requested for packages from AMS airport to Spanje for 2 adults",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "SOLR response has available packages",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "NURVIS is requested for booking",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "NURVIS returns booking ID",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "AMS",
      "offset": 36
    },
    {
      "val": "Spanje",
      "offset": 51
    },
    {
      "val": "2",
      "offset": 62
    }
  ],
  "location": "Steps.java:21"
});
formatter.result({
  "duration": 858530378036,
  "status": "passed"
});
formatter.match({
  "location": "Steps.java:34"
});
formatter.result({
  "duration": 82109,
  "status": "passed"
});
formatter.match({
  "location": "Steps.java:39"
});
formatter.result({
  "duration": 34524,
  "status": "passed"
});
formatter.match({
  "location": "Steps.java:45"
});
formatter.result({
  "duration": 40122,
  "status": "passed"
});
});