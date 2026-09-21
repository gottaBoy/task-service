/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeExp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCodeExpImp
extends PSObjectImpl
implements IPSDEDataQueryCodeExp {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCodeExpImp.class);
    protected IPSDEDataQueryCode iPSDEDataQueryCode = null;
    private String strExpression = "";
    private int nShowOrder = -1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataQueryCode iPSDEDataQueryCode, PSDEDataQueryCodeExp psDEDataQueryCodeExp) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataQueryCode = iPSDEDataQueryCode;
            this.setId(psDEDataQueryCodeExp.getPSDEDQCodeExpId());
            this.setName(psDEDataQueryCodeExp.getPSDEDQCodeExpName());
            this.setPSObjectData((IEntity)psDEDataQueryCodeExp, false);
            this.strExpression = DataObject.getStringValue((Object)psDEDataQueryCodeExp.getExpCode(), (String)"");
            this.nShowOrder = DataObject.getIntegerValue((Object)psDEDataQueryCodeExp.getOrderValue(), (Integer)0);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u8868\u8fbe\u5f0f", fields={"EXPCODE"})
    public String getExpression() {
        return this.strExpression;
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u5b57\u6bb5")
    public String getName() {
        return super.getName();
    }

    @Override
    public int getShowOrder() {
        return this.nShowOrder;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataQueryCode.getPSSysModelInstId();
    }

    public IPSDEDataQueryCode getPSDEDataQueryCode() {
        return this.iPSDEDataQueryCode;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataQueryCode().getPSDEDataQuery().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDEDQCODEEXP";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDataQueryCode().getModelId(), (Object)this.getId());
    }
}

