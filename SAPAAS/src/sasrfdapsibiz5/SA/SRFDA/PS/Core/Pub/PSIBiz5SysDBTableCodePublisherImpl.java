/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Database.IPSSysDBScheme
 *  SA.SRFDA.PS.Core.Database.IPSSysDBTable
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDBTableCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysDBSchemes = this.iPSSystem.getAllPSSysDBSchemes();
        if (psSysDBSchemes != null) {
            while (psSysDBSchemes.hasNext()) {
                IPSSysDBScheme iPSSysDBScheme = (IPSSysDBScheme)psSysDBSchemes.next();
                Iterator psSysDBTables = iPSSysDBScheme.getAllPSSysDBTables();
                if (psSysDBTables == null) continue;
                while (psSysDBTables.hasNext()) {
                    IPSSysDBTable iPSSysDBTable = (IPSSysDBTable)psSysDBTables.next();
                    this.onGenerateCode(iPSSysDBTable);
                }
            }
        }
    }

    protected void onGenerateCode(IPSSysDBTable iPSSysDBTable) throws Exception {
        HashMap params = new HashMap();
        this.savePSSysSFCode(iPSSysDBTable, null, params);
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }

    protected void onClose() {
        super.onClose();
    }
}

