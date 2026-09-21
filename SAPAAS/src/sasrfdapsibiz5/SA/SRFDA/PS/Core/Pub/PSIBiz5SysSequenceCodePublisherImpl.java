/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysSequence
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysSequenceCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysSequences = this.iPSSystem.getAllPSSysSequences();
        if (psSysSequences != null) {
            while (psSysSequences.hasNext()) {
                IPSSysSequence iPSSysSequence = (IPSSysSequence)psSysSequences.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysSequence.getPSSystemModule() != null && iPSSysSequence.getPSSystemModule().isSubSysModule() && !iPSSysSequence.getPSSystemModule().isSubSysAsCloud() || iPSSysSequence.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysSequence.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysSequence, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysSequence iPSSysSequence, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysSequence, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysSequence) {
            IPSSysSequence iPSSysSequence = (IPSSysSequence)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && iPSSysSequence.getPSSystemModule() != null && iPSSysSequence.getPSSystemModule().isSubSysModule() && !iPSSysSequence.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysSequence.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysSequence.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysSequence, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        super.onClose();
    }
}

