/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSDEActionTestCase;
import SA.SRFDA.PS.Core.Testing.IPSDEFVRTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseAssert;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseInput;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataInst;
import SA.SRFDA.PS.Core.Testing.PSSysTestCaseInputImpl;
import SA.SRFDA.PS.Data.PSSysTestCase;
import SA.SRFDA.PS.Data.PSSysTestCaseInput;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestCaseImpl
extends PSSystemObjectImpl
implements IPSSysTestCase,
IPSDEFVRTestCase,
IPSDEActionTestCase,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSSysTestCaseImpl.class);
    protected PSSysTestCase psSysTestCase = null;
    private ArrayList<IPSSysTestCaseInput> psSysTestCaseInputList = null;
    private ArrayList<IPSSysTestCaseAssert> psSysTestCaseAssertList = null;
    private boolean bRollbackTransaction = false;
    private String strAssertType = null;
    private String strTestCaseType = null;
    private IPSSysTestData iPSSysTestData = null;
    private IPSSysTestDataInst iPSSysTestDataInst = null;
    private String strAssertExceptionName = null;
    private String strAssertExceptionData = null;
    private String strAssertExceptionData2 = null;
    private Map<String, String> inputValueMap = new LinkedHashMap<String, String>();
    private Map<String, String> assertResultMap = new LinkedHashMap<String, String>();
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEField iPSDEField = null;
    private String strDEFValue = null;
    private IPSDEAction iPSDEAction = null;
    private IPSSysSampleValue defPSSysSampleValue = null;
    private int nOrderValue = 99999;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysTestCase psSysTestCase) throws Exception {
        try {
            String strValue;
            String strKey;
            Enumeration<Object> it;
            Properties properties;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysTestCase = psSysTestCase;
            this.setId(this.psSysTestCase.getPSSYSTESTCASEID());
            this.setName(this.psSysTestCase.getPSSYSTESTCASENAME());
            this.setPSObjectData(this.psSysTestCase);
            this.strTestCaseType = this.psSysTestCase.getTARGETTYPE();
            this.strAssertType = this.psSysTestCase.getASSERTTYPE();
            if (!this.psSysTestCase.isROLLBACKTRANNull()) {
                this.bRollbackTransaction = this.psSysTestCase.getROLLBACKTRAN();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSSYSTESTDATAID())) {
                this.iPSSysTestData = this.getPSSystem().getPSSysTestData(this.psSysTestCase.getPSSYSTESTDATAID());
                this.iPSSysTestDataInst = this.iPSSysTestData.getPSSysTestDataInst(0);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getDEFPSSYSSAMPLEVALUEID())) {
                this.defPSSysSampleValue = this.getPSSystem().getPSSysSampleValue(this.psSysTestCase.getDEFPSSYSSAMPLEVALUEID());
            }
            this.strAssertExceptionName = this.psSysTestCase.getEXCEPTIONNAME();
            this.strAssertExceptionData = this.psSysTestCase.getEXCEPTIONDATA();
            this.strAssertExceptionData2 = this.psSysTestCase.getEXCEPTIONDATA2();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getINPUTVALUES())) {
                properties = PropertiesHelper.Load((String)this.psSysTestCase.getINPUTVALUES());
                it = properties.keys();
                while (it.hasMoreElements()) {
                    strKey = (String)it.nextElement();
                    strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                    this.inputValueMap.put(strKey.toUpperCase(), strValue);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getASSERTRESULT())) {
                properties = PropertiesHelper.Load((String)this.psSysTestCase.getASSERTRESULT());
                it = properties.keys();
                while (it.hasMoreElements()) {
                    strKey = (String)it.nextElement();
                    strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                    this.assertResultMap.put(strKey.toUpperCase(), strValue);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSDEID())) {
                this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysTestCase.getPSDEID());
            }
            if (!this.psSysTestCase.isORDERVALUENull() && this.psSysTestCase.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psSysTestCase.getORDERVALUE();
            }
            if (this.getPSDataEntity() != null) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getTestCaseType(), (String)"DEFVR", (boolean)true) == 0) {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSDEFID())) {
                        this.iPSDEField = this.getPSDataEntity().getPSDEField(this.psSysTestCase.getPSDEFID());
                    }
                    this.strDEFValue = this.psSysTestCase.getDEFVALUE();
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDEFValue) && this.defPSSysSampleValue != null) {
                        this.strDEFValue = this.defPSSysSampleValue.getSampleValue(false);
                    }
                }
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getTestCaseType(), (String)"DEACTION", (boolean)true) == 0 && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSDEACTIONID())) {
                    this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysTestCase.getPSDEACTIONID());
                }
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
        this.onPreparePSSysTestCaseInputs();
        super.onInit();
    }

    protected void onPreparePSSysTestCaseInputs() throws Exception {
        if (this.psSysTestCaseInputList != null) {
            this.psSysTestCaseInputList.clear();
        } else {
            this.psSysTestCaseInputList = new ArrayList();
        }
        Vector<PSSysTestCaseInput> psSysTestCaseInputList = new Vector<PSSysTestCaseInput>();
        CallResult callResult = this.getPSModelHelper().getPSSysTestCaseInputs(this.getId(), psSysTestCaseInputList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysTestCaseInput psSysTestCaseInput : psSysTestCaseInputList) {
            PSSysTestCaseInputImpl iPSSysTestCaseInput = new PSSysTestCaseInputImpl();
            iPSSysTestCaseInput.init(this.getDAGlobalHelper(), this, psSysTestCaseInput);
            this.psSysTestCaseInputList.add(iPSSysTestCaseInput);
        }
        if (this.psSysTestCaseAssertList != null) {
            this.psSysTestCaseAssertList.clear();
        } else {
            this.psSysTestCaseAssertList = new ArrayList();
        }
        for (IPSSysTestCaseInput iPSSysTestCaseInput : this.psSysTestCaseInputList) {
            Iterator<IPSSysTestCaseAssert> psSysTestCaseAsserts = iPSSysTestCaseInput.getPSSysTestCaseAsserts();
            if (psSysTestCaseAsserts == null) continue;
            while (psSysTestCaseAsserts.hasNext()) {
                IPSSysTestCaseAssert iPSSysTestCaseAssert = psSysTestCaseAsserts.next();
                this.psSysTestCaseAssertList.add(iPSSysTestCaseAssert);
            }
        }
        if (this.psSysTestCaseAssertList.size() == 0) {
            this.psSysTestCaseAssertList = null;
        }
        if (this.psSysTestCaseInputList.size() == 0) {
            this.psSysTestCaseInputList = null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165\u96c6\u5408", hideempty=true, child=true, group="\u903b\u8f91", order=215)
    public Iterator<IPSSysTestCaseInput> getPSSysTestCaseInputs() {
        if (this.psSysTestCaseInputList == null || this.psSysTestCaseInputList.size() == 0) {
            return null;
        }
        return this.psSysTestCaseInputList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u7528\u4f8b\u65ad\u8a00\u96c6\u5408", hideempty=true, child=true, ignorert=3, group="\u903b\u8f91", order=217)
    public Iterator<IPSSysTestCaseAssert> getPSSysTestCaseAsserts() {
        if (this.psSysTestCaseAssertList == null || this.psSysTestCaseAssertList.size() == 0) {
            return null;
        }
        return this.psSysTestCaseAssertList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u4f8b\u7c7b\u578b", codelist="TestCaseTargetType", group="\u57fa\u672c", order=125, fields={"TARGETTYPE"})
    public String getTestCaseType() {
        return this.strTestCaseType;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6a21\u578b", group="\u57fa\u672c", order=127)
    public IPSModelObject getTargetPSModel() {
        return this.onGetTargetPSModel();
    }

    protected IPSModelObject onGetTargetPSModel() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getTestCaseType(), (String)"DEACTION", (boolean)false) == 0) {
            return this.getPSDEAction();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getTestCaseType(), (String)"DEFVR", (boolean)false) == 0) {
            return this.getPSDEField();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u7528\u4f8b\u7f16\u53f7", fields={"TESTCASESN"})
    public String getTestCaseSN() {
        return this.psSysTestCase.getTESTCASESN();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u52a1\u56de\u6eda", fields={"ROLLBACKTRAN"})
    public boolean isRollbackTransaction() {
        return this.bRollbackTransaction;
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u65ad\u8a00\u7c7b\u578b", codelist="TestCaseAssertType", fields={"ASSERTTYPE"})
    public String getAssertType() {
        return this.strAssertType;
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u6570\u636e", hideempty=true, dumpref=true, fields={"PSSYSTESTDATAID"})
    public IPSSysTestData getPSSysTestData() {
        return this.iPSSysTestData;
    }

    @Override
    @PSModelRTMeta(description="\u65ad\u8a00\u5f02\u5e38\u540d\u79f0", fields={"EXCEPTIONNAME"})
    public String getAssertExceptionName() {
        return this.strAssertExceptionName;
    }

    @Override
    @PSModelRTMeta(description="\u65ad\u8a00\u5f02\u5e38\u6570\u636e", hideempty2=true, fields={"EXCEPTIONDATA"})
    public String getAssertExceptionData() {
        return this.strAssertExceptionData;
    }

    @Override
    @PSModelRTMeta(description="\u65ad\u8a00\u5f02\u5e38\u6570\u636e2", hideempty2=true, fields={"EXCEPTIONDATA2"})
    public String getAssertExceptionData2() {
        return this.strAssertExceptionData2;
    }

    @Override
    public IPSSysTestDataInst getPSSysTestDataInst() {
        return this.iPSSysTestDataInst;
    }

    @Override
    public Iterator<String> getInputValueNames() {
        return this.inputValueMap.keySet().iterator();
    }

    @Override
    public String getInputValue(String strName) {
        return this.inputValueMap.get(strName.toUpperCase());
    }

    @Override
    public Iterator<String> getAssertResultNames() {
        return this.assertResultMap.keySet().iterator();
    }

    @Override
    public String getAssertResultValue(String strName) {
        return this.assertResultMap.get(strName.toUpperCase());
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, outputdoc="false", fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public int getExtendMode() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="__self__", from_method="getPSDataEntityMust().getPSDEField", fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public String getDEFValue() {
        return this.strDEFValue;
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSDataEntityMust().getPSDEAction", fields={"PSDEACTIONID"})
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    public String getModelType() {
        return "PSSYSTESTCASE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.psSysTestCase.getCODENAME();
    }

    @Override
    public IPSSystemModule getPSSystemModule() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u5907\u6ce8", hideempty2=true, dynamodelmode=4)
    public String getMemo() {
        return super.getMemo();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSDataEntity() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSDataEntity().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction();
        }
        if (this.getPSDEField() != null) {
            return this.getPSDEField();
        }
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity();
        }
        return super.onGetParentModel();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction();
        }
        if (this.getPSDEField() != null) {
            return this.getPSDEField();
        }
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity();
        }
        return super.onGetScopeModel();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSDataEntity() != null) {
            return String.format("%1$s/%2$s", this.getPSDataEntity().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return super.onGetRTMOSFolder();
    }
}

