package net.ibizsys.paas.core;

/**
 * 实体属性输入提示对象
 * @author Administrator
 *
 */
public interface IDEFInputTip extends IModelBase {

	/**
	 * 获取输入提示
	 * @return
	 */
	String getContent();
	
	
	/**
	 * 获取输入提示语言资源标识
	 * @return
	 */
	String getContentLanResTag();
	
	
	/**
	 * 获取输入提示进一步链接
	 * @return
	 */
	String getMoreUrl();
	
	
	/**
	 * 是否支持关闭
	 * @return
	 */
	boolean isEnableClose();
	
	
	/**
	 * 获取唯一的业务标识
	 * @return
	 */
	String getUniqueTag();

}
