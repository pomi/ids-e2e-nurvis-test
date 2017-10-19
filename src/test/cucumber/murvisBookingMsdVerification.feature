@NL @Ignore
Feature: Nurvis booking for PMI destination should be available in msD
  As a user I want to see Nurvis bookings with PMI destination in msD

  Scenario: Order a booking in Nurvis and verify it in msD
    Given SOLR is requested for packages from AMS airport to PMI for 1 adults
