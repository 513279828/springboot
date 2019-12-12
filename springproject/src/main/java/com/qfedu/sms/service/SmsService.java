package com.qfedu.sms.service;

import com.qfedu.common.vo.R;
import com.qfedu.dto.PhoneCodeDto;

public interface SmsService {
    R sendSmsCode(String phone);
    R checkSmsCode(PhoneCodeDto codeDto);
}
