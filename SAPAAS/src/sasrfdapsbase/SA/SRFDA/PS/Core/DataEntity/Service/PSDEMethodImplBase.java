/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethod;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelIgnoreMeta
public abstract class PSDEMethodImplBase
extends PSDataEntityObjectImpl
implements IPSDEMethod {
    @Override
    public String getModelType() {
        return "PSDEMETHOD";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getCodeName());
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }
}

