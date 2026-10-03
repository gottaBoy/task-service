package net.ibizsys.pswf.core;

import java.util.Iterator;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.StringHelper;

/**
 * 流程实体数据集合角色模型对象
 * 
 * @author lionlau
 *
 */
public abstract class WFDEDataSetRoleModelBase extends WFRoleModelBase {
	private String strDEName = null;
	private String strDEDataSetName = null;
	private String strWFUserIdField = null;
	private String strWFUserNameField = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.core.IWFRoleModel#getWFRoleType()
	 */
	@Override
	public String getWFRoleType() {
		return IWFRoleModel.WFROLETYPE_DEDATASET;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.pswf.core.IWFRoleModel#getWFRoleUserModels(net.ibizsys.pswf
	 * .core.IWFActionContext)
	 */
	@Override
	public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
		try {

			if (StringHelper.isNullOrEmpty(this.getDEName())) {
				throw new Exception("没有指定数据实体名称");
			}

			if (StringHelper.isNullOrEmpty(this.getDEDataSetName())) {
				throw new Exception("没有指定数据集合名称");
			}

			if (StringHelper.isNullOrEmpty(this.getWFUserIdField())) {
				throw new Exception("没有指定流程用户标识属性");
			}

			if (StringHelper.isNullOrEmpty(this.getWFUserNameField())) {
				throw new Exception("没有指定流程用户名称属性");
			}

			java.util.ArrayList<IWFRoleUser> wfRoleUserList = new java.util.ArrayList<IWFRoleUser>();

			DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
			deDataSetFetchContextImpl.setActiveDataObject(iWFActionContext.getActiveEntity());

			IService iService = this.getSystemModel().getDataEntityModel(this.getDEName()).getService();
			DBFetchResult fetchResult = iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);

			java.util.ArrayList<IEntity> list = ServiceBase.fromDBFetchResult(iService.getDEModel(), fetchResult);
			for (IEntity iEntity : list) {

				WFRoleUser wfRoleUser = new WFRoleUser();
				wfRoleUser.setWFUserId(DataObject.getStringValue(iEntity.get(this.getWFUserIdField())));
				wfRoleUser.setWFUserName(DataObject.getStringValue(iEntity.get(this.getWFUserNameField())));
				wfRoleUser.setWFRoleModel(this);
				wfRoleUserList.add(wfRoleUser);
			}
			return wfRoleUserList.iterator();
		} catch (Exception ex) {
			throw new Exception(StringHelper.format("获取流程角色[%1$s]成员发生异常，%2$s", this.getName(), ex.getMessage()), ex);
		}

	}

	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	protected String getDEName() {
		return strDEName;
	}

	/**
	 * 设置实体名称
	 * 
	 * @param strDEName
	 */
	protected void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	/**
	 * 获取实体结果集合名称
	 * 
	 * @return
	 */
	protected String getDEDataSetName() {
		return strDEDataSetName;
	}

	/**
	 * 设置实体结果集合名称
	 * 
	 * @param strDEDataSetName
	 */
	protected void setDEDataSetName(String strDEDataSetName) {
		this.strDEDataSetName = strDEDataSetName;
	}

	/**
	 * 获取流程用户标识存储属性
	 * 
	 * @return
	 */
	protected String getWFUserIdField() {
		return strWFUserIdField;
	}

	/**
	 * 设置流程用户标识存储属性
	 * 
	 * @param strWFUserIdField
	 */
	protected void setWFUserIdField(String strWFUserIdField) {
		this.strWFUserIdField = strWFUserIdField;
	}

	/**
	 * 获取流程用户名称存储属性
	 * 
	 * @return
	 */
	protected String getWFUserNameField() {
		return strWFUserNameField;
	}

	/**
	 * 设置流程用户名称存储属性
	 * 
	 * @param strWFUserNameField
	 */
	protected void setWFUserNameField(String strWFUserNameField) {
		this.strWFUserNameField = strWFUserNameField;
	}

}
