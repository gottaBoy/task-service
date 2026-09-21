/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppIndexView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 */
package SA.SRFDA.PS.Core.Pub.Ionic4;

import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4AppCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIonic4AppDefaultPageCodePublisherImpl
extends PSIonic4AppCodePublisherImpl {
    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        IPSAppIndexView iPSAppIndexView = null;
        Iterator psAppViews = this.iPSApplication.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = (IPSAppView)psAppViews.next();
            if (!(iPSAppView instanceof IPSAppIndexView)) continue;
            if (iPSAppIndexView == null) {
                iPSAppIndexView = (IPSAppIndexView)iPSAppView;
            }
            if (!((IPSAppIndexView)iPSAppView).isDefaultPage()) continue;
            iPSAppIndexView = (IPSAppIndexView)iPSAppView;
            break;
        }
        HashMap<String, IPSAppView> views = new HashMap<String, IPSAppView>();
        if (iPSAppIndexView != null) {
            views.put(iPSAppIndexView.getId(), (IPSAppView)iPSAppIndexView);
            this.addChildViews(views, (IPSAppView)iPSAppIndexView);
        }
        ArrayList arrList = new ArrayList();
        arrList.addAll(views.values());
        params.put("defaultview", iPSAppIndexView);
        params.put("referenceViews", arrList);
    }

    private void addChildViews(HashMap<String, IPSAppView> views, IPSAppView view) throws Exception {
        if (view != null) {
            Iterator childViews = view.getAllRelatedPSAppViews();
            while (childViews.hasNext()) {
                IPSAppView iPSAppView = (IPSAppView)childViews.next();
                if (views.containsKey(iPSAppView.getId())) continue;
                views.put(iPSAppView.getId(), iPSAppView);
                this.addChildViews(views, iPSAppView);
            }
        }
    }
}

