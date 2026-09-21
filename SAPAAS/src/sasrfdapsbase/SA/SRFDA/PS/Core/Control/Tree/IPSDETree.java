/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.tree.ITree
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeLogic;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRS;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITree;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u89c6\u56fe\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDETreeView")
public interface IPSDETree
extends IPSMDAjaxControl,
ITree,
IPSControlContainer,
IPSControlNavigatable {
    public static final int TREEGRIDMODE_NONE = 0;
    public static final int TREEGRIDMODE_DEFAULT = 1;
    public static final int TREEGRIDMODE_GANTT = 2;

    public boolean isEnableRootSelect();

    public boolean isRootVisible();

    public Iterator<IPSDETreeNode> getPSDETreeNodes();

    public Iterator<IPSDETreeNodeRS> getPSDETreeNodeRSs();

    public IPSDETreeNodeRS getPSDETreeNodeRS(String var1) throws Exception;

    public IPSDETreeNode getPSDETreeNode(String var1) throws Exception;

    public IPSCodeList getCatPSCodeList();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    public Iterator<IPSDETreeColumn> getPSDETreeColumns();

    public IPSDETreeColumn getPSDETreeColumn(String var1) throws Exception;

    public boolean isEnableTreeGrid();

    @Override
    public boolean isBufferRenderer();

    public IPSDETreeNode getRootPSDETreeNode();

    public boolean isOutputIconDefault();

    public IPSSysCounterRef getPSSysCounterRef();

    public IPSAppCounterRef getPSAppCounterRef();

    public int getTreeGridMode();

    public boolean isEnableSearchDefault();

    public boolean isEnableEdit();

    public Iterator<? extends IPSDETreeLogic> getPSDETreeLogics();

    public int getColumnEnableLink();

    public int getFrozenFirstColumn();

    public int getFrozenLastColumn();

    public String getTreeStyle();
}

