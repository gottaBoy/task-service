/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBProcParam;
import SA.SRFDA.PS.Core.Database.IPSDEDBProcCode;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDBProcParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public class PSDBProcParamImpl
extends PSObjectImpl
implements IPSDBProcParam {
    protected IPSDEDBProcCode iPSDEDBProcCode = null;
    protected PSDBProcParam psDBProcName = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDBProcCode iPSDEDBProcCode, PSDBProcParam psDBProcName) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDEDBProcCode = iPSDEDBProcCode;
        this.psDBProcName = psDBProcName;
        this.setId(this.psDBProcName.getPSDBPROCPARAMID());
        this.setName(this.psDBProcName.getPSDBPROCPARAMNAME());
        this.setPSObjectData(this.psDBProcName);
        this.onInit();
    }

    public int getDataType() {
        return this.psDBProcName.getJDBCTYPE();
    }

    public int getDirection() {
        return this.psDBProcName.getPARAMDIR();
    }

    public String getOutputParamName() {
        return this.getName();
    }

    public String getParamName() {
        return this.getName();
    }

    public Object getDefaultValue() {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDBProcCode.getPSSysModelInstId();
    }
}

