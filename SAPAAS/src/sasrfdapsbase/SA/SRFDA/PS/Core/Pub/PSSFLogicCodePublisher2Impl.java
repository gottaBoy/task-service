/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFLogicCodePublisher2;
import SA.SRFDA.PS.Core.Pub.IPSSFLogicCodePublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFLogicPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSSFCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Data.PSSFLogicTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFLogicCodePublisher2Impl
extends PSSFCodePublisher2Impl
implements IPSSFLogicCodePublisher2 {
    private static final Log log = LogFactory.getLog(PSSFLogicCodePublisher2Impl.class);
    public static final int MAXKEYCOUNT = 5000;
    protected IPSSFLogicTempl iPSSFLogicTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    private IPSSFPubCode2 iPSSFPubCode2 = null;
    private Object logicObj = null;
    private HashMap<String, String> keyMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFLogicTempl iPSSFLogicTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSFLogicTempl = iPSSFLogicTempl;
        this.iPSSFPubCode2 = (IPSSFPubCode2)this.iPSSFLogicTempl.getPSSFPubCode();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, Object obj) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
    }

    @Override
    protected void onClose() {
        this.iPSPublisherContext = null;
        this.logicObj = null;
        this.keyMap.clear();
        super.onClose();
        if (this.iPSSFLogicTempl != null) {
            this.iPSSFLogicTempl.releasePSSFLogicCodePublisher(this);
        }
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, Object object, Map<String, Object> params) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        this.logicObj = object;
        this.keyMap.clear();
        return this.onGenerateCode(object, params);
    }

    protected PSGenerateCodeResultImpl onGenerateCode(Object object, Map<String, Object> params2) throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(object);
        final HashMap<String, Object> params = new HashMap<String, Object>();
        if (params2 != null) {
            params.putAll(params2);
        }
        this.keyMap.clear();
        this.onFillGenerateCodeParams(params);
        params.put("item", object);
        params.put("P", new IPSSFLogicCodePublisherContext(){

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSSFLogicCodePublisher2Impl.this.internalGetLogicCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart, String strCodeType) throws Exception {
                return PSSFLogicCodePublisher2Impl.this.internalGetPartCode(objPart, strCodeType, params);
            }

            @Override
            public boolean hasPartCode(Object objPart) throws Exception {
                return PSSFLogicCodePublisher2Impl.this.internalTestPartCode(objPart);
            }

            @Override
            public boolean exists(String strType) {
                return this.exists(strType, "", "");
            }

            @Override
            public boolean exists(String strType, String strParam) {
                return this.exists(strType, strParam, "");
            }

            @Override
            public boolean exists(String strType, String strParam, String strParam2) {
                return PSSFLogicCodePublisher2Impl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSSFLogicCodePublisher2Impl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSSFLogicCodePublisher2Impl.this.internalGet(strParam, strDefault);
            }

            @Override
            public String get(String strParam) {
                return this.get(strParam, null);
            }
        });
        params.put("publisher", params.get("P"));
        PSSFLogicTempl psSFLogicTempl = this.iPSSFLogicTempl.getPSSFLogicTemplData();
        if (!StringHelper.IsNullOrEmpty((String)psSFLogicTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psSFLogicTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psSFLogicTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psSFLogicTempl, "TEMPLCODE2", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psSFLogicTempl.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((BaseDataEntity)psSFLogicTempl, "TEMPLCODE3", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psSFLogicTempl.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((BaseDataEntity)psSFLogicTempl, "TEMPLCODE4", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    @Override
    public IPSSFStyle2 getPSSFStyle2() {
        return (IPSSFStyle2)this.iPSSFLogicTempl.getPSSFStyle();
    }

    protected IPSGenerateCodeResult internalGetPartCode(Object objPart, String strCodeType, Map<String, Object> params) throws Exception {
        Object objItem = objPart;
        HashMap<String, Object> params2 = new HashMap<String, Object>();
        params2.putAll(params);
        IPSSFLogicPartCodePublisher iPSSFLogicPartCodePublisher = this.getPSSFLogicTempl().getPSSFLogicTemplDetail(strCodeType).getPSSFLogicPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSSFLogicPartCodePublisher.generateCode(this.iPSPublisherContext, this, this.logicObj, objItem, params2);
        iPSSFLogicPartCodePublisher.close();
        return iPSGenerateCodeResult;
    }

    protected boolean internalTestPartCode(Object objPart) throws Exception {
        if (objPart instanceof String) {
            return this.getPSSFLogicTempl().getPSSFLogicTemplDetail((String)objPart, true) != null;
        }
        return this.getPSSFLogicTempl().getPSSFLogicTemplDetail(objPart.toString(), true) != null;
    }

    public IPSSFLogicTempl2 getPSSFLogicTempl() {
        return (IPSSFLogicTempl2)this.iPSSFLogicTempl;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

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
        String strKey = KeyValueHelper.genUniqueId((String)"_PARAMTYPE_", (String)strParam, null);
        if (!this.keyMap.containsKey(strKey) && this.keyMap.size() > 5000) {
            log.error((Object)StringHelper.Format((String)"\u91cd\u590d\u9879\u9650\u5236\u8d85\u51fa\u9650\u5236[%1$s]", (Object)5000));
            return false;
        }
        this.keyMap.put(strKey, strValue);
        return true;
    }

    protected String internalGet(String strParam, String strDefault) {
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

