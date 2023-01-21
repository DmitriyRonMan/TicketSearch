package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInfo;

public class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    TicketInfo ticket1 = new TicketInfo(01, 23_450, "DME", "GRV");
    TicketInfo ticket2 = new TicketInfo(02, 13_000, "REN", "ROV");
    TicketInfo ticket3 = new TicketInfo(03, 27_750, "YKS", "SVO");
    TicketInfo ticket4 = new TicketInfo(04, 3_400, "KGD", "VKO");
    TicketInfo ticket5 = new TicketInfo(05, 15_300, "EGO", "OMS");

    @Test
    public void addTicketTest() {
        repository.addTicketInfo(ticket1);
        repository.addTicketInfo(ticket2);
        repository.addTicketInfo(ticket3);
        repository.addTicketInfo(ticket4);
        repository.addTicketInfo(ticket5);

        TicketInfo[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        TicketInfo[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTicketTestMin() {
        repository.addTicketInfo(ticket1);

        TicketInfo[] expected = {ticket1};
        TicketInfo[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTicketTestWithin() {
        repository.addTicketInfo(ticket1);
        repository.addTicketInfo(ticket3);
        repository.addTicketInfo(ticket5);

        TicketInfo[] expected = {ticket1, ticket3, ticket5};
        TicketInfo[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTicketTestMax() {
        repository.addTicketInfo(ticket1);
        repository.addTicketInfo(ticket2);
        repository.addTicketInfo(ticket3);
        repository.addTicketInfo(ticket4);
        repository.addTicketInfo(ticket5);
        repository.removeById(1);
        repository.removeById(2);
        repository.removeById(3);
        repository.removeById(4);
        repository.removeById(5);

        TicketInfo[] expected = {};
        TicketInfo[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTicketTestMin() {
        repository.addTicketInfo(ticket1);
        repository.addTicketInfo(ticket2);
        repository.addTicketInfo(ticket3);
        repository.addTicketInfo(ticket4);
        repository.addTicketInfo(ticket5);
        repository.removeById(1);

        TicketInfo[] expected = {ticket2, ticket3, ticket4, ticket5};
        TicketInfo[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTicketTestWithin() {
        repository.addTicketInfo(ticket1);
        repository.addTicketInfo(ticket2);
        repository.addTicketInfo(ticket3);
        repository.addTicketInfo(ticket4);
        repository.addTicketInfo(ticket5);
        repository.removeById(1);
        repository.removeById(4);

        TicketInfo[] expected = {ticket2, ticket3, ticket5};
        TicketInfo[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIDTicketTestAll() {
        repository.addTicketInfo(ticket1);
        repository.addTicketInfo(ticket2);
        repository.addTicketInfo(ticket3);
        repository.addTicketInfo(ticket4);
        repository.addTicketInfo(ticket5);

        TicketInfo[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        TicketInfo[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIDTicketTestMin() {
        repository.addTicketInfo(ticket1);

        TicketInfo[] expected = {ticket1};
        TicketInfo[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
