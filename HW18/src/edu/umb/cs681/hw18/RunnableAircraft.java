package edu.umb.cs681.hw18;

import java.util.LinkedList;
import java.util.concurrent.*;

public class RunnableAircraft implements Runnable{

    @Override
    public void run() {

        Aircraft aircraft = new Aircraft(new Position(70.2,56.4,20000));
        System.out.println("Aircraft's initial position: "+ aircraft.getPosition());

        //Latitude change
        aircraft.setPosition(aircraft.getPosition().changeLat(85.4));
        System.out.println("Aircraft's new latitude: "+ aircraft.getPosition().getLatitude());

        //Longitude change
        aircraft.setPosition(aircraft.getPosition().changeLon(78.9));
        System.out.println("Aircraft's new longitude: "+ aircraft.getPosition().getLongitude());

        //Altitude change
        aircraft.setPosition(aircraft.getPosition().changeAlt(15000));
        System.out.println("Aircraft's new altitude: "+ aircraft.getPosition().getAltitude());

        //New position
        System.out.println("Aircraft's new position: "+ aircraft.getPosition());

    }

    public static void main(String[] args) {

        RunnableAircraft aircraft = new RunnableAircraft();

        ExecutorService executor = Executors.newFixedThreadPool(6);

        executor.execute(aircraft);

        executor.shutdown();

    }

}
