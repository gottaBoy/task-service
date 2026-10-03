package net.ibizsys.psrt.srv.common.entity;

import java.util.ArrayList;
import java.util.TreeMap;

//@Entity

/**
 * 用户角色数据
 * 
 */
public class UserRoleData extends UserRoleDataBase
{

	public UserRoleData()
	{
		super();
	}

	private TreeMap<String,Boolean > actionsMap = new TreeMap<String,Boolean >();
	protected ArrayList<UserRoleDataDetail> dataDetails = new ArrayList<UserRoleDataDetail>();
	

	public void addAction(String strAction,Boolean bAllow)
	{
		actionsMap.put(strAction.toUpperCase(), bAllow);
	}
	
	public boolean containsAction(String strAction)
	{
		return actionsMap.containsKey(strAction.toUpperCase());
	}
	
	
	public boolean getAction(String strAction)
	{
		if(containsAction(strAction))
			return actionsMap.get(strAction.toUpperCase());
		else
			return false;
	}
	
	
	
	/**
	 * 获取数据明细
	 * @return
	 */
	public  ArrayList<UserRoleDataDetail> getDetailList(){return this.dataDetails;} 

}