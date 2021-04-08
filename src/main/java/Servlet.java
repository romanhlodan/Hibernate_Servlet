import entity.Car;
import entity.Passport;
import entity.Person;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connect");
        EntityManager manager = entityManagerFactory.createEntityManager();

//        Person roman = Person.builder().age(24).name("Roman").build();
//        Person ivan = Person.builder().name("Ivan").age(25).build();
//        Person olya = Person.builder().age(19).name("Olya").build();
//        Person lida = Person.builder().name("Lida").age(20).build();
//        Person petro = Person.builder().age(23).name("Petro").build();
//        Person katia = Person.builder().name("Katia").age(22).build();
//
//        Passport passport1 = Passport.builder().serialNumber("ED43684").build();
//        Passport passport2 = Passport.builder().serialNumber("LF44322").build();
//        Passport passport3 = Passport.builder().serialNumber("LF43112").build();
//        Passport passport4 = Passport.builder().serialNumber("VF54098").build();
//        Passport passport5 = Passport.builder().serialNumber("FR32189").build();
//        Passport passport6 = Passport.builder().serialNumber("OI76903").build();

//        Car opel = Car.builder().brand("Opel").model("Astra J").graduation_year(2012).build();
//        Car reno = Car.builder().brand("Renault").model("Megane 4").graduation_year(2017).build();
//        Car kia = Car.builder().brand("KIA").model("Ceed 2").graduation_year(2015).build();
//        Car bmw = Car.builder().brand("BMW").model("520").graduation_year(2008).build();
//        Car audi = Car.builder().brand("Audi").model("A7").graduation_year(2011).build();
//        Car jeep = Car.builder().brand("Jeep").model("Grand Cheroki").graduation_year(2019).build();
//        Car vw = Car.builder().brand("VW").model("Golf 7").graduation_year(2014).build();
//        Car mers = Car.builder().brand("Mers").model("S500").graduation_year(2018).build();
//        Car mini = Car.builder().brand("Mini").model("Cuntreman").graduation_year(2010).build();

//        manager.persist(roman);
//        manager.persist(ivan);
//        manager.persist(olya);
//        manager.persist(petro);
//        manager.persist(lida);
//        manager.persist(katia);
//
//        manager.persist(passport1);
//        manager.persist(passport2);
//        manager.persist(passport3);
//        manager.persist(passport4);
//        manager.persist(passport5);
//        manager.persist(passport6);

//        Person person = manager.find(Person.class, 1);
//        Car car = manager.find(Car.class, 2);
//        manager.persist(opel);
//        manager.persist(reno);
//        opel.setPerson(person);
//        car.setPerson(person);

//        Person person1 = manager.find(Person.class, 2);
//        manager.persist(jeep);
//        jeep.setPerson(person1);
//
//        Person person2 = manager.find(Person.class, 3);
//        manager.persist(audi);
//        manager.persist(vw);
//        audi.setPerson(person2);
//        vw.setPerson(person2);
//
//        Person person3 = manager.find(Person.class, 4);
//        manager.persist(bmw);
//        manager.persist(mers);
//        bmw.setPerson(person3);
//        mers.setPerson(person3);
//
//        Person person4 = manager.find(Person.class, 5);
//        manager.persist(kia);
//        kia.setPerson(person4);
//
//        Person person5 = manager.find(Person.class, 6);
//        manager.persist(mini);
//        mini.setPerson(person5);

//        Person person = manager.find(Person.class, 1);
//        Passport passport = manager.find(Passport.class, 1);
//        passport.setPerson(person);
//
//        Person person1 = manager.find(Person.class, 2);
//        Passport passport1 = manager.find(Passport.class, 2);
//        passport1.setPerson(person1);
//
//        Person person2 = manager.find(Person.class, 3);
//        Passport passport2 = manager.find(Passport.class, 3);
//        passport2.setPerson(person2);
//
//        Person person3 = manager.find(Person.class, 4);
//        Passport passport3 = manager.find(Passport.class, 4);
//        passport3.setPerson(person3);
//
//        Person person4 = manager.find(Person.class, 5);
//        Passport passport4 = manager.find(Passport.class, 5);
//        passport4.setPerson(person4);
//
//        Person person5 = manager.find(Person.class, 6);
//        Passport passport5 = manager.find(Passport.class, 6);
//        passport5.setPerson(person5);

        List<Person> people = manager.createQuery("select distinct p from Person p left join fetch p.cars", Person.class).getResultList();
        List<Passport> passport = manager.createQuery("select p from Passport p", Passport.class).getResultList();
        List<Car> cars = manager.createQuery("select c from Car c", Car.class).getResultList();

        manager.getTransaction().begin();


        String pathInfo = req.getPathInfo();
        String replace = pathInfo.replace("/", "");
        int id = Integer.parseInt(replace);
        Passport passports = passport.get(id-1);
        Person person = people.get(id-1);
        List<Car> cars1 = person.getCars();
        for (Car car : cars1) {
            int id1 = car.getId();
            Car car1 = cars.get(id1 - 1);
            req.setAttribute("car", car1);
        }

        req.setAttribute("person",person);
        req.setAttribute("passport",passports);
        req.getRequestDispatcher("/pages/persons.jsp").forward(req,resp);


        manager.getTransaction().commit();
        manager.close();
        entityManagerFactory.close();
    }

}
