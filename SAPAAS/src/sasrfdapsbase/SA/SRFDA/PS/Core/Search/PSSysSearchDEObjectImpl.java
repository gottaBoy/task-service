/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Search.IPSSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEObject;
import SA.SRFDA.PS.Core.Search.PSSysSearchSchemeObjectImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysSearchDEObjectImpl
extends PSSysSearchSchemeObjectImpl
implements IPSSysSearchDEObject {
    private IPSSysSearchDE iPSSysSearchDE = null;

    @Override
    public IPSSearchDE getPSSearchDE() {
        return this.getPSSysSearchDE();
    }

    @Override
    public IPSSysSearchDE getPSSysSearchDE() {
        return this.iPSSysSearchDE;
    }

    protected void setPSSysSearchDE(IPSSysSearchDE iPSSysSearchDE) {
        this.iPSSysSearchDE = iPSSysSearchDE;
        if (this.getPSSysSearchDE() != null) {
            this.setPSSysSearchScheme(this.getPSSysSearchDE().getPSSysSearchScheme());
        } else {
            this.setPSSysSearchScheme(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysSearchDE().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysSearchDE();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysSearchDE();
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
        if (this.getPSSysSearchDE() != null) {
            return String.format("%1$s/%2$s", this.getPSSysSearchDE().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysSearchDE() != null) {
            return String.format("%1$s/%2$s", this.getPSSysSearchDE().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

