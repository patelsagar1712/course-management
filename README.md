# Course Management

Please configure Project locally and try using Swagger UI to access the endpoints.

Please Start with Creating a user using /register and getting a JWT token using /login method.


Use Swagger for API Information and Make API calls 

http://localhost:8088/swagger-ui/index.html

TO DO: 

- System Admin 
		- Create/Update/Delete/List Users (Instructor, Student)
		- List all courses
		- List all Students 
		- List students enrolled in each course

	- Instructor 
		- Create Courses
		- Create Assignment for each course
		- List all courses
		- Access/Modify courses created by themselves
		- List the students enrolled in each course
		- Must not be able to access courses created by other instuctors

	- Student
		- Can see all the courses 
		- Can enroll in more than one course 
		- Can access only enrolled courses and assignments
		- Can submit/update assignments 
