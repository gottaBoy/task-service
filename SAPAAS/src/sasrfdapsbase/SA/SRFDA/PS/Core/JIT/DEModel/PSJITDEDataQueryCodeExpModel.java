/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataQueryCodeExp
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;

public class PSJITDEDataQueryCodeExpModel
implements IDEDataQueryCodeExp {
    private IPSDEDataQueryCodeExp deDataQueryCodeExp = null;

    public PSJITDEDataQueryCodeExpModel(IPSDEDataQueryCodeExp deDataQueryCodeExp) {
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

