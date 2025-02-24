package hu.valyis.progenv.service;

import hu.valyis.progenv.model.Car;
import hu.valyis.progenv.persistence.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarDAO carDAO;

    public void addCar(Car car) throws SQLException {
        carDAO.createCar(car);
    }

    public Car getCarById(int id) throws SQLException {
        return carDAO.getCarById(id);
    }

    public List<Car> getAllCars() throws SQLException {
        return carDAO.getAllCars();
    }

    public void updateCar(Car car) throws SQLException {
        carDAO.updateCar(car);
    }

    public void deleteCar(int id) throws SQLException {
        carDAO.deleteCar(id);
    }

    /**
     * Searches cars based on filtering conditions:
     * - numberOfSeats between minSeats and maxSeats
     * - rentalPricePerDay less than or equal to maxPrice
     * - matching brand and model.
     */
    public List<Car> searchCars(int minSeats, int maxSeats, double maxPrice, String brand, String model) throws SQLException {
        return carDAO.searchCars(minSeats, maxSeats, maxPrice, brand, model);
    }
}
