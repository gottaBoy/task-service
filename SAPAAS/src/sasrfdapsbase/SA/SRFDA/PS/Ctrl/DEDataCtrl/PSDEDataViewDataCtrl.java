/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDataView;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataViewDataCtrl
extends PSDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDataViewDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2050", (boolean)true) == 0) {
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                String strIndexDEMode = psDataEntity.getINDEXDETYPE();
                if (!StringHelper.IsNullOrEmpty((String)strIndexDEMode)) {
                    this.initIndexDEDataView(psDataEntity);
                }
                if (psDataEntity.getENAMULTIFORM() > 0) {
                    this.initMultiFormDataView(psDataEntity);
                }
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void initIndexDEDataView(PSDataEntity psDataEntity) throws Exception {
        String strIndexDEDataViewId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"INDEXDETYPE", (String)psDataEntity.getINDEXDETYPE());
        PSDEDataView psDEDataView = new PSDEDataView();
        psDEDataView.setPSDEDATAVIEWID(strIndexDEDataViewId);
        CallResult callResult = this.Get(psDEDataView);
        if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
            psDEDataView.setPSDEDATAVIEWID(strIndexDEDataViewId);
            psDEDataView.setPSDEID(psDataEntity.getPSDATAENTITYID());
            psDEDataView.setCODENAME("IndexType");
            psDEDataView.setPSDEDATAVIEWNAME("\u7d22\u5f15\u5b9e\u4f53\u9009\u62e9\u6570\u636e\u89c6\u56fe");
            psDEDataView.setENABLEPAGINGBAR(0);
            callResult = this.Save(true, psDEDataView);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u7d22\u5f15\u5b9e\u4f53\u9009\u62e9\u6570\u636e\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
    }

    protected void initMultiFormDataView(PSDataEntity psDataEntity) throws Exception {
        String strIndexDEDataViewId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"FORMTYPE", (String)"");
        PSDEDataView psDEDataView = new PSDEDataView();
        psDEDataView.setPSDEDATAVIEWID(strIndexDEDataViewId);
        CallResult callResult = this.Get(psDEDataView);
        if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
            psDEDataView.setPSDEDATAVIEWID(strIndexDEDataViewId);
            psDEDataView.setPSDEID(psDataEntity.getPSDATAENTITYID());
            psDEDataView.setCODENAME("FormType");
            psDEDataView.setPSDEDATAVIEWNAME("\u8868\u5355\u9009\u62e9\u6570\u636e\u89c6\u56fe");
            psDEDataView.setENABLEPAGINGBAR(0);
            callResult = this.Save(true, psDEDataView);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u8868\u5355\u9009\u62e9\u6570\u636e\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
    }
}

