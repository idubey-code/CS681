package edu.umb.cs681.hw4;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

    public RunnablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void run() {
        generatePrimes();
    }

    public static void main(String[] args) {
//        Generation with 1 thread
        RunnablePrimeGenerator gen = new RunnablePrimeGenerator(1L, 2000000L);
        Thread t = new Thread(gen);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Process interrupted");
        }

        gen.getPrimes().forEach( (Long prime)-> System.out.println(prime + ", ") );
        long primeNum = gen.getPrimes().size();
        System.out.println("\n" + primeNum + " prime numbers are found in total.");
        System.out.println("----------------------------------------------------");

//        Generation with 2 threads
        RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(1L, 1000000L);
        RunnablePrimeGenerator gen2 = new RunnablePrimeGenerator(1000001L, 2000000L);
        Thread t1 = new Thread(gen1);
        Thread t2 = new Thread(gen2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Process interrupted");
        }

        gen1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );

        long primeNum1 = gen1.getPrimes().size() + gen2.getPrimes().size();
        System.out.println("\n" + primeNum1 + " prime numbers are found in total.");
        System.out.println("----------------------------------------------------");

//        Generation with 4 threads
        RunnablePrimeGenerator gen3 = new RunnablePrimeGenerator(1L, 500000L);
        RunnablePrimeGenerator gen4 = new RunnablePrimeGenerator(500001L, 1000000L);
        RunnablePrimeGenerator gen5 = new RunnablePrimeGenerator(1000001L, 1500000L);
        RunnablePrimeGenerator gen6 = new RunnablePrimeGenerator(1500001L, 2000000L);
        Thread t3 = new Thread(gen3);
        Thread t4 = new Thread(gen4);
        Thread t5 = new Thread(gen5);
        Thread t6 = new Thread(gen6);
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        try {
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            System.out.println("Process interrupted");
        }

        gen3.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen4.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen5.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen6.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );

        long primeNum2 = gen3.getPrimes().size() + gen4.getPrimes().size() + gen5.getPrimes().size() +
                gen6.getPrimes().size();
        System.out.println("\n" + primeNum2 + " prime numbers are found in total.");
        System.out.println("----------------------------------------------------");

//        Generation with 8 threads
        RunnablePrimeGenerator gen7  = new RunnablePrimeGenerator(1L, 250000L);
        RunnablePrimeGenerator gen8  = new RunnablePrimeGenerator(250000L, 500000L);
        RunnablePrimeGenerator gen9  = new RunnablePrimeGenerator(500000L,750000L);
        RunnablePrimeGenerator gen10 = new RunnablePrimeGenerator(750000L, 1000000L);
        RunnablePrimeGenerator gen11 = new RunnablePrimeGenerator(1000000L, 1250000L);
        RunnablePrimeGenerator gen12 = new RunnablePrimeGenerator(1250000L, 1500000L);
        RunnablePrimeGenerator gen13 = new RunnablePrimeGenerator(1500000L,1750000L);
        RunnablePrimeGenerator gen14 = new RunnablePrimeGenerator(1750000L, 2000000L);

        Thread t7  = new Thread(gen7);
        Thread t8  = new Thread(gen8);
        Thread t9  = new Thread(gen9);
        Thread t10 = new Thread(gen10);
        Thread t11 = new Thread(gen11);
        Thread t12 = new Thread(gen12);
        Thread t13 = new Thread(gen13);
        Thread t14 = new Thread(gen14);

        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();

        try {
            t7.join();
            t8.join();
            t9.join();
            t10.join();
            t11.join();
            t12.join();
            t13.join();
            t14.join();
        } catch (InterruptedException e) {
            System.out.println("Process interrupted");
        }

        gen7.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen8.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen9.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen10.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen11.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen12.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen13.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen14.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );

        long primeNum3 = gen7.getPrimes().size() + gen8.getPrimes().size() + gen9.getPrimes().size() +
                gen10.getPrimes().size() + gen11.getPrimes().size() + gen12.getPrimes().size() +
                gen13.getPrimes().size() + gen14.getPrimes().size();
        System.out.println("\n" + primeNum3 + " prime numbers are found in total.");
        System.out.println("----------------------------------------------------");

    }
}
