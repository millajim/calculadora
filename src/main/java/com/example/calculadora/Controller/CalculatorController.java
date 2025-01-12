package com.example.calculadora.Controller;

import com.example.calculadora.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @GetMapping
    public String showCalculator() {
        return "diseño"; // Nombre del archivo sin la extensión .html
    }

    @GetMapping("/add")
    @ResponseBody
    public Object add(@RequestParam double a, @RequestParam double b) {
        return formatResult(calculator.add(a, b));
    }

    @GetMapping("/subtract")
    @ResponseBody
    public Object subtract(@RequestParam double a, @RequestParam double b) {
        return formatResult(calculator.subtract(a, b));
    }

    @GetMapping("/multiply")
    @ResponseBody
    public Object multiply(@RequestParam double a, @RequestParam double b) {
        return formatResult(calculator.multiply(a, b));
    }

    @GetMapping("/divide")
    @ResponseBody
    public Object divide(@RequestParam double a, @RequestParam double b) {
        return formatResult(calculator.divide(a, b));
    }

    private Object formatResult(double result) {
        // Verifica si el resultado es un número entero
        if (result == (int) result) {
            return (int) result; // Devuelve como int si es exacto
        }
        return result; // Devuelve como double si no es exacto
    }

}
