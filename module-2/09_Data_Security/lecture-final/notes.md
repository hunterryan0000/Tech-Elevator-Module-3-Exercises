# Data Security Notes

2 key take aways:

1. Never store passwords in plain text hash them!!!
    - Note hashing is different than encryption. Hashing is one way - encryption is 2 way (can get back to the original text).
2. Use parameterized queries to prevent SQL Injection Attacks (talked about this yesterday too)


## Protect your data

One way to protect sensitive data. (Another option is encryption, which we won't dive into in lecture.)

Examples of sensitive data:
- Passwords
- PIN
- Credit card numbers
- Bank account numbers

### Hashing

One type of sensitive data systems need to store is user passwords.

1.  We need to be able to *verify* a password but not *recover* it.
2.  A system administrator with access to credential data should not be able to determine a password.
3.  Any hacker that steals a database or set of credentials should not be able to read the passwords.
4.  Even with super-computing capabilities, no one should be able to access the data within any reasonable amount of time.

Hashing process:

1.  Use a one-way function to obfuscate the plain-text password prior to storage.
2.  Use the password supplied by the user, re-hash it, and compare it to the stored password hash value.
3.  Salt the passwords to make it take longer to calculate all possibilities.


### SQL injection attack

SQL injection occurs when un-trusted data such as user data from application web pages are added to database queries, materially changing the structure and producing behaviors inconsistent with application design or purpose.

Clever attackers exploit SQL injection vulnerabilities to steal sensitive information, bypass authentication or gain elevated privileges, add or delete rows in the database, deny services, and in extreme cases, gain direct operating system shell access, using the database as a launch point for sophisticated attacks against internal systems.

SQL injection is by far the most dangerous vulnerability impacting online applications today. When you read that hackers have stolen 450,000 user accounts or that 130 million credit card numbers have been exposed, it is very likely that the application was attacked using SQL injection.

### Preventing SQL injection

1.  **Parameterized Queries** - The single most effective thing you can do to prevent SQL injection is to use parameterized queries. If this is done consistently, SQL injection won't be possible.

2.  **Input Validation** - Limiting the data that can be input by a user can certainly be helpful in preventing SQL Injection, but is by no means an effective prevention by itself.

3.  **Limit Database User Privileges** - A web application should always use a database user to connect to the database that has as few permissions as necessary. For example, if your application never deletes data from a particular table, then the database user should not have permission to delete from that table. This helps to limit the damage in the case that there is a SQL Injection vulnerability.

### Encryption

Encryption is often used to secure data in transit. Mentioned SSL (using HTTPS in the browser) as an example. 

## Curious to know more?

The world of security is HUGE!  Check out [OWASP](https://owasp.org/) as a starting place if you are curious to know more.