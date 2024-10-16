package by.sakhdanil.t1_tomcat;

import by.sakhdanil.t1_tomcat.repository.Repository;
import by.sakhdanil.t1_tomcat.repository.RepositoryInMemory;

public class ManagerRep {
    private final Repository data;

    public ManagerRep() {
        this.data = new RepositoryInMemory();
        data.addPhrase("Hi Bro");
        data.addPhrase("U are good");
        data.addPhrase("Dont worry");
    }

    public String addPhrase(String phrase) {
        data.addPhrase(phrase);
        return "Phrase added:" + phrase;
    }

    public String getPhrase() {
        return data.getPhrase();
    }
}
