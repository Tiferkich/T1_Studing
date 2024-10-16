package by.sakhdanil.t1_tomcat.repository;

import java.rmi.server.UID;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RepositoryInMemory implements Repository {

    private final ReentrantLock lock = new ReentrantLock();
    private final Map<Integer, String> repository = new HashMap<>();

    @Override
    public String getPhrase() {
        return repository.get((int) (Math.random() * repository.size() + 1));
    }

    @Override
    public void addPhrase(String phrase) {
        lock.lock();
        repository.put(repository.size() + 1, phrase);
        lock.unlock();
    }

}
