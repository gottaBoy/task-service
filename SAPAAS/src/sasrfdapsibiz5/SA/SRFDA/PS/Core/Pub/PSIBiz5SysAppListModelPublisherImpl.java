/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysAppListModelPublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    public static final String CODETEMPL_APP = "APP";

    protected void onGenerateCode() throws Exception {
        HashMap params = new HashMap();
        ArrayList<IPSGenerateCodeResult> sysList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psApplications = this.iPSSystem.getAllPSApps();
        while (psApplications.hasNext()) {
            IPSApplication iPSApplication = (IPSApplication)psApplications.next();
            if (iPSApplication.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSApplication.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_APP, iPSApplication, null);
            sysList.add(iPSGenerateCodeResult);
        }
        params.put("apps", sysList);
        this.savePSSysSFCode(this.iPSSystem, null, params);
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }
}

