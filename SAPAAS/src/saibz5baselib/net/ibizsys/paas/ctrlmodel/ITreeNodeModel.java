/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;
import net.ibizsys.paas.db.IDataTable;

public interface ITreeNodeModel
extends IModelBase {
    public static final int COUNTERMODE_NONE = 0;
    public static final int COUNTERMODE_HIDEZERO = 1;
    public static final String TREENODE_SEPARATOR = ";";
    public static final String ROOTNODEID = "root";
    public static final String TREENODETYPE_STATIC = "STATIC";
    public static final String TREENODETYPE_DE = "DE";
    public static final String TREENODETYPE_CODELIST = "CODELIST";
    public static final String NODEACTION_PAGELINK = "PAGELINK";
    public static final String NODEACTION_JAVASCRIPT = "JAVASCRIPT";

    public ITreeModel getTreeModel();

    public String getDEName();

    public Iterator<ITreeNodeRSModel> getTreeNodeRSModels();

    public String getTreeNodeType();

    public void fillFetchResult(ITreeNodeFetchContext var1, ArrayList<ITreeNode> var2) throws Exception;

    public void fillFetchResult(ITreeNodeFetchContext var1, ArrayList<ITreeNode> var2, IDataTable var3) throws Exception;

    public boolean isAppendPNodeId();

    public String getIconCls();

    public String getIconPath();

    public boolean isExpanded();

    public boolean isEnableCheck();

    public String getNodeType();

    public boolean isChecked();

    public boolean isRootNode();

    public boolean hasTreeNodeRSModel();

    public int getCounterMode();

    public String getCounterId();

    public String getNodeDataType();

    public boolean isEnableQuickSearch();

    public ITreeNodeDataItem getTreeNodeDataItem(String var1) throws Exception;

    public Iterator<ITreeNodeDataItem> getTreeNodeDataItems();
}

