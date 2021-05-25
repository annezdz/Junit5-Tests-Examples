package junit5tests;

import org.junit.jupiter.api.*;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class MiscTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void timeout() throws InterruptedException {
        System.out.println("This is the test with the timeout");
        Thread.sleep(6000);
    }

    @Test
    @Timeout(1)
    @DisplayName("This is a nice method")
    @Tag("theTag")
    void annotatedMethod1(){
        System.out.println("This is the annotate method");
    }

    void annotatedMethod2() throws InterruptedException {
        System.out.println("This is the custom annotaded method");
        Thread.sleep(3000);
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest{
        void beforeAll(){
            System.out.println("Before all in nested test");
        }

        @Test
        void nestedTestMethod(){
            System.out.println("Nested test method");
        }
    }
}
