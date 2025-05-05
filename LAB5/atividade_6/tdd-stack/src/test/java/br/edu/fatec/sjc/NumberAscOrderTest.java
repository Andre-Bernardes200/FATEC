package br.edu.fatec.sjc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberAscOrderTest {

    @Test
    public void testSortWithSixNumbers() throws StackFullException {
        CustomStack<Integer> stack = new CustomStack<>(6, value -> value);
        stack.push(45);
        stack.push(7);
        stack.push(29);
        stack.push(13);
        stack.push(60);
        stack.push(22);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);
        List<Integer> sorted = sorter.sort();

        assertEquals(List.of(7, 13, 22, 29, 45, 60), sorted);
    }

    @Test
    public void testSortWithEmptyStack() {
        CustomStack<Integer> emptyStack = new CustomStack<>(6, value -> value);
        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(emptyStack);
        List<Integer> sorted = sorter.sort();

        assertTrue(sorted.isEmpty(), "A lista ordenada deve estar vazia");
    }
}
