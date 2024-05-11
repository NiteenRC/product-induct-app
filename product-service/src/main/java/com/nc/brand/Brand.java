package com.nc.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    private Integer id;
    private String brandName;
    private String brandDesc;
    private String country;
    private String status;
}
