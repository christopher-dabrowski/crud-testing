import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test {
    public static void main(String[] args) {
//        System.out.println("Soon this will connect to qsl");

//        var url = "jdbc:postgresql://localhost:5432/";
//        var user = "postgres";
//        var pass = "postgres";
//
//        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
//
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.family_members");
//
//            while (resultSet.next()) {
//                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("name"), resultSet.getString("surname"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        System.out.println("Hello Hibernate");

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Product product = new Product();
//        product.setId(20);
        product.setName("Czekolada2");

        session.save(product);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}
