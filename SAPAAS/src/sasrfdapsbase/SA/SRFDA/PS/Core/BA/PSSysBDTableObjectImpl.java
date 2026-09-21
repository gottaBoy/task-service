/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.psba.core.IBATable
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableObject;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeObjectImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import net.ibizsys.psba.core.IBATable;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysBDTableObjectImpl
extends PSSysBDSchemeObjectImpl
implements IPSSysBDTableObject {
    protected IPSSysBDTable iPSSysBDTable = null;

    @Override
    public IPSSysBDTable getPSSysBDTable() {
        return this.iPSSysBDTable;
    }

    public IBATable getBATable() {
        return this.getPSSysBDTable();
    }

    protected void setPSSysBDTable(IPSSysBDTable iPSSysBDTable) {
        this.iPSSysBDTable = iPSSysBDTable;
        if (this.iPSSysBDTable != null) {
            this.setPSSysBDScheme(this.iPSSysBDTable.getPSSysBDScheme());
        } else {
            this.setPSSysBDScheme(null);
        }
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysBDTable();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysBDTable();
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
        if (this.getPSSysBDTable() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBDTable().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysBDTable() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBDTable().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

