/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicParam;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public class PSDEMSLogicParamImpl
extends PSObjectImpl
implements IPSDEMSLogicParam {
    private static final Log log = LogFactory.getLog(PSDEMSLogicParamImpl.class);
    protected IPSDEMSLogic iPSDEMSLogic;
    protected PSDELogicParam psDELogicParam;
    protected IPSDataEntity paramPSDataEntity = null;
    private boolean bDefaultParam = false;
    private int nParamType = 0;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMSLogic iPSDEMSLogic, PSDELogicParam psDELogicParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEMSLogic = iPSDEMSLogic;
            this.psDELogicParam = psDELogicParam;
            this.setId(this.psDELogicParam.getPSDELOGICPARAMID());
            this.setName(this.psDELogicParam.getLOGICNAME());
            this.setPSObjectData(this.psDELogicParam);
            if (!psDELogicParam.isDEFAULTPARAMNull()) {
                this.bDefaultParam = psDELogicParam.getDEFAULTPARAM();
            }
            if (!this.psDELogicParam.isGLOBALPARAMNull()) {
                this.nParamType = this.psDELogicParam.getGLOBALPARAM();
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDELogicParam.getPSDELOGICPARAMNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u8fc1\u79fb\u903b\u8f91\u5bf9\u8c61")
    public IPSDEMSLogic getPSDEMSLogic() {
        return this.iPSDEMSLogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEMSLogic().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53c2\u6570")
    public boolean isDefault() {
        return this.bDefaultParam;
    }

    @Override
    public String getModelType() {
        return "PSDEMSLOGICPARAM";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEMSLogic().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEMSLogic().getPSDataEntity().getPSSystem());
    }

    public int getParamType() {
        return this.nParamType;
    }
}

