/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.drctrl.IPSDEDRTab
 *  net.ibizsys.model.control.drctrl.IPSDEDRTabPage
 *  net.ibizsys.model.control.drctrl.IPSDEDRTabParam
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 *  net.ibizsys.paas.control.drctrl.DRCtrlItem
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.drctrl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.drctrl.IPSDEDRTab;
import net.ibizsys.model.control.drctrl.IPSDEDRTabPage;
import net.ibizsys.model.control.drctrl.IPSDEDRTabParam;
import net.ibizsys.model.control.drctrl.PSDEDRCtrlImpl;
import net.ibizsys.model.control.drctrl.PSDEDRTabPageImpl;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRTabImpl
extends PSDEDRCtrlImpl
implements IPSDEDRTab {
    private static final Log log = LogFactory.getLog(PSDEDRTabImpl.class);
    protected IPSDEDRTabParam iPSDEDRTabParam = null;
    protected ArrayList<IPSDEDRTabPage> psDEDRTabPageList = new ArrayList();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.iPSDEDRTabParam = (IPSDEDRTabParam)iPSControlParam;
            super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void fillDRCtrlItems() throws Exception {
        this.drCtrlRootItem.reset();
        this.psDEDRCtrlItemList.clear();
        this.psDEDRTabPageList.clear();
        if (!this.isHideEditItem()) {
            DRCtrlItem formDRTabPage = new DRCtrlItem();
            formDRTabPage.setId("form");
            if (this.getPSDEDataRelation() != null) {
                formDRTabPage.setText(this.getPSDEDataRelation().getFormCaption());
                if (this.getPSDEDataRelation().getFormCapPSLanguageRes() != null) {
                    formDRTabPage.setTextLanResTag(this.getPSDEDataRelation().getFormCapPSLanguageRes().getLanResTag());
                }
            } else {
                formDRTabPage.setText(this.getPSDataEntity().getLogicName());
                if (this.getPSDataEntity().getLNPSLanguageRes() != null) {
                    formDRTabPage.setTextLanResTag(this.getPSDataEntity().getLNPSLanguageRes().getLanResTag());
                }
            }
            formDRTabPage.setExpanded(true);
            if (this.getFormPSAppView() != null) {
                String strViewId = "FORM";
                String strEmbedViewId = ((IPSAppViewRuntime)this.getFormPSAppView()).generateCtrlUniId();
                String strViewRefMode = StringHelper.format((String)"%1$s:%2$s", (Object)"DRITEM", (Object)strViewId);
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(this.getFormPSAppView().getId());
                psAppViewRef.setParamValue("EMBEDVIEWID", strEmbedViewId);
                IPSAppViewRef iPSAppViewRef = ((IPSAppViewRuntime)this.getPSAppView()).registerPSAppViewRef(psAppViewRef);
                formDRTabPage.setDRViewId(strViewId);
                ObjectNode viewParamJO = iPSAppViewRef.getViewParam(true);
                Iterator viewParamKeys = formDRTabPage.getViewParamNames();
                while (viewParamKeys.hasNext()) {
                    String strKey = (String)viewParamKeys.next();
                    String objValue = formDRTabPage.getViewParam(strKey);
                    JsonNodeHelper.put((ObjectNode)viewParamJO, (String)strKey, (Object)objValue);
                }
            }
            this.drCtrlRootItem.getItems().add(formDRTabPage);
        }
        Iterator psDEDRDetails = this.iPSDEDataRelation.getPSDEDRDetails();
        while (psDEDRDetails.hasNext()) {
            Iterator it;
            ObjectNode drViewParamJO;
            IPSDEDRDetail iPSDEDRDetail = (IPSDEDRDetail)psDEDRDetails.next();
            PSDEDRTabPageImpl psDEDRTabPageImpl = new PSDEDRTabPageImpl();
            psDEDRTabPageImpl.init(this.getPSModelStorageContext(), this, iPSDEDRDetail);
            this.psDEDRTabPageList.add(psDEDRTabPageImpl);
            DRCtrlItem drTabPage = new DRCtrlItem();
            drTabPage.setId(psDEDRTabPageImpl.getName());
            drTabPage.setText(psDEDRTabPageImpl.getCaption());
            if (iPSDEDRDetail.getCapPSLanguageRes() != null) {
                drTabPage.setTextLanResTag(iPSDEDRDetail.getCapPSLanguageRes().getLanResTag());
            }
            drTabPage.setViewParam("srfparentdeid", this.getPSDataEntity().getId());
            if (!StringHelper.isNullOrEmpty((String)iPSDEDRDetail.getCounterId())) {
                drTabPage.setCounterId(iPSDEDRDetail.getCounterId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEDRDetail.getEnableMode())) {
                drTabPage.setEnableMode(iPSDEDRDetail.getEnableMode());
            }
            if (iPSDEDRDetail.getTestPSDEAction() != null) {
                drTabPage.setTestEnableDEActionName(iPSDEDRDetail.getTestPSDEAction().getName());
            }
            if (iPSDEDRDetail.getTestPSDEOPPriv() != null) {
                drTabPage.setTestEnableDEOPPriv(iPSDEDRDetail.getTestPSDEOPPriv().getName());
            }
            if (psDEDRTabPageImpl.getPSDEDRItem() != null && (drViewParamJO = psDEDRTabPageImpl.getPSDEDRItem().getViewParamJO()) != null && (it = drViewParamJO.fieldNames()) != null) {
                while (it.hasNext()) {
                    String strKey = (String)it.next();
                    String strValue = JsonNodeHelper.getString((ObjectNode)drViewParamJO, (String)strKey, null);
                    if (strValue == null) continue;
                    drTabPage.setViewParam(strKey, strValue);
                }
            }
            if (psDEDRTabPageImpl.getPSAppView() != null) {
                String strViewId = psDEDRTabPageImpl.getName().toUpperCase();
                String strViewRefMode = StringHelper.format((String)"%1$s:%2$s", (Object)"DRITEM", (Object)strViewId);
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(psDEDRTabPageImpl.getPSAppView().getId());
                psAppViewRef.setParamValue("EMBEDVIEWID", psDEDRTabPageImpl.getEmbedViewId());
                IPSAppViewRef iPSAppViewRef = ((IPSAppViewRuntime)this.getPSAppView()).registerPSAppViewRef(psAppViewRef);
                drTabPage.setDRViewId(strViewId);
                ObjectNode viewParamJO = iPSAppViewRef.getViewParam(true);
                Iterator viewParamKeys = drTabPage.getViewParamNames();
                while (viewParamKeys.hasNext()) {
                    String strKey = (String)viewParamKeys.next();
                    String objValue = drTabPage.getViewParam(strKey);
                    JsonNodeHelper.put((ObjectNode)viewParamJO, (String)strKey, (Object)objValue);
                }
            }
            this.drCtrlRootItem.getItems().add(drTabPage);
        }
        this.psDEDRCtrlItemList.addAll(this.psDEDRTabPageList);
    }

    public String getControlType() {
        return "DRTAB";
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDEDRTabParam;
    }
}

