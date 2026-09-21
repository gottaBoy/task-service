/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Data.PSViewLogicType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewLogicTypeImpl
extends PSObjectImpl
implements IPSViewLogicType {
    protected PSViewLogicType psViewLogicType = null;
    private static final Log log = LogFactory.getLog(PSViewLogicTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSViewLogicType psViewLogicType) throws Exception {
        this.psViewLogicType = psViewLogicType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psViewLogicType.getPSVIEWLOGICTYPEID());
        this.setName(psViewLogicType.getPSVIEWLOGICTYPENAME());
        this.setPSObjectData(this.psViewLogicType);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IPSViewLogic createPSViewLogic() throws Exception {
        IPSViewLogic iPSAppViewLogic = (IPSViewLogic)ObjectHelper.Create((String)this.psViewLogicType.getAPPVIEWLOGICOBJ());
        return iPSAppViewLogic;
    }

    @Override
    public String getProcessName() {
        return this.psViewLogicType.getPROCESSNAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

