/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDETreeNode;
import SA.SRFDA.PS.Data.PSDETreeNodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDETreeNodeType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDETreeNodeType var2) throws Exception;

    public IPSDETreeNode createPSDETreeNode(PSDETreeNode var1) throws Exception;
}

