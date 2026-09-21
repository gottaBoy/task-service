/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.ICounterGlobalPlugin
 *  net.ibizsys.paas.ctrlhandler.ICounterHandler
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import java.util.HashMap;
import net.ibizsys.paas.ctrlhandler.ICounterGlobalPlugin;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITCounterGlobalPlugin
implements ICounterGlobalPlugin {
    private final Log log = LogFactory.getLog(PSJITCounterGlobalPlugin.class);
    private HashMap<String, ICounterHandler> counterHandlerMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerCounterHandler(String strCounterHandlerClsType, ICounterHandler iCounterHandler) {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.getInstance().getSystemModel().registerCounterHandler(strCounterHandlerClsType, iCounterHandler);
            return;
        }
        HashMap<String, ICounterHandler> hashMap = this.counterHandlerMap;
        synchronized (hashMap) {
            this.counterHandlerMap.put(strCounterHandlerClsType, iCounterHandler);
        }
    }

    public ICounterHandler getCounterHandler(Class cls) throws Exception {
        return this.getCounterHandler(cls.getCanonicalName());
    }

    public ICounterHandler getCounterHandler(String strCounterHandlerClsType) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            return PSJITWebContext.getInstance().getSystemModel().getCounterHandler(strCounterHandlerClsType);
        }
        return this.internalGetCounterHandler(strCounterHandlerClsType);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ICounterHandler internalGetCounterHandler(String strCounterHandlerClsType) throws Exception {
        HashMap<String, ICounterHandler> hashMap = this.counterHandlerMap;
        synchronized (hashMap) {
            ICounterHandler iCounterHandler = this.counterHandlerMap.get(strCounterHandlerClsType);
            return iCounterHandler;
        }
    }
}

