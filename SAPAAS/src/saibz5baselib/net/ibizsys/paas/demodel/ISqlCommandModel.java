/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.db.ISqlCommand;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

public interface ISqlCommandModel
extends ISqlCommand {
    public void fillSqlParams(IEntity var1, IWebContext var2, SqlParamList var3) throws Exception;
}

