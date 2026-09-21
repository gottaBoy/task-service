/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.WF.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.Plugin.PSAppDEViewPluginBase;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class WFWorkListMDViewPlugin
extends PSAppDEViewPluginBase {
    @Override
    public boolean fillRelatedPSAppViews(IPSAppView iPSAppView, ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        Iterator<IPSDataEntity> psDataEntities = iPSAppView.getPSSystem().getAllPSDataEntities();
        while (psDataEntities.hasNext()) {
            IPSDataEntity iPSDataEntity = psDataEntities.next();
            this.fillRelatedPSAppViews(iPSAppView, relatedAppViewList, iPSDataEntity);
        }
        return false;
    }

    protected void fillRelatedPSAppViews(IPSAppView iPSAppView, ArrayList<IPSAppView> relatedAppViewList, IPSDataEntity iPSDataEntity) throws Exception {
        Iterator<IPSDEWF> psDEWFs = iPSDataEntity.getAllPSDEWFs();
        while (psDEWFs.hasNext()) {
            IPSDEWF iPSDEWF = psDEWFs.next();
            this.fillRelatedPSAppViews(iPSAppView, relatedAppViewList, iPSDEWF);
        }
    }

    protected void fillRelatedPSAppViews(IPSAppView iPSAppView, ArrayList<IPSAppView> relatedAppViewList, IPSDEWF iPSDEWF) throws Exception {
        IPSCodeList iPSCodeList;
        String strPDTHeader = "";
        String strPDTParamPre = "";
        if (iPSAppView.isMobileView()) {
            strPDTHeader = "MOB";
        }
        if (iPSDEWF.getWFStepPSDEField() != null && (iPSCodeList = iPSDEWF.getWFStepPSDEField().getPSCodeList()) != null && iPSCodeList.getPSCodeItems() != null) {
            Iterator<IPSCodeItem> psCodeItems = iPSCodeList.getPSCodeItems();
            while (psCodeItems.hasNext()) {
                IPSCodeItem iPSCodeItem = psCodeItems.next();
                Iterator<IPSWFVersion> psWFVersions = iPSDEWF.getPSWorkflow().getPSWFVersions();
                if (psWFVersions == null) continue;
                while (psWFVersions.hasNext()) {
                    IPSAppView ipsAppView2;
                    String strPSAppDEViewId;
                    PSDEViewBase psDEViewBase;
                    String strPDTParam;
                    IPSWFVersion iPSWFVersion = psWFVersions.next();
                    if (iPSWFVersion.getWFVersion() == 1) {
                        strPDTParam = StringHelper.Format((String)"%1$s:W:%2$s", (Object)iPSDEWF.getCodeName(), (Object)iPSCodeItem.getValue());
                        strPDTParam = strPDTParam.toUpperCase();
                        psDEViewBase = iPSDEWF.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam, true);
                        if (psDEViewBase != null) {
                            strPSAppDEViewId = Helper.GenUniqueId((String)iPSAppView.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                            ipsAppView2 = iPSAppView.getPSApplication().getPSAppView(strPSAppDEViewId, true);
                            if (ipsAppView2 != null) {
                                relatedAppViewList.add(ipsAppView2);
                            }
                        }
                    }
                    strPDTParam = StringHelper.Format((String)"%1$s:%3$sW:%2$s", (Object)iPSDEWF.getCodeName(), (Object)iPSCodeItem.getValue(), (Object)(iPSWFVersion.getWFVersion() == 1 ? "" : Integer.valueOf(iPSWFVersion.getWFVersion())));
                    strPDTParam = strPDTParam.toUpperCase();
                    psDEViewBase = iPSDEWF.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "WFEDITVIEW", strPDTParamPre, strPDTParam, true);
                    if (psDEViewBase == null) continue;
                    strPSAppDEViewId = Helper.GenUniqueId((String)iPSAppView.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                    ipsAppView2 = iPSAppView.getPSApplication().getPSAppView(strPSAppDEViewId, true);
                    if (ipsAppView2 == null) continue;
                    relatedAppViewList.add(ipsAppView2);
                }
            }
        }
    }
}

