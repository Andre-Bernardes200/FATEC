package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number> {

    private final CustomStack<T> stack;

    public NumberAscOrder(CustomStack<T> stack) {
        this.stack = stack;
    }

    public List<T> sort() {
        if (stack == null || stack.isEmpty()) {
            return new ArrayList<>();
        }

        List<T> numbers = new ArrayList<>();
        while (!stack.isEmpty()) {
            try {
                numbers.add(stack.pop());
            } catch (StackEmptyException e) {
                // Nunca deve acontecer com a verificação acima
                throw new RuntimeException("Erro ao acessar a pilha: " + e.getMessage());
            }
        }

        Collections.sort(numbers, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
        return numbers;
    }
}
