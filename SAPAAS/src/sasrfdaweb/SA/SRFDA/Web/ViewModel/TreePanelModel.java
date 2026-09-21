/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.ViewModel;

import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class TreePanelModel
extends ControlModel {
    protected boolean bMultiSelect = false;
    protected boolean bSelectLeaf = false;
    protected String strCodeListId = "";
    protected String strRootNodeText = "";
    protected String strTreeNodeFilter = "";
    protected String strTreeNodeLink = "";
    protected boolean bShowRoot = false;
    protected String strActiveNode = "";
    protected String strCounterPath = "";
    protected int nDefaultLevel = 0;

    public boolean getMultiSelect() {
        return this.bMultiSelect;
    }

    public void setMultiSelect(boolean bMultiSelect) {
        this.bMultiSelect = bMultiSelect;
    }

    public boolean getSelectLeaf() {
        return this.bSelectLeaf;
    }

    public void setSelectLeaf(boolean bSelectLeaf) {
        this.bSelectLeaf = bSelectLeaf;
    }

    public String getCodeListId() {
        return this.strCodeListId;
    }

    public void setCodeListId(String strCodeListId) {
        this.strCodeListId = strCodeListId;
    }

    public String getRootNodeText() {
        return this.strRootNodeText;
    }

    public void setRootNodeText(String strRootNodeText) {
        this.strRootNodeText = strRootNodeText;
    }

    public String getTreeNodeFilter() {
        return this.strTreeNodeFilter;
    }

    public void setTreeNodeFilter(String strTreeNodeFilter) {
        this.strTreeNodeFilter = strTreeNodeFilter;
    }

    public String getTreeNodeLink() {
        return this.strTreeNodeLink;
    }

    public void setTreeNodeLink(String strTreeNodeLink) {
        this.strTreeNodeLink = strTreeNodeLink;
    }

    public String getCounterPath() {
        return this.strCounterPath;
    }

    public void setCounterPath(String strCounterPath) {
        this.strCounterPath = strCounterPath;
    }

    public boolean getShowRoot() {
        return this.bShowRoot;
    }

    public void setShowRoot(boolean bShowRoot) {
        this.bShowRoot = bShowRoot;
    }

    public String getActiveNode() {
        return this.strActiveNode;
    }

    public void setActiveNode(String strActiveNode) {
        this.strActiveNode = strActiveNode;
    }

    public int getDefaultLevel() {
        return this.nDefaultLevel;
    }

    public void setDefaultLevel(int nDefaultLevel) {
        this.nDefaultLevel = nDefaultLevel;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getMultiSelect()) {
            jo.put("multiselect", this.getMultiSelect());
        }
        if (this.getSelectLeaf()) {
            jo.put("selectleaf", this.getSelectLeaf());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getCodeListId())) {
            jo.put("codelist", (Object)this.getCodeListId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getRootNodeText())) {
            jo.put("rootnodetext", (Object)this.getRootNodeText());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getTreeNodeFilter())) {
            jo.put("nodefilter", (Object)this.getTreeNodeFilter());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getTreeNodeLink())) {
            jo.put("nodelink", (Object)this.getTreeNodeLink());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getCounterPath())) {
            jo.put("counterpath", (Object)this.getCounterPath());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getActiveNode())) {
            jo.put("activenode", (Object)this.getActiveNode());
        }
        if (this.getDefaultLevel() > 0) {
            jo.put("defaultlevel", this.getDefaultLevel());
        }
        jo.put("showroot", this.getShowRoot());
    }
}

