/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Editor.IPSTextEditor;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u591a\u884c\u6587\u672c\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"TEXTAREA", "MOBTEXTAREA", "TEXTAREA_10"})
public interface IPSTextArea
extends IPSTextEditor,
IPSNavigateParamContainer {
    public static final String EDITORPARAM_AC = "AC";
    public static final String EDITORPARAM_PICKUPVIEW = "PICKUPVIEW";

    public boolean isEnableAC();

    public IPSDataEntity getPSDataEntity() throws Exception;

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public IPSDEACMode getPSDEACMode() throws Exception;

    public IPSAppDataEntity getPSAppDataEntity() throws Exception;

    public IPSAppDEDataSet getPSAppDEDataSet() throws Exception;

    public IPSAppDEACMode getPSAppDEACMode() throws Exception;

    public boolean isEnablePickupView();

    public IPSAppView getPickupPSAppView() throws Exception;
}

