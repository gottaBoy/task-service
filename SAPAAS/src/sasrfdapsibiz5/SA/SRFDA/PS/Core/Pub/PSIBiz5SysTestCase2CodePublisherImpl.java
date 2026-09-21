/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Testing.IPSSysTestCase
 *  SA.SRFDA.PS.Core.Testing.IPSSysTestModule
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysTestModuleCodePublisherImpl;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestModule;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysTestCase2CodePublisherImpl
extends PSIBiz5SysTestModuleCodePublisherImpl {
    @Override
    protected void generateCode(IPSSysTestModule iPSSysTestModule, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psSysTestCases = iPSSysTestModule.getPSSysTestCases();
        if (psSysTestCases != null) {
            while (psSysTestCases.hasNext()) {
                IPSSysTestCase iPSSysTestCase = (IPSSysTestCase)psSysTestCases.next();
                this.generateCode2(iPSSysTestCase, list);
            }
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysTestCase) {
            IPSSysTestCase iPSSysTestCase = (IPSSysTestCase)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.generateCode2(iPSSysTestCase, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode2(IPSSysTestCase iPSSysTestCase, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysTestCase, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

