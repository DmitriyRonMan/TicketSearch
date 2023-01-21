package ru.netology.repository;

import ru.netology.domain.TicketInfo;

public class TicketRepository {
    private TicketInfo[] items = new TicketInfo[0];

    public void addTicketInfo(TicketInfo item) {
        TicketInfo[] tmp = new TicketInfo[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {
        TicketInfo[] tmp = new TicketInfo[items.length - 1];
        int copyToIndex = 0;
        for (TicketInfo item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public TicketInfo[] getItems() {
        return items;
    }

    public TicketInfo[] findAll() {

        return items;
    }
}
