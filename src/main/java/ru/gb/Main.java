package ru.gb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Конфигурация Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Создание фабрики сессий
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Открытие сессии и начало транзакции
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Создание нескольких объектов Person
        Person person1 = new Person();
        person1.setName("John Doe");
        person1.setAge(30);

        Person person2 = new Person();
        person2.setName("Jane Doe");
        person2.setAge(25);

        Person person3 = new Person();
        person3.setName("Alice Smith");
        person3.setAge(28);

        Person person4 = new Person();
        person4.setName("Bob Johnson");
        person4.setAge(35);

        // Сохранение объектов в базе данных
        session.save(person1);
        session.save(person2);
        session.save(person3);
        session.save(person4);

        // Фиксация транзакции
        transaction.commit();

        // Закрытие сессии
        session.close();
        sessionFactory.close();

        System.out.println("Persons saved to the database.");
    }
}
