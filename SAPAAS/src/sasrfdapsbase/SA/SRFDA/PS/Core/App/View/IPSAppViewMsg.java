/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.Msg.IPSAppMsgTempl;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSViewMsg;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u6d88\u606f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="dynamicMode", implement="PSAppViewMsgImpl", stringtype=false, model="PSViewMsg")
public interface IPSAppViewMsg
extends IPSViewMsg,
IPSApplicationObject,
IPSModelSortable {
    public IPSViewMsg getPSViewMsg();

    @Override
    public IPSSysMsgTempl getPSSysMsgTempl();

    @Override
    public String getTitle();

    @Override
    public String getCodeName();

    @Override
    public int getDynamicMode();

    @Override
    public IPSLanguageRes getTitlePSLanguageRes();

    @Override
    public int getRemoveMode();

    @Override
    public String getTitleLanResTag();

    @Override
    public String getPosition();

    @Override
    public String getMessage();

    @Override
    public String getMessageType();

    @Override
    public boolean isEnableRemove();

    public IPSAppMsgTempl getPSAppMsgTempl();

    public String getDataAccessAction();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSLayoutPanel getPSLayoutPanel();

    public IPSAppDELogic getTestPSAppDELogic();

    @Override
    public String getEnableMode();

    @Override
    public IPSDEOPPriv getTestPSDEOPPriv();

    @Override
    public String getTestScriptCode();

    @Override
    public IPSSysImage getPSSysImage();

    @Override
    public IPSSysCss getPSSysCss();
}

