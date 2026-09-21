/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DEWFDetail;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEWFDetailHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

public class DEWFDetailHelper
extends BaseDAObjectHelper
implements IDEWFDetailHelper {
    protected DEWFDetail deWFDetail = null;
    protected Properties wfFormMap = new Properties();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, DEWFDetail deWFDetail) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setDEHelper(iDEHelper);
        this.deWFDetail = deWFDetail;
        PropertiesHelper.Load((Properties)this.wfFormMap, (String)this.deWFDetail.getWFFORMPARAM());
        this.OnInit();
    }

    @Override
    public String getWFFormName(String strWFStep) throws Exception {
        String strWFFormName = StringHelper.Format((String)"WFFORM_STEP_%1$s", (Object)strWFStep);
        return PropertiesHelper.GetProperty((Properties)this.wfFormMap, (String)strWFStep, (String)strWFFormName);
    }
}

