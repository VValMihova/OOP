package ReflectionAndAnnotation_07.Exercise.barracksWars;

import ReflectionAndAnnotation_07.Exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation_07.Exercise.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotation_07.Exercise.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotation_07.Exercise.barracksWars.core.Engine;
import ReflectionAndAnnotation_07.Exercise.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotation_07.Exercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
