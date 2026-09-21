/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u9762\u677f\u9879\u7ec4\u5408\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"GROUP"})
public interface IPSPanelItemGroupLogic
extends IPSPanelItemLogic {
    public String getGroupOP();

    public boolean isNotMode();

    public Iterator<IPSPanelItemLogic> getPSPanelItemLogics();
}

