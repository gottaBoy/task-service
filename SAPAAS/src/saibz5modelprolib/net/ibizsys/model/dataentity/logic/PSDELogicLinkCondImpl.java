/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLink
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCondRuntime;
import net.ibizsys.model.entity.PSDELogicLinkCond;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDELogicLinkCondImpl
extends PSObjectImpl
implements IPSDELogicLinkCond,
IPSDELogicLinkCondRuntime {
    private static final Log log = LogFactory.getLog(PSDELogicLinkCondImpl.class);
    protected IPSDELogicLink iPSDELogicLink = null;
    protected PSDELogicLinkCond psDELogicLinkCond = null;
    protected IPSDELogicLinkCond parentPSDELogicLinkCond = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDELogicLink iPSDELogicLink, IPSDELogicLinkCond parentPSDELogicLinkCond, PSDELogicLinkCond psDELogicLinkCond) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDELogicLink = iPSDELogicLink;
            this.psDELogicLinkCond = psDELogicLinkCond;
            this.parentPSDELogicLinkCond = parentPSDELogicLinkCond;
            this.setId(this.psDELogicLinkCond.getPSDELLCONDID());
            this.setName(this.psDELogicLinkCond.getPSDELLCONDNAME());
            this.setPSObjectData(this.psDELogicLinkCond);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", codelist="DELogicLinkCondType")
    public String getLogicType() {
        return this.psDELogicLinkCond.getLOGICTYPE();
    }

    public IPSDELogicLink getPSDELogicLink() {
        return this.iPSDELogicLink;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDELogicLink);
    }
}

