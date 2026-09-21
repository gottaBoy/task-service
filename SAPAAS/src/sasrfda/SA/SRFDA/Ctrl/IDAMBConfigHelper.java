/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDAMBConfigHelperContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDAMBConfigHelper {
    public void Init(ISRFDAGlobalHelper var1, String var2, String var3) throws Exception;

    public ISRFDAGlobalHelper getGlobalHelper();

    public String getLanguage();

    public String getPageModel();

    public String GetMBListPanelListConfigId(IDAMBConfigHelperContext var1) throws Exception;

    public String GetMBListConfigId(IDAMBConfigHelperContext var1) throws Exception;
}

