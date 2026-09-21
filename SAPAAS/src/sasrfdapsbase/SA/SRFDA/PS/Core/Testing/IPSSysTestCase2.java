/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Data.PSSysTestCase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d4b\u8bd5\u9879\u76ee\u7528\u4f8b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e32", model="PSSysTestCase", description="\u6d4b\u8bd5\u9879\u76ee\u6d4b\u8bd5\u7528\u4f8b\u63a5\u53e3")
public interface IPSSysTestCase2
extends IPSSysTestCase {
    public void init(ISRFDAGlobalHelper var1, IPSSysTestPrj var2, IPSSysTestModule var3, PSSysTestCase var4) throws Exception;

    public IPSSysTestPrj getPSSysTestPrj();

    public IPSSysTestModule getPSSysTestModule();
}

