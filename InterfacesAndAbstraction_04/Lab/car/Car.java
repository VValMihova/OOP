package InterfacesAndAbstraction_04.Lab.car;

import java.io.Serializable;

public interface Car extends Serializable {
    Integer TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
}
