/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.IPSDataEntityObject
 *  net.ibizsys.paas.core.IDataEntity
 */
package net.ibizsys.model.dataentity;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.paas.core.IDataEntity;

public abstract class PSDataEntityObjectImpl
extends PSObjectImpl
implements IPSDataEntityObject {
    protected IPSDataEntity iPSDataEntity = null;
    private int nExtendMode = 0;
    public static final String CODETYPE_SUBSYS = "SUBSYS_";

    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSDataEntity().getPSSystem()).getPSSysModelInstId();
    }

    public int getExtendMode() {
        return this.nExtendMode;
    }

    protected void setExtendMode(int nExtendMode) {
        this.nExtendMode = nExtendMode;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u5bf9\u8c61")
    public IPSSystem getPSSystem() {
        return this.getPSDataEntity().getPSSystem();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)this.getPSDataEntity().getPSSystem();
    }
}

