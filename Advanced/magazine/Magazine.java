package Advanced.magazine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < capacity) {
            data.add(cloth);
        }
    }

    public boolean removeCloth(String colour) {
        return data.removeIf(cloth->cloth.getColor().equals(colour));
    }

    public Cloth getSmallestCloth() {
        return Collections.min(data,(f, s)->Integer.compare(f.getSize(),s.getSize()));
    }

    public Cloth getCloth(String colour) {
        return data.stream().filter(cloth->cloth.getColor().equals(colour)).findFirst().get();
    }
    public int getCount(){
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(" magazine contains:");
        for (Cloth cloth : data) {
            sb.append(System.lineSeparator());
            sb.append(cloth);
        }
        return sb.toString().trim();
    }
}


