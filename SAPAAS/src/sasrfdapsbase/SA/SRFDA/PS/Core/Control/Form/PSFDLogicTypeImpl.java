/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSFDLogicType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFDA.PS.Data.PSFDLogicType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFDLogicTypeImpl
extends PSObjectImpl
implements IPSFDLogicType {
    protected PSFDLogicType psFDLogicType = null;
    private static final Log log = LogFactory.getLog(PSFDLogicTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSFDLogicType psFDLogicType) throws Exception {
        this.psFDLogicType = psFDLogicType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psFDLogicType.getPSFDLOGICTYPEID());
        this.setName(psFDLogicType.getPSFDLOGICTYPENAME());
        this.onInit();
    }

    @Override
    public IPSDEFDLogic createPSDEFDLogic(PSDEFDLogic psDEFDLogic) throws Exception {
        return (IPSDEFDLogic)ObjectHelper.Create((String)this.psFDLogicType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

