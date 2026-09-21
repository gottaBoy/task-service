/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppIndexView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 */
package SA.SRFDA.PS.Core.Pub.AngularGA;

import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Pub.AngularGA.PSAngularAppCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSAngularAppCreateAppBatPublisherImpl
extends PSAngularAppCodePublisherImpl {
    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSAppView> indexViewList = new ArrayList<IPSAppView>();
        Iterator psAppViews = this.iPSApplication.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = (IPSAppView)psAppViews.next();
            if (!(iPSAppView instanceof IPSAppIndexView)) continue;
            indexViewList.add(iPSAppView);
        }
        params.put("indexviews", indexViewList);
    }
}

