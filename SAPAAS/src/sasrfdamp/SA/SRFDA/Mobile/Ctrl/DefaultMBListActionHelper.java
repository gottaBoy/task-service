/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Mobile.Ctrl.SRFDAMBFetchResult;
import SA.SRFDA.Mobile.Ctrl.SRFDAMBListActionHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultMBListActionHelper
extends SRFDAMBListActionHelper {
    private static final Log log = LogFactory.getLog(DefaultMBListActionHelper.class);

    @Override
    protected void OnFetchAction() throws Exception {
        SRFDAMBFetchResult fetchResult = null;
        try {
            fetchResult = super.DoFetchAction();
        }
        catch (Exception ex) {
            fetchResult = new SRFDAMBFetchResult();
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)"\u83b7\u53d6\u6570\u636e\u53d1\u751f\u5f02\u5e38", (Throwable)ex);
        }
        this.getPage().Output(fetchResult.ToJSONString());
    }
}

