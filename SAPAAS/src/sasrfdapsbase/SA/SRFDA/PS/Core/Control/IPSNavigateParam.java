/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u90e8\u4ef6\u5bfc\u822a\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSNavigateParam
extends IPSModelObject {
    public String getKey();

    public String getValue();

    public String getDesc();

    public boolean isRawValue();
}

