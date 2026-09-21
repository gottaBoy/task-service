/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFTemplDataCtrlBase;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFDataCtrl
extends PSSFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSSFDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSSFId = dataEntity.getParamStringValue("PSSFID", "");
        this.getPSModelStorage().resetPSSF(strPSSFId);
        IPSSF iPSSF = this.getPSModelStorage().getPSSF(strPSSFId);
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = this.getRootFolder();
        return StringHelper.format((String)"%1$s%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)dataEntity.getParamStringValue("PSSFID", ""));
    }

    @Override
    protected void onExportTempl(BaseDataEntity dataEntity) throws Exception {
        super.onExportTempl(dataEntity);
        String strPSSFId = dataEntity.getParamStringValue("PSSFID", "");
        IDEDataCtrl iPSSFStyleDataCtrl = this.GetRelatedDataCtrl("DE1513");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSFID", (Object)strPSSFId);
        Vector psPFStyleList = new Vector();
        iPSSFStyleDataCtrl.Select(cond, psPFStyleList);
        for (BaseDataEntity baseDataEntity : psPFStyleList) {
            iPSSFStyleDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
    }
}

