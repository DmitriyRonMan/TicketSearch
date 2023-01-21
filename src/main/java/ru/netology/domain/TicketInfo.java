package ru.netology.domain;

public class TicketInfo implements Comparable<TicketInfo> {
    private int id;
    private int price;
    private String departAirport;
    private String arrivalAirport;

    public TicketInfo(int id, int price, String departAirport, String arrivalAirport) {
        this.id = id;
        this.price = price;
        this.departAirport = departAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public int getId() {

        return id;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public String getDepartAirport() {

        return departAirport;
    }

    public String getArrivalAirport() {

        return arrivalAirport;
    }

    @Override
    public int compareTo(TicketInfo o) {
        if (this.getPrice() < o.getPrice()) {
            return -1;
        } else if (this.getPrice() > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
