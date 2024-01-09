package cat.paucasesnovescifp.spaad.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADB {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca-pu");
    
    public static EntityManager getConnection() {
        return emf.createEntityManager();
    }
}
