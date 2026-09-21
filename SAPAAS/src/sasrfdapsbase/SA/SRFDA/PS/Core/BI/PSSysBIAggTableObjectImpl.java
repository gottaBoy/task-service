/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggTableObject;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeObjectImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysBIAggTableObjectImpl
extends PSSysBISchemeObjectImpl
implements IPSSysBIAggTableObject {
    private IPSSysBIAggTable iPSSysBIAggTable = null;

    @Override
    public IPSBIAggTable getPSBIAggTable() {
        return this.getPSSysBIAggTable();
    }

    @Override
    public IPSSysBIAggTable getPSSysBIAggTable() {
        return this.iPSSysBIAggTable;
    }

    protected void setPSSysBIAggTable(IPSSysBIAggTable iPSSysBIAggTable) {
        this.iPSSysBIAggTable = iPSSysBIAggTable;
        if (this.getPSSysBIAggTable() != null) {
            this.setPSSysBIScheme(this.getPSSysBIAggTable().getPSSysBIScheme());
        } else {
            this.setPSSysBIScheme(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBIAggTable().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysBIAggTable();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysBIAggTable();
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
        if (this.getPSSysBIAggTable() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIAggTable().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysBIAggTable() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIAggTable().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

