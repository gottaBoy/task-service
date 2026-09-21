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

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelLogicNode;
import SA.SRFDA.PS.Data.PSPanelLogicNodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPanelLogicNodeTypeImpl
extends PSObjectImpl
implements IPSPanelLogicNodeType {
    protected PSPanelLogicNodeType psPanelLogicNodeType = null;
    private static final Log log = LogFactory.getLog(PSPanelLogicNodeTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPanelLogicNodeType psPanelLogicNodeType) throws Exception {
        this.psPanelLogicNodeType = psPanelLogicNodeType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psPanelLogicNodeType.getPSPANELLNTYPEID());
        this.setName(psPanelLogicNodeType.getPSPANELLNTYPENAME());
        this.setPSObjectData(this.psPanelLogicNodeType);
        this.onInit();
    }

    @Override
    public IPSPanelLogicNode createPSPanelLogicNode(PSPanelLogicNode psPanelLogicNode) throws Exception {
        return (IPSPanelLogicNode)ObjectHelper.Create((String)this.psPanelLogicNodeType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

