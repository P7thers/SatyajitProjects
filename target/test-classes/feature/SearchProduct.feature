Feature: Search and place the order for Product



Scenario Outline: Search Experience for product search in both home and offer page


Given User is on GreenCart Landing Page
When User searched with shortname <Name> and extracted actual name of product  
Then User searched for <Name> shortname in offers page 
And Validate product name in offers page matches with Landing Page

Examples:
|Name|
|Tom |
|Beet|

