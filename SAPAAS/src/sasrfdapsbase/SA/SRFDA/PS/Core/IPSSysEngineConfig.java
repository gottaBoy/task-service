/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Data.PSSysEngineCfg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSysEngineConfig
extends IPSModelObject {
    public static final int IMPDEFRULE_1 = 1;
    public static final int VIEWUAREGMODE_ALWAYS = 0;
    public static final int VIEWUAREGMODE_VALID = 1;
    public static final int VIEWCTRLAJAXRECVRANGE_ALL = 0;
    public static final int VIEWCTRLAJAXRECVRANGE_VIEWUAONLY = 1;

    public void init(ISRFDAGlobalHelper var1, PSSysEngineCfg var2) throws Exception;

    public int getImpDEFRule();

    public int getViewUARegMode();

    public int getViewCtrlAjaxRecvRange();

    public boolean isViewCtrlHandlerFirst();
}

