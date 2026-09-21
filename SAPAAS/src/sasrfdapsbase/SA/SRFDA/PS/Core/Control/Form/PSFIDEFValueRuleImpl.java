/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.valuerule.IDEFValueRule
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSFIDEFValueRule;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;

@PSModelIgnoreMeta
public class PSFIDEFValueRuleImpl
extends PSObjectImpl
implements IPSFIDEFValueRule {
    protected IDEFValueRule iDEFValueRule = null;

    public String getDEFVRName() {
        return this.getDEFValueRule().getName();
    }

    public String getDEFVRId() {
        return this.getDEFValueRule().getId();
    }

    public IDEFValueRule getDEFValueRule() {
        return this.iDEFValueRule;
    }

    protected void setDEFValueRule(IDEFValueRule iDEFValueRule) {
        this.iDEFValueRule = iDEFValueRule;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

