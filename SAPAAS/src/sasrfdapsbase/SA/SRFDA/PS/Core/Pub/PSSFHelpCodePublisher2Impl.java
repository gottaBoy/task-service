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
import SA.SRFDA.PS.Core.Pub.IPSSFHelpCodePublisher2;
import SA.SRFDA.PS.Core.Pub.IPSSFHelpCodePublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFHelpPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSSFCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Data.PSSFHelpTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFHelpCodePublisher2Impl
extends PSSFCodePublisher2Impl
implements IPSSFHelpCodePublisher2 {
    private static final Log log = LogFactory.getLog(PSSFHelpCodePublisher2Impl.class);
    public static final int MAXKEYCOUNT = 5000;
    protected IPSSFHelpTempl iPSSFHelpTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    private IPSSFPubCode2 iPSSFPubCode2 = null;
    private Object logicObj = null;
    private HashMap<String, String> keyMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFHelpTempl iPSSFHelpTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSFHelpTempl = iPSSFHelpTempl;
        this.iPSSFPubCode2 = (IPSSFPubCode2)this.iPSSFHelpTempl.getPSSFPubCode();
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
        if (this.iPSSFHelpTempl != null) {
            this.iPSSFHelpTempl.releasePSSFHelpCodePublisher(this);
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
        params.put("P", new IPSSFHelpCodePublisherContext(){

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSSFHelpCodePublisher2Impl.this.internalGetLogicCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getHelpCode(Object objCtrl, String strCodeType) throws Exception {
                return PSSFHelpCodePublisher2Impl.this.internalGetHelpCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart, String strCodeType) throws Exception {
                return PSSFHelpCodePublisher2Impl.this.internalGetPartCode(objPart, strCodeType, params);
            }

            @Override
            public boolean hasPartCode(Object objPart) throws Exception {
                return PSSFHelpCodePublisher2Impl.this.internalTestPartCode(objPart);
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
                return PSSFHelpCodePublisher2Impl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSSFHelpCodePublisher2Impl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSSFHelpCodePublisher2Impl.this.internalGet(strParam, strDefault);
            }

            @Override
            public String get(String strParam) {
                return this.get(strParam, null);
            }
        });
        params.put("publisher", params.get("P"));
        PSSFHelpTempl psSFHelpTempl = this.iPSSFHelpTempl.getPSSFHelpTemplData();
        if (!StringHelper.IsNullOrEmpty((String)psSFHelpTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psSFHelpTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psSFHelpTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psSFHelpTempl, "TEMPLCODE2", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psSFHelpTempl.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((BaseDataEntity)psSFHelpTempl, "TEMPLCODE3", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psSFHelpTempl.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((BaseDataEntity)psSFHelpTempl, "TEMPLCODE4", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    @Override
    public IPSSFStyle2 getPSSFStyle2() {
        return (IPSSFStyle2)this.iPSSFHelpTempl.getPSSFStyle();
    }

    protected IPSGenerateCodeResult internalGetPartCode(Object objPart, String strCodeType, Map<String, Object> params) throws Exception {
        Object objItem = objPart;
        HashMap<String, Object> params2 = new HashMap<String, Object>();
        params2.putAll(params);
        IPSSFHelpPartCodePublisher iPSSFHelpPartCodePublisher = this.getPSSFHelpTempl().getPSSFHelpTemplDetail(strCodeType).getPSSFHelpPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSSFHelpPartCodePublisher.generateCode(this.iPSPublisherContext, this, this.logicObj, objItem, params2);
        iPSSFHelpPartCodePublisher.close();
        return iPSGenerateCodeResult;
    }

    protected boolean internalTestPartCode(Object objPart) throws Exception {
        if (objPart instanceof String) {
            return this.getPSSFHelpTempl().getPSSFHelpTemplDetail((String)objPart, true) != null;
        }
        return this.getPSSFHelpTempl().getPSSFHelpTemplDetail(objPart.toString(), true) != null;
    }

    public IPSSFHelpTempl2 getPSSFHelpTempl() {
        return (IPSSFHelpTempl2)this.iPSSFHelpTempl;
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

