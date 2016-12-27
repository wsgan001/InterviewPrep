package org.practice.javaFundas.designPatterns.parking;

/**
 * Created by priyasingh on 12/12/15.
 */
public class Slot {
    private boolean isOccupied;
    private int slotNumber;


    Slot(int slotNumber) {
        isOccupied = false;
        this.slotNumber = slotNumber;
    }

    boolean isOccupied() {
        return isOccupied;
    }

    int getSlotNumber() {
        return slotNumber;
    }

    void park() {
        isOccupied = true;
    }

    void unPark() {
        isOccupied = false;
    }

    @Override
    public boolean equals(Object o) {
        return (((Slot) o).slotNumber == this.slotNumber);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.slotNumber;
        return hash;
    }
}
