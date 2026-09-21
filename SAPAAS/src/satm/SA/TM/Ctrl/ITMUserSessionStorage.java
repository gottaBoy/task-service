/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.ITMMainTaskHelper;
import SA.TM.Ctrl.ITMTaskBaseHelper;

public interface ITMUserSessionStorage {
    public void Init(ISRFDAGlobalHelper var1, String var2) throws Exception;

    public ITMTaskBaseHelper FindTMTask(TMTaskBase var1) throws Exception;

    public ITMTaskBaseHelper FindTMTask(String var1) throws Exception;

    public ITMTaskBaseHelper FindTMTask(String var1, int var2) throws Exception;

    public ITMMainTaskHelper FindTMMainTask(String var1) throws Exception;
}

