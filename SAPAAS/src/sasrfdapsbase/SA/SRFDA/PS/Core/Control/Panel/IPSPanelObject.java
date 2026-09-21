/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u9762\u677f\u76f8\u5173\u5bf9\u8c61\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3")
public interface IPSPanelObject
extends IPSModelObject {
    public IPSPanel getPSPanel();
}

