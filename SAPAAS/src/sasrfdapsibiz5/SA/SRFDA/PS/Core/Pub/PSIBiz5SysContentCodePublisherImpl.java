/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysContent
 *  SA.SRFDA.PS.Core.Res.IPSSysContentCat
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysContentCatCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysContent;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysContentCodePublisherImpl
extends PSIBiz5SysContentCatCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSSysContentCat iPSSysContentCat, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psSysContents = iPSSysContentCat.getPSSysContents();
        if (psSysContents != null && psSysContents != null) {
            while (psSysContents.hasNext()) {
                IPSSysContent iPSSysContent = (IPSSysContent)psSysContents.next();
                this.onGenerateCode(iPSSysContent, list);
            }
        }
    }

    protected void onGenerateCode(IPSSysContent iPSSysContent, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysContent, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysContent) {
            IPSSysContent iPSSysContent = (IPSSysContent)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysContent, list);
            return list;
        }
        return null;
    }
}

