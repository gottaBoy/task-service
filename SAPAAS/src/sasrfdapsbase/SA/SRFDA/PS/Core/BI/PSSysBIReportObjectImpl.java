/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportObject;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeObjectImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysBIReportObjectImpl
extends PSSysBISchemeObjectImpl
implements IPSSysBIReportObject {
    private IPSSysBIReport iPSSysBIReport = null;

    @Override
    public IPSBIReport getPSBIReport() {
        return this.getPSSysBIReport();
    }

    @Override
    public IPSSysBIReport getPSSysBIReport() {
        return this.iPSSysBIReport;
    }

    protected void setPSSysBIReport(IPSSysBIReport iPSSysBIReport) {
        this.iPSSysBIReport = iPSSysBIReport;
        if (this.getPSSysBIReport() != null) {
            this.setPSSysBIScheme(this.getPSSysBIReport().getPSSysBIScheme());
        } else {
            this.setPSSysBIScheme(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBIReport().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysBIReport();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysBIReport();
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
        if (this.getPSSysBIReport() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIReport().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysBIReport() != null) {
            return String.format("%1$s/%2$s", this.getPSSysBIReport().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

