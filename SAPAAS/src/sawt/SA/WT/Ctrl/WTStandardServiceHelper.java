/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.WTServiceBaseHelper;
import SA.WT.Data.WTStandardService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTStandardServiceHelper
extends WTServiceBaseHelper {
    private static final Log log = LogFactory.getLog(WTStandardServiceHelper.class);
    private WTStandardService wtStandardService = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IWTAccountHelper iWTAccountHelper, BaseDataEntity wtServiceBase) throws Exception {
        if (wtServiceBase instanceof WTStandardService) {
            this.wtStandardService = (WTStandardService)wtServiceBase;
        } else {
            String strWTStandardServiceId = wtServiceBase.GetParamStringValue("WTSERVICEBASEID", "");
            this.wtStandardService = new WTStandardService();
            CallResult callResult = this.getWTModelHelper().GetWTStandardService(strWTStandardServiceId, this.wtStandardService);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u4fe1\u670d\u52a1[%1$s]\uff0c%2$s", (Object)strWTStandardServiceId, (Object)callResult.getErrorInfo()));
            }
        }
        this.wtStandardService.SetParamValue("WTSERVICEBASEID", this.wtStandardService.getWTSTDSERVICEID());
        this.wtStandardService.SetParamValue("WTSERVICEBASENAME", this.wtStandardService.getWTSTDSERVICENAME());
        super.Init(iDAGlobalHelper, iWTAccountHelper, this.wtStandardService);
    }
}

