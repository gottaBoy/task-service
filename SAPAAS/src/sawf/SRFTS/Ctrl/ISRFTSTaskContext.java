/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 */
package SRFTS.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SRFTS.Ctrl.Data.TSTaskItem;
import SRFTS.Ctrl.ISRFTSEngine;

public interface ISRFTSTaskContext {
    public BaseDBCallerHelperEx getDBCallerHelper();

    public TSTaskItem getTaskItem();

    public Object getAttribute(String var1);

    public ContextHelper getContextHelper();

    public ISRFExGlobalHelper getGlobalHelper();

    public ISRFTSEngine getTSEngine();
}

