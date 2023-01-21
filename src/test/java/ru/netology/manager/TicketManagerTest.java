package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    TicketInfo ticket1 = new TicketInfo(01, 23_450, "DME", "OMS");
    TicketInfo ticket2 = new TicketInfo(02, 13_000, "REN", "ROV");
    TicketInfo ticket3 = new TicketInfo(03, 3_400, "YKS", "SVO");
    TicketInfo ticket4 = new TicketInfo(04, 3_400, "KGD", "VKO");
    TicketInfo ticket5 = new TicketInfo(05, 15_300, "DME", "OMS");
    TicketInfo ticket6 = new TicketInfo(06, 12_400, "DME", "OMS");
    TicketInfo ticket7 = new TicketInfo(07, 5_300, "DME", "SVO");

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
    }

    @Test
    public void findTestFromAirportToAirportThreeTicket() {

        TicketInfo[] expected = {ticket6, ticket5, ticket1};
        TicketInfo[] actual = manager.findAll("DME", "OMS");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findTestFromAirportToAirportOneTicket() {

        TicketInfo[] expected = {ticket4};
        TicketInfo[] actual = manager.findAll("KGD", "VKO");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findTestFromAirportToAirportNullTicket() {

        TicketInfo[] expected = {};
        TicketInfo[] actual = manager.findAll("KGD", "RDV");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void compareTOTicketOne() {

        System.out.println(ticket2.compareTo(ticket4));

    }

    @Test
    public void compareTOTicketNull() {

        System.out.println(ticket4.compareTo(ticket3));

    }

    @Test
    public void compareTOTicketMinOne() {

        System.out.println(ticket6.compareTo(ticket1));

    }

}
