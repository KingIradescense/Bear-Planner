Hello. This repository is my contribution to my Programming Language Concepts term project during the
fall of 2023. I worked on the backend implementation, and another group member worked on the
frontend implementation and UI/UX design. 

There are two folders in this repository for each version of the backend. Originally I chose to design
the structure of the backend in Java as it is the language which my college uses for courses and is
what I'm most familiar with. I later re-created the program in JavaScript when we chose to use the
React Native environment. The conversion presented some issues, such as JavaScript not supporting
polymorphism, but was feasible.

The backend implementation originally had a placeholder for the main method but later versions 
(including this version, which is what was attached to the final report submission) don't include it as
we decided to leave its implementation to the frontend. 

Bear Planner is meant to be a planner and to do list app which prioritizes the mental health of users, 
and is targeted at students. It does this by discouraging the user from burning themselves out, to take
breaks, drink water, etc., and the variety of the advice/popups/notifications depends on a mental health
score which the app determines with daily check-ins. If given more time, we wanted to implement a
feature where you could synchronize calendars with other users, such as the scenario where a group of people
are working on a project together. We wanted to use this feature to allow users to hold each other
accountable to rest and breaks as well, or to make them able to check in on each other's wellbeing. 

The Account object contains user information and all instances of the other objects. If given the chance
to develop the app further, we would choose to store Account objects in a simple data structure, but for
the purposes of the project submission and presentation, it wasn't needed. It stores Planner objects in a 
jagged 3D array to represent a calendar for the purposes of the project- this would also have been
changed if we pursued the project further, but for the presentation, this was sufficient-, ToDoList objects 
in an ArrayList as they do not need to be sorted by date, and integers from the daily mental health check
in order to keep a "mental health score" for the user. It uses an array to represent settings where
each position is a setting and the integer referenced correlates to an option.

The Date object is an interface implemented by ToDoList and Planner objects, though it was later
made negligible for the Planner object due to the Account object's use of a 3D jagged array to hard-code
a calendar structure. The Planner class further extends the ToDoList class. The ToDoList holds the name,
date, description, and completion status of a task, and if given the time to further implement the project,
would use the completion status to determine whether or not a ToDoList object is due to be removed
from the Account's ArrayList. The Planner class contains these and further includes the start and end
time of the represented event, whether or not its repeating, and the details about the repeating
event if true. 

In converting the program to JavaScript, the Date interface was considered negligible and excluded
due to how JavaScript handles types at runtime.

The app does not fully function due to issues with learning the React Native environment and connecting
the work done for the backend to the work done for the frontend. It was more important for the project
to represent an understanding of course material and programming practice, as this was for our
Programming Language Concepts course.
