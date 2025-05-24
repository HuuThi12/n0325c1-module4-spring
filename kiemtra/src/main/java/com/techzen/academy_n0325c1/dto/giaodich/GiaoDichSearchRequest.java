package com.techzen.academy_n0325c1.dto.giaodich;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GiaoDichSearchRequest {
    String loaiDichVu;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Date ngayGiaoDich;
    Double donGia;
    Double dienTich;
}
