/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.WFUtilUIActionTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSetting;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIAction;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysWFSettingService
extends PSSysWFSettingServiceBase {
    private static final String CURSYSTEMID = "SRFCURSYSTEMID";
    private static final Log log = LogFactory.getLog(PSSysWFSettingService.class);

    protected boolean onFillEntityKeyValue(PSSysWFSetting pSSysWFSetting, boolean bl) throws Exception {
        if (!bl && !StringHelper.isNullOrEmpty((String)pSSysWFSetting.getPSSystemId())) {
            pSSysWFSetting.setPSSysWFSettingId(pSSysWFSetting.getPSSystemId());
            return true;
        }
        return super.onFillEntityKeyValue((IEntity)pSSysWFSetting, bl);
    }

    public boolean get(PSSysWFSetting pSSysWFSetting, boolean bl) throws Exception {
        String string = pSSysWFSetting.getPSSysWFSettingId();
        if (StringHelper.compare((String)string, (String)CURSYSTEMID, (boolean)true) == 0) {
            String string2 = this.getWebContext().getAppDataValue("pssystemid");
            if (StringHelper.isNullOrEmpty((String)string2)) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u7cfb\u7edf\u6807\u8bc6"));
            }
            PSSysWFSetting pSSysWFSetting2 = new PSSysWFSetting();
            pSSysWFSetting2.setPSSysWFSettingId(string2);
            if (this.get(pSSysWFSetting2, true)) {
                pSSysWFSetting2.copyTo((IDataObject)pSSysWFSetting, true);
                return true;
            }
            String string3 = this.getWebContext().getAppDataValue("pssystemname");
            pSSysWFSetting.setPSSysWFSettingName(string3);
            pSSysWFSetting.setPSSysWFSettingId(string2);
            pSSysWFSetting.setPSSystemId(string2);
            pSSysWFSetting.setPSSystemName(string3);
            this.create(pSSysWFSetting);
            return true;
        }
        return super.get((IEntity)pSSysWFSetting, bl);
    }

    public void rebuildPSWFUtilActions(PSSysWFSetting pSSysWFSetting) throws Exception {
        Object object222;
        PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFUtilUIAction> arrayList = pSWFUtilUIActionService.selectByPSSysWFSetting(pSSysWFSetting);
        SelectContext selectContext = new SelectContext();
        selectContext.setIsNull("PSDEID");
        selectContext.setIsNotNull("PSSYSUIACTIONID");
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList2 = pSDEUIActionService.select((ISelectCond)selectContext);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Object object222 : arrayList2) {
            hashMap.put(((PSDEUIActionBase)object222).getPSSysUIActionId(), object222);
        }
        HashMap hashMap2 = new HashMap();
        for (PSWFUtilUIAction object3 : arrayList) {
            if (!StringHelper.isNullOrEmpty((String)object3.getPSWorkflowId()) || !StringHelper.isNullOrEmpty((String)object3.getPSWFVersionId())) continue;
            hashMap2.put(object3.getUtilType(), object3);
        }
        object222 = (WFUtilUIActionTypeCodeListModel)CodeListGlobal.getCodeList(WFUtilUIActionTypeCodeListModel.class);
        Iterator iterator = object222.getCodeItems();
        if (iterator != null) {
            while (iterator.hasNext()) {
                ICodeItem iCodeItem = (ICodeItem)iterator.next();
                if (hashMap2.containsKey(iCodeItem.getValue())) continue;
                String string = String.format("EDITVIEW_WF%1$sACTION", iCodeItem.getValue());
                PSDEUIAction pSDEUIAction = (PSDEUIAction)hashMap.get(string);
                if (pSDEUIAction == null) {
                    log.warn((Object)String.format("\u65e0\u6cd5\u83b7\u53d6\u9884\u7f6e\u754c\u9762\u884c\u4e3a[%1$s]\u5bf9\u5e94\u7684\u754c\u9762\u884c\u4e3a", string));
                    continue;
                }
                PSWFUtilUIAction pSWFUtilUIAction = new PSWFUtilUIAction();
                pSWFUtilUIAction.setPSSysWFSettingId(pSSysWFSetting.getPSSysWFSettingId());
                pSWFUtilUIAction.setPSSysWFSettingName("\u5de5\u4f5c\u6d41\u8bbe\u7f6e");
                pSWFUtilUIAction.setUtilType(iCodeItem.getValue());
                pSWFUtilUIAction.setPSWFUtilUIActionName(iCodeItem.getText());
                pSWFUtilUIAction.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
                pSWFUtilUIAction.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
                pSWFUtilUIActionService.create(pSWFUtilUIAction);
            }
        }
    }
}

