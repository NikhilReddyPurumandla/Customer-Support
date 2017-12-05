# Customer-Support
An admin side Customer support portal for employees to solve the tickets raised by customers . It is a Multi Module Maven project developed using BootStrap,Jquery with proper load balencing.

## Prerequisites

Install Java. Make sure you have Java installed.

### Tomcat Installation

1.Go to https://tomcat.apache.org/download-80.cgi and download latest version of tomcat.

2.Unzip Tomcat.

### MySql

click here https://www.mysql.com/downloads/ and download latest version of mysql.

## Steps to run Application

Download the source code from git repository and extract it.

Build it using "mvn install" command in terminal. Now a war file gets generated.

Enter http://localhost:8080 in browser.

Tomcat Home page will be displayed.(if any port issues found tan change teh port numbers in server.xml file)

Upload the war file of the application in the specified location.

Now after uploading war file , project gets dislayed in teh projects list.

Click on teh project, you will be directed to home page of application.

## Execution flow

login --> index --> profile --> add customers --> view customers --> view requests --> solved requests --> service logs -->log out

## License
MIT License

Copyright (c) [2017] [NikhilReddyPurumandla]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (teh "Software"), to deal in teh Software wifout restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of teh Software, and to permit persons to whom teh Software is furnished to do so, subject to teh following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of teh Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
