/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.der;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.der.IPSDERRuntime;
import net.ibizsys.model.entity.PSDER;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDERBaseImpl
extends PSSystemObjectImpl
implements IPSDERRuntime {
    private static final Log log = LogFactory.getLog(PSDERBaseImpl.class);
    protected IPSDataEntity majorPSDataEntity = null;
    protected IPSDataEntity minorPSDataEntity = null;
    protected PSDER psDER = null;
    protected String strCodeName = "";
    protected String strMinorCodeName = "";
    private String strLogicName = "";
    private int nOrderValue = 100;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity majorPSDataEntity, IPSDataEntity minorPSDataEntity, PSDER psDER) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.psDER = psDER;
            this.setId(this.psDER.getPSDERID());
            this.setName(this.psDER.getPSDERNAME());
            this.setPSObjectData(this.psDER);
            this.majorPSDataEntity = majorPSDataEntity;
            this.minorPSDataEntity = minorPSDataEntity;
            if (this.majorPSDataEntity == null) {
                throw new Exception(StringHelper.format((String)"\u5173\u7cfb[%1$s]\u4e3b\u5b9e\u4f53\u65e0\u6548", (Object)this.getName()));
            }
            if (this.minorPSDataEntity == null) {
                throw new Exception(StringHelper.format((String)"\u5173\u7cfb[%1$s]\u4ece\u5b9e\u4f53\u65e0\u6548", (Object)this.getName()));
            }
            this.setLogicName(this.psDER.getLOGICNAME());
            if (!this.psDER.isORDERVALUENull()) {
                this.nOrderValue = this.psDER.getORDERVALUE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u5173\u7cfb\u7c7b\u578b", codelist="DERType")
    public String getDERType() {
        return this.psDER.getDERTYPE();
    }

    public String getMajorDEId() {
        return this.getMajorPSDEId();
    }

    public String getMinorDEId() {
        return this.getMinorPSDEId();
    }

    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53 ")
    public IPSDataEntity getMajorPSDataEntity() {
        return this.majorPSDataEntity;
    }

    @PSModelRTMeta(description="\u5173\u7cfb\u5b9e\u4f53 ")
    public IPSDataEntity getMinorPSDataEntity() {
        return this.minorPSDataEntity;
    }

    public String getMajorPSDEId() {
        return this.majorPSDataEntity.getId();
    }

    public String getMinorPSDEId() {
        return this.minorPSDataEntity.getId();
    }

    public String getMajorDEName() {
        return this.majorPSDataEntity.getName();
    }

    public String getMinorDEName() {
        return this.minorPSDataEntity.getName();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0 ")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u5173\u7cfb\u6570\u636e\u4ee3\u7801\u540d\u79f0 ")
    public String getMinorCodeName() {
        return this.strMinorCodeName;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.majorPSDataEntity);
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0 ")
    public String getLogicName() {
        return this.strLogicName;
    }

    protected void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    @PSModelRTMeta(description="\u6392\u5e8f\u503c")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    protected void onFillViewParentModeJO(ObjectNode jo) {
        if (!jo.has("SRFPARENTTYPE".toLowerCase())) {
            jo.put("SRFPARENTTYPE".toLowerCase(), this.getDERType());
        }
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getMajorPSDataEntity().getPSSystem();
    }
}

