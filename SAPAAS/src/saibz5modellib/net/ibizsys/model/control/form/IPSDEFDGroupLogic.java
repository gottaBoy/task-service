package net.ibizsys.model.control.form;

/**
 * 实体表单成员组合逻辑对象接口
 * @author lionlau
 *
 */
public interface IPSDEFDGroupLogic extends IPSDEFDLogic
{
	/**
	 * 获取组逻辑
	 * @return
	 */
	String getGroupOP();
	
	
	/**
	 * 是否取反
	 * @return
	 */
	boolean isNotMode();
	
	
	
	/**
	 * 获取子逻辑集合
	 * @return
	 */
	java.util.Iterator<IPSDEFDLogic> getPSDEFDLogics();
}
