/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMTaskResAEType;
import SA.TM.Ctrl.ITMTaskResArrangeEngine;

public interface ITMTaskResAETypeHelper {
    public void Init(ISRFDAGlobalHelper var1, TMTaskResAEType var2) throws Exception;

    public ITMTaskResArrangeEngine CreateEngine() throws Exception;

    public String getId();

    public String getName();

    public int getVersion();
}

