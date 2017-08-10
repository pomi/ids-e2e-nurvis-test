@Nurvis
Feature: Testing different combinations of passengers

  Scenario Outline: create holiday package
    Given I, <name> <lastname>, want sms in <region>
    When I do sms
    Then I receive sms
  @NL
    Examples:
      | name   | lastname   | region |
      | maksym | omelchenko | nl     |
      | andrii | dvoinik    | nl     |
  @BE
    Examples:
      | name     | lastname   | region|
      | maksymio | omelchenko |be     |
      | andrew   | dvoinik    |be     |
