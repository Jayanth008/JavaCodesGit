package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingClass {

//	Logger log = LoggerFactory.getLogger(LoggingClass.class);
//
//	@Pointcut(value = "execution(* com.example.demo.*.*(..))")
//	public void myPointCut() {
//
//	}
//
//	@Around("myPointCut()")
//	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//
//		String methodName = pjp.getSignature().getName();
//		String ClassName = pjp.getTarget().getClass().toString();
//		Object[] array = pjp.getArgs();
//		log.info("Method Invoked " + ClassName + " : " + methodName + "()" + "arguments : "
//				+ new ObjectMapper().writeValueAsString(array));
//		Object object = pjp.proceed();
//		log.info("Method Response " + ClassName + " : " + methodName + "()" + "arguments : "
//				+ new ObjectMapper().writeValueAsString(object));
//
//		return object;
//	}
	private final Logger log = LoggerFactory.getLogger(LoggingClass.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Pointcut("execution(* com.example.demo.controller.sendEmail(..))")
    public void myPointCut() {
    }

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().getName();
        Object[] arguments = pjp.getArgs();

        try {
            log.info("Method Invoked {} : {}() arguments: {}", className, methodName,
                    objectMapper.writeValueAsString(arguments));
            Object result = pjp.proceed();
            log.info("Method Response {} : {}() result: {}", className, methodName,
                    objectMapper.writeValueAsString(result));
            return result;
        } catch (Throwable throwable) {
            log.error("Exception in {} : {}() with arguments: {}", className, methodName,
                    objectMapper.writeValueAsString(arguments), throwable);
            throw throwable;
        }
    }

}
