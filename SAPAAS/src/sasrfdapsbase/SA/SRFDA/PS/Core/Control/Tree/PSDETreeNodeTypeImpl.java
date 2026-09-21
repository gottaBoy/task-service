/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDETreeNode;
import SA.SRFDA.PS.Data.PSDETreeNodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETreeNodeTypeImpl
extends PSObjectImpl
implements IPSDETreeNodeType {
    protected PSDETreeNodeType psDETreeNodeType = null;
    private static final Log log = LogFactory.getLog(PSDETreeNodeTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDETreeNodeType psDETreeNodeType) throws Exception {
        this.psDETreeNodeType = psDETreeNodeType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDETreeNodeType.getPSTREENODETYPEID());
        this.setName(psDETreeNodeType.getPSTREENODETYPENAME());
        this.onInit();
    }

    @Override
    public IPSDETreeNode createPSDETreeNode(PSDETreeNode psDETreeNode) throws Exception {
        return (IPSDETreeNode)ObjectHelper.Create((String)this.psDETreeNodeType.getTREENODEOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

