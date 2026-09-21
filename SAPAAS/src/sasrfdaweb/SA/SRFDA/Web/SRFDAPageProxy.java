/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAModelStorage
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Web.SRFDAConfigCache
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.jsp.PageContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Web.SRFDAConfigCache;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDAPageProxy {
    private static final Log log = LogFactory.getLog(SRFDAPageProxy.class);

    public static SRFDAPageEx GetPage(PageContext pageContext, String strDefault) throws Exception {
        Object objPage;
        IDAModelStorage daModelStorage;
        IPageHelper iPageHelper = null;
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        String strPageId = "";
        try {
            strPageId = request.getParameter("SRFPAGEID");
            strPageId = SRFExWebContext.FilterRequestValue((String)strPageId);
        }
        catch (Exception e) {
            strPageId = "";
            log.error((Object)e.getMessage(), (Throwable)e);
        }
        if (!StringHelper.IsNullOrEmpty((String)strPageId) && !StringHelper.IsNullOrEmpty((String)(iPageHelper = (daModelStorage = SRFDAPageProxy.GetDAModelStroage(pageContext)).FindPage2(strPageId)).getPageObject())) {
            strDefault = iPageHelper.getPageObject();
        }
        if ((objPage = ObjectHelper.Create((String)strDefault)) == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)strDefault));
        }
        SRFDAPageEx pageEx = (SRFDAPageEx)((Object)objPage);
        pageEx.setPageData(iPageHelper);
        return pageEx;
    }

    public static IDAModelStorage GetDAModelStroage(PageContext pageContext) {
        return (IDAModelStorage)pageContext.getServletContext().getAttribute("SRFDAMODELSTORAGE");
    }

    public static SRFDAConfigCache GetConfigCache(PageContext pageContext) {
        return (SRFDAConfigCache)pageContext.getServletContext().getAttribute("SRFCONFIGCACHE");
    }
}

