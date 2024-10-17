package by.sakhdanil.t1_tomcat.applicationContext.configuration;


import by.sakhdanil.t1_tomcat.ManagerRep;


@Configuration
public class ManagerConfiguration {


    @Instance
    public ManagerRep managerRep() {
        return new ManagerRep();
    }

    @Instance
    public void hello() {
        System.out.println("hello");
    }

}
