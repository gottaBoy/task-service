/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.DERBaseModel;
import net.ibizsys.paas.demodel.IDER1NModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.ISystemModel;

public class DER1NModel
extends DERBaseModel
implements IDER1NModel {
    private IDataEntityModel majorDEModel = null;
    private IDataEntityModel minorDEModel = null;

    @Override
    public String getPickupDEFName() {
        return this.der.pickupdefname();
    }

    @Override
    public int getMasterRS() {
        return this.der.masterrs();
    }

    @Override
    public IDataEntityModel getMajorDEModel() throws Exception {
        if (this.majorDEModel != null) {
            return this.majorDEModel;
        }
        this.majorDEModel = DEModelGlobal.getDEModel(this.getMajorDEId());
        return this.majorDEModel;
    }

    @Override
    public IDataEntityModel getMinorDEModel() throws Exception {
        if (this.minorDEModel != null) {
            return this.minorDEModel;
        }
        this.minorDEModel = DEModelGlobal.getDEModel(this.getMinorDEId());
        return this.minorDEModel;
    }

    public ISystemModel getSystemModel() {
        return (ISystemModel)this.iSystem;
    }
}

