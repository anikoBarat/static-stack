import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackStaticTest {

    private StackStatic<Integer> stack;


    @BeforeEach
    void init(){
        stack = new StackStatic<Integer>(10);
    }

    @Test
    void testConstructor(){
        assertNotNull(stack);
    }

    @Test
    void testPush(){
        Integer num = 5;
        stack.push(num);
        assertEquals((Integer)5, stack.peek());
    }

    @Test
    void testPop(){
        Integer num = 10;
        stack.push(num);
        assertEquals((Integer)10, stack.pop());
        assertEquals((Integer)10, stack.numOfFreeSpaces());
    }

    @Test
    void testPeek(){
        Integer num = 10;
        stack.push(num);
        stack.peek();
        assertEquals((Integer)10, stack.peek());
        assertEquals((Integer)9, stack.numOfFreeSpaces());

    }

    @Test
    void testGetSize(){

        Integer num = 10;
        Integer num2 = 15;
        Integer num3 = 20;

        stack.push(num);
        stack.push(num2);
        stack.push(num3);

        assertEquals((Integer)10, stack.getSize());
    }

    @Test
    void testNumOfFreeSpaces(){
        Integer num = 10;
        Integer num2 = 15;
        Integer num3 = 20;

        stack.push(num);
        stack.push(num2);
        stack.push(num3);

        assertEquals((Integer)7 , stack.numOfFreeSpaces());
    }



}