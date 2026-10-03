package net.ibizsys.model.wf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.pswf.core.IWFProcRoleModel;

/**
 * 工作流处理角色对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSWFProcessRole extends IPSModelObject, IWFProcRoleModel {
	/**
	 * 工作流处理角色类型：工作流角色
	 */
	public final static String ROLETYPE_WFROLE = "WFROLE";

	/**
	 * 工作流处理角色类型：上两个步骤操作者
	 */
	public final static String ROLETYPE_LASTTWOSTEPACTOR = "LASTTWOSTEPACTOR";

	/**
	 * 工作流处理角色类型：上三个步骤操作者
	 */
	public final static String ROLETYPE_LASTTHREESTEPACTOR = "LASTTHREESTEPACTOR";

	/**
	 * 工作流处理角色类型：上一步骤操作者
	 */
	public final static String ROLETYPE_LASTSTEPACTOR = "LASTSTEPACTOR";

	/**
	 * 工作流处理角色类型：当前数据属性操作者
	 */
	public final static String ROLETYPE_UDACTOR = "UDACTOR";

	/**
	 * 工作流处理角色类型：当前操作者
	 */
	public final static String ROLETYPE_CURACTOR = "CURACTOR";

	
	/**
	 * 获取处理角色类型，值参考 SA.SRFDA.PS.Core.WF.IPSWFProcessRole.ROLETYPE_XXX 定义
	 * 
	 * @return
	 */
	String getWFProcessRoleType();

	/**
	 * 获取用户数据的字段
	 * 
	 * @return
	 */
	String getUDField();

}
