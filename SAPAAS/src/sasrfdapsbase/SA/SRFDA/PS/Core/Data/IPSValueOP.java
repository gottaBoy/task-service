/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Data;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u503c\u64cd\u4f5c\u7b26\u53f7\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelIgnoreMeta
public interface IPSValueOP
extends IPSObject {
    public String getCaption(boolean var1, String var2);

    public String getSimpleName();
}

