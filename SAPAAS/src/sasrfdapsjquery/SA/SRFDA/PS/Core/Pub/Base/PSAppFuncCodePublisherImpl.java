/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.Func.IPSAppFunc
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Base;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Pub.Base.PSAppCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

public class PSAppFuncCodePublisherImpl
extends PSAppCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psAppFuncs = this.iPSApplication.getAllPSAppFuncs();
        while (psAppFuncs.hasNext()) {
            IPSAppFunc iPSAppFunc = (IPSAppFunc)psAppFuncs.next();
            if (StringHelper.IsNullOrEmpty((String)iPSAppFunc.getCodeName())) continue;
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

