/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.dataentity.logic.IPSDELogicParam
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
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.IPSDELogicParam;
import net.ibizsys.model.entity.PSDELogicParam;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicParamImpl
extends PSObjectImpl
implements IPSDELogicParam {
    private static final Log log = LogFactory.getLog(PSDELogicParamImpl.class);
    protected IPSDELogic iPSDELogic;
    protected PSDELogicParam psDELogicParam;
    protected IPSDataEntity paramPSDataEntity = null;
    private boolean bDefaultParam = false;
    private boolean bSessionParam = false;
    private boolean bEnvParam = false;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDELogic iPSDELogic, PSDELogicParam psDELogicParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDELogic = iPSDELogic;
            this.psDELogicParam = psDELogicParam;
            this.setId(this.psDELogicParam.getPSDELOGICPARAMID());
            this.setName(this.psDELogicParam.getLOGICNAME());
            this.setPSObjectData(this.psDELogicParam);
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicParam.getPARAMPSDEID())) {
                this.paramPSDataEntity = StringHelper.compare((String)this.psDELogicParam.getPARAMPSDEID(), (String)this.iPSDELogic.getPSDataEntity().getId(), (boolean)false) == 0 ? this.iPSDELogic.getPSDataEntity() : this.iPSDELogic.getPSDataEntity().getPSSystem().getPSDataEntity(this.psDELogicParam.getPARAMPSDEID());
            }
            if (!psDELogicParam.isDEFAULTPARAMNull()) {
                this.bDefaultParam = psDELogicParam.getDEFAULTPARAM();
            }
            if (this.isDefault() && this.getParamPSDataEntity() == null && StringHelper.compare((String)iPSDELogic.getLogicType(), (String)"DELOGIC", (boolean)true) == 0) {
                this.paramPSDataEntity = this.iPSDELogic.getPSDataEntity();
            }
            if (!this.psDELogicParam.isGLOBALPARAMNull()) {
                switch (this.psDELogicParam.getGLOBALPARAM()) {
                    case 2: {
                        this.bEnvParam = true;
                        break;
                    }
                    case 1: {
                        this.bSessionParam = true;
                    }
                }
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

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.psDELogicParam.getPSDELOGICPARAMNAME();
    }

    @PSModelRTMeta(description="\u53c2\u6570\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getParamPSDataEntity() throws Exception {
        return this.paramPSDataEntity;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u903b\u8f91\u5bf9\u8c61")
    public IPSDELogic getPSDELogic() {
        return this.iPSDELogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.getPSDELogic());
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u53c2\u6570")
    public boolean isDefault() {
        return this.bDefaultParam;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u4f1a\u8bdd\u53d8\u91cf")
    public boolean isSessionParam() {
        return this.bSessionParam;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u73af\u5883\u53d8\u91cf")
    public boolean isEnvParam() {
        return this.bEnvParam;
    }
}

