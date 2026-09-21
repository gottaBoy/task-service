/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSSFStyleCode;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStyleCodeDataCtrl
extends PSSFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSSFStyleCodeDataCtrl.class);

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSSFStyleCode psSFStyleCode = new PSSFStyleCode();
        psSFStyleCode.proxy(dataEntity);
        BaseDataEntity psSFStyle = this.GetRelatedData("DE1513", psSFStyleCode.getPSSFSTYLEID(), false);
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1513");
        strRootFolder = iPSTemplDataCtrl.getTemplFolder(psSFStyle);
        return StringHelper.Format((String)"%1$s%2$sPSSFSTYLECODE%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)psSFStyleCode.getPSSFSTYLECODENAME());
    }

    @Override
    protected HashMap<String, String> getCodeTemplMap() throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("STYLECODE", "");
        return map;
    }
}

