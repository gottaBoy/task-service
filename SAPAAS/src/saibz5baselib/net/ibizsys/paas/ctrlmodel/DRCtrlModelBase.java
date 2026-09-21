/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IDRCtrlModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DRCtrlModelBase
extends CtrlModelBase
implements IDRCtrlModel {
    private static final Log log = LogFactory.getLog(DRCtrlModelBase.class);
    protected DRCtrlRootItem expBarRootItem = new DRCtrlRootItem();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPrepareRootItem(this.getRootItem());
    }

    protected void onPrepareRootItem(DRCtrlRootItem expBarRootItem) throws Exception {
    }

    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
        for (IDRCtrlItem iDRBarItem : this.getRootItem().getItems()) {
            JSONObject jo = DRCtrlItem.toJSONObject(iDRBarItem, null, this);
            fetchResult.getRows().add(jo);
        }
    }

    public DRCtrlRootItem getRootItem() {
        return this.expBarRootItem;
    }

    @Override
    public Iterator<IDRCtrlItem> getDRCtrlItems() {
        return this.getRootItem().getItems().iterator();
    }

    @Override
    public boolean testDRCtrlItemEnabled(IDRCtrlItem iDRCtrlItem) throws Exception {
        if (StringHelper.isNullOrEmpty(iDRCtrlItem.getEnableMode()) || StringHelper.compare(iDRCtrlItem.getEnableMode(), "ALL", true) == 0) {
            return true;
        }
        IWebContext iWebContext = WebContext.getCurrent();
        Object objMap = iWebContext.getAttribute(String.valueOf(this.getUniqueId()) + "_MAP");
        HashMap<String, Boolean> itemEnabledMap = null;
        if (objMap != null) {
            itemEnabledMap = (HashMap<String, Boolean>)objMap;
        } else {
            itemEnabledMap = new HashMap<String, Boolean>();
            iWebContext.setAttribute(String.valueOf(this.getUniqueId()) + "_MAP", itemEnabledMap);
        }
        String strEnableMode = StringHelper.format("%1$s_%2$s", iDRCtrlItem.getEnableMode(), iDRCtrlItem.getTestEnableDEActionName());
        if (itemEnabledMap.containsKey(strEnableMode)) {
            return (Boolean)itemEnabledMap.get(strEnableMode);
        }
        boolean bRet = this.internalTestDRCtrlItemEnabled(iWebContext, iDRCtrlItem);
        itemEnabledMap.put(strEnableMode, bRet);
        return bRet;
    }

    protected boolean internalTestDRCtrlItemEnabled(IWebContext iWebContext, IDRCtrlItem iDRCtrlItem) throws Exception {
        String strParentKey = WebContext.getParentKey(iWebContext);
        if (StringHelper.isNullOrEmpty(strParentKey)) {
            return false;
        }
        IEntity iEntity = this.getActiveEntity(iWebContext, strParentKey);
        String strKey = DataObject.getStringValue(iEntity, this.getDEModel().getKeyDEField().getName(), null);
        if (StringHelper.isNullOrEmpty(strKey)) {
            return false;
        }
        if (StringHelper.compare(iDRCtrlItem.getEnableMode(), "EDIT", true) == 0) {
            if (!KeyValueHelper.isTempKey(strKey)) {
                return true;
            }
            String strOriKey = DataObject.getStringValue(iEntity, "SRFORIKEY", null);
            return !StringHelper.isNullOrEmpty(strOriKey);
        }
        if (StringHelper.compare(iDRCtrlItem.getEnableMode(), "INWF", true) == 0) {
            Iterator<IDEWF> deWFs = this.getDEModel().getDEWFs();
            if (deWFs != null) {
                while (deWFs.hasNext()) {
                    IDEWF iDEWF = deWFs.next();
                    if (StringHelper.isNullOrEmpty(iDEWF.getWFStateField()) || DataObject.getIntegerValue(iEntity, iDEWF.getWFStateField(), 0) != 1) continue;
                    return true;
                }
            }
            return this.getDEModel().testDataInWF(iEntity) != null;
        }
        if (StringHelper.compare(iDRCtrlItem.getEnableMode(), "ALLWF", true) == 0) {
            Iterator<IDEWF> deWFs = this.getDEModel().getDEWFs();
            if (deWFs != null) {
                while (deWFs.hasNext()) {
                    IDEWF iDEWF = deWFs.next();
                    if (StringHelper.isNullOrEmpty(iDEWF.getWFStateField()) || DataObject.getIntegerValue(iEntity, iDEWF.getWFStateField(), 0) == 0) continue;
                    return true;
                }
            }
            return false;
        }
        if (StringHelper.compare(iDRCtrlItem.getEnableMode(), "DEOPPRIV", true) == 0) {
            if (StringHelper.isNullOrEmpty(iDRCtrlItem.getTestEnableDEOPPriv())) {
                throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5173\u7cfb\u9879[%1$s]\u6709\u6548\u5224\u65ad\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", iDRCtrlItem.getId()));
            }
            Object testEntity = this.getDEModel().createEntity();
            iEntity.copyTo((IDataObject)testEntity, false);
            CallResult callResult = WebContext.getCurrent().getUserPrivilegeMgr().testDataAccessAction(WebContext.getCurrent(), this.getDEModel(), (IEntity)testEntity, iDRCtrlItem.getTestEnableDEOPPriv());
            return callResult.isOk();
        }
        if (StringHelper.compare(iDRCtrlItem.getEnableMode(), "CUSTOM", true) == 0) {
            if (StringHelper.isNullOrEmpty(iDRCtrlItem.getTestEnableDEActionName())) {
                throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5173\u7cfb\u9879[%1$s]\u6709\u6548\u5224\u65ad\u5b9e\u4f53\u884c\u4e3a", iDRCtrlItem.getId()));
            }
            Object testEntity = this.getDEModel().createEntity();
            iEntity.copyTo((IDataObject)testEntity, false);
            IService iService = this.getDEModel().getService(this.getViewController().getSessionFactory());
            iService.executeAction(iDRCtrlItem.getTestEnableDEActionName(), (IEntity)testEntity);
            return DataObject.getIntegerValue(testEntity, "SRFRET", 0) == 1;
        }
        return false;
    }

    protected IEntity getActiveEntity(IWebContext iWebContext, String strParentKey) throws Exception {
        IService iService = this.getDEModel().getService(this.getViewController().getSessionFactory());
        Object objEntity = iWebContext.getAttribute(String.valueOf(this.getUniqueId()) + "_ENTITY");
        if (objEntity != null) {
            return (IEntity)objEntity;
        }
        Object iEntity = iService.getDEModel().createEntity();
        if (KeyValueHelper.isTempKey(strParentKey)) {
            iEntity.set(iService.getDEModel().getKeyDEField().getName(), strParentKey);
            iService.getTemp(iEntity);
        } else {
            iEntity.set(iService.getDEModel().getKeyDEField().getName(), strParentKey);
            if (!iService.get(iEntity, true)) {
                iEntity.reset();
            }
        }
        iWebContext.setAttribute(String.valueOf(this.getUniqueId()) + "_ENTITY", iEntity);
        return iEntity;
    }
}

