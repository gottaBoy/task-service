/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DALog;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DALogDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(DALogDataCtrl.class);
    protected IDBModelHelper iDBModelHelper = null;

    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = new CallResult();
        DALog daLog = new DALog();
        baseDataEntity.CopyTo((BaseDataEntity)daLog, true);
        if (StringHelper.Compare((String)daLog.getLOGTYPE(), (String)"CREATE", (boolean)true) != 0 && StringHelper.Compare((String)daLog.getLOGTYPE(), (String)"UPDATE", (boolean)true) != 0) {
            return callResult;
        }
        IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(daLog.getOBJECTTYPE());
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)daLog.getOBJECTTYPE()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEDataCtrl iDEDataCtrl = iDEHelper.GetDEDataCtrl(this.strCurOpPersonId, this.getWebContext());
        BaseDataEntity realDataEntity = new BaseDataEntity();
        realDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), (Object)daLog.getOBJECTID());
        return iDEDataCtrl.Export(realDataEntity, list, true, bFrameOnly);
    }
}

