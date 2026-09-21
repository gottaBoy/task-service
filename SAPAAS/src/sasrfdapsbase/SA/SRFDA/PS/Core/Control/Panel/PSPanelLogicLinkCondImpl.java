/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLink;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public abstract class PSPanelLogicLinkCondImpl
extends PSObjectImpl
implements IPSPanelLogicLinkCond {
    private static final Log log = LogFactory.getLog(PSPanelLogicLinkCondImpl.class);
    protected IPSPanelLogicLink iPSPanelLogicLink = null;
    protected PSPanelLogicLinkCond psPanelLogicLinkCond = null;
    protected IPSPanelLogicLinkCond parentPSPanelLogicLinkCond = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPanelLogicLink iPSPanelLogicLink, IPSPanelLogicLinkCond parentPSPanelLogicLinkCond, PSPanelLogicLinkCond psPanelLogicLinkCond) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSPanelLogicLink = iPSPanelLogicLink;
            this.psPanelLogicLinkCond = psPanelLogicLinkCond;
            this.parentPSPanelLogicLinkCond = parentPSPanelLogicLinkCond;
            this.setId(this.psPanelLogicLinkCond.getPSPANELLLCONDID());
            this.setName(this.psPanelLogicLinkCond.getPSPANELLLCONDNAME());
            this.setPSObjectData(this.psPanelLogicLinkCond);
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
    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", codelist="PanelLogicLinkCondType")
    public String getLogicType() {
        return this.psPanelLogicLinkCond.getLOGICTYPE();
    }

    @Override
    public IPSPanelLogicLink getPSPanelLogicLink() {
        return this.iPSPanelLogicLink;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSPanelLogicLink.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSPANELLLCOND";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSPanelLogicLink().getPSPanelLogic().getPSPanel().getPSAppView().getPSSystem());
    }
}

