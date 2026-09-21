/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DERGroup;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDERGroupDetailHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Vector;

public interface IDERGroupHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IDEHelper var2, DERGroup var3) throws Exception;

    public Vector<IDERGroupDetailHelper> getDetails();

    public boolean isIncludeForm();

    public String getDescription();

    public String getFormId();

    public String getFormName();
}

