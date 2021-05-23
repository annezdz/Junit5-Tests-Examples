package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedTestsCsv {


    @ParameterizedTest
    @CsvSource(value = {"steve,rogers","captain,marvel","bucky,barnes"})
    void csvSource_String_String(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true","captain,21,false","bucky,5,true"})
    void csvSource_SringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america, 'steve,rogers'","winter soldier," + "'bucky,barnes'"})
        void csvSource_StringWithComma(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers","bucky?barnes"}, delimiter = '?')
        void csvSource_StringWithDifferentDelimiter(String param1,String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        }


}
