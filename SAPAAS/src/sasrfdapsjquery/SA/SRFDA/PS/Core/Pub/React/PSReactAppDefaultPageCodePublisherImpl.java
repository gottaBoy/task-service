/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppIndexView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 */
package SA.SRFDA.PS.Core.Pub.React;

import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Pub.React.PSReactAppCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSReactAppDefaultPageCodePublisherImpl
extends PSReactAppCodePublisherImpl {
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
        ArrayList<IPSAppView> views = new ArrayList<IPSAppView>();
        HashMap<String, IPSAppView> viewsMap = new HashMap<String, IPSAppView>();
        if (iPSAppIndexView != null) {
            views.add((IPSAppView)iPSAppIndexView);
            this.addChildViews(views, (IPSAppView)iPSAppIndexView);
        }
        int i = 0;
        while (i < views.size()) {
            IPSAppView view = views.get(i);
            if (!viewsMap.containsKey(view.getId())) {
                viewsMap.put(view.getId(), view);
            }
            ++i;
        }
        views.clear();
        views.addAll(viewsMap.values());
        params.put("defaultview", iPSAppIndexView);
        params.put("referenceViews", views);
    }

    private void addChildViews(ArrayList<IPSAppView> views, IPSAppView view) throws Exception {
        if (view != null) {
            Iterator childViews = view.getAllRelatedPSAppViews();
            while (childViews.hasNext()) {
                IPSAppView iPSAppView = (IPSAppView)childViews.next();
                views.add(iPSAppView);
                this.addChildViews(views, iPSAppView);
            }
        }
    }
}

