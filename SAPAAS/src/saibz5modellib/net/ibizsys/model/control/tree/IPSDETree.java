/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.tree.ITree
 */
package net.ibizsys.model.control.tree;

import java.util.Iterator;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.model.control.tree.IPSDETreeColumn;
import net.ibizsys.model.control.tree.IPSDETreeNode;
import net.ibizsys.model.control.tree.IPSDETreeNodeRS;
import net.ibizsys.paas.control.tree.ITree;

public interface IPSDETree
extends IPSMDAjaxControl,
ITree {
    public boolean isEnableRootSelect();

    public boolean isRootVisible();

    public Iterator<IPSDETreeNode> getPSDETreeNodes();

    public Iterator<IPSDETreeNodeRS> getPSDETreeNodeRSs();

    public IPSDETreeNodeRS getPSDETreeNodeRS(String var1) throws Exception;

    public IPSDETreeNode getPSDETreeNode(String var1) throws Exception;

    public IPSCodeList getCatPSCodeList();

    public String getEmptyText();

    public Iterator<IPSDETreeColumn> getPSDETreeColumns();

    public IPSDETreeColumn getPSDETreeColumn(String var1) throws Exception;

    public boolean isEnableTreeGrid();

    public boolean isBufferRenderer();
}

