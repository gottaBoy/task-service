/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.Iterator;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;

public class DEDataQueryCodeCondModel
implements IDEDataQueryCodeCond {
    private DEDataQueryCodeCond deDataQueryCodeCond = null;

    public DEDataQueryCodeCondModel(DEDataQueryCodeCond deDataQueryCodeCond) {
        this.deDataQueryCodeCond = deDataQueryCodeCond;
    }

    @Override
    public String getId() {
        return this.deDataQueryCodeCond.id();
    }

    @Override
    public String getName() {
        return this.deDataQueryCodeCond.name();
    }

    @Override
    public String getDEFName() {
        return null;
    }

    @Override
    public String getCondType() {
        return "CUSTOM";
    }

    @Override
    public String getCondOp() {
        return null;
    }

    @Override
    public String getCondValue() {
        return null;
    }

    @Override
    public String getCustomCond() {
        return this.deDataQueryCodeCond.condition();
    }

    @Override
    public String getPredefindedCond() {
        return null;
    }

    @Override
    public String getPredefinedCode() {
        return null;
    }

    @Override
    public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
        return null;
    }

    @Override
    public String getDEFieldExp() {
        return null;
    }

    @Override
    public boolean isNotMode() {
        return false;
    }

    @Override
    public int getStdDataType() {
        return 0;
    }

    @Override
    public String getValueFunc() {
        return null;
    }
}

