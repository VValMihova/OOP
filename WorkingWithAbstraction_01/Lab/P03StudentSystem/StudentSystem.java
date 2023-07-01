package WorkingWithAbstraction_01.Lab.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public Map<String, Student> getRepository() {
        return this.repository;
    }

    public void executeCommand(String[] commandParts) {
        String commandName = commandParts[0];
        switch (commandName) {
            case "Create" :{
                createStudent(commandParts);

                break;
            }
            case "Show": {
                showStudents(commandParts);
                break;
            }
        }
    }

    private void showStudents(String[] commandParts) {
        String name = commandParts[1];
        if (repository.containsKey(name)) {
            Student student = repository.get(name);
            StringBuilder output = new StringBuilder(student.toString());


            if (student.getGrade() >= 5.00) {
                output.append(" Excellent student.");
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                output.append(" Average student.");
            } else {
                output.append(" Very nice person.");
            }

            System.out.println(output);
        }
    }

    private void createStudent(String[] commandParts) {
        String name = commandParts[1];
        int age = Integer.parseInt(commandParts[2]);
        double grade = Double.parseDouble(commandParts[3]);
        Student student = new Student(name, age, grade);
        repository.putIfAbsent(name, student);
    }
}
