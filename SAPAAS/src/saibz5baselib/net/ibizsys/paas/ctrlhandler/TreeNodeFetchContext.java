/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class TreeNodeFetchContext
implements ITreeNodeFetchContext {
    private String strNodeFilter = "";
    private boolean bAutoExpand = false;
    private String strRealNodeId = "";
    private boolean bSimpleMode = false;
    private String strCatalog = "";

    public TreeNodeFetchContext() {
    }

    public TreeNodeFetchContext(ITreeNodeFetchContext iTreeNodeFetchContext) {
        this.strNodeFilter = iTreeNodeFetchContext.getNodeFilter();
        this.bAutoExpand = iTreeNodeFetchContext.isAutoExpand();
        this.strRealNodeId = iTreeNodeFetchContext.getRealNodeId();
        this.bSimpleMode = iTreeNodeFetchContext.isSimpleMode();
        this.strCatalog = iTreeNodeFetchContext.getCatalog();
    }

    public TreeNodeFetchContext(IWebContext iWebContext) {
        this.strCatalog = iWebContext.getPostValue("srfcatalog");
        if (StringHelper.isNullOrEmpty(this.strCatalog)) {
            this.strCatalog = "";
        }
        this.strNodeFilter = iWebContext.getPostValue("srfnodefilter");
        if (StringHelper.isNullOrEmpty(this.strNodeFilter)) {
            this.strNodeFilter = "";
        }
        if (!StringHelper.isNullOrEmpty(this.strNodeFilter)) {
            String strAutoExpand = iWebContext.getPostValue("srfautoexpand");
            if (StringHelper.isNullOrEmpty(strAutoExpand)) {
                strAutoExpand = "";
            }
            this.bAutoExpand = StringHelper.compare(strAutoExpand, "TRUE", true) == 0;
        }
    }

    @Override
    public String getNodeFilter() {
        return this.strNodeFilter;
    }

    @Override
    public boolean isAutoExpand() {
        return this.bAutoExpand;
    }

    public void setRealNodeId(String strRealNodeId) {
        this.strRealNodeId = strRealNodeId;
    }

    @Override
    public String getRealNodeId() {
        return this.strRealNodeId;
    }

    @Override
    public boolean isSimpleMode() {
        return this.bSimpleMode;
    }

    protected void setSimpleMode(boolean bSimpleMode) {
        this.bSimpleMode = bSimpleMode;
    }

    @Override
    public String getCatalog() {
        return this.strCatalog;
    }
}

