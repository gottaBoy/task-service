/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.Control.Calendar.IPSDECalendarItem;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendar;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItemRV;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysLayoutPanel;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Data.PSSysCalendarItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u65e5\u5386\u90e8\u4ef6\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCalendarItem")
public interface IPSSysCalendarItem
extends IPSDECalendarItem {
    public void init(ISRFDAGlobalHelper var1, IPSSysCalendar var2, PSSysCalendarItem var3) throws Exception;

    public IPSSysCalendar getPSSysCalendar();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEAction getCreatePSDEAction();

    public IPSDEOPPriv getCreatePSDEOPPriv();

    public IPSDEAction getUpdatePSDEAction();

    public IPSDEOPPriv getUpdatePSDEOPPriv();

    public IPSDEAction getRemovePSDEAction();

    public IPSDEOPPriv getRemovePSDEOPPriv();

    public IPSDELogic getActiveDataPSDELogic();

    public IPSDEField getIdPSDEField();

    public IPSDEField getTextPSDEField();

    public IPSDEField getIconPSDEField();

    public IPSDEField getContentPSDEField();

    public IPSDEField getBeginTimePSDEField();

    public IPSDEField getEndTimePSDEField();

    public IPSDEField getColorPSDEField();

    public IPSDEField getBKColorPSDEField();

    public IPSDEField getTipsPSDEField();

    public IPSDEField getTagPSDEField();

    public IPSDEField getTag2PSDEField();

    public IPSDEField getLevelPSDEField();

    public IPSDEField getDataPSDEField();

    public IPSDEField getData2PSDEField();

    public Iterator<IPSSysCalendarItemRV> getPSSysCalendarItemRVs();

    public IPSAppDEField getIdPSAppDEField();

    public IPSAppDEField getTextPSAppDEField();

    public IPSAppDEField getIconPSAppDEField();

    public IPSAppDEField getContentPSAppDEField();

    public IPSAppDEField getBeginTimePSAppDEField();

    public IPSAppDEField getEndTimePSAppDEField();

    public IPSAppDEField getColorPSAppDEField();

    public IPSAppDEField getBKColorPSAppDEField();

    public IPSAppDEField getTipsPSAppDEField();

    public IPSAppDEField getTagPSAppDEField();

    public IPSAppDEField getTag2PSAppDEField();

    public IPSAppDEField getLevelPSAppDEField();

    public IPSAppDEDataSet getPSAppDEDataSet();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSPFXCodeObject getRender();

    public IPSSysLayoutPanel getPSSysLayoutPanel();

    public IPSAppDEAction getCreatePSAppDEAction();

    public IPSAppDEAction getUpdatePSAppDEAction();

    public IPSAppDEAction getRemovePSAppDEAction();

    public IPSAppViewUIAction getDefaultPSUIAction();

    public IPSUIAction getPSUIAction();

    public IPSDEField getClsPSDEField();

    public IPSAppDEField getClsPSAppDEField();

    public String getCustomCond();

    public IPSAppDEField getDataPSAppDEField();

    public IPSAppDEField getData2PSAppDEField();

    public IPSDEField getLinkPSDEField();

    public IPSAppDEField getLinkPSAppDEField();
}

