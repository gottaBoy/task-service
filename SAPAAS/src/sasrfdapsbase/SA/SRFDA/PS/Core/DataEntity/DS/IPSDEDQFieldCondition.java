/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u5c5e\u6027\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SINGLE"})
public interface IPSDEDQFieldCondition
extends IPSDEDQCondition {
    public String getPSDEFId();

    @Override
    public String getCondOp();

    public String getPSSysDBVFId();

    public String getPSDBValueOPId();

    public String getPSVARTypeId();

    public String getVARTypeParam();

    public String getCondValue();

    public boolean isIgnoreEmpty();

    public IPSDEField getPSDEField();

    public String getFieldName();

    public String getValueFunc();

    public String getValueFuncTag();

    public String getValueFuncTag2();

    public boolean isIgnoreOthers();
}

