# Week 1
- M: 1.5
- T: 0
- W: 2
- T: 0
- F: 0
- S: 2
- S: 3
- Total: 8.5

Set up environment, completed activities. Came up with an idea for
the independent project (NPC Creator).
# Week 2
- M: 0
- T: 1
- W: 2
- T: 2
- F: 2.25
- S: 1.5
- S: 1.5
- Total: 10.25

I spent most of my time this week working on the Week-2 activity and watching the videos. I did continue
to refine my project idea. The Problem Statement was posted to Slack. I wrote some user stories for the 
project. I defined what qualities I want the program to generate for a base NPC template. I started thinking
about what screens the application will have.
# Week 3
- M: 0.75
- T: 0
- W: 2
- T: 1.5
- F: 2
- S: 1.5
- S: 0.5
- Total: 8.25

This week, for the project I worked on getting everything set for checkpoint 1. I already had done most of the work
for the user stories and the problem statement, so mostly this consisted of polishing things up, drawing out 
screen designs, and writing out a project plan timeline.
Otherwise, I worked on the advent of code puzzle with JUnit and Log4J. I really like Log4J, I can tell it is 
going to be incredibly useful. I am still getting used to JUnit.

# Week 4
- M: 1
- T: 0
- W: 1
- T: 0
- F: 0.5
- S: 4.25
- S: 1.5
- Total: 8.25

This week I began to create the various entity classes that the application will require in preparation for creating a 
draft of my database and a test database. I meant to also create the development and test databases, but it looks like
that will likely be pushed to next week.

# Week 5
- M: 0
- T: 0
- W: 0
- T: 1.5
- F: 1
- S: 4.5
- S: 2
- Total: 9

This week I built out the test database and added (I think) all of the tables that needed to be created. I also built 
the InteractionTraitsDao and wrote tests for it. In the upcoming weeks, I need to convert it to a Generic Dao and 
implement tests for all of the Entity classes. I also still need to add the Hibernate annotations to all of my Entity
classes. Additionally, I need to start building out the controller classes and the jsps.

# Week 6
- M: 0
- T: 0
- W: 0.5
- T: 1.5
- F: 2.5
- S: 6
- S: 1.5
- Total: 12

This week was a "one step forward, two steps backwards" kind of week. On the bright side, it really reinforced the
importance of test driven development. I wrote all of the entity classes and tried to set up Hibernate many to one 
relationships, and only then started trying to test things. Unfortunately, I couldn't figure out what was broken, so
I made a new branch and started rebuilding piece by piece, this time testing after every class to make sure that everything 
is working as expected. All in all, a good learning experience, if a bit frustrating in the moment. Next week, I definitely
need to get all of the Entity classes and Hibernate set up so I can start working on the controllers and jsps.
# Week 7
- M: 0
- T: 0
- W: 2.5
- T:
- F: 0.5
- S: 4.5
- S:
- Total: 7.5

This week I got all of the database tables implemented and the Entity Classes annotated with Hibernate.
I also wrote tests for all of the Daos (the Generic Dao, set up for each Entity class). This filled out
the requirements for the second project checkpoint.

# Week 8
- M: 0
- T: 0
- W: 0
- T: 0
- F: 0
- S: 3.5
- S: 4.5
- Total: 8

This week I set up the web service to produce random names. I also began working on the jsps and controllers for
generating a NPC

# Week Spring Break
- M: 0
- T: 0
- W: 0.5
- T: 4
- F: 0
- S: 3.5
- S: 2
- Total: 10

This week I implemented authentication using Cognito into the project. I also deployed the project onto AWS
using elastic beanstalk. In addition, I continued to work on building out the generate and edit NPC controllers/jsps.
I also began working on the viewNPCs.jsp to display all of a user's generated NPCs

# Week 9
- M: 0
- T: 0
- W: 0
- T: 0
- F: 0
- S: 3.5
- S: 3.5
- Total: 7

Unfortunately this week I made minimal progress on the Independent Project. My time working on Java was spent
on the team project and week 9 activity/exercise.

# Week 10
- M: 1
- T: 0
- W: 0.5
- T: 0.75
- F: 2
- S: 2.25
- S: 3
- Total: 9.5

This week I worked on several of the jsps for the project. I built out the reroll functionality
in edit.jsp. I also added a link from view NPCs to a details screen, from which the edit page
can be accessed.

