/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Map;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMap;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapItem;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapLogic;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapParam;
import SA.SRFDA.PS.Core.Control.Map.PSMapImpl;
import SA.SRFDA.PS.Core.Control.Map.PSSysMapItemImpl;
import SA.SRFDA.PS.Core.Control.Map.PSSysMapLogicImpl;
import SA.SRFDA.PS.Core.Control.Map.PSSysMapParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Data.PSSysMapItem;
import SA.SRFDA.PS.Data.PSSysMapLogic;
import SA.SRFDA.PS.Data.PSSysMapView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"MAP"})
public class PSSysMapImpl
extends PSMapImpl
implements IPSSysMap {
    private static final Log log = LogFactory.getLog(PSSysMapImpl.class);
    protected PSSysMapView psSysMapView;
    protected ArrayList<IPSSysMapItem> psSysMapItemList = new ArrayList();
    protected Map<String, IPSSysMapItem> psSysMapItemMap = new LinkedHashMap<String, IPSSysMapItem>();
    protected PSSysMapParamImpl psSysMapParamImpl = new PSSysMapParamImpl();
    protected String strCodeName = "";
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private boolean bBufferRenderer = true;
    private boolean bInvalidId = false;
    protected List<PSSysMapLogicImpl> psSysMapLogicList = new ArrayList<PSSysMapLogicImpl>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSSysMapParam iPSSysMapParam = (IPSSysMapParam)iPSControlParam;
            this.psSysMapView = new PSSysMapView();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSSysMapParam.getPSSysMapViewId())) {
                CallResult callResult = this.getPSModelHelper().getPSSysMapView(iPSSysMapParam.getPSSysMapViewId(), this.psSysMapView);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u5730\u56fe\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psSysMapView.getPSSYSMAPVIEWID());
            } else {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psSysMapView.getPSSYSMAPVIEWNAME());
            this.setPSObjectData(this.psSysMapView);
            if (!(this.getPSDataEntity() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.psSysMapView.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysMapView.getPSDEID()))) {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psSysMapView.getPSDEID()));
            }
            this.psSysMapParamImpl.setPSCtrlMsgId(this.psSysMapView.getPSCTRLMSGID());
            this.psSysMapParamImpl.setPSSysPFPluginId(this.psSysMapView.getPSSYSPFPLUGINID());
            this.psSysMapParamImpl.setPSSysCssId(this.psSysMapView.getPSSYSCSSID());
            this.psSysMapParamImpl.setPSDEUILogicGroupId(this.psSysMapView.getPSCTRLLOGICGROUPID());
            this.psSysMapParamImpl.merge(iPSControlParam);
            this.strCodeName = this.psSysMapView.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.strEmptyText = this.psSysMapView.getEMPTYTEXT();
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psSysMapParamImpl);
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysMapView.getEMPTYTEXTPSLANRESID())) {
            this.emptyTextPSLanguageRes = this.getPSAppView().getPSApplication().getPSLanguageRes(this.psSysMapView.getEMPTYTEXTPSLANRESID());
        }
        super.onInit();
        if (!this.bInvalidId) {
            this.onPreparePSSysMapItems();
        }
        this.initNavParams(this.psSysMapView);
    }

    @Override
    protected void onCheckControlParam() throws Exception {
        super.onCheckControlParam();
    }

    protected void onPreparePSSysMapItems() throws Exception {
        this.psSysMapItemList.clear();
        this.psSysMapItemMap.clear();
        Vector<PSSysMapItem> psSysMapItemList = new Vector<PSSysMapItem>();
        CallResult callResult = this.getPSModelHelper().getPSSysMapItems(this.getId(), psSysMapItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5730\u56fe\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSSysMapItem> psSysMapItemMap2 = new HashMap<String, PSSysMapItem>();
        for (PSSysMapItem psSysMapItem : psSysMapItemList) {
            psSysMapItemMap2.put(psSysMapItem.getPSSYSMAPITEMID(), psSysMapItem);
        }
        for (PSSysMapItem psSysMapItem : psSysMapItemList) {
            PSSysMapItemImpl iPSSysMapItem = new PSSysMapItemImpl();
            iPSSysMapItem.init(this.getDAGlobalHelper(), this, psSysMapItem);
            this.psSysMapItemList.add(iPSSysMapItem);
            this.psSysMapItemMap.put(iPSSysMapItem.getId(), iPSSysMapItem);
        }
        PSModelUtil.sort(this.psSysMapItemList);
    }

    protected void onPreparePSSysMapLogics() throws Exception {
        this.psSysMapLogicList.clear();
        this.onPreparePSSysMapLogics(this.getId());
    }

    protected void onPreparePSSysMapLogics(String strPSSysMapId) throws Exception {
        Vector<PSSysMapLogic> psSysMapLogicList = new Vector<PSSysMapLogic>();
        CallResult callResult = this.getPSModelHelper().getPSSysMapLogics(strPSSysMapId, psSysMapLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5730\u56fe\u90e8\u4ef6\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysMapLogic psSysMapLogic : psSysMapLogicList) {
            PSSysMapLogicImpl psSysMapLogicImpl = new PSSysMapLogicImpl();
            psSysMapLogicImpl.init(this.getDAGlobalHelper(), this, psSysMapLogic);
            this.psSysMapLogicList.add(psSysMapLogicImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5730\u56fe\u9879\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5143\u7d20", order=162)
    public Iterator<IPSSysMapItem> getPSSysMapItems() {
        return this.psSysMapItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u90e8\u4ef6\u53c2\u6570", outputdoc="false")
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psSysMapParamImpl;
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
    @PSModelRTMeta(description="\u5730\u56fe\u6837\u5f0f", codelist="MapViewStyle", fields={"MAPVIEWSTYLE"})
    public String getMapStyle() {
        return this.psSysMapView.getMAPVIEWSTYLE();
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    public IPSSysMapItem getPSSysMapItem(String strPSSysMapItemId) throws Exception {
        IPSSysMapItem iPSSysMapItem = this.psSysMapItemMap.get(strPSSysMapItemId);
        if (iPSSysMapItem == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5730\u56fe\u89c6\u56fe\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5730\u56fe\u9879[%1$s]", (Object)strPSSysMapItemId));
        }
        return iPSSysMapItem;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        for (IPSSysMapItem iPSSysMapItem : this.psSysMapItemList) {
            iPSSysMapItem.fillRelatedPSAppViews(relatedAppViewList);
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
        return "PSSYSMAPVIEW";
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
    @PSModelRTMeta(description="\u56fe\u4f8b\u4f4d\u7f6e", codelist="FormItemLabelPos")
    public String getLegendPos() {
        if (this.psSysMapItemList == null || this.psSysMapItemList.size() <= 1) {
            return "NONE";
        }
        return "RIGHT";
    }

    @Override
    @PSModelRTMeta(description="\u5730\u56fe\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSSysMapLogic> getPSSysMapLogics() {
        if (this.psSysMapLogicList == null || this.psSysMapLogicList.size() == 0) {
            return null;
        }
        return this.psSysMapLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psSysMapLogicList == null || this.psSysMapLogicList.size() == 0) {
            return null;
        }
        return this.psSysMapLogicList.iterator();
    }
}

