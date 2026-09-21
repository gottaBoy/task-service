/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp
 *  net.ibizsys.paas.core.IDEDataQueryCodeExp
 */
package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;

public class DynaDEDataQueryCodeExpModel
implements IDEDataQueryCodeExp {
    private IPSDEDataQueryCodeExp deDataQueryCodeExp = null;

    public DynaDEDataQueryCodeExpModel(IPSDEDataQueryCodeExp deDataQueryCodeExp) {
        this.deDataQueryCodeExp = deDataQueryCodeExp;
    }

    public String getId() {
        return this.deDataQueryCodeExp.getId();
    }

    public String getName() {
        return this.deDataQueryCodeExp.getName();
    }

    public String getExpression() {
        return this.deDataQueryCodeExp.getExpression();
    }

    public int getShowOrder() {
        return 0;
    }
}

