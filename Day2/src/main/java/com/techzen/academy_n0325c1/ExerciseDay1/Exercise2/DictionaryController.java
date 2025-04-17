package com.techzen.academy_n0325c1.ExerciseDay1.Exercise2;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DictionaryController {
    private final Map<String, String> dictionaryMap = Map.ofEntries(
            /**
             * Map.entry() là một phương thức tiện ích (utility method)
             * giúp tạo một đối tượng Map.Entry mà không cần phải tạo một lớp con cho nó.
             * Sử dụng Map.entry() để tạo cặp key-value
             */
            Map.entry("Hello","Xin Chào"),
            Map.entry("Apple","Quả táo"),
            Map.entry("Banana","Quả chuối"),
            Map.entry("Orange","Quả cam"),
            Map.entry("Lemon","Quả chanh"),
            Map.entry("Watermelon","Quả dưa hấy"),
            Map.entry("blueberry","Quả việt quất")
    );

    @GetMapping("/dictionary")
    public ResponseEntity<String> dictionary(@RequestParam(defaultValue = "") String word) {
        // Xử lý nhập vào: Loại bỏ khoảng trắng dư thừa và chuyển chữ hoa thành chữ thường
        String translation = dictionaryMap.get(word.trim().toLowerCase());

        if (translation != null) {
            return ResponseEntity.ok(translation);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy phần tử trong từ điển");
    }
}