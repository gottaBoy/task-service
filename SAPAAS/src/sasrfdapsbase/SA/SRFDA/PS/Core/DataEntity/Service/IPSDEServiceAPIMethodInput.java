/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodInput;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u8f93\u5165\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEServiceAPIMethodInput
extends IPSDEMethodInput {
    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod();

    public IPSDEMethodDTO getPSDEMethodDTO() throws Exception;

    public IPSDEServiceAPIField getKeyPSDEServiceAPIField();
}

