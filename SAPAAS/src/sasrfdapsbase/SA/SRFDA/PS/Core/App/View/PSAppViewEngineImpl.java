/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppViewEngineImplBase;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Data.PSDEViewEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSAppViewEngineImpl
extends PSAppViewEngineImplBase {
    private static final Log log = LogFactory.getLog(PSAppViewEngineImpl.class);
    private IPSAppView iPSAppView = null;
    private PSDEViewEngine psDEViewEngine = null;
    private IPSUIEngineType iPSUIEngineType = null;
    private int nOrderValue = 99999;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppView iPSAppView, IPSUIEngineType iPSUIEngineType, PSDEViewEngine psDEViewEngine) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppView = iPSAppView;
            this.psDEViewEngine = psDEViewEngine;
            this.setId(this.psDEViewEngine.getPSDEVIEWENGINEID());
            this.setName(this.psDEViewEngine.getPSDEVIEWENGINENAME());
            this.setPSObjectData(this.psDEViewEngine);
            this.iPSUIEngineType = iPSUIEngineType;
            if (this.getPSUIEngineType() == null) {
                this.iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(this.psDEViewEngine.getPSUIENGINETYPEID());
            }
            if (!psDEViewEngine.isORDERVALUENull() && psDEViewEngine.getORDERVALUE() >= 0) {
                this.nOrderValue = psDEViewEngine.getORDERVALUE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
        super.onInit();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppView().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u64ce\u7c7b\u578b")
    public String getEngineType() {
        return this.getPSUIEngineType().getTypeCode();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u64ce\u5206\u7c7b")
    public String getEngineCat() {
        return this.getPSUIEngineType().getEngineCat();
    }

    @Override
    @PSModelRTMeta(description="\u52a0\u8f7d\u6392\u5e8f\u503c", dump=false)
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    public String getCodeName() {
        return this.getName();
    }

    public IPSUIEngineType getPSUIEngineType() {
        return this.iPSUIEngineType;
    }

    protected void setPSUIEngineType(IPSUIEngineType iPSUIEngineType) {
        this.iPSUIEngineType = iPSUIEngineType;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppView().getPSSystem());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSAppView() != null) {
            return this.getPSAppView();
        }
        return super.onGetParentModel();
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return null;
    }
}

