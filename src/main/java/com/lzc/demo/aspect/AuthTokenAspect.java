package com.lzc.demo.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lzc.demo.annotation.AuthToken;

@Aspect
@Component
public class AuthTokenAspect {
	/**
	 * Spring中使用@Pointcut注解来定义方法切入点
	 * 
	 * @Pointcut 用来定义切点，针对方法 
	 * @Aspect 用来定义切面，针对类 后面的增强均是围绕此切入点来完成的
	 * 此处仅配置被我们刚才定义的注解：AuthToken修饰的方法即可
	 * 
	 */
	@Pointcut("@annotation(authToken)")
	public void doAuthToken(AuthToken authToken) {
	}

	/**
	 * 此处我使用环绕增强，在方法执行之前或者执行之后均会执行。
	 */
	@Around("doAuthToken(authToken)")
	public Object deBefore(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 获取访问该方法所需的role_name信息
		String[] role_name = authToken.role_name();
		if (role_name.length <= 1) {
			// 只需登录，验证是否具有id即可。
			String id = request.getHeader("id");
			/**
			 * 此处使用短路与，若id==null直接会执行if体，不会继续判断 
			 * 若不等于null，则去验证后面的条件，但是也不会出现因为id为null而出现的空指针异常
			 * 所以这样写也是安全的。
			 */
			if (id != null && !id.equals("")) {
				// 已登录，执行原方法并返回即可。
				return pjp.proceed();
			}
			// 未登录，不执行方法，直接返回错误信息
			return "请登陆后再试！";
		} else {
			// 需要验证身份
			String role = request.getHeader("role");
			for (String str : role_name) {
				/**
				 * 此处str由于是用role_name中取值，则str必定不为空
				 * 而从请求头中获取的role有可能为空，则此处调用str的equals方法
				 * 当然可以直接在获得请求头后进行验证是是否不为空。
				 */
				if (str.equals(role)) {
					// 身份匹配成功
					return pjp.proceed();
				}
			}
			return "权限校验失败，不具有指定的身份";
		}
	}

}
