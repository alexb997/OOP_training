Library Management System
Problem Statement
Design a simple Library Management System where users can:

Register as Members (Student, Professor)

Borrow and Return Books

See Due Dates and Fines

Admin can add/remove books, and view all borrowed books.

Functional Requirements
Books

Have title, author, ISBN, availability, etc.

Can be borrowed or returned

Members

Can be of type Student or Professor

Can borrow books (limit: students = 3, professors = 5)

Have due dates (e.g., students = 14 days, professors = 28 days)

Fines apply for late returns (students = $1/day, professors = $0.5/day)

Library/Admin

Can add/remove books

View all borrowed books with member names

Bonus Extensions
Track transaction history per member

Add search (by title or author)

Simulate current date to test due date/fine calculation