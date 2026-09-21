/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERDEFieldMap;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSDERDEFieldMapImpl
extends PSObjectImpl
implements IPSDERDEFieldMap {
    private IPSDERBase iPSDERBase = null;

    protected void setPSDERBase(IPSDERBase iPSDERBase) {
        this.iPSDERBase = iPSDERBase;
    }

    @Override
    public IPSDERBase getPSDERBase() {
        return this.iPSDERBase;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDERBase().getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDERBase().getMinorPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDERDEFMAP";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDERBase().getModelId(), (Object)super.getModelId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDERBase() != null) {
            return this.getPSDERBase();
        }
        return super.onGetParentModel();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSDERBase() != null) {
            return this.getPSDERBase();
        }
        return super.onGetScopeModel();
    }
}

