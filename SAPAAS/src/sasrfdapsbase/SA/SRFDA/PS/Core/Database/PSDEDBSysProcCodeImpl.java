/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBProcParam;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProc;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProcCode;
import SA.SRFDA.PS.Core.Database.PSDEDBProcCodeImpl;
import SA.SRFDA.PS.Core.Database.PSDEDBSysProcParamGlobalModel;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBSysProcCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public class PSDEDBSysProcCodeImpl
extends PSDEDBProcCodeImpl
implements IPSDEDBSysProcCode {
    protected PSDEDBSysProcCode psDESysProcCode = null;
    protected IPSDEDBSysProc iPSDEDBSysProc = null;
    protected PSDEDBSysProcParamGlobalModel psDEDBSysProcParamGlobalModel = new PSDEDBSysProcParamGlobalModel();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDBSysProc iPSDEDBSysProc, PSDEDBSysProcCode psDESysProcCode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDEDBSysProc = iPSDEDBSysProc;
        this.psDESysProcCode = psDESysProcCode;
        this.setId(this.psDESysProcCode.getPSDESPCODEID());
        this.setName(this.psDESysProcCode.getPSDESPCODENAME());
        this.setPSObjectData(this.psDESysProcCode);
        this.psDEDBSysProcParamGlobalModel.Init(iDAGlobalHelper, this);
        Iterator psDBProcParams = this.psDEDBSysProcParamGlobalModel.getAllModelHelpers();
        while (psDBProcParams.hasNext()) {
            this.psDBProcParamList.add((IPSDBProcParam)psDBProcParams.next());
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDBSysProc.getPSSysModelInstId();
    }
}

