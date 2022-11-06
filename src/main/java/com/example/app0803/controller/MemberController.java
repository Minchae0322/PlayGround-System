package com.example.app0803.controller;


import com.example.app0803.pojo.MemberDto;
import com.example.app0803.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String index() {
        return "/home/index";
    }

    @GetMapping("/member/signup")
    public String signupForm(Model model) {
        model.addAttribute("member",new MemberDto());
        return "/member/signup";
    }

    @RequestMapping(value="/member/signup", method= RequestMethod.POST)
    public String signup(MemberDto memberDto) {
        memberService.signUp(memberDto);
        return "redirect:/";
    }

}
