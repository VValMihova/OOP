package Advanced.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (capacity>registry.size()){
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                registry.remove(child);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return getChild(firstName);
    }

    public String registryReport() {
        StringBuilder builder = new StringBuilder();
        registry = registry.stream().sorted(Comparator.comparingInt(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName)).collect(Collectors.toList());
        builder.append(String.format("Registered children in %s:", name));
        for (Child child : registry){
            builder.append(System.lineSeparator()).append("--").append(System.lineSeparator());
            builder.append(child);
        }
        return builder.toString();
    }
}
    //•	Method registryReport() – Orders the children by age ascending, then by first name ascending, then by last name ascending, and returns a String in the following format:
    //o	"Registered children in {kindergartenName}:
    //--
    //{child1}



