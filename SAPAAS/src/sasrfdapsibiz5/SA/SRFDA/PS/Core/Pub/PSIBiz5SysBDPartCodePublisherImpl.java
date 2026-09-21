/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.BA.IPSSysBDPart
 *  SA.SRFDA.PS.Core.BA.IPSSysBDScheme
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.BA.IPSSysBDPart;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysBDCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysBDPartCodePublisherImpl
extends PSIBiz5SysBDCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSSysBDScheme iPSSysBDScheme, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psSysBDParts = iPSSysBDScheme.getAllPSSysBDParts();
        if (psSysBDParts != null) {
            while (psSysBDParts.hasNext()) {
                IPSSysBDPart iPSSysBDPart = (IPSSysBDPart)psSysBDParts.next();
                this.generateCode(iPSSysBDPart, list);
            }
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysBDPart) {
            IPSSysBDPart iPSSysBDPart = (IPSSysBDPart)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.generateCode(iPSSysBDPart, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode(IPSSysBDPart iPSSysBDPart, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysBDPart, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

