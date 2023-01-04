import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Employee employee = new Employee(0,"Peter");

            Phone phone1 = new Phone("Nokia","2222222");
            Phone phone2 = new Phone("Motorola","33355555");

            List<Phone> phones = new ArrayList<>();
            phones.add(phone1);
            phones.add(phone2);
            employee.setPhones(phones);
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        sessionFactory.close();

    }
}