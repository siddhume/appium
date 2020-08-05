#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Check Mobile App
  


    
    
  #Scenario: verify OS
  #And I tap the OS button
  #Then verify that there are 4 elements on the page
  
  
  
   Scenario Outline: verify OS
  And I tap the OS button
  Then Verfiy that the <num> element name is "<elementName>"
  
  Examples:
  	|num|elementName|
  	|1|Morse Code|
  	|2|Rotation Vector|
  	|3|Sensors|
  	|4|SMS Messaging|
  
  
  
  
    
    
    
    
    

	