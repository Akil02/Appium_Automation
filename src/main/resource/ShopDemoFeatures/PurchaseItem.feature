@Purcahse_Required_item
Feature: Customer can puchase there item from this app
  We can use to puirchase any item using this

  Background: Common for login in shopp app
  Given The user is in home page log out and go to the login page
  When User enters the log in page use the credentials and log in
  And After entering log in page skip all the shipping and try to go to purchase page
  
  #@Data_Cucumber
  #Scenario Outline: Purchase item using cucumber data driven
  #When the user is on the purchase page select <Product1> and <item2> and click on buy button
  #And User needs to enter his shipping details and click on Payment button
  #When Users enters the Payment page enter the card details <FullName> <Cardnumber> <EXPDater> <SecCode> and when the user enters the next page
  #Then take the screenshot of that page
  #
  #Examples:
  #| Product1                 | item2                       | FullName       | Cardnumber      | EXPDater | SecCode |
  #| Sauce Labs Fleece Jacket | Test.allTheThings() T-Shirt | Rebecca Winter | 325812657568789 | 03/25    |     123 |
  #
  
  @Data_Excel
  Scenario: Purchase item using excel data driven
    When the user is on the purchase page select the items and click on buy button
    And User needs to enter his shipping details and click on Payment button
    When Users enters the Payment page enter the card details and when the user enters the next page
    Then take the screenshot of that page
