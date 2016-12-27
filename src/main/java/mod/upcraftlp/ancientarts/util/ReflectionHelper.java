package mod.upcraftlp.ancientarts.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import core.upcraftlp.craftdev.API.common.ModLogger;
import mod.upcraftlp.ancientarts.Main;

@SuppressWarnings("rawtypes")
public class ReflectionHelper {
	
	public static final Map<String, String> MAPPINGS = new HashMap<String, String>();
	private static final ModLogger log;
	
	static {
		log = Main.getLogger();
		MAPPINGS.put("getItemEnchantability", "func_77619_b");
		MAPPINGS.put("IRON_HOE", "IRON_HOE"); //FIXME
	}
	
	@Nullable
	public static Field getField(Class clazz, String deobfName) {
		try {
			for(Field f : clazz.getFields()) {
				f.setAccessible(true);
				String name = f.getName();
				if(name.equals(MAPPINGS.get(deobfName)) ||name.equals(deobfName)) {
					return f;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Nullable
	public static Method getMethod(Class clazz, String deobfName) {
		try {
			for(Method m : clazz.getMethods()) {
				m.setAccessible(true);
				String name = m.getName();
				if(name.equals(MAPPINGS.get(deobfName)) ||name.equals(deobfName)) {
					return m;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		log.println("Method not found: " + deobfName);
		return null;
	}
	
	
}
