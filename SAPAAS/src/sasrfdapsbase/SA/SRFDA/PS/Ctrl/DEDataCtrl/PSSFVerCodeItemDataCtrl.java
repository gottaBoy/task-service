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
import SA.SRFDA.PS.Data.PSSFVerCodeItem;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFVerCodeItemDataCtrl
extends PSSFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSSFVerCodeItemDataCtrl.class);

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSSFVerCodeItem psSFVerCodeItem = new PSSFVerCodeItem();
        psSFVerCodeItem.proxy(dataEntity);
        BaseDataEntity psSFVerCode = this.GetRelatedData("DE1551", psSFVerCodeItem.getPSSFVERCODEID(), false);
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1551");
        strRootFolder = iPSTemplDataCtrl.getTemplFolder(psSFVerCode);
        return StringHelper.Format((String)"%1$s%2$sPSSFVERCODEITEM%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)psSFVerCodeItem.getPSSFVERCODEITEMNAME());
    }

    @Override
    protected HashMap<String, String> getCodeTemplMap() throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("TEMPLCODE", "");
        map.put("TEMPLCODE2", "");
        return map;
    }
}

