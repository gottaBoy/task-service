/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI
 *  SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSIBiz5SysMSDepFuncCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psDevSlnMSDepFuncs = this.iPSSystem.getAllPSDevSlnMSDepFuncs();
        if (psDevSlnMSDepFuncs != null) {
            while (psDevSlnMSDepFuncs.hasNext()) {
                IPSDevSlnMSDepFunc iPSDevSlnMSDepFunc = (IPSDevSlnMSDepFunc)psDevSlnMSDepFuncs.next();
                this.onGenerateCode(iPSDevSlnMSDepFunc, null);
            }
        }
    }

    protected abstract void onGenerateCode(IPSDevSlnMSDepFunc var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDevSlnMSDepAPI) {
            IPSDevSlnMSDepFunc iPSDevSlnMSDepFunc = (IPSDevSlnMSDepFunc)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSDevSlnMSDepFunc, list);
            return list;
        }
        return null;
    }
}

