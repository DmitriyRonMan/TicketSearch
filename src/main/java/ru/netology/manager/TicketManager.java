package ru.netology.manager;

import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {

        this.repository = repository;
    }

    public void add(TicketInfo ticket) {

        repository.addTicketInfo(ticket);
    }

    public TicketInfo[] AllTickets() {

        return repository.getItems();
    }

    public TicketInfo[] findAll(String departAirport, String arrivalAirport) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo ticket : repository.getItems()) {
            if (ticket.getDepartAirport().equals(departAirport) && ticket.getArrivalAirport().equals(arrivalAirport)) {
                TicketInfo[] tmp = new TicketInfo[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
