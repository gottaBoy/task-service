/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.DBProcParam;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.util.StringHelper;

public class DEDBProcParamModel
extends ModelBaseImpl
implements IProcParam {
    private DBProcParam dbProcParam = null;

    public void init(DBProcParam dbProcParam) {
        this.dbProcParam = dbProcParam;
    }

    @Override
    public int getDirection() {
        return this.dbProcParam.dir();
    }

    @Override
    public String getOutputParamName() {
        if (StringHelper.isNullOrEmpty(this.dbProcParam.outputname())) {
            return this.getName();
        }
        return this.dbProcParam.outputname();
    }

    @Override
    public int getDataType() {
        return this.dbProcParam.datatype();
    }

    @Override
    public String getParamName() {
        return this.dbProcParam.name();
    }

    @Override
    public Object getDefaultValue() {
        return null;
    }
}

