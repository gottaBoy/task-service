/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFDynaEditView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEWFEditViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveLink;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFDYNAEDITVIEW", "DEWFDYNAEDITVIEW3"})
public class PSAppDEWFDynaEditViewImpl
extends PSAppDEWFEditViewImpl
implements IPSAppDEWFDynaEditView {
    private List<IPSWFVersion> psWFVersionList = new ArrayList<IPSWFVersion>();
    private List<IPSWFProcess> psWFProcessList = new ArrayList<IPSWFProcess>();
    private List<IPSWFLink> psWFLinkList = new ArrayList<IPSWFLink>();
    private List<IPSUIActionGroup> psUIActionGroupList = new ArrayList<IPSUIActionGroup>();

    @Override
    protected void onInit() throws Exception {
        this.setWFIAMode(true);
        super.onInit();
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        PSDEViewCtrl formPSDEViewCtrl = psDEViewCtrlMap.get("form");
        if (this.getPSWorkflow() != null && formPSDEViewCtrl != null) {
            LinkedHashMap<String, String> psDEFormMap = new LinkedHashMap<String, String>();
            LinkedHashMap<String, String> psDEUAGroupMap = new LinkedHashMap<String, String>();
            Iterator<IPSWFVersion> psWFVersions = this.getPSWorkflow().getPSWFVersions();
            if (psWFVersions != null) {
                while (psWFVersions.hasNext()) {
                    IPSWFVersion iPSWFVersion = psWFVersions.next();
                    if (this.getPSAppWF() != null && this.getPSAppWF().hasPSAppWFVer() && this.getPSApplication().getPSAppWFVer(iPSWFVersion.getId(), true) == null) continue;
                    this.psWFVersionList.add(iPSWFVersion);
                    Iterator<IPSWFProcess> psWFProcesses = iPSWFVersion.getPSWFProcesses();
                    if (psWFProcesses == null) continue;
                    while (psWFProcesses.hasNext()) {
                        IPSWFProcess iPSWFProcess = psWFProcesses.next();
                        if (!(iPSWFProcess instanceof IPSWFInteractiveProcess)) continue;
                        IPSWFInteractiveProcess iPSWFInteractiveProcess = (IPSWFInteractiveProcess)iPSWFProcess;
                        this.psWFProcessList.add(iPSWFInteractiveProcess);
                        Iterator<IPSWFLink> psWFLinks = iPSWFInteractiveProcess.getPSWFLinks();
                        if (psWFLinks != null) {
                            while (psWFLinks.hasNext()) {
                                IPSWFLink iPSWFLink = psWFLinks.next();
                                if (!(iPSWFLink instanceof IPSWFInteractiveLink)) continue;
                                IPSWFInteractiveLink iPSWFInteractiveLink = (IPSWFInteractiveLink)iPSWFLink;
                                this.psWFLinkList.add(iPSWFInteractiveLink);
                            }
                        }
                        String strPSDEFormId = null;
                        String strFormCodeName = null;
                        if (this.isMobileView()) {
                            strPSDEFormId = iPSWFInteractiveProcess.getMobPSDEFormId();
                            strFormCodeName = iPSWFInteractiveProcess.getMobFormCodeName();
                        } else {
                            strPSDEFormId = iPSWFInteractiveProcess.getPSDEFormId();
                            strFormCodeName = iPSWFInteractiveProcess.getFormCodeName();
                        }
                        if (!StringHelper.isNullOrEmpty((String)strPSDEFormId) && !StringHelper.isNullOrEmpty((String)strFormCodeName)) {
                            psDEFormMap.put(strPSDEFormId, strFormCodeName);
                        }
                        String strPSDEUAGroupId = null;
                        String strUAGroupCodeName = null;
                        if (this.isMobileView()) {
                            strPSDEUAGroupId = iPSWFInteractiveProcess.getMobPSDEUAGroupId();
                            strUAGroupCodeName = iPSWFInteractiveProcess.getMobUAGroupCodeName();
                        } else {
                            strPSDEUAGroupId = iPSWFInteractiveProcess.getPSDEUAGroupId();
                            strUAGroupCodeName = iPSWFInteractiveProcess.getUAGroupCodeName();
                        }
                        if (StringHelper.isNullOrEmpty((String)strPSDEUAGroupId) || StringHelper.isNullOrEmpty((String)strUAGroupCodeName)) continue;
                        psDEUAGroupMap.put(strPSDEUAGroupId, strUAGroupCodeName);
                    }
                }
            }
            for (Map.Entry entry : psDEFormMap.entrySet()) {
                String strWFFormName = StringHelper.format((String)"%1$s_%2$s", (Object)"wfform", entry.getValue()).toLowerCase();
                PSDEViewCtrl wfformPSDEViewCtrl = new PSDEViewCtrl();
                formPSDEViewCtrl.CopyTo(wfformPSDEViewCtrl, false);
                wfformPSDEViewCtrl.RemoveParam("PSDEVIEWCTRLID");
                wfformPSDEViewCtrl.setPSDEVIEWCTRLNAME(strWFFormName);
                wfformPSDEViewCtrl.setPSDEFORMID((String)entry.getKey());
                psDEViewCtrlMap.put(strWFFormName, wfformPSDEViewCtrl);
            }
            for (Map.Entry entry : psDEUAGroupMap.entrySet()) {
                IPSAppDEUIActionGroup iPSUIActionGroup;
                String strPSDEUAGroupId = (String)entry.getKey();
                if (this.getPSAppDataEntity() == null || (iPSUIActionGroup = this.getPSAppDataEntity().getPSAppDEUIActionGroup(strPSDEUAGroupId, true, this)) == null) continue;
                this.psUIActionGroupList.add(iPSUIActionGroup);
            }
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5de5\u4f5c\u6d41\u7248\u672c\u96c6\u5408")
    public Iterator<IPSWFVersion> getPSWFVersions() {
        if (this.psWFVersionList == null || this.psWFVersionList.size() == 0) {
            return null;
        }
        return this.psWFVersionList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u6d41\u7a0b\u5904\u7406\u96c6\u5408")
    public Iterator<IPSWFProcess> getPSWFProcesses() {
        if (this.psWFProcessList == null || this.psWFProcessList.size() == 0) {
            return null;
        }
        return this.psWFProcessList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u96c6\u5408")
    public Iterator<IPSWFLink> getPSWFLinks() {
        if (this.psWFLinkList == null || this.psWFLinkList.size() == 0) {
            return null;
        }
        return this.psWFLinkList.iterator();
    }

    @Override
    protected void onPreparePSAppViewRefs() throws Exception {
        Iterator<PSDEViewBase> psDEViewDatas;
        super.onPreparePSAppViewRefs();
        Iterator<IPSWFLink> psWFLinks = this.getPSWFLinks();
        if (psWFLinks != null) {
            LinkedHashMap<String, String> psDEViewMap = new LinkedHashMap<String, String>();
            while (psWFLinks.hasNext()) {
                IPSWFLink iPSWFLink = psWFLinks.next();
                if (!(iPSWFLink instanceof IPSWFInteractiveLink)) continue;
                IPSWFInteractiveLink iPSWFInteractiveLink = (IPSWFInteractiveLink)iPSWFLink;
                String strPSDEViewBaseId = null;
                String strViewCodeName = null;
                if (this.isMobileView()) {
                    strPSDEViewBaseId = iPSWFInteractiveLink.getMobPSDEViewId();
                    strViewCodeName = iPSWFInteractiveLink.getMobViewCodeName();
                } else {
                    strPSDEViewBaseId = iPSWFInteractiveLink.getPSDEViewId();
                    strViewCodeName = iPSWFInteractiveLink.getViewCodeName();
                }
                if (StringHelper.isNullOrEmpty((String)strPSDEViewBaseId) || StringHelper.isNullOrEmpty((String)strViewCodeName)) continue;
                psDEViewMap.put(strPSDEViewBaseId, strViewCodeName);
            }
            for (Map.Entry entry : psDEViewMap.entrySet()) {
                String strViewRefMode = StringHelper.format((String)"%1$s@%2$s", (Object)"WFACTION", entry.getValue());
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
        if (this.getPSDEWF() != null && (psDEViewDatas = this.getPSDataEntity().getPDTPSDEViewDatas()) != null) {
            ArrayList<PSDEViewBase> wfUtilActionViewList = new ArrayList<PSDEViewBase>();
            while (psDEViewDatas.hasNext()) {
                PSDEViewBase psDEViewBase = psDEViewDatas.next();
                if (StringHelper.compare((String)psDEViewBase.getPSWFDEID(), (String)this.getPSDEWF().getId(), (boolean)false) != 0) continue;
                if (this.isMobileView()) {
                    if (StringHelper.compare((String)psDEViewBase.getPREDEFINEVIEWTYPE(), (String)"MOBWFUTILACTIONVIEW", (boolean)false) != 0) continue;
                    wfUtilActionViewList.add(psDEViewBase);
                    continue;
                }
                if (StringHelper.compare((String)psDEViewBase.getPREDEFINEVIEWTYPE(), (String)"WFUTILACTIONVIEW", (boolean)false) != 0) continue;
                wfUtilActionViewList.add(psDEViewBase);
            }
            for (PSDEViewBase psDEViewBase : wfUtilActionViewList) {
                String strViewRefMode;
                IPSAppView iPSAppView;
                String strPDTParam = psDEViewBase.getPDVTPARAM();
                if (StringHelper.isNullOrEmpty((String)strPDTParam) || (iPSAppView = this.getRefPSAppView(strViewRefMode = StringHelper.format((String)"%1$s@%2$s", (Object)"WFUTILACTION", (Object)strPDTParam), true)) != null) continue;
                String strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                this.registerPSAppViewRef(psAppViewRef);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u754c\u9762\u884c\u4e3a\u7ec4\u96c6\u5408", child=true)
    public Iterator<IPSUIActionGroup> getPSUIActionGroups() {
        if (this.psUIActionGroupList == null || this.psUIActionGroupList.size() == 0) {
            return null;
        }
        return this.psUIActionGroupList.iterator();
    }
}

