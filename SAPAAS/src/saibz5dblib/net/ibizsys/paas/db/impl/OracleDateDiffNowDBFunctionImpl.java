/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.impl.DateDiffNowDBFunctionImplBase
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.db.impl.DateDiffNowDBFunctionImplBase;
import net.ibizsys.paas.util.StringHelper;

public class OracleDateDiffNowDBFunctionImpl
extends DateDiffNowDBFunctionImplBase {
    public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
        if (args == null || args.length != 1) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5e93\u503c\u51fd\u6570[%1$s]\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e", (Object)this.getName()));
        }
        return StringHelper.format((String)"(TRUNC(sysdate)-TRUNC(%1$s))", (Object)args[0]);
    }
}

