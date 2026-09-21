/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataExport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataImport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEPrint;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEUIAction")
public interface IPSAppDEUIAction
extends IPSDEUIAction,
IPSAppUIAction,
IPSModelSortable {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, IPSAppDataEntity var3, PSDEUIAction var4) throws Exception;

    @Override
    public IPSAppDEMethod getPSAppDEMethod();

    @Override
    public IPSAppView getFrontPSAppView() throws Exception;

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppUILogic getPSAppUILogic() throws Exception;

    public IPSAppDEUILogic getPSAppDEUILogic() throws Exception;

    public int getAppNoPrivDisplayMode();

    public IPSAppDEPrint getPSAppDEPrint() throws Exception;

    public IPSAppDEDataImport getPSAppDEDataImport() throws Exception;

    public IPSAppDEDataExport getPSAppDEDataExport() throws Exception;

    public IPSAppDEACMode getPSAppDEACMode() throws Exception;

    public IPSDEEditForm getPSDEEditForm() throws Exception;
}

