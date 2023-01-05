package com.revature.POProject1Remake.aspects;

import com.revature.POProject1Remake.annotations.Authorized;
import com.revature.POProject1Remake.exceptions.NotLoggedInException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {
    private final HttpServletRequest req;

    public AuthAspect(HttpServletRequest req){
        this.req=req;
    }

    @Around("@annotation(authorized)")
    public Object authenticate(ProceedingJoinPoint pjp, Authorized authorized) throws Throwable{
        HttpSession session = req.getSession();

        if(session.getAttribute("user")==null){
            throw new NotLoggedInException("Must be logged in to perform this action");
        }
        return pjp.proceed(pjp.getArgs());
    }
}
