/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.CodeList;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u4ee3\u7801\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSCodeList")
public interface IPSAppCodeList
extends IPSApplicationObject,
IPSCodeList,
IPSModelSortable {
    public IPSCodeList getPSCodeList();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEDataSet getPSAppDEDataSet();

    public IPSAppDEField getTextPSAppDEField() throws Exception;

    public IPSAppDEField getValuePSAppDEField() throws Exception;

    public IPSAppDEField getMinorSortPSAppDEField() throws Exception;

    public IPSAppDEField getIconClsPSAppDEField() throws Exception;

    public IPSAppDEField getIconClsXPSAppDEField() throws Exception;

    public IPSAppDEField getIconPathPSAppDEField() throws Exception;

    public IPSAppDEField getIconPathXPSAppDEField() throws Exception;

    public IPSAppDEField getPValuePSAppDEField() throws Exception;

    public IPSAppDEField getDisablePSAppDEField() throws Exception;

    public IPSAppDEField getDataPSAppDEField() throws Exception;

    public IPSAppDEField getBeginValuePSAppDEField() throws Exception;

    public IPSAppDEField getEndValuePSAppDEField() throws Exception;

    public IPSAppDEField getClsPSAppDEField() throws Exception;

    public IPSAppDEField getColorPSAppDEField() throws Exception;

    public IPSAppDEField getBKColorPSAppDEField() throws Exception;
}

