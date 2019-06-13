import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseControllerTest {

    @Test
    public void testConnection(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("toplist");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }
}
