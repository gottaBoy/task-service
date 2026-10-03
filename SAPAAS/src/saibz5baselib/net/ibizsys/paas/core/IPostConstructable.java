package net.ibizsys.paas.core;

/**
 * 支持构造之后调用接口
 * 
 * @author Administrator
 *
 */
public interface IPostConstructable {

	/**
	 * 构造之后调用
	 */
	void postConstruct() throws Exception;
}
