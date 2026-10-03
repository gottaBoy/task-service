package net.ibizsys.paas.security;

/**
 * 资源的访问用户模式
 * 
 * @author Administrator
 *
 */
public class AccessUserModes {
	/**
	 * 未知
	 */
	public final static Integer UNKNOWN = 0;

	/**
	 * 匿名用户
	 */
	public final static Integer ANONYMOUS = 1;

	/**
	 * 已登录用户
	 */
	public final static Integer LOGINUSER = 2;

	/**
	 * 全部用户
	 */
	public final static Integer ALLUSER = ANONYMOUS | LOGINUSER;

	/**
	 * 已登录用户，并具备访问指定访问标识
	 */
	public final static Integer LOGINUSERWITHKEY = 4;

}
