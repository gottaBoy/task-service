package net.ibizsys.paas.core;

import net.ibizsys.paas.util.IGlobalContext;

/**
 * 框架全局模型对象，
 * 
 * @author Administrator
 *
 */
public interface IGlobalModel<KT, VT, HT> {
	/**
	 * 初始化
	 * 
	 * @param iGlobalContext
	 */
	void init(IGlobalContext iGlobalContext) throws Exception;

	/**
	 * 查找对应的模型
	 * 
	 * @param objObjectId
	 * @return
	 */
	VT getObjectData(KT objObjectId) throws Exception;

	/**
	 * 查找模型辅助对象
	 * 
	 * @param objObjectId
	 * @return
	 */
	HT getObject(KT objObjectId) throws Exception;

	/**
	 * 重置模型
	 * 
	 * @param objObjectId
	 */
	void resetObject(KT objObjectId);

	/**
	 * 重置全部模型
	 */
	void resetAll();
}
