package com.techzen.academy_n0325c1.Bai9.dto.student;

import com.techzen.academy_n0325c1.Bai9.constraint.DobConstraint;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "[a-zA-ZÀ-ỹ ]+", message = "Tên không được chứa ký tự đặc biệt")
    @Length(min = 3, message = "Tên phải lớn hơn 3 ký tự")
    String fullName;

    String email;
    String phone;

    @NotNull(message = "Ngày sinh là bắt buộc")
    @DobConstraint(min = 18, message = "Bạn chưa đủ tuổi")
    LocalDate dob;

    @Valid
    @NotNull(message = "Bắt buộc chọn thẻ cho sinh viên")
    Integer cardId;
}