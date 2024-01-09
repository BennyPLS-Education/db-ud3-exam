import cat.paucasesnovescifp.spaad.jdbc.JDBCActivities;
import cat.paucasesnovescifp.spaad.jpa.JPAActivities;
import cat.paucasesnovescifp.spaad.jpa.entitats.Llibre;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("\tJDBC ACTIVITIES");
        
        var localities = JDBCActivities.getAllLocalities("071");
        System.out.println("Localities in idIlla : 071");
        System.out.println(localities);
        
        var isRemoved = JDBCActivities.removeCenter("07000042");
        System.out.println("Removed 07000042 Center? - " + isRemoved);
        
        System.out.println("Implementing procedure");
        JDBCActivities.implementProcedure();
        
        System.out.println("Calling procedure");
        var centerCount = JDBCActivities.callProcedure("071");
        System.out.println(centerCount);
        
        System.out.println("\tJPA ACTIVITIES");
        
        var editor = JPAActivities.getEditor(1);
        System.out.println(editor);
        
        var editor50 = JPAActivities.get50Editors();
        System.out.println(Arrays.toString(editor50));
        
        var editor2 = JPAActivities.getEditor("LA BUSCA EDICIONS");
        System.out.println(editor2);
        
        var book = new Llibre();
        book.setTitol("hola");
        book.setIdLlib(99999);
        
        JPAActivities.insertBook(book);
        
        JPAActivities.updateBook(99999, "other title");
        
        JPAActivities.getEgerEditor();
    }
}
