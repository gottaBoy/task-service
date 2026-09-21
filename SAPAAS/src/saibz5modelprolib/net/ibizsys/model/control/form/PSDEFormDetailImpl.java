/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.form.IPSDEFDGroupLogic
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormDRUIPart
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormGroupPanel
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.form.IPSDEFDGroupLogic;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormDetailRuntime;
import net.ibizsys.model.control.form.IPSDEFormGroupPanel;
import net.ibizsys.model.control.form.IPSDEFormRuntime;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEFormDetailImpl
extends PSObjectImpl
implements IPSDEFormDetail,
IPSDEFormDetailRuntime {
    private static final Log log = LogFactory.getLog(PSDEFormDetailImpl.class);
    protected IPSDEForm iPSDEForm;
    protected IPSDEFormDetail parentPSDEFormDetail;
    protected PSDEFormDetail psDEFormDetail;
    protected String strCaption = "";
    protected double fContentWidth = 0.0;
    protected double fWidth = 0.0;
    protected double fContentHeight = 0.0;
    protected double fHeight = 0.0;
    protected String strParentLayoutMode = "";
    private HashMap<String, IPSDEFDGroupLogic> psDEFDGroupLogicMap = null;
    protected static String[] DEFDLogicCats = new String[]{"PANELVISIBLE", "ITEMBLANK", "ITEMENABLE"};
    protected String strCssStyle = "";
    protected int nColSpan = 1;
    protected int nRowSpan = 1;
    private String strUniqueId = "";
    protected IPSDEFormGroupPanel parentPSDEFormGroupPanel = null;
    private int nColXS = -1;
    private int nColSM = -1;
    private int nColMD = -1;
    private int nColLG = -1;
    private int nColXSOffset = -1;
    private int nColSMOffset = -1;
    private int nColMDOffset = -1;
    private int nColLGOffset = -1;
    private String strColCssClass = "";
    private IPSSysCss iPSSysCss = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCounter iPSSysCounter = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysCss labelPSSysCss = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private int nColWidth = -1;
    private String strLayoutMode = "";
    private String strBorderLayoutPos = "";

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEForm iPSDEForm, IPSDEFormDetail parentPSDEFormDetail, PSDEFormDetail psDEFormDetail) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEForm = iPSDEForm;
            this.psDEFormDetail = psDEFormDetail;
            this.parentPSDEFormDetail = parentPSDEFormDetail;
            if (this.parentPSDEFormDetail != null && this.parentPSDEFormDetail instanceof IPSDEFormGroupPanel) {
                this.parentPSDEFormGroupPanel = (IPSDEFormGroupPanel)this.parentPSDEFormDetail;
            }
            this.setId(psDEFormDetail.getPSDEFORMDETAILID());
            this.setName(psDEFormDetail.getPSDEFORMDETAILNAME().toLowerCase());
            this.setPSObjectData(psDEFormDetail);
            this.strUniqueId = ((IPSAppViewRuntime)iPSDEForm.getPSAppView()).generateCtrlUniId();
            this.strCaption = this.psDEFormDetail.getCAPTION();
            if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDEForm().getPSAppView().getPSSystem().getPSLanguageRes(this.psDEFormDetail.getCAPPSLANRESID());
            }
            this.strCssStyle = this.psDEFormDetail.getCSSTYLE();
            this.strBorderLayoutPos = this.psDEFormDetail.getBL_POS();
            this.strLayoutMode = this.psDEFormDetail.getLAYOUTMODE();
            if (StringHelper.isNullOrEmpty((String)this.strLayoutMode)) {
                if (this.parentPSDEFormGroupPanel == null) {
                    this.strLayoutMode = this.getPSDEForm().getLayoutMode();
                    if (StringHelper.isNullOrEmpty((String)this.strLayoutMode)) {
                        this.strLayoutMode = "TABLE";
                    }
                } else {
                    this.strLayoutMode = this.parentPSDEFormGroupPanel.getLayoutMode();
                }
            }
            int nColumnCount = 12;
            if (StringHelper.compare((String)this.strLayoutMode, (String)"TABLE_12COL", (boolean)true) == 0) {
                nColumnCount = 12;
            } else if (StringHelper.compare((String)this.strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
                nColumnCount = 24;
            }
            if (this.psDEFormDetail.getCOLSPAN() > 0) {
                this.nColSpan = this.psDEFormDetail.getCOLSPAN();
            }
            if (this.psDEFormDetail.getROWSPAN() > 0) {
                this.nRowSpan = this.psDEFormDetail.getROWSPAN();
            }
            if (!this.psDEFormDetail.isCOL_XSNull()) {
                this.nColXS = this.psDEFormDetail.getCOL_XS();
                if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                    this.nColXS *= 2;
                }
                if (this.nColXS <= 0 && this.nColXS > nColumnCount) {
                    this.nColXS = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_SMNull()) {
                this.nColSM = this.psDEFormDetail.getCOL_SM();
                if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                    this.nColSM *= 2;
                }
                if (this.nColSM <= 0 && this.nColSM > nColumnCount) {
                    this.nColSM = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_MDNull()) {
                this.nColMD = this.psDEFormDetail.getCOL_MD();
                if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                    this.nColMD *= 2;
                }
                if (this.nColMD <= 0 && this.nColMD > nColumnCount) {
                    this.nColMD = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_LGNull()) {
                this.nColLG = this.psDEFormDetail.getCOL_LG();
                if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                    this.nColLG *= 2;
                }
                if (this.nColLG <= 0 && this.nColLG > nColumnCount) {
                    this.nColLG = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_XS_OSNull()) {
                this.nColXSOffset = this.psDEFormDetail.getCOL_XS_OS();
                if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                    this.nColXSOffset *= 2;
                }
                if (this.nColXSOffset <= 0 && this.nColXSOffset > nColumnCount - 1) {
                    this.nColXSOffset = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_SM_OSNull()) {
                this.nColSMOffset = this.psDEFormDetail.getCOL_SM_OS();
                if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                    this.nColSMOffset *= 2;
                }
                if (this.nColSMOffset <= 0 && this.nColSMOffset > nColumnCount - 1) {
                    this.nColSMOffset = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_MD_OSNull()) {
                this.nColMDOffset = this.psDEFormDetail.getCOL_MD_OS();
                if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                    this.nColMDOffset *= 2;
                }
                if (this.nColMDOffset <= 0 && this.nColMDOffset > nColumnCount - 1) {
                    this.nColMDOffset = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_LG_OSNull()) {
                this.nColLGOffset = this.psDEFormDetail.getCOL_LG_OS();
                if (this.getPSDEFormRuntime().isEnableCol12ToCol24()) {
                    this.nColLGOffset *= 2;
                }
                if (this.nColLGOffset <= 0 && this.nColLGOffset > nColumnCount - 1) {
                    this.nColLGOffset = -1;
                }
            }
            if (!this.psDEFormDetail.isCOL_WIDTHNull()) {
                this.nColWidth = this.psDEFormDetail.getCOL_WIDTH();
                if (this.nColWidth <= 0 && this.nColWidth > nColumnCount - 1) {
                    this.nColWidth = -1;
                }
            }
            if (this.parentPSDEFormGroupPanel != null) {
                if (this.nColXS == -1) {
                    this.nColXS = this.parentPSDEFormGroupPanel.getChildColXS();
                }
                if (this.nColSM == -1) {
                    this.nColSM = this.parentPSDEFormGroupPanel.getChildColSM();
                }
                if (this.nColMD == -1) {
                    this.nColMD = this.parentPSDEFormGroupPanel.getChildColMD();
                }
                if (this.nColLG == -1) {
                    this.nColLG = this.parentPSDEFormGroupPanel.getChildColLG();
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEFormDetail.getPSSYSCSSID());
                if (this.getPSDEForm().getPSAppView() != null) {
                    ((IPSAppViewRuntime)this.getPSDEForm().getPSAppView()).registerPSSysCss(this.iPSSysCss);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getLABELPSSYSCSSID())) {
                this.labelPSSysCss = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysCss(this.psDEFormDetail.getLABELPSSYSCSSID());
                if (this.getPSDEForm().getPSAppView() != null) {
                    ((IPSAppViewRuntime)this.getPSDEForm().getPSAppView()).registerPSSysCss(this.labelPSSysCss);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysImage(this.psDEFormDetail.getPSSYSIMAGEID());
                if (this.getPSDEForm().getPSAppView() != null) {
                    ((IPSAppViewRuntime)this.getPSDEForm().getPSAppView()).registerPSSysImage(this.iPSSysImage);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPSSYSCOUNTERID())) {
                this.iPSSysCounter = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSSysCounter(this.psDEFormDetail.getPSSYSCOUNTERID(), false);
                if (this.getPSDEForm().getPSAppView() != null) {
                    ((IPSAppViewRuntime)this.getPSDEForm().getPSAppView()).registerPSSysCounter(this.iPSSysCounter, null);
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    public String getCodeName() {
        return this.getName();
    }

    @Override
    protected void onInit() throws Exception {
        if (!this.getPSDEFormRuntime().isDesignMode() && !StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getUCPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = ((IPSSystemRuntime)this.getPSDEForm().getPSDataEntity().getPSSystem()).getPSSysPFPlugin(this.psDEFormDetail.getUCPSSYSPFPLUGINID());
        }
        super.onInit();
        this.strColCssClass = this.prepareColCssClass();
        this.onPreparePSDEFDLogics();
    }

    protected String prepareColCssClass() {
        StringBuilderEx sb = new StringBuilderEx();
        if (this.nColXS != -1) {
            sb.append(" col-xs-%1$s", (Object)this.nColXS);
        }
        if (this.nColSM != -1) {
            sb.append(" col-sm-%1$s", (Object)this.nColSM);
        }
        if (this.nColMD != -1) {
            sb.append(" col-md-%1$s", (Object)this.nColMD);
        }
        if (this.nColLG != -1) {
            sb.append(" col-lg-%1$s", (Object)this.nColLG);
        }
        if (this.nColXSOffset != -1) {
            sb.append(" col-xs-offset-%1$s", (Object)this.nColXSOffset);
        }
        if (this.nColSMOffset != -1) {
            sb.append(" col-sm-offset-%1$s", (Object)this.nColSMOffset);
        }
        if (this.nColMDOffset != -1) {
            sb.append(" col-md-offset-%1$s", (Object)this.nColMDOffset);
        }
        if (this.nColLGOffset != -1) {
            sb.append(" col-lg-offset-%1$s", (Object)this.nColLGOffset);
        }
        return sb.toString();
    }

    protected void onPreparePSDEFDLogics() throws Exception {
        String[] stringArray = DEFDLogicCats;
        int n = DEFDLogicCats.length;
        int n2 = 0;
        while (n2 < n) {
            String strDEFDLogicCat = stringArray[n2];
            ArrayList<PSDEFDLogic> psDEFDLogicList = this.psDEFormDetail.getChildPSDEFDLogics(strDEFDLogicCat, false);
            if (psDEFDLogicList != null) {
                if (this.psDEFDGroupLogicMap == null) {
                    this.psDEFDGroupLogicMap = new HashMap();
                }
                PSDEFDLogic psDEFDLogic = new PSDEFDLogic();
                psDEFDLogic.setGROUPOP("AND");
                psDEFDLogic.setLOGICTYPE("GROUP");
                psDEFDLogic.setLOGICCAT(strDEFDLogicCat);
                psDEFDLogic.getChildPSDEFDLogics(true).addAll(psDEFDLogicList);
                IPSDEFDLogic iPSDEFDLogic = this.getPSModelStorageContext().createPSDEFDLogic(this, null, psDEFDLogic);
                this.psDEFDGroupLogicMap.put(strDEFDLogicCat, (IPSDEFDGroupLogic)iPSDEFDLogic);
            }
            ++n2;
        }
    }

    @Override
    public void layout() throws Exception {
        this.onLayout();
    }

    protected void onLayout() throws Exception {
        double fWidth;
        double fHeight;
        if (this.getParentPSDEFormDetail() == null) {
            return;
        }
        IPSDEFormGroupPanel iPSDEFormGroupPanel = null;
        if (this.getParentPSDEFormDetail() instanceof IPSDEFormGroupPanel) {
            iPSDEFormGroupPanel = (IPSDEFormGroupPanel)this.getParentPSDEFormDetail();
        }
        if (iPSDEFormGroupPanel == null) {
            return;
        }
        this.fContentHeight = fHeight = (this.fHeight = (double)this.psDEFormDetail.getHEIGHT());
        this.fContentWidth = fWidth = (this.fWidth = (double)this.psDEFormDetail.getWIDTH());
        String strLayoutType = iPSDEFormGroupPanel.getLayoutMode();
        this.setParentLayoutMode(iPSDEFormGroupPanel.getLayoutMode());
        if (StringHelper.compare((String)strLayoutType, (String)"TABLE_12COL", (boolean)true) != 0) {
            StringHelper.compare((String)strLayoutType, (String)"TABLE_24COL", (boolean)true);
        }
        if (StringHelper.compare((String)strLayoutType, (String)"BORDER", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)this.getBorderLayoutPos())) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u8868\u5355\u6210\u5458[%1$s]\u6307\u5b9a\u8fb9\u7f18\u5e03\u5c40\u4f4d\u7f6e", (Object)this.getName()));
            }
            if (StringHelper.compare((String)this.getBorderLayoutPos(), (String)"CENTER", (boolean)true) == 0) {
                this.fWidth = 0.0;
                this.fHeight = 0.0;
            } else if (StringHelper.compare((String)this.getBorderLayoutPos(), (String)"EAST", (boolean)true) == 0 || StringHelper.compare((String)this.getBorderLayoutPos(), (String)"WEST", (boolean)true) == 0) {
                this.fHeight = 0.0;
                if (this.fWidth <= 1.0) {
                    throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u8868\u5355\u6210\u5458[%1$s]\u6307\u5b9a\u8fb9\u7f18\u5e03\u5c40\u5bbd\u5ea6", (Object)this.getName()));
                }
            } else if (StringHelper.compare((String)this.getBorderLayoutPos(), (String)"NORTH", (boolean)true) == 0 || StringHelper.compare((String)this.getBorderLayoutPos(), (String)"SOUTH", (boolean)true) == 0) {
                this.fWidth = 0.0;
                if (this.fHeight <= 1.0) {
                    throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u8868\u5355\u6210\u5458[%1$s]\u6307\u5b9a\u8fb9\u7f18\u5e03\u5c40\u9ad8\u5ea6", (Object)this.getName()));
                }
            }
        }
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        if (StringHelper.isNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption();
        }
        return this.strCaption;
    }

    protected String onGetCaption() {
        return "";
    }

    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.capPSLanguageRes == null) {
            return this.onGetCapPSLanguageRes();
        }
        return this.capPSLanguageRes;
    }

    protected IPSLanguageRes onGetCapPSLanguageRes() {
        return null;
    }

    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() == null) {
            return null;
        }
        return this.getCapPSLanguageRes().getLanResTag();
    }

    @PSModelRTMeta(description="\u662f\u5426\u663e\u793a\u6807\u9898")
    public boolean isShowCaption() {
        if (this.psDEFormDetail.isSHOWCAPTIONNull()) {
            return true;
        }
        return this.psDEFormDetail.getSHOWCAPTION();
    }

    public IPSDEForm getPSDEForm() {
        return this.iPSDEForm;
    }

    protected IPSDEFormRuntime getPSDEFormRuntime() {
        return (IPSDEFormRuntime)this.getPSDEForm();
    }

    public IPSDEFormDetail getParentPSDEFormDetail() {
        return this.parentPSDEFormDetail;
    }

    @PSModelRTMeta(description="\u6210\u5458\u7c7b\u578b")
    public String getDetailType() {
        return this.psDEFormDetail.getDETAILTYPE();
    }

    @PSModelRTMeta(description="\u5185\u5bb9\u5bbd\u5ea6")
    public double getContentWidth() {
        return this.fContentWidth;
    }

    @PSModelRTMeta(description="\u5185\u5bb9\u9ad8\u5ea6")
    public double getContentHeight() {
        return this.fContentHeight;
    }

    @PSModelRTMeta(description="\u5bbd\u5ea6")
    public double getWidth() {
        return this.fWidth;
    }

    @PSModelRTMeta(description="\u9ad8\u5ea6")
    public double getHeight() {
        return this.fHeight;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
    }

    @Override
    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList) {
    }

    protected void setParentLayoutMode(String strParentLayoutMode) {
        this.strParentLayoutMode = strParentLayoutMode;
    }

    public String getParentLayoutMode() {
        return this.strParentLayoutMode;
    }

    public IPSDEFDGroupLogic getPSDEFDGroupLogic(String strCat) throws Exception {
        if (this.psDEFDGroupLogicMap == null) {
            return null;
        }
        IPSDEFDGroupLogic iPSDEFDGroupLogic = this.psDEFDGroupLogicMap.get(strCat);
        return iPSDEFDGroupLogic;
    }

    public boolean isDesignMode() {
        return this.getPSDEFormRuntime().isDesignMode();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEFormRuntime().getPSSysModelInstId();
    }

    @Deprecated
    public String getCssStyle() {
        return this.strCssStyle;
    }

    public int getColSpan() throws Exception {
        return this.nColSpan;
    }

    public int getRowSpan() throws Exception {
        return this.nRowSpan;
    }

    public final String getUniqueId() {
        return this.strUniqueId;
    }

    public int getColXS() {
        return this.nColXS;
    }

    public int getColSM() {
        return this.nColSM;
    }

    public int getColMD() {
        return this.nColMD;
    }

    public int getColLG() {
        return this.nColLG;
    }

    public int getColXSOffset() {
        return this.nColXSOffset;
    }

    public int getColSMOffset() {
        return this.nColSMOffset;
    }

    public int getColMDOffset() {
        return this.nColMDOffset;
    }

    public int getColLGOffset() {
        return this.nColLGOffset;
    }

    public String getColCssClass() {
        return this.strColCssClass;
    }

    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    public IPSSysCss getLabelPSSysCss() {
        return this.labelPSSysCss;
    }

    public int getColWidth() {
        return this.nColWidth;
    }

    @Override
    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> psDEFormDetailList) {
        psDEFormDetailList.add(this);
    }

    public IPSDEFormDetail getRootPSDEFormDetail() {
        if (this.getParentPSDEFormDetail() == null) {
            return this;
        }
        return this.getParentPSDEFormDetail().getRootPSDEFormDetail();
    }

    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    public IPSSystem getPSSystem() {
        return this.getPSDEForm().getPSDataEntity().getPSSystem();
    }

    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0")
    public String getUserTag() {
        return this.psDEFormDetail.getUSERTAG();
    }

    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02")
    public String getUserTag2() {
        return this.psDEFormDetail.getUSERTAG2();
    }

    @PSModelRTMeta(description="\u6210\u5458\u6837\u5f0f", codelist="FormDetailStyle")
    public String getDetailStyle() {
        String strDetailStyle = this.psDEFormDetail.getDETAILSTYLE();
        if (StringHelper.isNullOrEmpty((String)strDetailStyle)) {
            return "DEFAULT";
        }
        return strDetailStyle;
    }

    @PSModelRTMeta(description="\u8fb9\u7f18\u5e03\u5c40\u4f4d\u7f6e")
    public String getBorderLayoutPos() {
        return this.strBorderLayoutPos;
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)this.getPSSystem();
    }

    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"name", (Object)this.getName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"type", (Object)this.getDetailType());
    }
}

