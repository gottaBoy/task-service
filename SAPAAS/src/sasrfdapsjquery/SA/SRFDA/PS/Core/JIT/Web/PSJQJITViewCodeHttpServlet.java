/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.JIT.Web.PSJITPFHttpServlet
 *  SA.SRFDA.PS.Core.PF.IPSPF
 *  SA.SRFDA.PS.Core.PF.IPSPFStyle
 *  SA.SRFDA.PS.Core.PF.IPSPFViewTempl
 *  SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFDA.PS.Core.Pub.PSPublishContextImpl
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.JIT.Web.PSJITPFHttpServlet;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

public class PSJQJITViewCodeHttpServlet
extends PSJITPFHttpServlet {
    public String output() throws Exception {
        String strContextPath;
        String strCurPath = this.getWebContext().getRequest().getRequestURL().toString();
        int nContextPathPos = strCurPath.indexOf(strContextPath = this.getWebContext().getRequest().getContextPath());
        if (nContextPathPos != -1) {
            strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
        }
        String strFolder = StringHelper.Format((String)"/sapsjit_%1$s/js/", (Object)this.getPSJITWebContext().getPSApplication().getPSPF().getId().toLowerCase());
        strCurPath = strCurPath.replace(strFolder, "");
        String[] parts = strCurPath.split("[/]");
        String strModuleName = parts[0];
        String strViewName = parts[1].split("[?]")[0];
        IPSPF iPSPF = this.getPSJITWebContext().getPSApplication().getPSPF();
        IPSPFStyle iPSPFStyle = this.getPSJITWebContext().getPSApplication().getPSPFStyle();
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getPSJITWebContext().getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(this.getPSJITWebContext().getPSSystem().getPSSysModelInstId());
        Iterator psAppViews = this.getPSJITWebContext().getPSApplication().getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = (IPSAppView)psAppViews.next();
            if (strViewName.indexOf(iPSAppView.getCodeName()) != 0 || StringHelper.Compare((String)iPSAppView.getPSAppModule().getCodeName(), (String)strModuleName, (boolean)false) != 0) continue;
            Iterator psPFViewTempls = iPSPFStyle.getPSPFViewTempls(iPSAppView);
            while (psPFViewTempls.hasNext()) {
                IPSPFViewTempl iPSPFViewTempl = (IPSPFViewTempl)psPFViewTempls.next();
                String strFullViewName = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)iPSAppView.getCodeName(), (Object)iPSPFViewTempl.getPSPFPubCode().getClassNameExt(), (Object)iPSPFViewTempl.getPSPFPubCode().getFileNameExt());
                if (StringHelper.Compare((String)strFullViewName, (String)strViewName, (boolean)false) != 0) continue;
                IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
                iPSPFViewCodePublisher.generateCode((IPSPublisherContext)psPublishContextImpl, iPSAppView);
                iPSPFViewCodePublisher.close();
                return this.getPSJITWebContext().getCode();
            }
        }
        throw new Exception("\u6ca1\u6709\u53d1\u5e03\u4ee3\u7801");
    }
}

