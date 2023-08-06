package ReflectionAndAnnotation_07.Exercise.barracksWars.core.factories;

import ReflectionAndAnnotation_07.Exercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation_07.Exercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionAndAnnotation_07.Exercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Class clazz = Class.forName("ReflectionAndAnnotation_07.Exercise.barracksWars.models.units." + unitType);
		Constructor<Unit> constructor = clazz.getDeclaredConstructor();
		Unit unit = constructor.newInstance();
		return unit;

	}
}
