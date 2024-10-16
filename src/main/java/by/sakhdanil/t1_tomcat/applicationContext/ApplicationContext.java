package by.sakhdanil.t1_tomcat.applicationContext;

import by.sakhdanil.t1_tomcat.applicationContext.configuration.Configuration;
import by.sakhdanil.t1_tomcat.applicationContext.configuration.Instance;
import by.sakhdanil.t1_tomcat.applicationContext.configuration.ManagerConfiguration;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ApplicationContext {

    private final Map<String, Object> beans = new HashMap<String, Object>();


    public ApplicationContext() throws InvocationTargetException, IllegalAccessException {
        Reflections reflections = new Reflections("by.sakhdanil.t1_tomcat.applicationContext.configuration");
        var list = reflections.getTypesAnnotatedWith(Configuration.class).stream().map(type -> {
            try {
                return type.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        for (var bean : list) {
            beans.put(bean.getClass().getSimpleName(), bean);
            System.out.println(bean.getClass().getSimpleName());
        }
        var test = beans.get("ManagerConfiguration");
        var methods = Arrays.stream(test.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(Instance.class)).toList();

        for (var method : methods) {
            method.invoke(test);
        }


    }

    public <T> T getBean(String name) {
        return Optional.ofNullable((T) beans.get(name)).orElseThrow();
    }
}
