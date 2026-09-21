/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDESubWFHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IDEHelper var2, DESubWF var3) throws Exception;

    public DESubWF getData();

    public boolean isWFStepEditable(String var1);

    public IDEFHelper getWFStepField() throws Exception;

    public String getDESubWFSN();

    public String getWFId();

    public String getWFFormName(String var1, String var2, String var3) throws Exception;
}

