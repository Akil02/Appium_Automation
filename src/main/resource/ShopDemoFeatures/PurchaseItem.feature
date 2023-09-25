#@Purcahse_Required_item
Feature: Customer can puchase there item from this app
  We can use to puirchase any item using this 

#@Backgrouund
    #Given The user is in home page log out and go to the login page
    #When User enters the log in page use the credentials and log in 
    #And After entering log in page skip all the shipping and try to go to purchase page
    
 # @Data_Cucumber
  Scenario Outline: Purchase item using cucumber data driven 
  Given The user is in home page log out and go to the login page
    When User enters the log in page use the credentials and log in 
    And After entering log in page skip all the shipping and try to go to purchase page  
    When the user is on the purchase page select <item1> and <item2> and click on buy button
    And User needs to enter his shipping details and click on Payment button
    When Users enters the Payment page enter the card details <FullName> <Cardnumber> <EXPDater> <SecCode>and when the user enters the next page
    Then take the screenshot of that page
    
    Examples:
      |item1                   |item2                       |FullName       |Cardnumber         |EXPDater |SecCode |
      |Sauce Labs Fleece Jacket|Test.allTheThings() T-Shirt |Rebecca Winter |3258 1265 7568 789 |03/25    |123     |

  @Data_Excel
  Scenario: Purchase item using excel data driven
    When the user is on the purchase page select the items and click on buy button
    And User needs to enter his shipping details and click on Payment button
    When Users enters the Payment page enter the card details and when the user enters the next page
    Then take the screenshot of that page
