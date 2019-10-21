import entity.FamilyMember;
import entity.Product;
import entity.Purchase;
import entity.ShoppingList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CRUD {

    public static SessionFactory buildSessionFactory() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        return meta.getSessionFactoryBuilder().build();
    }
  
    public static FamilyMember createFamilyMember(String name, String surname){
        FamilyMember fm = new FamilyMember(name, surname);
        System.out.println("Creating new family member...");

        Session session = buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        Query query = session.createSQLQuery("SELECT MAX(family_member.id) + 1 AS new_id FROM family_member");
        int id = (int) query.getSingleResult();
        fm.setId(id);

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

        Query query = session.createSQLQuery("SELECT MAX(id) + 1 AS new_id FROM product");
        int id = (int) query.getSingleResult();
        product.setId(id);

        session.save(product);
        t.commit();
        System.out.println("Product created");
        session.close();

        return product;
    }

    public static Purchase createPurchase(String productName, BigDecimal money, int familyMember, int amount, boolean settled){
        Purchase purchase = new Purchase();
        purchase.setDate(LocalDateTime.now());
	    System.out.println("Creating new purchase");

	    int prodId = -1;
	    List<Product> products = listProducts();
	    for (Product x : products) {
		    if (x.getName().equals(productName)) {
			    prodId = x.getId();
			    break;
		    }
	    }
	    if (prodId != -1) {
		    purchase.setProduct_id(prodId);
	    } else {
		    Product newProduct = createProduct(productName);
		    purchase.setProduct_id(newProduct.getId());
	    }

	    purchase.setMoney(money);

	    List<FamilyMember> familyMembers = listFamilyMembers();
	    int famMem = -1;
	    for (FamilyMember x : familyMembers) {
		    if (x.getId() == familyMember) {
			    famMem = familyMember;
			    break;
		    }
	    }
	    if (famMem != -1) {
		    purchase.setFamily_member(familyMember);
	    } else {
		    System.out.println("Podany członek rodziny nie istnieje");
		    return null;
	    }

	    purchase.setAmount(amount);
	    purchase.setSettled(settled);

	    Session session = buildSessionFactory().openSession();
	    Transaction t = session.beginTransaction();

	    session.save(purchase);
	    t.commit();
	    System.out.println("Purchase created");
	    session.close();

        return purchase;
    }

	public static void createNewRecordOnShoppingList(int productId, int amount) {
		ShoppingList shoppingList = new ShoppingList(productId, amount);
		System.out.println("Creating new record on shopping list...");

		Session session = buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		session.save(shoppingList);
		t.commit();
		System.out.println("New record on shopping list added.");
		session.close();
    }

	private static void editRecordOnShoppingList(int productId, int amount) {
		ShoppingList shoppingList = new ShoppingList();
	}
    
    public static List<Product> listProducts() {
        Session session = buildSessionFactory().openSession();
        List<Product> result = null;

        try {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria = criteriaBuilder.createQuery(Product.class);
            criteria.from(Product.class);

            result = session.createQuery(criteria).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }

        return result;
    }

    public static List<FamilyMember> listFamilyMembers() {
        Session session = buildSessionFactory().openSession();
        List<FamilyMember> result = null;

        try {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<FamilyMember> criteria = criteriaBuilder.createQuery(FamilyMember.class);
            criteria.from(FamilyMember.class);

            result = session.createQuery(criteria).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }

        return result;
    }

    public static List<Purchase> listPurchases() {
        Session session = buildSessionFactory().openSession();
        List<Purchase> result = null;

        try {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Purchase> criteria = criteriaBuilder.createQuery(Purchase.class);
            criteria.from(Purchase.class);

            result = session.createQuery(criteria).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }

        return result;
    }

	public static List<ShoppingList> listShoppingListItems() {
        Session session = buildSessionFactory().openSession();
        List<ShoppingList> result = null;

        try {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ShoppingList> criteria = criteriaBuilder.createQuery(ShoppingList.class);
            criteria.from(ShoppingList.class);

            result = session.createQuery(criteria).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }

        return result;
    }
}
