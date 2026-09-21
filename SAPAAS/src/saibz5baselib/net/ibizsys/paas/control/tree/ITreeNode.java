/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.tree;

import java.util.Iterator;
import net.ibizsys.paas.core.IModelBase;
import net.sf.json.JSONObject;

public interface ITreeNode
extends IModelBase {
    public String getTreeNodeType();

    public ITreeNode findTreeNode(String var1);

    public boolean isAsyncMode();

    public boolean isAlwaysAsyncMode();

    public boolean isExpanded();

    public boolean isDisabled();

    public boolean isLeaf();

    public String getCssClass();

    public String getIconCssClass();

    public String getIcon();

    public String getHref();

    public String getHrefTarget();

    public String getTips();

    public String getText();

    public boolean isDraggable();

    public boolean isChecked();

    public boolean isEnableCheck();

    public boolean containsTreeNode(String var1);

    public void addChildNode(ITreeNode var1);

    public void resetChildNodes();

    public Object getTagValue(String var1);

    public JSONObject getTag();

    public Iterator<ITreeNode> getChildNodes();

    public void setLeaf(boolean var1);

    public String getCounterId();

    public int getCounterMode();

    public Object getDataSource();

    public String getNodeDataType();
}

