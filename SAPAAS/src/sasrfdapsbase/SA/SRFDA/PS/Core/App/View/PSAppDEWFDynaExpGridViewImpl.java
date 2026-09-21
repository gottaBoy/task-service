/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFDynaExpGridView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEWFGridViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
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

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFDYNAEXPGRIDVIEW"})
public class PSAppDEWFDynaExpGridViewImpl
extends PSAppDEWFGridViewImpl
implements IPSAppDEWFDynaExpGridView {
    private List<IPSWFVersion> psWFVersionList = new ArrayList<IPSWFVersion>();
    private List<IPSWFLink> psWFLinkList = new ArrayList<IPSWFLink>();

    @Override
    protected void onInit() throws Exception {
        this.setWFIAMode(true);
        super.onInit();
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        Iterator<IPSWFVersion> psWFVersions;
        if (this.getPSWorkflow() != null && (psWFVersions = this.getPSWorkflow().getPSWFVersions()) != null) {
            while (psWFVersions.hasNext()) {
                IPSWFVersion iPSWFVersion = psWFVersions.next();
                if (this.getPSAppWF() != null && this.getPSAppWF().hasPSAppWFVer() && this.getPSApplication().getPSAppWFVer(iPSWFVersion.getId(), true) == null) continue;
                this.psWFVersionList.add(iPSWFVersion);
                Iterator<IPSWFProcess> psWFProcesses = iPSWFVersion.getPSWFProcesses();
                if (psWFProcesses == null) continue;
                while (psWFProcesses.hasNext()) {
                    IPSWFInteractiveProcess iPSWFInteractiveProcess;
                    Iterator<IPSWFLink> psWFLinks;
                    IPSWFProcess iPSWFProcess = psWFProcesses.next();
                    if (!(iPSWFProcess instanceof IPSWFInteractiveProcess) || (psWFLinks = (iPSWFInteractiveProcess = (IPSWFInteractiveProcess)iPSWFProcess).getPSWFLinks()) == null) continue;
                    while (psWFLinks.hasNext()) {
                        IPSWFLink iPSWFLink = psWFLinks.next();
                        if (!(iPSWFLink instanceof IPSWFInteractiveLink)) continue;
                        IPSWFInteractiveLink iPSWFInteractiveLink = (IPSWFInteractiveLink)iPSWFLink;
                        this.psWFLinkList.add(iPSWFInteractiveLink);
                    }
                }
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
}

