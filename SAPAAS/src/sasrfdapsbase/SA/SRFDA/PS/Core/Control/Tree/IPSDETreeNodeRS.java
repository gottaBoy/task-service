/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSNavContext;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSNavParam;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSParam;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDETreeNodeRS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u8282\u70b9\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDETreeNodeRS")
public interface IPSDETreeNodeRS
extends IPSModelObject,
ITreeNodeRSModel,
IPSControlObject,
IPSNavigateParamContainer {
    public void init(ISRFDAGlobalHelper var1, IPSDETree var2, PSDETreeNodeRS var3) throws Exception;

    public IPSDETree getPSDETree();

    public String getPPSTreeNodeId();

    public String getCPSTreeNodeId();

    public int getOrderValue();

    public IPSDEAction getPSDEAction();

    public IPSDETreeNode getParentPSDETreeNode() throws Exception;

    public IPSDETreeNode getChildPSDETreeNode() throws Exception;

    public IPSDER1N getParentPSDER1N();

    public int getParentValueLevel();

    public String getParentFilter();

    public Iterator<IPSDETreeNodeRSParam> getPSDETreeNodeRSParams() throws Exception;

    public Iterator<IPSDETreeNodeRSNavParam> getPSDETreeNodeRSNavParams() throws Exception;

    public Iterator<IPSDETreeNodeRSNavContext> getPSDETreeNodeRSNavContexts() throws Exception;

    public IPSAppDEField getParentPSAppDEField() throws Exception;

    public int getSearchMode();
}

