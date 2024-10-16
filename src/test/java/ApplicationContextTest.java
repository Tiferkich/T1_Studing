import by.sakhdanil.t1_tomcat.applicationContext.ApplicationContext;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApplicationContextTest {



    @Test
    public void app_cont_should_return_instance_by_class() throws InvocationTargetException, IllegalAccessException {
        final var context = new ApplicationContext();
        //assertNotNull(context.getBean("ManagerRep") );

    }
}
