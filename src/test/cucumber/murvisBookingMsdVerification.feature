@FullCheck
@NL
Feature: Nurvis booking for PMI destination should be available in msD
  As a user I want to see Nurvis bookings with PMI destination in msD

  Scenario: Order a booking in Nurvis and verify it in msD
    Given SOLR is requested for packages from AMS airport to PMI for 1 adults
    And SOLR response has available packages
    When NURVIS is requested for booking
    And NURVIS returns booking ID
    Then I should see a booking with same number exists in msD
    And booking in msD should have same details as were set in Nurvis
