/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.sysmodel.ISystemModel
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.sysmodel.ISystemModel;

public abstract class PSJITDERBaseModel
implements IDERBase {
    protected ISystemModel iSystem = null;
    protected IPSDERBase iPSDERBase = null;

    public void init(ISystemModel iSystem, IPSDERBase iPSDERBase) {
        this.iSystem = iSystem;
        this.iPSDERBase = iPSDERBase;
    }

    public String getId() {
        return this.iPSDERBase.getId();
    }

    public String getName() {
        return this.iPSDERBase.getName();
    }

    public String getDERType() {
        return this.iPSDERBase.getDERType();
    }

    public String getMajorDEId() {
        return this.iPSDERBase.getMajorDEId();
    }

    public String getMinorDEId() {
        return this.iPSDERBase.getMinorDEId();
    }

    public String getMajorDEName() {
        return this.iPSDERBase.getMajorDEName();
    }

    public String getMinorDEName() {
        return this.iPSDERBase.getMinorDEName();
    }

    protected ISystem getSystem() {
        return this.iSystem;
    }

    protected ISystemModel getSystemModel() {
        return this.iSystem;
    }
}

