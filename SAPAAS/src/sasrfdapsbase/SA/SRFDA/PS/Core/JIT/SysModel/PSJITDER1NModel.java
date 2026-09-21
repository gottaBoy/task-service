/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.IDER1NModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITDERBaseModel;
import net.ibizsys.paas.demodel.IDER1NModel;
import net.ibizsys.paas.demodel.IDataEntityModel;

public class PSJITDER1NModel
extends PSJITDERBaseModel
implements IDER1NModel {
    private IDataEntityModel majorDEModel = null;
    private IDataEntityModel minorDEModel = null;

    public String getPickupDEFName() {
        return ((IPSDER1N)this.iPSDERBase).getPickupDEFName();
    }

    public int getMasterRS() {
        return ((IPSDER1N)this.iPSDERBase).getMasterRS();
    }

    public IDataEntityModel getMajorDEModel() throws Exception {
        if (this.majorDEModel != null) {
            return this.majorDEModel;
        }
        this.majorDEModel = this.getSystemModel().getDataEntityModel(this.getMajorDEId());
        return this.majorDEModel;
    }

    public IDataEntityModel getMinorDEModel() throws Exception {
        if (this.minorDEModel != null) {
            return this.minorDEModel;
        }
        this.minorDEModel = this.getSystemModel().getDataEntityModel(this.getMinorDEId());
        return this.minorDEModel;
    }
}

