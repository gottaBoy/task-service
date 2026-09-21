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

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLink;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.PS.Data.PSPanelLogicLinkType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPanelLogicLinkTypeImpl
extends PSObjectImpl
implements IPSPanelLogicLinkType {
    protected PSPanelLogicLinkType psPanelLogicLinkType = null;
    private static final Log log = LogFactory.getLog(PSPanelLogicLinkTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPanelLogicLinkType psPanelLogicLinkType) throws Exception {
        this.psPanelLogicLinkType = psPanelLogicLinkType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psPanelLogicLinkType.getPSPANELLLTYPEID());
        this.setName(psPanelLogicLinkType.getPSPANELLLTYPENAME());
        this.setPSObjectData(this.psPanelLogicLinkType);
        this.onInit();
    }

    @Override
    public IPSPanelLogicLink createPSPanelLogicLink(PSPanelLogicLink psPanelLogicLink) throws Exception {
        return (IPSPanelLogicLink)ObjectHelper.Create((String)this.psPanelLogicLinkType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

