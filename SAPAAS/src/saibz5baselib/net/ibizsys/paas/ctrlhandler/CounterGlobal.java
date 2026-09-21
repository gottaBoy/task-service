/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.HashMap;
import net.ibizsys.paas.ctrlhandler.ICounterGlobalPlugin;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CounterGlobal {
    private static final Log log = LogFactory.getLog(CounterGlobal.class);
    private static HashMap<String, ICounterHandler> counterHandlerMap = new HashMap();
    private static ICounterGlobalPlugin iCounterGlobalPlugin = null;

    public static void registerCounterHandler(String strCounterHandlerClsType, ICounterHandler iCounterHandler) {
        if (CounterGlobal.getPlugin() != null) {
            CounterGlobal.getPlugin().registerCounterHandler(strCounterHandlerClsType, iCounterHandler);
            return;
        }
        if (!counterHandlerMap.containsKey(strCounterHandlerClsType)) {
            counterHandlerMap.put(strCounterHandlerClsType, iCounterHandler);
        }
    }

    public static ICounterHandler getCounterHandler(Class cls) throws Exception {
        if (CounterGlobal.getPlugin() != null) {
            return CounterGlobal.getPlugin().getCounterHandler(cls);
        }
        return CounterGlobal.getCounterHandler(cls.getCanonicalName());
    }

    public static ICounterHandler getCounterHandler(String strCounterHandlerClsType) throws Exception {
        if (CounterGlobal.getPlugin() != null) {
            return CounterGlobal.getPlugin().getCounterHandler(strCounterHandlerClsType);
        }
        ICounterHandler iCounterHandler = counterHandlerMap.get(strCounterHandlerClsType);
        if (iCounterHandler == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8ba1\u6570\u5668[%1$s]", strCounterHandlerClsType));
        }
        return iCounterHandler;
    }

    public static void setPlugin(ICounterGlobalPlugin iCounterGlobalPlugin) {
        CounterGlobal.iCounterGlobalPlugin = iCounterGlobalPlugin;
    }

    public static ICounterGlobalPlugin getPlugin() {
        return iCounterGlobalPlugin;
    }
}

