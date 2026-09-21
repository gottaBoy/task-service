/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysDictCat
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysDictCat;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDictCatCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysDictCat iPSSysDictCat = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysDictCats = this.iPSSystem.getAllPSSysDictCats();
        if (psSysDictCats != null) {
            while (psSysDictCats.hasNext()) {
                IPSSysDictCat iPSSysDictCat = (IPSSysDictCat)psSysDictCats.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysDictCat.getPSSystemModule() != null && iPSSysDictCat.getPSSystemModule().isSubSysModule() && !iPSSysDictCat.getPSSystemModule().isSubSysAsCloud()) continue;
                this.iPSSysDictCat = iPSSysDictCat;
                this.onGenerateCode(iPSSysDictCat, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysDictCat iPSSysDictCat, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysDictCat, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysDictCat) {
            this.iPSSysDictCat = (IPSSysDictCat)iPSObject;
            if (this.iPSSysDictCat.getPSSystemModule() != null && this.iPSSysDictCat.getPSSystemModule().isSubSysModule() && !this.iPSSysDictCat.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysDictCat, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysDictCat = null;
        super.onClose();
    }
}

