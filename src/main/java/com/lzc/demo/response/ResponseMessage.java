package com.lzc.demo.response;

public enum ResponseMessage {

	/**
	 * 成功
	 */
	OK(200, "成功"),
	/**
	 * 活动添加成功
	 */
	IOK(200, "活动添加成功"),

	/**
	 * 成功
	 */
	NOCHANGE(200, "未做任何修改"),
	/**
	 * 成功，用户当前为登录状态
	 */
	LOGIN_NOT_NULL(200, "成功，用户当前为登录状态"),

	/**
	 * 失败，找不到当前登录的用户
	 */
	LOGIN_IS_NULL(404, "找不到当前登录的用户"),

	/**
	 * 错误的请求
	 */
	BAD_REQUEST(400, "错误的请求"),

	/**
	 * 验证码错误
	 */
	VALIDATION_ERROR(400, "验证码错误"),
	/**
	 * 系统错误
	 */
	SYSTEM_ERROR(400, "系统内部错误！"),

	/**
	 * 错误的请求
	 */
	NULL_REQUEST(400, "入参错误！请求参数不能为空"),

	/**
	 * 错误的请求
	 */
	NOTNULL_ID(400, "请求ID不能为空"),

	/**
	 * 错误的请求
	 */
	NOTNULL_NAME(400, "名称不能为空"),

	/**
	 * 活动价不能大于原价
	 */
	PRICE(400, "活动价不能大于原价!"),

	/**
	 * 创建失败
	 */
	CREATE_FAIL(400, "创建失败"),

	/**
	 * 更新失败
	 */
	UPDATE_FAIL(400, "更新失败"),

	/**
	 * 删除失败
	 */
	DELETE_FAIL(400, "删除失败"),

	/**
	 * 上传失败
	 */
	UPLOAD_FAIL(400, "上传失败，请检查网络连接并重新上传"),

	/**
	 * 文件解析失败
	 */
	DECOMPRESS_FAIL(400, "解压失败，文件结构不正确"),

	/**
	 * 未授权——未授权客户机访问数据
	 */
	UNAUTHORIZED(401, "未授权——未授权客户机访问数据"),

	/**
	 * 禁止——即使有授权也不需要访问
	 */
	FORBIDDEN(403, "禁止——即使有授权也不需要访问"),
	/**
	 * 尚未指派，无法进行操作
	 */
	DOUSER_NOT_NULL(403, "尚未指派，无法进行操作！"),

	/**
	 * 找不到——服务器找不到给定的资源；文档不存在
	 */
	NOT_FOUND(404, "找不到——服务器找不到给定的资源；文档不存在"),

	/**
	 * 无法接受——不合法的请求数据
	 */
	UN_ACCEPT(406, "无法接受——不合法的请求数据"),

	/**
	 * 无法接受——不合法的请求数据
	 */
	JSON_ACCEPT(406, "无法接受——JSON字符串格式错误"),

	/**
	 * 代理认证请求 — 客户机首先必须使用代理认证自身
	 */
	PROXY_AUTHENTICATION_REQUIRED(407, "代理认证请求 — 客户机首先必须使用代理认证自身"),

	/**
	 * 介质类型不受支持 — 服务器拒绝服务请求，因为不支持请求实体的格式
	 */
	UNSUPPORTED_MEDIA_TYPE(415, "介质类型不受支持 — 服务器拒绝服务请求，因为不支持请求实体的格式"),

	/**
	 * 用户权限不足，禁止访问
	 */
	INADEQUATE_PERMISSIONS(450, "用户权限不足，禁止访问!"),

	/**
	 * 用户身份认证失败
	 */
	AUTHORIZED_ERROR(450, "用户身份认证失败，请重新登录"),

	/**
	 * 内部错误
	 */
	INTERNAL_SERVER_ERROR(500, "内部错误"),

	/**
	 * 还未实现
	 */
	NOT_IMPLEMENTED(501, "还未实现"),

	/**
	 * 网关错误
	 */
	BAD_GATEWAY(502, "网关错误"),

	/**
	 * 版本号重复
	 */
	VERSION_NAME_REPETITION(503, "版本号重复"),

	/**
	 * 找不到数据
	 */
	DATA_NOT_FOUND(504, "找不到数据"),

	/**
	 * 信息不完整
	 */
	INCOMPLETE_INFORMATION(505, "信息不完整"),

	/**
	 * 参数错误
	 */
	PARAMETER_ERROR(506, "参数错误"),

	/**
	 * 版本信息不完整
	 */
	VERSION_INCOMPLETE_INFORMATION(507, "版本信息不完整"),

	/**
	 * 基本信息不完整
	 */
	BASE_INCOMPLETE_INFORMATION(508, "基本信息不完整"),

	/**
	 * 英文名称重复
	 */
	E_NAME_REPETITION(509, "英文名称重复"),

	/**
	 * 中文名称重复
	 */
	C_NAME_REPETITION(510, "名称重复"),

	/**
	 * 操作太頻繁！
	 */
	FREQUENT_FEEDBACK(515, "操作太频繁，请五分钟后再提交！"),

	/**
	 * 服务范围格式异常！
	 */
	RANGE_ERROR_FORMAT(516, "服务范围格式异常！"),

	// 逻辑错误

	/**
	 * 验证码有误
	 */
	REG_SEND_FAIL(400, "验证码有误，请重新验证！"),
	/**
	 * 用户已注册
	 */
	REG_FAIL(400, "用户已注册，请前往登陆！"),
	/**
	 * 未登录
	 */
	NOT_LOGIN(108, "请登陆后再试哟亲~"),
	/**
	 * 登录失败，密码错误
	 */
	LOGIN_FAIL(400, "登录失败，请输入正确的密码！"),
	/**
	 * 当前用户已经在别处登录
	 */
	USER_ISLOGINED(400, "用户已经在别处登录！"),
	/**
	 * 登录失败，账号不存在
	 */
	USERNAME_ISNULL(400, "登录失败，账号未找到！"),
	/**
	 * 账号为空
	 */
	USERNAME_NULL(400, "请输入账号！"),
	/**
	 * 密码为空
	 */
	PASSWORD_NULL(400, "请输入密码！"),

	/**
	 * token过期！
	 */
	TOKEN_EXPIRED(109, "token非法或者已过期！"),
	/**
	 * token无效！
	 */
	TOKEN_INVALID(109, "无效的token！"),

	/**
	 * 此商家还没有授权，请重新授权
	 */
	MALL_TOKEN_ISNULL(110, "此商家还没有授权，请重新授权！"),

	/**
	 * 商家授权过期
	 */
	MALL_TOKEN_EXPIRED(111, "商家授权过期，请重新授权！"),

	;

	private final int status;

	private final String message;

	ResponseMessage(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
