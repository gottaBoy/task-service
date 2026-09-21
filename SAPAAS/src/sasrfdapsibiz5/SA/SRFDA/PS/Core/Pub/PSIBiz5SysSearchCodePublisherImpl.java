/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Search.IPSSysSearchScheme
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSIBiz5SysSearchCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysSearchSchemes = this.iPSSystem.getAllPSSysSearchSchemes();
        while (psSysSearchSchemes.hasNext()) {
            IPSSysSearchScheme iPSSysSearchScheme = (IPSSysSearchScheme)psSysSearchSchemes.next();
            if (iPSSysSearchScheme.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSSysSearchScheme.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
            this.onGenerateCode(iPSSysSearchScheme, null);
        }
    }

    protected abstract void onGenerateCode(IPSSysSearchScheme var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysSearchScheme) {
            IPSSysSearchScheme iPSSysSearchScheme = (IPSSysSearchScheme)iPSObject;
            if (iPSSysSearchScheme.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSSysSearchScheme.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysSearchScheme, list);
            return list;
        }
        return null;
    }
}

