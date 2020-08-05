package edu.mum.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import edu.mum.domain.User;

@Aspect
@Component
public class AuctionAspect {

	// 1-->implcit pointcut [execution] that looks for all Service methods
//	@Before("execution(* edu.mum.service..*(..))")
//	public void logServiceMethods(JoinPoint joinPoint) {
//		System.out.println("   **********     ADVICE CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
//				+ joinPoint.getSignature().getName() + "    **********");
//	}

	// 2-->Make the pointcut into an explicit pointcut.
//	@Pointcut("execution(* edu.mum.service..*(..))")

	// 3-->Change the pointcut arguments from (..) to (Long)
//	@Pointcut("execution(* edu.mum.service..*(Long))")

	// 4-->Change the pointcut arguments from (Long) to ()
//	 @Pointcut("execution(* edu.mum.service..*())")

	// 5-->Add a findAll() to testItems.java
//	@Pointcut("execution(* edu.mum.service..*())")

	// 6-->Replace the execution pointcut with a combination of a within() and an
	// args() pointcut
//	@Pointcut("within(edu.mum.service..*) && args()")
	public void applicationMethod() {
	}

	// 2-->Make the pointcut into an explicit pointcut.
	// 3-->Change the pointcut arguments from (..) to (Long)
	// 4-->Change the pointcut arguments from (Long) to ()
	// 5-->Add a findAll() to testItems.java
//	@Before("applicationMethod()")
//	public void logAllServiceMethods(JoinPoint joinPoint) {
//		System.out.println("   **********     ADVICE CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
//				+ joinPoint.getSignature().getName() + "    **********");
//	}

	// 7-->Add another Advice method with a User parameter:
	@Before("within(edu.mum.service..*) && args(user)")
	public void logResourceName(JoinPoint joinPoint, User user) {
		 System.out.println( "   **********     ADVICE CLASS : " + 
	    	joinPoint.getSignature().getDeclaringTypeName() + "." +
	    	joinPoint.getSignature().getName() + 
	    	"    **********" + "User First Name: " + user.getFirstName());
	}

}
