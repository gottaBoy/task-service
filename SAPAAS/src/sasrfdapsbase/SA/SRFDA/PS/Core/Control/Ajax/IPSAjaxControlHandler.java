/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControlHandler;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.SF.IPSSFACHandler;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u754c\u9762\u90e8\u4ef6\u5904\u7406\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSAjaxControlHandler
extends IPSControlHandler,
IPSAjaxHandler {
    public static final String ACTION_USER = "user";
    public static final String ACTION_USER2 = "user2";
    public static final int CACHESCOPE_NONE = 0;
    public static final int CACHESCOPE_GLOBAL = 1;
    public static final int CACHESCOPE_ORG = 2;
    public static final int CACHESCOPE_USER = 3;
    public static final int CACHESCOPE_APP = 4;

    public void init(ISRFDAGlobalHelper var1, IPSAppView var2, IPSAjaxControl var3, PSACHandler var4) throws Exception;

    public boolean isEnableDEFieldPrivilege();

    public boolean isEnableAjaxAction(String var1);

    public String getDEActionName(String var1);

    public String getDataAccessAction(String var1);

    public Iterator<String> getAjaxActions();

    @Override
    public int getTempMode();

    public IPSSFACHandler getPSSFACHandler();

    public boolean isEnableCache();

    public int getCacheTimeout();

    public int getCacheScope();

    public IPSSysUniState getPSSysUniState();

    public String getUniStateKeyValue();

    public String getUniStateField();

    public IPSAjaxControl getPSAjaxControl();

    public IPSDataEntity getPSDataEntity();

    public IPSDataEntity getGroupPSDataEntity();
}

