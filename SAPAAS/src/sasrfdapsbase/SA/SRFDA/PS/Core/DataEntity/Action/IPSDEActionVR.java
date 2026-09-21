/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEActionVR
extends IPSModelObject {
    public static final String VRTYPE_DEFVALUERULE = "DEFVALUERULE";
    public static final String VRTYPE_SYSVALUERULE = "SYSVALUERULE";

    public IPSDEAction getPSDEAction();

    @Override
    public String getCodeName();

    public int getOrderValue();

    public String getValueRuleType();

    public IPSDEFValueRule getPSDEFValueRule();

    public IPSDEField getPSDEField();
}

