/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDBCallContext
 *  net.ibizsys.paas.db.SqlParamList
 */
package net.ibizsys.pscore.srv;

import net.ibizsys.paas.core.IDEDBCallContext;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.pscore.srv.IPSRawSelectWork;

public interface IPSCoreSysDAO {
    public void executeRawSelectSql(IDEDBCallContext var1, String var2, SqlParamList var3, IPSRawSelectWork var4) throws Exception;
}

