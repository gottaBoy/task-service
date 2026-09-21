/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendar;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItem;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarLogic;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarParam;
import SA.SRFDA.PS.Core.Control.Calendar.PSCalendarImpl;
import SA.SRFDA.PS.Core.Control.Calendar.PSSysCalendarItemImpl;
import SA.SRFDA.PS.Core.Control.Calendar.PSSysCalendarLogicImpl;
import SA.SRFDA.PS.Core.Control.Calendar.PSSysCalendarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Data.PSSysCalendar;
import SA.SRFDA.PS.Data.PSSysCalendarItem;
import SA.SRFDA.PS.Data.PSSysCalendarItemRV;
import SA.SRFDA.PS.Data.PSSysCalendarLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"CALENDAR"})
public class PSSysCalendarImpl
extends PSCalendarImpl
implements IPSSysCalendar {
    private static final Log log = LogFactory.getLog(PSSysCalendarImpl.class);
    protected PSSysCalendar psSysCalendar;
    protected ArrayList<IPSSysCalendarItem> psSysCalendarItemList = new ArrayList();
    protected Map<String, IPSSysCalendarItem> psSysCalendarItemMap = new LinkedHashMap<String, IPSSysCalendarItem>();
    protected PSSysCalendarParamImpl psSysCalendarParamImpl = new PSSysCalendarParamImpl();
    protected String strCodeName = "";
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private boolean bBufferRenderer = true;
    private String strGroupMode = "NONE";
    private String strGroupLayout = "";
    private IPSDEField groupPSDEField = null;
    private IPSCodeList groupPSCodeList = null;
    private boolean bEnableGroup = false;
    private IPSAppDEField groupPSAppDEField = null;
    private IPSSysPFPlugin groupPSSysPFPlugin = null;
    private IPSSysCss groupPSSysCss = null;
    private IPSPFXCodeObject groupPSPFXCodeObject = null;
    private int nGroupWidth = 0;
    private int nGroupHeight = 0;
    private boolean bInvalidId = false;
    private IPSDEField groupTextPSDEField = null;
    private IPSAppDEField groupTextPSAppDEField = null;
    protected List<PSSysCalendarLogicImpl> psSysCalendarLogicList = new ArrayList<PSSysCalendarLogicImpl>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSSysCalendarParam iPSSysCalendarParam = (IPSSysCalendarParam)iPSControlParam;
            this.psSysCalendar = new PSSysCalendar();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSSysCalendarParam.getPSSysCalendarId())) {
                CallResult callResult = this.getPSModelHelper().getPSSysCalendar(iPSSysCalendarParam.getPSSysCalendarId(), this.psSysCalendar);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u65e5\u5386\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psSysCalendar.getPSSYSCALENDARID());
            } else {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psSysCalendar.getPSSYSCALENDARNAME());
            this.setPSObjectData(this.psSysCalendar);
            if (!(this.getPSDataEntity() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysCalendar.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysCalendar.getPSDEID()))) {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psSysCalendar.getPSDEID()));
            }
            this.psSysCalendarParamImpl.setPSCtrlMsgId(this.psSysCalendar.getPSCTRLMSGID());
            this.psSysCalendarParamImpl.setPSSysPFPluginId(this.psSysCalendar.getPSSYSPFPLUGINID());
            this.psSysCalendarParamImpl.setPSSysCssId(this.psSysCalendar.getPSSYSCSSID());
            this.psSysCalendarParamImpl.setPSDEUILogicGroupId(this.psSysCalendar.getPSCTRLLOGICGROUPID());
            this.psSysCalendarParamImpl.merge(iPSControlParam);
            this.strCodeName = this.psSysCalendar.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.strEmptyText = this.psSysCalendar.getEMPTYTEXT();
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psSysCalendarParamImpl);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        boolean bRegisterToContainer = this.getPSAppView().getPSPFStyle().isRegisterToContainer();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysCalendar.getEMPTYTEXTPSLANRESID())) {
            this.emptyTextPSLanguageRes = this.getPSAppView().getPSApplication().getPSLanguageRes(this.psSysCalendar.getEMPTYTEXTPSLANRESID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysCalendar.getGROUPMODE())) {
            this.strGroupMode = this.psSysCalendar.getGROUPMODE();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupMode(), (String)"NONE", (boolean)false) != 0) {
            if (!this.psSysCalendar.isGROUPWIDTHNull() && this.psSysCalendar.getGROUPWIDTH() >= 0) {
                this.nGroupWidth = this.psSysCalendar.getGROUPWIDTH();
            }
            if (!this.psSysCalendar.isGROUPHEIGHTNull() && this.psSysCalendar.getGROUPHEIGHT() >= 0) {
                this.nGroupHeight = this.psSysCalendar.getGROUPHEIGHT();
            }
            this.bEnableGroup = true;
            this.strGroupLayout = this.psSysCalendar.getGROUPLAYOUT();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getGroupLayout())) {
                this.strGroupLayout = "ROW";
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysCalendar.getGROUPPSDEFID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5206\u7ec4\u5c5e\u6027");
            }
            this.groupPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendar.getGROUPPSDEFID());
            this.groupPSCodeList = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysCalendar.getGROUPPSCODELISTID()) ? this.getPSDataEntity().getPSSystem().getPSCodeList(this.psSysCalendar.getGROUPPSCODELISTID()) : this.groupPSDEField.getPSCodeList();
            if (this.groupPSCodeList != null) {
                this.groupPSCodeList = this.getPSAppView().getPSApplication().getPSCodeList(this.groupPSCodeList, true);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysCalendar.getGROUPTEXTPSDEFID())) {
                this.groupTextPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendar.getGROUPTEXTPSDEFID());
            } else if (this.groupPSCodeList == null && this.groupPSDEField instanceof IPSPickupDEField) {
                this.groupTextPSDEField = ((IPSPickupDEField)this.groupPSDEField).getPSPickupTextDEField();
            }
            if (this.getPSAppDataEntity() != null) {
                this.groupPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.groupPSDEField, true);
                if (this.groupTextPSDEField != null) {
                    this.groupTextPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.groupTextPSDEField, true);
                }
            }
        }
        super.onInit();
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupMode(), (String)"NONE", (boolean)false) != 0) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysCalendar.getGROUPPSSYSCSSID())) {
                this.groupPSSysCss = this.getPSDataEntity().getPSSystem().getPSSysCss(this.psSysCalendar.getGROUPPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSControlContainer().registerPSSysCss(this.groupPSSysCss);
                } else if (this.getPSAppView() != null) {
                    this.getPSAppView().registerPSSysCss(this.groupPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysCalendar.getGROUPPSSYSPFPLUGINID())) {
                this.groupPSSysPFPlugin = this.getPSAppView().getPSApplication() != null ? this.getPSAppView().getPSApplication().getPSSysPFPlugin(this.psSysCalendar.getGROUPPSSYSPFPLUGINID(), "CONTROLITEM", this.getControlType(), "GROUP") : this.getPSAppView().getPSSystem().getPSSysPFPlugin(this.psSysCalendar.getGROUPPSSYSPFPLUGINID());
                this.getPSAppView().registerPSSysPFPlugin(this.groupPSSysPFPlugin);
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.groupPSSysPFPlugin.getId(), (String)this.getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.groupPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSAppView(), (Object)this, null);
                }
            }
        }
        if (!this.bInvalidId) {
            this.onPreparePSSysCalendarItems();
            this.onPreparePSSysCalendarLogics();
        }
        this.initNavParams(this.psSysCalendar);
    }

    @Override
    protected int onCheck() throws Exception {
        Iterator<IPSSysCalendarItem> psSysCalendarItems = this.getPSSysCalendarItems();
        if (psSysCalendarItems != null) {
            while (psSysCalendarItems.hasNext()) {
                psSysCalendarItems.next().check();
            }
        }
        return super.onCheck();
    }

    @Override
    protected void onCheckControlParam() throws Exception {
        super.onCheckControlParam();
    }

    protected void onPreparePSSysCalendarItems() throws Exception {
        this.psSysCalendarItemList.clear();
        this.psSysCalendarItemMap.clear();
        Vector<PSSysCalendarItem> psSysCalendarItemList = new Vector<PSSysCalendarItem>();
        CallResult callResult = this.getPSModelHelper().getPSSysCalendarItems(this.getId(), psSysCalendarItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u65e5\u5386\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSSysCalendarItem> psSysCalendarItemMap2 = new HashMap<String, PSSysCalendarItem>();
        for (PSSysCalendarItem psSysCalendarItem : psSysCalendarItemList) {
            psSysCalendarItemMap2.put(psSysCalendarItem.getPSSYSCALENDARITEMID(), psSysCalendarItem);
        }
        Vector<PSSysCalendarItemRV> psSysCalendarItemRVList = new Vector<PSSysCalendarItemRV>();
        callResult = this.getPSModelHelper().getPSSysCalendarItemRVs(this.getId(), psSysCalendarItemRVList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u65e5\u5386\u9879\u89c6\u56fe\u5f15\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysCalendarItemRV psSysCalendarItemRV : psSysCalendarItemRVList) {
            PSSysCalendarItem psSysCalendarItem = (PSSysCalendarItem)((Object)psSysCalendarItemMap2.get(psSysCalendarItemRV.getPSSYSCALENDARITEMID()));
            if (psSysCalendarItem != null) {
                psSysCalendarItem.getPSSysCalendarItemRVs(true).add(psSysCalendarItemRV);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u65e5\u5386\u6570\u636e\u9879[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psSysCalendarItemRV.getPSSYSCALENDARITEMID()), "PSSYSCALENDARITEM", "REMOVE", psSysCalendarItemRV.getPSSYSCALENDARITEMRVID());
        }
        for (PSSysCalendarItem psSysCalendarItem : psSysCalendarItemList) {
            PSSysCalendarItemImpl iPSSysCalendarItem = new PSSysCalendarItemImpl();
            iPSSysCalendarItem.init(this.getDAGlobalHelper(), this, psSysCalendarItem);
            this.psSysCalendarItemList.add(iPSSysCalendarItem);
            this.psSysCalendarItemMap.put(iPSSysCalendarItem.getId(), iPSSysCalendarItem);
        }
        PSModelUtil.sort(this.psSysCalendarItemList);
    }

    protected void onPreparePSSysCalendarLogics() throws Exception {
        this.psSysCalendarLogicList.clear();
        this.onPreparePSSysCalendarLogics(this.getId());
    }

    protected void onPreparePSSysCalendarLogics(String strPSSysCalendarId) throws Exception {
        Vector<PSSysCalendarLogic> psSysCalendarLogicList = new Vector<PSSysCalendarLogic>();
        CallResult callResult = this.getPSModelHelper().getPSSysCalendarLogics(strPSSysCalendarId, psSysCalendarLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysCalendarLogic psSysCalendarLogic : psSysCalendarLogicList) {
            PSSysCalendarLogicImpl psSysCalendarLogicImpl = new PSSysCalendarLogicImpl();
            psSysCalendarLogicImpl.init(this.getDAGlobalHelper(), this, psSysCalendarLogic);
            this.psSysCalendarLogicList.add(psSysCalendarLogicImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u65e5\u5386\u9879\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=163)
    public Iterator<IPSSysCalendarItem> getPSSysCalendarItems() {
        return this.psSysCalendarItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u90e8\u4ef6\u53c2\u6570", outputdoc="false")
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psSysCalendarParamImpl;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.strCodeName, null);
    }

    @Override
    @PSModelRTMeta(description="\u65e5\u5386\u6837\u5f0f", codelist="CalendarStyle", fields={"CALENDARSTYLE"})
    public String getCalendarStyle() {
        return this.psSysCalendar.getCALENDARSTYLE();
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    public IPSSysCalendarItem getPSSysCalendarItem(String strPSSysCalendarItemId) throws Exception {
        IPSSysCalendarItem iPSSysCalendarItem = this.psSysCalendarItemMap.get(strPSSysCalendarItemId);
        if (iPSSysCalendarItem == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e5\u5386\u89c6\u56fe\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u65e5\u5386\u9879[%1$s]", (Object)strPSSysCalendarItemId));
        }
        return iPSSysCalendarItem;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        for (IPSSysCalendarItem iPSSysCalendarItem : this.psSysCalendarItemList) {
            iPSSysCalendarItem.fillRelatedPSAppViews(relatedAppViewList);
        }
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90", fields={"EMPTYTEXTPSLANRESID"})
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        if (this.emptyTextPSLanguageRes == null && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyTextPSLanguageRes();
        }
        return this.emptyTextPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u5185\u5bb9", fields={"EMPTYTEXT"})
    public String getEmptyText() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEmptyText) && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyText();
        }
        return this.strEmptyText;
    }

    @Override
    public String getModelType() {
        return "PSSYSCALENDAR";
    }

    @Override
    public boolean hasWFDataItems() {
        return false;
    }

    @Override
    public boolean isBufferRenderer() {
        return this.bBufferRenderer;
    }

    @Override
    protected String getQuickPSDEToolbarId() {
        return this.psSysCalendar.getQUICKPSDETOOLBARID();
    }

    @Override
    protected String getBatchPSDEToolbarId() {
        return this.psSysCalendar.getBATPSDETOOLBARID();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u4f8b\u4f4d\u7f6e", codelist="FormItemLabelPos", doc="\u591a\u4e2a\u65e5\u5386\u9879\u56fe\u4f8b\u4f4d\u7f6e")
    public String getLegendPos() {
        if (this.psSysCalendarItemList == null || this.psSysCalendarItemList.size() <= 1) {
            return "NONE";
        }
        return "TOP";
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5e03\u5c40", hideempty2=true, codelist="MDCtrlGroupLayout", fields={"GROUPLAYOUT"})
    public String getGroupLayout() {
        return this.strGroupLayout;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6a21\u5f0f", hideempty2=true, codelist="MDCtrlGroupMode", fields={"GROUPMODE"})
    public String getGroupMode() {
        return this.strGroupMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5206\u7ec4", doc="\u8ba1\u7b97{@link #getGroupMode}\u8fd4\u56de\u4e0d\u7b49\u4e8e(NONE)")
    public boolean isEnableGroup() {
        return this.bEnableGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, fields={"GROUPPSDEFID"})
    public IPSAppDEField getGroupPSAppDEField() {
        return this.groupPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5bbd\u5ea6", ignoredumpvalues="0", fields={"GROUPWIDTH"})
    public int getGroupWidth() {
        return this.nGroupWidth;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u9ad8\u5ea6", ignoredumpvalues="0", fields={"GROUPHEIGHT"})
    public int getGroupHeight() {
        return this.nGroupHeight;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u7ed8\u5236\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getGroupPSSysPFPlugin() {
        return this.groupPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u7ed8\u5236\u5668", hideempty=true)
    public IPSPFXCodeObject getGroupRender() {
        return this.groupPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u9ed8\u8ba4\u754c\u9762\u6837\u5f0f", hideempty=true, fields={"GROUPPSSYSCSSID"})
    public IPSSysCss getGroupPSSysCss() {
        return this.groupPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5c5e\u6027", hideempty=true)
    public IPSDEField getGroupPSDEField() {
        return this.groupPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u4ee3\u7801\u8868", hideempty=true, dumpref=true, fields={"GROUPPSCODELISTID"})
    public IPSCodeList getGroupPSCodeList() {
        return this.groupPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, fields={"GROUPTEXTPSDEFID"})
    public IPSAppDEField getGroupTextPSAppDEField() {
        return this.groupTextPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6587\u672c\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, ignorepf=true)
    public IPSDEField getGroupTextPSDEField() {
        return this.groupTextPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", ignoredumpvalues="false", doc="\u7531\u90e8\u4ef6\u53c2\u6570{@link net.ibizsys.centralstudio.dto.PSDEViewCtrlDTO#FIELD_CTRLPARAM6}\u5b9a\u4e49")
    public boolean isEnableEdit() {
        if (this.psSysCalendarParamImpl.isEnableEdit() == null) {
            return false;
        }
        return this.psSysCalendarParamImpl.isEnableEdit();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u65e5\u5386\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSSysCalendarLogic> getPSSysCalendarLogics() {
        if (this.psSysCalendarLogicList == null || this.psSysCalendarLogicList.size() == 0) {
            return null;
        }
        return this.psSysCalendarLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psSysCalendarLogicList == null || this.psSysCalendarLogicList.size() == 0) {
            return null;
        }
        return this.psSysCalendarLogicList.iterator();
    }
}

