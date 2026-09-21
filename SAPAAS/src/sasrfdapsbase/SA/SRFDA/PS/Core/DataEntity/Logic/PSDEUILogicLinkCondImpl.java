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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicLink;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkCond;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEUILogicLinkCondImpl
extends PSObjectImpl
implements IPSDEUILogicLinkCond,
IPSAppDEUILogicLinkCond {
    private static final Log log = LogFactory.getLog(PSDEUILogicLinkCondImpl.class);
    protected IPSDEUILogicLink iPSDEUILogicLink = null;
    protected PSDELogicLinkCond psDELogicLinkCond = null;
    protected IPSDEUILogicLinkCond parentPSDEUILogicLinkCond = null;
    private IPSAppDEUILogicLink iPSAppDEUILogicLink = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEUILogicLink iPSDEUILogicLink, IPSDEUILogicLinkCond parentPSDEUILogicLinkCond, PSDELogicLinkCond psDELogicLinkCond) throws Exception {
        try {
            IPSAppDEUILogicLink iPSAppDEUILogicLink;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEUILogicLink = iPSDEUILogicLink;
            this.psDELogicLinkCond = psDELogicLinkCond;
            this.parentPSDEUILogicLinkCond = parentPSDEUILogicLinkCond;
            this.setId(this.psDELogicLinkCond.getPSDELLCONDID());
            this.setName(this.psDELogicLinkCond.getPSDELLCONDNAME());
            this.setPSObjectData(this.psDELogicLinkCond);
            if (iPSDEUILogicLink instanceof IPSAppDEUILogicLink && (iPSAppDEUILogicLink = (IPSAppDEUILogicLink)iPSDEUILogicLink).getPSAppDEUILogic() != null) {
                this.iPSAppDEUILogicLink = iPSAppDEUILogicLink;
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
    public IPSDEUILogicLink getPSDEUILogicLink() {
        return this.iPSDEUILogicLink;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEUILogicLink.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDEUILogicLink() != null) {
            return "PSAPPDEUILLCOND";
        }
        return "PSDEUILLCOND";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDEUILogicLink() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDEUILogicLink().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEUILogicLink().getPSDEUILogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public IPSAppDEUILogicLink getPSAppDEUILogicLink() {
        return this.iPSAppDEUILogicLink;
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

