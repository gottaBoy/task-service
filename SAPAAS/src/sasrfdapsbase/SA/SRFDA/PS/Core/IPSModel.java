/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Plugin.IPSModelPlugin;
import SA.SRFDA.PS.Data.PSModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSModel
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSModel var2) throws Exception;

    public Iterator<IPSModelPlugin> getPSModelPlugins(String var1) throws Exception;

    public String getHelpArticleUrl();
}

