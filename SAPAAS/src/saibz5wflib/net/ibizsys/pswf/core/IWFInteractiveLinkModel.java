package net.ibizsys.pswf.core;

import java.util.Iterator;

import net.ibizsys.paas.codelist.ICodeList;

/**
 * 流程交互连接操作模型接口
 * @author lionlau
 *
 */
public interface IWFInteractiveLinkModel extends IWFLinkModel
{
	/**
	 * 任意一个人
	 */
	public final static String NEXTCOND_ANY = "ANY";
	
	
	/**
	 * 全部一个人
	 */
	public final static String NEXTCOND_ALL = "ALL";
	
	
	
	/**
	 * 启用操作者交互控制
	 * @return
	 */
	boolean isActorIAActionControl();
	
	
	/**
	 * 是否包括过程角色
	 * @param iWFProcRoleModel
	 * @return
	 */
	boolean containsWFProcRole(IWFProcRoleModel iWFProcRoleModel);
	
	
	
	/**
	 * 是否包括用户数据指定角色
	 * @param strUDActorId
	 * @return
	 */
	boolean containsUDActor(String strUDActorId);
	
	
	
	/**
	 * 获取需要的操作数量
	 * @return
	 */
	int getActionCount();
	
	
	
	/**
	 * 获取下一步的条件
	 * @return
	 */
	String getNextCondition();
	
	
	/**
	 * 获取处理意见属性
	 * @return
	 */
	String getMemoField();
	
	
	/**
	 * 获取操作实体属性
	 * @return
	 */
	String getActionField();
	
	
	/**
	 * 获取操作代码表对象
	 * @return
	 */
	ICodeList getActionCodeList();
	
	
//	
//	/**
//	 * 获取附加操作者属性
//	 * @return
//	 */
//	String[] getAddActorFields();
//	
	
	
	/**
	 * 获取附加到当前步骤流程角色标识
	 * 
	 * @return
	 */
	String getAddedWFRoleId();
	
	
	
	/**
	 * 获取附加到当前步骤流程角色模型
	 * @return
	 */
	IWFRoleModel getAddedWFRoleModel();
	
	
	/**
	 * 获取附加到当前步骤流程角色用户成员
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	Iterator<IWFRoleUser> getAddedWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception;
}
