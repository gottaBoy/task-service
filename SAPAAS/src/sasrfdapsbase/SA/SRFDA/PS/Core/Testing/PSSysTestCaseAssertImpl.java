/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseAssert;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseInput;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Data.PSSysTestCaseAssert;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestCaseAssertImpl
extends PSObjectImpl
implements IPSSysTestCaseAssert {
    private static final Log log = LogFactory.getLog(PSSysTestCaseAssertImpl.class);
    protected PSSysTestCaseAssert psSysTestCaseAssert = null;
    private IPSSysTestCaseInput iPSSysTestCaseInput = null;
    private IPSSysTestData iPSSysTestData = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysTestCaseInput iPSSysTestCaseInput, PSSysTestCaseAssert psSysTestCaseAssert) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psSysTestCaseAssert = psSysTestCaseAssert;
            this.iPSSysTestCaseInput = iPSSysTestCaseInput;
            this.setId(this.psSysTestCaseAssert.getPSSYSTCASSERTID());
            this.setName(this.psSysTestCaseAssert.getPSSYSTCASSERTNAME());
            this.setPSObjectData(this.psSysTestCaseAssert);
            if (!StringHelper.IsNullOrEmpty((String)this.psSysTestCaseAssert.getPSSYSTESTDATAID())) {
                this.iPSSysTestData = this.getPSSysTestCase().getPSSystem().getPSSysTestData(this.psSysTestCaseAssert.getPSSYSTESTDATAID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165", hideempty=true, from="IPSSysTestCase", dumpref=true, from_method="getPSSysTestCaseInput")
    public IPSSysTestCaseInput getPSSysTestCaseInput() {
        return this.iPSSysTestCaseInput;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysTestCaseInput().getPSSysModelInstId();
    }

    @Override
    public IPSSysTestCase getPSSysTestCase() {
        return this.getPSSysTestCaseInput().getPSSysTestCase();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u6570\u636e")
    public IPSSysTestData getPSSysTestData() {
        return this.iPSSysTestData;
    }

    @Override
    public String getModelType() {
        if (StringHelper.Compare((String)this.getPSSysTestCase().getModelType(), (String)"PSSYSTESTCASE2", (boolean)false) == 0) {
            return "PSSYSTCASSERT2";
        }
        return "PSSYSTCASSERT";
    }

    @Override
    public String getModelId() {
        if (this.getPSSysTestCase() != null) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysTestCase().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u65ad\u8a00\u7c7b\u578b", codelist="TestCaseAssertType", fields={"ASSERTTYPE"})
    public String getAssertType() {
        return this.psSysTestCaseAssert.getASSERTTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u65ad\u8a00\u6807\u8bb0", fields={"ASSERTTAG"})
    public String getAssertTag() {
        return this.psSysTestCaseAssert.getASSERTTAG();
    }

    @Override
    @PSModelRTMeta(description="\u65ad\u8a00\u6807\u8bb02", fields={"ASSERTTAG2"})
    public String getAssertTag2() {
        return this.psSysTestCaseAssert.getASSERTTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u65ad\u8a00\u6807\u8bb03", fields={"ASSERTTAG3"})
    public String getAssertTag3() {
        return this.psSysTestCaseAssert.getASSERTTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u65ad\u8a00\u6807\u8bb04", fields={"ASSERTTAG4"})
    public String getAssertTag4() {
        return this.psSysTestCaseAssert.getASSERTTAG4();
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u5e38\u540d\u79f0", fields={"EXCEPTIONNAME"})
    public String getExceptionName() {
        return this.psSysTestCaseAssert.getEXCEPTIONNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u5e38\u6807\u8bb0", fields={"EXCEPTIONDATA"})
    public String getExceptionTag() {
        return this.psSysTestCaseAssert.getEXCEPTIONDATA();
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u5e38\u6807\u8bb02", fields={"EXCEPTIONDATA2"})
    public String getExceptionTag2() {
        return this.psSysTestCaseAssert.getEXCEPTIONDATA2();
    }

    @Override
    @PSModelRTMeta(description="\u65ad\u8a00\u503c", fields={"ASSERTRESULT"})
    public String getAssertValue() {
        return this.psSysTestCaseAssert.getASSERTRESULT();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.psSysTestCaseAssert.getCUSTOMCODE();
    }

    @Override
    @PSModelRTMeta(description="\u5907\u6ce8", hideempty2=true, dynamodelmode=4)
    public String getMemo() {
        return super.getMemo();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysTestCase().getPSSystem());
    }
}

