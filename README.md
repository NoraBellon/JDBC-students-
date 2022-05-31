# JDBC-students-
Hello! It is a small program which built on the main principles of framework DAO. We have 2 layers: first to take data from db and the second one for our user. 
We have:

1. A special class CollectionUtil that realize in itself connection to db;

2. A class StudentFormat - have fields that are the same to columns of the table we will use;

3.A class StudentFormatDaoImpl implemets StudentFormatDao and have their realization of these methods. 
StudentFormatDaoImpl realization short info:

a) EACH METHOD MUST DO THIS OWN SINGLE CONNCETION TO OUR TABLE "STUDENTS'. 
b) There are reasons why we use PreparedStatemnt or Statement.

4. StudentServerImpl implements StudentServer and have injected StudentFormatDao. Its methods are just frames of these which realized in StudentFormatDaoImpl. It must be for making an interface for user and seperate this interfaces from direct cooperation with db.

