/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSIBiz5SysMSDepAppCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psDevSlnMSDepAPIs = this.iPSSystem.getPSDevSlnMSDepApps();
        if (psDevSlnMSDepAPIs != null) {
            while (psDevSlnMSDepAPIs.hasNext()) {
                IPSDevSlnMSDepApp iPSDevSlnMSDepApp = (IPSDevSlnMSDepApp)psDevSlnMSDepAPIs.next();
                this.onGenerateCode(iPSDevSlnMSDepApp, null);
            }
        }
    }

    protected abstract void onGenerateCode(IPSDevSlnMSDepApp var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDevSlnMSDepApp) {
            IPSDevSlnMSDepApp iPSDevSlnMSDepApp = (IPSDevSlnMSDepApp)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSDevSlnMSDepApp, list);
            return list;
        }
        return null;
    }
}

