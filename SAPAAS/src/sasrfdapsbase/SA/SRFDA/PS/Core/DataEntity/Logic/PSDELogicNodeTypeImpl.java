/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.PS.Data.PSDELogicNodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicNodeTypeImpl
extends PSObjectImpl
implements IPSDELogicNodeType {
    protected PSDELogicNodeType psDELogicNodeType = null;
    private static final Log log = LogFactory.getLog(PSDELogicNodeTypeImpl.class);
    private String strLogicType = null;
    private int nLogicHolder = 3;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDELogicNodeType psDELogicNodeType) throws Exception {
        this.psDELogicNodeType = psDELogicNodeType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDELogicNodeType.getPSDELNTYPEID());
        this.setName(psDELogicNodeType.getPSDELNTYPENAME());
        this.setPSObjectData(this.psDELogicNodeType);
        this.strLogicType = this.psDELogicNodeType.getLOGICTYPE();
        if (StringHelper.compare((String)this.strLogicType, (String)"VIEWLOGIC", (boolean)false) == 0) {
            this.nLogicHolder = 2;
        } else if (!this.psDELogicNodeType.isLOGICHOLDERNull()) {
            this.nLogicHolder = this.psDELogicNodeType.getLOGICHOLDER();
        }
        this.onInit();
    }

    @Override
    public IPSDELogicNode createPSDELogicNode(PSDELogicNode psDELogicNode) throws Exception {
        IPSDELogicNode iPSDELogicNode = (IPSDELogicNode)ObjectHelper.Create((String)this.psDELogicNodeType.getITEMOBJ());
        if (iPSDELogicNode == null) {
            throw new Exception(String.format("\u65e0\u6cd5\u5efa\u7acb\u903b\u8f91\u8282\u70b9[%1$s][%2$s]\u6a21\u578b\u5bf9\u8c61", psDELogicNode.getPSDELOGICNODENAME(), this.psDELogicNodeType.getPSDELNTYPEID()));
        }
        return iPSDELogicNode;
    }

    @Override
    public IPSDEUILogicNode createPSDEUILogicNode(PSDELogicNode psDELogicNode) throws Exception {
        String strObj = this.psDELogicNodeType.getITEMOBJ2();
        if (StringHelper.isNullOrEmpty((String)strObj)) {
            strObj = this.psDELogicNodeType.getITEMOBJ();
        }
        return (IPSDEUILogicNode)ObjectHelper.Create((String)strObj);
    }

    @Override
    public IPSDEMSLogicNode createPSDEMSLogicNode(PSDELogicNode psDELogicNode) throws Exception {
        return (IPSDEMSLogicNode)ObjectHelper.Create((String)this.psDELogicNodeType.getITEMOBJ());
    }

    @Override
    public IPSDEDataFlowNode createPSDEDataFlowNode(PSDELogicNode psDELogicNode) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDELogicNodeType.getITEMOBJ4())) {
            return (IPSDEDataFlowNode)ObjectHelper.Create((String)this.psDELogicNodeType.getITEMOBJ4());
        }
        return (IPSDEDataFlowNode)ObjectHelper.Create((String)this.psDELogicNodeType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public int getLogicHolder() {
        return this.nLogicHolder;
    }
}

