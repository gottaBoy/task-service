/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPageHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, Page var2) throws Exception;

    public Page getData();

    public String getPagePath();

    public String getWindowStyle();

    public int getWidth();

    public int getHeight();

    public boolean isModalStyle();

    public String getDescription();

    public String getWTParam();

    public String getPageTemplId();

    public String getPageTemplName();

    public String getToolbar();

    public String getDEId();

    public String getDEName();

    public String getPageObject();

    public String getUserMode();

    public String getAppendParam();

    public String getResourceId();

    public String getResourceId(String var1) throws Exception;

    public String getResType();

    public String getResDataAction();

    public String getPageHeader();

    public String getPageScript();

    public int getPageFunc();

    public boolean isEnableAdvPageParam();

    public String getPageFuncType();

    public String getToolbarId();

    public String getToolbarName();

    public String getSLUIPart();

    public String getPageHelper();

    public String getFullPagePath();

    public String getPageParam(String var1, String var2);

    public boolean getPageParam(String var1, boolean var2);

    public int getPageParam(String var1, int var2);
}

