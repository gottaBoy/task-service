/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.SF.IPSSFPluginTempl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFTemplDataCtrlBase;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFPluginTemplDataCtrl
extends PSSFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSSFPluginTemplDataCtrl.class);

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
        String strPSSFPluginTemplId = dataEntity.getParamStringValue("PSSFPLUGINTEMPLID", "");
        this.getPSModelStorage().resetPSSFPluginTempl(strPSSFPluginTemplId);
        IPSSFPluginTempl iPSSFPluginTempl = this.getPSModelStorage().getPSSFPluginTempl(strPSSFPluginTemplId);
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = this.getRootFolder();
        return StringHelper.format((String)"%1$s%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)dataEntity.getParamStringValue("PSSFPLUGINTEMPLID", ""));
    }
}

