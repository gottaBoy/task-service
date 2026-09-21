/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 */
package SA.SRFDA.PS.Core.WF.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.WF.View.WFWorkListMDViewPlugin;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.Iterator;

public class WFWorkListMDViewPlugin2
extends WFWorkListMDViewPlugin {
    @Override
    protected void fillRelatedPSAppViews(IPSAppView iPSAppView, ArrayList<IPSAppView> relatedAppViewList, IPSDataEntity iPSDataEntity) throws Exception {
        Iterator<PSDEViewBase> psDEViewBases;
        super.fillRelatedPSAppViews(iPSAppView, relatedAppViewList, iPSDataEntity);
        String strPDTHeader = "";
        if (iPSAppView.isMobileView()) {
            strPDTHeader = "MOB";
        }
        if ((psDEViewBases = iPSDataEntity.getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + "EDITVIEW")) != null) {
            while (psDEViewBases.hasNext()) {
                PSDEViewBase psDEViewBase = psDEViewBases.next();
                String strPSAppDEViewId = Helper.GenUniqueId((String)iPSAppView.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                IPSAppView ipsAppView2 = iPSAppView.getPSApplication().getPSAppView(strPSAppDEViewId, true);
                if (ipsAppView2 == null) continue;
                relatedAppViewList.add(ipsAppView2);
            }
        }
    }
}

