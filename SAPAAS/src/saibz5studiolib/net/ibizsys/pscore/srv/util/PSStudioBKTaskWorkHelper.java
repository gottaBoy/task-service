/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.util.IPSStudioBKTaskWork;
import net.ibizsys.pscore.srv.util.IPSStudioBKTaskWork2;

public class PSStudioBKTaskWorkHelper {
    private static SimpleWebContext simpleWebContext = null;

    public static void execute(IPSStudioBKTaskWork iPSStudioBKTaskWork) throws Exception {
        PSStudioBKTaskWorkHelper.execute(iPSStudioBKTaskWork, null);
    }

    public static void execute(IPSStudioBKTaskWork iPSStudioBKTaskWork, Object object) throws Exception {
        boolean bl = false;
        try {
            if (WebContext.getCurrent() == null) {
                WebContext.setCurrent((IWebContext)simpleWebContext);
                bl = true;
            }
            iPSStudioBKTaskWork.execute(object);
            if (bl) {
                WebContext.setCurrent(null);
            }
        }
        catch (Exception exception) {
            if (bl) {
                WebContext.setCurrent(null);
            }
            throw exception;
        }
    }

    public static void execute(IPSStudioBKTaskWork2 iPSStudioBKTaskWork2) {
        PSStudioBKTaskWorkHelper.execute(iPSStudioBKTaskWork2, null);
    }

    public static void execute(IPSStudioBKTaskWork2 iPSStudioBKTaskWork2, Object object) {
        block4: {
            boolean bl = false;
            try {
                if (WebContext.getCurrent() == null) {
                    WebContext.setCurrent((IWebContext)simpleWebContext);
                    bl = true;
                }
                iPSStudioBKTaskWork2.execute(object);
                if (bl) {
                    WebContext.setCurrent(null);
                }
            }
            catch (Exception exception) {
                if (!bl) break block4;
                WebContext.setCurrent(null);
            }
        }
    }

    static {
        simpleWebContext = new SimpleWebContext();
        simpleWebContext.setSessionValue("SRFPERSONID", (Object)"SYSTEM");
    }
}

