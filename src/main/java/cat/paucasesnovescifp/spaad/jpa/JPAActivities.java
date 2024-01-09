package cat.paucasesnovescifp.spaad.jpa;

import cat.paucasesnovescifp.spaad.jpa.entitats.Editor;
import cat.paucasesnovescifp.spaad.jpa.entitats.Llibre;

import javax.persistence.EntityManager;
import java.util.List;

;

public class JPAActivities {
    
    public static Editor getEditor(int idEditor) {
        EntityManager em = JPADB.getConnection();
        
        try {
            return em.find(Editor.class, idEditor);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } finally {
            em.close();
            
        }
    }
    
    public static Editor getEditor(String editorName) {
        EntityManager em = JPADB.getConnection();
        
        try {
            var query = em.createQuery("SELECT e FROM Editor e WHERE e.nomEdit = :editorName", Editor.class);
            query.setParameter("editorName", editorName);
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    
    public static Editor[] get50Editors() {
        EntityManager em = JPADB.getConnection();
        List<Editor> editors;
        Editor[] editors50 = new Editor[50];
        try {
            var query = em.createNamedQuery("editors.all", Editor.class);
            editors = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
        
        for (int i = 0; i < editors.size() && i < 49; i++) {
            editors50[i] = editors.get(i);
        }
        
        return editors50;
    }
    
    public static void insertBook(Llibre newBook) {
        EntityManager em = JPADB.getConnection();
        
        try {
            em.persist(newBook);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    
    public static void updateBook(int idBook, String newTitle) {
        EntityManager em = JPADB.getConnection();
        
        try {
            var book = em.find(Llibre.class, idBook);
            book.setTitol(newTitle);
            em.merge(book);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    
    public static void getEgerEditor() {
        EntityManager em = JPADB.getConnection();
        Editor editor = null;
        
        try {
            var query = em.createQuery("SELECT e FROM Editor e FETCH ALL PROPERTIES", Editor.class);
            editor = query.getResultList().get(0);
            
            System.out.println(editor != null ? editor.getLlibres() : null);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
