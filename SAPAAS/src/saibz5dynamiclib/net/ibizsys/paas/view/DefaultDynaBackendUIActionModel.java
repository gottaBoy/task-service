package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.util.StringHelper;


/**
 * 默认动态界面行为对象实现
 * @author Administrator
 *
 */
public class DefaultDynaBackendUIActionModel extends DynaUIActionModelBase implements IDynaBackendUIActionModel{

	private boolean bReloadData = false;
	private String strSuccessMsg = null;
	private String strDataAccessAction = null;
	//private boolean bCloseEditView = false;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUIAction#isReloadData()
	 */
	@Override
	public boolean isReloadData() {
		return this.bReloadData;
	}

	/**
	 * 设置是否重新加载数据
	 * 
	 * @param bReloadData
	 */
	public void setReloadData(boolean bReloadData) {
		this.bReloadData = bReloadData;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUIAction#getSuccessMsg()
	 */
	@Override
	public String getSuccessMsg() {
		return this.strSuccessMsg;
	}

	/**
	 * 设置常规提示信息
	 * 
	 * @param strSuccessMsg the strSuccessMsg to set
	 */
	public void setSuccessMsg(String strSuccessMsg) {
		this.strSuccessMsg = strSuccessMsg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUIAction#getDataAccessAction()
	 */
	@Override
	public String getDataAccessAction() {
		if (!StringHelper.isNullOrEmpty(this.strDataAccessAction)) return this.strDataAccessAction;

		if (StringHelper.compare(this.getActionTarget(), IDEUIAction.ACTIONTARGET_NONE, true) == 0) {
			return "";
		} else {
			return DataAccessActions.UPDATE;
		}
	}

	/**
	 * 设置实体操作标识（用于权限判断）
	 * 
	 * @param strDataAccessAction
	 */
	public void setDataAccessAction(String strDataAccessAction) {
		this.strDataAccessAction = strDataAccessAction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUIAction#isCloseEditView()
	 */
	@Override
	public boolean isCloseEditView() {
		return this.isClosePopupView();
	}

	/**
	 * 设置是否关闭编辑视图
	 * 
	 * @param bCloseEditView the bCloseEditView to set
	 */
	public void setCloseEditView(boolean bCloseEditView) {
		this.setClosePopupView(bCloseEditView);
	}

	

}
