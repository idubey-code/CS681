package edu.umb.cs681.hw10;

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

        for(int i=0; i<7; i++) {
            Thread t = new Thread(new RunnableAircraft());
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
