Feature: Customers

Background: Repeated test case 
Given  Launch browser
When open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter Email as "admin@yourstore.com" and Password as "admin"
And click on login
Then User can view Dashboard
When User click on Customer Menu
And click on customer menu item

@AddCustomer @Sanity
Scenario: Add new Customer
And click on Add new button
Then User can view Add new customer page
When User enters customer info
And click on save button
Then User can view confirmation message "The new customer has been added successfully"
And close browser

@SearchCustomerEmail  @Regression  @Sanity
Scenario: Search customer by Email
And Enter email address with "brenda_lindgren@nopCommerce.com"
When click on the search button
Then User should found the email in the search bar
And close browser

@SearchCustomerName @Regression
Scenario: Search customer by Name
And the firstName and LastName 
When click on the search button
Then User should found the name in the search bar
And close browser

