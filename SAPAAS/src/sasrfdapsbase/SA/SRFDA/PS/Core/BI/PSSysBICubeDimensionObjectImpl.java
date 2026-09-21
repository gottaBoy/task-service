/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimensionObject;
import SA.SRFDA.PS.Core.BI.PSSysBICubeObjectImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public class PSSysBICubeDimensionObjectImpl
extends PSSysBICubeObjectImpl
implements IPSSysBICubeDimensionObject {
    private IPSSysBICubeDimension iPSSysBICubeDimension = null;

    @Override
    public IPSBICubeDimension getPSBICubeDimension() {
        return this.getPSSysBICubeDimension();
    }

    @Override
    public IPSSysBICubeDimension getPSSysBICubeDimension() {
        return this.iPSSysBICubeDimension;
    }

    protected void setPSSysBICubeDimension(IPSSysBICubeDimension iPSSysBICubeDimension) {
        this.iPSSysBICubeDimension = iPSSysBICubeDimension;
        if (this.getPSSysBICubeDimension() != null) {
            this.setPSSysBICube(this.getPSSysBICubeDimension().getPSSysBICube());
        } else {
            this.setPSSysBICube(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBICubeDimension().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysBICubeDimension();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysBICubeDimension();
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
        if (this.getPSSysBICubeDimension() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBICubeDimension().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysBICubeDimension() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBICubeDimension().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

