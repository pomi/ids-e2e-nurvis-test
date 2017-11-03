@FullCheck
@NL
Feature: Nurvis booking for given destination should be available in msD
  As a user I want to see Nurvis bookings with PMI destination in msD

  Scenario: Order a booking in Nurvis and verify it in msD
    Given SOLR is requested for packages from AMS airport to Egypte for 1 adults
      | Room | Adults | Children | Infants |
      | 1    | 2      | 0        | 0       |
      | 2    | 2      | 2        | 1       |
#    Given SOLR is requested for packages from AMS airport to Spanje for 1 adults
#    Given SOLR is requested for packages from AMS airport to Mexico for 1 adults
#    Given SOLR is requested for packages from AMS airport to Portugal for 1 adults
#    Given SOLR is requested for packages from AMS airport to Malta for 1 adults
#    Given SOLR is requested for packages from AMS airport to Marokko for 1 adults
#    Given SOLR is requested for packages from AMS airport to Brazilië for 1 adults
#    Given SOLR is requested for packages from AMS airport to Chili for 1 adults
    And SOLR response has available packages
    When NURVIS is requested for booking
    And NURVIS returns booking ID
    And Nurvis booking
    And ontour xml is created
    And ontour xml is put on sftp
    And booking is processed
    Then I should see a booking with same number exists in msD
    And booking in msD should have same details as were set in onTour XML
