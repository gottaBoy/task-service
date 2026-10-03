/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSSFVerCode;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFVerCodeDataCtrl
extends PSSFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSSFVerCodeDataCtrl.class);

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSSFVerCode psSFVerCode = new PSSFVerCode();
        psSFVerCode.proxy(dataEntity);
        BaseDataEntity psSFStyleVer = this.GetRelatedData("DE1550", psSFVerCode.getPSSFSTYLEVERID(), false);
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1550");
        strRootFolder = iPSTemplDataCtrl.getTemplFolder(psSFStyleVer);
        return StringHelper.Format((String)"%1$s%2$sPSSFVERCODE%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)psSFVerCode.getTYPECODE());
    }

    @Override
    protected HashMap<String, String> getCodeTemplMap() throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("CODETEMPL", "");
        map.put("TEMPLCODE2", "");
        return map;
    }

    @Override
    protected void onExportTempl(BaseDataEntity dataEntity) throws Exception {
        super.onExportTempl(dataEntity);
        String strPSSFVerCodeId = dataEntity.getParamStringValue("PSSFVERCODEID", "");
        IDEDataCtrl iPSSFVerCodeItemDataCtrl = this.GetRelatedDataCtrl("DE1552");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSFVERCODEID", (Object)strPSSFVerCodeId);
        Vector<BaseDataEntity> psSFVerCodeItemList = new Vector<BaseDataEntity>();
        iPSSFVerCodeItemDataCtrl.Select(cond, psSFVerCodeItemList);
        for (BaseDataEntity baseDataEntity : psSFVerCodeItemList) {
            iPSSFVerCodeItemDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
    }
}
