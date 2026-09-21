/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCond;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public abstract class PSWFLinkCondImpl
extends PSObjectImpl
implements IPSWFLinkCond {
    private static final Log log = LogFactory.getLog(PSWFLinkCondImpl.class);
    protected IPSWFLink iPSWFLink = null;
    protected PSWFLinkCond psWFLinkCond = null;
    protected IPSWFLinkCond parentPSWFLinkCond = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWFLink iPSWFLink, IPSWFLinkCond parentPSWFLinkCond, PSWFLinkCond psWFLinkCond) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSWFLink = iPSWFLink;
            this.psWFLinkCond = psWFLinkCond;
            this.parentPSWFLinkCond = parentPSWFLinkCond;
            this.setId(this.psWFLinkCond.getPSWFLINKCONDID());
            this.setName(this.psWFLinkCond.getPSWFLINKCONDNAME());
            this.setPSObjectData(this.psWFLinkCond);
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
    public IPSWFLinkCond getParentPSWFLinkCond() {
        return this.parentPSWFLinkCond;
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", codelist="WFLinkCondType", fields={"LOGICTYPE"})
    public String getCondType() {
        return this.psWFLinkCond.getLOGICTYPE();
    }

    @Override
    public IPSWFLink getPSWFLink() {
        return this.iPSWFLink;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWFLink().getPSSysModelInstId();
    }

    public String getPId() {
        if (this.getParentPSWFLinkCond() != null) {
            return this.getParentPSWFLinkCond().getId();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSWFLINKCOND";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSWFLink().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        if (StringHelper.isNullOrEmpty((String)this.getId())) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSWFLink().getPSWFVersion().getModelId(), (Object)this.getPSWFLink().getId());
        }
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSWFLink().getPSWFVersion().getModelId(), (Object)this.getId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSWFLink().getPSWFVersion().getPSWorkflow().getPSSystem());
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

