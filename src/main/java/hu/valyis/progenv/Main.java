package hu.valyis.progenv;

import hu.valyis.progenv.persistence.CarDAO;
import hu.valyis.progenv.persistence.CustomerDAO;
import hu.valyis.progenv.persistence.RentalEventDAO;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome! This is the CarRental app.");

        new hu.valyis.progenv.util.DBInitializer().initializeDB();
        try {
            System.out.println(new CustomerDAO().getAllCustomers().getFirst());
            System.out.println(new CustomerDAO().getAllCustomers().getLast());
            System.out.println(new CarDAO().getAllCars().getFirst());
            System.out.println(new CarDAO().getAllCars().getLast());
            System.out.println(new RentalEventDAO().getAllRentalEvents().getFirst());
            System.out.println(new RentalEventDAO().getAllRentalEvents().getLast());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}