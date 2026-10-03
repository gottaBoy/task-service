/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppIndexView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Pub.PSExtJS5AppCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSExtJS5AppViewListCodePublisherImpl
extends PSExtJS5AppCodePublisherImpl {
    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSAppView iPSAppView;
        super.onFillGenerateCodeParams(params);
        HashMap<String, IPSAppView> requireAppViewMap = new HashMap<String, IPSAppView>();
        ArrayList<Object> requireViewList = new ArrayList<Object>();
        Iterator psAppViews = this.iPSApplication.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            iPSAppView = (IPSAppView)psAppViews.next();
            if (!(iPSAppView instanceof IPSAppIndexView) && !iPSAppView.isUserRefMode()) continue;
            requireViewList.add(iPSAppView);
        }
        while (requireViewList.size() > 0) {
            iPSAppView = (IPSAppView)requireViewList.remove(0);
            if (requireAppViewMap.containsKey(iPSAppView.getId())) continue;
            requireAppViewMap.put(iPSAppView.getId(), iPSAppView);
            ArrayList<IPSAppView> psAppViewList = new ArrayList();
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

