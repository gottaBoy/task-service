/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDETreeNodeRV;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u89c6\u56fe\u8282\u70b9\u5f15\u7528\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDETreeNodeRV")
public interface IPSDETreeNodeRV
extends IPSModelObject,
IPSNavigateParamContainer {
    public void init(ISRFDAGlobalHelper var1, IPSDETreeNode var2, PSDETreeNodeRV var3) throws Exception;

    public String getPSDEViewBaseId();

    public IPSDETreeNode getPSDETreeNode();

    public String getViewParam();

    public IPSAppView getRefPSAppView() throws Exception;
}

