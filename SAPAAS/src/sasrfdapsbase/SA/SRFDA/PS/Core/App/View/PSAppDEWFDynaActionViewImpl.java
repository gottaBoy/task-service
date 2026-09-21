/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFDynaActionView;
import SA.SRFDA.PS.Core.App.View.PSAppDEWFActionViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveLink;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFDYNAACTIONVIEW"})
public class PSAppDEWFDynaActionViewImpl
extends PSAppDEWFActionViewImpl
implements IPSAppDEWFDynaActionView {
    private List<IPSWFVersion> psWFVersionList = new ArrayList<IPSWFVersion>();
    private List<IPSWFLink> psWFLinkList = new ArrayList<IPSWFLink>();

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        PSDEViewCtrl formPSDEViewCtrl = psDEViewCtrlMap.get("form");
        if (this.getPSWorkflow() != null && formPSDEViewCtrl != null) {
            LinkedHashMap<String, String> psDEFormMap = new LinkedHashMap<String, String>();
            Iterator<IPSWFVersion> psWFVersions = this.getPSWorkflow().getPSWFVersions();
            if (psWFVersions != null) {
                String strWFUtilType = this.getWFUtilType();
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
                        if (StringHelper.isNullOrEmpty((String)strWFUtilType)) {
                            Iterator<IPSWFLink> psWFLinks = iPSWFInteractiveProcess.getPSWFLinks();
                            if (psWFLinks == null) continue;
                            while (psWFLinks.hasNext()) {
                                IPSWFLink iPSWFLink = psWFLinks.next();
                                if (!(iPSWFLink instanceof IPSWFInteractiveLink)) continue;
                                IPSWFInteractiveLink iPSWFInteractiveLink = (IPSWFInteractiveLink)iPSWFLink;
                                String strPSDEFormId = null;
                                String strFormCodeName = null;
                                if (this.isMobileView()) {
                                    if (StringHelper.compare((String)this.getPSDEViewId(), (String)iPSWFInteractiveLink.getMobPSDEViewId(), (boolean)false) != 0) continue;
                                    strPSDEFormId = iPSWFInteractiveLink.getMobPSDEFormId();
                                    strFormCodeName = iPSWFInteractiveLink.getMobFormCodeName();
                                } else {
                                    if (StringHelper.compare((String)this.getPSDEViewId(), (String)iPSWFInteractiveLink.getPSDEViewId(), (boolean)false) != 0) continue;
                                    strPSDEFormId = iPSWFInteractiveLink.getPSDEFormId();
                                    strFormCodeName = iPSWFInteractiveLink.getFormCodeName();
                                }
                                this.psWFLinkList.add(iPSWFInteractiveLink);
                                if (StringHelper.isNullOrEmpty((String)strPSDEFormId) || StringHelper.isNullOrEmpty((String)strFormCodeName)) continue;
                                psDEFormMap.put(strPSDEFormId, strFormCodeName);
                            }
                            continue;
                        }
                        String strPSDEFormId = null;
                        String strFormCodeName = null;
                        if (this.isMobileView()) {
                            if (this.getWFUtilType().equals("ADDSTEPBEFORE")) {
                                strPSDEFormId = iPSWFInteractiveProcess.getMobUtilPSDEFormId();
                                strFormCodeName = iPSWFInteractiveProcess.getMobUtilFormCodeName();
                            } else if (this.getWFUtilType().equals("ADDSTEPAFTER")) {
                                strPSDEFormId = iPSWFInteractiveProcess.getMobUtil2PSDEFormId();
                                strFormCodeName = iPSWFInteractiveProcess.getMobUtil2FormCodeName();
                            } else if (this.getWFUtilType().equals("REASSIGN")) {
                                strPSDEFormId = iPSWFInteractiveProcess.getMobUtil3PSDEFormId();
                                strFormCodeName = iPSWFInteractiveProcess.getMobUtil3FormCodeName();
                            }
                        } else if (this.getWFUtilType().equals("ADDSTEPBEFORE")) {
                            strPSDEFormId = iPSWFInteractiveProcess.getUtilPSDEFormId();
                            strFormCodeName = iPSWFInteractiveProcess.getUtilFormCodeName();
                        } else if (this.getWFUtilType().equals("ADDSTEPAFTER")) {
                            strPSDEFormId = iPSWFInteractiveProcess.getUtil2PSDEFormId();
                            strFormCodeName = iPSWFInteractiveProcess.getUtil2FormCodeName();
                        } else if (this.getWFUtilType().equals("REASSIGN")) {
                            strPSDEFormId = iPSWFInteractiveProcess.getUtil3PSDEFormId();
                            strFormCodeName = iPSWFInteractiveProcess.getUtil3FormCodeName();
                        }
                        if (StringHelper.isNullOrEmpty((String)strPSDEFormId) || StringHelper.isNullOrEmpty((String)strFormCodeName)) continue;
                        psDEFormMap.put(strPSDEFormId, strFormCodeName);
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
}

