package net.ibizsys.paas.api;


/**
 * Rest 服务接口操作模型对象
 * @author Administrator
 *
 */
public class RestServiceAPIActionModel extends ServiceAPIActionModel implements IRestServiceAPIAction {

	private String strActionPath = "";
	private String strRequestMethod = IRestServiceAPIAction.REQUESTMETHOD_GET;
	private String strKeyField = null;
	
	@Override
	public String getActionPath() {
		return this.strActionPath;
	}
	
	/**
	 * 设置操作路径
	 * @param strActionPath
	 */
	public void setActionPath(String strActionPath){
		this.strActionPath = strActionPath;
	}

	@Override
	public String getRequestMethod() {
		return this.strRequestMethod;
	}
	
	/**
	 * 设置请求方式
	 * @param strRequestMethod
	 */
	public void setRequestMethod(String strRequestMethod){
		this.strRequestMethod = strRequestMethod;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.api.IRestServiceAPIAction#getKeyField()
	 */
	@Override
	public String getKeyField() {
		return this.strKeyField;
	}

	/**
	 * 设置键值属性
	 * @param strKeyField
	 */
	public void setKeyField(String strKeyField){
		this.strKeyField = strKeyField;
	}
	
	
}
