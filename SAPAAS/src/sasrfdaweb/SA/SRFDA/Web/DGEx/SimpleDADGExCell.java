/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext
 *  SA.SRFramework.WebEx.DGEx.UI.DGExCellConfig
 */
package SA.SRFDA.Web.DGEx;

import SA.SRFDA.Web.DGEx.BaseDADGExCell;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext;
import SA.SRFramework.WebEx.DGEx.UI.DGExCellConfig;

public class SimpleDADGExCell
extends BaseDADGExCell {
    @Override
    protected String OnGetCellContent(DGExFetchResultHelperContext context, ISRFDAGlobalHelper iDAGlobalHelper, DataRow dr, DGExCellConfig cellConfig) {
        return "\u6d4b\u8bd5\u4fe1\u606f";
    }
}

