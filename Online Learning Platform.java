class Course:
    def __init__(self, course_id, title, instructor, duration):
        self.course_id = course_id
        self.title = title
        self.instructor = instructor
        self.duration = duration
        self.students = []

    def add_student(self, student):
        self.students.append(student)

    def display_details(self):
        print(f"Course ID: {self.course_id}")
        print(f"Title: {self.title}")
        print(f"Instructor: {self.instructor}")
        print(f"Duration: {self.duration} hours")

    def display_students(self):
        print(f"Students enrolled in {self.title}:")
        for idx, student in enumerate(self.students, start=1):
            print(f"{idx}. {student.name}")


class Student:
    def __init__(self, student_id, name, email):
        self.student_id = student_id
        self.name = name
        self.email = email

    def display_details(self):
        print(f"Student ID: {self.student_id}")
        print(f"Name: {self.name}")
        print(f"Email: {self.email}")


class LearningPlatform:
    def __init__(self):
        self.courses = []

    def create_course(self, course_id, title, instructor, duration):
        course = Course(course_id, title, instructor, duration)
        self.courses.append(course)
        print(f"Course '{title}' created successfully.")

    def display_courses(self):
        print("Available Courses:")
        for course in self.courses:
            course.display_details()

    def enroll_student(self, course_id, student):
        for course in self.courses:
            if course.course_id == course_id:
                course.add_student(student)
                print(f"{student.name} enrolled in {course.title}.")
                return
        print(f"Error: Course with ID '{course_id}' not found.")

    def display_students_in_course(self, course_id):
        for course in self.courses:
            if course.course_id == course_id:
                course.display_students()
                return
        print(f"Error: Course with ID '{course_id}' not found.")


def main():
    platform = LearningPlatform()

    # Create courses
    platform.create_course(101, "Python Programming", "John Doe", 8)
    platform.create_course(102, "Web Development", "Jane Smith", 12)

    # Display available courses
    platform.display_courses()

    # Create students
    student1 = Student(201, "Alice", "alice@example.com")
    student2 = Student(202, "Bob", "bob@example.com")

    # Enroll students in courses
    platform.enroll_student(101, student1)
    platform.enroll_student(102, student2)

    # Display students enrolled in courses
    platform.display_students_in_course(101)
    platform.display_students_in_course(102)


if __name__ == "__main__":
    main()
