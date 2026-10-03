/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrlBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEViewCtrlService
extends PSDEViewCtrlServiceBase {
    private static final Log log = LogFactory.getLog(PSDEViewCtrlService.class);

    @Override
    public void getDraftTemp(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        Object object;
        Object object2;
        String string;
        super.getDraftTemp(pSDEViewCtrl);
        if (pSDEViewCtrl.getPSDEViewBase() != null) {
            pSDEViewCtrl.setPSDEId(pSDEViewCtrl.getPSDEViewBase().getPSDEId());
            pSDEViewCtrl.setPSDEName(pSDEViewCtrl.getPSDEViewBase().getPSDEName());
            if (StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEViewCtrlName()) && !StringHelper.isNullOrEmpty((String)(string = pSDEViewCtrl.getPSDEViewCtrlType()))) {
                Object object3;
                object2 = this.selectTempByPSDEViewBase(pSDEViewCtrl.getPSDEViewBase());
                object = new HashMap();
                Iterator iterator = ((ArrayList)object2).iterator();
                while (iterator.hasNext()) {
                    object3 = (PSDEViewCtrl)iterator.next();
                    ((HashMap)object).put(((PSDEViewCtrlBase)object3).getPSDEViewCtrlName().toUpperCase(), object3);
                }
                string = string.toUpperCase();
                int n = 0;
                while (((HashMap)object).containsKey(object3 = StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n + 1))))) {
                    ++n;
                }
                pSDEViewCtrl.setPSDEViewCtrlName((String)object3);
            }
        }
        if (StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSACHandlerId()) && WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)(string = WebContext.getCurrent().getAppDataValue("pssystemid")))) {
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSSYSTEMID", (Object)string);
            selectCond.set("CTRLTYPE", (Object)pSDEViewCtrl.getPSDEViewCtrlType());
            selectCond.set("PSACHANDLERID", SelectCond.ISNOTNULL);
            PSACHandlerService handlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSACHandler> arrayList = handlerService.select((ISelectCond)selectCond);
            if (arrayList.size() == 1) {
                pSDEViewCtrl.setPSACHandlerId(((PSACHandler)arrayList.get(0)).getPSACHandlerId());
                pSDEViewCtrl.setPSACHandlerName(((PSACHandler)arrayList.get(0)).getPSACHandlerName());
            }
        }
    }

    @Override
    public void getDraft(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        super.getDraftTemp(pSDEViewCtrl);
        if (pSDEViewCtrl.getPSDEViewBase() != null) {
            pSDEViewCtrl.setPSDEId(pSDEViewCtrl.getPSDEViewBase().getPSDEId());
            pSDEViewCtrl.setPSDEName(pSDEViewCtrl.getPSDEViewBase().getPSDEName());
        }
    }

    @Override
    protected void onBeforeCreate(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        this.calcDEViewCtrlConfigInfo(pSDEViewCtrl);
        this.calcRealViewCtrlDEId(pSDEViewCtrl);
        super.onBeforeCreate(pSDEViewCtrl);
    }

    @Override
    protected void onBeforeUpdate(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        this.calcDEViewCtrlConfigInfo(pSDEViewCtrl);
        this.calcRealViewCtrlDEId(pSDEViewCtrl);
        super.onBeforeUpdate(pSDEViewCtrl);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        this.calcDEViewCtrlConfigInfo(pSDEViewCtrl);
        super.onBeforeCreateTemp(pSDEViewCtrl);
    }

    protected void internalCreateTemp(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEId()) || StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEName())) {
            pSDEViewCtrl.setPSDEId(pSDEViewCtrl.getPSDEViewBase().getPSDEId());
            pSDEViewCtrl.setPSDEName(pSDEViewCtrl.getPSDEViewBase().getPSDEName());
        }
        super.internalCreateTemp(pSDEViewCtrl);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        this.calcDEViewCtrlConfigInfo(pSDEViewCtrl);
        super.onBeforeUpdateTemp(pSDEViewCtrl);
    }

    protected void calcDEViewCtrlConfigInfo(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        if (PSDEViewCtrlService.isImpSysModelNowEx()) {
            return;
        }
        String string = "";
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEToolbarName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u5de5\u5177\u680f]";
            string = string + pSDEViewCtrl.getPSDEToolbarName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEGridName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u8868\u683c]";
            string = string + pSDEViewCtrl.getPSDEGridName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEDataViewName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u6570\u636e\u89c6\u56fe]";
            string = string + pSDEViewCtrl.getPSDEDataViewName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEFormName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u8868\u5355]";
            string = string + pSDEViewCtrl.getPSDEFormName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEDRName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u5173\u7cfb\u7ec4]";
            string = string + pSDEViewCtrl.getPSDEDRName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEViewName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u5b9e\u4f53\u89c6\u56fe]";
            string = string + pSDEViewCtrl.getPSDEViewName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDETreeViewName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u6811\u89c6\u56fe]";
            string = string + pSDEViewCtrl.getPSDETreeViewName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEChartName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u6570\u636e\u56fe\u8868]";
            string = string + pSDEViewCtrl.getPSDEChartName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEReportName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u62a5\u8868]";
            string = string + pSDEViewCtrl.getPSDEReportName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEListName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u6570\u636e\u5217\u8868]";
            string = string + pSDEViewCtrl.getPSDEListName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEWizardName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u5411\u5bfc]";
            string = string + pSDEViewCtrl.getPSDEWizardName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSSysDashboardName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u6570\u636e\u770b\u677f]";
            string = string + pSDEViewCtrl.getPSSysDashboardName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSSysCalendarName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u65e5\u5386\u90e8\u4ef6]";
            string = string + pSDEViewCtrl.getPSSysCalendarName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSSysSearchBarName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u641c\u7d22\u680f]";
            string = string + pSDEViewCtrl.getPSSysSearchBarName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSSysMsgTemplName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u6d88\u606f\u6a21\u677f]";
            string = string + pSDEViewCtrl.getPSSysMsgTemplName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEActionName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u5904\u7406\u884c\u4e3a]";
            string = string + pSDEViewCtrl.getPSDEActionName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEDataSetName())) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "[\u6570\u636e\u96c6\u5408]";
            string = string + pSDEViewCtrl.getPSDEDataSetName();
        }
        pSDEViewCtrl.setConfigInfo(string);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected void onBeforeRemove(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        super.onBeforeRemove(pSDEViewCtrl);
    }

    @Override
    protected void onBeforeRemoveTemp(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        super.onBeforeRemoveTemp(pSDEViewCtrl);
    }

    @Override
    protected void onAfterCreate(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        super.onAfterCreate(pSDEViewCtrl);
    }

    @Override
    protected void onAfterUpdate(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        super.onAfterUpdate(pSDEViewCtrl);
    }

    @Override
    protected void onChangeEditForm(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srforikey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = jSONObject.optString("srfkey");
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSDEViewCtrl.setPSDEFormId(string2);
            pSDEViewCtrl.setPSDEFormName(jSONObject.optString("psdeformname"));
        }
    }

    @Override
    protected void onChangeToolbar(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srforikey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = jSONObject.optString("srfkey");
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSDEViewCtrl.setPSDEToolbarId(string2);
            pSDEViewCtrl.setPSDEToolbarName(jSONObject.optString("psdetoolbarname"));
        }
    }

    @Override
    protected void onChangeGrid(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srforikey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = jSONObject.optString("srfkey");
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSDEViewCtrl.setPSDEGridId(string2);
            pSDEViewCtrl.setPSDEGridName(jSONObject.optString("psdegridname"));
        }
    }

    protected void calcRealViewCtrlDEId(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        if (PSDEViewCtrlService.isImpSysModelNowEx()) {
            return;
        }
        try {
            if (pSDEViewCtrl.getPSDETreeView() != null) {
                pSDEViewCtrl.setPSDEId(pSDEViewCtrl.getPSDETreeView().getPSDEId());
                pSDEViewCtrl.setPSDEName(pSDEViewCtrl.getPSDETreeView().getPSDEName());
                return;
            }
            if (pSDEViewCtrl.getPSSysCalendar() != null) {
                pSDEViewCtrl.setPSDEId(pSDEViewCtrl.getPSSysCalendar().getPSDEId());
                pSDEViewCtrl.setPSDEName(pSDEViewCtrl.getPSSysCalendar().getPSDEName());
                return;
            }
            if (pSDEViewCtrl.getPSSysDashboard() != null) {
                pSDEViewCtrl.setPSDEId(pSDEViewCtrl.getPSSysDashboard().getPSDEId());
                pSDEViewCtrl.setPSDEName(pSDEViewCtrl.getPSSysDashboard().getPSDEName());
                return;
            }
            if (pSDEViewCtrl.getPSSysMapView() != null) {
                pSDEViewCtrl.setPSDEId(pSDEViewCtrl.getPSSysMapView().getPSDEId());
                pSDEViewCtrl.setPSDEName(pSDEViewCtrl.getPSSysMapView().getPSDEName());
                return;
            }
            if (pSDEViewCtrl.getPSSysViewPanel() != null) {
                pSDEViewCtrl.setPSDEId(pSDEViewCtrl.getPSSysViewPanel().getPSDEId());
                pSDEViewCtrl.setPSDEName(pSDEViewCtrl.getPSSysViewPanel().getPSDEName());
                return;
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u8ba1\u7b97\u89c6\u56fe\u90e8\u4ef6\u5b9e\u9645\u5b9e\u4f53\u6807\u8bc6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEViewCtrl pSDEViewCtrl, String string) throws Exception {
        if ((objectNode = super.fillModelV2(objectNode, pSDEViewCtrl, string)) != null && StringHelper.compare((String)pSDEViewCtrl.getPSDEViewCtrlType(), (String)"TABVIEWPANEL", (boolean)false) == 0 && !StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getCtrlParam2())) {
            try {
                String string2 = this.getModelV2UniqueTag("PSDER", pSDEViewCtrl.getCtrlParam2(), string);
                objectNode.remove("ctrlparam2");
                objectNode.put("ctrlparam2", string2);
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
        return objectNode;
    }

    @Override
    public boolean fillModelV2Key(PSDEViewCtrl pSDEViewCtrl, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        boolean bl2 = super.fillModelV2Key(pSDEViewCtrl, objectNode, string, string2, bl);
        if (bl && objectNode != null && StringHelper.compare((String)pSDEViewCtrl.getPSDEViewCtrlType(), (String)"TABVIEWPANEL", (boolean)false) == 0) {
            try {
                String string3 = JsonNodeHelper.getString((ObjectNode)objectNode, (String)"ctrlparam2", null);
                if (!StringHelper.isNullOrEmpty((String)string3)) {
                    string3 = this.getModelV2Key("PSDER", string3, string, "CTRLPARAM2");
                    pSDEViewCtrl.setCtrlParam2(string3);
                }
            }
            catch (Exception exception) {
                log.error((Object)exception);
                pSDEViewCtrl.setCtrlParam2(null);
            }
        }
        return bl2;
    }
}
