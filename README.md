# My Personal Project

## Workout Tracker

The workout tracker application will have four main functions:
- The first (and obvious) function will be to store the user's previous workouts, with the ability to customize each 
workout session
  - For example, the user would be able to customize how heavy they lifted, so they can track their progress
- The second function would be to give the user the ability to input their workouts
- The third function would be to suggest what type of workouts would be best for certain muscles groups/types of
exercises
  - For example, if the user wants to exercise their chest muscles, the application will recommend chest exercises (with 
  and without equipment)
  - Another example, if the user wants to do cardio, it will provide cardiovascular exercises (with and without
  equipment)
- The final feature would be to provide some everyday fun facts that promote a healthier lifestyle for the user

The project is for personal use, but could easily be used by others who either are just starting out their workout
journey or are already very experienced (essentially for everyone that wants to work out). This application would be
incredibly useful as it streamlines the process of working out and hence, reduces the friction of workout so that you 
don't give up on your New Year Resolutions as quick!

This project is interesting to me personally because I have been on my workout journey for almost 2 years now. So, this
application is directly correlated to one of my hobbies/interests. As well as, I have had a great experience with 
working out, specifically, I felt a massive confidence boost as well as just felt healthier as I progressed through my
journey. So, I believe that creating this project can help some beginners (or even people that want to start working
out) to get into the habit of working out more easily, so they can also experience what I have experienced.

Adapted JsonSerializationDemo's as a basis for this project's persistence module.

## User Stories
- As a user, I want to be able to add my workout session to the application's record
- As a user, I want to add multiple exercises to one workout session
- As a user, I want to be able to view the recorded workouts to track progress 
- As a user, I want to be able to mark how I felt after each workout session (out of a score of 5, with 1 being the
lowest)
- As a user, I want to be able to see my statistics over my entire workout journey
- As a user, I want to be able to save my workout history list to file (if I so choose)
- As a user, I want to be able to load my to-do list from file (if I so choose)

## Instructions for Grader
- You can generate the first required action related to adding Xs to a Y by...
  - Clicking on the "Add Workout Session" button, then filling in the input fields (correctly), then click the "DONE"
button, then fill in another set of input fields (correctly) and click the "ADD" button as many times as you'd like to
add an Exercise (X) to a Workout Session (Y).  
- You can generate the second required action related to adding Xs to a Y by...
  - Repeating the above process, expect this time, right after you finish filling in the first set of input fields (for
the workout session), simply click on the "Remove Exercise" tab at the top. This will lead you to a page where you
can click on the dropdown combo-box to select an exercise (from the current workout session, so you'd first need to
add an exercise) in which you can the click the "REMOVE" button in order to remove the selected exercise (X) from the
current Workout Session (Y).
- You can locate my visual component by...
  - Starting up the application, and you are able to change this visual component by clicking on the "Click Me" button
located close to the bottom left of the window.
- You can save the state of my application by...
  - Clicking on the "Save/Load" button, then you will be directed to a new page where you can click on the "SAVE" button
which will save your current data.
- You can reload the state of my application by...
  - Clicking on the "Save/Load" button, then you will be directed to a new page where you can click on the "LOAD" button
which will load your previously saved data to your current application.