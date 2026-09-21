/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.TreePageModel;
import SA.SRFramework.Utility.StringHelper;
import java.util.Collection;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TreeExplorerViewModel
extends TreePageModel {
    protected boolean bRootDimension = false;
    protected boolean bNodeSearch = false;
    protected String strDefaultView = "";
    protected String strNodeSelectCode = "";
    protected String strNodeContextMenuId = "";
    protected int nTitleBarWidth = 0;
    protected Vector rootDimensionList = null;

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getRootDimension()) {
            jo.put("rootdimension", this.getRootDimension());
            if (this.getRootDimensionList() != null) {
                jo.put("rootdimensions", (Collection)this.getRootDimensionList());
            }
        }
        if (this.getNodeSearch()) {
            jo.put("nodesearch", this.getNodeSearch());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getDefaultView())) {
            jo.put("defaultview", (Object)this.getDefaultView());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getNodeSelectCode())) {
            jo.put("nodeselectcode", (Object)this.getNodeSelectCode());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getNodeContextMenuId())) {
            jo.put("nodecontextmenuid", (Object)this.getNodeContextMenuId());
        }
        jo.put("titlebarwidth", this.getTitleBarWidth());
    }

    public boolean getRootDimension() {
        return this.bRootDimension;
    }

    public void setRootDimension(boolean bRootDimension) {
        this.bRootDimension = bRootDimension;
    }

    public boolean getNodeSearch() {
        return this.bNodeSearch;
    }

    public void setNodeSearch(boolean bNodeSearch) {
        this.bNodeSearch = bNodeSearch;
    }

    public String getDefaultView() {
        return this.strDefaultView;
    }

    public void setDefaultView(String strDefaultView) {
        this.strDefaultView = strDefaultView;
    }

    public String getNodeSelectCode() {
        return this.strNodeSelectCode;
    }

    public void setNodeSelectCode(String strNodeSelectCode) {
        this.strNodeSelectCode = strNodeSelectCode;
    }

    public Vector getRootDimensionList() {
        return this.rootDimensionList;
    }

    public void setRootDimensionList(Vector rootDimensionList) {
        this.rootDimensionList = rootDimensionList;
    }

    public String getNodeContextMenuId() {
        return this.strNodeContextMenuId;
    }

    public void setNodeContextMenuId(String strNodeContextMenuId) {
        this.strNodeContextMenuId = strNodeContextMenuId;
    }

    public int getTitleBarWidth() {
        return this.nTitleBarWidth;
    }

    public void setTitleBarWidth(int nTitleBarWidth) {
        this.nTitleBarWidth = nTitleBarWidth;
    }
}

