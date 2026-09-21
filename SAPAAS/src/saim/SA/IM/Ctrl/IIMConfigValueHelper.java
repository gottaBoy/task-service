/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMConfigValue;
import SA.IM.Ctrl.IIMConfigTypeHelper;
import SA.IM.Ctrl.IIMObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IIMConfigValueHelper
extends IIMObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IIMConfigTypeHelper var2, IMConfigValue var3) throws Exception;

    public String getConfigValue();
}

