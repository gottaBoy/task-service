/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Toolbar.GridDEBehaviorHandler;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Utility.URLHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GridRedirectHandler
extends GridDEBehaviorHandler {
    private static final Log log = LogFactory.getLog(GridRedirectHandler.class);

    @Override
    protected String GetHandleJSCode(boolean bButton, XMLConfig config, ISRFDAWebContext daWebContext, SRFExDataGrid dataGrid) {
        String strPageId = config.GetExtValue("UP_PAGEID", "");
        String strPagePath = ".." + daWebContext.getCurPagePath();
        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
        strPagePath = String.valueOf(strPagePath) + daWebContext.GetQueryStringWithout("SRFPAGEID");
        if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
            strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
            strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SRFPAGEID", (Object)strPageId);
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8df3\u8f6c\u7684\u9875\u9762\u7f16\u53f7"));
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("window.location='%1$s';", (Object)strPagePath);
        script.Append("}");
        return script.toString();
    }
}

