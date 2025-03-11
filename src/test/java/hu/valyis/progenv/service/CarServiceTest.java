package hu.valyis.progenv.service;

import hu.valyis.progenv.config.AppConfig;
import hu.valyis.progenv.model.Car;
import hu.valyis.progenv.persistence.CarDAO;
import hu.valyis.progenv.persistence.CustomerDAO;
import hu.valyis.progenv.persistence.RentalEventDAO;
import hu.valyis.progenv.util.DBInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CarServiceTest {
    AnnotationConfigApplicationContext context = null;
    DBInitializer dbinit = null;
    CarDAO carDAO = null;
    CarService carService = null;
    @BeforeEach
    public void initializeCarServiceTests () {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        dbinit = context.getBean(DBInitializer.class);
        dbinit.initializeDB();
        carDAO = context.getBean(CarDAO.class);
        carService = context.getBean(CarService.class);

    }

    @Test
    public void addCarTest() {
        Car myOldCar = new Car(100,"Ford","Escort",2000,"EEF257",
                100,true,5);
        int numberOfCars = 0; int newNumberOfCars = 0;
        try {
            numberOfCars = carService.getAllCars().size();
            carService.addCar(myOldCar);
            newNumberOfCars = carService.getAllCars().size();
        } catch (SQLException e) {
            System.out.println("SQL exception");
        }
        Car myOldCar2 = new Car(101,"Trabant","601",1982,"ABV016",
                100,true,5);
        try {
            // numberOfCars = carService.getAllCars().size();
            carService.addCar(myOldCar2);
            newNumberOfCars = carService.getAllCars().size();
        } catch (SQLException e) {
            System.out.println("SQL exception");
        }
        assertTrue(newNumberOfCars == numberOfCars + 2);


    }


}
