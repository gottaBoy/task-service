/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMConfigTypeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IIMModelStorage {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public IIMConfigTypeHelper FindIMConfigType(String var1) throws Exception;
}

