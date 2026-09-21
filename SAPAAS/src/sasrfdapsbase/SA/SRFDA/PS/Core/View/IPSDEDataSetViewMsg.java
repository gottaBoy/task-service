/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.IDEDataSetViewMsg
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import net.ibizsys.paas.view.IDEDataSetViewMsg;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u96c6\u89c6\u56fe\u6d88\u606f\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEDataSetViewMsg
extends IPSViewMsg,
IDEDataSetViewMsg {
    @Override
    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getTitlePSDEField();

    public IPSDEField getTitleLanResTagPSDEField();

    public IPSDEField getMsgTypePSDEField();

    public IPSDEField getMsgPosPSDEField();

    public IPSDEField getRemoveFlagPSDEField();

    public IPSDEField getContentPSDEField();

    public boolean getDefaultFlag();

    public IPSDEField getOrderValuePSDEField();

    public IPSDELogic getActiveDataPSDELogic();

    public IPSDEField getCacheTagPSDEField();

    public IPSDEField getCacheTag2PSDEField();

    public boolean isEnableCache();

    public String getCacheScope();

    public int getCacheTimeout();

    public IPSDEField getContentTypePSDEField();
}

