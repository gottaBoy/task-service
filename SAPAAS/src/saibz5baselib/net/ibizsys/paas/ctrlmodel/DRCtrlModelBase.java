package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.core.WFStates;
import net.sf.json.JSONObject;

/**
 * 数据关系部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DRCtrlModelBase extends CtrlModelBase implements IDRCtrlModel {
	private static final Log log = LogFactory.getLog(DRCtrlModelBase.class);

	protected DRCtrlRootItem expBarRootItem = new DRCtrlRootItem();

	@Override
	protected void onInit() throws Exception {
		super.onInit();
		onPrepareRootItem(this.getRootItem());
	}

	/**
	 * 准备数据关系部门根节点
	 * 
	 * @param expBarRootItem
	 * @throws Exception
	 */
	protected void onPrepareRootItem(DRCtrlRootItem expBarRootItem) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IDRCtrlModel#fillFetchResult(net.ibizsys.paas.web.MDAjaxActionResult)
	 */
	@Override
	public void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
		for (IDRCtrlItem iDRBarItem : getRootItem().getItems()) {
			JSONObject jo = DRCtrlItem.toJSONObject(iDRBarItem, null, this);

			fetchResult.getRows().add(jo);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IDRCtrlModel#getRootItem()
	 */
	public DRCtrlRootItem getRootItem() {
		return this.expBarRootItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IDRCtrlModel#getDRCtrlItems()
	 */
	@Override
	public Iterator<IDRCtrlItem> getDRCtrlItems() {
		return getRootItem().getItems().iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IDRCtrlModel#testDRCtrlItemEnabled(net.ibizsys.paas.control.drctrl.IDRCtrlItem)
	 */
	@Override
	public boolean testDRCtrlItemEnabled(IDRCtrlItem iDRCtrlItem) throws Exception {
		if (StringHelper.isNullOrEmpty(iDRCtrlItem.getEnableMode()) || StringHelper.compare(iDRCtrlItem.getEnableMode(), IDRCtrlItem.ENABLEMODE_ALL, true) == 0) return true;

		IWebContext iWebContext = WebContext.getCurrent();
		Object objMap = iWebContext.getAttribute(this.getUniqueId() + "_MAP");
		HashMap<String, Boolean> itemEnabledMap = null;
		if (objMap != null) {
			itemEnabledMap = (HashMap<String, Boolean>) objMap;
		} else {
			itemEnabledMap = new HashMap<String, Boolean>();
			iWebContext.setAttribute(this.getUniqueId() + "_MAP", itemEnabledMap);
		}

		String strEnableMode = StringHelper.format("%1$s_%2$s", iDRCtrlItem.getEnableMode(), iDRCtrlItem.getTestEnableDEActionName());
		if (itemEnabledMap.containsKey(strEnableMode)) {
			return itemEnabledMap.get(strEnableMode);
		}

		boolean bRet = internalTestDRCtrlItemEnabled(iWebContext, iDRCtrlItem);
		itemEnabledMap.put(strEnableMode, bRet);
		return bRet;
	}

	/**
	 * 内部判断关系项是否有效
	 * 
	 * @param iWebContext
	 * @param iDRCtrlItem
	 * @return
	 * @throws Exception
	 */
	protected boolean internalTestDRCtrlItemEnabled(IWebContext iWebContext, IDRCtrlItem iDRCtrlItem) throws Exception {
		String strParentKey = WebContext.getParentKey(iWebContext);
		if (StringHelper.isNullOrEmpty(strParentKey)) {
			return false;
		}

		// 获取当前数据对象
		IEntity iEntity = getActiveEntity(iWebContext, strParentKey);
		String strKey = DataObject.getStringValue(iEntity, this.getDEModel().getKeyDEField().getName(), null);
		if (StringHelper.isNullOrEmpty(strKey)) {
			// 不是有效数据
			return false;
		}

		if (StringHelper.compare(iDRCtrlItem.getEnableMode(), IDRCtrlItem.ENABLEMODE_EDIT, true) == 0) {
			if (!KeyValueHelper.isTempKey(strKey)) {
				return true;
			}

			// 进一步判断有没有原始键值
			String strOriKey = DataObject.getStringValue(iEntity, ServiceBase.ORIGINKEY, null);
			return !(StringHelper.isNullOrEmpty(strOriKey));
		}

		if (StringHelper.compare(iDRCtrlItem.getEnableMode(), IDRCtrlItem.ENABLEMODE_INWF, true) == 0) {
			// 判断数据在流程中
			java.util.Iterator<IDEWF> deWFs = this.getDEModel().getDEWFs();
			if (deWFs != null) {
				while (deWFs.hasNext()) {
					IDEWF iDEWF = deWFs.next();
					if (!StringHelper.isNullOrEmpty(iDEWF.getWFStateField())) {
						if (DataObject.getIntegerValue(iEntity, iDEWF.getWFStateField(), WFStates.NOTSTART) == WFStates.NOTFINISH) return true;
					}
				}
			}

			return (this.getDEModel().testDataInWF(iEntity) != null);
		}

		if (StringHelper.compare(iDRCtrlItem.getEnableMode(), IDRCtrlItem.ENABLEMODE_ALLWF, true) == 0) {
			// 判断数据流程已启动
			java.util.Iterator<IDEWF> deWFs = this.getDEModel().getDEWFs();
			if (deWFs != null) {
				while (deWFs.hasNext()) {
					IDEWF iDEWF = deWFs.next();
					if (!StringHelper.isNullOrEmpty(iDEWF.getWFStateField())) {
						if (DataObject.getIntegerValue(iEntity, iDEWF.getWFStateField(), WFStates.NOTSTART) != WFStates.NOTSTART) return true;
					}
				}
			}
			return false;
		}

		if (StringHelper.compare(iDRCtrlItem.getEnableMode(), IDRCtrlItem.ENABLEMODE_DEOPPRIV, true) == 0) {
			if (StringHelper.isNullOrEmpty(iDRCtrlItem.getTestEnableDEOPPriv())) {
				throw new Exception(StringHelper.format("没有指定关系项[%1$s]有效判断实体操作标识", iDRCtrlItem.getId()));
			}

			IEntity testEntity = this.getDEModel().createEntity();
			iEntity.copyTo(testEntity, false);
			CallResult callResult = WebContext.getCurrent().getUserPrivilegeMgr().testDataAccessAction(WebContext.getCurrent(), this.getDEModel(), testEntity, iDRCtrlItem.getTestEnableDEOPPriv());
			return callResult.isOk();
		}

		if (StringHelper.compare(iDRCtrlItem.getEnableMode(), IDRCtrlItem.ENABLEMODE_CUSTOM, true) == 0) {
			if (StringHelper.isNullOrEmpty(iDRCtrlItem.getTestEnableDEActionName())) {
				throw new Exception(StringHelper.format("没有指定关系项[%1$s]有效判断实体行为", iDRCtrlItem.getId()));
			}

			IEntity testEntity = this.getDEModel().createEntity();
			iEntity.copyTo(testEntity, false);
			IService iService = this.getDEModel().getService(this.getViewController().getSessionFactory());
			iService.executeAction(iDRCtrlItem.getTestEnableDEActionName(), testEntity);
			return DataObject.getIntegerValue(testEntity, ServiceBase.RET, 0) == 1;
		}

		return false;
	}

	/**
	 * 获取当前数据对象
	 * 
	 * @param iWebContext
	 * @param strParentKey
	 * @return
	 * @throws Exception
	 */
	protected IEntity getActiveEntity(IWebContext iWebContext, String strParentKey) throws Exception {
		IService iService = this.getDEModel().getService(this.getViewController().getSessionFactory());
		Object objEntity = iWebContext.getAttribute(this.getUniqueId() + "_ENTITY");
		if (objEntity != null) {
			return (IEntity) objEntity;
		} else {

			IEntity iEntity = iService.getDEModel().createEntity();
			if (KeyValueHelper.isTempKey(strParentKey)) {
				iEntity.set(iService.getDEModel().getKeyDEField().getName(), strParentKey);
				iService.getTemp(iEntity);
			} else {
				iEntity.set(iService.getDEModel().getKeyDEField().getName(), strParentKey);
				if (!iService.get(iEntity, true)) {
					iEntity.reset();
				}
			}
			iWebContext.setAttribute(this.getUniqueId() + "_ENTITY", iEntity);
			return iEntity;
		}
	}

}
