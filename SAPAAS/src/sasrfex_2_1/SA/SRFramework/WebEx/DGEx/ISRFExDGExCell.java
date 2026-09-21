/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 */
package SA.SRFramework.WebEx.DGEx;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext;
import SA.SRFramework.WebEx.DGEx.UI.DGExCellConfig;

public interface ISRFExDGExCell {
    public String GetCellContent(DGExFetchResultHelperContext var1, DataRow var2, DGExCellConfig var3);
}

