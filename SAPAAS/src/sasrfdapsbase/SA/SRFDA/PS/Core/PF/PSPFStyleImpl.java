/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyleCode;
import SA.SRFDA.PS.Core.PF.IPSPFStylePkg;
import SA.SRFDA.PS.Core.PF.IPSPFStylePrj;
import SA.SRFDA.PS.Core.PF.IPSPFUIActionTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PF.PSPFAppTemplGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFCtrlTemplDetailProxy;
import SA.SRFDA.PS.Core.PF.PSPFCtrlTemplGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Core.PF.PSPFStyleCodeGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFStyleEditorTemplGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFStylePkgGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFStylePrjGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFUIActionTemplGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFViewLogicTemplGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFViewTemplGlobalModel;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSPFStyle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStyleImpl
extends PSPFObjectImpl
implements IPSPFStyle {
    private static final Log log = LogFactory.getLog(PSPFStyleImpl.class);
    protected PSPFStyle psPFStyle = null;
    protected HashMap<String, ArrayList<IPSPFViewTempl>> psPFViewTemplMap = new HashMap();
    protected HashMap<String, ArrayList<IPSPFCtrlTempl>> psPFCtrlTemplMap = new HashMap();
    protected HashMap<String, ArrayList<IPSPFAppTempl>> psPFAppTemplMap = new HashMap();
    protected PSPFStyleCodeGlobalModel psPFStyleCodeGlobalModel = new PSPFStyleCodeGlobalModel();
    protected PSPFViewTemplGlobalModel psPFViewTemplGlobalModel = new PSPFViewTemplGlobalModel();
    protected PSPFCtrlTemplGlobalModel psPFCtrlTemplGlobalModel = new PSPFCtrlTemplGlobalModel();
    protected PSPFViewLogicTemplGlobalModel psPFViewLogicTemplGlobalModel = new PSPFViewLogicTemplGlobalModel();
    protected PSPFUIActionTemplGlobalModel psPFUIActionTemplGlobalModel = new PSPFUIActionTemplGlobalModel();
    protected PSPFStylePrjGlobalModel psPFStylePrjGlobalModel = new PSPFStylePrjGlobalModel();
    protected PSPFAppTemplGlobalModel psPFAppTemplGlobalModel = new PSPFAppTemplGlobalModel();
    protected PSPFStyleEditorTemplGlobalModel psPFEditorTemplGlobalModel = new PSPFStyleEditorTemplGlobalModel();
    protected HashMap<String, PSPFCtrlTemplDetailProxy> psPFCtrlTemplDetailProxyMap = new HashMap();
    private String strTemplPSPFStyleId = "";
    private IPSPFStyle templPSPFStyle = null;
    protected PSPFStylePkgGlobalModel psPFStylePkgGlobalModel = new PSPFStylePkgGlobalModel();
    protected ArrayList<IPSPFPkgVer> psPFPkgVerList = new ArrayList();
    private String strTemplDocRootUrl = null;
    private String strResourceUrl = null;
    private String strVersionString = "";
    private Properties classPkgParamsMap = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFStyle psPFStyle) throws Exception {
        this.psPFStyle = psPFStyle;
        this.setPSPF(iPSPF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFStyle.getPSPFSTYLEID());
        this.setName(this.psPFStyle.getPSPFSTYLENAME());
        this.setPSObjectData(this.psPFStyle);
        if (!this.psPFStyle.isVERSIONNull()) {
            this.setVersion(this.psPFStyle.getVERSION());
        } else {
            this.setVersion(1);
        }
        this.strVersionString = this.psPFStyle.getVERSTR();
        this.classPkgParamsMap = PropertiesHelper.Load((String)this.psPFStyle.getCLSPKGPARAMS());
        this.strTemplPSPFStyleId = this.psPFStyle.getTEMPLPSPFSTYLEID();
        this.strTemplDocRootUrl = this.psPFStyle.getTEMPLROOTURL();
        this.strResourceUrl = this.psPFStyle.getSTYLERESURL();
        if (StringHelper.IsNullOrEmpty((String)this.strTemplDocRootUrl) && this.getTemplPSPFStyle() != null) {
            this.strTemplDocRootUrl = this.getTemplPSPFStyle().getTemplDocRootUrl();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strVersionString) && this.getTemplPSPFStyle() != null) {
            this.strVersionString = this.getTemplPSPFStyle().getVersionString();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strResourceUrl) && this.getTemplPSPFStyle() != null) {
            this.strResourceUrl = this.getTemplPSPFStyle().getResourceUrl();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.psPFStylePkgGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFViewTemplGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFStylePrjGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFStyleCodeGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFCtrlTemplGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFUIActionTemplGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFViewLogicTemplGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFAppTemplGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFEditorTemplGlobalModel.Init(this.getDAGlobalHelper(), this);
        super.onInit();
        this.getPSPFStyleCodes();
        this.preparePSPFPkgVers();
    }

    protected void preparePSPFPkgVers() throws Exception {
        HashMap<String, IPSPFPkgVer> psPFPkgVerMap = new HashMap<String, IPSPFPkgVer>();
        if (this.getTemplPSPFStyle() != null && this.getTemplPSPFStyle().getPSPFPkgVers() != null) {
            Iterator<IPSPFPkgVer> psPFPkgVers = this.getTemplPSPFStyle().getPSPFPkgVers();
            while (psPFPkgVers.hasNext()) {
                IPSPFPkgVer iPSPFPkgVer = psPFPkgVers.next();
                psPFPkgVerMap.put(iPSPFPkgVer.getPSPFPkg().getId(), iPSPFPkgVer);
            }
        }
        Iterator<IPSPFStylePkg> psPFStylePkgs = this.getPSPFStylePkgs();
        while (psPFStylePkgs.hasNext()) {
            IPSPFStylePkg iPSPFStylePkg = psPFStylePkgs.next();
            IPSPFPkgVer iPSPFPkgVer = iPSPFStylePkg.getPSPFPkgVer();
            psPFPkgVerMap.put(iPSPFPkgVer.getPSPFPkg().getId(), iPSPFPkgVer);
        }
        this.psPFPkgVerList.addAll(psPFPkgVerMap.values());
        Collections.sort(this.psPFPkgVerList, new Comparator<IPSPFPkgVer>(){

            @Override
            public int compare(IPSPFPkgVer arg0, IPSPFPkgVer arg1) {
                int nRet = arg0.getOrderValue() - arg1.getOrderValue();
                if (nRet == 0) {
                    return 0;
                }
                if (nRet > 0) {
                    return 1;
                }
                return -1;
            }
        });
    }

    @Override
    public String getStyleCode() {
        return this.psPFStyle.getSTYLECODE();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator<IPSPFViewTempl> getPSPFViewTempls(IPSAppView iPSAppView) throws Exception {
        HashMap<String, ArrayList<IPSPFViewTempl>> hashMap = this.psPFViewTemplMap;
        synchronized (hashMap) {
            ArrayList<IPSPFViewTempl> list = this.psPFViewTemplMap.get(iPSAppView.getViewType());
            if (list != null) {
                return list.iterator();
            }
            list = new ArrayList();
            Iterator<IPSPFPubCode> psPFPubCodes = this.iPSPF.getPSPFPubCodes("VIEW");
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                IPSPFViewTempl iPSPFViewTempl = this.getPSPFViewTempl(iPSAppView.getPSViewType(), iPSPFPubCode);
                if (iPSPFViewTempl == null) {
                    log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s/%2$s/%3$s/%4$s]\u4ee3\u7801\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)this.getName(), (Object)iPSAppView.getViewType(), (Object)iPSPFPubCode.getName()));
                    continue;
                }
                list.add(iPSPFViewTempl);
            }
            this.psPFViewTemplMap.put(iPSAppView.getViewType(), list);
            return list.iterator();
        }
    }

    @Override
    public IPSPFViewTempl getPSPFViewTempl(IPSViewType iPSViewType, IPSPFPubCode iPSPFPubCode) throws Exception {
        IPSPFStyle templPSPFStyle;
        String strPSPFViewTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSViewType.getId(), (String)iPSPFPubCode.getId());
        IPSPFViewTempl iPSPFViewTempl = this.getPSPFViewTempl(strPSPFViewTemplId, true);
        if (iPSPFViewTempl == null && (templPSPFStyle = this.getTemplPSPFStyle()) != null) {
            return templPSPFStyle.getPSPFViewTempl(iPSViewType, iPSPFPubCode);
        }
        return iPSPFViewTempl;
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl(IPSControlType iPSControlType, IPSPFPubCode iPSPFPubCode) throws Exception {
        IPSPFStyle templPSPFStyle;
        String strPSPFCtrlTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSControlType.getId(), (String)iPSPFPubCode.getId());
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
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6[%1$s]\u6a21\u677f[%2$s]\u6210\u5458[%3$s]", (Object)iPSControlType.getName(), (Object)iPSPFPubCode.getName(), (Object)strDetailName));
    }

    @Override
    public IPSPFUIActionTempl getPSPFUIActionTempl(IPSUIAction iPSUIAction, IPSPFPubCode iPSPFPubCode) throws Exception {
        IPSPFStyle templPSPFStyle;
        IPSPFUIActionTempl iPSPFUIActionTempl;
        String strPSPFUIActionTemplId = "";
        IPSDEUIAction iPSDEUIAction = null;
        if (iPSUIAction instanceof IPSDEUIAction) {
            iPSDEUIAction = (IPSDEUIAction)iPSUIAction;
        }
        if (iPSDEUIAction != null) {
            strPSPFUIActionTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSDEUIAction.getPSSysDEUIActionId(null), (String)iPSPFPubCode.getId());
        }
        if ((iPSPFUIActionTempl = this.getPSPFUIActionTempl(strPSPFUIActionTemplId, true)) == null && (templPSPFStyle = this.getTemplPSPFStyle()) != null) {
            return templPSPFStyle.getPSPFUIActionTempl(iPSUIAction, iPSPFPubCode);
        }
        return iPSPFUIActionTempl;
    }

    @Override
    public IPSPFViewLogicTempl getPSPFViewLogicTempl(IPSViewLogicType iPSViewLogicType, IPSPFPubCode iPSPFPubCode) throws Exception {
        IPSPFStyle templPSPFStyle;
        String strPSViewLogicTypeId = null;
        strPSViewLogicTypeId = iPSViewLogicType == null ? "VIEW_DELOGIC" : iPSViewLogicType.getId();
        String strPSPFViewLogicTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strPSViewLogicTypeId, (String)iPSPFPubCode.getId());
        IPSPFViewLogicTempl iPSPFViewLogicTempl = this.getPSPFViewLogicTempl(strPSPFViewLogicTemplId, true);
        if (iPSPFViewLogicTempl == null && (templPSPFStyle = this.getTemplPSPFStyle()) != null) {
            return templPSPFStyle.getPSPFViewLogicTempl(iPSViewLogicType, iPSPFPubCode);
        }
        return iPSPFViewLogicTempl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator<IPSPFAppTempl> getPSPFAppTempls(IPSApplication iPSApplication) throws Exception {
        HashMap<String, ArrayList<IPSPFAppTempl>> hashMap = this.psPFAppTemplMap;
        synchronized (hashMap) {
            ArrayList<IPSPFAppTempl> list = this.psPFAppTemplMap.get("");
            if (list != null) {
                return list.iterator();
            }
            list = new ArrayList();
            Iterator<IPSPFPubCode> psPFPubCodes = this.iPSPF.getPSPFPubCodes("APP");
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                IPSPFAppTempl iPSPFAppTempl = this.getPSPFAppTempl(iPSPFPubCode);
                if (iPSPFAppTempl == null) {
                    log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s/%2$s/%3$s]\u4ee3\u7801\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)this.getName(), (Object)iPSPFPubCode.getName()));
                    continue;
                }
                list.add(iPSPFAppTempl);
            }
            this.psPFAppTemplMap.put("", list);
            return list.iterator();
        }
    }

    @Override
    public IPSPFAppTempl getPSPFAppTempl(IPSPFPubCode iPSPFPubCode) throws Exception {
        IPSPFStyle templPSPFStyle;
        String strPSPFAppTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSPFPubCode.getId());
        IPSPFAppTempl iPSPFAppTempl = this.getPSPFAppTempl(strPSPFAppTemplId, true);
        if (iPSPFAppTempl == null && (templPSPFStyle = this.getTemplPSPFStyle()) != null) {
            return templPSPFStyle.getPSPFAppTempl(iPSPFPubCode);
        }
        return iPSPFAppTempl;
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorType iPSEditorType, String strContainerType, IPSPFPubCode iPSPFPubCode) throws Exception {
        String strPSPFEditorTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSEditorType.getId(), (String)strContainerType, (String)iPSPFPubCode.getId());
        IPSPFEditorTempl iPSPFEditorTempl = this.getPSPFEditorTempl(strPSPFEditorTemplId, true);
        if (iPSPFEditorTempl != null) {
            return iPSPFEditorTempl;
        }
        if (!iPSEditorType.isStandardEditor() && !StringHelper.IsNullOrEmpty((String)iPSEditorType.getStandardPSEditorType()) && (iPSPFEditorTempl = this.getPSPFEditorTempl(strPSPFEditorTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSEditorType.getStandardPSEditorType(), (String)strContainerType, (String)iPSPFPubCode.getId()), true)) != null) {
            return iPSPFEditorTempl;
        }
        IPSPFStyle templPSPFStyle = this.getTemplPSPFStyle();
        if (templPSPFStyle != null) {
            return templPSPFStyle.getPSPFEditorTempl(iPSEditorType, strContainerType, iPSPFPubCode);
        }
        try {
            strPSPFEditorTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)iPSEditorType.getId(), (String)strContainerType, (String)iPSPFPubCode.getId());
            iPSPFEditorTempl = this.getPSPF().getPSPFEditorTempl(strPSPFEditorTemplId, !iPSEditorType.isStandardEditor());
            if (iPSPFEditorTempl != null) {
                return iPSPFEditorTempl;
            }
            strPSPFEditorTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)iPSEditorType.getStandardPSEditorType(), (String)strContainerType, (String)iPSPFPubCode.getId());
            iPSPFEditorTempl = this.getPSPF().getPSPFEditorTempl(strPSPFEditorTemplId);
            return iPSPFEditorTempl;
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.Format((String)"\u524d\u7aef\u5e94\u7528\u67b6\u6784[%1$s]\u4e0d\u5b58\u5728\u7f16\u8f91\u5668[%2$s][%3$s-%4$s]\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)iPSEditorType.getStandardPSEditorType(), (Object)strContainerType, (Object)iPSPFPubCode.getName()));
        }
    }

    @Override
    public IPSPFStyleCode getPSPFStyleCode(String strPSPFStyleCodeId, boolean bTryMode) throws Exception {
        return (IPSPFStyleCode)this.psPFStyleCodeGlobalModel.FindModelHelper(strPSPFStyleCodeId, bTryMode);
    }

    @Override
    public Iterator<IPSPFStyleCode> getPSPFStyleCodes() throws Exception {
        return this.psPFStyleCodeGlobalModel.getAllModelHelpers();
    }

    @Override
    public String replacePFStyleCode(String strCode) throws Exception {
        int i = 0;
        while (i < 10) {
            boolean bChanged = false;
            Iterator<IPSPFStyleCode> psPFStyleCodes = this.getPSPFStyleCodes();
            while (psPFStyleCodes.hasNext()) {
                IPSPFStyleCode iPSPFStyleCode = psPFStyleCodes.next();
                String strTag = StringHelper.Format((String)"<#SRFINC(%1$s)>", (Object)iPSPFStyleCode.getName().toUpperCase());
                if (strCode.indexOf(strTag) == -1) continue;
                strCode = strCode.replace(strTag, iPSPFStyleCode.getStyleCode());
                bChanged = true;
            }
            if (!bChanged) break;
            ++i;
        }
        if (this.getTemplPSPFStyle() != null) {
            return this.getTemplPSPFStyle().replacePFStyleCode(strCode);
        }
        return strCode;
    }

    @Override
    public String getPFStyleParams() {
        return this.psPFStyle.getPFSTYLEPARAM();
    }

    @Override
    public IPSPFViewTempl getPSPFViewTempl(String strPFViewTemplId) throws Exception {
        return (IPSPFViewTempl)this.psPFViewTemplGlobalModel.FindModelHelper(strPFViewTemplId);
    }

    @Override
    public IPSPFViewTempl getPSPFViewTempl(String strPFViewTemplId, boolean bTryMode) throws Exception {
        return (IPSPFViewTempl)this.psPFViewTemplGlobalModel.FindModelHelper(strPFViewTemplId, bTryMode);
    }

    @Override
    public void resetPSPFViewTempl(String strPFViewTemplId) throws Exception {
        this.psPFViewTemplGlobalModel.ResetModel(strPFViewTemplId);
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u6837\u5f0f", hideempty=true)
    public IPSPFStyle getTemplPSPFStyle() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.strTemplPSPFStyleId)) {
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
                throw new Exception(StringHelper.Format((String)"\u524d\u7aef\u5e94\u7528\u6846\u67b6[%1$s]\u6837\u5f0f[%2$s]\u6a21\u677f\u6837\u5f0f\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getPSPF().getName(), (Object)this.getName()));
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
                        log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s/%2$s/%3$s/%4$s]\u4ee3\u7801\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)this.getName(), (Object)iPSControl.getPSControlType().getId(), (Object)iPSPFPubCode.getName()));
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
                    log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s/%2$s/%3$s/%4$s]\u4ee3\u7801\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)this.getName(), (Object)iPSControl.getPSControlType().getId(), (Object)iPSPFPubCode.getName()));
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
        return (IPSPFCtrlTempl)this.psPFCtrlTemplGlobalModel.FindModelHelper(strPFCtrlTemplId);
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl(String strPFCtrlTemplId, boolean bTryMode) throws Exception {
        return (IPSPFCtrlTempl)this.psPFCtrlTemplGlobalModel.FindModelHelper(strPFCtrlTemplId, bTryMode);
    }

    @Override
    public void resetPSPFCtrlTempl(String strPFCtrlTemplId) throws Exception {
        this.psPFCtrlTemplGlobalModel.ResetModel(strPFCtrlTemplId);
    }

    @Override
    public IPSPFUIActionTempl getPSPFUIActionTempl(String strPFUIActionTemplId) throws Exception {
        return (IPSPFUIActionTempl)this.psPFUIActionTemplGlobalModel.FindModelHelper(strPFUIActionTemplId);
    }

    @Override
    public IPSPFUIActionTempl getPSPFUIActionTempl(String strPFUIActionTemplId, boolean bTryMode) throws Exception {
        return (IPSPFUIActionTempl)this.psPFUIActionTemplGlobalModel.FindModelHelper(strPFUIActionTemplId, bTryMode);
    }

    @Override
    public void resetPSPFUIActionTempl(String strPFUIActionTemplId) throws Exception {
        this.psPFUIActionTemplGlobalModel.ResetModel(strPFUIActionTemplId);
    }

    @Override
    public IPSPFViewLogicTempl getPSPFViewLogicTempl(String strPFViewLogicTemplId, boolean bTryMode) throws Exception {
        return (IPSPFViewLogicTempl)this.psPFViewLogicTemplGlobalModel.FindModelHelper(strPFViewLogicTemplId, bTryMode);
    }

    @Override
    public void resetPSPFViewLogicTempl(String strPFViewLogicTemplId) throws Exception {
        this.psPFViewLogicTemplGlobalModel.ResetModel(strPFViewLogicTemplId);
    }

    @Override
    public IPSPFAppTempl getPSPFAppTempl(String strPFAppTemplId) throws Exception {
        return (IPSPFAppTempl)this.psPFAppTemplGlobalModel.FindModelHelper(strPFAppTemplId);
    }

    @Override
    public IPSPFAppTempl getPSPFAppTempl(String strPFAppTemplId, boolean bTryMode) throws Exception {
        return (IPSPFAppTempl)this.psPFAppTemplGlobalModel.FindModelHelper(strPFAppTemplId, bTryMode);
    }

    @Override
    public void resetPSPFAppTempl(String strPFAppTemplId) throws Exception {
        this.psPFAppTemplGlobalModel.ResetModel(strPFAppTemplId);
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(String strPFEditorTemplId) throws Exception {
        return (IPSPFEditorTempl)this.psPFEditorTemplGlobalModel.FindModelHelper(strPFEditorTemplId);
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(String strPFEditorTemplId, boolean bTryMode) throws Exception {
        return (IPSPFEditorTempl)this.psPFEditorTemplGlobalModel.FindModelHelper(strPFEditorTemplId, bTryMode);
    }

    @Override
    public void resetPSPFEditorTempl(String strPFEditorTemplId) throws Exception {
        this.psPFEditorTemplGlobalModel.ResetModel(strPFEditorTemplId);
    }

    @Override
    public IPSPFStylePrj getPSPFStylePrj(String strPSPFStylePrjId, boolean bTryMode) throws Exception {
        IPSPFStyle templPSPFStyle = this.getTemplPSPFStyle();
        if (templPSPFStyle != null) {
            return templPSPFStyle.getPSPFStylePrj(strPSPFStylePrjId, bTryMode);
        }
        return (IPSPFStylePrj)this.psPFStylePrjGlobalModel.FindModelHelper(strPSPFStylePrjId, bTryMode);
    }

    @Override
    public Iterator<IPSPFStylePrj> getPSPFStylePrjs() throws Exception {
        IPSPFStyle templPSPFStyle = this.getTemplPSPFStyle();
        if (templPSPFStyle != null) {
            return templPSPFStyle.getPSPFStylePrjs();
        }
        return this.psPFStylePrjGlobalModel.getAllModelHelpers();
    }

    @Override
    public String getPSDevCenterName() {
        return this.psPFStyle.getPSDEVCENTERNAME();
    }

    @Override
    public String getPSDevCenterId() {
        return this.psPFStyle.getPSDEVCENTERID();
    }

    @Override
    public Iterator<IPSPFStylePkg> getPSPFStylePkgs() throws Exception {
        return this.psPFStylePkgGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSPFPkgVer> getPSPFPkgVers() throws Exception {
        return this.psPFPkgVerList.iterator();
    }

    @Override
    public String getTemplDocRootUrl() {
        return this.strTemplDocRootUrl;
    }

    @Override
    public String getResourceUrl() {
        return this.strResourceUrl;
    }

    @Override
    public String getModelType() {
        return "PSPFSTYLE";
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
        return PropertiesHelper.GetProperty((Properties)this.classPkgParamsMap, (String)strParamName, (String)strDefault);
    }

    @Override
    public int getStyleParam(String strParamName, int nDefault) {
        if (this.templPSPFStyle != null) {
            nDefault = this.templPSPFStyle.getStyleParam(strParamName, nDefault);
        }
        return PropertiesHelper.GetProperty((Properties)this.classPkgParamsMap, (String)strParamName, (int)nDefault);
    }

    @Override
    public boolean isEnableGetPSObjectParam() {
        return true;
    }

    @Override
    public IPSPFCodeFolder getPSPFCodeFolder(String strPFCodeFolderId) throws Exception {
        return this.getPSPF().getPSPFCodeFolder(strPFCodeFolderId);
    }

    @Override
    public void resetPSPFCodeFolder(String strPFCodeFolderId) throws Exception {
        this.getPSPF().resetPSPFCodeFolder(strPFCodeFolderId);
    }

    @Override
    public IPSPFPubCode getPSPFPubCode(String strPFPubCodeId) throws Exception {
        return this.getPSPF().getPSPFPubCode(strPFPubCodeId);
    }

    @Override
    public IPSPFPubCode getPSPFPubCode(String strPFPubCodeId, boolean bTryMode) throws Exception {
        return this.getPSPF().getPSPFPubCode(strPFPubCodeId, bTryMode);
    }

    @Override
    public Iterator<IPSPFPubCode> getPSPFPubCodes(String strTargetType, boolean bTryMode) throws Exception {
        return this.getPSPF().getPSPFPubCodes(strTargetType, bTryMode);
    }

    @Override
    public Iterator<IPSPFPubCode> getPSPFPubCodes(String strTargetType) throws Exception {
        return this.getPSPF().getPSPFPubCodes(strTargetType, false);
    }

    @Override
    public boolean isAutoNameOrCode() {
        return this.getPFEngineVer() >= 20;
    }

    @Override
    public boolean isSystemFieldReadonlyDefault() {
        return this.getPFEngineVer() >= 20;
    }

    @Override
    public boolean isEnableEditorStyleCode() {
        return this.getPFEngineVer() >= 20;
    }

    @Override
    public boolean isRegisterToContainer() {
        return this.getPFEngineVer() >= 20;
    }

    @Override
    public String getTemplInfo() {
        return this.psPFStyle.getTEMPLINFO();
    }

    @Override
    public int getPFEngineVer() {
        int nPFEngineVer = this.getPSPF().getPFEngineVer();
        if (nPFEngineVer != 0) {
            return nPFEngineVer;
        }
        return 10;
    }

    @Override
    public String getResLocalPath() {
        return null;
    }
}

