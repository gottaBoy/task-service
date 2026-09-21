/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBar;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBarItem;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSSysSearchBarItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSearchBarItemImplBase
extends PSSysSearchBarObjectImpl
implements IPSSysSearchBarItem {
    private static final Log log = LogFactory.getLog(PSSysSearchBarItemImplBase.class);
    protected PSSysSearchBarItem psSysSearchBarItem = null;
    private String strItemType = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;
    private String strCaption = "";
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSSysCss iPSSysCss = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss labelPSSysCss = null;
    private IPSSysCss ctrlPSSysCss = null;
    private IPSSysCounter iPSSysCounter = null;
    private IPSSysCounterRef iPSSysCounterRef = null;
    private int nCounterMode = 0;
    private String strCounterId = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysSearchBar iPSSysSearchBar, PSSysSearchBarItem psSysSearchBarItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysSearchBar(iPSSysSearchBar);
            this.psSysSearchBarItem = psSysSearchBarItem;
            this.setId(this.psSysSearchBarItem.getPSSYSSEARCHBARITEMID());
            this.setName(this.psSysSearchBarItem.getPSSYSSEARCHBARITEMNAME());
            this.setPSObjectData(this.psSysSearchBarItem);
            this.strItemType = this.psSysSearchBarItem.getITEMTYPE();
            if (this.getPSSysSearchBar().getPSDataEntity() != null) {
                if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getPSDEFID())) {
                    this.iPSDEField = this.getPSSysSearchBar().getPSDataEntity().getPSDEField(this.psSysSearchBarItem.getPSDEFID());
                }
                if (this.getPSDEField() != null && this.getPSSysSearchBar().getPSAppDataEntity() != null) {
                    this.iPSAppDEField = this.getPSSysSearchBar().getPSAppDataEntity().getPSAppDEField(this.getPSDEField(), true);
                }
            }
            this.iPSSysCounterRef = this.preparePSSysCounterRef();
            if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getCOUNTERID())) {
                this.strCounterId = this.psSysSearchBarItem.getCOUNTERID();
                if (!this.psSysSearchBarItem.isCOUNTERMODENull() && this.psSysSearchBarItem.getCOUNTERMODE() >= 0) {
                    this.nCounterMode = this.psSysSearchBarItem.getCOUNTERMODE();
                }
            }
            this.onInit();
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
        this.strCaption = this.psSysSearchBarItem.getCAPTION();
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getCAPPSLANRESID())) {
            this.capPSLanguageRes = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSLanguageRes(this.psSysSearchBarItem.getCAPPSLANRESID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.getPSSysSearchBar().getPSAppView().getPSSystem().getPSSysImage(this.psSysSearchBarItem.getPSSYSIMAGEID());
            if (this.getPSSysSearchBar().getPSAppView() != null) {
                this.getPSSysSearchBar().getPSAppView().registerPSSysImage(this.iPSSysImage);
            }
        }
        boolean bRegisterToContainer = true;
        if (this.getPSSysSearchBar().getPSAppView() != null) {
            bRegisterToContainer = this.getPSSysSearchBar().getPSAppView().getPSPFStyle().isRegisterToContainer();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getPSSYSCSSID())) {
            this.iPSSysCss = this.getPSSysSearchBar().getPSAppView().getPSSystem().getPSSysCss(this.psSysSearchBarItem.getPSSYSCSSID());
            if (bRegisterToContainer) {
                this.getPSSysSearchBar().registerPSSysCss(this.iPSSysCss);
            } else if (this.getPSSysSearchBar().getPSAppView() != null) {
                this.getPSSysSearchBar().getPSAppView().registerPSSysCss(this.iPSSysCss);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getLABELPSSYSCSSID())) {
            this.labelPSSysCss = this.getPSSysSearchBar().getPSAppView().getPSSystem().getPSSysCss(this.psSysSearchBarItem.getLABELPSSYSCSSID());
            if (bRegisterToContainer) {
                this.getPSSysSearchBar().registerPSSysCss(this.labelPSSysCss);
            } else if (this.getPSSysSearchBar().getPSAppView() != null) {
                this.getPSSysSearchBar().getPSAppView().registerPSSysCss(this.labelPSSysCss);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getCTRLPSSYSCSSID())) {
            this.ctrlPSSysCss = this.getPSSysSearchBar().getPSAppView().getPSSystem().getPSSysCss(this.psSysSearchBarItem.getCTRLPSSYSCSSID());
            if (bRegisterToContainer) {
                this.getPSSysSearchBar().registerPSSysCss(this.ctrlPSSysCss);
            } else if (this.getPSSysSearchBar().getPSAppView() != null) {
                this.getPSSysSearchBar().getPSAppView().registerPSSysCss(this.ctrlPSSysCss);
            }
        }
        super.onInit();
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getPSSYSCOUNTERID()) && this.getPSSysSearchBar().getPSAppView() != null) {
            this.iPSSysCounter = this.getPSSysSearchBar().getPSAppView().getPSSystem().getPSSysCounter(this.psSysSearchBarItem.getPSSYSCOUNTERID(), false);
            IPSAppCounter iPSAppCounter = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSAppCounter(this.psSysSearchBarItem.getPSSYSCOUNTERID(), false);
            this.iPSSysCounter = iPSAppCounter;
            if (this.isPrepareTemplV2logic()) {
                return this.getPSSysSearchBar().registerPSAppCounter(iPSAppCounter, null);
            }
            return this.getPSSysSearchBar().getPSAppView().registerPSSysCounter(iPSAppCounter, null);
        }
        return null;
    }

    protected boolean isPrepareTemplV2logic() {
        return this.getPSSysSearchBar().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7c7b\u578b", codelist="SearchBarItemType", fields={"ITEMTYPE"})
    public String getItemType() {
        return this.strItemType;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    public boolean isDesignMode() {
        return this.getPSSysSearchBar().isDesignMode();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6570\u636e", fields={"DATA"})
    public String getData() {
        return this.psSysSearchBarItem.getDATA();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysSearchBar().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() == null) {
            return null;
        }
        return this.getCapPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u9879\u754c\u9762\u6837\u5f0f\u8868")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u56fe\u7247\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    public String getPredefinedType() {
        return null;
    }

    public String getRenderMode() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6837\u5f0f\u8868\u5bf9\u8c61", fields={"LABELPSSYSCSSID"})
    public IPSSysCss getLabelPSSysCss() {
        return this.labelPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"LABELRAWCSSSTYLE"})
    public String getLabelCssStyle() {
        return this.psSysSearchBarItem.getLABELRAWCSSSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"RAWCSSSTYLE"})
    public String getCssStyle() {
        return this.psSysSearchBarItem.getRAWCSSSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u52a8\u6001\u6837\u5f0f\u8868", hideempty2=true, fields={"LABELDYNACLASS"})
    public String getLabelDynaClass() {
        return this.psSysSearchBarItem.getLABELDYNACLASS();
    }

    public IPSSysCss getCtrlPSSysCss() {
        return this.ctrlPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868", fields={"DYNACLASS"})
    public String getDynaClass() {
        return this.psSysSearchBarItem.getDYNACLASS();
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

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bc6", fields={"COUNTERID"})
    public String getCounterId() {
        return this.strCounterId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6a21\u5f0f", codelist="DETreeNodeCounterMode", ignoredumpvalues="0", fields={"COUNTERMODE"})
    public int getCounterMode() {
        return this.nCounterMode;
    }

    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    @Override
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true, from="IPSSysSearchBar", fields={"PSSYSCOUNTERID"})
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return this.getOwnedPSControl().getPSControlRendersByItemName(this.getName());
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSSysSearchBar();
    }
}

