package com.somoim.aop;

import com.somoim.exception.RequiredLoginException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
@RequiredArgsConstructor
public class LoginCheckAspect {

    private final HttpSession httpSession;

    @Before("@annotation(com.somoim.annotation.LoginCheck)")
    public void loginCheck() {
        if(httpSession.getAttribute("USER_ID") == null)
            throw new RequiredLoginException("Login is required.");
    }
}
