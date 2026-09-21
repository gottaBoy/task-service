/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.WX.IPSWXAccount
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSIBiz5SysWXCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psWXAccounts = this.iPSSystem.getAllPSWXAccounts();
        while (psWXAccounts.hasNext()) {
            IPSWXAccount iPSWXAccount = (IPSWXAccount)psWXAccounts.next();
            if (iPSWXAccount.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSWXAccount.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
            this.onGenerateCode(iPSWXAccount, null);
        }
    }

    protected abstract void onGenerateCode(IPSWXAccount var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSWXAccount) {
            IPSWXAccount iPSWXAccount = (IPSWXAccount)iPSObject;
            if (iPSWXAccount.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSWXAccount.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSWXAccount, list);
            return list;
        }
        return null;
    }
}

