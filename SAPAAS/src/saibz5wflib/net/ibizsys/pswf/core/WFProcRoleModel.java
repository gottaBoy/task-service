/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;
import net.ibizsys.pswf.core.WFProcRoleModelBase;

public class WFProcRoleModel
extends WFProcRoleModelBase {
    @Override
    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        if (this.getWFRoleModel() != null) {
            return this.getWFRoleModel().getWFRoleUserModels(iWFActionContext);
        }
        return null;
    }
}

