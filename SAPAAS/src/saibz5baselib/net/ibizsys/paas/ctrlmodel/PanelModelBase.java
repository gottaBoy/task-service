package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.panel.IPanelField;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ISDCtrlHandler;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * 面板部件模型
 * 
 * @author lionlau
 *
 */
public abstract class PanelModelBase extends CtrlModelBase implements IPanelModel {
	
	private static final Log log = LogFactory.getLog(PanelModelBase.class);

	protected ArrayList<IPanelField> panelFieldList = new ArrayList<IPanelField>();
	protected HashMap<String, IPanelField> panelFieldMap = new HashMap<String, IPanelField>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.impl.ControlImpl#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();
		preparePanelFields();
	}

	/**
	 * 建立面板属性项
	 * 
	 * @param strPanelFieldName
	 * @return
	 */
	protected IPanelField createPanelField(String strPanelFieldName) {
		return null;
	}

	/**
	 * 准备面板属性项模型
	 * 
	 * @throws Exception
	 */
	protected void preparePanelFields() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.grid.IGrid#getGridDataItems()
	 */
	@Override
	public Iterator<IPanelField> getPanelFields() {
		return panelFieldList.iterator();
	}

	/**
	 * 获取指定面板属性项
	 * 
	 * @param strName
	 * @return
	 * @throws Exception
	 */
	public IPanelField getPanelField(String strName) throws Exception {
		return getPanelField(strName, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.form.IPanel#getPanelField(java.lang.String, boolean)
	 */
	@Override
	public IPanelField getPanelField(String strName, boolean bTryMode) throws Exception {
		IPanelField iPanelField = this.panelFieldMap.get(strName.toLowerCase());
		if (iPanelField == null) {
			if (bTryMode) return null;

			throw new Exception(StringHelper.format("无法获取面板属性项[%1$s]", strName));
		}
		return iPanelField;
	}

	/**
	 * 注册面板属性项
	 * 
	 * @param iPanelField
	 */
	protected void registerPanelField(IPanelField iPanelField) {
		panelFieldMap.put(iPanelField.getName().toLowerCase(), iPanelField);
		panelFieldList.add(iPanelField);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IPanelModel#fillOutputDatas(net.ibizsys.paas.data.IDataObject, boolean, net.sf.json.JSONObject, net.sf.json.JSONObject, net.sf.json.JSONObject)
	 */
	@Override
	public void fillOutputDatas(IDataObject iDataObject, JSONObject data, JSONObject config) throws Exception {
		if (iDataObject == null) throw new Exception(StringHelper.format("数据对象无效"));

		onFillOutputDatas(iDataObject,  data,  config);
	}
	
	protected void onFillOutputDatas(IDataObject iDataObject,JSONObject data,JSONObject config) throws Exception {
		ICtrlHandler iCtrlHandler = CtrlHandler.getCurrent();
		ISDCtrlHandler iSDCtrlHandler = null;
		boolean bEnableItemPriv = false;
		if (iCtrlHandler != null && iCtrlHandler instanceof ISDCtrlHandler) {
			iSDCtrlHandler = (ISDCtrlHandler) iCtrlHandler;
			bEnableItemPriv = iSDCtrlHandler.isEnableItemPriv();
		}

		java.util.Iterator<IPanelField> panelFields = this.getPanelFields();

		// 值预处理
//		while (panelFields.hasNext()) {
//			IPanelField iPanelField = panelFields.next();
//			String strPrivilegeId = iPanelField.getPrivilegeId();
//			if (!StringHelper.isNullOrEmpty(strPrivilegeId)) {
//				String strHiddenItemId = StringHelper.format("%1$s%2$s", IPanelField.ITEMPRIV_PREFIX, iPanelField.getPrivFieldName());
//				if (bEnableItemPriv) {
//					// 判断是否有权限
//					if ((this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & PrivilegeAbilities.READ) == 0) {
//						iDataObject.set(strHiddenItemId, 0);
//					} else {
//						iDataObject.set(strHiddenItemId, 1);
//					}
//				} else {
//					iDataObject.set(strHiddenItemId, 1);
//				}
//			}
//		}

		panelFields = this.getPanelFields();
		while (panelFields.hasNext()) {
			IPanelField iPanelField = panelFields.next();

			boolean bItemReadOk = true;
//			if (bEnableItemPriv) {
//				String strPrivilegeId = iPanelField.getPrivilegeId();
//				if (!StringHelper.isNullOrEmpty(strPrivilegeId)) {
//					// 判断是否有权限
//					if ((this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & PrivilegeAbilities.READ) == 0) {
//						bItemReadOk = false;
//					}
//				}
//			}

			Object objValue = null;
			if (bItemReadOk) {
				objValue = iPanelField.getOutputValue(this.getViewController().getWebContext(), iDataObject, true);
				if (objValue == null){
					objValue = "";
				}
				
			} else {
				// 没有权限
				objValue = "";
			}
			
			JSONObjectHelper.put(data, iPanelField.getName(), objValue);
			
			if (config != null) {
				JSONObject itemConfig = iPanelField.getConfig(this.getViewController().getWebContext(), iDataObject);
				if (itemConfig != null) {
					config.put(iPanelField.getName(), itemConfig);
				}
			}
		}
	}

	
	

	
	
	@Override
	public String getControlType() {
		return ControlTypes.Panel;
	}

}
