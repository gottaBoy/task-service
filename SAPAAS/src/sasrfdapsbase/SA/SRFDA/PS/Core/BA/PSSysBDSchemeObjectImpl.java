/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.psba.core.IBAScheme
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDSchemeObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;
import net.ibizsys.psba.core.IBAScheme;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysBDSchemeObjectImpl
extends PSObjectImpl
implements IPSSysBDSchemeObject {
    protected IPSSysBDScheme iPSSysBDScheme = null;

    @Override
    public IPSSysBDScheme getPSSysBDScheme() {
        return this.iPSSysBDScheme;
    }

    public IBAScheme getBAScheme() {
        return this.getPSSysBDScheme();
    }

    protected void setPSSysBDScheme(IPSSysBDScheme iPSSysBDScheme) {
        this.iPSSysBDScheme = iPSSysBDScheme;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysBDScheme().getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysBDScheme().getPSSystem());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysBDScheme();
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
        if (this.getPSSysBDScheme() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBDScheme().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysBDScheme() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBDScheme().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysBDScheme();
    }
}

