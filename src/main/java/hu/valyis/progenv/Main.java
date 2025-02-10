package hu.valyis.progenv;

import hu.valyis.progenv.model.RentalEvent;
import hu.valyis.progenv.persistence.CarDAO;
import hu.valyis.progenv.persistence.CustomerDAO;
import hu.valyis.progenv.persistence.RentalEventDAO;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

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