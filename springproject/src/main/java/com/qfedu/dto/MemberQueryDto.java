package com.qfedu.dto;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
public class MemberQueryDto {
    private int page;
    private int size;
    private String name;
    private int sex;
}

