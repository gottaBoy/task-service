/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseAssert;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Data.PSSysTestCaseInput;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165\uff08\u8c03\u7528\uff09\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysTCInput")
public interface IPSSysTestCaseInput
extends IPSModelObject {
    public static final String INPUTTYPE_DATA = "DATA";
    public static final String INPUTTYPE_CUSTOMCODE = "CUSTOMCODE";
    public static final String INPUTTYPE_USER = "USER";
    public static final String INPUTTYPE_USER2 = "USER2";
    public static final String INPUTTYPE_USER3 = "USER3";
    public static final String INPUTTYPE_USER4 = "USER4";

    public void init(ISRFDAGlobalHelper var1, IPSSysTestCase var2, PSSysTestCaseInput var3) throws Exception;

    public IPSSysTestCase getPSSysTestCase();

    public Iterator<IPSSysTestCaseAssert> getPSSysTestCaseAsserts();

    public IPSSysTestData getPSSysTestData();

    public IPSDEAction getInputPSDEAction();

    public String getInputTag();

    public String getInputTag2();

    public String getInputTag3();

    public String getInputTag4();

    public String getInputValue();

    public String getScriptCode();

    public String getInputType();
}

