package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEFInputTip;
import net.ibizsys.paas.core.IDEFInputTipSet;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 实体属性输入提示集合模型对象
 * @author Administrator
 *
 */
public interface IDEFInputTipSetModel extends IDEFInputTipSet,IModelBase3 {
	
	/**
	 * 初始化
	 * @param iSystemModel
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel)throws Exception;
	
	
	/**
	 * 准备属性输入提示数据
	 * @throws Exception
	 */
	void prepareDEFInputTips() throws Exception;
	
	
	
	/**
	 * 重置全部
	 */
	void resetAll();
	
	/**
	 * 获取属性输入提示对象
	 * @param strUniqueTag
	 * @return
	 * @throws Exception
	 */
	IDEFInputTip getDEFInputTip(String strUniqueTag)throws Exception;
	
	
	
	/**
	 * 获取属性输入提示对象
	 * @param strUniqueTag
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IDEFInputTip getDEFInputTip(String strUniqueTag,boolean bTryMode)throws Exception;
}
