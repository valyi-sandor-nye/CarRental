package hu.valyis.progenv.persistence;

import hu.valyis.progenv.model.Car;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public interface CarDAO {
    void createCar(Car car) throws SQLException;

    Car getCarById(int id) throws SQLException;

    List<Car> getAllCars() throws SQLException;

    void updateCar(Car car) throws SQLException;

    void deleteCar(int id) throws SQLException;

    List<Car> searchCars(int minSeats, int maxSeats, double maxPrice, String brand, String model) throws SQLException;
}
