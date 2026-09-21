/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMResBT;

public interface ITMResBTHelper {
    public void Init(ISRFDAGlobalHelper var1, TMResBT var2) throws Exception;

    public String getId();

    public String getName();

    public boolean isEnableUserCreate();

    public String getBKTheme();
}

