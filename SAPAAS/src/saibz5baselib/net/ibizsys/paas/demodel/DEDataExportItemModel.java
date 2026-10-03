package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.security.PrivilegeAbilities;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体数据导出项模型
 * 
 * @author lionlau
 * 
 */
public class DEDataExportItemModel extends DataItemModel implements IDEDataExportItem {
	private IDEDataExport iDEDataExport = null;
	private IDEDataExportModel iDEDataExportModel = null;
	private String strPrivilegeId = null;
	private String strCaption = null;
	private String strCapLanResTag = null;
	
	public DEDataExportItemModel() {

	}

	/**
	 * 初始化
	 * 
	 * @param iDEDataExport
	 * @throws Exception
	 */
	public void init(IDEDataExport iDEDataExport) throws Exception {
		this.setDEDataExport(iDEDataExport);
		this.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataExportItem#getDEDataExport()
	 */
	@Override
	public IDEDataExport getDEDataExport() {
		return this.iDEDataExport;
	}

	/**
	 * 获取实体数据导出模型对象
	 * 
	 * @return
	 */
	protected IDEDataExportModel getDEDataExportModel() {
		return this.iDEDataExportModel;
	}

	/**
	 * 设置实体数据导出对象
	 * 
	 * @param iDEDataExport the iDEDataExport to set
	 */
	protected void setDEDataExport(IDEDataExport iDEDataExport) {
		this.iDEDataExport = iDEDataExport;
		if (this.iDEDataExport == null) {
			this.iDEDataExportModel = null;
		} else if (this.iDEDataExport instanceof IDEDataExportModel) {
			this.iDEDataExportModel = (IDEDataExportModel) this.iDEDataExport;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.impl.DataItemImpl#getCurSystem(net.ibizsys.paas.core.IActionContext)
	 */
	@Override
	public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
		return this.getDEDataExport().getDataEntity().getSystem();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.impl.DataItemImpl#getDEModel()
	 */
	@Override
	protected IDataEntityModel getDEModel() throws Exception {
		return (IDataEntityModel) this.getDEDataExport().getDataEntity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataExportItem#getPrivilegeId()
	 */
	@Override
	public String getPrivilegeId() {
		return this.strPrivilegeId;
	}

	/**
	 * 设置列控制标识
	 * 
	 * @param strPrivilegeId
	 */
	public void setPrivilegeId(String strPrivilegeId) {
		this.strPrivilegeId = strPrivilegeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataExportItem#getCaption()
	 */
	@Override
	public String getCaption() {
		return this.strCaption;
	}

	/**
	 * 设置标题
	 * 
	 * @param strCaption
	 */
	public void setCaption(String strCaption) {
		this.strCaption = strCaption;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataExportItem#getCapLanResTag()
	 */
	@Override
	public String getCapLanResTag() {
		return this.strCapLanResTag;
	}

	/**
	 * 设置标题语言资源标识
	 * 
	 * @param strCapLanResTag
	 */
	public void setCapLanResTag(String strCapLanResTag) {
		this.strCapLanResTag = strCapLanResTag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataExportItem#getText(net.ibizsys.paas.web.IWebContext, java.lang.Object, boolean)
	 */
	@Override
	public String getText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
		try {
			if (bEnableItemPrivilege) {

				String strPrivilegeId = this.getPrivilegeId();
				if (!StringHelper.isNullOrEmpty(strPrivilegeId)) {
					// 判断是否有权限
					if ((iWebContext.getUserPrivilegeMgr().testDEField(iWebContext, strPrivilegeId) & PrivilegeAbilities.READ) == 0) {
						return "";
					}
				}
			}

			Object objValue = this.getValue(iWebContext, object);

			ICodeListModel iCodeListModel = null;
			if (!StringHelper.isNullOrEmpty(this.getCodeListId())) {
				boolean bConvertCL = true;
				if (this.getDataItemParams() != null) {
					for (IDataItemParam iDataItemParam : this.getDataItemParams()) {
						if (!StringHelper.isNullOrEmpty(iDataItemParam.getCodeListId())) {
							bConvertCL = false;
							break;
						}
					}
				}
				if (bConvertCL) {
					iCodeListModel = (ICodeListModel) CodeListGlobal.getCodeList(this.getCodeListId());
				}
			}

			if (objValue == null) {
				if (iCodeListModel != null) {
					return iCodeListModel.getEmptyText();
				}
				return "";
			} else {
				if (iCodeListModel != null) {
					return iCodeListModel.getCodeListText(objValue.toString(), true);
				}
				return objValue.toString();
			}
		} catch (Exception ex) {
			return ex.getMessage();
		}
	}

}
