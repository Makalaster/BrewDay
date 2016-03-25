README

 BrewDay is an app designed to be used as a toolkit for a beer home brewer. The app can be installed through Android Studio by opening and running the project either on a virtual or physical Android device.

 The landing page for the app is a checklist of items that need to be cleaned and sanitized with a spinner at the top to select other pages. Choosing one or both of the checkboxes at the top of the app then clicking the APPLY button will activate a pre-set group of checkboxes in the main body of this page. Clicking the RESET button at the bottom will reset this page back to the default state.

 Clicking the spinner at the top of the page will allow the user to choose another step of the brewing process. It is recommended to go down the list in order, but the steps can be viewed in whatever order is needed.

 The second page in the app is the mashing step. This contains a table of values based on how many pounds of grain the brewer is using, from common values 6 to 10. The table relates how many pounds of grain were used to volumes of water that will be needed at various points in the mashing step.

 The third page is a set of tools for use during the boil step. The user can enter the total boil time and number of hop additions in the first two EditText lines, then press the SET button to assign the initial values. If either line is left blank a toast will appear to remind the user to enter valid values for both lines. The third EditText asks for the time in minutes until the next hop addition. Clicking the START TIMER button will subtract one hop addition from the hop addition counter at the bottom, as well as subtract the entered minutes from the total time remaining. Additionally, a timer is started using Android’s built in timer functions. If the time to next hop addition EditText is left blank a toast is shown to remind the user to enter a value.

 Page four of the app has two tools for use in the fermentation step. First is a large reminder to sanitize the user’s equipment. Next is an EditText that takes the number of days the beer will ferment. Clicking the ADD TO CALENDAR button will send an intent to the calendar to create an event the number of days from the current day to remind the user that fermentation has completed. Last is another EditText that accepts a value for the original gravity of the beer prior to fermentation, for example 1.060. This sets a global variable that will be used in the final page of the app, packaging. Clicking the ENTER button will display a toast with the entered value. If either button is pressed without a value having been entered a toast will be shown reminding the user to enter a valid value.

 The last page of the app pertains to the packaging step, which can include bottling or kegging. At the top of the page is a reminder to sanitize the user’s equipment. Below that is a short list of steps to take to bottle the finished beer. Then is an EditText which takes a value for the beer’s final gravity after fermentation has completed, for example 1.020. Entering a value and clicking ENTER will update the FG and estimated ABV (alcohol by volume) text views appropriately. At the bottom of the page is a picture of a bottled home brewed beer and a glass from which to drink it.

AUTHOR

Sam Perlow