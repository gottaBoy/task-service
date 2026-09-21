/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainState
 *  net.ibizsys.model.dataentity.priv.IPSDEOPPriv
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.mainstate;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainStateOPPrivRuntime;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.entity.PSDEMainStateOPPriv;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMainStateOPPrivImpl
extends PSObjectImpl
implements IPSDEMainStateOPPrivRuntime {
    private static final Log log = LogFactory.getLog(PSDEMainStateOPPrivImpl.class);
    private IPSDEMainState iPSDEMainState = null;
    private PSDEMainStateOPPriv psDEMainStateOPPriv = null;
    private String strPSDEOPPrivId = null;
    private IPSDEOPPriv iPSDEOPPriv = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEMainState iPSDEMainState, PSDEMainStateOPPriv psDEMainStateOPPriv) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEMainState(iPSDEMainState);
            this.setPSDEMainStateOPPrivData(psDEMainStateOPPriv);
            this.setId(this.psDEMainStateOPPriv.getPSDEMSOPPRIVID());
            this.setName(this.psDEMainStateOPPriv.getPSDEMSOPPRIVNAME());
            this.setPSObjectData(this.psDEMainStateOPPriv);
            this.strPSDEOPPrivId = psDEMainStateOPPriv.getPSDEOPPRIVID();
            if (!StringHelper.isNullOrEmpty((String)this.strPSDEOPPrivId)) {
                this.iPSDEOPPriv = iPSDEMainState.getPSDataEntity().getPSDEOPPriv(this.strPSDEOPPrivId);
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u5bf9\u8c61")
    public IPSDEMainState getPSDEMainState() {
        return this.iPSDEMainState;
    }

    protected void setPSDEMainState(IPSDEMainState iPSDEMainState) {
        this.iPSDEMainState = iPSDEMainState;
    }

    public PSDEMainStateOPPriv getPSDEMainStateOPPrivData() {
        return this.psDEMainStateOPPriv;
    }

    protected void setPSDEMainStateOPPrivData(PSDEMainStateOPPriv psDEMainStateOPPriv) {
        this.psDEMainStateOPPriv = psDEMainStateOPPriv;
    }

    public String getPSDEOPPrivId() {
        return this.strPSDEOPPrivId;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u5bf9\u8c61")
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDEMainState);
    }
}

