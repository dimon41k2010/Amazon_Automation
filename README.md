# Amazon_Automation
Automation of the scenario on Amazon native app. 

Here are the following steps of the test case:
1. Launch Amazon app on mobile device (iOS).
2. On the HomePage, assert the search bar and search for “airpods.” 
  2.1 Read the drop-down suggestions and select “airpods” in Cell Phones & accessories.
3. Once you get onto SearchResultsPage, turn on the Prime filter. 
  3.1 Verify that only “Prime” eligible items are displayed in the search results. 
4. Traverse through the results list and get the price details of the item which is Amazon’s choice “Apple airpods by Apple.” 
5. Tap on the same item and proceed to the ItemPage.
6. Assert the price displayed on the ItemPage with the price on SearchResultsPage.
7. Click on Buy now and Assert the item is added on the CheckOutPage.
