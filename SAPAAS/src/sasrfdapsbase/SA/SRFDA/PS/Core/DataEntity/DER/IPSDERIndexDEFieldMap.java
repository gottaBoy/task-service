/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDERDEFMap")
public interface IPSDERIndexDEFieldMap
extends IPSDERDEFieldMap {
    public IPSDERIndex getPSDERIndex();

    public String getSrcValue();

    public String getSrcValueType();

    public int getSrcValueStdDataType();
}

