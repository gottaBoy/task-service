/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSIBiz5SysAppCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSApplication iPSApplication = null;

    protected void onGenerateCode() throws Exception {
        Iterator psApplications = this.iPSSystem.getAllPSApps();
        while (psApplications.hasNext()) {
            IPSApplication iPSApplication = (IPSApplication)psApplications.next();
            if (iPSApplication.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSApplication.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
            this.iPSApplication = iPSApplication;
            this.onGenerateCode(iPSApplication, null);
        }
    }

    protected abstract void onGenerateCode(IPSApplication var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSApplication) {
            this.iPSApplication = (IPSApplication)iPSObject;
            if (this.iPSApplication.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)this.iPSApplication.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSApplication, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (this.iPSApplication != null && params.get("app") == null) {
            params.put("app", this.iPSApplication);
        }
    }

    protected void onClose() {
        this.iPSApplication = null;
        super.onClose();
    }
}

