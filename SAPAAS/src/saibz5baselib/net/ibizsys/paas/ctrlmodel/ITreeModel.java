/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface ITreeModel
extends ICtrlModel {
    public static final String NODE_SEPARATOR = ";";
    public static final String NODE_ROOTID = "root";

    public ITreeNodeModel getRootTreeNodeModel();

    public ITreeNodeModel getTreeNodeModel(String var1) throws Exception;

    public Iterator<ITreeNodeModel> getTreeNodeModels();

    public boolean isEnableRootSelect();

    public boolean isRootVisible();

    public String getCatCodeListId();

    public void fillCatFetchResult(MDAjaxActionResult var1) throws Exception;

    public boolean isOutputTreeNodeRS(ITreeNodeFetchContext var1, ITreeNodeRSModel var2) throws Exception;

    public boolean isOutputTreeNode(ITreeNodeFetchContext var1, ITreeNode var2) throws Exception;

    public String getCounterId();
}

