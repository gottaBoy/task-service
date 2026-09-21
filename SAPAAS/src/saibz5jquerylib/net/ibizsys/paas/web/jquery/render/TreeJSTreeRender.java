/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.tree.ITreeNode
 *  net.ibizsys.paas.ctrlhandler.ITreeRender
 *  net.ibizsys.paas.ctrlmodel.ITreeModel
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.psrt.srv.web.WebContext
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.jquery.render;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeRender;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.jquery.render.JSTreeRenderBase;
import net.ibizsys.psrt.srv.web.WebContext;
import net.sf.json.JSONObject;

public class TreeJSTreeRender
extends JSTreeRenderBase
implements ITreeRender {
    public String getNodeId(IWebContext iWebContext) throws Exception {
        return WebContext.getNodeId((IWebContext)iWebContext);
    }

    public void fillFetchResult(ITreeModel iTreeModel, MDAjaxActionResult fetchResult, ArrayList<ITreeNode> treeNodeList) throws Exception {
        fetchResult.setArrayMode(this.isFetchResultArrayMode());
        for (ITreeNode iTreeNode : treeNodeList) {
            fetchResult.getRows().add(TreeJSTreeRender.toJSONObject(iTreeNode, null));
        }
    }

    public static JSONObject toJSONObject(ITreeNode iTreeNode, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put("id", JSONObjectHelper.stripQuotes((String)iTreeNode.getId()));
        jsonObject.put("text", JSONObjectHelper.stripQuotes((String)iTreeNode.getText()));
        if (!StringHelper.isNullOrEmpty((String)iTreeNode.getIconCssClass())) {
            jsonObject.put("icon", JSONObjectHelper.stripQuotes((String)iTreeNode.getIconCssClass()));
        } else if (!StringHelper.isNullOrEmpty((String)iTreeNode.getIcon())) {
            jsonObject.put("icon", JSONObjectHelper.stripQuotes((String)iTreeNode.getIcon()));
        }
        JSONObject stateJO = new JSONObject();
        stateJO.put("opened", iTreeNode.isExpanded());
        jsonObject.put("state", (Object)stateJO);
        if (iTreeNode.getTag() != null) {
            jsonObject.put("tag", (Object)iTreeNode.getTag());
        }
        if (iTreeNode.isLeaf()) {
            jsonObject.put("children", false);
        } else if (iTreeNode.getChildNodes() == null) {
            jsonObject.put("children", true);
        } else {
            ArrayList<JSONObject> items = new ArrayList<JSONObject>();
            Iterator treeNodes = iTreeNode.getChildNodes();
            while (treeNodes.hasNext()) {
                ITreeNode childTreeNode = (ITreeNode)treeNodes.next();
                JSONObject jsonItem = TreeJSTreeRender.toJSONObject(childTreeNode, null);
                items.add(jsonItem);
            }
            jsonObject.put("children", (Object)items.toArray());
        }
        return jsonObject;
    }
}

