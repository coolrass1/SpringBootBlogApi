package com.skk.BlogApi.post;

import com.skk.BlogApi.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/scar")
public class PostControllerexp {
    @GetMapping("/post")
    public  String Hellopost(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getId());

        return "post";
    }
}
