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

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLinkCond;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public abstract class PSDEMSLogicLinkCondImpl
extends PSObjectImpl
implements IPSDEMSLogicLinkCond {
    private static final Log log = LogFactory.getLog(PSDEMSLogicLinkCondImpl.class);
    protected IPSDEMSLogicLink iPSDEMSLogicLink = null;
    protected PSDELogicLinkCond psDELogicLinkCond = null;
    protected IPSDEMSLogicLinkCond parentPSDEMSLogicLinkCond = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMSLogicLink iPSDEMSLogicLink, IPSDEMSLogicLinkCond parentPSDEMSLogicLinkCond, PSDELogicLinkCond psDELogicLinkCond) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEMSLogicLink = iPSDEMSLogicLink;
            this.psDELogicLinkCond = psDELogicLinkCond;
            this.parentPSDEMSLogicLinkCond = parentPSDEMSLogicLinkCond;
            this.setId(this.psDELogicLinkCond.getPSDELLCONDID());
            this.setName(this.psDELogicLinkCond.getPSDELLCONDNAME());
            this.setPSObjectData(this.psDELogicLinkCond);
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
    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", codelist="DELogicLinkCondType", fields={"LOGICTYPE"})
    public String getLogicType() {
        return this.psDELogicLinkCond.getLOGICTYPE();
    }

    @Override
    public IPSDEMSLogicLink getPSDEMSLogicLink() {
        return this.iPSDEMSLogicLink;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEMSLogicLink.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEMSLLCOND";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEMSLogicLink().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEMSLogicLink().getPSDEMSLogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

