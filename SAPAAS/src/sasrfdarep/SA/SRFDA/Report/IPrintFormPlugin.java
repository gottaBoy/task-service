/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PrintForm
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Report;

import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;

public interface IPrintFormPlugin {
    public String Output(SRFDAWebContext var1, PrintForm var2, IDEHelper var3, BaseDataEntity var4);
}

