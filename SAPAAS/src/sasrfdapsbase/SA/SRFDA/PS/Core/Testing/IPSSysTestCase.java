/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseAssert;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseInput;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataInst;
import SA.SRFDA.PS.Data.PSSysTestCase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d4b\u8bd5\u7528\u4f8b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="testCaseType", implement="PSSysTestCaseImpl", model="PSSysTestCase")
public interface IPSSysTestCase
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String TARGETTYPE_DEFVR = "DEFVR";
    public static final String TARGETTYPE_DEACTION = "DEACTION";
    public static final String TARGETTYPE_DELOGIC = "DELOGIC";
    public static final String TARGETTYPE_DESADETAIL = "DESADETAIL";
    public static final String TARGETTYPE_APPVIEW = "APPVIEW";
    public static final String TARGETTYPE_CUSTOM = "CUSTOM";
    public static final String ASSERTTYPE_RESULT = "RESULT";
    public static final String ASSERTTYPE_EXCEPTION = "EXCEPTION";
    public static final String ASSERTTYPE_DATAEXISTS = "DATAEXISTS";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysTestCase var3) throws Exception;

    public IPSDataEntity getPSDataEntity();

    public String getTestCaseType();

    public Iterator<IPSSysTestCaseInput> getPSSysTestCaseInputs();

    public String getTestCaseSN();

    public boolean isRollbackTransaction();

    public String getAssertType();

    public IPSSysTestData getPSSysTestData();

    public String getAssertExceptionName();

    public String getAssertExceptionData();

    public String getAssertExceptionData2();

    public IPSSysTestDataInst getPSSysTestDataInst();

    public Iterator<String> getInputValueNames();

    public String getInputValue(String var1);

    public Iterator<String> getAssertResultNames();

    public String getAssertResultValue(String var1);

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public Iterator<IPSSysTestCaseAssert> getPSSysTestCaseAsserts();

    public IPSModelObject getTargetPSModel();

    public int getOrderValue();
}

