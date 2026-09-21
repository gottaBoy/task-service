/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.action.IPSDEActionLogic
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.action.IPSDEActionLogic;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.entity.PSDEActionLogic;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionLogicImpl
extends PSObjectImpl
implements IPSDEActionLogic {
    private static final Log log = LogFactory.getLog(PSDEActionLogicImpl.class);
    protected IPSDEAction iPSDEAction;
    protected PSDEActionLogic psDEActionLogic;
    private boolean bInternalLogic = true;
    private boolean bValid = true;
    private boolean bCloneParam = false;
    private boolean bIgnoreException = false;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEAction iPSDEAction, PSDEActionLogic psDEActionLogic) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEAction = iPSDEAction;
            this.psDEActionLogic = psDEActionLogic;
            this.setId(this.psDEActionLogic.getPSDEACTIONLOGICID());
            this.setName(this.psDEActionLogic.getPSDEACTIONLOGICNAME());
            this.setPSObjectData(this.psDEActionLogic);
            if (!this.psDEActionLogic.isINTERNALLOGICNull()) {
                this.bInternalLogic = this.psDEActionLogic.getINTERNALLOGIC();
            }
            if (!this.psDEActionLogic.isVALIDFLAGNull()) {
                this.bValid = this.psDEActionLogic.getVALIDFLAG();
            }
            if (!this.psDEActionLogic.isCLONEPARAMFLAGNull()) {
                this.bCloneParam = this.psDEActionLogic.getCLONEPARAMFLAG();
            }
            if (!this.psDEActionLogic.isIGNOREEXCEPTIONNull()) {
                this.bIgnoreException = this.psDEActionLogic.getIGNOREEXCEPTION();
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

    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61")
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @PSModelRTMeta(description="\u9644\u52a0\u6a21\u5f0f", codelist="DEActionLogicAttachMode")
    public String getAttachMode() {
        return this.psDEActionLogic.getATTACHMODE();
    }

    public String getPSDELogicId() {
        return this.psDEActionLogic.getPSDELOGICID();
    }

    public String getPSDELogicName() {
        return this.psDEActionLogic.getPSDELOGICNAME();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u903b\u8f91")
    public IPSDELogic getPSDELogic() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSDELogicId())) {
            return null;
        }
        return this.iPSDEAction.getPSDataEntity().getPSDELogic(this.getPSDELogicId());
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDEAction);
    }

    @PSModelRTMeta(description="\u662f\u5426\u5185\u90e8\u903b\u8f91")
    public boolean isInternalLogic() {
        return this.bInternalLogic;
    }

    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53")
    public IPSDataEntity getDstPSDE() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEID())) {
            return null;
        }
        return this.iPSDEAction.getPSDataEntity().getPSSystem().getPSDataEntity(this.psDEActionLogic.getDSTPSDEID());
    }

    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getDstPSDEAction() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEACTIONID())) {
            return null;
        }
        if (this.getDstPSDE() == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53");
        }
        return this.getDstPSDE().getPSDEAction(this.psDEActionLogic.getDSTPSDEACTIONID());
    }

    @PSModelRTMeta(description="\u662f\u5426\u542f\u7528")
    public boolean isValid() {
        return this.bValid;
    }

    @PSModelRTMeta(description="\u662f\u5426\u514b\u9686\u4f20\u5165\u53c2\u6570")
    public boolean isCloneParam() {
        return this.bCloneParam;
    }

    @PSModelRTMeta(description="\u662f\u5426\u5ffd\u7565\u5f02\u5e38")
    public boolean isIgnoreException() {
        return this.bIgnoreException;
    }
}

