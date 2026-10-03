package net.ibizsys.model.service;

/**
 * 实体行为 REST风格的服务接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEActionRESTfulAPI extends IPSRESTfulAPI {

	/**
	 * 请求参数类型：无参数
	 */
	public final static String REQUESTPARAMTYPE_NONE = "NONE";

	/**
	 * 请求参数类型：指定属性
	 */
	public final static String REQUESTPARAMTYPE_FIELD = "FIELD";

	/**
	 * 请求参数类型：数据对象
	 */
	public final static String REQUESTPARAMTYPE_ENTITY = "ENTITY";
	
	
	/**
	 * 获取请求的参数类型
	 * @return
	 */
	String getRequestParamType();
	
	
	
	/**
	 * 获取请求的属性名称，请求参数类型为 FIELD 时启用
	 * @return
	 */
	String getRequestField();
}
