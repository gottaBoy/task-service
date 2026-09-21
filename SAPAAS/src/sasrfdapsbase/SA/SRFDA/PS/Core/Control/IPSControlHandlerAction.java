/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u5904\u7406\u5668\u884c\u4e3a\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", implement="PSAjaxControlHandlerActionImpl")
@PSModelRTIgnoreMeta
public interface IPSControlHandlerAction
extends IPSControlAction {
    public static final String ACTIONTYPE_DEACTION = "DEACTION";
    public static final String ACTIONTYPE_DEDATASET = "DEDATASET";
    public static final String ACTIONTYPE_CUSTOM = "CUSTOM";
    public static final String ACTIONTYPE_WFACTION = "WFACTION";
    public static final String ACTIONTYPE_FILTERACTION = "FILTERACTION";

    public String getActionType();

    public IPSDEOPPriv getPSDEOPPriv();

    public IPSDEAction getPSDEAction();

    public String getDEActionName();

    public IPSDataEntity getPSDataEntity();

    public String getDataAccessAction();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDELogic getActiveDataPSDELogic();

    public String getWFActionName();

    @Override
    public String getActionName();

    public String getCustomCond();
}

