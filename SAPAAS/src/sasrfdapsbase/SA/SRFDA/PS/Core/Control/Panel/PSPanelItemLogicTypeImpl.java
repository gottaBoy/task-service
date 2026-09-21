/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogicType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelItemLogic;
import SA.SRFDA.PS.Data.PSPanelItemLogicType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPanelItemLogicTypeImpl
extends PSObjectImpl
implements IPSPanelItemLogicType {
    protected PSPanelItemLogicType psPanelItemLogicType = null;
    private static final Log log = LogFactory.getLog(PSPanelItemLogicTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPanelItemLogicType psPanelItemLogicType) throws Exception {
        this.psPanelItemLogicType = psPanelItemLogicType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psPanelItemLogicType.getPSPILOGICTYPEID());
        this.setName(psPanelItemLogicType.getPSPILOGICTYPENAME());
        this.onInit();
    }

    @Override
    public IPSPanelItemLogic createPSPanelItemLogic(PSPanelItemLogic psPanelItemLogic) throws Exception {
        return (IPSPanelItemLogic)ObjectHelper.Create((String)this.psPanelItemLogicType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

