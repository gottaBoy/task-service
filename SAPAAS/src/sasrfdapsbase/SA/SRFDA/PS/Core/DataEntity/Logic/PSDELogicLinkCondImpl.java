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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogicLink;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDELogicLinkCondImpl
extends PSObjectImpl
implements IPSDELogicLinkCond,
IPSAppDELogicLinkCond {
    private static final Log log = LogFactory.getLog(PSDELogicLinkCondImpl.class);
    protected IPSDELogicLink iPSDELogicLink = null;
    protected PSDELogicLinkCond psDELogicLinkCond = null;
    protected IPSDELogicLinkCond parentPSDELogicLinkCond = null;
    private IPSAppDELogicLink iPSAppDELogicLink = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDELogicLink iPSDELogicLink, IPSDELogicLinkCond parentPSDELogicLinkCond, PSDELogicLinkCond psDELogicLinkCond) throws Exception {
        try {
            IPSAppDELogicLink iPSAppDELogicLink;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDELogicLink = iPSDELogicLink;
            this.psDELogicLinkCond = psDELogicLinkCond;
            this.parentPSDELogicLinkCond = parentPSDELogicLinkCond;
            this.setId(this.psDELogicLinkCond.getPSDELLCONDID());
            this.setName(this.psDELogicLinkCond.getPSDELLCONDNAME());
            this.setPSObjectData(this.psDELogicLinkCond);
            if (iPSDELogicLink instanceof IPSAppDELogicLink && (iPSAppDELogicLink = (IPSAppDELogicLink)iPSDELogicLink).getPSAppDELogic() != null) {
                this.iPSAppDELogicLink = iPSAppDELogicLink;
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
    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", codelist="DELogicLinkCondType", fields={"LOGICTYPE"})
    public String getLogicType() {
        return this.psDELogicLinkCond.getLOGICTYPE();
    }

    @Override
    public IPSDELogicLink getPSDELogicLink() {
        return this.iPSDELogicLink;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDELogicLink.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDELogicLink() != null) {
            return "PSAPPDELLCOND";
        }
        return "PSDELLCOND";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDELogicLink() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDELogicLink().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDELogicLink().getPSDELogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public IPSAppDELogicLink getPSAppDELogicLink() {
        return this.iPSAppDELogicLink;
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

