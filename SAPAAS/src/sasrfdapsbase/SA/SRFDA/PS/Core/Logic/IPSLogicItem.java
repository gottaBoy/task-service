/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Logic;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSLogicItem
extends IPSModelObject {
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";

    public String getLogicType();
}

