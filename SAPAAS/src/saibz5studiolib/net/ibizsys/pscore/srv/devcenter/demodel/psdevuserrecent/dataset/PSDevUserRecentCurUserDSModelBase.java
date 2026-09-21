/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevuserrecent.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="D2ECECC4-BC25-45E5-A575-EC2C77550CF8", name="CurUser", queries={@DEDataSetQuery(queryid="C082036E-AD63-4AAC-8E0A-AAC88B88D877", queryname="CurUser")})
public abstract class PSDevUserRecentCurUserDSModelBase
extends DEDataSetModelBase {
    public PSDevUserRecentCurUserDSModelBase() {
        this.initAnnotation(PSDevUserRecentCurUserDSModelBase.class);
    }
}

