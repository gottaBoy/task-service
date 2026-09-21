/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.BA.IPSSysBDScheme
 *  SA.SRFDA.PS.Core.BA.IPSSysBDTable
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysBDCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysBDTableCodePublisherImpl
extends PSIBiz5SysBDCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSSysBDScheme iPSSysBDScheme, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psSysBDTables = iPSSysBDScheme.getAllPSSysBDTables();
        if (psSysBDTables != null) {
            while (psSysBDTables.hasNext()) {
                IPSSysBDTable iPSSysBDTable = (IPSSysBDTable)psSysBDTables.next();
                this.generateCode(iPSSysBDTable, list);
            }
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysBDTable) {
            IPSSysBDTable iPSSysBDTable = (IPSSysBDTable)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.generateCode(iPSSysBDTable, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode(IPSSysBDTable iPSSysBDTable, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysBDTable, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

