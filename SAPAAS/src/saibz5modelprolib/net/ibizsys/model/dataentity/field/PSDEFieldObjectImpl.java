/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.IPSDEFieldObject
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDataEntity
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSDEFieldObject;
import net.ibizsys.model.dataentity.field.IPSDEFieldRuntime;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;

public abstract class PSDEFieldObjectImpl
extends PSObjectImpl
implements IPSDEFieldObject {
    protected IPSDEField iPSDEField = null;

    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    protected void setPSDEField(IPSDEField iPSDEField) {
        this.iPSDEField = iPSDEField;
    }

    public IDEField getDEField() {
        return this.getPSDEField();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSDEField()).getPSSysModelInstId();
    }

    public IPSDataEntity getPSDataEntity() {
        return this.getPSDEField().getPSDataEntity();
    }

    public IDataEntity getDataEntity() {
        return this.getPSDEField().getDataEntity();
    }

    protected IPSDEFieldRuntime getPSDEFieldRuntime() {
        return (IPSDEFieldRuntime)this.getPSDEField();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)this.getPSDEField().getPSDataEntity().getPSSystem();
    }
}

