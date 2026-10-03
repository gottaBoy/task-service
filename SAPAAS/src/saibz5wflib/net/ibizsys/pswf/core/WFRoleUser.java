package net.ibizsys.pswf.core;

import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroupDetail;
 
/**
 * 流程角色用户对象
 * @author lionlau
 *
 */
public class WFRoleUser extends WFUser implements IWFRoleUser
{
	
	private IWFRoleModel iWFRoleModel = null;

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRoleUser#getWFRoleModel()
	 */
	@Override
	public IWFRoleModel getWFRoleModel()
	{
		return this.iWFRoleModel;
	}
	
	/**
	 * 设置流程角色对象
	 * @param iWFRoleModel the iWFRoleModel to set
	 */
	public void setWFRoleModel(IWFRoleModel iWFRoleModel)
	{
		this.iWFRoleModel = iWFRoleModel;
	}
	
	/**
	 * 从角色用户构建用户对象
	 * @param iWFRoleUser
	 * @param iWFProcRoleModel
	 * @return
	 * @throws Exception
	 */
	public static IWFRoleUser fromWFUserGroupDetail(WFUserGroupDetail wfUserGroupDetail, IWFRoleModel iWFRoleModel)throws Exception
	{
		WFRoleUser wfRoleUser = new WFRoleUser();
		wfUserGroupDetail.copyTo(wfRoleUser, true);
		wfRoleUser.setWFRoleModel(iWFRoleModel);
		return wfRoleUser;
	}

	
	/**
	 * 从流程用户构建用户对象
	 * @param iWFRoleUser
	 * @param iWFProcRoleModel
	 * @return
	 * @throws Exception
	 */
	public static IWFRoleUser fromWFUser(WFUser wfUser, IWFRoleModel iWFRoleModel)throws Exception
	{
		WFRoleUser wfRoleUser = new WFRoleUser();
		wfUser.copyTo(wfRoleUser, true);
		wfRoleUser.setWFRoleModel(iWFRoleModel);
		return wfRoleUser;
	}
	
	
	
	
}
