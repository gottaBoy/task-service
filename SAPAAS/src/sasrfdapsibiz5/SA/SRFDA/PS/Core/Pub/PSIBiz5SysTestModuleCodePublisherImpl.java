/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Testing.IPSSysTestModule
 *  SA.SRFDA.PS.Core.Testing.IPSSysTestPrj
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysTestPrjCodePublisherImpl;
import SA.SRFDA.PS.Core.Testing.IPSSysTestModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysTestModuleCodePublisherImpl
extends PSIBiz5SysTestPrjCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSSysTestPrj iPSSysTestPrj, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psSysTestModules = iPSSysTestPrj.getPSSysTestModules();
        if (psSysTestModules != null) {
            while (psSysTestModules.hasNext()) {
                IPSSysTestModule iPSSysTestModule = (IPSSysTestModule)psSysTestModules.next();
                this.generateCode(iPSSysTestModule, list);
            }
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysTestModule) {
            IPSSysTestModule iPSSysTestModule = (IPSSysTestModule)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.generateCode(iPSSysTestModule, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode(IPSSysTestModule iPSSysTestModule, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysTestModule, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

