/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDEWFHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IDEHelper var2, DEWF var3) throws Exception;

    public DEWF getData();

    public IDEFHelper getWFStateField() throws Exception;

    public IDEFHelper getWFStepField() throws Exception;

    public IDEFHelper getStateField() throws Exception;

    public boolean isWFStepEditable(String var1);

    public String getWFMSCodeListId();

    public String getWFId();

    public String getStartActionFormId();

    public String getStartActionPageId();
}

