/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.PP.PPEVTabView
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDER11Helper
 *  SA.SRFDA.Ctrl.IDER1NHelper
 *  SA.SRFDA.Ctrl.IDERGroupDetailHelper
 *  SA.SRFDA.Ctrl.IDERGroupHelper
 *  SA.SRFDA.Ctrl.IDERModeHelper
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Ctrl.ISummaryPageHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.DAConfigPublisher;
import SA.SRFDA.Ctrl.Config.ITabViewConfigPublishContext;
import SA.SRFDA.Ctrl.Config.ITabViewConfigPublisherContext;
import SA.SRFDA.Ctrl.Config.ITabViewPageConfigPublisher;
import SA.SRFDA.Ctrl.Config.TabViewPageConfigPublishContext;
import SA.SRFDA.Ctrl.Config.TabViewPageConfigPublisher;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.PP.PPEVTabView;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDER11Helper;
import SA.SRFDA.Ctrl.IDER1NHelper;
import SA.SRFDA.Ctrl.IDERGroupDetailHelper;
import SA.SRFDA.Ctrl.IDERGroupHelper;
import SA.SRFDA.Ctrl.IDERModeHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Ctrl.ISummaryPageHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TabViewConfigPublisher
extends DAConfigPublisher<ITabViewConfigPublishContext>
implements ITabViewConfigPublisherContext {
    private static final Log log = LogFactory.getLog(TabViewConfigPublisher.class);
    private Hashtable<String, ITabViewPageConfigPublisher> tabViewPageConfigPublisherMap = new Hashtable();

    @Override
    protected XMLNode OnPublish(ITabViewConfigPublishContext iPublishContext) throws Exception {
        IDEHelper iDEHelper = iPublishContext.getDEHelper();
        PPEVTabView ppEVTabView = iPublishContext.getPPEVTabView();
        String strDERGroupId = iPublishContext.getDERGroupId();
        IPageHelper iPageHelper = iPublishContext.getPage().getPageData();
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTABVIEW");
        TabViewPageConfigPublishContext tabViewPageConfigPublishContext = new TabViewPageConfigPublishContext();
        tabViewPageConfigPublishContext.From(iPublishContext);
        XMLNode groupNode = new XMLNode();
        groupNode.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.DETAIL", "\u8be6\u7ec6\u4fe1\u606f"));
        groupNode.SetValue("GROUPICON", "../sasrfex/images/default/icon_details.png");
        tabViewPageConfigPublishContext.RegisterTabViewPageGroup("", groupNode, 0);
        groupNode = new XMLNode();
        groupNode.SetValue("GROUP", this.GetLocalization(iDEHelper, "PAGE.COMMON.EDITVIEW.DERGROUP.OTHER", "\u5176\u5b83"));
        groupNode.SetValue("GROUPICON", "../sasrfex/images/default/icon_details.png");
        tabViewPageConfigPublishContext.RegisterTabViewPageGroup("OTHER", groupNode, 99999999);
        if (iPublishContext.isPublishForm()) {
            BaseDataEntity formParam = new BaseDataEntity();
            String strFormName = "";
            String strFormPageId = "";
            Object strFormState = "";
            if (ppEVTabView != null) {
                strFormName = ppEVTabView.getFORMID();
                strFormPageId = ppEVTabView.getFORMPAGEID();
                strFormState = ppEVTabView.getFORMSTATE();
            }
            if (iPageHelper != null) {
                strFormName = iPageHelper.getPageParam("PAGE.FORM", strFormName);
                strFormPageId = iPageHelper.getPageParam("PAGE.FORMPAGE", strFormPageId);
                strFormState = iPageHelper.getPageParam("PAGE.FORMSTATE", strFormState);
            }
            formParam.SetParamValue("FORMNAME", (Object)strFormName);
            formParam.SetParamValue("FORMPAGEID", (Object)strFormPageId);
            formParam.SetParamValue("FORMSTATE", strFormState);
            tabViewPageConfigPublishContext.setParam(formParam);
            tabViewPageConfigPublishContext.setTabViewPageId("EDIT");
            tabViewPageConfigPublishContext.setGroupId("");
            tabViewPageConfigPublishContext.setCaption("");
            ITabViewPageConfigPublisher iTabViewPageConfigPublisher = this.getTabViewPageConfigPublisher("FORM");
            iTabViewPageConfigPublisher.Publish(tabViewPageConfigPublishContext);
        }
        if (StringHelper.IsNullOrEmpty((String)strDERGroupId)) {
            ITabViewPageConfigPublisher iTabViewPageConfigPublisher;
            Vector der1NList;
            ITabViewPageConfigPublisher iTabViewPageConfigPublisher2;
            Vector der11List = iDEHelper.GetDER11s();
            if (der11List.size() > 0) {
                iTabViewPageConfigPublisher2 = this.getTabViewPageConfigPublisher("DER11");
                for (IDER11Helper der11Helper : der11List) {
                    if (der11Helper.getShowOrder() < 0) continue;
                    tabViewPageConfigPublishContext.setParam(der11Helper);
                    tabViewPageConfigPublishContext.setTabViewPageId(null);
                    tabViewPageConfigPublishContext.setGroupId("");
                    tabViewPageConfigPublishContext.setCaption("");
                    iTabViewPageConfigPublisher2.Publish(tabViewPageConfigPublishContext);
                }
            }
            if ((der1NList = iDEHelper.GetDER1Ns()).size() > 0) {
                iTabViewPageConfigPublisher2 = this.getTabViewPageConfigPublisher("DER1N");
                for (IDER1NHelper der1NHelper : der1NList) {
                    if (der1NHelper.getShowOrder() < 0) continue;
                    tabViewPageConfigPublishContext.setParam(der1NHelper);
                    tabViewPageConfigPublishContext.setTabViewPageId("");
                    tabViewPageConfigPublishContext.setGroupId("");
                    tabViewPageConfigPublishContext.setCaption("");
                    iTabViewPageConfigPublisher2.Publish(tabViewPageConfigPublishContext);
                }
            }
            Vector derIndexs = iDEHelper.GetDERINDEXs(false);
            for (DERINDEX derIndex : derIndexs) {
                IDEHelper iIndexDEHelper = this.getDAModelStorage().FindDEHelper2(derIndex.getINDEXDEID());
                Vector der1NList2 = iIndexDEHelper.GetDER1Ns();
                if (der1NList2.size() <= 0) continue;
                ITabViewPageConfigPublisher iTabViewPageConfigPublisher3 = this.getTabViewPageConfigPublisher("DER1N");
                for (IDER1NHelper der1NHelper : der1NList2) {
                    if (iDEHelper.IsExtendDER1N(der1NHelper.getId())) {
                        der1NHelper = iDEHelper.FindDER1N2(der1NHelper.getId());
                    }
                    if (der1NHelper.getShowOrder() < 0) continue;
                    tabViewPageConfigPublishContext.setParam(der1NHelper);
                    tabViewPageConfigPublishContext.setTabViewPageId("");
                    tabViewPageConfigPublishContext.setGroupId("");
                    tabViewPageConfigPublishContext.setCaption("");
                    iTabViewPageConfigPublisher3.Publish(tabViewPageConfigPublishContext);
                }
            }
            Vector summaryPageHelperList = iDEHelper.GetSummaryPages();
            if (summaryPageHelperList.size() > 0) {
                iTabViewPageConfigPublisher = this.getTabViewPageConfigPublisher("SUMMARYPAGE");
                for (ISummaryPageHelper ISummaryPageHelper2 : summaryPageHelperList) {
                    if (ISummaryPageHelper2.getDERShowOrder() < 0) continue;
                    tabViewPageConfigPublishContext.setParam(ISummaryPageHelper2);
                    tabViewPageConfigPublishContext.setTabViewPageId("");
                    tabViewPageConfigPublishContext.setGroupId("");
                    tabViewPageConfigPublishContext.setCaption("");
                    iTabViewPageConfigPublisher.Publish(tabViewPageConfigPublishContext);
                }
            }
            if (iDEHelper.IsEnableWF()) {
                boolean bWFStepData = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFINFOPAGE_WFSTEPDATA", true);
                if (iDEHelper != null && iDEHelper.GetDEWF() != null) {
                    bWFStepData = iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.WFSTEPDATA", bWFStepData);
                }
                if (iPageHelper != null) {
                    bWFStepData = iPageHelper.getPageParam("WFINFOPAGE.WFSTEPDATA", bWFStepData);
                }
                if (bWFStepData) {
                    tabViewPageConfigPublishContext.setParam(null);
                    tabViewPageConfigPublishContext.setTabViewPageId("DER_WFSTEPDATA");
                    tabViewPageConfigPublishContext.setGroupId("");
                    tabViewPageConfigPublishContext.setCaption("");
                    iTabViewPageConfigPublisher = this.getTabViewPageConfigPublisher("WFSTEP");
                    iTabViewPageConfigPublisher.Publish(tabViewPageConfigPublishContext);
                }
            }
            if (iDEHelper.IsEnableWF()) {
                boolean bWFStepActor = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFINFOPAGE_WFSTEPACTOR", true);
                if (iDEHelper != null && iDEHelper.GetDEWF() != null) {
                    bWFStepActor = iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.WFSTEPACTOR", bWFStepActor);
                }
                if (iPageHelper != null) {
                    bWFStepActor = iPageHelper.getPageParam("WFINFOPAGE.WFSTEPACTOR", bWFStepActor);
                }
                if (bWFStepActor) {
                    tabViewPageConfigPublishContext.setParam(null);
                    tabViewPageConfigPublishContext.setTabViewPageId("DER_WFSTEPACTOR");
                    tabViewPageConfigPublishContext.setGroupId("");
                    tabViewPageConfigPublishContext.setCaption("");
                    iTabViewPageConfigPublisher = this.getTabViewPageConfigPublisher("WFSTEPACTOR");
                    iTabViewPageConfigPublisher.Publish(tabViewPageConfigPublishContext);
                }
            }
            if (iDEHelper.IsSupportFA()) {
                tabViewPageConfigPublishContext.setParam(null);
                tabViewPageConfigPublishContext.setTabViewPageId("DER_FILELIST");
                tabViewPageConfigPublishContext.setGroupId("");
                tabViewPageConfigPublishContext.setCaption("");
                ITabViewPageConfigPublisher iTabViewPageConfigPublisher4 = this.getTabViewPageConfigPublisher("FILELIST");
                iTabViewPageConfigPublisher4.Publish(tabViewPageConfigPublishContext);
            }
            if (iDEHelper.IsEnableAudit()) {
                tabViewPageConfigPublishContext.setParam(null);
                tabViewPageConfigPublishContext.setTabViewPageId("DER_DATAAUDIT");
                tabViewPageConfigPublishContext.setGroupId("");
                tabViewPageConfigPublishContext.setCaption("");
                ITabViewPageConfigPublisher iTabViewPageConfigPublisher5 = this.getTabViewPageConfigPublisher("DATAAUDIT");
                iTabViewPageConfigPublisher5.Publish(tabViewPageConfigPublishContext);
            }
        }
        tabViewPageConfigPublishContext.ExportTabViewPageNodes(rootNode);
        return rootNode;
    }

    protected void OnPublishDERGroup(TabViewPageConfigPublishContext tabViewPageConfigPublishContext, String strDERGroupId) throws Exception {
        IDERGroupHelper iDERGroupHelper = tabViewPageConfigPublishContext.getDEHelper().FindDERGroup(strDERGroupId);
        Vector derGroupDetails = iDERGroupHelper.getDetails();
        for (IDERGroupDetailHelper derGroupDetailHelper : derGroupDetails) {
            ITabViewPageConfigPublisher iTabViewPageConfigPublisher;
            String strDetailType = derGroupDetailHelper.getDetailType();
            tabViewPageConfigPublishContext.setParam(derGroupDetailHelper);
            tabViewPageConfigPublishContext.setTabViewPageId("");
            tabViewPageConfigPublishContext.setCaption("");
            tabViewPageConfigPublishContext.setGroupId(null);
            if (StringHelper.Compare((String)strDetailType, (String)"WFSTEP", (boolean)true) == 0) {
                tabViewPageConfigPublishContext.setTabViewPageId("DER_WFSTEPDATA");
                iTabViewPageConfigPublisher = this.getTabViewPageConfigPublisher(strDetailType);
                iTabViewPageConfigPublisher.Publish(tabViewPageConfigPublishContext);
                continue;
            }
            if (StringHelper.Compare((String)strDetailType, (String)"WFSTEPACTOR", (boolean)true) == 0) {
                tabViewPageConfigPublishContext.setTabViewPageId("DER_WFSTEPACTOR");
                iTabViewPageConfigPublisher = this.getTabViewPageConfigPublisher(strDetailType);
                iTabViewPageConfigPublisher.Publish(tabViewPageConfigPublishContext);
                continue;
            }
            if (StringHelper.Compare((String)strDetailType, (String)"FILELIST", (boolean)true) == 0) {
                tabViewPageConfigPublishContext.setTabViewPageId("DER_FILELIST");
                iTabViewPageConfigPublisher = this.getTabViewPageConfigPublisher(strDetailType);
                iTabViewPageConfigPublisher.Publish(tabViewPageConfigPublishContext);
                continue;
            }
            if (StringHelper.Compare((String)strDetailType, (String)"DATAAUDIT", (boolean)true) == 0) {
                tabViewPageConfigPublishContext.setTabViewPageId("DER_DATAAUDIT");
                iTabViewPageConfigPublisher = this.getTabViewPageConfigPublisher(strDetailType);
                iTabViewPageConfigPublisher.Publish(tabViewPageConfigPublishContext);
                continue;
            }
            iTabViewPageConfigPublisher = this.getTabViewPageConfigPublisher(strDetailType);
            iTabViewPageConfigPublisher.Publish(tabViewPageConfigPublishContext);
        }
    }

    public String GetConfigFilePath(String strConfigId) throws Exception {
        return ConfigPathHelper.GetRuntimeTVConfigPath((String)this.getDAGlobalHelper().GetAppRootPath(), (String)strConfigId);
    }

    @Override
    protected String OnGetConfigId(ITabViewConfigPublishContext iDAConfigPublishContext) throws Exception {
        String strConfigId = "";
        strConfigId = StringHelper.Format((String)"DE%1$s.TABVIEW_%2$s", (Object)iDAConfigPublishContext.getDEHelper().getId(), (Object)iDAConfigPublishContext.getDEHelper().getVersion());
        if (iDAConfigPublishContext.getDEMainState() != null) {
            strConfigId = String.valueOf(strConfigId) + StringHelper.Format((String)"_%1$s", (Object)iDAConfigPublishContext.getDEMainState().getName());
        }
        strConfigId = TabViewConfigPublisher.AppendPageId(strConfigId, iDAConfigPublishContext);
        return strConfigId;
    }

    protected ITabViewPageConfigPublisher getTabViewPageConfigPublisher(String strMode) throws Exception {
        if (this.tabViewPageConfigPublisherMap.containsKey(strMode = strMode.toUpperCase())) {
            return this.tabViewPageConfigPublisherMap.get(strMode);
        }
        ITabViewPageConfigPublisher iTabViewPageConfigPublisher = this.OnCreateTabViewPageConfigPublisher(strMode);
        iTabViewPageConfigPublisher.Init(this);
        this.tabViewPageConfigPublisherMap.put(strMode, iTabViewPageConfigPublisher);
        return iTabViewPageConfigPublisher;
    }

    protected ITabViewPageConfigPublisher OnCreateTabViewPageConfigPublisher(String strMode) throws Exception {
        IDERModeHelper iDERModeHelper = this.getDAModelStorage().FindDERMode(strMode);
        return this.CreateTabViewPageConfigPublisher(iDERModeHelper);
    }

    protected ITabViewPageConfigPublisher CreateTabViewPageConfigPublisher(IDERModeHelper iDERModeHelper) throws Exception {
        ITabViewPageConfigPublisher iTabViewPageConfigPublisher = this.OnCreateTabViewPageConfigPublisher(iDERModeHelper);
        iTabViewPageConfigPublisher.setParams(PropertiesHelper.Load(null, (String)iDERModeHelper.getTVPPublisherParam()));
        return iTabViewPageConfigPublisher;
    }

    protected ITabViewPageConfigPublisher OnCreateTabViewPageConfigPublisher(IDERModeHelper iDERModeHelper) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)iDERModeHelper.getTVPPublisher())) {
            return new TabViewPageConfigPublisher();
        }
        Object objTabViewPageConfigPublisher = ObjectHelper.Create((String)iDERModeHelper.getTVPPublisher());
        if (objTabViewPageConfigPublisher == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u53d1\u5e03\u5668\u5bf9\u8c61[%1$s]", (Object)iDERModeHelper.getTVPPublisher()));
        }
        if (!(objTabViewPageConfigPublisher instanceof ITabViewPageConfigPublisher)) {
            throw new Exception(StringHelper.Format((String)"\u53d1\u5e03\u5668\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iDERModeHelper.getTVPPublisher()));
        }
        return (ITabViewPageConfigPublisher)objTabViewPageConfigPublisher;
    }
}

