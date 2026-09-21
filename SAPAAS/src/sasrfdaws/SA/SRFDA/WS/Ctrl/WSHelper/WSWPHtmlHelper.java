/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.WS.Ctrl.Data.WSWPHtml;
import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSWebPartHelper;
import SA.SRFramework.Data.DataRow;
import java.util.Map;

public class WSWPHtmlHelper
extends BaseWSWebPartHelper {
    WSWPHtml wsWPHtml = null;

    @Override
    protected void FillPageWebPartModelContext(Map<String, Object> pageWebPartModellMap) {
    }

    @Override
    protected void OnFillIndexDataEntity(DataRow dr) throws Exception {
        this.wsWPHtml = new WSWPHtml();
        this.wsWPHtml.FromDataRow(dr);
    }
}

