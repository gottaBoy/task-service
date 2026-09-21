/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web;

import SA.SRFDA.Web.IDACustomMenuBuilder;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDACustomMenuBuilder
implements IDACustomMenuBuilder {
    private static final Log log = LogFactory.getLog(BaseDACustomMenuBuilder.class);

    @Override
    public CallResult Build(ISRFDAGlobalHelper iDAGlobalHelper, ISRFDAWebContext iWebContext, XMLNode menuNode) {
        Properties properties;
        String strProperty = menuNode.GetExtValue("CUSTOMOBJECTPARAM", "");
        try {
            properties = PropertiesHelper.Load((String)strProperty);
        }
        catch (Exception e) {
            CallResult callResult = new CallResult();
            callResult.setErrorInfo(StringHelper.Format((String)"\u52a0\u8f7d\u52a8\u6001\u83dc\u5355\u5bf9\u8c61\u53c2\u6570\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()));
            callResult.setRetCode(1);
            log.error((Object)"\u52a0\u8f7d\u52a8\u6001\u83dc\u5355\u5bf9\u8c61\u53c2\u6570\u51fa\u73b0\u5f02\u5e38", (Throwable)e);
            return callResult;
        }
        return this.OnBuild(iDAGlobalHelper, iWebContext, menuNode, properties);
    }

    protected CallResult OnBuild(ISRFDAGlobalHelper iDAGlobalHelper, ISRFDAWebContext iWebContext, XMLNode menuNode, Properties properties) {
        return new CallResult();
    }
}

