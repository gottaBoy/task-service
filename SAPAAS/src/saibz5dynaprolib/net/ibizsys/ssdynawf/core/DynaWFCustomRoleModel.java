package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFRole;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.pswf.core.WFCustomRoleModelBase;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * JIT 自定义流程角色模型对象
 * @author Administrator
 *
 */
public class DynaWFCustomRoleModel extends WFCustomRoleModelBase implements IDynaWFRoleModel{
	private IDynaSysModel iDynaSysModel = null;
	private IPSWFRole iPSWFRole = null;

	/**
	 * 初始化
	 * @param iDynaSysModel
	 * @param iPSWFRole
	 * @throws Exception
	 */
	public void init(IDynaSysModel iDynaSysModel, IPSWFRole iPSWFRole) throws Exception {
		this.iDynaSysModel = iDynaSysModel;
		this.iPSWFRole = iPSWFRole;
		
		this.setId(this.iPSWFRole.getId());
		this.setName(this.iPSWFRole.getName());
		
        this.setWFRoleSN(this.iPSWFRole.getWFRoleSN());
        this.setUserData(this.iPSWFRole.getUserData());
        this.setUserData2(this.iPSWFRole.getUserData2());

         //注册流程角色
        getSystemModel().registerWFRoleModel(this);
     }
	
	
	
	@Override
	public ISystemModel getSystemModel() {
		return this.iDynaSysModel;
	}


	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.JIT.WF.IDynaWFRoleModel#getDynaSysModel()
	 */
	@Override
	public IDynaSysModel getDynaSysModel() {
		return this.iDynaSysModel;
	}


	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.JIT.WF.IDynaWFRoleModel#getPSWFRole()
	 */
	@Override
	public IPSWFRole getPSWFRole() {
		return iPSWFRole;
	}
	
}
