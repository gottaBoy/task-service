/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSIBiz5SysMSDepAPICodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psDevSlnMSDepAPIs = this.iPSSystem.getPSDevSlnMSDepAPIs();
        if (psDevSlnMSDepAPIs != null) {
            while (psDevSlnMSDepAPIs.hasNext()) {
                IPSDevSlnMSDepAPI iPSDevSlnMSDepAPI = (IPSDevSlnMSDepAPI)psDevSlnMSDepAPIs.next();
                this.onGenerateCode(iPSDevSlnMSDepAPI, null);
            }
        }
    }

    protected abstract void onGenerateCode(IPSDevSlnMSDepAPI var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDevSlnMSDepAPI) {
            IPSDevSlnMSDepAPI iPSDevSlnMSDepAPI = (IPSDevSlnMSDepAPI)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSDevSlnMSDepAPI, list);
            return list;
        }
        return null;
    }
}

