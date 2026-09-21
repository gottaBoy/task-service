/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5e94\u7528\u89c6\u56fe\u6253\u5f00\u6570\u636e\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"APP_OPENDATA"})
public interface IPSAppUIOpenDataLogic
extends IPSAppUILogic {
    public static final String LOGICTYPE_EDITDATA = "APP_EDITDATA";
    public static final String LOGICTYPE_OPENDATA = "APP_OPENDATA";

    public IPSAppUILogicRefView getOpenDataPSAppView();

    public Iterator<IPSAppUILogicRefView> getOpenDataPSAppViews();

    public boolean isEditMode();
}

