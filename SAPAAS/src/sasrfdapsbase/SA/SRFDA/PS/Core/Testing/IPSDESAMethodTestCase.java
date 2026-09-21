/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase2;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5\u6d4b\u8bd5\u7528\u4f8b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DESADETAIL"}, model="PSSysTestCase")
public interface IPSDESAMethodTestCase
extends IPSSysTestCase2 {
    public IPSDEServiceAPI getPSDEServiceAPI() throws Exception;

    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod() throws Exception;
}

