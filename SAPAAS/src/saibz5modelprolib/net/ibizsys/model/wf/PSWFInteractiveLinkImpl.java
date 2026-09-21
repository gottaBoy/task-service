/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFInteractiveLink
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFProcRoleModel
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.model.wf;

import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.wf.IPSWFInteractiveLink;
import net.ibizsys.model.wf.PSWFLinkImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFRoleUser;

public class PSWFInteractiveLinkImpl
extends PSWFLinkImpl
implements IPSWFInteractiveLink {
    protected String strNextCondition = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strNextCondition = this.psWFLink.getNEXTCOND();
        if (StringHelper.isNullOrEmpty((String)this.strNextCondition)) {
            this.strNextCondition = "ANY";
        }
    }

    public boolean isActorIAActionControl() {
        return false;
    }

    public boolean containsWFProcRole(IWFProcRoleModel iWFProcRoleModel) {
        return false;
    }

    public boolean containsUDActor(String strUDActorId) {
        return false;
    }

    public int getActionCount() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u6761\u4ef6")
    public String getNextCondition() {
        if (this.isEnableCustomCond()) {
            return this.getCustomCond();
        }
        return this.strNextCondition;
    }

    public Iterator<IWFRoleUser> getAddedWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        if (this.getAddedWFRoleModel() == null) {
            return null;
        }
        return this.getAddedWFRoleModel().getWFRoleUserModels(iWFActionContext);
    }
}

