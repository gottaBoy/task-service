/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEDQConditionImpl
extends PSObjectImpl
implements IPSDEDQCondition {
    private static final Log log = LogFactory.getLog(PSDEDQConditionImpl.class);
    protected IPSDEDQJoin iPSDEDQJoin = null;
    protected IPSDEDQGroupCondition iPSDEDQGroupCondition = null;
    protected PSDEDataQueryCond psDEDataQueryCond = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDQJoin iPSDEDQJoin, IPSDEDQGroupCondition iPSDEDQGroupCondition, PSDEDataQueryCond psDEDataQueryCond) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDQJoin = iPSDEDQJoin;
            this.iPSDEDQGroupCondition = iPSDEDQGroupCondition;
            this.psDEDataQueryCond = psDEDataQueryCond;
            this.setId(this.psDEDataQueryCond.getPSDEDQCONDID());
            this.setName(this.psDEDataQueryCond.getPSDEDQCONDNAME());
            this.setPSObjectData(this.psDEDataQueryCond);
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
    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", codelist="LogicType", fields={"CONDTYPE"})
    public String getCondType() {
        return this.psDEDataQueryCond.getCONDTYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDQJoin.getPSSysModelInstId();
    }

    @Override
    public IPSDEDQJoin getPSDEDQJoin() {
        return this.iPSDEDQJoin;
    }

    @Override
    public String getModelType() {
        return "PSDEDQCOND";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDQJoin().getPSDEDataQuery().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDQJoin().getPSDEDataQuery().getModelId(), (Object)this.getId());
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u6807\u8bb0", fields={"CONDTAG"})
    public String getCondTag() {
        return this.psDEDataQueryCond.getCONDTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u6807\u8bb02", fields={"CONDTAG2"})
    public String getCondTag2() {
        return this.psDEDataQueryCond.getCONDTAG2();
    }
}

