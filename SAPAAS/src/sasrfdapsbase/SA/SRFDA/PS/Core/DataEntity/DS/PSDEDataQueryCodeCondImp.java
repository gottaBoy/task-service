/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeCond;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCodeCondImp
extends PSObjectImpl
implements IPSDEDataQueryCodeCond {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCodeCondImp.class);
    protected IPSDEDataQueryCode iPSDEDataQueryCode = null;
    private String strCustomCond = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataQueryCode iPSDEDataQueryCode, PSDEDataQueryCodeCond psDEDataQueryCodeCond) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataQueryCode = iPSDEDataQueryCode;
            this.setId(psDEDataQueryCodeCond.getPSDEDQCODECONDID());
            this.setName(psDEDataQueryCodeCond.getPSDEDQCODECONDNAME());
            this.setPSObjectData(psDEDataQueryCodeCond, false);
            this.strCustomCond = psDEDataQueryCodeCond.getCONDCODE();
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

    public String getDEFName() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", doc="\u6052\u4e3a\u81ea\u5b9a\u4e49(CUSTOM)")
    public String getCondType() {
        return "CUSTOM";
    }

    public String getCondOp() {
        return null;
    }

    public String getCondValue() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u6761\u4ef6")
    public String getCustomCond() {
        return this.strCustomCond;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u7c7b\u578b")
    public String getCustomType() {
        if (this.getPSDEDataQueryCode().getPSDEDataQuery().isEnablePQL()) {
            return "PQL";
        }
        return null;
    }

    public String getPredefindedCond() {
        return null;
    }

    public String getPredefinedCode() {
        return null;
    }

    public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
        return null;
    }

    public String getDEFieldExp() {
        return null;
    }

    public boolean isNotMode() {
        return false;
    }

    public int getStdDataType() {
        return 0;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataQueryCode.getPSSysModelInstId();
    }

    public String getValueFunc() {
        return null;
    }

    public IPSDEDataQueryCode getPSDEDataQueryCode() {
        return this.iPSDEDataQueryCode;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataQueryCode().getPSDEDataQuery().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDEDQCODECOND";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDataQueryCode().getModelId(), (Object)this.getId());
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

