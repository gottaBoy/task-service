/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;

public class DEDataQueryCodeExpModel
implements IDEDataQueryCodeExp {
    private DEDataQueryCodeExp deDataQueryCodeExp = null;

    public DEDataQueryCodeExpModel(DEDataQueryCodeExp deDataQueryCodeExp) {
        this.deDataQueryCodeExp = deDataQueryCodeExp;
    }

    @Override
    public String getId() {
        return this.deDataQueryCodeExp.id();
    }

    @Override
    public String getName() {
        return this.deDataQueryCodeExp.name();
    }

    @Override
    public String getExpression() {
        return this.deDataQueryCodeExp.expression();
    }

    @Override
    public int getShowOrder() {
        return this.deDataQueryCodeExp.showorder();
    }
}

