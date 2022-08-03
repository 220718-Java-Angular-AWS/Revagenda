# First Steps:

## Identify Domain Objects
These are the things which will be POJOs in Java that correspond to rows in the database.
 - User/Employee/principal
 - Reimbursement
 - Demographics?
 - Address
 - Role/Dept

Identify what info these domain objects need to hold. What private fields should exist in the POJOs?
these private fields (the object state) correspond to database table rows. 
Once you identify the domain objects you can create the POJOs, database schema, and DAOs.

## Write CRUD Methods
Next, you are ready to write your DAOs. Start with an interface that sets forth a promise for all concrete DAO 
classes to implement. You will want to set up abstract methods in the interface to CREATE, READ, UPDATE, and DELETE. 
I suggest you write two methods for READ, one to get a single row based on primary key and return a single object, 
and one to get the whole table and return the results in a collection of objects.

Consider having one DAO implementation for each domain object. The DAOs would be part of the persistence layer. I 
would also suggest considering having one service class and one servlet class for each domain object as well. This 
way you have a stack of servlet, service, and DAO for each domain object. Don't worry about writing any servlets or 
services now, just give some thought to these and keep it in mind as you write persistence layer code.
