/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.StaticViewMsgModel
 */
package net.ibizsys.pscore.srv.core;

import java.util.ArrayList;
import net.ibizsys.paas.view.StaticViewMsgModel;
import net.ibizsys.pscore.srv.core.IPSViewMsgFilter;
import net.ibizsys.pscore.srv.core.IPSViewMsgModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;

public class PSStaticViewMsgModel
extends StaticViewMsgModel
implements IPSViewMsgModel {
    private PSViewMsg psViewMsg = null;
    private int nCloseMode = 0;

    public void setCloseMode(int n) {
        this.nCloseMode = n;
    }

    public int getCloseMode(int n) {
        return this.nCloseMode;
    }

    @Override
    public int fillPSViewMsgs(IPSViewMsgFilter iPSViewMsgFilter, ArrayList<PSViewMsg> arrayList) throws Exception {
        PSViewMsg pSViewMsg = this.psViewMsg;
        if (pSViewMsg == null) {
            pSViewMsg = new PSViewMsg();
            pSViewMsg.setPSViewMsgId(this.getId());
            pSViewMsg.setTitle(this.getTitle());
            pSViewMsg.setMsgType(this.getMessageType());
            pSViewMsg.setMsgPos(this.getPosition());
            pSViewMsg.setContent(this.getMessage());
            if (this.psViewMsg == null) {
                this.psViewMsg = pSViewMsg;
            }
        }
        arrayList.add(pSViewMsg);
        return 1;
    }
}

