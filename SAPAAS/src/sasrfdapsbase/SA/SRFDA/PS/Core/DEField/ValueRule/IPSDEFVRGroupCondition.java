/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.valuerule.IDEFVRGroupCondition
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;
import net.ibizsys.paas.core.valuerule.IDEFVRGroupCondition;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7ec4\u5408\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"GROUP"})
public interface IPSDEFVRGroupCondition
extends IPSDEFVRCondition,
IDEFVRGroupCondition {
    public Iterator<IPSDEFVRCondition> getPSDEFVRConditions();

    public String getCondOp();
}

