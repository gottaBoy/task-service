/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTConfigValueHelper;
import SA.WT.Ctrl.IWTObjectHelper;
import SA.WT.Data.WTConfigType;
import java.util.Iterator;

public interface IWTConfigTypeHelper
extends IWTObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, WTConfigType var2) throws Exception;

    public IWTConfigValueHelper FindDefaultWTConfigValue() throws Exception;

    public IWTConfigValueHelper FindWTConfigValue(String var1) throws Exception;

    public Iterator<IWTConfigValueHelper> getWTConfigValues() throws Exception;
}

