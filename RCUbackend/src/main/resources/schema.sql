CREATE TABLE user (
    userID INT unsigned NOT NULL auto_increment PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE account (
    accountID INT unsigned NOT NULL auto_increment PRIMARY KEY,
    userID INT NOT NULL,
    accountType INT NOT NULL,
    balance INT unsigned NOT NULL,
    FOREIGN KEY (userID) REFERENCES user(userID)
);

CREATE TABLE transaction (
    transactionID INT unsigned NOT NULL auto_increment PRIMARY KEY,
    userID INT unsigned NOT NULL auto_increment,
    accountID INT unsigned NOT NULL auto_increment,
    transactionType VARCHAR(10) NOT NULL,
    debitcredit INT NOT NULL,
    amount INT NOT NULL,
    transactionTimestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userID) REFERENCES user(userID),
    FOREIGN KEY (accountID) REFERENCES account(accountID)
);