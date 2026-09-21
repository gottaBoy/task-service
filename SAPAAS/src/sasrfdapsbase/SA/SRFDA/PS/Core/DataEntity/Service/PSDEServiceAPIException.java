/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

@PSModelIgnoreMeta
public class PSDEServiceAPIException
extends PSDataEntityException {
    private IPSDEServiceAPI iPSDEServiceAPI = null;

    public PSDEServiceAPIException(IPSDEServiceAPI iPSDEServiceAPI, int nErrorCode, String strErrorInfo) {
        super(iPSDEServiceAPI.getPSDataEntity(), nErrorCode, strErrorInfo);
        this.iPSDEServiceAPI = iPSDEServiceAPI;
    }

    public IPSDEServiceAPI getPSDEServiceAPI() {
        return this.iPSDEServiceAPI;
    }

    public static PSDEServiceAPIException create(IPSDEServiceAPI iPSDEServiceAPI, int nErrorCode, Object objArg) throws Exception {
        return PSDEServiceAPIException.create(iPSDEServiceAPI, nErrorCode, objArg);
    }

    public static PSDEServiceAPIException create(IPSDEServiceAPI iPSDEServiceAPI, int nErrorCode, Object objArg, Object objArg2) throws Exception {
        switch (nErrorCode) {
            case 20020: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDESADetail psDESADetail = new PSDESADetail();
                CallResult callResult = PSDEServiceAPIException.getPSModelHelper(iPSDEServiceAPI).getPSDESADetail((String)objArg, psDESADetail);
                if (callResult.isOk()) {
                    if (psDESADetail.GetParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSDEServiceAPIException(iPSDEServiceAPI, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53\u670d\u52a1API[%1$s]\u6307\u5b9a\u65b9\u6cd5[%2$s]\u6ca1\u6709\u542f\u7528", (Object)iPSDEServiceAPI.getName(), (Object)psDESADetail.getPSDESADETAILNAME()));
                    }
                    if (StringHelper.Compare((String)iPSDEServiceAPI.getId(), (String)psDESADetail.getPSDESERVICEAPIID(), (boolean)false) != 0) {
                        return new PSDEServiceAPIException(iPSDEServiceAPI, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53\u670d\u52a1API[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u65b9\u6cd5[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53\u670d\u52a1API[%3$s]", (Object)iPSDEServiceAPI.getName(), (Object)psDESADetail.getPSDESADETAILNAME(), (Object)psDESADetail.getPSDESERVICEAPINAME()));
                    }
                    return new PSDEServiceAPIException(iPSDEServiceAPI, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53\u670d\u52a1API[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u65b9\u6cd5[%2$s]", (Object)iPSDEServiceAPI.getName(), (Object)psDESADetail.getPSDESADETAILNAME()));
                }
                return new PSDEServiceAPIException(iPSDEServiceAPI, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53\u670d\u52a1API[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u65b9\u6cd5[%2$s]", (Object)iPSDEServiceAPI.getName(), (Object)objArg));
            }
        }
        if (objArg != null && objArg instanceof String) {
            return new PSDEServiceAPIException(iPSDEServiceAPI, nErrorCode, (String)objArg);
        }
        return new PSDEServiceAPIException(iPSDEServiceAPI, nErrorCode, null);
    }
}

