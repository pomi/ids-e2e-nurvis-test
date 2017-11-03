@NL
Feature: Create Booking

  Scenario: Create booking
    Given SOLR is requested for packages from AMS airport to Spanje for 2 adults
    And SOLR response has available packages
    When NURVIS is requested for booking
    Then NURVIS returns booking ID

  Scenario:
    Given Nurvis booking
    When ontour xml is created
    And ontour xml is put on sftp
    Then booking is processed
