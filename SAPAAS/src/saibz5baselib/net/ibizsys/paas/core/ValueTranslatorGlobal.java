/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.core;

import java.util.HashMap;
import net.ibizsys.paas.core.IValueTranslator;
import net.ibizsys.paas.core.valuetranslator.DateValueTranslator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ValueTranslatorGlobal {
    private static final Log log;
    private static HashMap<String, IValueTranslator> valueTranslatorMap;

    static {
        String[] list;
        log = LogFactory.getLog(ValueTranslatorGlobal.class);
        valueTranslatorMap = new HashMap();
        String[] stringArray = list = new String[]{"DATE|YYYY-MM-DD HH:mm:ss", "DATE|YYYY-MM-DD", "DATE|HH:mm:ss", "DATE|YYYY-MM-DD HH", "DATE|YYYY-MM-DD HH:mm", "DATE|HH:mm"};
        int n = list.length;
        int n2 = 0;
        while (n2 < n) {
            String strType = stringArray[n2];
            DateValueTranslator dateValueTranslator = new DateValueTranslator();
            dateValueTranslator.setParam(strType);
            ValueTranslatorGlobal.registerValueTranslator(strType, dateValueTranslator);
            ++n2;
        }
    }

    public static void registerValueTranslator(String strValueTranslator, IValueTranslator iValueTranslator) {
        valueTranslatorMap.put(strValueTranslator, iValueTranslator);
    }

    public static IValueTranslator getValueTranslator(String strValueTranslator) throws Exception {
        IValueTranslator iValueTranslator = valueTranslatorMap.get(strValueTranslator);
        if (iValueTranslator == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u503c\u8f6c\u6362\u5668[%1$s]", strValueTranslator));
        }
        return iValueTranslator;
    }
}

