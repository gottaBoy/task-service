/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBValueFunc;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDBValueFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDBValueFuncImpl
extends PSObjectImpl
implements IPSDBValueFunc {
    protected PSDBValueFunc psDBValueFunc = null;
    private static final Log log = LogFactory.getLog(PSDBValueFuncImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDBValueFunc psDBValueFunc) throws Exception {
        this.psDBValueFunc = psDBValueFunc;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDBValueFunc.getPSDBVALUEFUNCID());
        this.setName(psDBValueFunc.getPSDBVALUEFUNCNAME());
        this.setPSObjectData(this.psDBValueFunc);
        this.onInit();
    }

    @Override
    public int getInputStdDataType() {
        return this.psDBValueFunc.getINPUTSTDDATATYPE();
    }

    @Override
    public int getOutputStdDataType() {
        return this.psDBValueFunc.getOUTPUTSTDDATATYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

