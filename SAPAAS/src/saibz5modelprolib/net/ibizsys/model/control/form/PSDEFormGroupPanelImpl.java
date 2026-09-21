/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormGroupPanel
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormGroupPanel;
import net.ibizsys.model.control.form.PSDEFormBaseGroupPanelImpl;
import net.ibizsys.paas.util.JsonNodeHelper;

public class PSDEFormGroupPanelImpl
extends PSDEFormBaseGroupPanelImpl
implements IPSDEFormGroupPanel {
    private boolean bEnableAnchor = false;
    private int nMoreActions = 0;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEFormDetail.isENABLEANCHORNull()) {
            this.bEnableAnchor = this.psDEFormDetail.getENABLEANCHOR();
        }
        if (!this.psDEFormDetail.isBUILDINACTIONNull()) {
            this.nMoreActions = this.psDEFormDetail.getBUILDINACTION();
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u6210\u5458\u96c6\u5408")
    public Iterator<IPSDEFormDetail> getPSDEFormDetails() {
        return this.psDEFormDetailList.iterator();
    }

    public int getPSDEFormDetailCount() {
        return this.psDEFormDetailList.size();
    }

    public IPSDEFormDetail getPSDEFormDetail(int nIndex) throws Exception {
        return (IPSDEFormDetail)this.psDEFormDetailList.get(nIndex);
    }

    @PSModelRTMeta(description="\u63d0\u4f9b\u951a\u70b9")
    public boolean isEnableAnchor() {
        return this.bEnableAnchor;
    }

    @PSModelRTMeta(description="\u5185\u5efa\u64cd\u4f5c")
    public int getBuildInActions() {
        return this.nMoreActions;
    }

    public boolean isEnableBuildInAction(int nAction) {
        return (this.getBuildInActions() & nAction) == nAction;
    }

    @Override
    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        super.onFillJsonObject(objectNode);
        if (!this.isShowCaption()) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)"showcap", (Object)false);
        }
    }
}

