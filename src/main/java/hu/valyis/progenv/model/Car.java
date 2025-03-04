package hu.valyis.progenv.model;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int buildYear;
    private String licensePlate;
    private double rentalPricePerDay;
    private boolean available;
    private int numberOfSeats;

    public Car() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(double rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", buildYear=" + buildYear +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", available=" + available +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }

    public Car(int id, String brand, String model, int buildYear, String licensePlate, double rentalPricePerDay, boolean available, int numberOfSeats) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.buildYear = buildYear;
        this.licensePlate = licensePlate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.available = available;
        this.numberOfSeats = numberOfSeats;
    }
}

