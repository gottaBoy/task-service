/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSPanelItemLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u9762\u677f\u9879\u903b\u8f91\u9879\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", typefield="logicType", model="PSPanelItemLogic")
public interface IPSPanelItemLogic
extends IPSModelObject {
    public static final String LOGICCAT_PANELVISIBLE = "PANELVISIBLE";
    public static final String LOGICCAT_ITEMENABLE = "ITEMENABLE";
    public static final String LOGICCAT_ITEMBLANK = "ITEMBLANK";
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";

    public void init(ISRFDAGlobalHelper var1, IPSPanelItem var2, IPSPanelItemLogic var3, PSPanelItemLogic var4) throws Exception;

    public IPSPanelItem getPSPanelItem();

    public String getLogicCat();

    public String getLogicType();
}

