/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimensionObject;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeObjectImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysBIDimensionObjectImpl
extends PSSysBISchemeObjectImpl
implements IPSSysBIDimensionObject {
    private IPSSysBIDimension iPSSysBIDimension = null;

    @Override
    public IPSBIDimension getPSBIDimension() {
        return this.getPSSysBIDimension();
    }

    @Override
    public IPSSysBIDimension getPSSysBIDimension() {
        return this.iPSSysBIDimension;
    }

    protected void setPSSysBIDimension(IPSSysBIDimension iPSSysBIDimension) {
        this.iPSSysBIDimension = iPSSysBIDimension;
        if (this.getPSSysBIDimension() != null) {
            this.setPSSysBIScheme(this.getPSSysBIDimension().getPSSysBIScheme());
        } else {
            this.setPSSysBIScheme(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBIDimension().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysBIDimension();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysBIDimension();
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSSysBIDimension() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIDimension().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysBIDimension() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIDimension().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

