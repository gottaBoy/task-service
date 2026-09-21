/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSSDAjaxControl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u7f16\u8f91\u8868\u5355\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEForm")
public interface IPSDEEditForm
extends IPSDEForm,
IPSSDAjaxControl {
    public static final String EVENT_SAVE = "SAVE";
    public static final String EVENT_LOAD = "LOAD";
    public static final String EVENT_REMOVE = "REMOVE";
    public static final String KEYITEM = "srfkey";
    public static final String MAJORITEM = "srfmajortext";
    public static final String ORIKEYITEM = "srforikey";
    public static final String UFITEM = "srfuf";
    public static final String DEITEM = "srfdeid";
    public static final String SOURCEKEYITEM = "srfsourcekey";
    public static final String UPDATEDATE = "srfupdatedate";
    public static final String TEMPMODEITEM = "srftempmode";

    public boolean isShowFormNavBar();

    public boolean isInfoFormMode();

    public boolean isInfoFormConvertPickerToLink();

    public boolean isInfoFormReadOnlyMode();

    public boolean isEnableAutoSave();

    public int getAutoSaveMode();

    @Override
    public IPSControlAction getCreatePSControlAction();

    @Override
    public IPSControlAction getUpdatePSControlAction();

    @Override
    public IPSControlAction getRemovePSControlAction();

    @Override
    public IPSControlAction getGetPSControlAction();

    @Override
    public IPSControlAction getGetDraftPSControlAction();

    @Override
    public IPSControlAction getGetDraftFromPSControlAction();

    public String getDataType();

    public IPSSysCounterRef getPSSysCounterRef();

    public IPSAppCounterRef getPSAppCounterRef();

    public boolean isEnableCustomized();

    public String getNavBarPos();

    public String getNavBarStyle();

    public double getNavBarWidth();

    public double getNavbarHeight();

    public IPSSysCss getNavBarPSSysCss();
}

