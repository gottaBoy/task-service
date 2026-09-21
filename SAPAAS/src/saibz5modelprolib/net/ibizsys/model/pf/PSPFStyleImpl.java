/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Version
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlType
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import javax.persistence.Version;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.entity.PSPFStyle;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pf.IPSPFStyleRuntime;
import net.ibizsys.model.pf.PSPFCtrlTemplDetailProxy;
import net.ibizsys.model.pf.PSPFCtrlTemplGlobalModel;
import net.ibizsys.model.pf.PSPFObjectImpl;
import net.ibizsys.model.pf.PSPFStyleEditorTemplGlobalModel;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStyleImpl
extends PSPFObjectImpl
implements IPSPFStyleRuntime {
    private static final Log log = LogFactory.getLog(PSPFStyleImpl.class);
    protected PSPFStyle psPFStyle = null;
    protected HashMap<String, ArrayList<IPSPFCtrlTempl>> psPFCtrlTemplMap = new HashMap();
    protected PSPFCtrlTemplGlobalModel psPFCtrlTemplGlobalModel = new PSPFCtrlTemplGlobalModel();
    protected PSPFStyleEditorTemplGlobalModel psPFEditorTemplGlobalModel = new PSPFStyleEditorTemplGlobalModel();
    protected HashMap<String, PSPFCtrlTemplDetailProxy> psPFCtrlTemplDetailProxyMap = new HashMap();
    private String strTemplPSPFStyleId = "";
    private IPSPFStyle templPSPFStyle = null;
    private String strTemplDocRootUrl = null;
    private String strResourceUrl = null;
    private String strVersionString = "";
    private Properties classPkgParamsMap = null;
    private int nVersion = 0;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPF iPSPF, PSPFStyle psPFStyle) throws Exception {
        this.psPFStyle = psPFStyle;
        this.setPSPF(iPSPF);
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(this.psPFStyle.getPSPFSTYLEID());
        this.setName(this.psPFStyle.getPSPFSTYLENAME());
        this.setPSObjectData(this.psPFStyle);
        this.setVersion(this.psPFStyle.getVERSION());
        this.strVersionString = this.psPFStyle.getVERSTR();
        this.classPkgParamsMap = PropertiesHelper.load((String)this.psPFStyle.getCLSPKGPARAMS());
        this.strTemplPSPFStyleId = this.psPFStyle.getTEMPLPSPFSTYLEID();
        this.strTemplDocRootUrl = this.psPFStyle.getTEMPLROOTURL();
        this.strResourceUrl = this.psPFStyle.getSTYLERESURL();
        if (StringHelper.isNullOrEmpty((String)this.strVersionString) && this.getTemplPSPFStyle() != null) {
            this.strVersionString = this.getTemplPSPFStyle().getVersionString();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.psPFCtrlTemplGlobalModel.init(this.getPSModelStorageContext(), this);
        this.psPFEditorTemplGlobalModel.init(this.getPSModelStorageContext(), this);
        super.onInit();
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl(IPSControlType iPSControlType, IPSPFPubCode iPSPFPubCode) throws Exception {
        IPSPFStyle templPSPFStyle;
        String strPSPFCtrlTemplId = KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSControlType.getId(), (String)iPSPFPubCode.getId());
        IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(strPSPFCtrlTemplId, true);
        if (iPSPFCtrlTempl == null && (templPSPFStyle = this.getTemplPSPFStyle()) != null) {
            return templPSPFStyle.getPSPFCtrlTempl(iPSControlType, iPSPFPubCode);
        }
        return iPSPFCtrlTempl;
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(IPSControlType iPSControlType, IPSPFPubCode iPSPFPubCode, String strDetailName) throws Exception {
        return this.getPSPFCtrlTemplDetail(iPSControlType, iPSPFPubCode, strDetailName, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(IPSControlType iPSControlType, IPSPFPubCode iPSPFPubCode, String strDetailName, boolean bTryMode) throws Exception {
        IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail = null;
        IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(iPSControlType, iPSPFPubCode);
        if (iPSPFCtrlTempl != null && (iPSPFCtrlTemplDetail = iPSPFCtrlTempl.getPSPFCtrlTemplDetail2(strDetailName, true)) != null) {
            return iPSPFCtrlTemplDetail;
        }
        IPSPFStyle templPSPFStyle = this.getTemplPSPFStyle();
        if (templPSPFStyle != null) {
            String strUniqueKey = KeyValueHelper.genUniqueId((String)iPSControlType.getId(), (String)iPSPFPubCode.getId(), (String)strDetailName);
            HashMap<String, PSPFCtrlTemplDetailProxy> hashMap = this.psPFCtrlTemplDetailProxyMap;
            synchronized (hashMap) {
                iPSPFCtrlTemplDetail = this.psPFCtrlTemplDetailProxyMap.get(strUniqueKey);
            }
            if (iPSPFCtrlTemplDetail != null) {
                return iPSPFCtrlTemplDetail;
            }
            IPSPFCtrlTempl iPSPFCtrlTempl2 = templPSPFStyle.getPSPFCtrlTempl(iPSControlType, iPSPFPubCode);
            if (iPSPFCtrlTempl2 != null && iPSPFCtrlTempl2 != iPSPFCtrlTempl) {
                iPSPFCtrlTemplDetail = iPSPFCtrlTempl2.getPSPFCtrlTemplDetail2(strDetailName, true);
            }
            if (iPSPFCtrlTemplDetail != null) {
                PSPFCtrlTemplDetailProxy psPFCtrlTemplDetailProxy = new PSPFCtrlTemplDetailProxy();
                psPFCtrlTemplDetailProxy.proxy(iPSPFCtrlTempl, iPSPFCtrlTemplDetail);
                HashMap<String, PSPFCtrlTemplDetailProxy> hashMap2 = this.psPFCtrlTemplDetailProxyMap;
                synchronized (hashMap2) {
                    this.psPFCtrlTemplDetailProxyMap.put(strUniqueKey, psPFCtrlTemplDetailProxy);
                }
                return psPFCtrlTemplDetailProxy;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6[%1$s]\u6a21\u677f[%2$s]\u6210\u5458[%3$s]", (Object)iPSControlType.getName(), (Object)iPSPFPubCode.getName(), (Object)strDetailName));
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorType iPSEditorType, String strContainerType, IPSPFPubCode iPSPFPubCode) throws Exception {
        String strPSPFEditorTemplId = KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSEditorType.getId(), (String)strContainerType, (String)iPSPFPubCode.getId());
        IPSPFEditorTempl iPSPFEditorTempl = this.getPSPFEditorTempl(strPSPFEditorTemplId, true);
        if (iPSPFEditorTempl != null) {
            return iPSPFEditorTempl;
        }
        if (!iPSEditorType.isStandardEditor() && !StringHelper.isNullOrEmpty((String)iPSEditorType.getStandardPSEditorType()) && (iPSPFEditorTempl = this.getPSPFEditorTempl(strPSPFEditorTemplId = KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSEditorType.getStandardPSEditorType(), (String)strContainerType, (String)iPSPFPubCode.getId()), true)) != null) {
            return iPSPFEditorTempl;
        }
        IPSPFStyle templPSPFStyle = this.getTemplPSPFStyle();
        if (templPSPFStyle != null) {
            return templPSPFStyle.getPSPFEditorTempl(iPSEditorType, strContainerType, iPSPFPubCode);
        }
        try {
            strPSPFEditorTemplId = KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)iPSEditorType.getId(), (String)strContainerType, (String)iPSPFPubCode.getId());
            iPSPFEditorTempl = this.getPSPF().getPSPFEditorTempl(strPSPFEditorTemplId, !iPSEditorType.isStandardEditor());
            if (iPSPFEditorTempl != null) {
                return iPSPFEditorTempl;
            }
            strPSPFEditorTemplId = KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)iPSEditorType.getStandardPSEditorType(), (String)strContainerType, (String)iPSPFPubCode.getId());
            iPSPFEditorTempl = this.getPSPF().getPSPFEditorTempl(strPSPFEditorTemplId);
            return iPSPFEditorTempl;
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u524d\u7aef\u5e94\u7528\u67b6\u6784[%1$s]\u4e0d\u5b58\u5728\u7f16\u8f91\u5668[%2$s][%3$s-%4$s]\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)iPSEditorType.getStandardPSEditorType(), (Object)strContainerType, (Object)iPSPFPubCode.getName()));
        }
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u6837\u5f0f", hideempty=true)
    public IPSPFStyle getTemplPSPFStyle() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strTemplPSPFStyleId)) {
            return null;
        }
        if (this.templPSPFStyle != null) {
            return this.templPSPFStyle;
        }
        boolean bClose = false;
        try {
            ActionSession actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSPFStyleImpl");
                actionSession.registerRecursion("PSPFSTYLE", (Object)this.getId());
            } else if (!actionSession.registerRecursion("PSPFSTYLE", (Object)this.getId())) {
                throw new Exception(StringHelper.format((String)"\u524d\u7aef\u5e94\u7528\u6846\u67b6[%1$s]\u6837\u5f0f[%2$s]\u6a21\u677f\u6837\u5f0f\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getPSPF().getName(), (Object)this.getName()));
            }
            this.templPSPFStyle = this.getPSPF().getPSPFStyle(this.strTemplPSPFStyleId);
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            return this.templPSPFStyle;
        }
        catch (Exception ex) {
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean hasPSPFCtrlTempls(IPSControl iPSControl) throws Exception {
        HashMap<String, ArrayList<IPSPFCtrlTempl>> hashMap = this.psPFCtrlTemplMap;
        synchronized (hashMap) {
            ArrayList<IPSPFCtrlTempl> list = this.psPFCtrlTemplMap.get(iPSControl.getPSControlType().getId());
            if (list != null) {
                return list.size() > 0;
            }
            list = new ArrayList();
            Iterator<IPSPFPubCode> psPFPubCodes = this.iPSPF.getPSPFPubCodes("VIEWCTRL", true);
            if (psPFPubCodes != null) {
                while (psPFPubCodes.hasNext()) {
                    IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                    IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(iPSControl.getPSControlType(), iPSPFPubCode);
                    if (iPSPFCtrlTempl == null) {
                        log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s/%2$s/%3$s/%4$s]\u4ee3\u7801\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)this.getName(), (Object)iPSControl.getPSControlType().getId(), (Object)iPSPFPubCode.getName()));
                        continue;
                    }
                    list.add(iPSPFCtrlTempl);
                }
            }
            this.psPFCtrlTemplMap.put(iPSControl.getPSControlType().getId(), list);
            return list.size() > 0;
        }
    }

    @Override
    public boolean hasPSPFCtrlTempls(IPSControl iPSControl, String strPubCode) throws Exception {
        IPSPFPubCode iPSPFPubCode = this.getPSPF().getPSPFPubCode(strPubCode);
        IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(iPSControl.getPSControlType(), iPSPFPubCode);
        return iPSPFCtrlTempl != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator<IPSPFCtrlTempl> getPSPFCtrlTempls(IPSControl iPSControl) throws Exception {
        HashMap<String, ArrayList<IPSPFCtrlTempl>> hashMap = this.psPFCtrlTemplMap;
        synchronized (hashMap) {
            ArrayList<IPSPFCtrlTempl> list = this.psPFCtrlTemplMap.get(iPSControl.getPSControlType().getId());
            if (list != null) {
                return list.iterator();
            }
            list = new ArrayList();
            Iterator<IPSPFPubCode> psPFPubCodes = this.iPSPF.getPSPFPubCodes("VIEWCTRL");
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(iPSControl.getPSControlType(), iPSPFPubCode);
                if (iPSPFCtrlTempl == null) {
                    log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s/%2$s/%3$s/%4$s]\u4ee3\u7801\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)this.getName(), (Object)iPSControl.getPSControlType().getId(), (Object)iPSPFPubCode.getName()));
                    continue;
                }
                list.add(iPSPFCtrlTempl);
            }
            this.psPFCtrlTemplMap.put(iPSControl.getPSControlType().getId(), list);
            return list.iterator();
        }
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl(String strPFCtrlTemplId) throws Exception {
        return (IPSPFCtrlTempl)this.psPFCtrlTemplGlobalModel.findModelHelper(strPFCtrlTemplId);
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl(String strPFCtrlTemplId, boolean bTryMode) throws Exception {
        return (IPSPFCtrlTempl)this.psPFCtrlTemplGlobalModel.findModelHelper(strPFCtrlTemplId, bTryMode);
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
    public String getVersionString() {
        return this.strVersionString;
    }

    @Override
    public String getStyleParam(String strParamName, String strDefault) {
        if (this.templPSPFStyle != null) {
            strDefault = this.templPSPFStyle.getStyleParam(strParamName, strDefault);
        }
        return PropertiesHelper.getProperty((Properties)this.classPkgParamsMap, (String)strParamName, (String)strDefault);
    }

    @Override
    public int getStyleParam(String strParamName, int nDefault) {
        if (this.templPSPFStyle != null) {
            nDefault = this.templPSPFStyle.getStyleParam(strParamName, nDefault);
        }
        return PropertiesHelper.getProperty((Properties)this.classPkgParamsMap, (String)strParamName, (int)nDefault);
    }

    protected void setVersion(int nVersion) {
        this.nVersion = nVersion;
    }

    @Override
    @Version
    public int getVersion() {
        return this.nVersion;
    }

    @Override
    public String getPSDevCenterId() {
        return this.psPFStyle.getPSDEVCENTERID();
    }

    @Override
    public String getPFStyleParams() {
        return this.psPFStyle.getPFSTYLEPARAM();
    }
}

