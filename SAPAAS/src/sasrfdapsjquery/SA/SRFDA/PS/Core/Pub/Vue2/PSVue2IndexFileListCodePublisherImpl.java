/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;

public class PSVue2IndexFileListCodePublisherImpl
extends PSPFViewCodePublisherImpl {
    protected String getPSAppViewCodeName(IPSAppView iPSAppView) {
        return iPSAppView.getCodeName().toLowerCase();
    }

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        HashMap<String, IPSAppView> requireAppViewMap = new HashMap<String, IPSAppView>();
        ArrayList<Object> requireViewList = new ArrayList<Object>();
        requireViewList.add(this.iPSAppView);
        requireAppViewMap.put(this.iPSAppView.getId(), this.iPSAppView);
        while (requireViewList.size() > 0) {
            IPSAppView iPSAppView = (IPSAppView)requireViewList.remove(0);
            ArrayList psAppViewList = new ArrayList();
            iPSAppView.fillRelatedPSAppViews(psAppViewList);
            for (IPSAppView iPSAppView2 : psAppViewList) {
                if (requireAppViewMap.containsKey(iPSAppView2.getId())) continue;
                requireAppViewMap.put(iPSAppView2.getId(), iPSAppView2);
                requireViewList.add(iPSAppView2);
            }
        }
        requireViewList.clear();
        requireViewList.addAll(requireAppViewMap.values());
        params.put("requireviews", requireViewList);
    }
}

