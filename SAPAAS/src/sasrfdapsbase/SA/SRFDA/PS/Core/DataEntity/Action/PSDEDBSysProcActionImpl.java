/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.db.IProcParam
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionType;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEDBSysProcAction;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionImplBase;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProc;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.db.IProcParam;

@PSModelPFIgnoreMeta
public class PSDEDBSysProcActionImpl
extends PSDEActionImplBase
implements IPSDEDBSysProcAction {
    protected IPSDEDBSysProc iPSDEDBSysProc = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.iPSDEDBSysProc = this.getPSDataEntity().getPSDEDBSysProc(this.getPSDEDBSysProcId());
        if (StringHelper.IsNullOrEmpty((String)this.getCallerObject())) {
            IPSDEActionType iPSDEActionType = this.getPSModelStorage().getPSDEActionType("SYSDBPROC");
            String strProcType = this.iPSDEDBSysProc.getProcType();
            String strCallerObjectKey = StringHelper.Format((String)"CALLER.%1$s", (Object)strProcType);
            String strCallerObject = PropertiesHelper.GetProperty((Properties)iPSDEActionType.getTypeParams(), (String)strCallerObjectKey, (String)"");
            this.setCallerObject(strCallerObject);
        }
    }

    public String getDBProcName() {
        return this.psDEAction.getPSDESYSPROCNAME();
    }

    @Override
    public String getActionMode() {
        return this.psDEAction.getPSDESPACTIONNAME();
    }

    @Override
    public String getPSDEDBSysProcId() {
        return this.psDEAction.getPSDESYSPROCID();
    }

    @Override
    public String getPSDEDBSPActionId() {
        return this.psDEAction.getPSDESPACTIONID();
    }

    public Iterator<IProcParam> getProcParams(String strDBType) throws Exception {
        return null;
    }

    @Override
    public IPSDEDBSysProc getPSDEDBSysProc() {
        return this.iPSDEDBSysProc;
    }

    @Override
    public String getModelType() {
        return "PSDEACTION";
    }
}

