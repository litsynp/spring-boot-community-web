package com.litsynp.springbootcommunityweb.controller;

import com.litsynp.springbootcommunityweb.annotation.SocialUser;
import com.litsynp.springbootcommunityweb.domain.User;
import com.litsynp.springbootcommunityweb.domain.enums.SocialType;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginComplete(@SocialUser User user) {
        return "redirect:/board/list";
    }
}

/*
OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext()
                .getAuthentication();
        Map<String, String> map = (HashMap<String, String>) authentication
                .getUserAuthentication().getDetails();

        session.setAttribute("user", User.builder()
                .name(map.get("name"))
                .email(map.get("email"))
                .principal(map.get("id"))
                .socialType(SocialType.FACEBOOK)
                .createdDate(LocalDateTime.now())
                .build());

 */
