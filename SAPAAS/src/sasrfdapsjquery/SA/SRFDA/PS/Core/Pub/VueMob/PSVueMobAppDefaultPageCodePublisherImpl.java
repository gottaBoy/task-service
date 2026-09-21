/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppIndexView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 */
package SA.SRFDA.PS.Core.Pub.VueMob;

import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Pub.VueMob.PSVueMobAppCodePublisherImpl;
import java.util.HashMap;
import java.util.Iterator;

public class PSVueMobAppDefaultPageCodePublisherImpl
extends PSVueMobAppCodePublisherImpl {
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
        params.put("defaultview", iPSAppIndexView);
    }
}

