/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDERIndex
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITDERBaseModel;
import net.ibizsys.paas.core.IDERIndex;

public class PSJITDERIndexModel
extends PSJITDERBaseModel
implements IDERIndex {
    public String getTypeValue() {
        return ((IPSDERIndex)this.iPSDERBase).getTypeValue();
    }
}

