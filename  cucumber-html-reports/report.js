$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.feature");
formatter.feature({
  "line": 2,
  "name": "Test",
  "description": "",
  "id": "test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Test"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Test1",
  "description": "",
  "id": "test;test1",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "fff",
  "keyword": "Given "
});
formatter.match({
  "location": "fff.java:18"
});
formatter.result({
  "duration": 118447187,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Test2",
  "description": "",
  "id": "test;test2",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "ggg",
  "keyword": "Given "
});
formatter.match({
  "location": "ggg.java:18"
});
formatter.result({
  "duration": 150845,
  "status": "passed"
});
});