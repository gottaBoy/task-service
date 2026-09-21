/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SRFWF.Client.WFGetIAActionsResult
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SRFWF.Client.WFGetIAActionsResult;

public interface IToolbarItemWriterContext {
    public String getViewStyle();

    public boolean TestCondition(String var1);

    public IDEHelper getDEHelper();

    public Page getPage();

    public WFGetIAActionsResult getWFGetIAActionsResult();

    public String getPageModel();

    public String getLanguage();

    public ISRFDAGlobalHelper getDAGlobalHelper();

    public boolean getSimpleMode();

    public String FindDEBHGroup(String var1);

    public String getDEObjectName();

    public Object getAttribute(String var1);

    public void setAttribute(String var1, Object var2);
}

