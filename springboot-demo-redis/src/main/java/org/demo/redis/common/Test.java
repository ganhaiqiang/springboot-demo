package org.demo.redis.common;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Test {
	public static void main(String[] args) {

		Field[] fields = TTL.class.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.getType().toString().endsWith("java.lang.String") && Modifier.isStatic(field.getModifiers()))
					System.out.println(field.getName() + " , " + field.get(TTL.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		TTL.class.getDeclaredFields();

//		Arrays.stream(TTL.class.getDeclaredFields()).filter(field->field.getType().toString().endsWith("java.lang.String") && Modifier.isStatic(field.getModifiers())).map(Field::getName).collect(Collectors.toList()).forEach(System.out::println);;
	}
}
