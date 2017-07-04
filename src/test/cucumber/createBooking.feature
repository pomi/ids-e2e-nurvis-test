Feature: Create Booking

  Scenario: Create booking
    Given I have a list of packages from SOLR and want to book one of them in Nurvis
    When I request SOLR for existing packages
    And make price request to nurvis NL endpoint
    And request extras to package
    Then booking created

  Scenario:
    Given SOLR is requested for packages for NL market for 2 adults for Mallorca destination
    And response has available packages
    When
    Then
