# INSERT, UPDATE, DELETE, transactions, constraints, and referential integrity

## Session objectives

- Write INSERT statements
- Write UPDATE statements
- Write DELETE statements
- Understand the benefits of referential integrity and how it can cause INSERTs, UPDATEs, and DELETEs to fail
- Understand how constraints limit the changes that can be made
- Understand what transactions are and the SQL needed to make use of them

## INSERT, UPDATE, DELETE

1. **INSERT**
	- INSERT adds new records to the database.
	- Primary keys are often automatically generated rather than being set explicitly.
	- The values of the records being added can be supplied in a VALUES clause, or be the result of a subquery.

2. **UPDATE**
	- UPDATE modifies existing records.
	- The WHERE clause determines which records are updated. **Without it, all records are updated.**
	- The previous value of a field can be used to calculate the new value.
	- Multiple fields can be updated by a single query.

3. **DELETE**
	- DELETE removes records.
	- The WHERE clause determines which records are deleted. **Without it, all records are deleted.**


## Referential Integrity & Constraints

**Referential Integrity**
	- We've learned that databases can have relationships established between tables using primary and foreign keys.
	- **Referential integrity** ensures that relationships between tables remain consistent.
	- INSERTs, UPDATEs, and DELETEs can all fail if the change violates the database's referential integrity.
	- Often, the order in which changes are made is important. For example, a record with a foreign key must first be deleted before the associated record in another table can be deleted.


**Constraints**
	- A **constraint** is associated with a table and defines criteria that the column data must comply with.
	- Types of Constraints:
		1. **NOT NULL** - requires a value to be specified for the column
		2. **DEFAULT** - provides a default value for the column
		3. **UNIQUE** - prevents using a value already in the table for that column
		4. **CHECK** - specifies acceptable values that can be entered in the column
	- Two other constraints are used to establish referential integrity:
		1. **PRIMARY KEY** (PK) - includes NOT NULL and UNIQUE
		2. **FOREIGN KEY** (FK) - requires values to exist as PKs, and limits deletion of the PK row if FK row exists


## Transactions
	- If we have multiple INSERT, UPDATE, or DELETE statements and want them to be considered as an *all or nothing*, then we consider it a **transaction**.
	- A **transaction** is a single unit of work. When it is successful, it must be **committed**. If an error is encountered at any point, it must be cancelled or **rolled back**.
	- When a transaction is in progress, other queries of the database normally won't see the changes being made until the transaction has been committed.
	- Ask students why this might be important using the example of a bank transfer. Some possible answers:
		- We wouldn't want funds to be withdrawn from one account and never deposited to the other account.
		- If the deposit fails, the withdrawal should also fail (and vice-versa).
		- Simultaneous requests to transfer to different accounts should be handled one after the other (and should not create money).

