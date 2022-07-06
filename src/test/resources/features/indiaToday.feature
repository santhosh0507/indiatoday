Feature: this test is to verify the sportstack web application
 
  
  Scenario Outline: selecting the language from home page
    Given select this language <language>
    Examples: 
      | language  | 
      | english 	|


  Scenario: Click on each thumbnail and verify that links are not broken on homepage. 
    Given from home page scroll to bottom
    Then verify the broken images
     

 	Scenario: Click on the menu and change the theme. 
 	Given click on left hamburger menu
 	Then change the theme and verify the header colour
 
  	
 	Scenario:  Click on any Web Stories displayed 
 	Given Navigate to webstory section
 	Then click on any webstory from the page
 	
 	 
 	Scenario: Capture the text on each Web Stories and each page of webstories. 
 	Given Navigate to webstory section
 	Then capture the text on each web stories
 	
 	
 	Scenario: click on the next webstory and return to the homepage.
 	Given Navigate to webstory section
 	When click on any webstory from the page
 	Then Click on the home section
 	
 