package com.shop.controller;

import com.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {

    @GetMapping(value = "/ex01")
    public String ex01(Model model) {
        model.addAttribute("data", "타임리프 예제입니다!");
        return "thymeleafEx/thymeleafEx01";
    }

    @GetMapping(value = "/ex02")
    public String ex02(Model model) {

        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 설명입니다");
        itemDto.setItemName("테스트 굿즈1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto",itemDto);
        return "thymeleafEx/thymeleafEx02";
    }

    @GetMapping(value = "/ex03")
    public String ex03() {
        return "thymeleafEx/thymeleafEx03";
    }

}
