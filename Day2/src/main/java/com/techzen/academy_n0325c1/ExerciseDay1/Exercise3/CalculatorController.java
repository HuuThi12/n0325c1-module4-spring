package com.techzen.academy_n0325c1.ExerciseDay1.Exercise3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    // http://localhost:8080/calculator?firstNumber=5&secondNumber=3&operator=+
    @GetMapping("/calculator")
    public ResponseEntity<String> calculator(
            @RequestParam(value = "firstNumber", defaultValue = "") String firstNumberStr,
            @RequestParam(value = "secondNumber", defaultValue = "") String secondNumberStr,
            @RequestParam(value = "operator", defaultValue = "") String operator) {

        // Kiểm tra đầu vào
        if (firstNumberStr.isEmpty()) {
            return ResponseEntity.badRequest().body("First number cannot be empty");
        } else if (secondNumberStr.isEmpty()) {
            return ResponseEntity.badRequest().body("Second number cannot be empty");
        } else if (!isDouble(firstNumberStr)) {
            return ResponseEntity.badRequest().body("First number must be numeric");
        } else if (!isDouble(secondNumberStr)) {
            return ResponseEntity.badRequest().body("Second number must be numeric");
        }

        double firstNumber = Double.parseDouble(firstNumberStr);
        double secondNumber = Double.parseDouble(secondNumberStr);
        double result;

        // Khi run phép toán + không sử dụng được
        switch (operator) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> {
                if (secondNumber == 0) {
                    // Không được phép chia cho 0
                    return ResponseEntity.badRequest().body("Division by zero is not allowed");
                }
                result = firstNumber / secondNumber;
            }
            default -> {
                // Invalid operator = Toán tử không hợp lệ
                return ResponseEntity.badRequest().body("Invalid operator");
            }

        }

        return ResponseEntity.ok("Result: " + result);
    }

    // Kiểm tra là số thực
    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
