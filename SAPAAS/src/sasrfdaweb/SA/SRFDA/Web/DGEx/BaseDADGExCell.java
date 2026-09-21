/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext
 *  SA.SRFramework.WebEx.DGEx.ISRFExDGExCell
 *  SA.SRFramework.WebEx.DGEx.UI.DGExCellConfig
 */
package SA.SRFDA.Web.DGEx;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext;
import SA.SRFramework.WebEx.DGEx.ISRFExDGExCell;
import SA.SRFramework.WebEx.DGEx.UI.DGExCellConfig;

public abstract class BaseDADGExCell
implements ISRFExDGExCell {
    public String GetCellContent(DGExFetchResultHelperContext context, DataRow dr, DGExCellConfig cellConfig) {
        ISRFDAGlobalHelper iDAGlobalHelper = (ISRFDAGlobalHelper)context.getWebContext().getGlobalHelper();
        return this.OnGetCellContent(context, iDAGlobalHelper, dr, cellConfig);
    }

    protected abstract String OnGetCellContent(DGExFetchResultHelperContext var1, ISRFDAGlobalHelper var2, DataRow var3, DGExCellConfig var4);
}

