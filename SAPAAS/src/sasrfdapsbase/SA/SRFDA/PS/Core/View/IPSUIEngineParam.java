/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u754c\u9762\u5f15\u64ce\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSAppViewEngineParamImpl")
public interface IPSUIEngineParam
extends IPSModelObject {
    public String getParamType();

    public Object getValue();
}

