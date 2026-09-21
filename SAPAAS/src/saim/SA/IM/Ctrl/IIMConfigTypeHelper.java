/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMConfigType;
import SA.IM.Ctrl.IIMConfigValueHelper;
import SA.IM.Ctrl.IIMObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IIMConfigTypeHelper
extends IIMObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IMConfigType var2) throws Exception;

    public IIMConfigValueHelper FindDefaultIMConfigValue() throws Exception;

    public IIMConfigValueHelper FindIMConfigValue(String var1) throws Exception;

    public Iterator<IIMConfigValueHelper> getIMConfigValues() throws Exception;
}

