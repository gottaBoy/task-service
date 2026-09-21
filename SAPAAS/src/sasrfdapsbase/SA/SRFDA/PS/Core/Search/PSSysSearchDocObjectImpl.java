/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Search.IPSSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDocObject;
import SA.SRFDA.PS.Core.Search.PSSysSearchSchemeObjectImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysSearchDocObjectImpl
extends PSSysSearchSchemeObjectImpl
implements IPSSysSearchDocObject {
    private IPSSysSearchDoc iPSSysSearchDoc = null;

    @Override
    public IPSSearchDoc getPSSearchDoc() {
        return this.getPSSysSearchDoc();
    }

    @Override
    public IPSSysSearchDoc getPSSysSearchDoc() {
        return this.iPSSysSearchDoc;
    }

    protected void setPSSysSearchDoc(IPSSysSearchDoc iPSSysSearchDoc) {
        this.iPSSysSearchDoc = iPSSysSearchDoc;
        if (this.getPSSysSearchDoc() != null) {
            this.setPSSysSearchScheme(this.getPSSysSearchDoc().getPSSysSearchScheme());
        } else {
            this.setPSSysSearchScheme(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysSearchDoc().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysSearchDoc();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysSearchDoc();
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
        if (this.getPSSysSearchDoc() != null) {
            return String.format("%1$s/%2$s", this.getPSSysSearchDoc().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysSearchDoc() != null) {
            return String.format("%1$s/%2$s", this.getPSSysSearchDoc().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

