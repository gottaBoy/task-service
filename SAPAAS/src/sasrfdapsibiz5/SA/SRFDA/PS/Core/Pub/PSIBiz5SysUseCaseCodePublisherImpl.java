/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.UML.IPSSysUseCase
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysUseCaseCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysUseCases = this.iPSSystem.getAllPSSysUseCases();
        if (psSysUseCases != null) {
            while (psSysUseCases.hasNext()) {
                IPSSysUseCase iPSSysUseCase = (IPSSysUseCase)psSysUseCases.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysUseCase.getPSSystemModule() != null && iPSSysUseCase.getPSSystemModule().isSubSysModule() && !iPSSysUseCase.getPSSystemModule().isSubSysAsCloud() || iPSSysUseCase.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysUseCase.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysUseCase, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysUseCase iPSSysUseCase, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysUseCase, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysUseCase) {
            IPSSysUseCase iPSSysUseCase = (IPSSysUseCase)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && iPSSysUseCase.getPSSystemModule() != null && iPSSysUseCase.getPSSystemModule().isSubSysModule() && !iPSSysUseCase.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysUseCase.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysUseCase.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysUseCase, list);
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

