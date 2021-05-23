package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTestsMethodSource {

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_StringWithList(String param1){
        System.out.println("param1 = " + param1);
    }

    /*
    Using  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    Dont need to specify the static attribute for this parameter values
     */

    List<String> sourceString(){
        //processing none here
    return Arrays.asList("tomato","carrot","cabbage");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsSteam")
    void methodSource_StringWithStream(String param1){
        System.out.println("param1 = " + param1);
    }

    Stream<String> sourceStringAsSteam(){
        //processing
        return Stream.of("beetroot","apple","pear");
    }

    List<Arguments> sourceList_StringDouble(){
        //processing
        return Arrays.asList(
                arguments("tomato",2.0),
                arguments("carrot",5.2),
                arguments("cabbage",7.8));
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
}
