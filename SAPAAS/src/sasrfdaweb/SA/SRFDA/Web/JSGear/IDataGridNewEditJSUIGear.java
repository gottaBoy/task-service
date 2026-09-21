/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.UIGear.IUIGear
 *  SA.SRFramework.WebEx.SRFExDataGrid
 */
package SA.SRFDA.Web.JSGear;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.UIGear.IUIGear;
import SA.SRFramework.WebEx.SRFExDataGrid;

public interface IDataGridNewEditJSUIGear
extends IUIGear {
    public boolean Load(SRFDAPage var1, SRFExDataGrid var2, boolean var3, boolean var4, boolean var5);

    public boolean Load(SRFDAPage var1, SRFExDataGrid var2, boolean var3, boolean var4, boolean var5, boolean var6);

    public boolean Load(SRFDAPage var1, SRFExDataGrid var2);
}

