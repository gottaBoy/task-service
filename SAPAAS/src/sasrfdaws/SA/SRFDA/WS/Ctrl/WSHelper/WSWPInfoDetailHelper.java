/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSWebPartHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import java.util.Map;

public class WSWPInfoDetailHelper
extends BaseWSWebPartHelper {
    @Override
    protected boolean IsPreProcess() {
        return false;
    }

    @Override
    protected String OnGetPublishedModel() throws Exception {
        String strPageId = this.iWSWebpartPublishContext.getWSPageHelper().getPageId();
        return StringHelper.Format((String)"<%%=%1$s.RenderDetail(\"%2$s\",\"%3$s\",\"%4$s\",\"%5$s\",\"%6$s\")%%>", (Object)strPageId, (Object)this.iWSWebpartPublishContext.getWSPageHelper().getWSWebSiteHelper().getWSWebSite().getWSWEBSITEID(), (Object)this.iWSWebpartPublishContext.getWSPageHelper().getWSPage().getWSPAGEID(), (Object)this.iWSWBType.getWSWBType().getWSWBTYPEID(), (Object)this.getWSWebPart().getWSWEBPARTID(), (Object)this.iWSWebpartPublishContext.getWSpageWb().getWSPAGEWBID());
    }

    @Override
    protected void FillPageWebPartModelContext(Map<String, Object> pageWebPartModellMap) {
    }

    @Override
    protected void OnFillIndexDataEntity(DataRow dr) throws Exception {
    }
}

