/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.drctrl.DRCtrlItem
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRTab;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRTabPage;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRTabParam;
import SA.SRFDA.PS.Core.Control.DRCtrl.PSDEDRCtrlImpl;
import SA.SRFDA.PS.Core.Control.DRCtrl.PSDEDRTabPageImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"DRTAB"})
public class PSDEDRTabImpl
extends PSDEDRCtrlImpl
implements IPSDEDRTab {
    private static final Log log = LogFactory.getLog(PSDEDRTabImpl.class);
    protected IPSDEDRTabParam iPSDEDRTabParam = null;
    protected ArrayList<IPSDEDRTabPage> psDEDRTabPageList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.iPSDEDRTabParam = (IPSDEDRTabParam)iPSControlParam;
            super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void fillDRCtrlItems() throws Exception {
        boolean bRegisterPSAppViewRefToContainer;
        this.drCtrlRootItem.reset();
        this.psDEDRCtrlItemList.clear();
        this.psDEDRTabPageList.clear();
        boolean bl = bRegisterPSAppViewRefToContainer = !this.isPrepareDefaultPSAppViewLogics();
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
                String strEmbedViewId = this.getFormPSAppView().generateCtrlUniId();
                String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"DRITEM", (Object)strViewId);
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(this.getFormPSAppView().getId());
                psAppViewRef.setParamValue("EMBEDVIEWID", strEmbedViewId);
                IPSAppViewRef iPSAppViewRef = null;
                iPSAppViewRef = bRegisterPSAppViewRefToContainer ? this.getPSControlContainer().registerPSAppViewRef(psAppViewRef) : this.registerPSAppViewRef(psAppViewRef);
                formDRTabPage.setDRViewId(strViewId);
                JSONObject viewParamJO = iPSAppViewRef.getViewParam(true);
                Iterator viewParamKeys = formDRTabPage.getViewParamNames();
                while (viewParamKeys.hasNext()) {
                    String strKey = (String)viewParamKeys.next();
                    String objValue = formDRTabPage.getViewParam(strKey);
                    viewParamJO.put(strKey, (Object)objValue);
                }
            }
            this.drCtrlRootItem.getItems().add(formDRTabPage);
        }
        Iterator<IPSDEDRDetail> psDEDRDetails = this.iPSDEDataRelation.getPSDEDRDetails();
        while (psDEDRDetails.hasNext()) {
            Iterator it;
            JSONObject drViewParamJO;
            IPSDEDRDetail iPSDEDRDetail = psDEDRDetails.next();
            PSDEDRTabPageImpl psDEDRTabPageImpl = new PSDEDRTabPageImpl();
            psDEDRTabPageImpl.init(this.getDAGlobalHelper(), this, iPSDEDRDetail);
            this.psDEDRTabPageList.add(psDEDRTabPageImpl);
            DRCtrlItem drTabPage = new DRCtrlItem();
            drTabPage.setId(psDEDRTabPageImpl.getName());
            drTabPage.setText(psDEDRTabPageImpl.getCaption());
            if (iPSDEDRDetail.getCapPSLanguageRes() != null) {
                drTabPage.setTextLanResTag(iPSDEDRDetail.getCapPSLanguageRes().getLanResTag());
            }
            drTabPage.setViewParam("srfparentdeid", this.getPSDataEntity().getId());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getCounterId())) {
                drTabPage.setCounterId(iPSDEDRDetail.getCounterId());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getEnableMode())) {
                drTabPage.setEnableMode(iPSDEDRDetail.getEnableMode());
            }
            if (iPSDEDRDetail.getTestPSDEAction() != null) {
                drTabPage.setTestEnableDEActionName(iPSDEDRDetail.getTestPSDEAction().getName());
            }
            if (iPSDEDRDetail.getTestPSDEOPPriv() != null) {
                drTabPage.setTestEnableDEOPPriv(iPSDEDRDetail.getTestPSDEOPPriv().getName());
            }
            if (psDEDRTabPageImpl.getPSDEDRItem() != null && (drViewParamJO = psDEDRTabPageImpl.getPSDEDRItem().getViewParamJO()) != null && (it = drViewParamJO.keys()) != null) {
                while (it.hasNext()) {
                    String strKey = (String)it.next();
                    String strValue = drViewParamJO.optString(strKey);
                    if (strValue == null) continue;
                    drTabPage.setViewParam(strKey, strValue);
                }
            }
            if (psDEDRTabPageImpl.getPSAppView() != null) {
                String strViewId = psDEDRTabPageImpl.getName().toUpperCase();
                String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"DRITEM", (Object)strViewId);
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(psDEDRTabPageImpl.getPSAppView().getId());
                psAppViewRef.setParamValue("EMBEDVIEWID", psDEDRTabPageImpl.getEmbedViewId());
                IPSAppViewRef iPSAppViewRef = null;
                iPSAppViewRef = bRegisterPSAppViewRefToContainer ? this.getPSControlContainer().registerPSAppViewRef(psAppViewRef) : this.registerPSAppViewRef(psAppViewRef);
                drTabPage.setDRViewId(strViewId);
                JSONObject viewParamJO = iPSAppViewRef.getViewParam(true);
                Iterator viewParamKeys = drTabPage.getViewParamNames();
                while (viewParamKeys.hasNext()) {
                    String strKey = (String)viewParamKeys.next();
                    String objValue = drTabPage.getViewParam(strKey);
                    viewParamJO.put(strKey, (Object)objValue);
                }
            }
            this.drCtrlRootItem.getItems().add(drTabPage);
        }
        this.psDEDRCtrlItemList.addAll(this.psDEDRTabPageList);
    }

    @Override
    protected String onGetControlType() {
        return "DRTAB";
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDEDRTabParam;
    }

    @Override
    public String getModelType() {
        return "PSDEDRTAB";
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5206\u9875\u96c6\u5408", child=true)
    public Iterator<IPSDEDRTabPage> getPSDEDRTabPages() {
        return this.psDEDRTabPageList.iterator();
    }

    @Override
    public Iterator<IPSDEDRCtrlItem> getPSDEDRCtrlItems() {
        return super.getPSDEDRCtrlItems();
    }
}

