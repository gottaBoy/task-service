/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDConfigValueHelper;
import SA.SRFDA.ND.Ctrl.INDObjectHelper;
import SA.SRFDA.ND.Data.NDConfigType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface INDConfigTypeHelper
extends INDObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, NDConfigType var2) throws Exception;

    public INDConfigValueHelper FindDefaultNDConfigValue() throws Exception;

    public INDConfigValueHelper FindNDConfigValue(String var1) throws Exception;

    public String FindNDConfigValue(String var1, String var2) throws Exception;

    public Iterator<INDConfigValueHelper> getNDConfigValues() throws Exception;
}

