/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.Data.WSPageTempl;
import SA.SRFDA.WS.Ctrl.Data.WSPageType;
import SA.SRFDA.WS.Ctrl.Data.WSWBType;
import SA.SRFDA.WS.Ctrl.Data.WSWebPart;
import SA.SRFDA.WS.Ctrl.Data.WSWebSite;
import SA.SRFDA.WS.Ctrl.IWSModelStorage;
import SA.SRFDA.WS.Ctrl.IWSPageHelper;
import SA.SRFDA.WS.Ctrl.IWSPageTemplHelper;
import SA.SRFDA.WS.Ctrl.IWSPageTypeHelper;
import SA.SRFDA.WS.Ctrl.IWSWBTypeHelper;
import SA.SRFDA.WS.Ctrl.IWSWebPartHelper;
import SA.SRFDA.WS.Ctrl.IWSWebSiteHelper;
import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSPageTemplHelper;
import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSWBTypeHelper;
import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSWebPartHelper;
import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSWebSiteHelper;
import SA.SRFDA.WS.Ctrl.WSPageTemplGlobalModel;
import SA.SRFDA.WS.Ctrl.WSPageTypeGlobalModel;
import SA.SRFDA.WS.Ctrl.WSPageTypeHelper;
import SA.SRFDA.WS.Ctrl.WSWBTypeGlobalModel;
import SA.SRFDA.WS.Ctrl.WSWebPartGlobalModel;
import SA.SRFDA.WS.Ctrl.WSWebSiteGlobalModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Hashtable;

