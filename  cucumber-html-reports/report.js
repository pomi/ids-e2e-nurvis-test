$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Passengers.feature");
formatter.feature({
  "line": 2,
  "name": "Create booking for NL, BE markets and put it on OnTour sftp",
  "description": "",
  "id": "create-booking-for-nl,-be-markets-and-put-it-on-ontour-sftp",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Tosca"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Create package holiday",
  "description": "",
  "id": "create-booking-for-nl,-be-markets-and-put-it-on-ontour-sftp;create-package-holiday",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I request packages in SOLR from LGW to Spain with passengers",
  "rows": [
    {
      "cells": [
        "Room",
        "Adults",
        "Children",
        "Infants"
      ],
      "line": 6
    },
    {
      "cells": [
        "1",
        "2",
        "0",
        "0"
      ],
      "line": 7
    },
    {
      "cells": [
        "2",
        "2",
        "2",
        "1"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I check availability in Tosca",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "add extras",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "confirm package",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "booking is created",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "LGW",
      "offset": 32
    },
    {
      "val": "Spain",
      "offset": 39
    }
  ],
  "location": "CreateBookingForUKSteps.java:34"
});
formatter.result({
  "duration": 2858724841,
  "status": "passed"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:47"
});
formatter.result({
  "duration": 1570226255,
  "status": "passed"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:56"
});
formatter.result({
  "duration": 668723175258,
  "status": "passed"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:70"
});
formatter.result({
  "duration": 1508760,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat com.thomascook.ids.e2e.steps.CreateBookingForUKSteps.lambda$new$3(CreateBookingForUKSteps.java:72)\r\n\tat ✽.And confirm package(Passengers.feature:11)\r\n",
  "status": "pending"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:75"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 14,
  "name": "Send booking to WebRio and OnTour",
  "description": "",
  "id": "create-booking-for-nl,-be-markets-and-put-it-on-ontour-sftp;send-booking-to-webrio-and-ontour",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I have Tosca booking",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I create XML for Webrio",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "send it to WebRio",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "WebRio answered without errors",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:80"
});
formatter.result({
  "duration": 229533,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat com.thomascook.ids.e2e.steps.CreateBookingForUKSteps.lambda$new$5(CreateBookingForUKSteps.java:82)\r\n\tat ✽.Given I have Tosca booking(Passengers.feature:15)\r\n",
  "status": "pending"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:85"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:90"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:95"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 20,
  "name": "Put booking on OnTour sftp",
  "description": "",
  "id": "create-booking-for-nl,-be-markets-and-put-it-on-ontour-sftp;put-booking-on-ontour-sftp",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "I have Tosca booking",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I create OnTour xml",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "put it on OnTour sftp",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "OnTour processed XML without errors",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:80"
});
formatter.result({
  "duration": 187545,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat com.thomascook.ids.e2e.steps.CreateBookingForUKSteps.lambda$new$5(CreateBookingForUKSteps.java:82)\r\n\tat ✽.Given I have Tosca booking(Passengers.feature:21)\r\n",
  "status": "pending"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:100"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:105"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CreateBookingForUKSteps.java:110"
});
formatter.result({
  "status": "skipped"
});
});