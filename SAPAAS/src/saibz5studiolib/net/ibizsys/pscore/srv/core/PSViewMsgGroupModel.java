/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.IViewMsgModel
 *  net.ibizsys.paas.view.ViewMsgGroupModel
 */
package net.ibizsys.pscore.srv.core;

import java.util.ArrayList;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.paas.view.ViewMsgGroupModel;
import net.ibizsys.pscore.srv.core.IPSViewMsgFilter;
import net.ibizsys.pscore.srv.core.IPSViewMsgGroupModel;
import net.ibizsys.pscore.srv.core.IPSViewMsgModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;

public class PSViewMsgGroupModel
extends ViewMsgGroupModel
implements IPSViewMsgGroupModel {
    private String strCodeName = null;

    public void setCodeName(String string) {
        this.strCodeName = string;
    }

    @Override
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public PSViewMsg[] listPSViewMsgs(IPSViewMsgFilter iPSViewMsgFilter) throws Exception {
        ArrayList<PSViewMsg> arrayList = new ArrayList<PSViewMsg>();
        for (IViewMsgModel iViewMsgModel : this.viewMsgModelList) {
            if (!(iViewMsgModel instanceof IPSViewMsgModel)) continue;
            ((IPSViewMsgModel)iViewMsgModel).fillPSViewMsgs(iPSViewMsgFilter, arrayList);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList.toArray(new PSViewMsg[arrayList.size()]);
    }
}

