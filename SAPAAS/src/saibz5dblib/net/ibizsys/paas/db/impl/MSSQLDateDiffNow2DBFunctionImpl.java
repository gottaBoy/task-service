/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.impl.DateDiffNow2DBFunctionImplBase
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.db.impl.DateDiffNow2DBFunctionImplBase;
import net.ibizsys.paas.util.StringHelper;

public class MSSQLDateDiffNow2DBFunctionImpl
extends DateDiffNow2DBFunctionImplBase {
    public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
        if (args == null || args.length != 1) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5e93\u503c\u51fd\u6570[%1$s]\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e", (Object)this.getName()));
        }
        return StringHelper.format((String)"DATEDIFF(d,getdate(),%1$s)", (Object)args[0]);
    }
}

