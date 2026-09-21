/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseAssert;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseInput;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.PSSysTestCaseAssertImpl;
import SA.SRFDA.PS.Data.PSSysTestCaseAssert;
import SA.SRFDA.PS.Data.PSSysTestCaseInput;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestCaseInputImpl
extends PSObjectImpl
implements IPSSysTestCaseInput {
    private static final Log log = LogFactory.getLog(PSSysTestCaseInputImpl.class);
    protected PSSysTestCaseInput psSysTestCaseInput = null;
    private ArrayList<IPSSysTestCaseAssert> psSysTestCaseAssertList = null;
    private IPSSysTestCase iPSSysTestCase = null;
    private IPSSysTestData iPSSysTestData = null;
    private IPSDEAction iPSDEAction = null;
    private String strInputType = "DATA";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysTestCase iPSSysTestCase, PSSysTestCaseInput psSysTestCaseInput) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysTestCase = iPSSysTestCase;
            this.psSysTestCaseInput = psSysTestCaseInput;
            this.setId(this.psSysTestCaseInput.getPSSYSTCINPUTID());
            this.setName(this.psSysTestCaseInput.getPSSYSTCINPUTNAME());
            this.setPSObjectData(this.psSysTestCaseInput);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCaseInput.getINPUTTYPE())) {
                this.strInputType = this.psSysTestCaseInput.getINPUTTYPE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCaseInput.getPSDEACTIONID())) {
                if (this.getPSSysTestCase().getPSDataEntity() == null) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u7528\u4f8b\u8f93\u5165\u6307\u5b9a\u4e86\u8f93\u5165\u884c\u4e3a\uff0c\u4f46\u4e0d\u5b58\u5728\u5b9e\u4f53\u5bf9\u8c61"));
                }
                this.iPSDEAction = this.getPSSysTestCase().getPSDataEntity().getPSDEAction(this.psSysTestCaseInput.getPSDEACTIONID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCaseInput.getPSSYSTESTDATAID())) {
                this.iPSSysTestData = this.getPSSysTestCase().getPSSystem().getPSSysTestData(this.psSysTestCaseInput.getPSSYSTESTDATAID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSSysTestCaseAsserts();
        super.onInit();
    }

    protected void onPreparePSSysTestCaseAsserts() throws Exception {
        if (this.psSysTestCaseAssertList != null) {
            this.psSysTestCaseAssertList.clear();
        } else {
            this.psSysTestCaseAssertList = new ArrayList();
        }
        Vector<PSSysTestCaseAssert> psSysTestCaseAssertList = new Vector<PSSysTestCaseAssert>();
        CallResult callResult = this.getPSModelHelper().getPSSysTestCaseAsserts(this.getId(), psSysTestCaseAssertList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165\u65ad\u8a00\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysTestCaseAssert psSysTestCaseAssert : psSysTestCaseAssertList) {
            PSSysTestCaseAssertImpl iPSSysTestCaseAssert = new PSSysTestCaseAssertImpl();
            iPSSysTestCaseAssert.init(this.getDAGlobalHelper(), this, psSysTestCaseAssert);
            this.psSysTestCaseAssertList.add(iPSSysTestCaseAssert);
        }
        if (this.psSysTestCaseAssertList.size() == 0) {
            this.psSysTestCaseAssertList = null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u65ad\u8a00\u96c6\u5408", child=true, dumpref=true, rtdump=2, rtname="getAsserts", from="IPSSysTestCase", outputdoc="false")
    public Iterator<IPSSysTestCaseAssert> getPSSysTestCaseAsserts() {
        if (this.psSysTestCaseAssertList == null || this.psSysTestCaseAssertList.size() == 0) {
            return null;
        }
        return this.psSysTestCaseAssertList.iterator();
    }

    @Override
    public IPSSysTestCase getPSSysTestCase() {
        return this.iPSSysTestCase;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysTestCase().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u6570\u636e", dumpref=true, fields={"PSSYSTESTDATAID"})
    public IPSSysTestData getPSSysTestData() {
        return this.iPSSysTestData;
    }

    @Override
    public String getModelType() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSSysTestCase().getModelType(), (String)"PSSYSTESTCASE2", (boolean)false) == 0) {
            return "PSSYSTCINPUT2";
        }
        return "PSSYSTCINPUT";
    }

    @Override
    public String getModelId() {
        if (this.getPSSysTestCase() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysTestCase().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysTestCase().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u6807\u8bb0", fields={"INPUTTAG"})
    public String getInputTag() {
        return this.psSysTestCaseInput.getINPUTTAG();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u6807\u8bb02", fields={"INPUTTAG2"})
    public String getInputTag2() {
        return this.psSysTestCaseInput.getINPUTTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u6807\u8bb03", fields={"INPUTTAG3"})
    public String getInputTag3() {
        return this.psSysTestCaseInput.getINPUTTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u6807\u8bb04", fields={"INPUTTAG4"})
    public String getInputTag4() {
        return this.psSysTestCaseInput.getINPUTTAG4();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u503c", fields={"INPUTVALUES"})
    public String getInputValue() {
        return this.psSysTestCaseInput.getINPUTVALUES();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u884c\u4e3a", hideempty=true, dumpref=true, from="IPSSysTestCase", from_method="getPSDataEntityMust().getPSDEAction", fields={"PSDEACTIONID"})
    public IPSDEAction getInputPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.psSysTestCaseInput.getCUSTOMCODE();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u7c7b\u578b", codelist="TestCaseInputType", fields={"INPUTTYPE"})
    public String getInputType() {
        return this.strInputType;
    }

    @Override
    @PSModelRTMeta(description="\u5907\u6ce8", hideempty2=true, dynamodelmode=4)
    public String getMemo() {
        return super.getMemo();
    }
}

