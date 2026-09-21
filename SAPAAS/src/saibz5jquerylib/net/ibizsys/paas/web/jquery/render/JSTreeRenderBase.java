/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.CtrlRenderBase
 *  net.ibizsys.paas.ctrlhandler.ICtrlRender
 */
package net.ibizsys.paas.web.jquery.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CtrlRenderBase;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;

public abstract class JSTreeRenderBase
extends CtrlRenderBase
implements ICtrlRender {
    public static final String TREENODE_COUNTERID = "counterid";
    public static final String TREENODE_COUNTERMODE = "countermode";
    public static final String TREENODE_ID = "id";
    public static final String TREENODE_PID = "pid";
    public static final String TREENODE_TEXT = "text";
    public static final String TREENODE_ICON = "icon";
    public static final String TREENODE_TEXTCLS = "textcls";
    public static final String TREENODE_ITEMS = "children";
    public static final String TREENODE_LEAF = "leaf";
    public static final String TREENODE_VIEWID = "viewid";
    public static final String TREENODE_DRITEM = "dritem";
    public static final String TREENODE_VIEWPARAM = "viewparam";
    public static final String TREENODE_EXPANDED = "opened";
    public static final String TREENODE_STATE = "state";
    public static final String TREENODE_TAG = "tag";

    public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    public String getFetchQuickSearch() {
        return null;
    }

    protected boolean isFetchResultArrayMode() {
        return true;
    }
}

