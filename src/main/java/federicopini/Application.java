package federicopini;

import entities.*;
import enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Application {

    public static void main(String[] args) {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("B3-L5");
            EntityManager em = emf.createEntityManager();


            em.close();
            emf.close();
    }
}
