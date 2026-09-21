/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="Flex\u5e03\u5c40\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"FLEX"})
public interface IPSFlexLayout
extends IPSLayout {
    public String getDir();

    public String getAlign();

    public String getVAlign();
}

