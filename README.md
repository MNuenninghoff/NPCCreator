# Welcome to the NPC Creator

This repository contains the source code for the NPC Creator

# Problem Statement

As a Dungeon Master (DM), oftentimes, your party will wander off track. Ignoring the flashing neon signs saying “dragons 
and treasure this way”, they instead head off to the part of the map that you left blank with the thought, “I’ll fill 
that in next Friday”. Now you need to quickly make some non-player characters (NPCs) to fill out the town that you are 
creating right now.

I want to build an application that can quickly generate randomized NPC templates to provide descriptions for busy DM’s. 
Need a barkeeper who has a unique trait? Now you can quickly generate it (and save it for future reference). 
Struggling to come up with a fun villain for the next plot arc? Quickly make a couple random villains and see if any 
strike your fancy.

**The goal of this application is to streamline prep work and make NPC generation faster than rolling through random 
tables, as well as providing an interface to save NPC’s that you like.**

Building off of the NPC creation guide described in the Dungeons and Dragons 5th Edition Dungeon Masters Guide, 
NPC Creator will generate a random NPC with characteristics for the **Name, Race, Appearance, Ability, Talent, 
Mannerisms, Interaction Traits, Bond, and Flaw**

# Project Technologies/Techniques
- Security/Authentication:
  - AWS Cognito
- Database
  - MySQL 8.3
  - Hibernate ORM Version 6.4.3 Final
- Web Services consumed using Java
  - ??Mockaroo??
  - ??muna.ironarachne.com name generator??
    - https://muna.ironarachne.com/elf/?count=1&nameType=family
- Dependency Management
  - Maven
- Logging
  - Log4J2
- Hosting
  - AWS
- CSS
  - ??Bootstrap??
- IDE: IntelliJ IDEA