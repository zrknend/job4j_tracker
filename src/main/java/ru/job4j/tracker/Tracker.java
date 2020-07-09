package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public boolean delete(int id) {
        int index = -1;
        index = indexOf(id);
        System.arraycopy(items, index + 1, items, index, size - index);
        items[size - 1] = null;
        size--;
        return index != -1;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public boolean replace(int id, Item item) {
        int index = -1;
        index = indexOf(id);
        item.setId(ids++);
        items[index] = item;
        return index != -1;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int sizeMass = 0;
        Item[] namesKey = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i].equals(key)) {
                namesKey[sizeMass] = items[i];
                sizeMass++;
            }
        }
        namesKey = Arrays.copyOf(namesKey, sizeMass);
        return namesKey;
    }
}