/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDBSysProcAction;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

public interface IDEDBProcModel
extends IDEDBSysProcAction {
    public void fillSqlParams(String var1, IEntity var2, IWebContext var3, SqlParamList var4) throws Exception;
}

