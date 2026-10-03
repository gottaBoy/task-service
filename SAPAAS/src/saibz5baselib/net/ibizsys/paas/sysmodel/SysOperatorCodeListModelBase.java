package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.UserService;

/**
 * 系统操作者代码表
 * 
 * @author Administrator
 * 
 */
public abstract class SysOperatorCodeListModelBase extends DynamicCodeListModelBase {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(SysOperatorCodeListModelBase.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.DynamicCodeListModelBase#getService()
	 */
	@Override
	protected IService getService() {
		try {
			return ServiceGlobal.getService(UserService.class);
		} catch (Exception ex) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.DynamicCodeListModelBase#onPrepareCodeItems()
	 */
	@Override
	protected void onPrepareCodeItems() throws Exception {
		try{
			UserService userService = (UserService) ServiceGlobal.getService(UserService.class);
			SelectCond selectCond = new SelectCond();
			ArrayList<User> userList = userService.select(selectCond);
			for (User user : userList) {
				CodeItemModel codeItemModel = new CodeItemModel();
				codeItemModel.setText(user.getUserName());
				codeItemModel.setValue(user.getUserId());
				this.registerCodeItemModel(codeItemModel);
			}
		}
		catch(Exception ex){
			log.error(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.DynamicCodeListModelBase#getCodeListText(java.lang.String, boolean, java.lang.Object, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
		prepareCodeItems();
		if (StringHelper.isNullOrEmpty(strValue)) strValue = "";

		ICodeItem iCodeItem = this.getCodeItemModel(strValue);
		if (iCodeItem != null) return iCodeItem.getText();

		if (StringHelper.isNullOrEmpty(strValue)) {
			CodeItemModel codeItemModel = new CodeItemModel();
			codeItemModel.setText(StringHelper.format("UID:%1$s", strValue));
			codeItemModel.setValue(strValue);
			this.registerCodeItemModel(codeItemModel);
			return codeItemModel.getText();
		}

		// 重新查出
		try{
			UserService userService = (UserService) ServiceGlobal.getService(UserService.class);
			User user = new User();
			user.setUserId(strValue);
			if (userService.get(user, true)) {
				CodeItemModel codeItemModel = new CodeItemModel();
				codeItemModel.setText(user.getUserName());
				codeItemModel.setValue(user.getUserId());
				this.registerCodeItemModel(codeItemModel);
				return user.getUserName();
			} else {
				CodeItemModel codeItemModel = new CodeItemModel();
				if(SysModelGlobal.isUseLoginNameAsOperator()) {
					codeItemModel.setText(strValue);
				}
				else {
					codeItemModel.setText(StringHelper.format("UID:%1$s", strValue));
				}
				codeItemModel.setValue(user.getUserId());
				this.registerCodeItemModel(codeItemModel);
				return codeItemModel.getText();
			}
		}
		catch(Exception ex){
			log.error(ex);
			CodeItemModel codeItemModel = new CodeItemModel();
			if(SysModelGlobal.isUseLoginNameAsOperator()) {
				codeItemModel.setText(strValue);
			}
			else {
				codeItemModel.setText(StringHelper.format("UID:%1$s", strValue));
			}
			codeItemModel.setValue(strValue);
			this.registerCodeItemModel(codeItemModel);
			return codeItemModel.getText();
		}
		
	}
}
