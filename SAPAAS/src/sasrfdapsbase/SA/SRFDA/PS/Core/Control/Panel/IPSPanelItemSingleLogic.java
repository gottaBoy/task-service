/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u9762\u677f\u9879\u5355\u9879\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SINGLE"})
public interface IPSPanelItemSingleLogic
extends IPSPanelItemLogic {
    public IPSPanelModel getDstPSPanelModel();

    public String getDstModelField();

    public String getCondOp();

    public String getValue();
}

