package net.ibizsys.model.core;

import net.ibizsys.paas.core.IModelBase;


/**
 * 模型对象接口（包含运行时能力）对象接口
 * @author Administrator
 *
 */
public interface IPSModelObject extends IModelBase {
	
	/**
	 * 获取模型类型
	 * @return
	 */
	String getModelType();
	
	
	
	
//	/**
//	 * 获取模型的标识
//	 * @return
//	 */
//	String getModelId();
//	
//	
//	
//	/**
//	 * 获取模型对象绑定的动态模型对象
//	 * @return
//	 */
//	IPSDynaModel getPSDynaModel();
//
//	
//	
//	/**
//	 * 获取模型名称
//	 * @return
//	 */
//	String getModelName();
//	
//	
//	
//	/**
//	 * 获取模型类型
//	 * @param strModelType 模型类型
//	 * @return
//	 */
//	String getModelType(String strModelType);
//	
//	
//	/**
//	 * 获取模型标识
//	 * @param strModelType 模型类型
//	 * @return
//	 */
//	String getModelId(String strModelType);
//	
//	
//	
//	/**
//	 * 获取模型名称
//	 * @param strModelType 模型类型
//	 * @return
//	 */
//	String getModelName(String strModelType);
//	
//	
//	
//	/**
//	 * 获取模型的类对象
//	 * @param strModelType
//	 * @return
//	 */
//	Class<?> getModelClass(String strModelType) ;
//	
//	
//	
//	/**
//	 * 获取完整的模型名称
//	 * @return
//	 */
//	String getFullModelName();
}
