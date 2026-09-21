/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTemplDetail;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSPFViewLogicTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewLogicPartCodePublisher2Impl
extends PSPFCodePublisher2Impl
implements IPSPFViewLogicPartCodePublisher {
    private static final Log log = LogFactory.getLog(PSPFViewLogicPartCodePublisher2Impl.class);
    protected IPSPFViewLogicTemplDetail iPSPFViewLogicTemplDetail = null;
    private IPSPFViewLogicCodePublisher iPSPFViewLogicCodePublisher = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected Object object = null;
    private Object logicObj = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFViewLogicTemplDetail iPSPFViewLogicTemplDetail) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSPFViewLogicTemplDetail = iPSPFViewLogicTemplDetail;
        this.setPSPFPubCode(this.iPSPFViewLogicTemplDetail.getPSPFPubCode());
        this.onInit();
    }

    protected IPSPFViewLogicTempl getPSPFViewLogicTempl() {
        return this.iPSPFViewLogicTemplDetail.getPSPFViewLogicTempl();
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
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSPFViewLogicCodePublisher iPSPFViewLogicCodePublisher, Object logicObj, Object object, Map<String, Object> params) throws Exception {
        this.object = object;
        this.logicObj = logicObj;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSPFViewLogicCodePublisher = iPSPFViewLogicCodePublisher;
        this.beforeGenerateCode();
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
        params.put("item", this.object);
        params.put("logic", this.logicObj);
        this.onFillGenerateCodeParams(params);
        params.put("P", new IPSPFViewLogicCodePublisherContext(){

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart, String strCodeType) throws Exception {
                return PSPFViewLogicPartCodePublisher2Impl.this.internalGetPartCode(objPart, strCodeType, params);
            }

            @Override
            public boolean hasPartCode(Object objPart) throws Exception {
                return PSPFViewLogicPartCodePublisher2Impl.this.internalTestPartCode(objPart);
            }

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFViewLogicPartCodePublisher2Impl.this.internalGetLogicCode(objCtrl, strCodeType, params);
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
                return PSPFViewLogicPartCodePublisher2Impl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSPFViewLogicPartCodePublisher2Impl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSPFViewLogicPartCodePublisher2Impl.this.internalGet(strParam, strDefault);
            }

            @Override
            public String get(String strParam) {
                return this.get(strParam, null);
            }
        });
        params.put("publisher", params.get("P"));
        PSPFViewLogicTemplDetail psPFViewLogicTemplDetail = this.iPSPFViewLogicTemplDetail.getPSPFViewLogicTemplDetailData();
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTemplDetail.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTemplDetail, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTemplDetail.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTemplDetail, "TEMPLCODE2", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTemplDetail.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTemplDetail, "TEMPLCODE3", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTemplDetail.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTemplDetail, "TEMPLCODE4", params));
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
        this.iPSPFViewLogicCodePublisher = null;
        this.onClose();
        if (this.iPSPFViewLogicTemplDetail != null) {
            this.iPSPFViewLogicTemplDetail.releasePSPFViewLogicPartCodePublisher(this);
        }
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }

    protected IPSGenerateCodeResult internalGetPartCode(Object objPart, String strCodeType, Map<String, Object> params) throws Exception {
        if (this.iPSPFViewLogicCodePublisher == null) {
            throw new Exception("\u90e8\u4ef6\u4ee3\u7801\u53d1\u5e03\u5668\u5bf9\u8c61\u65e0\u6548");
        }
        Object objItem = objPart;
        HashMap<String, Object> params2 = new HashMap<String, Object>();
        params2.putAll(params);
        IPSPFViewLogicPartCodePublisher iPSPFViewLogicPartCodePublisher = this.iPSPFViewLogicTemplDetail.getPSPFViewLogicTempl().getPSPFViewLogicTemplDetail(strCodeType).getPSPFViewLogicPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFViewLogicPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSPFViewLogicCodePublisher, this.logicObj, objItem, params2);
        iPSPFViewLogicPartCodePublisher.close();
        return iPSGenerateCodeResult;
    }

    protected boolean internalTestPartCode(Object objPart) throws Exception {
        if (objPart instanceof String) {
            return this.iPSPFViewLogicTemplDetail.getPSPFViewLogicTempl().getPSPFViewLogicTemplDetail((String)objPart, true) != null;
        }
        return this.iPSPFViewLogicTemplDetail.getPSPFViewLogicTempl().getPSPFViewLogicTemplDetail(objPart.toString(), true) != null;
    }

    @Override
    public IPSPFStyle2 getPSPFStyle2() {
        return (IPSPFStyle2)this.iPSPFViewLogicTemplDetail.getPSPFViewLogicTempl().getPSPFStyle();
    }
}

