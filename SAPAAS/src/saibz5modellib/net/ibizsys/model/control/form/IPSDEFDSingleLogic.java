package net.ibizsys.model.control.form;


/**
 * 实体表单成员单项逻辑对象接口
 * @author Administrator
 *
 */
public interface IPSDEFDSingleLogic extends IPSDEFDLogic
{
	/**
	 * 获取表单成员名称
	 * @return
	 */
	String getDEFDName();
	
	
	
	/**
	 * 获取值操作符号标识，值参考  net.ibizsys.paas.logic.ICondition 定义
	 * @return
	 */
	String getPSDBValueOPId();
	
	
	/**
	 * 获取条件值
	 * @return
	 */
	String getValue();
	
	
	
}
