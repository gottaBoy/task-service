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
import SA.SRFDA.PS.Core.Pub.IPSSFDBCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSSFDBCodePublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFDBPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSSFCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.PSSFDBCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.SF.IPSSFDBTempl;
import SA.SRFDA.PS.Core.SF.IPSSFDBTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Data.PSSFDBTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFDBPartCodePublisher2Impl
extends PSSFCodePublisher2Impl
implements IPSSFDBPartCodePublisher {
    private static final Log log = LogFactory.getLog(PSSFDBCodePublisher2Impl.class);
    public static final int MAXKEYCOUNT = 5000;
    protected IPSSFDBTemplDetail iPSSFDBTemplDetail = null;
    private IPSSFDBCodePublisher iPSSFDBCodePublisher = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected Object object = null;
    private Object logicObj = null;
    private IPSSFPubCode iPSSFPubCode = null;
    private HashMap<String, String> keyMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFDBTemplDetail iPSSFDBTemplDetail) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSFDBTemplDetail = iPSSFDBTemplDetail;
        this.setPSSFPubCode(this.iPSSFDBTemplDetail.getPSSFPubCode());
        this.onInit();
    }

    protected void setPSSFPubCode(IPSSFPubCode iPSSFPubCode) {
        this.iPSSFPubCode = iPSSFPubCode;
    }

    protected IPSSFDBTempl getPSSFDBTempl() {
        return this.iPSSFDBTemplDetail.getPSSFDBTempl();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, Object logicObj, Object object) throws Exception {
        return this.generateCode(iPSPublisherContext, logicObj, object, null);
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, Object logicObj, Object object, Map<String, Object> params) throws Exception {
        return this.generateCode(iPSPublisherContext, null, logicObj, object, params);
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSSFDBCodePublisher iPSSFDBCodePublisher, Object logicObj, Object object, Map<String, Object> params) throws Exception {
        this.object = object;
        this.logicObj = logicObj;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSSFDBCodePublisher = iPSSFDBCodePublisher;
        this.keyMap.clear();
        if (params == null) {
            return this.onGenerateCode();
        }
        return this.onGenerateCode((HashMap)params);
    }

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        return this.onGenerateCode(null);
    }

    protected PSGenerateCodeResultImpl onGenerateCode(final Map<String, Object> params) throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.object);
        this.keyMap.clear();
        params.put("item", this.object);
        params.put("logic", this.logicObj);
        this.onFillGenerateCodeParams(params);
        params.put("P", new IPSSFDBCodePublisherContext(){

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart, String strCodeType) throws Exception {
                return PSSFDBPartCodePublisher2Impl.this.internalGetPartCode(objPart, strCodeType, params);
            }

            @Override
            public boolean hasPartCode(Object objPart) throws Exception {
                return PSSFDBPartCodePublisher2Impl.this.internalTestPartCode(objPart);
            }

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSSFDBPartCodePublisher2Impl.this.internalGetLogicCode(objCtrl, strCodeType, params);
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
                return PSSFDBPartCodePublisher2Impl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSSFDBPartCodePublisher2Impl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSSFDBPartCodePublisher2Impl.this.internalGet(strParam, strDefault);
            }

            @Override
            public String get(String strParam) {
                return this.get(strParam, null);
            }
        });
        params.put("publisher", params.get("P"));
        PSSFDBTemplDetail psSFDBTemplDetail = this.iPSSFDBTemplDetail.getPSSFDBTemplDetailData();
        if (!StringHelper.IsNullOrEmpty((String)psSFDBTemplDetail.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psSFDBTemplDetail, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psSFDBTemplDetail.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psSFDBTemplDetail, "TEMPLCODE2", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psSFDBTemplDetail.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((BaseDataEntity)psSFDBTemplDetail, "TEMPLCODE3", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psSFDBTemplDetail.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((BaseDataEntity)psSFDBTemplDetail, "TEMPLCODE4", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    protected void onFillGenerateCodeParams(Map<String, Object> params) throws Exception {
    }

    @Override
    public void close() {
        this.iPSPublisherContext = null;
        this.logicObj = null;
        this.object = null;
        this.iPSSFDBCodePublisher = null;
        this.keyMap.clear();
        this.onClose();
        if (this.iPSSFDBTemplDetail != null) {
            this.iPSSFDBTemplDetail.releasePSSFDBPartCodePublisher(this);
        }
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }

    protected IPSGenerateCodeResult internalGetPartCode(Object objPart, String strCodeType, Map<String, Object> params) throws Exception {
        if (this.iPSSFDBCodePublisher == null) {
            throw new Exception("\u90e8\u4ef6\u4ee3\u7801\u53d1\u5e03\u5668\u5bf9\u8c61\u65e0\u6548");
        }
        Object objItem = objPart;
        HashMap<String, Object> params2 = new HashMap<String, Object>();
        params2.putAll(params);
        IPSSFDBPartCodePublisher iPSSFDBPartCodePublisher = this.iPSSFDBTemplDetail.getPSSFDBTempl().getPSSFDBTemplDetail(strCodeType).getPSSFDBPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSSFDBPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSSFDBCodePublisher, this.logicObj, objItem, params2);
        iPSSFDBPartCodePublisher.close();
        return iPSGenerateCodeResult;
    }

    protected boolean internalTestPartCode(Object objPart) throws Exception {
        if (objPart instanceof String) {
            return this.iPSSFDBTemplDetail.getPSSFDBTempl().getPSSFDBTemplDetail((String)objPart, true) != null;
        }
        return this.iPSSFDBTemplDetail.getPSSFDBTempl().getPSSFDBTemplDetail(objPart.toString(), true) != null;
    }

    @Override
    public IPSSFStyle2 getPSSFStyle2() {
        return (IPSSFStyle2)this.iPSSFDBTemplDetail.getPSSFDBTempl().getPSSFStyle();
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

