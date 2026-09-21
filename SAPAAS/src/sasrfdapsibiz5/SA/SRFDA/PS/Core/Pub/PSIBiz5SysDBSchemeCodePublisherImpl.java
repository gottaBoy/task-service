/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Database.IPSSysDBScheme
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDBSchemeCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysDBSchemes = this.iPSSystem.getAllPSSysDBSchemes();
        if (psSysDBSchemes != null) {
            while (psSysDBSchemes.hasNext()) {
                IPSSysDBScheme iPSSysDBScheme = (IPSSysDBScheme)psSysDBSchemes.next();
                this.onGenerateCode(iPSSysDBScheme);
            }
        }
    }

    protected void onGenerateCode(IPSSysDBScheme iPSSysDBScheme) throws Exception {
        HashMap params = new HashMap();
        this.savePSSysSFCode(iPSSysDBScheme, null, params);
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }

    protected void onClose() {
        super.onClose();
    }
}

