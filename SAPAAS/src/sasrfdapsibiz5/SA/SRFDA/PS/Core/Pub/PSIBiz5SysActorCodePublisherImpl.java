/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.UML.IPSSysActor
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysActorCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysActors = this.iPSSystem.getAllPSSysActors();
        if (psSysActors != null) {
            while (psSysActors.hasNext()) {
                IPSSysActor iPSSysActor = (IPSSysActor)psSysActors.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysActor.getPSSystemModule() != null && iPSSysActor.getPSSystemModule().isSubSysModule() && !iPSSysActor.getPSSystemModule().isSubSysAsCloud() || iPSSysActor.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysActor.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysActor, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysActor iPSSysActor, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysActor, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysActor) {
            IPSSysActor iPSSysActor = (IPSSysActor)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && iPSSysActor.getPSSystemModule() != null && iPSSysActor.getPSSystemModule().isSubSysModule() && !iPSSysActor.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysActor.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysActor.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysActor, list);
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

