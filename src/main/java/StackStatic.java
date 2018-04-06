import java.util.Arrays;
import java.util.EmptyStackException;

public class StackStatic<T> {

    /*
    it should be generic
    the size should be given in the constructor (no default constructor allowed)
    push functionality (when I add an item to the stack)
    pop functionality (when I remove an item)
    peek functionality (I can receive the top item without removing it from the stack, so it's peeking)
    I want to be able to get the size of the stack (I mean the maximum capacity)
    And write me a method which gives back the number of free spaces left
    throw an exception when the stack is full and I want to add one more item
    throw an exception when the stack is empty and I want to pop an item
    Unit tests!!
     */

    private int size;
    private T[] container;
    private int currentPosition;

    public StackStatic(int size){
        this.size = size;
        this.container = (T[]) new Object[size];
        this.currentPosition = 0;
    }


    public void push(T item){
        if(currentPosition < size){
            container[currentPosition] = item;
            currentPosition += 1;
        }
        else throw new StackOverflowError("Stack is already tied up!");
    }

//remove an item
    public T pop(){
        if(currentPosition < 1){
            throw new EmptyStackException();
        }
        currentPosition -= 1;
        T topItem = container[currentPosition];
        container[currentPosition] = null;
        return topItem;
    }

    public T peek(){
        if(currentPosition < 1){
            throw new EmptyStackException();
        }
        T topItem = container[currentPosition-1];
        return topItem;
    }

    public Integer getSize(){
        return size;
    }

    public Integer numOfFreeSpaces(){
        return (size - currentPosition);
    }

    @Override
    public String toString() {
        return "StackStatic{" +
                "size=" + size +
                ", container=" + Arrays.toString(container) +
                ", currentPosition=" + currentPosition +
                '}';
    }

    public static void main(String args[]){
        StackStatic<Integer> stack = new StackStatic<Integer>(10);
        Integer num = 5;
        stack.push((num));
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);

        StackStatic<Integer> emptyStack = new StackStatic<Integer>(0);
        emptyStack.pop();

    }


}
