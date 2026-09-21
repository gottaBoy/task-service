/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Search.IPSSearchScheme;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Core.Search.IPSSysSearchSchemeObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysSearchSchemeObjectImpl
extends PSObjectImpl
implements IPSSysSearchSchemeObject {
    private IPSSysSearchScheme iPSSysSearchScheme = null;

    @Override
    public IPSSearchScheme getPSSearchScheme() {
        return this.getPSSysSearchScheme();
    }

    @Override
    public IPSSysSearchScheme getPSSysSearchScheme() {
        return this.iPSSysSearchScheme;
    }

    protected void setPSSysSearchScheme(IPSSysSearchScheme iPSSysSearchScheme) {
        this.iPSSysSearchScheme = iPSSysSearchScheme;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysSearchScheme().getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysSearchScheme().getModelId(), (Object)this.getId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysSearchScheme().getPSSystem());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysSearchScheme();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysSearchScheme();
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
        if (this.getPSSysSearchScheme() != null) {
            return String.format("%1$s/%2$s", this.getPSSysSearchScheme().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysSearchScheme() != null) {
            return String.format("%1$s/%2$s", this.getPSSysSearchScheme().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

