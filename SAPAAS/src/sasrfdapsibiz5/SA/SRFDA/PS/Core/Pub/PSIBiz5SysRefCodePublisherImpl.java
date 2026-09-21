/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.System.IPSSysRef
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysRefCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysRef iPSSysRef = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysRefs = this.iPSSystem.getAllPSSysRefs();
        if (psSysRefs != null) {
            while (psSysRefs.hasNext()) {
                IPSSysRef iPSSysRef;
                this.iPSSysRef = iPSSysRef = (IPSSysRef)psSysRefs.next();
                this.onGenerateCode(iPSSysRef, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysRef iPSSysRef, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysRef, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysRef) {
            this.iPSSysRef = (IPSSysRef)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysRef, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysRef = null;
        super.onClose();
    }
}

