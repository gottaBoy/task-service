/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5e94\u7528\u89c6\u56fe\u65b0\u5efa\u6570\u636e\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"APP_NEWDATA"})
public interface IPSAppUINewDataLogic
extends IPSAppUILogic {
    public static final String LOGICTYPE_NEWDATA = "APP_NEWDATA";
    public static final String ACTIONAFTERWIZARD_DEFAULT = "DEFAULT";
    public static final String ACTIONAFTERWIZARD_NONE = "NONE";
    public static final String ACTIONAFTERWIZARD_OPENDATA = "OPENDATA";

    public boolean isEnableBatchAdd();

    public boolean isEnableWizardAdd();

    public boolean isBatchAddOnly();

    public String getActionAfterWizard();

    public IPSAppUILogicRefView getWizardPSAppView();

    public IPSAppUILogicRefView getNewDataPSAppView();

    public Iterator<IPSAppUILogicRefView> getNewDataPSAppViews();

    public Iterator<IPSAppUILogicRefView> getBatchAddPSAppViews();

    @Override
    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEAction getBatchAddPSAppDEAction();
}

