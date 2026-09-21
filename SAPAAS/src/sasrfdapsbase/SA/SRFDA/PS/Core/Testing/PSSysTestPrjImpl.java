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

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.Testing.PSSysTestModuleImpl;
import SA.SRFDA.PS.Data.PSSysTestModule;
import SA.SRFDA.PS.Data.PSSysTestPrj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestPrjImpl
extends PSSystemObjectImpl
implements IPSSysTestPrj {
    private static final Log log = LogFactory.getLog(PSSysTestPrjImpl.class);
    protected PSSysTestPrj psSysTestPrj = null;
    private String strPrjType = null;
    private ArrayList<IPSSysTestModule> psSysTestModuleList = new ArrayList();
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysServiceAPI iPSSysServiceAPI = null;
    private IPSApplication iPSApplication = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysTestPrj psSysTestPrj) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysTestPrj = psSysTestPrj;
            this.setId(this.psSysTestPrj.getPSSYSTESTPRJID());
            this.setName(this.psSysTestPrj.getPSSYSTESTPRJNAME());
            this.setPSObjectData(this.psSysTestPrj);
            this.strPrjType = this.psSysTestPrj.getPRJTYPE();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestPrj.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysTestPrj.getPSMODULEID());
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPrjType(), (String)"SYSSERVICEAPI", (boolean)false) == 0) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestPrj.getPSSYSSERVICEAPIID())) {
                    throw new Exception("\u6d4b\u8bd5\u9879\u76ee\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3");
                }
                this.iPSSysServiceAPI = this.getPSSystem().getPSSysServiceAPI(this.psSysTestPrj.getPSSYSSERVICEAPIID());
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPrjType(), (String)"SYSAPP", (boolean)false) == 0) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysTestPrj.getPSSYSAPPID())) {
                    throw new Exception("\u6d4b\u8bd5\u9879\u76ee\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528");
                }
                this.iPSApplication = this.getPSSystem().getPSApplication(this.psSysTestPrj.getPSSYSAPPID());
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
        this.preparePSSysTestModules();
        super.onInit();
    }

    protected void preparePSSysTestModules() throws Exception {
        this.psSysTestModuleList.clear();
        Vector<PSSysTestModule> psSysTestModuleList = new Vector<PSSysTestModule>();
        CallResult callResult = this.getPSModelHelper().getPSSysTestModules(this.getId(), psSysTestModuleList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysTestModule psSysTestModule : psSysTestModuleList) {
            PSSysTestModuleImpl iPSSysTestModule = new PSSysTestModuleImpl();
            iPSSysTestModule.init(this.getDAGlobalHelper(), this, psSysTestModule);
            this.psSysTestModuleList.add(iPSSysTestModule);
        }
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u7c7b\u578b", codelist="TestPrjType", group="\u57fa\u672c", order=125, fields={"PRJTYPE"})
    public String getPrjType() {
        return this.strPrjType;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6a21\u578b", group="\u57fa\u672c", order=127)
    public IPSModelObject getTargetPSModel() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPrjType(), (String)"SYSAPP", (boolean)true) == 0) {
            return this.getPSApplication();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPrjType(), (String)"SYSSERVICEAPI", (boolean)true) == 0) {
            return this.getPSSysServiceAPI();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSSYSTESTPRJ";
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u6a21\u5757\u96c6\u5408", child=true, group="\u57fa\u672c", order=240)
    public Iterator<IPSSysTestModule> getPSSysTestModules() {
        if (this.psSysTestModuleList == null || this.psSysTestModuleList.size() == 0) {
            return null;
        }
        return this.psSysTestModuleList.iterator();
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
        return this.psSysTestPrj.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u6807\u8bb0", fields={"PRJTAG"})
    public String getPrjTag() {
        return this.psSysTestPrj.getPRJTAG();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u6807\u8bb02", fields={"PRJTAG2"})
    public String getPrjTag2() {
        return this.psSysTestPrj.getPRJTAG2();
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3", hideempty=true, dumpref=true, fields={"PSSYSSERVICEAPIID"})
    public IPSSysServiceAPI getPSSysServiceAPI() {
        return this.iPSSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5e94\u7528", hideempty=true, dumpref=true, fields={"PSSYSAPPID"})
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    @Override
    @PSModelRTMeta(description="\u5907\u6ce8", hideempty2=true, dynamodelmode=4)
    public String getMemo() {
        return super.getMemo();
    }

    @Override
    public int check() throws Exception {
        int nRet = 0;
        Iterator<IPSSysTestModule> psSysTestModules = this.getPSSysTestModules();
        if (psSysTestModules != null) {
            while (psSysTestModules.hasNext()) {
                IPSSysTestModule iPSSysTestModule = psSysTestModules.next();
                nRet += iPSSysTestModule.check();
            }
        }
        return nRet += super.check();
    }
}

