/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletConfig
 *  javax.servlet.ServletException
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.JIT.Web.PSJITPFHttpServlet;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class PSJITPFAppCodeHttpServlet
extends PSJITPFHttpServlet {
    private String strAppCode = "";

    public void init(ServletConfig config) throws ServletException {
        this.strAppCode = config.getInitParameter("APPCODE");
        super.init(config);
    }

    @Override
    public String output() throws Exception {
        IPSPF iPSPF = this.getPSJITWebContext().getPSApplication().getPSPF();
        IPSPFStyle iPSPFStyle = this.getPSJITWebContext().getPSApplication().getPSPFStyle();
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getPSJITWebContext().getDAGlobalHelper(), null);
        Iterator<IPSPFAppTempl> psPFAppTempls = iPSPFStyle.getPSPFAppTempls(this.getPSJITWebContext().getPSApplication());
        while (psPFAppTempls.hasNext()) {
            IPSPFAppTempl iPSPFAppTempl = psPFAppTempls.next();
            if (StringHelper.Compare((String)iPSPFAppTempl.getPSPFPubCode().getName(), (String)this.strAppCode, (boolean)true) != 0) continue;
            IPSPFAppCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppCodePublisher();
            iPSPFAppCodePublisher.generateCode(psPublishContextImpl, this.getPSJITWebContext().getPSApplication());
            iPSPFAppCodePublisher.close();
            return this.getPSJITWebContext().getCode();
        }
        throw new Exception("\u6ca1\u6709\u53d1\u5e03\u4ee3\u7801");
    }
}

