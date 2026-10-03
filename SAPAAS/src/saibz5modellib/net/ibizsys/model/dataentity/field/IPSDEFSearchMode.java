package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSSysDBValueFunc;
import net.ibizsys.paas.core.IDEFSearchMode;


/**
 * 属性搜索模式对象接口
 * @author Administrator
 *
 */
public interface IPSDEFSearchMode extends IPSDEFieldObject,IDEFSearchMode,IPSModelObject
{	
	
	/**
	 * 获取实体属性标识
	 * @return
	 */
	String getPSDEFId();
	
	
	
	/**
	 * 获取值函数标识
	 * @return
	 */
	String getPSSysDBVFId();
	
	
	
	/**
	 * 获取值操作符号标识
	 * @return
	 */
	String getPSDBValueOPId();
	
	
	/**
	 * 获取搜索表单项
	 * @param 界面模式，DEFAULT 
	 * @return
	 */
	IPSDEFFormItem getPSDEFFormItem(String strUIMode);
	
	
	/**
	 * 获取系统数据库值函数对象
	 * @return
	 */
	IPSSysDBValueFunc getPSSysDBValueFunc();

	
	/**
	 * 获取系统代码表标识
	 * @return
	 */
	String getPSCodeListId();
}
