#ExternalApiScheduler

This aplication is resposible for geting information from external service and save it to local database. 
All finish games are save only when program get information about update.
All games available from external service is saved one per day.  

Program uses mainly SpringBoot, SpringDataJPA, two design patterns(Observer and Facade). This is my first try to write app in Hexagonal Architecture based on _WJUG #211 - Modularity and hexagonal architecture in real life: Jakub Nabrdalik._ 

All data are save to local MySql server. 

The main entities:
* **Game** -> contains all needed information about play (data, team, league, status, winner etc.)
* **Team** -> contains only ID and name of team
* **Competition** -> contains ID and name of league

In future this application will be responsible for update result of users bets therefor **Game** contains verified_status.
