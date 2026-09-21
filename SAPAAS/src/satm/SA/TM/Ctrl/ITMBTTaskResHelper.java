/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTTaskRes;

public interface ITMBTTaskResHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBTTaskRes var2) throws Exception;

    public String getId();

    public String getName();

    public TMBTTaskRes getData();

    public boolean isCustomDuration();

    public int getDuration();

    public String getResCatalogId();
}

