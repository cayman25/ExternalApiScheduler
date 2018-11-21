#ExternalApiScheduler

It is an aplication resposible for get information from external service and save it to local database. 
Finished games are saved only when program get information about any update.
All games avaiable from external service is saved one per day.  

Program uses mainly SpringBoot, SpringDataJPA, two design patterns(Observer and Facade). Data is saved to local MySql server. 

The main entities:
>**Game** -> contains all needed information about play (data, team, league, status, winner etc.)
>**Team** -> contains only ID and name of team
>**Competition** -> contains ID and name of league

This entities is diffrent than object get from external api. 
In future this application will be responsible for update result of users bets.
