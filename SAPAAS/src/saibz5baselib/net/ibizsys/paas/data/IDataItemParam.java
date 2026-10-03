package net.ibizsys.paas.data;

import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.web.IWebContext;

/**
 * 数据项参数接口
 * 
 * @author lionlau
 *
 */
public interface IDataItemParam extends IModelBase {
	/**
	 * 获取格式化
	 * 
	 * @return
	 */
	String getFormat();

	/**
	 * 获取默认值
	 * 
	 * @return
	 */
	Object getDefaultValue();

	/**
	 * 获取代码表标识
	 * 
	 * @return
	 */
	String getCodeListId();

	/**
	 * 获取值
	 * 
	 * @param iWebContext 网络请求上下文对象
	 * @param object 当前数据对象
	 * @return
	 * @throws Exception
	 */
	Object getValue(IWebContext iWebContext, Object object) throws Exception;

}
