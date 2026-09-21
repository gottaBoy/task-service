/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcType;
import SA.SRFDA.PS.Core.Database.IPSDEDBProcCode;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProc;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProcCode;
import SA.SRFDA.PS.Core.Database.PSDEDBProcImpl;
import SA.SRFDA.PS.Core.Database.PSDEDBSysProcCodeGlobalModel;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBSysProc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;

@PSModelIgnoreMeta
public class PSDEDBSysProcImpl
extends PSDEDBProcImpl
implements IPSDEDBSysProc {
    protected PSDEDBSysProc psDESysProc = null;
    protected PSDEDBSysProcCodeGlobalModel psDEDBSysProcCodeGlobalModel = new PSDEDBSysProcCodeGlobalModel();
    protected IPSDBSysProcType iPSDBSysProcType = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDBSysProc psDESysProc) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDataEntity(iPSDataEntity);
        this.psDESysProc = psDESysProc;
        this.setId(this.psDESysProc.getPSDESYSPROCID());
        this.setName(this.psDESysProc.getPSDESYSPROCNAME());
        this.setPSObjectData(this.psDESysProc);
        this.psDEDBSysProcCodeGlobalModel.Init(iDAGlobalHelper, this);
        this.iPSDBSysProcType = this.getPSModelStorage().getPSDBSysProcType(this.getProcType());
        this.onInit();
    }

    @Override
    public IPSDEDBProcCode getPSDEDBProcCode(String strDBType) throws Exception {
        return this.getPSDEDBSysProcCode(strDBType);
    }

    @Override
    public IPSDEDBSysProcCode getPSDEDBSysProcCode(String strDBType) throws Exception {
        String strId = Helper.GenUniqueId((String)this.getId(), (String)strDBType);
        return (IPSDEDBSysProcCode)this.psDEDBSysProcCodeGlobalModel.FindModelHelper(strId);
    }

    @Override
    public String getProcType() {
        return this.psDESysProc.getSYSPROCTYPE();
    }

    @Override
    public IPSDBSysProcType getPSDBSysProcType() {
        return this.iPSDBSysProcType;
    }

    @Override
    public String getModelType() {
        return "PSDESYSPROC";
    }
}

