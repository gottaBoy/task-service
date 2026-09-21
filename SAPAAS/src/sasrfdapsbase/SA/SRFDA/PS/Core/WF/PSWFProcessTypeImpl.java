/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessType;
import SA.SRFDA.PS.Data.PSWFProcess;
import SA.SRFDA.PS.Data.PSWFProcessType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSWFProcessTypeImpl
extends PSObjectImpl
implements IPSWFProcessType {
    protected PSWFProcessType psWFProcessType = null;
    private static final Log log = LogFactory.getLog(PSWFProcessTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSWFProcessType psWFProcessType) throws Exception {
        this.psWFProcessType = psWFProcessType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psWFProcessType.getPSWFPROCESSTYPEID());
        this.setName(psWFProcessType.getPSWFPROCESSTYPENAME());
        this.setPSObjectData(this.psWFProcessType);
        this.onInit();
    }

    @Override
    public IPSWFProcess createPSWFProcess(PSWFProcess psWFProcess) throws Exception {
        return (IPSWFProcess)ObjectHelper.Create((String)this.psWFProcessType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

