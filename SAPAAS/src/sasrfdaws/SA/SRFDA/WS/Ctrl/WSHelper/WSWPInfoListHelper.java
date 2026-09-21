/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.WS.Ctrl.Data.WSWPInfoList;
import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSWebPartHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WSWPInfoListHelper
extends BaseWSWebPartHelper {
    Log log = LogFactory.getLog(WSWPInfoListHelper.class);
    WSWPInfoList wsWPInfoList = null;

    @Override
    protected void OnFillIndexDataEntity(DataRow dr) throws Exception {
        this.wsWPInfoList = new WSWPInfoList();
        this.wsWPInfoList.FromDataRow(dr);
    }

    public WSWPInfoList getWSWPInfoList() {
        return this.wsWPInfoList;
    }

    @Override
    protected boolean IsPreProcess() {
        return false;
    }

    @Override
    protected String OnGetPublishedModel() throws Exception {
        String strPageId = this.iWSWebpartPublishContext.getWSPageHelper().getPageId();
        return StringHelper.Format((String)"<%%=%1$s.RenderInfoList(\"%2$s\",\"%3$s\",\"%4$s\",\"%5$s\",\"%6$s\")%%>", (Object)strPageId, (Object)this.iWSWebpartPublishContext.getWSPageHelper().getWSWebSiteHelper().getWSWebSite().getWSWEBSITEID(), (Object)this.iWSWebpartPublishContext.getWSPageHelper().getWSPage().getWSPAGEID(), (Object)this.iWSWBType.getWSWBType().getWSWBTYPEID(), (Object)this.getWSWebPart().getWSWEBPARTID(), (Object)this.iWSWebpartPublishContext.getWSpageWb().getWSPAGEWBID());
    }

    @Override
    protected void FillPageWebPartModelContext(Map<String, Object> pageWebPartModellMap) {
    }
}

