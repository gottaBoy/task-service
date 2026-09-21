/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.view.IStaticViewMsg
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSViewMsg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.view.IStaticViewMsg;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u89c6\u56fe\u6d88\u606f\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSViewMsg")
public interface IPSViewMsg
extends IPSSystemObject,
IStaticViewMsg {
    public static final String MSGPOS_TOP = "TOP";
    public static final String MSGPOS_BOTTOM = "BOTTOM";
    public static final String MSGPOS_POPUP = "POPUP";
    public static final String MSGTYPE_INFO = "INFO";
    public static final String MSGTYPE_WARN = "WARN";
    public static final String MSGTYPE_ERROR = "ERROR";
    public static final Integer DYNAMICMODE_STATIC = 0;
    public static final Integer DYNAMICMODE_DEDATASET = 1;
    public static final Integer REMOVEMODE_NONE = 0;
    public static final Integer REMOVEMODE_ALWAYS = 1;
    public static final Integer REMOVEMODE_ONCE = 2;
    public static final String ENABLEMODE_ALL = "ALL";
    public static final String ENABLEMODE_DEOPPRIV = "DEOPPRIV";
    public static final String ENABLEMODE_DELOGIC = "DELOGIC";
    public static final String ENABLEMODE_SCRIPT = "SCRIPT";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSViewMsg var3) throws Exception;

    public String getTitle();

    @Override
    public String getCodeName();

    public int getDynamicMode();

    public IPSSysMsgTempl getPSSysMsgTempl();

    public IPSLanguageRes getTitlePSLanguageRes();

    public IPSSystemModule getPSSystemModule();

    public int getRemoveMode();

    public String getTitleLanResTag();

    public String getMsgTemplateId();

    public String getPosition();

    public String getMessage();

    public String getMessageType();

    public boolean isEnableRemove();

    public IPSLanguageRes getContentPSLanguageRes();

    public String getUniqueTag();

    public String getEnableMode();

    public IPSDataEntity getPSDataEntity();

    public IPSDELogic getTestPSDELogic();

    public IPSDEOPPriv getTestPSDEOPPriv();

    public String getTestScriptCode();

    public String getPSLayoutPanelId();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public String getContentType();
}

