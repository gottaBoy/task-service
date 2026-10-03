package net.ibizsys.pswf.core;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFUser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
/**
 * 流程处理角色用户对象
 * @author lionlau
 *
 */
public class WFProcRoleUser extends WFUser implements IWFProcRoleUser
{
	private static final Log log = LogFactory.getLog(WFProcRoleUser.class);
	
	
	private IWFProcRoleModel iWFProcRoleModel = null;
	private String strId = "";
	private String strName = "";
	private String strWFRoleId = null;
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleUser#getId()
	 */
	@Override
	public String getId()
	{
		return this.strId;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleUser#getName()
	 */
	@Override
	public String getName()
	{
		return this.strName;
	}

	/**
	 * 设置处理角色用户标识
	 * @param strId the strId to set
	 */
	public void setId(String strId)
	{
		this.strId = strId;
	}

	/**
	 * 设置处理角色用户名称
	 * @param strName the strName to set
	 */
	public void setName(String strName)
	{
		this.strName = strName;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleUser#getWFProcRoleModel()
	 */
	@Override
	public IWFProcRoleModel getWFProcRoleModel()
	{
		return this.iWFProcRoleModel;
	}

	/**
	 * 设置流程处理角色模型
	 * @param iWFProcRoleModel the iWFProcRoleModel to set
	 */
	public void setWFProcRoleModel(IWFProcRoleModel iWFProcRoleModel)
	{
		this.iWFProcRoleModel = iWFProcRoleModel;
	}
	
	/**
	 * 从角色用户构建处理用户
	 * @param iWFRoleUser
	 * @param iWFProcRoleModel
	 * @return
	 * @throws Exception
	 */
	public static IWFProcRoleUser fromWFRoleUser(IWFRoleUser iWFRoleUser, String strWFRoleId)throws Exception
	{
		WFProcRoleUser wfProcRoleUser = new WFProcRoleUser();
		iWFRoleUser.copyTo(wfProcRoleUser, true);
		wfProcRoleUser.setWFRoleId(strWFRoleId);
		return wfProcRoleUser;
	}
	
	
	/**
	 * 从角色用户构建处理用户
	 * @param iWFRoleUser
	 * @param iWFProcRoleModel
	 * @return
	 * @throws Exception
	 */
	public static IWFProcRoleUser fromWFRoleUser(IWFRoleUser iWFRoleUser, IWFProcRoleModel iWFProcRoleModel)throws Exception
	{
		WFProcRoleUser wfProcRoleUser = new WFProcRoleUser();
		iWFRoleUser.copyTo(wfProcRoleUser, true);
		wfProcRoleUser.setWFProcRoleModel(iWFProcRoleModel);
		return wfProcRoleUser;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleUser#getWFRoleId()
	 */
	@Override
	public String getWFRoleId()
	{
		if(!StringHelper.isNullOrEmpty(this.strWFRoleId))
			return this.strWFRoleId;
		
		if(getWFProcRoleModel()!=null)
			return getWFProcRoleModel().getWFRoleId();
		
		return null;
	}
	
	/**
	 * 设置流程角色标识
	 * @param strWFRoleId
	 */
	public void setWFRoleId(String strWFRoleId)
	{
		this.strWFRoleId = strWFRoleId;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleUser#isIgnoreSubstitute()
	 */
	@Override
	public boolean isIgnoreSubstitute() {
		try
		{
			return DataObject.getBoolValue(this,IWFProcRoleUser.FIELD_IGNORESUBSTITUTE,false);
		}
		catch(Exception ex)
		{
			log.error(ex);
			return false;
		}
		
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleUser#getOriginalWFUserId()
	 */
	@Override
	public String getOriginalWFUserId() {
		try
		{
			return DataObject.getStringValue(this,IWFProcRoleUser.FIELD_ORIGINALWFUSERID,null);
		}
		catch(Exception ex)
		{
			log.error(ex);
			return null;
		}
	}
}
