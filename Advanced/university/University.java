package Advanced.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (getStudentCount() >= capacity) {
            return "No seats in the university";
        }
        if (getStudent(student.firstName, student.lastName) != null) {
            return "Student is already in the university";
        }
        students.add(student);
        return String.format("Added student %s %s", student.firstName, student.lastName);
    }

    public String dismissStudent(Student student) {
        Student foundStudent = getStudent(student.firstName, student.lastName);
        if (foundStudent == null) {
            return "Student not found";
        }
        students.remove(student);
        return String.format("Removed student %s %s", foundStudent.firstName, foundStudent.lastName);
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (firstName.equals(student.firstName) && lastName.equals(student.lastName)) {
                return student;
            }
        }
        return null;
    }

//==Student: First Name = Rihanna, Last Name = Fenty, Best Subject = Music
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append("==Student: First Name = ").append(student.firstName)
                    .append(", Last Name = ").append(student.lastName)
                    .append(", Best Subject = ").append(student.bestSubject)
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
