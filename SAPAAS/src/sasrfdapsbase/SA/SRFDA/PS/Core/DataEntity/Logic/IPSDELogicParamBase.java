/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u903b\u8f91\u53c2\u6570\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSDELogicParamBase
extends IPSModelObject {
    @Override
    public String getCodeName();

    public boolean isDefault();
}

