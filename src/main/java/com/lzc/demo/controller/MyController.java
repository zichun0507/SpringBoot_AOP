package com.lzc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzc.demo.annotation.AuthToken;

@RestController
public class MyController {
	/**
	 * 无需校验，不加注解
	 */
	@GetMapping("hello")
	public String hello(Integer id, String name, Integer age) {
		System.out.println("hello方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
		return "hi~ 我不需要用户权限";
	}

	/**
	 * 需要登录校验，加上注解，但不传所需角色
	 */
	@GetMapping("user")
	@AuthToken
	public String user(Integer id, String name, Integer age) {
		System.out.println("user方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
		return "hi~ 我需要登陆后才可以访问";
	}

	/**
	 * 需要角色校验，加上注解，并且写入两个角色，本文演示两个角色有一个即可访问，当然写一个可以。
	 * 注：若想两个角色同时具有，修改后文的逻辑判断即可。
	 * 若需要更复杂的逻辑操作，推荐使用Spring Security框架。
	 */
	@GetMapping("admin")
	@AuthToken(role_name = { "admin", "Administrator" })
	public String admin(Integer id, String name, Integer age) {
		System.out.println("admin方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
		return "hi~ 我需要管理员身份才可以访问";
	}
}
