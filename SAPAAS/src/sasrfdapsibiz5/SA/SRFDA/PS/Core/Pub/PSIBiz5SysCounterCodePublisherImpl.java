/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSIBiz5SysCounterCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysCounters = this.iPSSystem.getAllPSSysCounters();
        if (psSysCounters != null) {
            while (psSysCounters.hasNext()) {
                IPSSysCounter iPSSysCounter = (IPSSysCounter)psSysCounters.next();
                if (iPSSysCounter.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSSysCounter.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0 || !iPSSysCounter.getRefFlag()) continue;
                this.onGenerateCode(iPSSysCounter, null);
            }
        }
    }

    protected abstract void onGenerateCode(IPSSysCounter var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysCounter) {
            IPSSysCounter iPSSysCounter = (IPSSysCounter)iPSObject;
            if (iPSSysCounter.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSSysCounter.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            if (iPSSysCounter.getRefFlag()) {
                ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
                this.onGenerateCode(iPSSysCounter, list);
                return list;
            }
            return null;
        }
        return null;
    }
}

