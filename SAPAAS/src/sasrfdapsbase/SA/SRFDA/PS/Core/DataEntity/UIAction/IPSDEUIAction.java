/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEUIAction
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEUIAction;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEUIAction")
public interface IPSDEUIAction
extends IPSDataEntityObject,
IPSUIAction,
IDEUIAction {
    public static final String UIACTIONTYPE_DEUIACTION = "DEUIACTION";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, IPSDataEntity var3, PSDEUIAction var4) throws Exception;

    public String getPSSysDEUIActionId(Object var1) throws Exception;

    public IPSDEAction getPSDEAction();

    public String getFrontPSDEViewId(Object var1);

    public String getFrontPSDEViewId();

    public String getFrontMobPSDEViewId();

    @Override
    public IPSAppView getFrontPSAppView(Object var1) throws Exception;

    @Override
    public int getExtendMode();

    public String getFrontPSSysPDTViewId();

    public boolean isFrontPDTView();

    public IPSAppDEMethod getPSAppDEMethod();

    public boolean isSaveTargetFirst();

    public String getReplacePSSysUIActionId();

    public IPSDEOPPriv getPSDEOPPriv();

    public boolean isAsyncAction();

    public String getPSDEEditFormId();

    public String getMobPSDEEditFormId();
}

