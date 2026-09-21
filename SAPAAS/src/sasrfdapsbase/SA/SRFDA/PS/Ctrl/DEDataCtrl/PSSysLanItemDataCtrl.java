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

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysLanItem;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysLanItemDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysLanItemDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        PSSysLanItem psSysLanItem = new PSSysLanItem();
        psSysLanItem.proxy(dataEntity);
        if (bInsert) {
            psSysLanItem.setPSSYSLANITEMID(StringHelper.format((String)"%1$s.%2$s", (Object)psSysLanItem.getPSLANGUAGEID(), (Object)psSysLanItem.getPSSYSLANRESID()));
        }
        return callResult;
    }
}

