/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.entity.PSSysPFPlugin;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFPluginTempl;
import net.ibizsys.model.pf.IPSPFPluginTemplRuntime;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pub.util.PSTemplHelper;
import net.ibizsys.model.res.IPSSysPFPluginRuntime;
import net.ibizsys.model.res.IPSSysPFPluginTempl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPFPluginImpl
extends PSSystemObjectImpl
implements IPSSysPFPluginRuntime {
    private static final Log log = LogFactory.getLog(PSSysPFPluginImpl.class);
    protected PSSysPFPlugin psSysPFPlugin = null;
    private String strCodeName = "";
    private String strPFPluginTag = "";
    private ThreadLocal<Integer> currentThreadCallCount = new ThreadLocal();
    private String strPSPFPluginId = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysPFPlugin psSysPFPlugin) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psSysPFPlugin = psSysPFPlugin;
            this.setId(this.psSysPFPlugin.getPSSYSPFPLUGINID());
            this.setName(this.psSysPFPlugin.getPSSYSPFPLUGINNAME());
            this.setPSObjectData(this.psSysPFPlugin);
            this.strPFPluginTag = this.psSysPFPlugin.getPLUGINTAG();
            if (StringHelper.isNullOrEmpty((String)this.strPFPluginTag)) {
                this.strPFPluginTag = String.valueOf(psSysPFPlugin.getPLUGINTYPE()) + KeyValueHelper.genUniqueId((String)this.psSysPFPlugin.getPSSYSPFPLUGINID()).substring(0, 10);
            }
            this.strPSPFPluginId = this.psSysPFPlugin.getPSPFPLUGINID();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPFPluginType() {
        return this.psSysPFPlugin.getPLUGINTYPE();
    }

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String strPSPFId) throws Exception {
        return this.getPSPFPluginTempl(strPSPFId, "", false);
    }

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String strPSPFId, String strPSPFPubCodeId, boolean bTryMode) throws Exception {
        try {
            IPSSysPFPluginTempl iPSPFPluginTempl;
            String strPSPFPluginTemplId = null;
            if (!StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
                strPSPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strPSPFId, (String)strPSPFPubCodeId);
                iPSPFPluginTempl = this.getPSSystemRuntime().getPSSysPFPluginTempl(strPSPFPluginTemplId, true);
                if (iPSPFPluginTempl != null) {
                    return iPSPFPluginTempl;
                }
            }
            strPSPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strPSPFId);
            iPSPFPluginTempl = this.getPSSystemRuntime().getPSSysPFPluginTempl(strPSPFPluginTemplId, bTryMode || !StringHelper.isNullOrEmpty((String)this.getPSPFPluginId()));
            if (iPSPFPluginTempl != null) {
                return iPSPFPluginTempl;
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSPFPluginId())) {
                strPSPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSPFPluginId(), (String)strPSPFId);
                return this.getPSModelStorageContext().getPSPFPluginTempl(strPSPFPluginTemplId, bTryMode);
            }
            return iPSPFPluginTempl;
        }
        catch (Exception ex) {
            if (StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u5e94\u7528\u6846\u67b6\u63d2\u4ef6\u6a21\u677f[%1$s][%2$s]", (Object)this.getName(), (Object)strPSPFId), ex);
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u5e94\u7528\u6846\u67b6\u63d2\u4ef6\u6a21\u677f[%1$s][%2$s][%3$s]", (Object)this.getName(), (Object)strPSPFId, (Object)strPSPFPubCodeId), ex);
        }
    }

    @Override
    public String getCode(String strCodeType, String strPSPFId, String strPSPFStyleId, Object objView, Object objCtrl, Object objItem) throws Exception {
        try {
            this.logCallCount(1);
            IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(strPSPFId);
            HashMap<String, Object> params = new HashMap<String, Object>();
            if (objItem != null) {
                params.put("item", objItem);
            }
            if (objCtrl != null) {
                params.put("ctrl", objCtrl);
            }
            IPSAppView iPSAppView = null;
            if (objView != null && objView instanceof IPSAppView) {
                iPSAppView = (IPSAppView)objView;
                params.put("app", iPSAppView.getPSApplication());
                params.put("view", iPSAppView);
                params.put("sys", iPSAppView.getPSApplication().getPSSystem());
            }
            IPSPFStyle iPSPFStyle = null;
            IPSPF iPSPF = null;
            if (iPSAppView != null) {
                iPSPF = ((IPSApplicationRuntime)iPSAppView.getPSApplication()).getPSPF();
                if (!StringHelper.isNullOrEmpty((String)strPSPFStyleId)) {
                    iPSPFStyle = ((IPSApplicationRuntime)iPSAppView.getPSApplication()).getPSPFStyle(strPSPFStyleId);
                }
            } else {
                iPSPF = this.getPSModelStorageContext().getPSPF(strPSPFId);
                if (!StringHelper.isNullOrEmpty((String)strPSPFStyleId)) {
                    iPSPFStyle = iPSPF.getPSPFStyle(strPSPFStyleId);
                }
            }
            params.put("pf", iPSPF);
            if (iPSPFStyle != null) {
                params.put("pfstyle", iPSPFStyle);
            }
            String strCodeName = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType);
            String strCode = PSTemplHelper.generateCode((IEntity)((IPSPFPluginTemplRuntime)iPSPFPluginTempl).getPSPFPluginTemplData(iPSPFStyle), strCodeName, params);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    @Override
    public String getCode(String strCodeType, String strPSPFPubCodeId, String strPSPFId, String strPSPFStyleId, Object objView, Object objCtrl, Object objItem) throws Exception {
        try {
            this.logCallCount(1);
            IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(strPSPFId, strPSPFPubCodeId, false);
            HashMap<String, Object> params = new HashMap<String, Object>();
            if (objItem != null) {
                params.put("item", objItem);
            }
            if (objCtrl != null) {
                params.put("ctrl", objCtrl);
            }
            IPSAppView iPSAppView = null;
            if (objView != null && objView instanceof IPSAppView) {
                iPSAppView = (IPSAppView)objView;
                params.put("app", iPSAppView.getPSApplication());
                params.put("view", iPSAppView);
                params.put("sys", iPSAppView.getPSApplication().getPSSystem());
            }
            IPSPFStyle iPSPFStyle = null;
            IPSPF iPSPF = null;
            if (iPSAppView != null) {
                iPSPF = ((IPSApplicationRuntime)iPSAppView.getPSApplication()).getPSPF();
                if (!StringHelper.isNullOrEmpty((String)strPSPFStyleId)) {
                    iPSPFStyle = ((IPSApplicationRuntime)iPSAppView.getPSApplication()).getPSPFStyle(strPSPFStyleId);
                }
            } else {
                iPSPF = this.getPSModelStorageContext().getPSPF(strPSPFId);
                if (!StringHelper.isNullOrEmpty((String)strPSPFStyleId)) {
                    iPSPFStyle = iPSPF.getPSPFStyle(strPSPFStyleId);
                }
            }
            params.put("pf", iPSPF);
            if (iPSPFStyle != null) {
                params.put("pfstyle", iPSPFStyle);
            }
            String strCodeName = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType);
            String strCode = PSTemplHelper.generateCode((IEntity)((IPSPFPluginTemplRuntime)iPSPFPluginTempl).getPSPFPluginTemplData(iPSPFStyle), strCodeName, params);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    @Override
    public String getPFPluginTag() {
        return this.strPFPluginTag;
    }

    @Override
    public String getCode(String strCodeType) throws Exception {
        return this.getCode(strCodeType, "");
    }

    @Override
    public String getCode(String strCodeType, String strPSPFPubCodeId) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeType) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return "";
        }
        try {
            this.logCallCount(1);
            Map<String, Object> params = PSTemplHelper.getCurrentParams();
            if (params == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSPF iPSPF = null;
            IPSPFStyle iPSPFStyle = null;
            Object objPF = params.get("pf");
            Object objPFStyle = params.get("pfstyle");
            if (objPF != null && objPF instanceof IPSPF) {
                iPSPF = (IPSPF)objPF;
            }
            if (objPFStyle != null && objPFStyle instanceof IPSPFStyle) {
                iPSPFStyle = (IPSPFStyle)objPFStyle;
            }
            if (iPSPF == null || iPSPFStyle == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(iPSPF.getId(), strPSPFPubCodeId, false);
            String strCodeName = "";
            strCodeName = StringHelper.isNullOrEmpty((String)iPSPFPluginTempl.getPSPFPubCodeId()) ? StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType) : "TEMPLCODE";
            String strCode = PSTemplHelper.generateCode(((IPSPFPluginTemplRuntime)iPSPFPluginTempl).getPSPFPluginTemplData(iPSPFStyle), strCodeName);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    private void logCallCount(int nStep) throws Exception {
        Integer nValue = this.currentThreadCallCount.get();
        if (nValue == null) {
            if (nStep <= 0) {
                return;
            }
            nValue = 0;
        }
        if ((nValue = Integer.valueOf(nValue + nStep)) <= 0) {
            this.currentThreadCallCount.set(null);
        } else {
            if (nValue >= 3) {
                this.currentThreadCallCount.set(null);
                throw new Exception(StringHelper.format((String)"\u524d\u7aef\u5e94\u7528\u63d2\u4ef6[%1$s]\u5b58\u5728\u9012\u5f52\u8c03\u7528", (Object)this.getName()));
            }
            this.currentThreadCallCount.set(nValue);
        }
    }

    @Override
    public boolean hasCode(String strCodeType) throws Exception {
        return this.hasCode(strCodeType, "");
    }

    @Override
    public boolean hasCode(String strCodeType, String strPSPFPubCodeId) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeType) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return false;
        }
        Map<String, Object> params = PSTemplHelper.getCurrentParams();
        if (params == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        IPSPF iPSPF = null;
        IPSPFStyle iPSPFStyle = null;
        Object objPF = params.get("pf");
        Object objPFStyle = params.get("pfstyle");
        if (objPF != null && objPF instanceof IPSPF) {
            iPSPF = (IPSPF)objPF;
        }
        if (objPFStyle != null && objPFStyle instanceof IPSPFStyle) {
            iPSPFStyle = (IPSPFStyle)objPFStyle;
        }
        if (iPSPF == null || iPSPFStyle == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        boolean bTryMode = StringHelper.isNullOrEmpty((String)strCodeType);
        IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(iPSPF.getId(), strPSPFPubCodeId, true);
        if (iPSPFPluginTempl == null) {
            return false;
        }
        String strCodeName = "";
        strCodeName = StringHelper.isNullOrEmpty((String)iPSPFPluginTempl.getPSPFPubCodeId()) ? StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType) : "TEMPLCODE";
        String strCode = ((IPSPFPluginTemplRuntime)iPSPFPluginTempl).getPSPFPluginTemplData(iPSPFStyle).getParamStringValue(strCodeName, "");
        return !StringHelper.isNullOrEmpty((String)strCode);
    }

    @Override
    public boolean hasCode(String strCodeType, String strPSPFPubCodeId, String strPSPFId, String strPSPFStyleId) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeType) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return false;
        }
        Map<String, Object> params = PSTemplHelper.getCurrentParams();
        if (params == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        boolean bTryMode = StringHelper.isNullOrEmpty((String)strCodeType);
        IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(strPSPFId, strPSPFPubCodeId, true);
        if (iPSPFPluginTempl == null) {
            return false;
        }
        IPSPF iPSPF = this.getPSModelStorageContext().getPSPF(strPSPFId);
        IPSPFStyle iPSPFStyle = iPSPF.getPSPFStyle(strPSPFStyleId);
        String strCodeName = "";
        strCodeName = StringHelper.isNullOrEmpty((String)iPSPFPluginTempl.getPSPFPubCodeId()) ? StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType) : "TEMPLCODE";
        String strCode = ((IPSPFPluginTemplRuntime)iPSPFPluginTempl).getPSPFPluginTemplData(iPSPFStyle).getParamStringValue(strCodeName, "");
        return !StringHelper.isNullOrEmpty((String)strCode);
    }

    @Override
    public boolean hasCode2(String strPSPFPubCodeId) throws Exception {
        return this.hasCodeX(strPSPFPubCodeId, "TEMPLCODE2");
    }

    @Override
    public boolean hasCode3(String strPSPFPubCodeId) throws Exception {
        return this.hasCodeX(strPSPFPubCodeId, "TEMPLCODE3");
    }

    @Override
    public boolean hasCode4(String strPSPFPubCodeId) throws Exception {
        return this.hasCodeX(strPSPFPubCodeId, "TEMPLCODE4");
    }

    @Override
    public String getCode2(String strPSPFPubCodeId) throws Exception {
        return this.getCodeX(strPSPFPubCodeId, "TEMPLCODE2");
    }

    @Override
    public String getCode3(String strPSPFPubCodeId) throws Exception {
        return this.getCodeX(strPSPFPubCodeId, "TEMPLCODE3");
    }

    @Override
    public String getCode4(String strPSPFPubCodeId) throws Exception {
        return this.getCodeX(strPSPFPubCodeId, "TEMPLCODE4");
    }

    protected boolean hasCodeX(String strPSPFPubCodeId, String strCodeName) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeName) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return false;
        }
        Map<String, Object> params = PSTemplHelper.getCurrentParams();
        if (params == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        IPSPF iPSPF = null;
        IPSPFStyle iPSPFStyle = null;
        Object objPF = params.get("pf");
        Object objPFStyle = params.get("pfstyle");
        if (objPF != null && objPF instanceof IPSPF) {
            iPSPF = (IPSPF)objPF;
        }
        if (objPFStyle != null && objPFStyle instanceof IPSPFStyle) {
            iPSPFStyle = (IPSPFStyle)objPFStyle;
        }
        if (iPSPF == null || iPSPFStyle == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(iPSPF.getId(), strPSPFPubCodeId, true);
        if (iPSPFPluginTempl == null) {
            return false;
        }
        String strCode = ((IPSPFPluginTemplRuntime)iPSPFPluginTempl).getPSPFPluginTemplData(iPSPFStyle).getParamStringValue(strCodeName, "");
        return !StringHelper.isNullOrEmpty((String)strCode);
    }

    protected String getCodeX(String strPSPFPubCodeId, String strCodeName) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeName) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return "";
        }
        try {
            this.logCallCount(1);
            Map<String, Object> params = PSTemplHelper.getCurrentParams();
            if (params == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSPF iPSPF = null;
            IPSPFStyle iPSPFStyle = null;
            Object objPF = params.get("pf");
            Object objPFStyle = params.get("pfstyle");
            if (objPF != null && objPF instanceof IPSPF) {
                iPSPF = (IPSPF)objPF;
            }
            if (objPFStyle != null && objPFStyle instanceof IPSPFStyle) {
                iPSPFStyle = (IPSPFStyle)objPFStyle;
            }
            if (iPSPF == null || iPSPFStyle == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(iPSPF.getId(), strPSPFPubCodeId, false);
            String strCode = PSTemplHelper.generateCode(((IPSPFPluginTemplRuntime)iPSPFPluginTempl).getPSPFPluginTemplData(iPSPFStyle), strCodeName);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    @Override
    public String getPSPFPluginId() {
        return this.strPSPFPluginId;
    }
}

