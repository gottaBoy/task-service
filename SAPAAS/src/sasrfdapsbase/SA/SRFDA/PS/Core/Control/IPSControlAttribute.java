/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSControlAttributeProxy")
public interface IPSControlAttribute
extends IPSModelObject {
    public String getItemName();

    public String getAttrName();

    public String getAttrValue();
}

