package ru.unclediga.spec.service;

import javax.ejb.Stateless;

@Stateless
public class CalcService {
    public int calculate(int a, int b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '*':
                return a * b;
            case '-':
                return a - b;
            case '/':
                return a / b;
        }
        return -1;
    }
}
