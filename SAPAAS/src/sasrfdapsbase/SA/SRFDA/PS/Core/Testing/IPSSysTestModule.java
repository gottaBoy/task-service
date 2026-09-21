/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Data.PSSysTestModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysTestModule")
public interface IPSSysTestModule
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysTestPrj var2, PSSysTestModule var3) throws Exception;

    public IPSSysTestPrj getPSSysTestPrj();

    public Iterator<IPSSysTestCase> getPSSysTestCases();

    @Override
    public String getCodeName();

    public String getModuleTag();

    public String getModuleTag2();
}

