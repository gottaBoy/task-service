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

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.Testing.PSSysTestCase2Impl;
import SA.SRFDA.PS.Data.PSSysTestCase;
import SA.SRFDA.PS.Data.PSSysTestModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestModuleImpl
extends PSObjectImpl
implements IPSSysTestModule {
    private static final Log log = LogFactory.getLog(PSSysTestModuleImpl.class);
    private IPSSysTestPrj iPSSysTestPrj = null;
    protected PSSysTestModule psSysTestModule = null;
    private ArrayList<IPSSysTestCase> psSysTestCaseList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysTestPrj iPSSysTestPrj, PSSysTestModule psSysTestModule) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psSysTestModule = psSysTestModule;
            this.iPSSysTestPrj = iPSSysTestPrj;
            this.setId(this.psSysTestModule.getPSSYSTESTMODULEID());
            this.setName(this.psSysTestModule.getPSSYSTESTMODULENAME());
            this.setPSObjectData(this.psSysTestModule);
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
        this.preparePSSysTestCases();
        super.onInit();
    }

    protected void preparePSSysTestCases() throws Exception {
        this.psSysTestCaseList.clear();
        Vector<PSSysTestCase> psSysTestCaseList = new Vector<PSSysTestCase>();
        CallResult callResult = this.getPSModelHelper().getPSSysTestCases(this.getId(), psSysTestCaseList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7528\u4f8b\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysTestCase psSysTestCase : psSysTestCaseList) {
            PSSysTestCase2Impl iPSSysTestCase = new PSSysTestCase2Impl();
            iPSSysTestCase.init(this.getDAGlobalHelper(), this.getPSSysTestPrj(), this, psSysTestCase);
            this.psSysTestCaseList.add(iPSSysTestCase);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSTESTMODULE";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysTestPrj().getModelId(), (Object)super.getModelId());
    }

    @Override
    public IPSSysTestPrj getPSSysTestPrj() {
        return this.iPSSysTestPrj;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysTestPrj().getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysTestPrj().getPSSystem());
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
        return this.psSysTestModule.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb0", fields={"MODULETAG"})
    public String getModuleTag() {
        return this.psSysTestModule.getMODULETAG();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb02", fields={"MODULETAG2"})
    public String getModuleTag2() {
        return this.psSysTestModule.getMODULETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u7528\u4f8b\u96c6\u5408", child=true, dumpref=true, rtdump=2)
    public Iterator<IPSSysTestCase> getPSSysTestCases() {
        if (this.psSysTestCaseList == null || this.psSysTestCaseList.size() == 0) {
            return null;
        }
        return this.psSysTestCaseList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5907\u6ce8", hideempty2=true, dynamodelmode=4)
    public String getMemo() {
        return super.getMemo();
    }

    @Override
    public int check() throws Exception {
        int nRet = 0;
        Iterator<IPSSysTestCase> psSysTestCases = this.getPSSysTestCases();
        if (psSysTestCases != null) {
            while (psSysTestCases.hasNext()) {
                IPSSysTestCase iPSSysTestCase = psSysTestCases.next();
                nRet += iPSSysTestCase.check();
            }
        }
        return nRet += super.check();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSSysTestPrj() != null) {
            return this.getPSSysTestPrj();
        }
        return super.onGetParentModel();
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }
}

