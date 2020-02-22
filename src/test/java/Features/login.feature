Feature: Login

@Sanity
Scenario: Successful login with valid Credential
Given  Launch browser
When open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter Email as "admin@yourstore.com" and Password as "admin"
And click on login
Then Page tittle should be "Dashboard / nopCommerce administration"
When User click on logout link
Then Page tittle should be "Your store. Login"
And close browser



Scenario Outline: Successful login with valid Credential
Given  Launch browser
When open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter Email as "<Email>" and Password as "<password>"

And click on login
Then Page tittle should be "Dashboard / nopCommerce administration"
When User click on logout link
Then Page tittle should be "Your store. Login"
And close browser

Examples:
|Email                 |password|
|admin123@yourstore.com|admin123|
|admin@yourstore.com   |admin   |
