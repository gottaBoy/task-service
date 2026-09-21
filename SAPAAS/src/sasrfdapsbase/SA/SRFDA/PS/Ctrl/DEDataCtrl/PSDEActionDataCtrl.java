/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEAction;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEActionDataCtrl.class);
    public static final String[] DEACTIONS = new String[]{"CheckKey", "Create", "Get", "Remove", "Save", "Update", "GetDraft"};
    public static final String[] DEACTIONS2 = new String[]{"CreateTemp", "CreateTempMajor", "GetDraftTemp", "GetDraftTempMajor", "GetTemp", "GetTempMajor", "RemoveTemp", "RemoveTempMajor", "UpdateTemp", "UpdateTempMajor"};

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
                PSDEAction psDEAction;
                String strAction;
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                String[] stringArray = DEACTIONS;
                int n = DEACTIONS.length;
                int n2 = 0;
                while (n2 < n) {
                    strAction = stringArray[n2];
                    psDEAction = new PSDEAction();
                    psDEAction.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    psDEAction.setPSDEACTIONNAME(strAction);
                    callResult = this.Select(psDEAction);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        psDEAction.setPSDENAME(psDataEntity.getPSDATAENTITYNAME());
                        psDEAction.setACTIONTYPE("BUILTIN");
                        psDEAction.setCODENAME(strAction);
                        psDEAction.setLOGICNAME(strAction);
                        callResult = this.Save(true, psDEAction);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u9ed8\u8ba4\u884c\u4e3a\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                    ++n2;
                }
                if (psDataEntity.getENATEMPDATA() != 0) {
                    stringArray = DEACTIONS2;
                    n = DEACTIONS2.length;
                    n2 = 0;
                    while (n2 < n) {
                        strAction = stringArray[n2];
                        psDEAction = new PSDEAction();
                        psDEAction.setPSDEID(psDataEntity.getPSDATAENTITYID());
                        psDEAction.setPSDEACTIONNAME(strAction);
                        callResult = this.Select(psDEAction);
                        if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                            psDEAction.setPSDENAME(psDataEntity.getPSDATAENTITYNAME());
                            psDEAction.setACTIONTYPE("BUILTIN");
                            psDEAction.setCODENAME(strAction);
                            psDEAction.setLOGICNAME(strAction);
                            callResult = this.Save(true, psDEAction);
                            if (callResult.isError()) {
                                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u9ed8\u8ba4\u884c\u4e3a\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                            }
                        }
                        ++n2;
                    }
                }
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
}

