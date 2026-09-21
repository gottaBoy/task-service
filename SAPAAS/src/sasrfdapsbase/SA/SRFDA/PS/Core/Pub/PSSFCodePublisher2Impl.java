/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSSFHelpCodePublisher2;
import SA.SRFDA.PS.Core.Pub.IPSSFLogicCodePublisher2;
import SA.SRFDA.PS.Core.Pub.PSSFCodePublisherImpl;
import SA.SRFDA.PS.Core.SF.IPSSFHelpCodeObject;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl;
import SA.SRFDA.PS.Core.SF.IPSSFLogicCodeObject;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;

public abstract class PSSFCodePublisher2Impl
extends PSSFCodePublisherImpl {
    protected IPSGenerateCodeResult internalGetLogicCode(Object objCtrl, String strCodeType, Map<String, Object> params) throws Exception {
        if (this.getPSSFStyle2() == null) {
            throw new Exception("\u5f53\u524d\u6a21\u677f\u4e0d\u652f\u6301\u6b64\u65b9\u6cd5");
        }
        IPSSFLogicCodeObject iPSSFLogicCodeObject = null;
        if (!(objCtrl instanceof IPSSFLogicCodeObject)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u903b\u8f91\u4ee3\u7801\u5bf9\u8c61[%1$s]", (Object)objCtrl));
        }
        iPSSFLogicCodeObject = (IPSSFLogicCodeObject)objCtrl;
        IPSSFPubCode iPSSFPubCode = this.getPSSFStyle2().getPSSFPubCode("NONE", strCodeType, true);
        if (iPSSFPubCode == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strCodeType));
        }
        IPSSFLogicTempl iPSSFLogicTempl = this.getPSSFStyle2().getPSSFLogicTempl(iPSSFLogicCodeObject, iPSSFPubCode);
        if (iPSSFLogicTempl != null) {
            HashMap<String, Object> params2 = new HashMap<String, Object>();
            params2.putAll(params);
            IPSSFLogicCodePublisher2 iPSSFLogicCodePublisher = (IPSSFLogicCodePublisher2)iPSSFLogicTempl.getPSSFLogicCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSSFLogicCodePublisher.generateCode(this.getContext(), iPSSFLogicCodeObject, params);
            iPSSFLogicCodePublisher.close();
            return iPSGenerateCodeResult;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u903b\u8f91[%1$s][%2$s][%3$s]\u4ee3\u7801\u6a21\u677f", (Object)iPSSFLogicCodeObject.getSFLogicCodeCat(), (Object)iPSSFLogicCodeObject.getSFLogicCodeType(), (Object)iPSSFPubCode.getName()));
    }

    public abstract IPSSFStyle2 getPSSFStyle2();

    protected IPSGenerateCodeResult internalGetHelpCode(Object objCtrl, String strCodeType, Map<String, Object> params) throws Exception {
        if (this.getPSSFStyle2() == null) {
            throw new Exception("\u5f53\u524d\u6a21\u677f\u4e0d\u652f\u6301\u6b64\u65b9\u6cd5");
        }
        IPSSFHelpCodeObject iPSSFHelpCodeObject = null;
        if (!(objCtrl instanceof IPSSFHelpCodeObject)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5e2e\u52a9\u4ee3\u7801\u5bf9\u8c61[%1$s]", (Object)objCtrl));
        }
        iPSSFHelpCodeObject = (IPSSFHelpCodeObject)objCtrl;
        IPSSFPubCode iPSSFPubCode = this.getPSSFStyle2().getPSSFPubCode("NONE", strCodeType, true);
        if (iPSSFPubCode == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strCodeType));
        }
        IPSSFHelpTempl iPSSFHelpTempl = this.getPSSFStyle2().getPSSFHelpTempl(iPSSFHelpCodeObject, iPSSFPubCode);
        if (iPSSFHelpTempl != null) {
            HashMap<String, Object> params2 = new HashMap<String, Object>();
            params2.putAll(params);
            IPSSFHelpCodePublisher2 iPSSFHelpCodePublisher = (IPSSFHelpCodePublisher2)iPSSFHelpTempl.getPSSFHelpCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSSFHelpCodePublisher.generateCode(this.getContext(), iPSSFHelpCodeObject, params);
            iPSSFHelpCodePublisher.close();
            return iPSGenerateCodeResult;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e2e\u52a9[%1$s][%2$s][%3$s]\u4ee3\u7801\u6a21\u677f", (Object)iPSSFHelpCodeObject.getSFHelpCodeCat(), (Object)iPSSFHelpCodeObject.getSFHelpCodeType(), (Object)iPSSFPubCode.getName()));
    }
}

