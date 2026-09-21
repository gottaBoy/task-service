/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView;
import SA.SRFDA.PS.Core.App.View.IPSAppDETabExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppDEExplorerViewImpl;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPanel;
import SA.SRFDA.PS.Core.Control.ExpBar.PSTabExpPanelParamImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.PSControlLogicProxy3;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDETabViewPanel;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDER1NItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRSysDER1NItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import net.sf.json.JSONObject;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DETABEXPVIEW", "DETABEXPVIEW9"})
public class PSAppDETabExplorerViewImpl
extends PSAppDEExplorerViewImpl
implements IPSAppDETabExplorerView,
IPSAppDESearchView {
    private String strTabLayout = "TOP";
    private boolean bEnableQuickSearchDefault = false;
    private boolean bEnableQuickSearch = false;
    private IPSDESearchForm iPSDESearchForm = null;
    private boolean bLoadDefault = true;
    private boolean bExpandSearchFormDefault = false;
    private boolean bExpandSearchForm = false;
    private IPSTabExpPanel iPSTabExpPanel = null;

    @Override
    protected void onInit() throws Exception {
        this.bEnableQuickSearch = this.isEnableQuickSearchDefault();
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bEnableQuickSearch = this.psViewBase.getVIEWPARAM5();
        }
        if (!this.psViewBase.isVIEWPARAM6Null()) {
            this.bShowDataInfoBar = this.psViewBase.getVIEWPARAM6();
        }
        this.bExpandSearchForm = this.isExpandSearchFormDefault();
        if (!this.psViewBase.isVIEWPARAM10Null()) {
            this.bExpandSearchForm = this.psViewBase.getVIEWPARAM10() == 1;
        }
        this.bLoadDefault = !this.psViewBase.isLOADDEFAULTNull() ? this.psViewBase.getLOADDEFAULT() : this.isLoadDefaultDefault();
        super.onInit();
        if (!StringHelper.IsNullOrEmpty((String)this.psViewBase.getVIEWPARAM7())) {
            this.strTabLayout = this.psViewBase.getVIEWPARAM7();
        }
        boolean bPrepareParentData = this.isPrepareDefaultPSAppViewLogics();
        ArrayList<IPSControl> psControls = this.getPSControls("tabviewpanel", 40);
        for (IPSControl iPSControl : psControls) {
            IPSDETabViewPanel iPSDETabViewPanel;
            if (!(iPSControl instanceof IPSDEViewPanel)) continue;
            IPSDEViewPanel iPSDEViewPanel = (IPSDEViewPanel)iPSControl;
            String strViewRefMode = StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)iPSControl.getName());
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
            psAppViewRef.setMINORPSAPPVIEWID(iPSDEViewPanel.getPSAppDEView().getId());
            psAppViewRef.setParamValue("EMBEDVIEWID", iPSDEViewPanel.getEmbedViewId());
            IPSAppViewRef ipsAppViewRef = this.getPSAppView().registerPSAppViewRef(psAppViewRef);
            if (!bPrepareParentData || !(iPSDEViewPanel instanceof IPSDETabViewPanel) || (iPSDETabViewPanel = (IPSDETabViewPanel)iPSDEViewPanel).getNavPSDER() == null || !(iPSDETabViewPanel.getNavPSDER() instanceof IPSDER1N)) continue;
            IPSDER1N iPSDER1N = (IPSDER1N)iPSDETabViewPanel.getNavPSDER();
            JSONObject parentDataJO = ipsAppViewRef.getParentDataJO(true);
            parentDataJO.put("srfparentmode", (Object)iPSDER1N.getName());
            parentDataJO.put("srfparentdename", (Object)iPSDER1N.getMajorDEName());
            parentDataJO.put("srfparentdefname", (Object)iPSDER1N.getPickupDEFName());
        }
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("searchform");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDESearchForm) {
            this.iPSDESearchForm = (IPSDESearchForm)iPSControl;
        }
        if (this.getPSPFStyle().getPFEngineVer() >= 20) {
            Iterator<IPSDEDRDetail> psDEDRDetails;
            IPSDataEntity iPSDataEntity = null;
            IPSDEDataRelation iPSDEDataRelation = null;
            PSDEViewCtrl drtabPSDEViewCtrl = psDEViewCtrlMap.remove("drtab");
            PSTabExpPanelParamImpl psTabExpPanelParamImpl = new PSTabExpPanelParamImpl();
            if (drtabPSDEViewCtrl != null) {
                iPSDataEntity = !StringHelper.IsNullOrEmpty((String)drtabPSDEViewCtrl.getPSDEID()) ? this.getPSSystem().getPSDataEntity2(drtabPSDEViewCtrl.getPSDEID(), false) : this.getPSDataEntity();
                if (!StringHelper.IsNullOrEmpty((String)drtabPSDEViewCtrl.getPSSYSPFPLUGINID())) {
                    psTabExpPanelParamImpl.setPSSysPFPluginId(drtabPSDEViewCtrl.getPSSYSPFPLUGINID());
                }
                if (!StringHelper.IsNullOrEmpty((String)drtabPSDEViewCtrl.getPSCTRLLOGICGROUPID())) {
                    psTabExpPanelParamImpl.setPSDEUILogicGroupId(drtabPSDEViewCtrl.getPSCTRLLOGICGROUPID());
                }
                if (!StringHelper.IsNullOrEmpty((String)drtabPSDEViewCtrl.getPSDEDRID())) {
                    iPSDEDataRelation = iPSDataEntity.getPSDEDataRelation(drtabPSDEViewCtrl.getPSDEDRID());
                    if (StringHelper.IsNullOrEmpty((String)psTabExpPanelParamImpl.getPSDEUILogicGroupId()) && !StringHelper.IsNullOrEmpty((String)iPSDEDataRelation.getPSDEUILogicGroupId())) {
                        psTabExpPanelParamImpl.setPSDEUILogicGroupId(iPSDEDataRelation.getPSDEUILogicGroupId());
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)drtabPSDEViewCtrl.getPSSYSCSSID())) {
                    psTabExpPanelParamImpl.setPSSysCssId(drtabPSDEViewCtrl.getPSSYSCSSID());
                }
            }
            psTabExpPanelParamImpl.setTabLayout(this.getTabLayout());
            if (iPSDataEntity != null) {
                psTabExpPanelParamImpl.setPSDEId(iPSDataEntity.getId());
            } else if (this.getPSDataEntity() != null) {
                psTabExpPanelParamImpl.setPSDEId(this.getPSDataEntity().getId());
            }
            this.iPSTabExpPanel = (IPSTabExpPanel)this.registerPSControl("tabexppanel", "TABEXPPANEL", psTabExpPanelParamImpl);
            ArrayList<PSDEViewCtrl> psDEViewCtrlList = new ArrayList<PSDEViewCtrl>();
            int i = 0;
            while (i < 20) {
                String strKey = StringHelper.Format((String)"tabviewpanel%1$s", (Object)(i == 0 ? "" : Integer.valueOf(i + 1)));
                psDEViewCtrl = psDEViewCtrlMap.remove(strKey);
                if (psDEViewCtrl != null) {
                    if (psDEViewCtrl.isORDERVALUENull()) {
                        psDEViewCtrl.setORDERVALUE(99999);
                    }
                    psDEViewCtrlList.add(psDEViewCtrl);
                    if (psDEViewCtrlMap.size() == 0) break;
                }
                ++i;
            }
            Collections.sort(psDEViewCtrlList, new Comparator<PSDEViewCtrl>(){

                @Override
                public int compare(PSDEViewCtrl o1, PSDEViewCtrl o2) {
                    return Integer.valueOf(o1.getORDERVALUE()).compareTo(o2.getORDERVALUE());
                }
            });
            int nDRTabIndex = 20;
            if (iPSDEDataRelation != null && (psDEDRDetails = iPSDEDataRelation.getPSDEDRDetails()) != null) {
                while (psDEDRDetails.hasNext()) {
                    IPSDEDRDetail iPSDEDRDetail = psDEDRDetails.next();
                    PSDEViewCtrl psDEViewCtrl2 = new PSDEViewCtrl();
                    psDEViewCtrl2.setPSDEVIEWCTRLTYPE("TABVIEWPANEL");
                    psDEViewCtrl2.setCAPTION(iPSDEDRDetail.getCaption());
                    if (iPSDEDRDetail.getCapPSLanguageRes() != null) {
                        psDEViewCtrl2.setCAPPSLANRESID(iPSDEDRDetail.getCapPSLanguageRes().getId());
                        psDEViewCtrl2.setCAPPSLANRESNAME(iPSDEDRDetail.getCapPSLanguageRes().getName());
                    }
                    if (iPSDEDRDetail.getPSSysImage() != null) {
                        psDEViewCtrl2.setPSSYSIMAGEID(iPSDEDRDetail.getPSSysImage().getId());
                        psDEViewCtrl2.setPSSYSIMAGENAME(iPSDEDRDetail.getPSSysImage().getName());
                    }
                    if (iPSDEDRDetail.getTestPSDEOPPriv() != null) {
                        psDEViewCtrl2.setPSDEOPPRIVID(iPSDEDRDetail.getTestPSDEOPPriv().getId());
                        psDEViewCtrl2.setPSDEOPPRIVNAME(iPSDEDRDetail.getTestPSDEOPPriv().getName());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)iPSDEDataRelation.getPSSysCounterId()) && !StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getCounterId())) {
                        psDEViewCtrl2.setPSSYSCOUNTERID(iPSDEDataRelation.getPSSysCounterId());
                        psDEViewCtrl2.setCTRLPARAM3(iPSDEDRDetail.getCounterId());
                    }
                    if (iPSDEDRDetail.getPSDEDRItem() != null) {
                        if (StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getPSDEDRItem().getPSDEViewId())) continue;
                        psDEViewCtrl2.setPSDEVIEWID(iPSDEDRDetail.getPSDEDRItem().getPSDEViewId());
                        if (iPSDEDRDetail.getPSDEDRItem() instanceof IPSDEDRDER1NItem) {
                            IPSDEDRDER1NItem iPSDEDRDER1NItem = (IPSDEDRDER1NItem)iPSDEDRDetail.getPSDEDRItem();
                            psDEViewCtrl2.setPSDEID(iPSDEDRDER1NItem.getPSDER1N().getMinorDEId());
                            if (iPSDEDRDER1NItem.getPSDER1N() != null) {
                                psDEViewCtrl2.setCTRLPARAM(iPSDEDRDER1NItem.getPSDER1N().getName());
                                psDEViewCtrl2.setCTRLPARAM2(iPSDEDRDER1NItem.getPSDER1N().getId());
                            }
                        } else if (iPSDEDRDetail.getPSDEDRItem() instanceof IPSDEDRSysDER1NItem) {
                            IPSDEDRSysDER1NItem iPSDEDRSysDER1NItem = (IPSDEDRSysDER1NItem)iPSDEDRDetail.getPSDEDRItem();
                            psDEViewCtrl2.setPSDEID(iPSDEDRSysDER1NItem.getPSDER1N().getMinorDEId());
                            if (iPSDEDRSysDER1NItem.getPSDER1N() != null) {
                                psDEViewCtrl2.setCTRLPARAM(iPSDEDRSysDER1NItem.getPSDER1N().getName());
                                psDEViewCtrl2.setCTRLPARAM2(iPSDEDRSysDER1NItem.getPSDER1N().getId());
                            }
                        }
                    } else {
                        if (iPSDEDRDetail.getPSSysPDTView() == null || StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getPSSysPDTView().getPSDEViewBaseId())) continue;
                        psDEViewCtrl2.setPSDEVIEWID(iPSDEDRDetail.getPSSysPDTView().getPSDEViewBaseId());
                    }
                    ++nDRTabIndex;
                    if (this.isEnableUIModelEx()) {
                        psDEViewCtrl2.setPSDEVIEWCTRLNAME(iPSDEDRDetail.getName());
                    } else {
                        psDEViewCtrl2.setPSDEVIEWCTRLNAME(StringHelper.Format((String)"tabviewpanel%1$s", (Object)nDRTabIndex));
                    }
                    psDEViewCtrlList.add(psDEViewCtrl2);
                }
            }
            for (PSDEViewCtrl psDEViewCtrl2 : psDEViewCtrlList) {
                IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType(psDEViewCtrl2.getPSDEVIEWCTRLTYPE());
                IPSControlParam iPSControlParam = iPSControlType.createPSControlParam(psDEViewCtrl2);
                iPSControlParam.init(this.getDAGlobalHelper(), this, psDEViewCtrl2);
                this.iPSTabExpPanel.registerPSControl(psDEViewCtrl2.getPSDEVIEWCTRLNAME().toLowerCase(), psDEViewCtrl2.getPSDEVIEWCTRLTYPE(), iPSControlParam);
            }
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u90e8\u4ef6\u5e03\u5c40\u6a21\u5f0f", codelist="TabViewTabPos")
    public String getTabLayout() {
        return this.strTabLayout;
    }

    protected boolean isEnableQuickSearchDefault() {
        return this.bEnableQuickSearchDefault;
    }

    protected void setEnableQuickSearchDefault(boolean bEnableQuickSearchDefault) {
        this.bEnableQuickSearchDefault = bEnableQuickSearchDefault;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u641c\u7d22")
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    @Override
    public IPSDESearchForm getPSDESearchForm() {
        return this.iPSDESearchForm;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u641c\u7d22")
    public boolean isEnableSearch() {
        return this.getPSDESearchForm() != null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d\u6570\u636e")
    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    @Override
    protected boolean isLoadDefaultDefault() {
        return true;
    }

    protected boolean isExpandSearchFormDefault() {
        return this.bExpandSearchFormDefault;
    }

    protected void setExpandSearchFormDefault(boolean bExpandSearchFormDefault) {
        this.bExpandSearchFormDefault = bExpandSearchFormDefault;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355")
    public boolean isExpandSearchForm() {
        return this.bExpandSearchForm;
    }

    @Override
    public IPSTabExpPanel getPSTabExpPanel() {
        return this.iPSTabExpPanel;
    }

    @Override
    public void registerPSAppViewLogic(String strKey, IPSAppViewLogic iPSAppViewLogic) throws Exception {
        String strPSViewCtrlName;
        if (this.getPSPFStyle().getPFEngineVer() >= 20 && !StringHelper.IsNullOrEmpty((String)(strPSViewCtrlName = iPSAppViewLogic.getPSViewCtrlName())) && this.getPSTabExpPanel().hasPSControl(strPSViewCtrlName.toLowerCase())) {
            if (this.isEnableUIModelEx()) {
                this.getPSTabExpPanel().registerPSAppViewLogic(iPSAppViewLogic);
            } else {
                this.getPSTabExpPanel().registerPSControlLogic(new PSControlLogicProxy3(this.getPSTabExpPanel(), iPSAppViewLogic));
            }
            return;
        }
        super.registerPSAppViewLogic(strKey, iPSAppViewLogic);
    }

    @Override
    public boolean hasPSControl(String strControlName) {
        if (this.getPSPFStyle().getPFEngineVer() >= 20) {
            if (!super.hasPSControl(strControlName)) {
                if (this.getPSTabExpPanel() != null) {
                    boolean bRet = this.getPSTabExpPanel().hasPSControl(strControlName);
                    return bRet;
                }
                return false;
            }
            return true;
        }
        return super.hasPSControl(strControlName);
    }

    @Override
    public IPSControl getPSControl(String strControlName) throws Exception {
        if (this.getPSPFStyle().getPFEngineVer() >= 20 && !super.hasPSControl(strControlName) && this.getPSTabExpPanel() != null) {
            return this.getPSTabExpPanel().getPSControl(strControlName);
        }
        return super.getPSControl(strControlName);
    }
}

