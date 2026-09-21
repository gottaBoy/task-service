/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSCodePublisherContextBase;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCodePublisherContextImpl
extends PSCodePublisherContextBase {
    private static final Log log = LogFactory.getLog(PSCodePublisherContextImpl.class);
    private HashMap<String, String> keyMap = new HashMap();

    @Override
    public boolean exists(String strType, String strParam, String strParam2) {
        String strKey = KeyValueHelper.genUniqueId((String)strType, (String)strParam, (String)strParam2);
        if (this.keyMap.containsKey(strKey)) {
            return true;
        }
        if (this.keyMap.size() > 5000) {
            log.error((Object)StringHelper.Format((String)"\u91cd\u590d\u9879\u9650\u5236\u8d85\u51fa\u9650\u5236[%1$s]", (Object)5000));
            return true;
        }
        this.keyMap.put(strKey, "");
        return false;
    }

    @Override
    public boolean set(String strParam, String strValue) {
        String strKey = KeyValueHelper.genUniqueId((String)"_PARAMTYPE_", (String)strParam, null);
        if (!this.keyMap.containsKey(strKey) && this.keyMap.size() > 5000) {
            log.error((Object)StringHelper.Format((String)"\u91cd\u590d\u9879\u9650\u5236\u8d85\u51fa\u9650\u5236[%1$s]", (Object)5000));
            return false;
        }
        this.keyMap.put(strKey, strValue);
        return true;
    }

    @Override
    public String get(String strParam, String strDefault) {
        String strKey = KeyValueHelper.genUniqueId((String)"_PARAMTYPE_", (String)strParam, null);
        String strValue = this.keyMap.get(strKey);
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        if (!StringHelper.IsNullOrEmpty((String)strDefault)) {
            return strDefault;
        }
        return "";
    }
}

