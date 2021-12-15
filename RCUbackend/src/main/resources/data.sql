INSERT INTO user (username, password, firstName, lastName, email) VALUES ('user1', 'password1', 'Kev', 'C', 'user1@email.com');

INSERT INTO user (username, password, firstName, lastName, email) VALUES ('user2', 'password2', 'Vek', 'K', 'user2@email.com');

INSERT INTO account (userID, accountType, balance) VALUES (1, 0, 400.00);

INSERT INTO account (userID, accountType, balance) VALUES (1, 1, 1600.00);

INSERT INTO account (userID, accountType, balance) VALUES (2, 0, 270.00);

INSERT INTO account (userID, accountType, balance) VALUES (2, 1, 3750.00);

INSERT INTO transaction (userID, accountID, transactionType, debitcredit, amount) VALUES(1, 1, 0, 0, 200.00);
-- User 1 / account 1 / balance 600.00

INSERT INTO transaction (userID, accountID, transactionType, debitcredit, amount) VALUES(1, 1, 1, 1, 200.00);
-- User 1 / account 1 / balance 400.00

INSERT INTO transaction (userID, accountID, transactionType, debitcredit, amount) VALUES(2, 2, 2, 1, 70.00);
-- User 2 / account 2 / balance 200.00

INSERT INTO transaction (userID, accountID, transactionType, debitcredit, amount) VALUES(1, 1, 2, 0, 70.00);
-- User 1 / account 1 / balance 470.00