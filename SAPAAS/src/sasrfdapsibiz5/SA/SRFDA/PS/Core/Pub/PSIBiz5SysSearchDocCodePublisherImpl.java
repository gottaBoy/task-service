/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Search.IPSSysSearchDoc
 *  SA.SRFDA.PS.Core.Search.IPSSysSearchScheme
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysSearchCodePublisherImpl;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysSearchDocCodePublisherImpl
extends PSIBiz5SysSearchCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSSysSearchScheme iPSSysSearchScheme, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psSysSearchDocs = iPSSysSearchScheme.getAllPSSysSearchDocs();
        while (psSysSearchDocs.hasNext()) {
            IPSSysSearchDoc iPSSysSearchDoc = (IPSSysSearchDoc)psSysSearchDocs.next();
            this.generateCode(iPSSysSearchDoc, list);
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysSearchDoc) {
            IPSSysSearchDoc iPSSysSearchDoc = (IPSSysSearchDoc)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.generateCode(iPSSysSearchDoc, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode(IPSSysSearchDoc iPSSysSearchDoc, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysSearchDoc, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

