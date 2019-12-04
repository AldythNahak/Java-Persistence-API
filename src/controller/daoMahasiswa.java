package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.TbMahasiswa;

public class daoMahasiswa {

    EntityManager em;

    public daoMahasiswa() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("KampusJPAPU");
        em = emf.createEntityManager();
    }

    public List<TbMahasiswa> getAllMahasiswa() {
        List<TbMahasiswa> listMhs = em.createNamedQuery("TbMahasiswa.findAll", TbMahasiswa.class).getResultList();
        return listMhs;
    }
    
    public TbMahasiswa getMahasiswa(int nim) {
        TbMahasiswa mhs = em.find(TbMahasiswa.class, nim);
        return mhs;
    }

    public void insertMahasiswa(TbMahasiswa mhs) {
        em.getTransaction().begin();
        em.persist(mhs);
        em.getTransaction().commit();
    }
    
    public void updateMahasiswa(TbMahasiswa mhs) {
        em.getTransaction().begin();
        em.merge(mhs);
        em.getTransaction().commit();
    }
    
    public void deleteMahasiswa(TbMahasiswa mhs) {
        em.getTransaction().begin();
        em.remove(mhs);
        em.getTransaction().commit();
    }
}
