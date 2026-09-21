/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Testing.IPSAppViewTestCase;
import SA.SRFDA.PS.Core.Testing.IPSDESAMethodTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.Testing.PSSysTestCaseImpl;
import SA.SRFDA.PS.Data.PSSysTestCase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSSysTestCase", typevalues={"APPVIEW", "CUSTOM", "DESADETAIL"})
public class PSSysTestCase2Impl
extends PSSysTestCaseImpl
implements IPSDESAMethodTestCase,
IPSAppViewTestCase {
    private static final Log log = LogFactory.getLog(PSSysTestCase2Impl.class);
    private IPSSysTestPrj iPSSysTestPrj = null;
    private IPSSysTestModule iPSSysTestModule = null;
    private IPSDEServiceAPI iPSDEServiceAPI = null;
    private IPSDEServiceAPIMethod iPSDEServiceAPIMethod = null;
    private IPSAppView iPSAppView = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysTestPrj iPSSysTestPrj, IPSSysTestModule iPSSysTestModule, PSSysTestCase psSysTestCase) throws Exception {
        this.iPSSysTestPrj = iPSSysTestPrj;
        this.iPSSysTestModule = iPSSysTestModule;
        this.init(iDAGlobalHelper, this.iPSSysTestPrj.getPSSystem(), psSysTestCase);
    }

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.Compare((String)this.getTestCaseType(), (String)"DESADETAIL", (boolean)true) == 0) {
            if (this.getPSSysTestPrj() == null || this.getPSSysTestPrj().getPSSysServiceAPI() == null) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3"));
            }
            if (StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSDESERVICEAPIID())) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3"));
            }
            if (StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSDESADETAILID())) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458"));
            }
        }
        if (StringHelper.Compare((String)this.getTestCaseType(), (String)"APPVIEW", (boolean)true) == 0) {
            if (this.getPSSysTestPrj() == null || this.getPSSysTestPrj().getPSApplication() == null) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528"));
            }
            if (StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSAPPVIEWID())) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u89c6\u56fe"));
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u9879\u76ee", hideempty=true, dumpref=true, fields={"PSSYSTESTPRJID"})
    public IPSSysTestPrj getPSSysTestPrj() {
        return this.iPSSysTestPrj;
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u6a21\u5757", hideempty=true, dumpref=true, from="__self__", from_method="getPSSysTestPrjMust().getPSSysTestModule", fields={"PSSYSTESTMODULEID"})
    public IPSSysTestModule getPSSysTestModule() {
        return this.iPSSysTestModule;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe", hideempty=true, dumpref=true, from="__self__", from_method="getPSSysTestPrjMust().getPSApplicationMust().getPSAppView", fields={"PSAPPVIEWID"})
    public IPSAppView getPSAppView() throws Exception {
        if (this.iPSAppView == null && !StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSAPPVIEWID())) {
            this.iPSAppView = this.getPSSysTestPrj().getPSApplication().getPSAppView(this.psSysTestCase.getPSAPPVIEWID(), false);
        }
        return this.iPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3", hideempty=true, dumpref=true, from="__self__", from_method="getPSSysTestPrjMust().getPSSysServiceAPIMust().getPSDEServiceAPI", fields={"PSDESERVICEAPIID"})
    public IPSDEServiceAPI getPSDEServiceAPI() throws Exception {
        if (this.iPSDEServiceAPI == null && !StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSDESERVICEAPIID())) {
            this.iPSDEServiceAPI = this.getPSSysTestPrj().getPSSysServiceAPI().getPSDEServiceAPI(this.psSysTestCase.getPSDESERVICEAPIID());
        }
        return this.iPSDEServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5", hideempty=true, dumpref=true, from="__self__", from_method="getPSDEServiceAPIMust().getPSDEServiceAPIMethod", fields={"PSDESADETAILID"})
    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod() throws Exception {
        if (this.iPSDEServiceAPIMethod == null && this.getPSDEServiceAPI() != null && !StringHelper.IsNullOrEmpty((String)this.psSysTestCase.getPSDESADETAILID())) {
            this.iPSDEServiceAPIMethod = this.getPSDEServiceAPI().getPSDEServiceAPIMethod(this.psSysTestCase.getPSDESADETAILID());
        }
        return this.iPSDEServiceAPIMethod;
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysTestModule().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getModelType() {
        return "PSSYSTESTCASE2";
    }

    @Override
    public int check() throws Exception {
        if (StringHelper.Compare((String)this.getTestCaseType(), (String)"APPVIEW", (boolean)true) == 0) {
            if (this.getPSSysTestPrj().getPSApplication().getLoadedLevel() > IPSSystem.LOADLEVEL_NONE) {
                this.getPSAppView();
            }
        } else if (StringHelper.Compare((String)this.getTestCaseType(), (String)"DESADETAIL", (boolean)true) == 0) {
            this.getPSDEServiceAPIMethod();
        }
        return super.check();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSSysTestModule() != null) {
            return this.getPSSysTestModule();
        }
        return super.onGetParentModel();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSSysTestPrj() != null) {
            return this.getPSSysTestPrj();
        }
        return super.onGetScopeModel();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSSysTestPrj() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSSysTestPrj().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysTestModule() != null) {
            return String.format("%1$s/%2$s", this.getPSSysTestModule().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        if (this.getPSSysTestPrj() != null) {
            return String.format("%1$s/%2$s", this.getPSSysTestPrj().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return super.onGetRTMOSFolder();
    }

    @Override
    protected IPSModelObject onGetTargetPSModel() {
        try {
            if (StringHelper.Compare((String)this.getTestCaseType(), (String)"APPVIEW", (boolean)true) == 0) {
                if (this.getPSSysTestPrj().getPSApplication().getLoadedLevel() > IPSSystem.LOADLEVEL_NONE) {
                    return this.getPSAppView();
                }
            } else if (StringHelper.Compare((String)this.getTestCaseType(), (String)"DESADETAIL", (boolean)true) == 0) {
                return this.getPSDEServiceAPIMethod();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return super.onGetTargetPSModel();
    }

    @Override
    public String getMOSModelType() {
        return "PSSYSTESTCASE";
    }

    @Override
    public String getRTMOSModelType() {
        return "PSSYSTESTCASE";
    }

    @Override
    public String getDumpModelType() {
        return "PSSYSTESTCASE";
    }
}

