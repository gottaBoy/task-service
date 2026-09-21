/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSAppModule
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppDocPublisherImpl
extends PSIBiz5SysAppCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        Iterator psAppViews = iPSApplication.getAllPSAppViews();
        ArrayList<IPSAppView> psAppViewList = new ArrayList<IPSAppView>();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = (IPSAppView)psAppViews.next();
            if (iPSApplication.isPubRefViewOnly() && !iPSAppView.getRefFlag()) continue;
            psAppViewList.add(iPSAppView);
        }
        Collections.sort(psAppViewList, new Comparator<IPSAppView>(){

            @Override
            public int compare(IPSAppView arg0, IPSAppView arg1) {
                return arg0.getCodeName().compareTo(arg1.getCodeName());
            }
        });
        params.put("appviews", psAppViewList);
        Iterator psAppModules = iPSApplication.getAllPSAppModules();
        ArrayList<IPSAppModule> psAppModuleList = new ArrayList<IPSAppModule>();
        while (psAppModules.hasNext()) {
            psAppModuleList.add((IPSAppModule)psAppModules.next());
        }
        Collections.sort(psAppModuleList, new Comparator<IPSAppModule>(){

            @Override
            public int compare(IPSAppModule arg0, IPSAppModule arg1) {
                return arg0.getCodeName().compareTo(arg1.getCodeName());
            }
        });
        params.put("appmodules", psAppModuleList);
        this.savePSSysSFCode(iPSApplication, null, params);
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }
}

