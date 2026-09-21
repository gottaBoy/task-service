/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.der.IPSDERBase
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.priv;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.priv.IPSDEOPPrivRuntime;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.entity.PSDEOPPriv;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEOPPrivImpl
extends PSSystemObjectImpl
implements IPSDEOPPrivRuntime {
    private static final Log log = LogFactory.getLog(PSDEOPPrivImpl.class);
    protected PSDEOPPriv psDEOPPriv = null;
    private String strLogicName = null;
    private IPSDataEntity iPSDataEntity = null;
    private String strPSDERName = null;
    private String strMapPSDEOPPrivName = null;
    private IPSDERBase iPSDERBase = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSDEOPPriv psDEOPPriv) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            if (!StringHelper.isNullOrEmpty((String)psDEOPPriv.getPSDEID())) {
                this.iPSDataEntity = this.getPSSystem().getPSDataEntity(psDEOPPriv.getPSDEID());
                this.setPSDataEntity(this.iPSDataEntity);
            }
            this.psDEOPPriv = psDEOPPriv;
            this.setId(this.psDEOPPriv.getPSDEOPPRIVID());
            this.setName(this.psDEOPPriv.getPSDEOPPRIVNAME());
            this.strLogicName = this.psDEOPPriv.getLOGICNAME();
            this.setPSObjectData(this.psDEOPPriv);
            if (!StringHelper.isNullOrEmpty((String)this.psDEOPPriv.getPSDERNAME())) {
                this.strPSDERName = this.psDEOPPriv.getPSDERNAME();
                this.strMapPSDEOPPrivName = this.psDEOPPriv.getMAPPSDEOPPRIVNAME();
                this.iPSDERBase = this.getPSSystem().getPSDER(this.psDEOPPriv.getPSDERID());
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

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.strLogicName;
    }

    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    public String getPSDERName() {
        return this.strPSDERName;
    }

    @PSModelRTMeta(description="\u6620\u5c04\u5b9e\u4f53\u64cd\u4f5c\u540d\u79f0", hideempty2=true)
    public String getMapPSDEOPPrivName() {
        return this.strMapPSDEOPPrivName;
    }

    @PSModelRTMeta(description="\u6620\u5c04\u5173\u7cfb\u5bf9\u8c61", hideempty2=true)
    public IPSDERBase getPSDER() {
        return this.iPSDERBase;
    }
}

