package net.ibizsys.paas.sysmodel;

import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.web.IWebContext;



/**
 * 系统用户角色模型对象
 * 
 * @author lionlau
 *
 */
public abstract class SystemUserRoleModelBase extends SystemModelObjectBase implements ISystemUserRoleModel {

	private String strRoleTag  = null;
	private HashMap<String, String> sysUniResMap = new HashMap<String, String>();
	
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.setSystemModel(iSystemModel);
		this.onInit();
	}

	
	
	
	@Override
	protected void onInit() throws Exception {
		super.onInit();
	}
	

	/**
	 * 设置标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	
	/**
	 * 设置名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}




	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.ISystemUserRole#getRoleTag()
	 */
	@Override
	public String getRoleTag() {
		return this.strRoleTag;
	}




	/**
	 * 设置系统角色标记
	 * @param strRoleTag
	 */
	public void setRoleTag(String strRoleTag) {
		this.strRoleTag = strRoleTag;
	}




	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.ISystemUserRole#getUniResTags()
	 */
	@Override
	public Iterator<String> getUniResTags() {
		if(this.sysUniResMap.size() == 0)
			return null;
		return this.sysUniResMap.keySet().iterator();
	}




	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemUserRoleModel#registerUniResTag(java.lang.String)
	 */
	@Override
	public void registerUniResTag(String strUniResTag) {
		this.sysUniResMap.put(strUniResTag, "");
	}




	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemUserRoleModel#testCurUser(net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public boolean testCurUser(IWebContext iWebContext) throws Exception {
		return false;
	}




	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemUserRoleModel#testUniResTag(java.lang.String)
	 */
	@Override
	public boolean testUniResTag(String strUniResTag) throws Exception {
		return this.sysUniResMap.containsKey(strUniResTag);
	}
	
	
	
	
}
