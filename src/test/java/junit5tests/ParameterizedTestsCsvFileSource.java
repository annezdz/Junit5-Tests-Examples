package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ParameterizedTestsCsvFileSource {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist.csv",numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringStringWithOneFile(String name, double price,int quantity,
                                                   String measure, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity +
                ", measure = " + measure + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv",
            "src/test/resources/params/shoppinglist2.csv"},numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringStringWithMoreFiles(String name, double price,int quantity,
                                                              String measure, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity +
                ", measure = " + measure + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist3.csv"},numLinesToSkip = 1,
            delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringWithDifferentDelimiter
            (String name, double price,int quantity,
                                                                String measure, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity +
                ", measure = " + measure + ", provider = " + provider);
    }
}
