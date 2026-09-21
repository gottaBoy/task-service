/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainState
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
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainStateActionRuntime;
import net.ibizsys.model.entity.PSDEMainStateAction;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMainStateActionImpl
extends PSObjectImpl
implements IPSDEMainStateActionRuntime {
    private static final Log log = LogFactory.getLog(PSDEMainStateActionImpl.class);
    private IPSDEMainState iPSDEMainState = null;
    private PSDEMainStateAction psDEMainStateAction = null;
    private String strPSDEActionId = null;
    private IPSDEAction iPSDEAction = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEMainState iPSDEMainState, PSDEMainStateAction psDEMainStateAction) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEMainState(iPSDEMainState);
            this.setPSDEMainStateActionData(psDEMainStateAction);
            this.setId(this.psDEMainStateAction.getPSDEMSACTIONID());
            this.setName(this.psDEMainStateAction.getPSDEMSACTIONNAME());
            this.setPSObjectData(this.psDEMainStateAction);
            this.strPSDEActionId = psDEMainStateAction.getPSDEACTIONID();
            if (!StringHelper.isNullOrEmpty((String)this.strPSDEActionId)) {
                this.iPSDEAction = iPSDEMainState.getPSDataEntity().getPSDEAction(this.strPSDEActionId);
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

    public PSDEMainStateAction getPSDEMainStateActionData() {
        return this.psDEMainStateAction;
    }

    protected void setPSDEMainStateActionData(PSDEMainStateAction psDEMainStateAction) {
        this.psDEMainStateAction = psDEMainStateAction;
    }

    public String getPSDEActionId() {
        return this.strPSDEActionId;
    }

    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDEMainState);
    }
}

