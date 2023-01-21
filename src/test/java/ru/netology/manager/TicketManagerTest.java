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
    TicketInfo ticket3 = new TicketInfo(03, 27_750, "YKS", "SVO");
    TicketInfo ticket4 = new TicketInfo(04, 3_400, "KGD", "VKO");
    TicketInfo ticket5 = new TicketInfo(05, 15_300, "DME", "OMS");

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void findTestFromAirportToAirportMinNull() {

        TicketInfo[] expected = {ticket5, ticket1};
        TicketInfo[] actual = manager.findAll("DME", "OMS");

        System.out.println(ticket5.compareTo(ticket1));

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findTestFromAirportToAirportMaxNull() {

        System.out.println(ticket2.compareTo(ticket4));

    }

}
