package com.priyanka.datta.springbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {

    Logger logger = LoggerFactory.getLogger(StudentAspect.class);

    @Before("execution(* com.priyanka.datta.springbootaop.service.StudentService.*(..))")
    public void before(JoinPoint joinpoint){
        logger.info("Before");
        logger.info("{}() method is being called with parameter {}", joinpoint.getSignature().getName(),
                joinpoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.priyanka.datta.springbootaop.service.StudentService.*(..))"
            , returning = "result")
    public void afterReturn(JoinPoint joinpoint,Object result){
        logger.info("After return");
        logger.info("{}() method has returned {}", joinpoint.getSignature().getName(), result);
    }

    /*@AfterThrowing(pointcut = "execution(* com.priyanka.datta.springbootaop.service.StudentService.*(..))"
            , throwing = "ex")
    public void afterException(JoinPoint joinpoint,Exception ex){
        logger.info("After return");
        logger.info("{}() method has thrown exception {}", joinpoint.getSignature().getName(), ex);
    }*/

    @After("execution(* com.priyanka.datta.springbootaop.service.StudentService.*(..))")
    public void after(JoinPoint joinpoint){
        logger.info("After");
        logger.info("{}() method has been called", joinpoint.getSignature().getName());
    }
}
