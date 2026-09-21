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
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseInput;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Data.PSSysTestCaseAssert;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d4b\u8bd5\u7528\u4f8b\u65ad\u8a00\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysTCAssert")
public interface IPSSysTestCaseAssert
extends IPSModelObject {
    public static final String ASSERTTYPE_RESULT = "RESULT";
    public static final String ASSERTTYPE_EXCEPTION = "EXCEPTION";
    public static final String ASSERTTYPE_DATAEXISTS = "DATAEXISTS";
    public static final String ASSERTTYPE_NOEXCEPTION = "NOEXCEPTION";
    public static final String ASSERTTYPE_CUSTOMCODE = "CUSTOMCODE";
    public static final String ASSERTTYPE_USER = "USER";
    public static final String ASSERTTYPE_USER2 = "USER2";
    public static final String ASSERTTYPE_USER3 = "USER3";
    public static final String ASSERTTYPE_USER4 = "USER4";

    public void init(ISRFDAGlobalHelper var1, IPSSysTestCaseInput var2, PSSysTestCaseAssert var3) throws Exception;

    public IPSSysTestCaseInput getPSSysTestCaseInput();

    public IPSSysTestData getPSSysTestData();

    public String getAssertType();

    public String getAssertTag();

    public String getAssertTag2();

    public String getAssertTag3();

    public String getAssertTag4();

    public String getExceptionName();

    public String getExceptionTag();

    public String getExceptionTag2();

    public IPSSysTestCase getPSSysTestCase();

    public String getAssertValue();

    public String getScriptCode();
}

