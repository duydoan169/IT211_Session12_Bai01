package org.example.bai1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* org.example.bai1.service.BookService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method "+joinPoint.getSignature().getName()+"Agrs"+ Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(pointcut="execution(* org.example.bai1.service.BookService.*(..))", returning="result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("After method"+joinPoint.getSignature().getName()+"Result"+result);
    }
    @Around("execution(* org.example.bai1.service.BookService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Around"+joinPoint.getSignature().getName()+"excuted in"+(endTime-startTime)+"ms");
        return result;
    }
}
