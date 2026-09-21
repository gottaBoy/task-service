/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEEditView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEXDataViewImpl;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.Control.DataInfoBar.IPSDataInfoBar;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFStartProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEOPTVIEW", "DEEDITVIEW", "DEEDITVIEW2", "DEEDITVIEW3", "DEEDITVIEW4"})
public class PSAppDEEditViewImpl
extends PSAppDEXDataViewImpl
implements IPSAppDEEditView {
    protected boolean bShowDataInfoBar = true;
    private boolean bHideEditForm = false;
    private int nMultiFormMode = 0;
    private Map<String, String> dataTypeDEFormMap = null;
    private IPSDataInfoBar iPSDataInfoBar = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isVIEWPARAM4Null()) {
            this.nMultiFormMode = this.psViewBase.getVIEWPARAM4();
        }
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bShowDataInfoBar = this.psViewBase.getVIEWPARAM5();
        }
        if (!this.psViewBase.isVIEWPARAM6Null()) {
            this.bHideEditForm = this.psViewBase.getVIEWPARAM6();
        }
        super.onInit();
        if (this.isEnableUIModelEx() && this.isShowDataInfoBar() && this.getPSDataInfoBar() == null) {
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLID("datainfobar");
            psDEViewCtrl.setPSDEVIEWCTRLNAME("datainfobar");
            psDEViewCtrl.setPSDEVIEWCTRLTYPE("DATAINFOBAR");
            IPSControl iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl);
            if (iPSControl instanceof IPSDataInfoBar) {
                this.iPSDataInfoBar = (IPSDataInfoBar)iPSControl;
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4fe1\u606f\u680f")
    public boolean isShowDataInfoBar() {
        return this.bShowDataInfoBar;
    }

    @Override
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (!this.isPrepareTemplV2logic() && this.isShowDataInfoBar()) {
            this.registerPSAppViewParam("UI.SHOWDATAINFOBAR", "TRUE", "\u663e\u793a\u6570\u636e\u4fe1\u606f\u680f");
        }
        if (this.dataTypeDEFormMap != null) {
            for (Map.Entry<String, String> entry : this.dataTypeDEFormMap.entrySet()) {
                String strMultiFormParam = String.format("MULTIFORM.%1$s", entry.getKey());
                this.registerPSAppViewParam(strMultiFormParam, entry.getValue(), null);
            }
        }
        super.onPreparePSAppViewParams();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898\u680f", ignoredumpvalues="true")
    public boolean isShowCaptionBar() {
        if (this.getPSPFStyle().getPFEngineVer() >= 20) {
            return super.isShowCaptionBar();
        }
        return this.isShowDataInfoBar() && super.isShowCaptionBar();
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u7f16\u8f91\u8868\u5355", ignoredumpvalues="false")
    public boolean isHideEditForm() {
        return this.bHideEditForm;
    }

    @Override
    protected String onGetXDataControlName() {
        return "form";
    }

    @Override
    protected void onPreparePSAppViewRefs() throws Exception {
        super.onPreparePSAppViewRefs();
        if (this.getPSWorkflow() != null && !this.isWFIAMode() && this.isEnableStartWF()) {
            IPSAppWF iPSAppWF = this.getPSApplication().getPSAppWF(this.getPSWorkflow().getId(), true);
            Iterator<IPSWFVersion> psWFVersions = this.getPSWorkflow().getPSWFVersions();
            if (psWFVersions != null) {
                LinkedHashMap<String, String> psDEViewMap = new LinkedHashMap<String, String>();
                while (psWFVersions.hasNext()) {
                    Iterator<IPSWFProcess> psWFProcesses;
                    IPSWFVersion iPSWFVersion = psWFVersions.next();
                    if (iPSAppWF != null && iPSAppWF.hasPSAppWFVer() && this.getPSApplication().getPSAppWFVer(iPSWFVersion.getId(), true) == null || (psWFProcesses = iPSWFVersion.getPSWFProcesses()) == null) continue;
                    while (psWFProcesses.hasNext()) {
                        IPSWFProcess iPSWFProcess = psWFProcesses.next();
                        if (!(iPSWFProcess instanceof IPSWFStartProcess)) continue;
                        String strStartPSDEViewId = "";
                        IPSWFStartProcess iPSWFStartProcess = (IPSWFStartProcess)iPSWFProcess;
                        strStartPSDEViewId = this.isMobileView() ? iPSWFStartProcess.getMobStartPSDEViewId() : iPSWFStartProcess.getStartPSDEViewId();
                        if (StringHelper.isNullOrEmpty((String)strStartPSDEViewId)) continue;
                        psDEViewMap.put(strStartPSDEViewId, StringHelper.format((String)"%1$s", (Object)iPSWFVersion.getVersion()));
                    }
                }
                for (Map.Entry entry : psDEViewMap.entrySet()) {
                    String strViewRefMode = StringHelper.format((String)"%1$s@%2$s", (Object)"WFSTART", entry.getValue());
                    IPSAppView iPSAppView = this.getRefPSAppView(strViewRefMode, true);
                    if (iPSAppView != null) continue;
                    String strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)((String)entry.getKey()));
                    PSAppViewRef psAppViewRef = new PSAppViewRef();
                    psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                    psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                    psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", entry.getKey());
                    this.registerPSAppViewRef(psAppViewRef);
                }
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5185\u7f6e\u591a\u8868\u5355\u6a21\u5f0f", ignoredumpvalues="0", codelist="EditViewMultiFormMode")
    public int getMultiFormMode() {
        return this.nMultiFormMode;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u4fe1\u606f\u680f")
    public IPSDataInfoBar getPSDataInfoBar() {
        return this.iPSDataInfoBar;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u810f\u68c0\u67e5", ignoredumpvalues="true", fields={"VIEWPARAM3"})
    public boolean isEnableDirtyChecking() {
        if (!this.psViewBase.isVIEWPARAM3Null()) {
            return this.psViewBase.getVIEWPARAM3() == 1;
        }
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u6570\u636e\u6a21\u5f0f", codelist="EditViewMarkOpenDataMode", fields={"VIEWPARAM13"})
    public String getMarkOpenDataMode() {
        return this.psViewBase.getVIEWPARAM13();
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        PSDEViewCtrl formPSDEViewCtrl;
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("datainfobar");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDataInfoBar) {
            this.iPSDataInfoBar = (IPSDataInfoBar)iPSControl;
        }
        if (this.getMultiFormMode() != 0 && !this.isManualAppendForms() && (formPSDEViewCtrl = psDEViewCtrlMap.get("form")) != null) {
            Iterator<IPSDEMainState> psDEMainStates;
            this.dataTypeDEFormMap = new LinkedHashMap<String, String>();
            LinkedHashMap<String, String> psDEFormMap = new LinkedHashMap<String, String>();
            if (this.getMultiFormMode() == 1) {
                Iterator<PSDEForm> psDEForms = this.getPSDataEntity().getAllPSDEEditFormDatas();
                if (psDEForms != null) {
                    while (psDEForms.hasNext()) {
                        PSDEForm psDEEditForm = psDEForms.next();
                        if (StringHelper.isNullOrEmpty((String)psDEEditForm.getDATATYPE()) || StringHelper.compare((String)formPSDEViewCtrl.getPSDEFORMID(), (String)psDEEditForm.getPSDEFORMID(), (boolean)false) == 0) continue;
                        boolean bMobileFlag = psDEEditForm.getMOBFLAG();
                        if (this.isMobileView() ? !bMobileFlag : bMobileFlag) continue;
                        psDEFormMap.put(psDEEditForm.getPSDEFORMID(), psDEEditForm.getCODENAME());
                        this.dataTypeDEFormMap.put(psDEEditForm.getDATATYPE(), psDEEditForm.getCODENAME());
                    }
                }
            } else if (this.getMultiFormMode() == 2 && (psDEMainStates = this.getPSDataEntity().getAllPSDEMainStates()) != null) {
                while (psDEMainStates.hasNext()) {
                    IPSDEMainState iPSDEMainState = psDEMainStates.next();
                    String strPSDEFormId = null;
                    String strPSDEFormCodeName = null;
                    if (this.isMobileView()) {
                        strPSDEFormId = iPSDEMainState.getMobPSDEFormId();
                        strPSDEFormCodeName = iPSDEMainState.getMobFormCodeName();
                    } else {
                        strPSDEFormId = iPSDEMainState.getPSDEFormId();
                        strPSDEFormCodeName = iPSDEMainState.getFormCodeName();
                    }
                    if (StringHelper.isNullOrEmpty((String)strPSDEFormId) || StringHelper.isNullOrEmpty((String)strPSDEFormCodeName)) continue;
                    psDEFormMap.put(strPSDEFormId, strPSDEFormCodeName);
                    this.dataTypeDEFormMap.put(iPSDEMainState.getMSTag(), strPSDEFormCodeName);
                }
            }
            for (Map.Entry entry : psDEFormMap.entrySet()) {
                String strFormName = StringHelper.format((String)"_%1$s_%2$s", (Object)"form", entry.getValue()).toLowerCase();
                if (psDEViewCtrlMap.containsKey(strFormName)) continue;
                PSDEViewCtrl multiformPSDEViewCtrl = new PSDEViewCtrl();
                formPSDEViewCtrl.CopyTo(multiformPSDEViewCtrl, false);
                multiformPSDEViewCtrl.RemoveParam("PSDEVIEWCTRLID");
                multiformPSDEViewCtrl.setPSDEVIEWCTRLNAME(strFormName);
                multiformPSDEViewCtrl.setPSDEFORMID((String)entry.getKey());
                psDEViewCtrlMap.put(strFormName, multiformPSDEViewCtrl);
            }
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    @Override
    @PSModelRTMeta(description="\u624b\u52a8\u9644\u52a0\u8868\u5355", ignoredumpvalues="false", fields={"VIEWPARAM17"})
    public boolean isManualAppendForms() {
        if (this.getMultiFormMode() != 0) {
            return this.psViewBase.getVIEWPARAM17() == 1;
        }
        return false;
    }
}

