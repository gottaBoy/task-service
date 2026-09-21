/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEXDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppDataRelationView;
import SA.SRFDA.PS.Core.Control.DataInfoBar.IPSDataInfoBar;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEOPTVIEW", "DEEDITVIEW", "DEEDITVIEW2", "DEEDITVIEW3", "DEEDITVIEW4"})
public interface IPSAppDEEditView
extends IPSAppDEView,
IPSAppDataRelationView,
IPSAppDEXDataView {
    public static final String CONTROL_DATAINFOBAR = "datainfobar";
    public static final int MULTIFORMMODE_NONE = 0;
    public static final int MULTIFORMMODE_DATATYPE = 1;
    public static final int MULTIFORMMODE_MAINSTATE = 2;
    public static final String CONTROL_FORM = "form";
    public static final String VIEWPARAM_UI_SHOWDATAINFOBAR = "UI.SHOWDATAINFOBAR";

    public boolean isShowDataInfoBar();

    public boolean isHideEditForm();

    public int getMultiFormMode();

    public IPSDataInfoBar getPSDataInfoBar();

    public boolean isEnableDirtyChecking();

    public String getMarkOpenDataMode();

    public boolean isManualAppendForms();
}

