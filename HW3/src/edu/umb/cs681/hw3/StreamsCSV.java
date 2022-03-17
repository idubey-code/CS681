package edu.umb.cs681.hw3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCSV {

    public static void main(String[] args) {

        Path path = Path.of("Data", "PVIData.csv");

        try( Stream<String> lines = Files.lines(path) ){
            List<List<String>> matrix = lines.map(line -> {
                        return Stream.of( line.split(",") )
                                .map(value->value.substring(0, value.length()))
                                .collect( Collectors.toList() ); })
                    .collect( Collectors.toList() );


            List massachusetts = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts")).collect(Collectors.toList());
            String totalCases = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts"))
                    .map((i) -> i.get(6)).reduce("0", (temp, result) -> String.valueOf(Integer.parseInt(temp) + Integer.parseInt(result)));

            List suffolk = matrix.stream().filter((i) -> i.get(5).contains("Suffolk")).collect(Collectors.toList()).get(0);

            List nantucket = matrix.stream().filter((i) -> i.get(5).contains("Nantucket")).collect(Collectors.toList()).get(0);

            float sufIR = Float.parseFloat((String) suffolk.get(8));
            float nanIR = Float.parseFloat((String) nantucket.get(8));

            System.out.println("Total no. of cases in Massachusetts: " + totalCases);
            System.out.println("\nInfection rate in Suffolk County: " + suffolk.get(8));
            System.out.println("\nInfection rate in Nantucket County: " + nantucket.get(8));

            if(sufIR > nanIR){
                System.out.println("\nInfection Rate in Suffolk is "+(sufIR-nanIR)+" times more than Nantucket");
            }else{
                System.out.println("\nInfection Rate in Nantucket is "+(nanIR-sufIR)+" times more than Suffolk");
            }

        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
