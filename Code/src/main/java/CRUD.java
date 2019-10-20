import entity.FamilyMember;
import entity.Product;
import entity.Purchase;
import entity.ShoppingList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CRUD {
    
    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        return meta.getSessionFactoryBuilder().build();
    }

    public static FamilyMember createFamilyMember(String name, String surname){
        FamilyMember fm = new FamilyMember(name, surname);
        System.out.println("Creating new family member...");

        Session session = buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        session.save(fm);
        t.commit();
        System.out.println("Family member created");
        session.close();

        return fm;
    }

    public static Product createProduct(String name){
        Product product = new Product(name);
        System.out.println("Creating new product");

        Session session = buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        session.save(product);
        t.commit();
        System.out.println("Product created");
        session.close();

        return product;
    }

    public static Purchase createPurchase(String productName, float money, int familyMember, int amount, boolean settled){
        Purchase purchase = new Purchase();
        return purchase;
    }

    public static ShoppingList createNewRecordOnShoppingList(String productName, int amount){
        ShoppingList shoppingList = new ShoppingList();
        return shoppingList;
    }
}