public class WSModelStorage
implements IWSModelStorage {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected WSPageTypeGlobalModel wsPageTypeGlobalModel = new WSPageTypeGlobalModel();
    protected WSPageTemplGlobalModel wsPageTemplGlobalModel = new WSPageTemplGlobalModel();
    protected WSWBTypeGlobalModel wsWBTypeGlobalModel = new WSWBTypeGlobalModel();
    protected WSWebPartGlobalModel wsWebPartGlobalModel = new WSWebPartGlobalModel();
    protected WSWebSiteGlobalModel wsWebSiteGlobalModel = new WSWebSiteGlobalModel();
    protected Hashtable<String, IWSPageTypeHelper> wsPageTypeHelperMap = new Hashtable();
    protected Hashtable<String, IWSPageTemplHelper> wsPageTemplHelperMap = new Hashtable();
    protected Hashtable<String, IWSWBTypeHelper> wsWBTypeHelperMap = new Hashtable();
    protected Hashtable<String, IWSWebPartHelper> wsWebPartHelperMap = new Hashtable();
    protected Hashtable<String, IWSWebSiteHelper> wsWebSiteHelperMap = new Hashtable();
    protected Hashtable<String, IWSPageHelper> wsPageHelper = new Hashtable();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.wsPageTypeGlobalModel.Init(iDAGlobalHelper);
        this.wsWBTypeGlobalModel.Init(iDAGlobalHelper);
        this.wsWebSiteGlobalModel.Init(iDAGlobalHelper);
        this.wsPageTemplGlobalModel.Init(iDAGlobalHelper);
        this.wsWebPartGlobalModel.Init(iDAGlobalHelper);
        this.OnInit();
    }

    protected void OnInit() {
    }

    @Override
    public IWSPageTypeHelper FindWSPageTypeHelper(String strWSPageTypeId) throws Exception {
        WSPageType wsPageType = (WSPageType)((Object)this.wsPageTypeGlobalModel.FindModel(strWSPageTypeId));
        if (wsPageType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7f51\u7ad9\u9875\u9762\u7c7b\u578b[%1$s]", (Object)strWSPageTypeId));
        }
        IWSPageTypeHelper iWSPageTypeHelper = this.wsPageTypeHelperMap.get(strWSPageTypeId);
        if (iWSPageTypeHelper != null) {
            return iWSPageTypeHelper;
        }
        iWSPageTypeHelper = this.OnCreateWSPageTypeHelper(wsPageType);
        iWSPageTypeHelper.Init(this.iDAGlobalHelper, wsPageType);
        this.wsPageTypeHelperMap.put(strWSPageTypeId, iWSPageTypeHelper);
        return iWSPageTypeHelper;
    }

    @Override
    public IWSPageTemplHelper FindWSPageTemplHelper(String strWSPageTemplId) throws Exception {
        WSPageTempl wsPageTempl = (WSPageTempl)((Object)this.wsPageTemplGlobalModel.FindModel(strWSPageTemplId));
        if (wsPageTempl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7f51\u7ad9\u9875\u9762\u6a21\u677f[%1$s]", (Object)strWSPageTemplId));
        }
        IWSPageTemplHelper iWSPageTemplHelper = this.wsPageTemplHelperMap.get(strWSPageTemplId);
        if (iWSPageTemplHelper != null && iWSPageTemplHelper.getWsPageTempl().getVERSION() == wsPageTempl.getVERSION()) {
            return iWSPageTemplHelper;
        }
        IWSPageTypeHelper wsPageTypeHelper = this.FindWSPageTypeHelper(wsPageTempl.getWSPAGETYPEID());
        iWSPageTemplHelper = this.OnCreateWSPageTemplHelper(wsPageTempl);
        iWSPageTemplHelper.Init(this.iDAGlobalHelper, wsPageTypeHelper, wsPageTempl);
        this.wsPageTemplHelperMap.put(strWSPageTemplId, iWSPageTemplHelper);
        return iWSPageTemplHelper;
    }

    @Override
    public IWSWBTypeHelper FindWSWBTypeHelper(String strWSWBTypeId) throws Exception {
        WSWBType wsWBType = (WSWBType)((Object)this.wsWBTypeGlobalModel.FindModel(strWSWBTypeId));
        if (wsWBType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u6570\u636e\u5e93[%1$s]", (Object)strWSWBTypeId));
        }
        IWSWBTypeHelper iWSWBTypeHelper = this.wsWBTypeHelperMap.get(strWSWBTypeId);
        if (iWSWBTypeHelper != null && iWSWBTypeHelper.getWSWBType().getVERSION() == wsWBType.getVERSION()) {
            return iWSWBTypeHelper;
        }
        iWSWBTypeHelper = this.OnCreateWSWBTypeHelper(wsWBType);
        iWSWBTypeHelper.Init(this.iDAGlobalHelper, wsWBType);
        this.wsWBTypeHelperMap.put(strWSWBTypeId, iWSWBTypeHelper);
        return iWSWBTypeHelper;
    }

    @Override
    public IWSWebPartHelper FindWSWebPartHelper(String strWSWebPartId) throws Exception {
        WSWebPart wsWebPart = (WSWebPart)((Object)this.wsWebPartGlobalModel.FindModel(strWSWebPartId));
        if (wsWebPart == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7f51\u7ad9\u90e8\u4ef6[%1$s]", (Object)strWSWebPartId));
        }
        IWSWebPartHelper iWSWebPartHelper = this.wsWebPartHelperMap.get(strWSWebPartId);
        if (iWSWebPartHelper != null && iWSWebPartHelper.getWSWebPart().getVERSION() == wsWebPart.getVERSION()) {
            return iWSWebPartHelper;
        }
        iWSWebPartHelper = this.OnCreateWSWebPartHelper(wsWebPart);
        this.wsWebPartHelperMap.put(strWSWebPartId, iWSWebPartHelper);
        return iWSWebPartHelper;
    }

    @Override
    public IWSWebSiteHelper FindWSWebSiteHelper(String strWSWebsiteId) throws Exception {
        WSWebSite wsWebSite = (WSWebSite)((Object)this.wsWebSiteGlobalModel.FindModel(strWSWebsiteId));
        if (wsWebSite == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7f51\u7ad9\u7ad9\u70b9[%1$s]", (Object)strWSWebsiteId));
        }
        IWSWebSiteHelper iWSWebSiteHelper = this.wsWebSiteHelperMap.get(strWSWebsiteId);
        if (iWSWebSiteHelper != null && iWSWebSiteHelper.getWSWebSite().getVERSION() == wsWebSite.getVERSION()) {
            return iWSWebSiteHelper;
        }
        iWSWebSiteHelper = this.OnCreateWSWebSiteHelper(wsWebSite);
        iWSWebSiteHelper.Init(this.iDAGlobalHelper, wsWebSite);
        this.wsWebSiteHelperMap.put(strWSWebsiteId, iWSWebSiteHelper);
        return iWSWebSiteHelper;
    }

    protected IWSPageTemplHelper OnCreateWSPageTemplHelper(WSPageTempl wsPageTempl) throws Exception {
        return new BaseWSPageTemplHelper();
    }

    protected IWSPageTypeHelper OnCreateWSPageTypeHelper(WSPageType wsPageType) throws Exception {
        return new WSPageTypeHelper();
    }

    protected IWSWBTypeHelper OnCreateWSWBTypeHelper(WSWBType wsWBType) throws Exception {
        return new BaseWSWBTypeHelper();
    }

    protected IWSWebPartHelper OnCreateWSWebPartHelper(WSWebPart wsWebPart) throws Exception {
        try {
            IWSWBTypeHelper wsWBTypeHelper = this.FindWSWBTypeHelper(wsWebPart.getWSWBTYPEID());
            String strHelperObject = wsWBTypeHelper.getWSWBType().getHELPEROBJECT();
            if (StringHelper.IsNullOrEmpty((String)strHelperObject)) {
                strHelperObject = BaseWSWebPartHelper.class.getName();
            }
            IWSWebPartHelper wsWebPartHelper = (IWSWebPartHelper)ObjectHelper.Create((String)strHelperObject);
            wsWebPartHelper.Init(this.iDAGlobalHelper, wsWBTypeHelper, wsWebPart);
            return wsWebPartHelper;
        }
        catch (Exception e) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u90e8\u4ef6[%1$s:%2$s]\u53d1\u5e03\u8f85\u52a9\u5bf9\u8c61\u53d1\u751f\u9519\u8bef", (Object)wsWebPart.getWSWEBPARTNAME(), (Object)wsWebPart.getWSWEBPARTID()));
        }
    }

    protected IWSWebSiteHelper OnCreateWSWebSiteHelper(WSWebSite wsWebSite) throws Exception {
        return new BaseWSWebSiteHelper();
    }
}

