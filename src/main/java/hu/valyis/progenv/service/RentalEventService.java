package hu.valyis.progenv.service;

import hu.valyis.progenv.model.Car;
import hu.valyis.progenv.model.RentalEvent;
import hu.valyis.progenv.persistence.CarDAO;
import hu.valyis.progenv.persistence.RentalEventDAO;

import java.sql.SQLException;
import java.util.List;

public class RentalEventService {
    private RentalEventDAO rentalEventDAO = new RentalEventDAO();
    private CarDAO carDAO = new CarDAO();

    /**
     * Rents a car by creating a rental event.
     * The DAO checks the car's availability and marks it as rented.
     */
    public boolean rentCar(RentalEvent rentalEvent) throws SQLException {
        return rentalEventDAO.createRentalEvent(rentalEvent);
    }

    /**
     * Returns a car by marking the rental event as closed and setting the car's availability to true.
     */
    public void returnCar(int rentalEventId) throws SQLException {
        RentalEvent rentalEvent = rentalEventDAO.getRentalEventById(rentalEventId);
        if (rentalEvent == null) {
            throw new SQLException("Rental event not found.");
        }
        if (rentalEvent.isClosed()) {
            throw new SQLException("Rental event is already closed.");
        }
        rentalEvent.setClosed(true);
        rentalEventDAO.updateRentalEvent(rentalEvent);

        // Mark the car as available
        Car car = carDAO.getCarById(rentalEvent.getCarId());
        if (car != null) {
            car.setAvailable(true);
            carDAO.updateCar(car);
        }
    }

    public RentalEvent getRentalEventById(int id) throws SQLException {
        return rentalEventDAO.getRentalEventById(id);
    }

    public List<RentalEvent> getAllRentalEvents() throws SQLException {
        return rentalEventDAO.getAllRentalEvents();
    }

    public void updateRentalEvent(RentalEvent rentalEvent) throws SQLException {
        rentalEventDAO.updateRentalEvent(rentalEvent);
    }

    public void deleteRentalEvent(int id) throws SQLException {
        rentalEventDAO.deleteRentalEvent(id);
    }
}
