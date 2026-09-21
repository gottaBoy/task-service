/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeObject;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeObjectImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysBICubeObjectImpl
extends PSSysBISchemeObjectImpl
implements IPSSysBICubeObject {
    private IPSSysBICube iPSSysBICube = null;

    @Override
    public IPSBICube getPSBICube() {
        return this.getPSSysBICube();
    }

    @Override
    public IPSSysBICube getPSSysBICube() {
        return this.iPSSysBICube;
    }

    protected void setPSSysBICube(IPSSysBICube iPSSysBICube) {
        this.iPSSysBICube = iPSSysBICube;
        if (this.getPSSysBICube() != null) {
            this.setPSSysBIScheme(this.getPSSysBICube().getPSSysBIScheme());
        } else {
            this.setPSSysBIScheme(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBICube().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysBICube();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysBICube();
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
        if (this.getPSSysBICube() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBICube().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysBICube() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBICube().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

