# QuotesGame - Introduction to Programming project

## Table of content
* [Introduction](#introduction)
* [Description](#description)
* [Setup](#setup)
* [Instructions](#instructions)
* [Team](#team)
* [Features](#features)
* [Technologies](#technologies)
* [Licence](#license)

## Introduction
This project aims to develop a web application to test our knowledge in the field of cyber security. There are 2 versions of the same application.
The first version implements an unsecured web app (with database) that can be subjected to XSS, CSRF, and SQL injection attacks.
Instead, the second version implements the same web app as before, but it is secure.

## Description
The application utilizes a random procedure to determine which author is preferred by the user.
The chooseAuthor method decides which author will be selected, from whom pick a random quote.
It uses a random generator number between 0 and 1. This last step is developed in the chooseQuote method.
Moreover, the program can autonomously stop the game as soon as the likes of one of the two authors are over half.
For example, if the user select 11 quotes and after 8 shown quote the user liked 6 quotes from author A 
and 1 quote from author B and disliked 1 quote from author B, the resultPane will be displayed.

## Setup
To install this project, follow the instructions:
```
# Clone this repository in the local xammp/htdocs repository
$ git clone https://github.com/Liukooo/mssn_project.git
# Import the database file forumdb.sql on the local PhpMyAdmin named forumdb
$ http://localhost/phpmyadmin/index.php?route=/server/databases&server=1
```

## Instructions
To run this project, follow the instructions:
```
# Start Apache server and MySQL database
# Run the application in the localhost, sign in with a username and a password and after success, log in with the same username and password
$ http://localhost/mssn_project/src-secure/signin.php
# Now you have various options: ask a question in the main forum, answer to a specific question, sign in with a new account or log out
$ http://localhost/mssn_project/src-secure/forum.php
# If you want to answer a specific question you will be redirected to the specific page where you can answer the question or consult other answers from other users
$ http://localhost/mssn_project/src-secure/answers.php?id=46
```

## Team
Project is developed by:
<a><img alt="Luca" title="Luca Borrelli" src="./img/luca.jpg" width="200"></a> |
--- |
Luca Borrelli |

## Features
What you can do:
* Sign in
* Log in
* Log out
* Make technical questions
* Add answers to questions from other users
* Try to exploit the site :wink:

## Technologies
Project is created with:
* PHP version: 8.0.13
* CSS version: 3.0.0
* phpMyAdmin SQL version: 5.1.1

## License
MIT License

Copyright (c) 2021 Luca Borrelli

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
