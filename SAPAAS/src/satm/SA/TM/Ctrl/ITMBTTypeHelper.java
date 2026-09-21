/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTType;
import SA.TM.Ctrl.ITMBTMainTaskInstHelper;
import SA.TM.Ctrl.ITMBTTaskInstHelper;

public interface ITMBTTypeHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBTType var2) throws Exception;

    public String getId();

    public String getName();

    public String getDescription();

    public String getObjectHelper();

    public String getTaskObject();

    public String getTaskObjectParam();

    public ITMBTMainTaskInstHelper CreateBTMainTaskInstHelper() throws Exception;

    public ITMBTTaskInstHelper CreateBTTaskInstHelper() throws Exception;
}

