/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork2;
import SA.SRFDA.PS.Web.WebContextProxy;
import SA.SRFDA.Web.ISRFDAWebContext;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;

public class PSBKTaskWorkHelper {
    private static SimpleWebContext simpleWebContext = null;

    static {
        simpleWebContext = new SimpleWebContext();
        simpleWebContext.setSessionValue("SRFPERSONID", (Object)"SYSTEM");
        simpleWebContext.setSessionValue("SRFLOGINNAME", (Object)"SYSTEM");
        simpleWebContext.setSessionValue("SRFUSERNAME", (Object)"\u7cfb\u7edf\u5185\u7f6e\u7528\u6237");
    }

    public static void execute(IPSBKTaskWork iPSBKTaskWork) throws Exception {
        PSBKTaskWorkHelper.execute(iPSBKTaskWork, null);
    }

    public static void execute(IPSBKTaskWork iPSBKTaskWork, Object obj) throws Exception {
        boolean bCreateWebContext = false;
        try {
            if (WebContext.getCurrent() == null) {
                WebContext.setCurrent((IWebContext)simpleWebContext);
                bCreateWebContext = true;
            }
            iPSBKTaskWork.execute(obj);
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
        }
        catch (Exception ex) {
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
            throw ex;
        }
    }

    public static void execute(IPSBKTaskWork iPSBKTaskWork, Object obj, ISRFDAWebContext iWebContext) throws Exception {
        boolean bCreateWebContext = false;
        try {
            if (WebContext.getCurrent() == null) {
                WebContext.setCurrent((IWebContext)new WebContextProxy(iWebContext));
                bCreateWebContext = true;
            }
            iPSBKTaskWork.execute(obj);
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
        }
        catch (Exception ex) {
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
            throw ex;
        }
    }

    public static void execute(IPSBKTaskWork2 iPSBKTaskWork) {
        PSBKTaskWorkHelper.execute(iPSBKTaskWork, null);
    }

    public static void execute(IPSBKTaskWork2 iPSBKTaskWork, Object obj) {
        block4: {
            boolean bCreateWebContext = false;
            try {
                if (WebContext.getCurrent() == null) {
                    WebContext.setCurrent((IWebContext)simpleWebContext);
                    bCreateWebContext = true;
                }
                iPSBKTaskWork.execute(obj);
                if (bCreateWebContext) {
                    WebContext.setCurrent(null);
                }
            }
            catch (Exception ex) {
                if (!bCreateWebContext) break block4;
                WebContext.setCurrent(null);
            }
        }
    }

    public static void execute(IPSBKTaskWork2 iPSBKTaskWork2, Object obj, ISRFDAWebContext iWebContext) throws Exception {
        boolean bCreateWebContext = false;
        try {
            if (WebContext.getCurrent() == null) {
                WebContext.setCurrent((IWebContext)new WebContextProxy(iWebContext));
                bCreateWebContext = true;
            }
            iPSBKTaskWork2.execute(obj);
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
        }
        catch (Exception ex) {
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
            throw ex;
        }
    }
}

