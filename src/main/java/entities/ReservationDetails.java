package entities;


public class ReservationDetails {

    private String place;
    private int checkInDate;
    private int checkOutDate;
    private int startingAfterDays;
    private int vacationDaysNumber;
    private int numberOfAdults;
    private int numberOfKids;

    public int getStartingAfterDays() {
        return startingAfterDays;
    }

    public void setStartingAfterDays(int startingAfterDays) {
        this.startingAfterDays = startingAfterDays;
    }

    public int getVacationDaysNumber() {
        return vacationDaysNumber;
    }

    public void setVacationDaysNumber(int vacationDaysNumber) {
        this.vacationDaysNumber = vacationDaysNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(int checkInDate)
    {
        this.checkInDate = checkInDate;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(int checkOutDate)
    {
     this.checkOutDate = checkOutDate;

    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfKids() {
        return numberOfKids;
    }

    public void setNumberOfKids(int numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                ", place='" + place + '\'' +
                ", checkin='" + checkInDate + '\'' +
                ", checkout='" + checkOutDate + '\'' +
                ", adults=" + numberOfAdults +
                ", kids=" + numberOfKids +
                "}";
    }

}
