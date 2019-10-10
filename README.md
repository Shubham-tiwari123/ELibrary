# ELibrary using Spring

### Developed an eLibrary for performing unit testing and integration testing.

Performed unit testing on **DAO layer** using **Junit** to check its working. For this created an another DB test.

Performed unit testing on **Controller** using **Mockito**.

Performed integration testing on **Controller** using **@SpringBootTest**.

Performed webapplication testing using **Selenium**.

### Steps to make Spring Project ELibrary.

1. File-> New Project-> Maven-> Web Application

2. Edit pom.xml to convert simple maven into Spring project

3. Create a **main method** inside a package **com.springpro.elibrary**

4. Create a new package inside Source Package for controller **com.springpro.elibrary.controller** and add Java Files
	
   	AdminSideController
   	
   	LibrarianSideController
   
5. Create a new package inside Source Package for dao **com.springpro.elibrary.dao** and add Java Files
	
   	AdminFunctionDao
   	
   	LibrarianFunctionDao
   	
   	DbConnenction

6. Create a new package inside Source Package for entity **com.springpro.elibrary.entity** and add Java Files
	
   	AddBook
   	
   	AddLibrarian
   	
   	IssueBook
   	
   	LoginDetails
   	
   	ReturnBook

7. Create a new package inside Source Package for entity **com.springpro.elibrary.service** and add Java Files
	
   	AdminLoginService
   	
   	AdminService
   	
   	LibrarianLoginService
   	
   	LibrarianService
   	
8. Create a new package inside Test Package for daotest **com.springpro.elibrary.dao** and add Java Files

	AdminFunctionDaoTest
	
	LibrarianFunctionDaoTest
	
9. Create a new package inside Test Package for daotest **com.springpro.elibrary.controller** and add Java Files

	AdminSideControllerTest
	
	LibrarianSideControllerIT
	
10. To perform one unit test comment all the other tests of the file.

11. Create two database one for testing and one for application

### Testing ELibrary using Selenium

1. Create a simple Java project.

2. Download jar files for Selenium.
	
	[Download the jar/zip file from here](https://selenium-release.storage.googleapis.com/index.html?path=3.9/)
	
		selenium-server-3.9.0.zip
	
		selenium-server-standalone-3.9.0.jar
	
	[Download suitable chromedriver from here](https://sites.google.com/a/chromium.org/chromedriver/downloads)
	
3. Unzip all the zip files.

4. Add all the jar files in the project.

**Note:-** Run ELibrary Spring Project before running Selenium Project 


