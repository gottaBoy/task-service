/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIScheme;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BI.IPSSysBISchemeObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysBISchemeObjectImpl
extends PSObjectImpl
implements IPSSysBISchemeObject {
    private IPSSysBIScheme iPSSysBIScheme = null;

    @Override
    public IPSBIScheme getPSBIScheme() {
        return this.getPSSysBIScheme();
    }

    @Override
    public IPSSysBIScheme getPSSysBIScheme() {
        return this.iPSSysBIScheme;
    }

    protected void setPSSysBIScheme(IPSSysBIScheme iPSSysBIScheme) {
        this.iPSSysBIScheme = iPSSysBIScheme;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysBIScheme().getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBIScheme().getModelId(), (Object)this.getId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysBIScheme().getPSSystem());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysBIScheme();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysBIScheme();
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
        if (this.getPSSysBIScheme() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIScheme().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysBIScheme() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIScheme().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

