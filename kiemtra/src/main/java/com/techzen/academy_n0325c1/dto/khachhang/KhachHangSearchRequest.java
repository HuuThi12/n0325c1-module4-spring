package com.techzen.academy_n0325c1.dto.khachhang;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhachHangSearchRequest {
    String tenKhachHang = "";
    String soDienThoai;
    String Email;
}
