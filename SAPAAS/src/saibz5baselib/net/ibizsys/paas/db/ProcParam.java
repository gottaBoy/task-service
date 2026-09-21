/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.db.SqlParam;

public class ProcParam
extends SqlParam
implements IProcParam {
    @Override
    public Object getDefaultValue() {
        return this.getValue();
    }

    public void setDefaultValue(Object objValue) {
        this.setValue(objValue);
    }
}

