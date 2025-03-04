package hu.valyis.progenv;

import hu.valyis.progenv.config.AppConfig;
import hu.valyis.progenv.model.Car;
import hu.valyis.progenv.persistence.*;
import hu.valyis.progenv.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import hu.valyis.progenv.util.DBInitializer;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome! This is the CarRental app.");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DBInitializer dbinit = context.getBean(DBInitializer.class);
        dbinit.initializeDB();
        CarDAO carDAO = context.getBean(CarDAO.class);
        Car myOldCar = new Car(100,"Ford","Escort",2000,"EEF257",
                100,true,5);
        CarService carService = context.getBean(CarService.class);
        try {
            carService.addCar(myOldCar);
            System.out.println(new CustomerDAO().getAllCustomers().getFirst().toString());
            System.out.println(new CustomerDAO().getAllCustomers().getLast().toString());
            System.out.println(carDAO.getAllCars().getFirst());
            System.out.println(carDAO.getAllCars().getLast());
            System.out.println(new RentalEventDAO().getAllRentalEvents().getFirst());
            System.out.println(new RentalEventDAO().getAllRentalEvents().getLast());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}