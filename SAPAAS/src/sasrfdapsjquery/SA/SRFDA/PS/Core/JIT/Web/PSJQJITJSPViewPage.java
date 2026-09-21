/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.JIT.Controller.IPSJITViewController
 *  SA.SRFDA.PS.Core.JIT.Web.PSJITJSPViewPage
 *  SA.SRFDA.PS.Core.PF.IPSPFStyle
 *  SA.SRFDA.PS.Core.PF.IPSPFViewTempl
 *  SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFDA.PS.Core.Pub.PSPublishContextImpl
 *  SA.SRFDA.PS.Core.Util.FileWriterHelper
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.JIT.Controller.IPSJITViewController;
import SA.SRFDA.PS.Core.JIT.Web.PSJITJSPViewPage;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.Iterator;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJQJITJSPViewPage
extends PSJITJSPViewPage {
    private static final Log log = LogFactory.getLog(PSJQJITJSPViewPage.class);

    protected void onInit() throws Exception {
        String strContextPath;
        String strCurPath = this.getWebContext().getRequest().getRequestURL().toString();
        int nContextPathPos = strCurPath.indexOf(strContextPath = this.getWebContext().getRequest().getContextPath());
        if (nContextPathPos != -1) {
            strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
        }
        String strJSPPath = this.getWebContext().getParamValue("JSPPATH");
        String[] parts = (strJSPPath = strJSPPath.replace("//", "/")).split("[/]");
        if (parts.length < 3) {
            throw new Exception(StringHelper.Format((String)"\u8def\u5f84[%1$s]\u4e0d\u652f\u6301", (Object)strJSPPath));
        }
        String strModuleName = parts[1];
        String strViewName = parts[2].split("[?]")[0];
        IPSPFStyle iPSPFStyle = this.getPSJITWebContext().getPSApplication().getPSPFStyle();
        IPSAppView iPSAppView2 = null;
        Iterator psAppViews = this.getPSJITWebContext().getPSApplication().getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = (IPSAppView)psAppViews.next();
            if (strViewName.indexOf(iPSAppView.getCodeName().toLowerCase()) != 0 || StringHelper.Compare((String)iPSAppView.getPSAppModule().getCodeName(), (String)strModuleName, (boolean)true) != 0) continue;
            Iterator psPFViewTempls = iPSPFStyle.getPSPFViewTempls(iPSAppView);
            while (psPFViewTempls.hasNext()) {
                IPSPFViewTempl iPSPFViewTempl = (IPSPFViewTempl)psPFViewTempls.next();
                String strFullViewName = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)iPSAppView.getCodeName(), (Object)iPSPFViewTempl.getPSPFPubCode().getClassNameExt(), (Object)iPSPFViewTempl.getPSPFPubCode().getFileNameExt());
                if (StringHelper.Compare((String)strFullViewName, (String)strViewName, (boolean)true) != 0) continue;
                iPSAppView2 = iPSAppView;
                break;
            }
            if (iPSAppView2 != null) break;
        }
        String strIncludeJSPFile = "";
        if (iPSAppView2 != null) {
            IPSJITViewController iPSJITViewController = this.getPSJITWebContext().getAppModel().getViewController(iPSAppView2);
            Iterator psPFViewTempls = iPSPFStyle.getPSPFViewTempls(iPSAppView2);
            while (psPFViewTempls.hasNext()) {
                IPSPFViewTempl iPSPFViewTempl = (IPSPFViewTempl)psPFViewTempls.next();
                if (StringHelper.Compare((String)iPSPFViewTempl.getPSPFPubCode().getFileNameExt(), (String)".jsp", (boolean)true) != 0) continue;
                String strJSPTmp = StringHelper.Format((String)"jsp_%1$s", (Object)this.getPSJITWebContext().getAppModel().getId()).toLowerCase();
                PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getPSJITWebContext().getDAGlobalHelper(), null);
                psPublishContextImpl.setPSSysModelInstId(this.getPSJITWebContext().getPSSystem().getPSSysModelInstId());
                IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
                iPSPFViewCodePublisher.generateCode((IPSPublisherContext)psPublishContextImpl, iPSAppView2);
                iPSPFViewCodePublisher.close();
                String strFileName = String.valueOf(strJSPTmp) + StringHelper.Format((String)"/%1$s/%2$s%3$s.jsp", (Object)iPSAppView2.getPSAppModule().getCodeName(), (Object)iPSAppView2.getCodeName(), (Object)iPSPFViewTempl.getPSPFPubCode().getClassNameExt()).toLowerCase();
                String strFileName2 = String.valueOf(strJSPTmp) + StringHelper.Format((String)"/%1$s", (Object)iPSAppView2.getPSAppModule().getCodeName(), (Object)iPSAppView2.getCodeName(), (Object)iPSPFViewTempl.getPSPFPubCode().getClassNameExt()).toLowerCase();
                String strNewFilePath = this.getRequest().getRealPath(strCurPath.replace("jspproxyview.jsp", strFileName));
                String strNewFilePath2 = this.getRequest().getRealPath(strCurPath.replace("jspproxyview.jsp", strFileName2));
                File dir = new File(strNewFilePath2);
                if (!dir.exists() || !dir.isDirectory()) {
                    dir.mkdirs();
                }
                String strCode = this.getPSJITWebContext().getCode();
                strCode = strCode.replace(StringHelper.Format((String)"/jsp/%1$s/", (Object)iPSAppView2.getPSAppModule().getCodeName().toLowerCase()), StringHelper.Format((String)"/%1$s/%2$s/", (Object)strJSPTmp, (Object)iPSAppView2.getPSAppModule().getCodeName().toLowerCase()));
                strCode = strCode.replace("${pageContext.request.contextPath}", this.getPSJITWebContext().getContextPath());
                FileWriterHelper.write((String)strNewFilePath, (String)strCode);
                String strFullViewName = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)iPSAppView2.getCodeName(), (Object)iPSPFViewTempl.getPSPFPubCode().getClassNameExt(), (Object)iPSPFViewTempl.getPSPFPubCode().getFileNameExt());
                if (StringHelper.Compare((String)strFullViewName, (String)strViewName, (boolean)true) != 0) continue;
                strIncludeJSPFile = strFileName;
            }
            this.getRequest().getRequestDispatcher(strIncludeJSPFile).forward((ServletRequest)this.getRequest(), (ServletResponse)this.getResponse());
            this.getRequest().setAttribute("includejsp", (Object)strIncludeJSPFile);
            return;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8def\u5f84[%1$s]\u5bf9\u5e94\u7684\u5e94\u7528\u89c6\u56fe", (Object)strJSPPath));
    }
}

