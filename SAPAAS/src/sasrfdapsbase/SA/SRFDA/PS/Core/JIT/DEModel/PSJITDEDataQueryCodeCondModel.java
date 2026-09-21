/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeCond;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;

public class PSJITDEDataQueryCodeCondModel
implements IDEDataQueryCodeCond {
    private IPSDEDataQueryCodeCond deDataQueryCodeCond = null;

    public PSJITDEDataQueryCodeCondModel(IPSDEDataQueryCodeCond deDataQueryCodeCond) {
        this.deDataQueryCodeCond = deDataQueryCodeCond;
    }

    public String getId() {
        return this.deDataQueryCodeCond.getId();
    }

    public String getName() {
        return this.deDataQueryCodeCond.getName();
    }

    public String getDEFName() {
        return null;
    }

    public String getCondType() {
        return "CUSTOM";
    }

    public String getCondOp() {
        return null;
    }

    public String getCondValue() {
        return null;
    }

    public String getCustomCond() {
        return this.deDataQueryCodeCond.getCustomCond();
    }

    public String getPredefindedCond() {
        return null;
    }

    public String getPredefinedCode() {
        return null;
    }

    public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
        return null;
    }

    public String getDEFieldExp() {
        return null;
    }

    public boolean isNotMode() {
        return false;
    }

    public int getStdDataType() {
        return 0;
    }

    public String getValueFunc() {
        return null;
    }
}

