/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.wf.IPSWFLink
 *  net.ibizsys.model.wf.IPSWFLinkCond
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFLinkCond;
import net.ibizsys.model.wf.IPSWFLinkCondRuntime;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSWFLinkCondImpl
extends PSObjectImpl
implements IPSWFLinkCondRuntime {
    private static final Log log = LogFactory.getLog(PSWFLinkCondImpl.class);
    protected IPSWFLink iPSWFLink = null;
    protected PSWFLinkCond psWFLinkCond = null;
    protected IPSWFLinkCond parentPSWFLinkCond = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFLink iPSWFLink, IPSWFLinkCond parentPSWFLinkCond, PSWFLinkCond psWFLinkCond) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSWFLink = iPSWFLink;
            this.psWFLinkCond = psWFLinkCond;
            this.parentPSWFLinkCond = parentPSWFLinkCond;
            this.setId(this.psWFLinkCond.getPSWFLINKCONDID());
            this.setName(this.psWFLinkCond.getPSWFLINKCONDNAME());
            this.setPSObjectData(this.psWFLinkCond);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    public IPSWFLinkCond getParentPSWFLinkCond() {
        return this.parentPSWFLinkCond;
    }

    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", codelist="WFLinkCondType")
    public String getCondType() {
        return this.psWFLinkCond.getLOGICTYPE();
    }

    public IPSWFLink getPSWFLink() {
        return this.iPSWFLink;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.getPSWFLink());
    }

    public String getPId() {
        if (this.getParentPSWFLinkCond() != null) {
            return this.getParentPSWFLinkCond().getId();
        }
        return null;
    }
}

