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

import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl2;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher2;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewLogicCodePublisher2Impl
extends PSPFCodePublisher2Impl
implements IPSPFViewLogicCodePublisher2 {
    private static final Log log = LogFactory.getLog(PSPFViewLogicCodePublisher2Impl.class);
    protected IPSPFViewLogicTempl iPSPFViewLogicTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    private Object logicObj = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFViewLogicTempl iPSPFViewLogicTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSPFViewLogicTempl = iPSPFViewLogicTempl;
        this.setPSPFPubCode(this.iPSPFViewLogicTempl.getPSPFPubCode());
        this.onInit();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSAppViewLogic iPSAppViewLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
    }

    @Override
    protected void onClose() {
        this.iPSPublisherContext = null;
        this.logicObj = null;
        super.onClose();
        if (this.iPSPFViewLogicTempl != null) {
            this.iPSPFViewLogicTempl.releasePSPFViewLogicCodePublisher(this);
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
        this.beforeGenerateCode();
        return this.onGenerateCode(object, params);
    }

    protected PSGenerateCodeResultImpl onGenerateCode(Object object, Map<String, Object> params2) throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(object);
        final HashMap<String, Object> params = new HashMap<String, Object>();
        if (params2 != null) {
            params.putAll(params2);
        }
        this.onFillGenerateCodeParams(params);
        params.put("item", object);
        params.put("P", new IPSPFViewLogicCodePublisherContext(){

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSPFViewLogicCodePublisher2Impl.this.internalGetLogicCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart, String strCodeType) throws Exception {
                return PSPFViewLogicCodePublisher2Impl.this.internalGetPartCode(objPart, strCodeType, params);
            }

            @Override
            public boolean hasPartCode(Object objPart) throws Exception {
                return PSPFViewLogicCodePublisher2Impl.this.internalTestPartCode(objPart);
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
                return PSPFViewLogicCodePublisher2Impl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSPFViewLogicCodePublisher2Impl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSPFViewLogicCodePublisher2Impl.this.internalGet(strParam, strDefault);
            }

            @Override
            public String get(String strParam) {
                return this.get(strParam, null);
            }
        });
        params.put("publisher", params.get("P"));
        PSPFViewLogicTempl psPFViewLogicTempl = this.iPSPFViewLogicTempl.getPSPFViewLogicTemplData();
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTempl, "TEMPLCODE2", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTempl.getTEMPLCODE3())) {
            psGenerateCodeResultImpl.setCode3(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTempl, "TEMPLCODE3", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psPFViewLogicTempl.getTEMPLCODE4())) {
            psGenerateCodeResultImpl.setCode4(PSTemplHelper.generateCode((BaseDataEntity)psPFViewLogicTempl, "TEMPLCODE4", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    protected IPSGenerateCodeResult internalGetPartCode(Object objPart, String strCodeType, Map<String, Object> params) throws Exception {
        Object objItem = objPart;
        HashMap<String, Object> params2 = new HashMap<String, Object>();
        params2.putAll(params);
        IPSPFViewLogicPartCodePublisher iPSPFViewLogicPartCodePublisher = this.getPSPFViewLogicTempl().getPSPFViewLogicTemplDetail(strCodeType).getPSPFViewLogicPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFViewLogicPartCodePublisher.generateCode(this.iPSPublisherContext, this, this.logicObj, objItem, params2);
        iPSPFViewLogicPartCodePublisher.close();
        return iPSGenerateCodeResult;
    }

    protected boolean internalTestPartCode(Object objPart) throws Exception {
        if (objPart instanceof String) {
            return this.getPSPFViewLogicTempl().getPSPFViewLogicTemplDetail((String)objPart, true) != null;
        }
        return this.getPSPFViewLogicTempl().getPSPFViewLogicTemplDetail(objPart.toString(), true) != null;
    }

    @Override
    public IPSPFStyle2 getPSPFStyle2() {
        return (IPSPFStyle2)this.iPSPFViewLogicTempl.getPSPFStyle();
    }

    public IPSPFViewLogicTempl2 getPSPFViewLogicTempl() {
        return (IPSPFViewLogicTempl2)this.iPSPFViewLogicTempl;
    }
}

