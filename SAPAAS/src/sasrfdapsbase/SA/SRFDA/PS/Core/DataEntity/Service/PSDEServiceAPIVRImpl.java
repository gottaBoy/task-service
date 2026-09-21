/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIVR;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDESAVR;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEServiceAPIVRImpl
extends PSObjectImpl
implements IPSDEServiceAPIVR {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIVRImpl.class);
    private IPSDEServiceAPI iPSDEServiceAPI = null;
    private PSDESAVR psDESAVR = null;
    private String strVRType = null;
    private IPSDEFValueRule iPSDEFValueRule = null;
    private String strCodeName = null;
    private int nOrderValue = 1000;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEServiceAPI iPSDEServiceAPI, PSDESAVR psDESAVR) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEServiceAPI(iPSDEServiceAPI);
            this.psDESAVR = psDESAVR;
            this.setId(this.psDESAVR.getPSDESAVRID());
            this.setName(this.psDESAVR.getPSDESAVRNAME());
            this.setPSObjectData(this.psDESAVR);
            this.strVRType = psDESAVR.getVRTYPE();
            if (!StringHelper.isNullOrEmpty((String)this.psDESAVR.getCODENAME())) {
                this.strCodeName = this.psDESAVR.getCODENAME();
            }
            if (!this.psDESAVR.isORDERVALUENull()) {
                this.nOrderValue = this.psDESAVR.getORDERVALUE();
            }
            if (StringHelper.compare((String)this.getValueRuleType(), (String)"DEFVALUERULE", (boolean)false) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psDESAVR.getPSDEFVRID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027\u503c\u89c4\u5219");
                }
                this.iPSDEFValueRule = this.getPSDEServiceAPI().getPSDataEntity().getPSDEFValueRule(this.psDESAVR.getPSDEFVRID());
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
        super.onInit();
    }

    @Override
    public IPSDEServiceAPI getPSDEServiceAPI() {
        return this.iPSDEServiceAPI;
    }

    protected void setPSDEServiceAPI(IPSDEServiceAPI iPSDEServiceAPI) {
        this.iPSDEServiceAPI = iPSDEServiceAPI;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEServiceAPI.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u7c7b\u578b", codelist="DEFIVRType")
    public String getValueRuleType() {
        return this.strVRType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSDESAVR";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEServiceAPI().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEServiceAPI().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEServiceAPI().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u6b21\u5e8f")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219")
    public IPSDEFValueRule getPSDEFValueRule() {
        return this.iPSDEFValueRule;
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }
}

