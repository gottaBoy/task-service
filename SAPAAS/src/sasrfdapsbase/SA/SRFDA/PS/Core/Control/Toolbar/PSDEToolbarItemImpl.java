/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBSeperatorItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSToolbarItemType;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlPartCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEToolbarItemImpl
extends PSObjectImpl
implements IPSDEToolbarItem,
IPSDEContextMenuItem,
IPSPFCtrlPartCodeObject,
IPSControlObject {
    private static final Log log = LogFactory.getLog(PSDEToolbarItemImpl.class);
    protected static final ArrayList<IPSDEToolbarItem> emptyPSDEToolbarItemList = new ArrayList();
    private IPSDEToolbar iPSDEToolbar = null;
    private IPSDEToolbarItem parentPSDEToolbarItem = null;
    protected PSDEToolbarItem psDEToolbarItem = null;
    private ArrayList<IPSDEToolbarItem> psDEToolbarItemList = null;
    private String strCaption = "";
    private boolean bShowCaption = true;
    private boolean bShowIcon = true;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss iPSSysCss = null;
    private IPSDEContextMenu iPSDEContextMenu = null;
    private IPSDEContextMenuItem parentPSDEContextMenuItem = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private double fWidth = 0.0;
    private double fHeight = 0.0;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private String strData = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEToolbar iPSDEToolbar, IPSDEToolbarItem parentPSDEToolbarItem, PSDEToolbarItem psDEToolbarItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEToolbar(iPSDEToolbar);
            this.setParentPSDEToolbarItem(parentPSDEToolbarItem);
            this.setPSDEToolbarItemData(psDEToolbarItem);
            this.setId(this.psDEToolbarItem.getPSDETBITEMID());
            this.setName(this.psDEToolbarItem.getPSDETBITEMNAME());
            this.setPSObjectData(this.psDEToolbarItem);
            this.strCaption = psDEToolbarItem.getCAPTION();
            if (!this.psDEToolbarItem.isWIDTHNull() && this.psDEToolbarItem.getWIDTH() >= 0.0f) {
                this.fWidth = this.psDEToolbarItem.getWIDTH();
            }
            if (!this.psDEToolbarItem.isHEIGHTNull() && this.psDEToolbarItem.getHEIGHT() >= 0.0f) {
                this.fHeight = this.psDEToolbarItem.getHEIGHT();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEToolbarItem.getSHOWMODE(), (String)"ICONANDSHORTWORD", (boolean)true) == 0) {
                this.bShowCaption = true;
                this.bShowIcon = true;
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEToolbarItem.getSHOWMODE(), (String)"ICON", (boolean)true) == 0) {
                this.bShowCaption = false;
                this.bShowIcon = true;
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEToolbarItem.getSHOWMODE(), (String)"SHORTWORD", (boolean)true) == 0) {
                this.bShowCaption = true;
                this.bShowIcon = false;
            }
            boolean bRegisterToContainer = true;
            if (this.iPSDEToolbar.getPSAppView() != null) {
                bRegisterToContainer = this.iPSDEToolbar.getPSAppView().getPSPFStyle().isRegisterToContainer();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPSSYSCSSID())) {
                this.iPSSysCss = this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSystem().getPSSysCss(psDEToolbarItem.getPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.iPSDEToolbar.getPSControlContainer().registerPSSysCss(this.iPSSysCss);
                } else if (this.iPSDEToolbar.getPSAppView() != null) {
                    this.iPSDEToolbar.getPSAppView().registerPSSysCss(this.iPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSystem().getPSSysImage(psDEToolbarItem.getPSSYSIMAGEID());
                if (bRegisterToContainer) {
                    this.iPSDEToolbar.getPSControlContainer().registerPSSysImage(this.iPSSysImage);
                } else if (this.iPSDEToolbar.getPSAppView() != null) {
                    this.iPSDEToolbar.getPSAppView().registerPSSysImage(this.iPSSysImage);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = this.iPSDEToolbar.getPSAppView().getPSApplication() != null ? this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSysPFPlugin(this.psDEToolbarItem.getPSSYSPFPLUGINID(), "CONTROLITEM", this.iPSDEToolbar.getControlType(), this.getItemType()) : this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSystem().getPSSysPFPlugin(psDEToolbarItem.getPSSYSPFPLUGINID());
                this.iPSDEToolbar.getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
            }
            if (this.getPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.iPSDEToolbar.getPSAppView().getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.iPSDEToolbar.getPSAppView().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.iPSDEToolbar.getPSAppView(), (Object)this.iPSDEToolbar, (Object)this);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.iPSDEToolbar.getPSAppView().getPSApplication().getPSLanguageRes(psDEToolbarItem.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEToolbarItem.getTIPPSLANRESID())) {
                this.tooltipPSLanguageRes = this.iPSDEToolbar.getPSAppView().getPSApplication().getPSLanguageRes(psDEToolbarItem.getTIPPSLANRESID());
            }
            this.strData = psDEToolbarItem.getDATA();
            this.onInit();
        }
        catch (Exception ex) {
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)this.getLogName(), (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(this.getLogName(), strExInfo);
            }
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEToolbarItems();
    }

    protected void onPreparePSDEToolbarItems() throws Exception {
        ArrayList<PSDEToolbarItem> psDEToolbarItemList;
        if (this.psDEToolbarItemList != null) {
            this.psDEToolbarItemList.clear();
        }
        if ((psDEToolbarItemList = this.psDEToolbarItem.getChildPSDEToolbarItems(false)) == null || psDEToolbarItemList.size() == 0) {
            return;
        }
        if (this.psDEToolbarItemList == null) {
            this.psDEToolbarItemList = new ArrayList();
        }
        boolean bLastSeperator = true;
        for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            IPSToolbarItemType iPSToolbarItemType = this.getPSModelStorage().getPSToolbarItemType(psDEToolbarItem.getTBITEMTYPE());
            IPSDEToolbarItem iPSDEToolbarItem = iPSToolbarItemType.createPSDEToolbarItem(psDEToolbarItem);
            iPSDEToolbarItem.init(this.getDAGlobalHelper(), this.iPSDEToolbar, this, psDEToolbarItem);
            if (!iPSDEToolbarItem.isValid()) continue;
            if (iPSDEToolbarItem instanceof IPSDETBSeperatorItem) {
                if (bLastSeperator) continue;
                bLastSeperator = true;
            } else {
                bLastSeperator = false;
            }
            this.psDEToolbarItemList.add(iPSDEToolbarItem);
        }
        if (bLastSeperator && this.psDEToolbarItemList.size() > 0) {
            this.psDEToolbarItemList.remove(this.psDEToolbarItemList.size() - 1);
        }
        if (this.psDEToolbarItemList.size() == 0) {
            this.psDEToolbarItemList = null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption();
        }
        return this.strCaption;
    }

    protected String onGetCaption() {
        return "";
    }

    @Override
    public IPSDEToolbar getPSDEToolbar() {
        return this.iPSDEToolbar;
    }

    protected void setPSDEToolbar(IPSDEToolbar iPSDEToolbar) {
        this.iPSDEToolbar = iPSDEToolbar;
        if (this.iPSDEToolbar == null) {
            this.iPSDEContextMenu = null;
        } else if (this.iPSDEToolbar instanceof IPSDEContextMenu) {
            this.iPSDEContextMenu = (IPSDEContextMenu)this.iPSDEToolbar;
        }
    }

    @Override
    public IPSDEToolbarItem getParentPSDEToolbarItem() {
        return this.parentPSDEToolbarItem;
    }

    protected void setParentPSDEToolbarItem(IPSDEToolbarItem parentPSDEToolbarItem) {
        this.parentPSDEToolbarItem = parentPSDEToolbarItem;
        if (this.parentPSDEToolbarItem == null) {
            this.parentPSDEContextMenuItem = null;
        } else if (this.parentPSDEToolbarItem instanceof IPSDEContextMenuItem) {
            this.parentPSDEContextMenuItem = (IPSDEContextMenuItem)this.parentPSDEToolbarItem;
        }
    }

    public PSDEToolbarItem getPSDEToolbarItemData() {
        return this.psDEToolbarItem;
    }

    protected void setPSDEToolbarItemData(PSDEToolbarItem psDEToolbarItem) {
        this.psDEToolbarItem = psDEToolbarItem;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7c7b\u578b", codelist="TBItemType", fields={"TBITEMTYPE"})
    public String getItemType() {
        return this.getPSDEToolbarItemData().getTBITEMTYPE();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        this.onFillRelatedPSAppViews(relatedAppViewList);
    }

    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.psDEToolbarItemList == null) {
            return;
        }
        for (IPSDEToolbarItem iPSDEToolbarItem : this.psDEToolbarItemList) {
            iPSDEToolbarItem.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public boolean isValid() throws Exception {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898", fields={"SHOWMODE"}, ignoresetvalues="*")
    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u56fe\u6807", fields={"SHOWMODE"}, ignoresetvalues="*")
    public boolean isShowIcon() {
        return this.bShowIcon;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u63d0\u793a", fields={"TOOLTIPINFO"})
    public String getTooltip() {
        String strTooltipInfo = this.psDEToolbarItem.getTOOLTIPINFO();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strTooltipInfo)) {
            return strTooltipInfo;
        }
        return this.getCaption();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEToolbar.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    public IPSDEContextMenu getPSDEContextMenu() {
        return this.iPSDEContextMenu;
    }

    @Override
    public IPSDEContextMenuItem getParentPSDEContextMenuItem() {
        return this.parentPSDEContextMenuItem;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u8bed\u8a00\u8d44\u6e90", fields={"TIPPSLANRESID"})
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u680f\u9879\u5bbd\u5ea6", ignoredumpvalues="0.0", outputdoc="(%1$s.getWidth() gt 0)", fields={"WIDTH"}, ignoresetvalues="0.0")
    public double getWidth() {
        return this.fWidth;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u680f\u9879\u9ad8\u5ea6", ignoredumpvalues="0.0", outputdoc="(%1$s.getHeight() gt 0)", fields={"HEIGHT"}, ignoresetvalues="0.0")
    public double getHeight() {
        return this.fHeight;
    }

    @Override
    public void fillPSDEToolbarItems(ArrayList<IPSDEToolbarItem> psDEToolbarItemList) {
        psDEToolbarItemList.add(this);
    }

    protected ArrayList<IPSDEToolbarItem> getPSDEToolbarItemList(boolean bCreate) {
        if (this.psDEToolbarItemList == null && bCreate) {
            this.psDEToolbarItemList = new ArrayList();
        }
        return this.psDEToolbarItemList;
    }

    @Override
    public String getModelType() {
        return "PSDETBITEM";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEToolbar() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEToolbar().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelName() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getCaption()) && SA.SRFramework.Utility.StringHelper.Compare((String)this.getName(), (String)this.getCaption(), (boolean)false) != 0) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getName(), (Object)this.getCaption());
        }
        return super.getModelName();
    }

    @Override
    public IPSControl getOwnedPSControl() {
        if (this.getPSDEToolbar() != null) {
            return this.getPSDEToolbar();
        }
        return this.getPSDEContextMenu();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6210\u5458\u4ee3\u7801\u7c7b\u578b", dump=false)
    public String getPFPartCodeType() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"ITEM_%1$s", (Object)this.getItemType());
    }

    protected Object getOwner() {
        if (this.getPSDEToolbar() != null) {
            return this.getPSDEToolbar().getOwner();
        }
        if (this.getPSDEContextMenu() != null) {
            return this.getPSDEContextMenu().getOwner();
        }
        return null;
    }

    @PSModelRTMeta(description="\u63a7\u4ef6\u5bb9\u5668")
    public IPSControlContainer getPSControlContainer() {
        if (this.getPSDEToolbar() != null) {
            return this.getPSDEToolbar().getPSControlContainer();
        }
        if (this.getPSDEContextMenu() != null) {
            return this.getPSDEContextMenu().getPSControlContainer();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0", fields={"USERTAG"})
    public String getUserTag() {
        return this.psDEToolbarItem.getUSERTAG();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02", fields={"USERTAG2"})
    public String getUserTag2() {
        return this.psDEToolbarItem.getUSERTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6570\u636e", fields={"DATA"})
    public String getData() {
        return this.strData;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868", fields={"DYNACLASS"})
    public String getDynaClass() {
        return this.psDEToolbarItem.getDYNACLASS();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"RAWCSSSTYLE"})
    public String getCssStyle() {
        return this.psDEToolbarItem.getRAWCSSSTYLE();
    }

    @Override
    public String getFullModelName() {
        if (this.getOwnedPSControl() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.getOwnedPSControl().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getOwnedPSControl().getPSAppView().getPSSystem());
    }

    public String getPredefinedType() {
        return this.psDEToolbarItem.getPREDEFINEDTYPE();
    }

    public String getRenderMode() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        return this.getOwnedPSControl().getPSControlLogicsByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        return this.getOwnedPSControl().getPSControlAttributesByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return this.getOwnedPSControl().getPSControlRendersByItemName(this.getName());
    }

    @Override
    public String getItemStyle() {
        return this.psDEToolbarItem.getITEMSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bc6", fields={"COUNTERID"})
    public String getCounterId() {
        return this.onGetCounterId();
    }

    protected String onGetCounterId() {
        return this.psDEToolbarItem.getCOUNTERID();
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6a21\u5f0f", codelist="DETreeNodeCounterMode", ignoredumpvalues="0", fields={"COUNTERMODE"})
    public int getCounterMode() {
        return this.onGetCounterMode();
    }

    protected int onGetCounterMode() {
        return this.psDEToolbarItem.getCOUNTERMODE();
    }

    protected boolean isPrepareTemplV2logic() {
        return this.getOwnedPSControl().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }
}

