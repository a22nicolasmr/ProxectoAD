package JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    public static volatile EntityManagerFactory instance;
    public static EntityManager createEntity(){
        if(instance== null){
            synchronized (JPAUtil.class){
                if(instance== null){
                    instance = Persistence.createEntityManagerFactory("proyectoGestorTareas");
                }
            }
        }
        return instance.createEntityManager();
    }
    public static void closeEntity(){
        if(instance!=null){
            instance.close();
        }
    }
}
