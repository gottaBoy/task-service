/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(typevalue={"INHERIT"}, title="\u5b9e\u4f53\u7ee7\u627f\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEInheritAction
extends IPSDEAction {
    @Override
    public IPSDEAction getInheritPSDEAction() throws Exception;

    public IPSDERBase getPSDER() throws Exception;
}

