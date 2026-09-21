/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Logic;

import SA.SRFDA.PS.Core.Logic.IPSLogicItem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSGroupLogic
extends IPSLogicItem {
    public static final String CONDOP_OR = "OR";
    public static final String CONDOP_AND = "AND";

    public boolean isNotMode();

    public String getCondOp();
}

