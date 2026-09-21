/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u884c\u4e3a\u6d4b\u8bd5\u7528\u4f8b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEACTION"}, model="PSSysTestCase")
public interface IPSDEActionTestCase
extends IPSSysTestCase,
IPSDataEntityObject {
    public IPSDEAction getPSDEAction();
}

