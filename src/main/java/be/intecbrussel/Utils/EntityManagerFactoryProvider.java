package be.intecbrussel.Utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {

    private static EntityManagerFactoryProvider provider;

    private EntityManagerFactory emf;

    private EntityManagerFactoryProvider() {
        emf = Persistence.createEntityManagerFactory("mypersistenceunit");
    }

    public EntityManagerFactory getEmf(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
        }
        return emf;
    }

    public static EntityManagerFactoryProvider getInstance(){
        if (provider == null){
            provider = new EntityManagerFactoryProvider();
        }
        return provider;
    }
}
