/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsg;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.View.IPSDEDataSetViewMsg;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u89c6\u56fe\u6d88\u606f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"1"})
public interface IPSAppDEDataSetViewMsg
extends IPSAppViewMsg,
IPSDEDataSetViewMsg {
    @Override
    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEDataSet getPSAppDEDataSet();

    public IPSAppDEField getTitlePSAppDEField();

    public IPSAppDEField getTitleLanResTagPSAppDEField();

    public IPSAppDEField getMsgTypePSAppDEField();

    public IPSAppDEField getMsgPosPSAppDEField();

    public IPSAppDEField getRemoveFlagPSAppDEField();

    public IPSAppDEField getContentPSAppDEField();

    public IPSAppDEField getContentTypePSAppDEField();

    public IPSAppDEField getOrderValuePSAppDEField();

    @Override
    public IPSDELogic getActiveDataPSDELogic();

    public IPSAppDEField getCacheTagPSAppDEField();

    public IPSAppDEField getCacheTag2PSAppDEField();

    @Override
    public boolean isEnableCache();

    @Override
    public String getCacheScope();

    @Override
    public int getCacheTimeout();
}

