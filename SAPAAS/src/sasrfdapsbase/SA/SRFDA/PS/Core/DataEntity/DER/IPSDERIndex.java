/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndexDEFieldMap;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DERINDEX"})
@PSModelPFIgnoreMeta
public interface IPSDERIndex
extends IPSDERBase {
    public String getTypeValue();

    public Iterator getPropertyMapNames();

    public String getPropertyMap(String var1);

    public Iterator<IPSDERIndexDEFieldMap> getPSDERIndexDEFieldMaps();

    public boolean isVirtual();

    public boolean isInherit();
}

