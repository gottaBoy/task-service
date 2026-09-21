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

import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher2;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSPFCodePublisher2Impl
extends PSPFCodePublisherImpl {
    private static final Log log = LogFactory.getLog(PSPFCodePublisher2Impl.class);
    public static final int MAXKEYCOUNT = 5000;
    public static final String PARAMTYPE = "_PARAMTYPE_";
    private HashMap<String, String> keyMap = new HashMap();

    protected IPSGenerateCodeResult internalGetLogicCode(Object objCtrl, String strCodeType, Map<String, Object> params) throws Exception {
        IPSPFLogicCodeObject iPSPFLogicCodeObject = null;
        if (!(objCtrl instanceof IPSPFLogicCodeObject)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u903b\u8f91\u4ee3\u7801\u5bf9\u8c61[%1$s]", (Object)objCtrl));
        }
        iPSPFLogicCodeObject = (IPSPFLogicCodeObject)objCtrl;
        IPSPFPubCode iPSPFPubCode = this.getPSPFStyle2().getPSPFPubCode("NONE", strCodeType, true);
        if (iPSPFPubCode == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strCodeType));
        }
        IPSPFViewLogicTempl iPSPFViewLogicTempl = this.getPSPFStyle2().getPSPFViewLogicTempl(iPSPFLogicCodeObject, iPSPFPubCode);
        if (iPSPFViewLogicTempl != null) {
            HashMap<String, Object> params2 = new HashMap<String, Object>();
            params2.putAll(params);
            IPSPFViewLogicCodePublisher2 iPSPFViewLogicCodePublisher = (IPSPFViewLogicCodePublisher2)iPSPFViewLogicTempl.getPSPFViewLogicCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFViewLogicCodePublisher.generateCode(this.getContext(), iPSPFLogicCodeObject, params);
            iPSPFViewLogicCodePublisher.close();
            return iPSGenerateCodeResult;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u903b\u8f91[%1$s][%2$s][%3$s]\u4ee3\u7801\u6a21\u677f", (Object)iPSPFLogicCodeObject.getPFLogicCodeCat(), (Object)iPSPFLogicCodeObject.getPFLogicCodeType(), (Object)iPSPFPubCode.getName()));
    }

    public abstract IPSPFStyle2 getPSPFStyle2();

    protected boolean internalExists(String strType, String strParam, String strParam2) {
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

    protected boolean internalSet(String strParam, String strValue) {
        String strKey = KeyValueHelper.genUniqueId((String)PARAMTYPE, (String)strParam, null);
        if (!this.keyMap.containsKey(strKey) && this.keyMap.size() > 5000) {
            log.error((Object)StringHelper.Format((String)"\u91cd\u590d\u9879\u9650\u5236\u8d85\u51fa\u9650\u5236[%1$s]", (Object)5000));
            return false;
        }
        this.keyMap.put(strKey, strValue);
        return true;
    }

    protected String internalGet(String strParam, String strDefault) {
        String strKey = KeyValueHelper.genUniqueId((String)PARAMTYPE, (String)strParam, null);
        String strValue = this.keyMap.get(strKey);
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        if (!StringHelper.IsNullOrEmpty((String)strDefault)) {
            return strDefault;
        }
        return "";
    }

    @Override
    protected void onClose() {
        this.keyMap.clear();
        super.onClose();
    }

    protected void beforeGenerateCode() {
        this.keyMap.clear();
    }
}

