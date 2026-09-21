/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;

public abstract class TreeNodeRSModelBase
extends ModelBaseImpl
implements ITreeNodeRSModel {
    private String strParentTreeNodeId = "";
    private ITreeModel iTreeModel = null;
    private String strChildTreeNodeId = "";
    private String strDEActionName = null;
    private int nParentValueLevel = 1;
    private int nSearchMode = 3;
    private HashMap<String, String> parentModeParamMap = new HashMap();

    public void init(ITreeModel iTreeModel) throws Exception {
        this.iTreeModel = iTreeModel;
        this.onInit();
    }

    public ITreeModel getTreeModel() {
        return this.iTreeModel;
    }

    @Override
    public String getParentTreeNodeId() {
        return this.strParentTreeNodeId;
    }

    @Override
    public String getChildTreeNodeId() {
        return this.strChildTreeNodeId;
    }

    public void setParentTreeNodeId(String strParentTreeNodeId) {
        this.strParentTreeNodeId = strParentTreeNodeId;
    }

    public void setChildTreeNodeId(String strChildTreeNodeId) {
        this.strChildTreeNodeId = strChildTreeNodeId;
    }

    @Override
    public String getDEActionName() {
        return this.strDEActionName;
    }

    public void setDEActionName(String strDEActionName) {
        this.strDEActionName = strDEActionName;
    }

    public void setParentModeParam(String strKey, String objValue) {
        if (objValue == null) {
            this.parentModeParamMap.remove(strKey.toLowerCase());
        } else {
            this.parentModeParamMap.put(strKey.toLowerCase(), objValue);
        }
    }

    public String getParentModeParam(String strKey) {
        return this.parentModeParamMap.get(strKey.toLowerCase());
    }

    public Iterator<String> getParentModeParamNames() {
        return this.parentModeParamMap.keySet().iterator();
    }

    public void setParentValueLevel(int nParentValueLevel) {
        this.nParentValueLevel = nParentValueLevel;
    }

    public int getParentValueLevel() {
        return this.nParentValueLevel;
    }

    @Override
    public int getSearchMode() {
        return this.nSearchMode;
    }

    public void setSearchMode(int nSearchMode) {
        this.nSearchMode = nSearchMode;
    }
}

