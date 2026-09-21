/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevusersql.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserSql;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevUserSqlExecuteSQLUIActionModelBase
extends DEUIActionModelBase<PSDevUserSql> {
    private static final Log log = LogFactory.getLog(PSDevUserSqlExecuteSQLUIActionModelBase.class);

    public PSDevUserSqlExecuteSQLUIActionModelBase() {
        this.setId("209D9B2D-934D-4E35-884B-67621D781DEB");
        this.setName("ExecuteSQL");
        this.setActionTarget("NONE");
        this.setDEActionName("ExecuteSQL");
        this.setDataAccessAction("READ");
    }
}

