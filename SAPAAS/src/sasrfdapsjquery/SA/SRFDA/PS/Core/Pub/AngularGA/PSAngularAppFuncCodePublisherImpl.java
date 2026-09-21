/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.Func.IPSAppFunc
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.AngularGA;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Pub.AngularGA.PSAngularAppCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSAngularAppFuncCodePublisherImpl
extends PSAngularAppCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psAppFuncs = this.iPSApplication.getAllPSAppFuncs();
        while (psAppFuncs.hasNext()) {
            IPSAppFunc iPSAppFunc = (IPSAppFunc)psAppFuncs.next();
            if (StringHelper.isNullOrEmpty((String)iPSAppFunc.getCodeName()) && iPSAppFunc.getCodeName() == null) continue;
            this.onGenerateCode(iPSAppFunc, String.valueOf(iPSAppFunc.getCodeName().toLowerCase()) + "/" + iPSAppFunc.getCodeName().toLowerCase());
        }
    }

    public void generateCode(IPSPublisherContext iPSPublisherContext, IPSApplication iPSApplication, IPSAppFunc iPSAppFunc) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSApplication = iPSApplication;
        this.iPSPF = this.iPSApplication.getPSPF();
        this.iPSPFStyle = this.iPSApplication.getPSPFStyle();
        this.onGenerateCode(iPSAppFunc, iPSAppFunc.getCodeName().toLowerCase());
    }
}

