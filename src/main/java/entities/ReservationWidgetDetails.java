package entities;

import utils.MonthsEnum;

import java.time.LocalDate;

public class ReservationWidgetDetails {

    private String place;
    private String checkInDate;
    private String checkOutDate;
    private int startingAfterDays;
    private int vacationDaysNumber;
    private int addNumberOfAdults;
    private int addNumberOfKids;
    private LocalDate today = LocalDate.now();

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

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate()
    {
        LocalDate localDateTime = today.plusDays(getStartingAfterDays());
        this.checkInDate = localDateTime.toString();
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate)
    {
        LocalDate checkOutDateCalculation = today.plusDays(getStartingAfterDays()).plusDays(getVacationDaysNumber());
        this.checkOutDate = checkOutDateCalculation.toString().split("-")[0];

    }

    public int getAddNumberOfAdults() {
        return addNumberOfAdults;
    }

    public void setAddNumberOfAdults(int addNumberOfAdults) {
        this.addNumberOfAdults = addNumberOfAdults;
    }

    public int getAddNumberOfKids() {
        return addNumberOfKids;
    }

    public void setAddNumberOfKids(int addNumberOfKids) {
        this.addNumberOfKids = addNumberOfKids;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                ", place='" + place + '\'' +
                ", checkin='" + checkInDate + '\'' +
                ", checkout='" + checkOutDate + '\'' +
                ", adults=" + addNumberOfAdults +
                ", kids=" + addNumberOfKids +
                "}";
    }

}
