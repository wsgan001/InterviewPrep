package org.practice.javaFundas.designPatterns.elevator;

import org.practice.javaFundas.designPatterns.elevator.enums.*;

import java.util.*;

public class Elevator {
    private float location = 0;
    private Direction direction = Direction.UP;
    private State state = State.STOPPED;
    private Door door = Door.CLOSED;
    private Thread processingThread;
    private Thread listeningThread;

    public class Request {
        public long time;
        public Integer floor;
        public Direction direction;

        public Request(long time, Integer floor, Direction direction) {
            this.time = time;
            this.floor = floor;
            this.direction = direction;
        }
    }

    public Comparator<Request> upComparator = new Comparator<Request>() {
        @Override
        public int compare(Request o1, Request o2) {
            return o1.floor.compareTo(o2.floor);
        }
    };

    public Comparator<Request> downComparator = new Comparator<Request>() {
        @Override
        public int compare(Request o1, Request o2) {
            return o2.floor.compareTo(o1.floor);
        }
    };

    private Queue<Request> upQueue = new PriorityQueue<Request>((Collection<? extends Request>) upComparator);
    private Queue<Request> currentQueue = upQueue;
    // private Queue<Request> downQueue = new PriorityQueue<Request>(downComparator);
}
