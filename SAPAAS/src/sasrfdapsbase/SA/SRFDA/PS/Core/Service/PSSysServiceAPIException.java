/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.PSException;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSDEServiceAPI;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class PSSysServiceAPIException
extends PSException {
    private static final long serialVersionUID = 1L;
    public static final int ERROR_DESERVICEAPINOTFOUND = 12000;
    private IPSSysServiceAPI iPSSysServiceAPI = null;

    public PSSysServiceAPIException(IPSSysServiceAPI iPSSysServiceAPI, int nErrorCode, String strErrorInfo) {
        super(nErrorCode, strErrorInfo);
        this.setPSSysServiceAPI(iPSSysServiceAPI);
    }

    public IPSSysServiceAPI getPSSysServiceAPI() {
        return this.iPSSysServiceAPI;
    }

    protected void setPSSysServiceAPI(IPSSysServiceAPI iPSSysServiceAPI) {
        this.iPSSysServiceAPI = iPSSysServiceAPI;
    }

    public static PSSysServiceAPIException create(IPSSysServiceAPI iPSSysServiceAPI, int nErrorCode) throws Exception {
        return PSSysServiceAPIException.create(iPSSysServiceAPI, nErrorCode, null, null);
    }

    public static PSSysServiceAPIException create(IPSSysServiceAPI iPSSysServiceAPI, int nErrorCode, Object objArg) throws Exception {
        return PSSysServiceAPIException.create(iPSSysServiceAPI, nErrorCode, objArg, null);
    }

    public static PSSysServiceAPIException create(IPSSysServiceAPI iPSSysServiceAPI, int nErrorCode, Object objArg, Object objArg2) throws Exception {
        switch (nErrorCode) {
            case 12000: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEServiceAPI psDEServiceAPI = new PSDEServiceAPI();
                CallResult callResult = PSSysServiceAPIException.getPSModelHelper(iPSSysServiceAPI).getPSDEServiceAPI((String)objArg, psDEServiceAPI);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSSysServiceAPI.getId(), (String)psDEServiceAPI.getPSSYSSERVICEAPIID(), (boolean)false) != 0) {
                        return new PSSysServiceAPIException(iPSSysServiceAPI, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%2$s]\uff0c\u9519\u8bef\u7684\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3[%3$s]", (Object)iPSSysServiceAPI.getName(), (Object)psDEServiceAPI.getPSDESERVICEAPINAME(), (Object)psDEServiceAPI.getPSSYSSERVICEAPINAME()));
                    }
                    if (!psDEServiceAPI.getVALIDFLAG()) {
                        return new PSSysServiceAPIException(iPSSysServiceAPI, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s]\u6ca1\u6709\u542f\u7528", (Object)psDEServiceAPI.getPSDESERVICEAPINAME()));
                    }
                    return new PSSysServiceAPIException(iPSSysServiceAPI, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%2$s]", (Object)iPSSysServiceAPI.getName(), (Object)psDEServiceAPI.getPSDESERVICEAPINAME()));
                }
                return new PSSysServiceAPIException(iPSSysServiceAPI, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%2$s]", (Object)iPSSysServiceAPI.getName(), (Object)objArg));
            }
        }
        if (objArg != null && objArg instanceof String) {
            return new PSSysServiceAPIException(iPSSysServiceAPI, nErrorCode, (String)objArg);
        }
        return new PSSysServiceAPIException(iPSSysServiceAPI, nErrorCode, null);
    }
}

