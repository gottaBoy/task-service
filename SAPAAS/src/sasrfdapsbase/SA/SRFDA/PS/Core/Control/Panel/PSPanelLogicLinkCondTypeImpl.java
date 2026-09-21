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

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCondType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCondType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPanelLogicLinkCondTypeImpl
extends PSObjectImpl
implements IPSPanelLogicLinkCondType {
    protected PSPanelLogicLinkCondType psPanelLogicLinkCondType = null;
    private static final Log log = LogFactory.getLog(PSPanelLogicLinkCondTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPanelLogicLinkCondType psPanelLogicLinkCondType) throws Exception {
        this.psPanelLogicLinkCondType = psPanelLogicLinkCondType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psPanelLogicLinkCondType.getPSPANELLLCONDTYPEID());
        this.setName(psPanelLogicLinkCondType.getPSPANELLLCONDTYPENAME());
        this.setPSObjectData(this.psPanelLogicLinkCondType);
        this.onInit();
    }

    @Override
    public IPSPanelLogicLinkCond createPSPanelLogicLinkCond(PSPanelLogicLinkCond psPanelLogicLinkCond) throws Exception {
        return (IPSPanelLogicLinkCond)ObjectHelper.Create((String)this.psPanelLogicLinkCondType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

