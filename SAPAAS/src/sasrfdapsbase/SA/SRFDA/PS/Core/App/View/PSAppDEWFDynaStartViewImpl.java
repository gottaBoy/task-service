/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFDynaStartView;
import SA.SRFDA.PS.Core.App.View.PSAppDEWFEditViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFStartProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFDYNASTARTVIEW"})
public class PSAppDEWFDynaStartViewImpl
extends PSAppDEWFEditViewImpl
implements IPSAppDEWFDynaStartView {
    private List<IPSWFVersion> psWFVersionList = new ArrayList<IPSWFVersion>();
    private List<IPSWFProcess> psWFProcessList = new ArrayList<IPSWFProcess>();

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
                        if (!(iPSWFProcess instanceof IPSWFStartProcess)) continue;
                        IPSWFStartProcess iPSWFStartProcess = (IPSWFStartProcess)iPSWFProcess;
                        if (this.isMobileView() ? StringHelper.compare((String)this.getPSDEViewId(), (String)iPSWFStartProcess.getMobStartPSDEViewId(), (boolean)false) != 0 : StringHelper.compare((String)this.getPSDEViewId(), (String)iPSWFStartProcess.getStartPSDEViewId(), (boolean)false) != 0) continue;
                        this.psWFProcessList.add(iPSWFStartProcess);
                        String strPSDEFormId = null;
                        String strFormCodeName = null;
                        if (this.isMobileView()) {
                            strPSDEFormId = iPSWFStartProcess.getMobPSDEFormId();
                            strFormCodeName = iPSWFStartProcess.getMobFormCodeName();
                        } else {
                            strPSDEFormId = iPSWFStartProcess.getPSDEFormId();
                            strFormCodeName = iPSWFStartProcess.getFormCodeName();
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
    @PSModelRTMeta(description="\u76f8\u5173\u6d41\u7a0b\u5904\u7406\u96c6\u5408")
    public Iterator<IPSWFProcess> getPSWFProcesses() {
        if (this.psWFProcessList == null || this.psWFProcessList.size() == 0) {
            return null;
        }
        return this.psWFProcessList.iterator();
    }
}

