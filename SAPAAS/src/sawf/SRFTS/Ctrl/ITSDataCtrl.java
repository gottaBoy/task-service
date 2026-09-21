/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  javax.servlet.ServletContext
 */
package SRFTS.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SRFTS.Ctrl.Data.TSSchedule;
import SRFTS.Ctrl.Data.TSTaskItem;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;

public interface ITSDataCtrl {
    public boolean Init(ServletContext var1, BaseDBCallerHelperEx var2);

    public boolean Init(ISRFExGlobalHelper var1, BaseDBCallerHelperEx var2);

    public CallResult GetSchedule(String var1, Date var2, Date var3, ArrayList<TSSchedule> var4);

    public CallResult GetTaskItems(Date var1, Date var2, ArrayList<TSTaskItem> var3);

    public CallResult PrepareRunTaskItem(TSTaskItem var1);

    public CallResult StartRunTaskItem(TSTaskItem var1);

    public CallResult FinishRunTaskItem(TSTaskItem var1, CallResult var2);

    public CallResult AddTaskItem(TSTaskItem var1, String var2);
}

