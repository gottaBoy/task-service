/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.WS.Ctrl.Data.WSWPPic;
import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSWebPartHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import java.util.Map;

public class WSWPPicHelper
extends BaseWSWebPartHelper {
    WSWPPic wsWPPic = null;

    @Override
    protected void OnFillIndexDataEntity(DataRow dr) throws Exception {
        this.wsWPPic = new WSWPPic();
        this.wsWPPic.FromDataRow(dr);
    }

    @Override
    protected void FillPageWebPartModelContext(Map<String, Object> pageWebPartModellMap) {
        pageWebPartModellMap.put("IMGURL", this.wsWPPic.getIMGURL());
        pageWebPartModellMap.put("IMGSRC", this.OnGetRealFileUrl(this.wsWPPic.getIMGURL()));
    }

    protected String OnGetRealFileUrl(String strFileId) {
        return StringHelper.Format((String)"../srfpage/exportfile.jsp?FILEID=%1$s", (Object)strFileId);
    }
}

