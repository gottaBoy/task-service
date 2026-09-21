/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemGroupLogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u9762\u677f\u9879\u5206\u7c7b\u7ec4\u5408\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSPanelItemCatGroupLogic
extends IPSPanelItemGroupLogic {
    @Override
    public String getLogicCat();

    public Iterator<String> getRelatedItemNames();
}

