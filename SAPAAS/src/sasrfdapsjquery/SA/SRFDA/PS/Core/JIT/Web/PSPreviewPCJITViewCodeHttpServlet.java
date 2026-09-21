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
 *  net.ibizsys.paas.util.StringBuilderEx
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
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringBuilderEx;

public class PSPreviewPCJITViewCodeHttpServlet
extends PSJITPFHttpServlet {
    public String output() throws Exception {
        String strFolder;
        String strContextPath;
        String strCurPath = this.getWebContext().getRequest().getRequestURL().toString();
        int nContextPathPos = strCurPath.indexOf(strContextPath = this.getWebContext().getRequest().getContextPath());
        if (nContextPathPos != -1) {
            strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
        }
        if (StringHelper.Compare((String)(strCurPath = strCurPath.replace(strFolder = StringHelper.Format((String)"/sapsjit_%1$s/src/pages/", (Object)this.getPSJITWebContext().getPSApplication().getPSPF().getId().toLowerCase()), "")), (String)"IBizDEStore.js", (boolean)true) == 0) {
            IPSPF iPSPF = this.getPSJITWebContext().getPSApplication().getPSPF();
            IPSPFStyle iPSPFStyle = this.getPSJITWebContext().getPSApplication().getPSPFStyle();
            PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getPSJITWebContext().getDAGlobalHelper(), null);
            psPublishContextImpl.setPSSysModelInstId(this.getPSJITWebContext().getPSSystem().getPSSysModelInstId());
        } else {
            String[] parts = strCurPath.split("[/]");
            String strModuleName = parts[0];
            String strViewName = parts[2].split("[?]")[0];
            strViewName = strViewName.replace("-", "");
            boolean bAllView = false;
            if (strViewName.indexOf(".rtall.") != -1) {
                bAllView = true;
                strViewName = strViewName.replace(".rtall.", ".");
            }
            IPSPF iPSPF = this.getPSJITWebContext().getPSApplication().getPSPF();
            IPSPFStyle iPSPFStyle = this.getPSJITWebContext().getPSApplication().getPSPFStyle();
            PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getPSJITWebContext().getDAGlobalHelper(), null);
            psPublishContextImpl.setPSSysModelInstId(this.getPSJITWebContext().getPSSystem().getPSSysModelInstId());
            Iterator psAppViews = this.getPSJITWebContext().getPSApplication().getAllPSAppViews();
            while (psAppViews.hasNext()) {
                IPSAppView iPSAppView = (IPSAppView)psAppViews.next();
                if (StringHelper.Compare((String)parts[1], (String)iPSAppView.getCodeName(), (boolean)true) != 0 || StringHelper.Compare((String)iPSAppView.getPSAppModule().getCodeName(), (String)strModuleName, (boolean)true) != 0) continue;
                Iterator psPFViewTempls = iPSPFStyle.getPSPFViewTempls(iPSAppView);
                while (psPFViewTempls.hasNext()) {
                    IPSPFViewTempl iPSPFViewTempl = (IPSPFViewTempl)psPFViewTempls.next();
                    String strFullViewName = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)iPSAppView.getCodeName(), (Object)iPSPFViewTempl.getPSPFPubCode().getClassNameExt(), (Object)iPSPFViewTempl.getPSPFPubCode().getFileNameExt()).toLowerCase();
                    if (StringHelper.Compare((String)strFullViewName.replace("_", ""), (String)strViewName.replace("_", ""), (boolean)true) != 0) continue;
                    if (bAllView) {
                        HashMap<String, IPSAppView> allRelatedPSAppViewMap = new HashMap<String, IPSAppView>();
                        allRelatedPSAppViewMap.put(iPSAppView.getId(), iPSAppView);
                        this.fillRTAllPSAppView(iPSAppView, allRelatedPSAppViewMap);
                        allRelatedPSAppViewMap.remove(iPSAppView.getId());
                        StringBuilderEx sb = new StringBuilderEx();
                        this.getPSJITWebContext().resetCode();
                        for (IPSAppView relatedPSAppView : allRelatedPSAppViewMap.values()) {
                            IPSPFViewTempl iPSPFViewTempl2 = iPSPFStyle.getPSPFViewTempl(relatedPSAppView.getPSViewType(), iPSPFViewTempl.getPSPFPubCode());
                            if (iPSPFViewTempl2 == null) continue;
                            IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl2.getPSPFViewCodePublisher();
                            iPSPFViewCodePublisher.generateCode((IPSPublisherContext)psPublishContextImpl, relatedPSAppView);
                            iPSPFViewCodePublisher.close();
                            sb.append(this.getPSJITWebContext().getCode());
                            sb.append("\r\n");
                            this.getPSJITWebContext().resetCode();
                        }
                        IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
                        iPSPFViewCodePublisher.generateCode((IPSPublisherContext)psPublishContextImpl, iPSAppView);
                        iPSPFViewCodePublisher.close();
                        sb.append(this.getPSJITWebContext().getCode());
                        sb.append("\r\n");
                        return sb.toString();
                    }
                    IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
                    iPSPFViewCodePublisher.generateCode((IPSPublisherContext)psPublishContextImpl, iPSAppView);
                    iPSPFViewCodePublisher.close();
                    return this.getPSJITWebContext().getCode();
                }
            }
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strCurPath));
    }

    protected void fillRTAllPSAppView(IPSAppView iPSAppView, HashMap<String, IPSAppView> psAppViewMap) throws Exception {
        Iterator allRelatedPSAppViews = iPSAppView.getAllRelatedPSAppViews();
        if (allRelatedPSAppViews != null) {
            while (allRelatedPSAppViews.hasNext()) {
                IPSAppView relatedPSAppView = (IPSAppView)allRelatedPSAppViews.next();
                if (psAppViewMap.containsKey(relatedPSAppView.getId())) continue;
                psAppViewMap.put(relatedPSAppView.getId(), relatedPSAppView);
                this.fillRTAllPSAppView(relatedPSAppView, psAppViewMap);
            }
        }
    }
}

