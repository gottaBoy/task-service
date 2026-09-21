/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u7ee7\u627f\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DERINHERIT"})
@PSModelPFIgnoreMeta
public interface IPSDERInherit
extends IPSDERBase,
IPSDERIndex {
    public static final int INHERITMODE_STORAGE = 1;
    public static final int INHERITMODE_LOGIC = 2;

    public boolean isSingleInherit();

    public boolean isSameTable();

    public boolean isSameStorage();

    public int getInheritMode();

    public boolean isStorageInherit();

    public boolean isLogicInherit();
}

