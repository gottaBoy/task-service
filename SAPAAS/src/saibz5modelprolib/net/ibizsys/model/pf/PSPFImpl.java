/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.entity.PSPF;
import net.ibizsys.model.entity.PSPFPubCode;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.IPSPFRuntime;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pf.PSPFEditorTemplGlobalModel;
import net.ibizsys.model.pf.PSPFPubCodeImpl;
import net.ibizsys.model.pf.PSPFStyleGlobalModel;
import net.ibizsys.model.pf.PSPFStyleImpl;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.IPSPFEditorCodePublisher;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFImpl
extends PSObjectImpl
implements IPSPFRuntime {
    protected PSPF psPF = null;
    private static final Log log = LogFactory.getLog(PSPFImpl.class);
    protected PSPFStyleGlobalModel psPFStyleGlobalModel = new PSPFStyleGlobalModel();
    protected PSPFEditorTemplGlobalModel psPFEditorTemplGlobalModel = new PSPFEditorTemplGlobalModel();
    protected HashMap<String, ArrayList<IPSPFPubCode>> psPFPubCodesMap = new HashMap();
    protected HashMap<String, IPSPFPubCode> psPFPubCodeMap = new HashMap();
    public static final String DEFAULT_DOCURL = "http://www.ibizsys.net";
    private IPSPFPubCode iDynaViewPSPFPubCode = null;
    private IPSPFPubCode iDynaModelPSPFPubCode = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSPF psPF) throws Exception {
        this.psPF = psPF;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psPF.getPSPFID());
        this.setName(psPF.getPSPFNAME());
        this.setPSObjectData(this.psPF);
        this.onPreparePSPFPubCodes();
        this.psPFEditorTemplGlobalModel.init(this.getPSModelStorageContext(), this);
        this.psPFStyleGlobalModel.init(this.getPSModelStorageContext(), this);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onPreparePSPFPubCodes() throws Exception {
        HashMap<String, ArrayList<IPSPFPubCode>> hashMap = this.psPFPubCodesMap;
        synchronized (hashMap) {
            this.psPFPubCodesMap.clear();
            this.psPFPubCodeMap.clear();
            Vector<PSPFPubCode> psPFPubCodeList = new Vector<PSPFPubCode>();
            CallResult callResullt = this.getPSModelQueryHelper().getPSPFPubCodes(this.getId(), psPFPubCodeList);
            if (callResullt.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u6280\u672f\u53d1\u5e03\u4ee3\u7801\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResullt.getErrorInfo()));
            }
            for (PSPFPubCode psPFPubCode : psPFPubCodeList) {
                if (!psPFPubCode.isVALIDFLAGNull() && !psPFPubCode.getVALIDFLAG() || !StringHelper.isNullOrEmpty((String)psPFPubCode.getPPSPFPUBCODEID())) continue;
                PSPFPubCodeImpl iPSPFPubCode = new PSPFPubCodeImpl();
                iPSPFPubCode.init(this.getPSModelStorageContext(), this, null, psPFPubCode);
                ArrayList<IPSPFPubCode> list = this.psPFPubCodesMap.get(iPSPFPubCode.getTargetType());
                if (list == null) {
                    list = new ArrayList();
                    this.psPFPubCodesMap.put(iPSPFPubCode.getTargetType(), list);
                }
                list.add(iPSPFPubCode);
                this.psPFPubCodeMap.put(iPSPFPubCode.getId(), iPSPFPubCode);
                if (!StringHelper.isNullOrEmpty((String)iPSPFPubCode.getName())) {
                    this.psPFPubCodeMap.put(iPSPFPubCode.getName(), iPSPFPubCode);
                }
                if (iPSPFPubCode.isDynaViewPubCode()) {
                    this.iDynaViewPSPFPubCode = iPSPFPubCode;
                }
                if (!iPSPFPubCode.isDynaModelPubCode()) continue;
                this.iDynaModelPSPFPubCode = iPSPFPubCode;
            }
        }
    }

    @Override
    public IPSPFStyle getPSPFStyle(String strPFStyleId) throws Exception {
        IPSPFStyle iPSPFStyle = (IPSPFStyle)this.psPFStyleGlobalModel.findModelHelper(strPFStyleId);
        return iPSPFStyle;
    }

    @Override
    public String getFormLayoutMode() {
        return this.psPF.getFORMLAYOUTMODE();
    }

    @Override
    public String getPSAppViewPageUrl(IPSAppView iPSAppView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSAppViewBackendUrl(IPSAppView iPSAppView) throws Exception {
        return StringHelper.format((String)"../%1$s/%2$s/%3$s.do?", (Object)iPSAppView.getPSApplication().getPKGCodeName(), (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)((IPSAppViewRuntime)iPSAppView).getCodeName());
    }

    @Override
    public String getPSAppViewPageUrl(IPSAppView iPSAppView, Map<String, String> params) throws Exception {
        return this.getPSAppViewPageUrl(iPSAppView);
    }

    @Override
    public String getPSAppViewBackendUrl(IPSAppView iPSAppView, Map<String, String> params) throws Exception {
        String strUrlParams = "";
        if (params != null) {
            strUrlParams = WebUtility.getQueryString(params);
        }
        if (StringHelper.isNullOrEmpty((String)strUrlParams)) {
            return StringHelper.format((String)"../%1$s/%2$s/%3$s.do?", (Object)iPSAppView.getPSApplication().getPKGCodeName(), (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)((IPSAppViewRuntime)iPSAppView).getCodeName());
        }
        return StringHelper.format((String)"../%1$s/%2$s/%3$s.do?%4$s", (Object)iPSAppView.getPSApplication().getPKGCodeName(), (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)((IPSAppViewRuntime)iPSAppView).getCodeName(), (Object)strUrlParams);
    }

    @Override
    public IPSPFCtrlCodePublisher createPSPFCtrlCodePublisher() throws Exception {
        return (IPSPFCtrlCodePublisher)this.getPSModelStorageContext().createObject(this.psPF.getCTRLPUBOBJ());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFPubCode getPSPFPubCode(String strPFPubCodeId) throws Exception {
        HashMap<String, ArrayList<IPSPFPubCode>> hashMap = this.psPFPubCodesMap;
        synchronized (hashMap) {
            IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(strPFPubCodeId);
            if (iPSPFPubCode == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strPFPubCodeId));
            }
            return iPSPFPubCode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFPubCode getPSPFPubCode(String strPFPubCodeId, boolean bTryMode) throws Exception {
        HashMap<String, ArrayList<IPSPFPubCode>> hashMap = this.psPFPubCodesMap;
        synchronized (hashMap) {
            IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(strPFPubCodeId);
            if (iPSPFPubCode == null && !bTryMode) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801[%1$s]", (Object)strPFPubCodeId));
            }
            return iPSPFPubCode;
        }
    }

    @Override
    public IPSPFCtrlPartCodePublisher createPSPFCtrlPartCodePublisher() throws Exception {
        return (IPSPFCtrlPartCodePublisher)this.getPSModelStorageContext().createObject(this.psPF.getCTRLPARTPUBOBJ());
    }

    @Override
    public IPSPFEditorCodePublisher createPSPFEditorCodePublisher() throws Exception {
        return (IPSPFEditorCodePublisher)this.getPSModelStorageContext().createObject(this.psPF.getEDITORPUBOBJ());
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(String strPFEditorTemplId) throws Exception {
        return (IPSPFEditorTempl)this.psPFEditorTemplGlobalModel.findModelHelper(strPFEditorTemplId);
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(String strPFEditorTemplId, boolean bTryMode) throws Exception {
        return (IPSPFEditorTempl)this.psPFEditorTemplGlobalModel.findModelHelper(strPFEditorTemplId, bTryMode);
    }

    @Override
    public Iterator<IPSPFPubCode> getPSPFPubCodes(String strTargetType) throws Exception {
        ArrayList<IPSPFPubCode> list = this.psPFPubCodesMap.get(strTargetType);
        if (list == null) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u76ee\u6807[%1$s]\u53d1\u5e03\u4ee3\u7801", (Object)strTargetType));
        }
        return list.iterator();
    }

    @Override
    public Iterator<IPSPFPubCode> getPSPFPubCodes(String strTargetType, boolean bTryMode) throws Exception {
        ArrayList<IPSPFPubCode> list = this.psPFPubCodesMap.get(strTargetType);
        if (list == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u76ee\u6807[%1$s]\u53d1\u5e03\u4ee3\u7801", (Object)strTargetType));
        }
        return list.iterator();
    }

    @Override
    public IPSPFStyle createPSPFStyle() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psPF.getSTYLEOBJ())) {
            return new PSPFStyleImpl();
        }
        return (IPSPFStyle)this.getPSModelStorageContext().createObject(this.psPF.getSTYLEOBJ());
    }

    @Override
    public IPSPFPubCode getDynaViewPSPFPubCode() {
        return this.iDynaViewPSPFPubCode;
    }

    @Override
    public IPSPFPubCode getDynaModelPSPFPubCode() {
        return this.iDynaModelPSPFPubCode;
    }
}

