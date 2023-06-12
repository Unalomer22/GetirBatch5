Feature: Login Test


  Scenario: Getir Login Test
    Given User open the getir app and enters "hello@getir.com" and "hello"
    Then  User login successfully

  #Go to basket and verify that it is empty
  #go to items list and print all list and verify that size is 12
  #Go to second category and add two different items
  #Go back the home page
  #Go to basket again
  #Verify total amount

  @wip
  Scenario: Getir basket verification
    Given User open the getir app and enters "hello@getir.com" and "hello"
    Then  User login successfully
    And   User clicks basket button
    Then   User verify that basket is empty and able to see "There is no result"
    Then   User able to see all menu list in console and verify that size is 12
    And   User clicks second category which is "Atıştırmalık"
    And   User adds two different items
    And   User scroll down to "Ürün 14"
    And   User adds two different items
    And   User clicks basket button
    Then  User verify that "Total Amount : 84 ₺"




