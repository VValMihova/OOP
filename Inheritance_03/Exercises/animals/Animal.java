package Inheritance_03.Exercises.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    private void setName(String name) {
        checkInput(name);
        this.name = name;
    }

    private void setAge(int age) {
        checkAge(age);
        this.age = age;
    }

    private void setGender(String gender) {
        checkInput(gender);
        this.gender = gender;
    }
    public String produceSound(){
        return "";
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(String.format("%s %d %s%n", name, age, gender));
        sb.append(produceSound());
        return sb.toString();
    }

    private static void checkInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }
    private static void checkAge(int age){
        if (age<0){
            throw new IllegalArgumentException("Invalid input!");
        }
    }

}
