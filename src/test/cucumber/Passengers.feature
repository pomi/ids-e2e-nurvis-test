@Tosca
Feature: Create booking for UK market and put it on OnTour sftp

  Scenario: Create package holiday
    Given I request packages in SOLR from LGW to Spain with passengers
      | Room | Adults | Children | Infants |
      | 1    | 2      | 0        | 0       |
      | 2    | 2      | 2        | 1       |
    When I check availability in Tosca, and add extras, and check costs, and confirm package
    Then booking is created

  Scenario: Send booking to WebRio and OnTour
    Given I have Tosca booking
    When I create XML for Webrio
    And send it to WebRio
    Then WebRio answered without errors

  Scenario: Put booking on OnTour sftp
    Given I have Tosca booking
    When I create OnTour xml
    And put it on OnTour sftp
    Then OnTour processed XML without errors
#  Scenario Outline: create holiday package
#    Given I, <name> <lastname>, want sms in <region>
#    When I do sms
#    Then I receive sms
#  @NL
#    Examples:
#      | name   | lastname   | region |
#      | maksym | omelchenko | nl     |
#      | andrii | dvoinik    | nl     |
#  @BE
#    Examples:
#      | name     | lastname   | region|
#      | maksymio | omelchenko |be     |
#      | andrew   | dvoinik    |be     |
