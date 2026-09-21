/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchyObject;
import SA.SRFDA.PS.Core.BI.PSSysBIDimensionObjectImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysBIHierarchyObjectImpl
extends PSSysBIDimensionObjectImpl
implements IPSSysBIHierarchyObject {
    private IPSSysBIHierarchy iPSSysBIHierarchy = null;

    @Override
    public IPSBIHierarchy getPSBIHierarchy() {
        return this.getPSSysBIHierarchy();
    }

    @Override
    public IPSSysBIHierarchy getPSSysBIHierarchy() {
        return this.iPSSysBIHierarchy;
    }

    protected void setPSSysBIHierarchy(IPSSysBIHierarchy iPSSysBIHierarchy) {
        this.iPSSysBIHierarchy = iPSSysBIHierarchy;
        if (this.getPSSysBIHierarchy() != null) {
            this.setPSSysBIDimension(this.getPSSysBIHierarchy().getPSSysBIDimension());
        } else {
            this.setPSSysBIDimension(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBIHierarchy().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysBIHierarchy();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysBIHierarchy();
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
        if (this.getPSSysBIHierarchy() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIHierarchy().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysBIHierarchy() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIHierarchy().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

