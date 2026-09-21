/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.control.calendar.ICalendarItem
 *  net.ibizsys.paas.control.calendar.ICalendarItemDataItem
 *  net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext
 *  net.ibizsys.paas.ctrlmodel.ICalendarModel
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.BuiltinPSAppUINewDataLogicImpl;
import SA.SRFDA.PS.Core.App.Logic.BuiltinPSAppUIOpenDataLogicImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.Control.Calendar.IPSCalendarItemDataItem;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendar;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItem;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItemDataItem;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItemRV;
import SA.SRFDA.PS.Core.Control.Calendar.PSSysCalendarItemRVImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlMDObject;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.PSControlItemImpl2;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelParamImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEContextMenuParamImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSSysCalendarItem;
import SA.SRFDA.PS.Data.PSSysCalendarItemRV;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.control.calendar.ICalendarItemDataItem;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;
import net.ibizsys.paas.ctrlmodel.ICalendarModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCalendarItemImpl
extends PSControlItemImpl2
implements IPSSysCalendarItem,
IPSControlXDataContainer,
IPSControlMDObject {
    private static final Log log = LogFactory.getLog(PSSysCalendarItemImpl.class);
    private IPSSysCalendar iPSSysCalendar = null;
    protected PSSysCalendarItem psSysCalendarItem = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss iPSSysCss = null;
    private IPSDEContextMenu iPSDEContextMenu = null;
    private boolean bEnableViewActions = true;
    private long nViewActions = 0L;
    private boolean bEnableNewDataDefault = true;
    private boolean bEnableEditDataDefault = false;
    private boolean bEnableCreateDataDefault = false;
    private boolean bEnableUpdateDataDefault = false;
    private boolean bEnableRemoveDataDefault = false;
    private boolean bEnablePrintDefault = false;
    private IPSDEPrint iPSDEPrint = null;
    private IPSDataEntity iPSDataEntity = null;
    protected String strNewDataMode = "";
    protected String strEditDataMode = "";
    private boolean bLoadDefault = false;
    private boolean bEnableBatchAdd = false;
    private boolean bBatchAddOnly = false;
    private boolean bEnableQuickSearch = false;
    protected String strCreatePSDEActionName = "";
    protected String strCreatePSDEOPPrivName = "";
    protected String strUpdatePSDEActionName = "";
    protected String strUpdatePSDEOPPrivName = "";
    protected String strRemovePSDEActionName = "";
    protected String strRemovePSDEOPPrivName = "";
    private IPSLanguageRes namePSLanguageRes = null;
    private ArrayList<IPSSysCalendarItemDataItem> psSysCalendarItemDataItemList = null;
    private ArrayList<IPSSysCalendarItemRV> psSysCalendarItemRVList = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEAction removePSDEAction = null;
    private IPSDEOPPriv removePSDEOPPriv = null;
    private IPSDEAction updatePSDEAction = null;
    private IPSDEOPPriv updatePSDEOPPriv = null;
    private IPSDEAction createPSDEAction = null;
    private IPSDEOPPriv createPSDEOPPriv = null;
    private IPSDELogic activeDataPSDELogic = null;
    private IPSDEField idPSDEField = null;
    private IPSDEField textPSDEField = null;
    private IPSDEField iconPSDEField = null;
    private IPSDEField contentPSDEField = null;
    private IPSDEField tipsPSDEField = null;
    private IPSDEField beginPSDEField = null;
    private IPSDEField endPSDEField = null;
    private IPSDEField colorPSDEField = null;
    private IPSDEField bkcolorPSDEField = null;
    private IPSDEField levelPSDEField = null;
    private IPSDEField tagPSDEField = null;
    private IPSDEField tag2PSDEField = null;
    private IPSDEField clsPSDEField = null;
    private IPSDEField dataPSDEField = null;
    private IPSDEField data2PSDEField = null;
    private IPSDEField linkPSDEField = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private IPSAppDEField idPSAppDEField = null;
    private IPSAppDEField textPSAppDEField = null;
    private IPSAppDEField iconPSAppDEField = null;
    private IPSAppDEField contentPSAppDEField = null;
    private IPSAppDEField tipsPSAppDEField = null;
    private IPSAppDEField beginPSAppDEField = null;
    private IPSAppDEField endPSAppDEField = null;
    private IPSAppDEField colorPSAppDEField = null;
    private IPSAppDEField bkcolorPSAppDEField = null;
    private IPSAppDEField levelPSAppDEField = null;
    private IPSAppDEField tagPSAppDEField = null;
    private IPSAppDEField tag2PSAppDEField = null;
    private IPSAppDEField clsPSAppDEField = null;
    private IPSAppDEField dataPSAppDEField = null;
    private IPSAppDEField data2PSAppDEField = null;
    private IPSAppDEField linkPSAppDEField = null;
    private int nMaxSize = -1;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private List<IPSAppDEField> psAppDEFieldList = null;
    private IPSSysLayoutPanel iPSSysLayoutPanel = null;
    private IPSAppDEAction createPSAppDEAction = null;
    private IPSAppDEAction updatePSAppDEAction = null;
    private IPSAppDEAction removePSAppDEAction = null;
    protected Map<String, IPSAppViewRef> psAppViewRefMap = null;
    private IPSAppViewUIAction defaultPSAppViewUIAction = null;
    private IPSUIAction defaultPSUIAction = null;
    private int nOrderValue = 99999;
    private boolean bEditable = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysCalendar iPSSysCalendar, PSSysCalendarItem psSysCalendarItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysCalendar(iPSSysCalendar);
            this.psSysCalendarItem = psSysCalendarItem;
            this.setId(this.psSysCalendarItem.getPSSYSCALENDARITEMID());
            this.setName(this.psSysCalendarItem.getPSSYSCALENDARITEMNAME());
            this.setPSObjectData(this.psSysCalendarItem);
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getPSDEID())) {
                this.iPSDataEntity = this.getPSSysCalendar().getPSAppView().getPSSystem().getPSDataEntity2(this.psSysCalendarItem.getPSDEID());
            }
            if (!psSysCalendarItem.isENABLEVIEWACTIONSNull()) {
                this.bEnableViewActions = psSysCalendarItem.getENABLEVIEWACTIONS();
                if (this.bEnableViewActions) {
                    this.nViewActions = psSysCalendarItem.getVIEWACTIONS();
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getCREATEPSDEACTIONNAME())) {
                this.bEnableCreateDataDefault = true;
                this.strCreatePSDEActionName = this.psSysCalendarItem.getCREATEPSDEACTIONNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getCREATEPSDEOPPRIVNAME())) {
                this.strCreatePSDEOPPrivName = this.psSysCalendarItem.getCREATEPSDEOPPRIVNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getUPDATEPSDEACTIONNAME())) {
                this.bEnableUpdateDataDefault = true;
                this.strUpdatePSDEActionName = this.psSysCalendarItem.getUPDATEPSDEACTIONNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getUPDATEPSDEOPPRIVNAME())) {
                this.strUpdatePSDEOPPrivName = this.psSysCalendarItem.getUPDATEPSDEOPPRIVNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getREMOVEPSDEACTIONNAME())) {
                this.bEnableRemoveDataDefault = true;
                this.strRemovePSDEActionName = this.psSysCalendarItem.getREMOVEPSDEACTIONNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getREMOVEPSDEOPPRIVNAME())) {
                this.strRemovePSDEOPPrivName = this.psSysCalendarItem.getREMOVEPSDEOPPRIVNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getNAMEPSLANRESID())) {
                this.namePSLanguageRes = this.getPSSysCalendar().getPSAppView().getPSApplication().getPSLanguageRes(this.psSysCalendarItem.getNAMEPSLANRESID());
            }
            if (!this.psSysCalendarItem.isORDERVALUENull()) {
                this.nOrderValue = this.psSysCalendarItem.getORDERVALUE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSysCalendar().getPSAppView().getPSSystem().getPSSysImage(this.psSysCalendarItem.getPSSYSIMAGEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSSysCalendar().getPSAppView().getPSSystem().getPSSysCss(this.psSysCalendarItem.getPSSYSCSSID());
            }
            if (!this.psSysCalendarItem.isEDITMODENull() && this.psSysCalendarItem.getEDITMODE() == 1) {
                this.bEditable = true;
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
        if (this.getPSDataEntity() == null) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u65e5\u5386\u9879[%1$s]\u6307\u5b9a\u5b9e\u4f53", (Object)this.getName()));
        }
        this.iPSAppDataEntity = this.getPSSysCalendar().getPSAppView().getPSApplication().getPSAppDataEntity(this.getItemType(), true);
        if (this.iPSAppDataEntity != null && StringHelper.compare((String)this.iPSAppDataEntity.getPSDataEntity().getId(), (String)this.getPSDataEntity().getId(), (boolean)false) != 0) {
            this.iPSAppDataEntity = null;
        }
        if (this.iPSAppDataEntity == null) {
            this.iPSAppDataEntity = this.getPSSysCalendar().getPSAppView().getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), true);
        }
        this.setEnableRemoveDataDefault(true);
        this.setEnableEditDataDefault(true);
        this.setEnablePrintDefault(this.getPSDataEntity().hasPSDEPrint());
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getPSDEDSID())) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psSysCalendarItem.getPSDEDSID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getCREATEPSDEACTIONID())) {
            this.createPSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysCalendarItem.getCREATEPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getCREATEPSDEOPPRIVID())) {
            this.createPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psSysCalendarItem.getCREATEPSDEOPPRIVID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getUPDATEPSDEACTIONID())) {
            this.updatePSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysCalendarItem.getUPDATEPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getUPDATEPSDEOPPRIVID())) {
            this.updatePSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psSysCalendarItem.getUPDATEPSDEOPPRIVID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getREMOVEPSDEACTIONID())) {
            this.removePSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysCalendarItem.getREMOVEPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getREMOVEPSDEOPPRIVID())) {
            this.removePSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psSysCalendarItem.getREMOVEPSDEOPPRIVID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getPSDELOGICID())) {
            this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.psSysCalendarItem.getPSDELOGICID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getKEYPSDEFID())) {
            this.idPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getKEYPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getTEXTPSDEFID())) {
            this.textPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getTEXTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getICONPSDEFID())) {
            this.iconPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getICONPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getCONTENTPSDEFID())) {
            this.contentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getCONTENTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getTIPSPSDEFID())) {
            this.tipsPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getTIPSPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getBEGINPSDEFID())) {
            this.beginPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getBEGINPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getENDPSDEFID())) {
            this.endPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getENDPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getCOLORPSDEFID())) {
            this.colorPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getCOLORPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getBKCOLORPSDEFID())) {
            this.bkcolorPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getBKCOLORPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getTAGPSDEFID())) {
            this.tagPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getTAGPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getTAG2PSDEFID())) {
            this.tag2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getTAG2PSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getLEVELPSDEFID())) {
            this.levelPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getLEVELPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getCLSPSDEFID())) {
            this.clsPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getCLSPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getDATAPSDEFID())) {
            this.dataPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getDATAPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getDATA2PSDEFID())) {
            this.data2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getDATA2PSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getLINKPSDEFID())) {
            this.linkPSDEField = this.getPSDataEntity().getPSDEField(this.psSysCalendarItem.getLINKPSDEFID());
        }
        if (this.getPSAppDataEntity() != null) {
            boolean bTryMode = true;
            if (this.getPSDEDataSet() != null) {
                this.iPSAppDEDataSet = this.getPSAppDataEntity().getPSAppDEDataSet(this.getPSDEDataSet(), bTryMode);
            }
            if (this.getIdPSDEField() != null) {
                this.idPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getIdPSDEField().getId(), bTryMode);
            } else if (this.getPSDataEntity().getKeyPSDEField() != null) {
                this.idPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getKeyPSDEField(), bTryMode);
            }
            if (this.getTextPSDEField() != null) {
                this.textPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTextPSDEField().getId(), bTryMode);
            } else if (this.getPSDataEntity().getMajorPSDEField() != null) {
                this.textPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getPSDataEntity().getMajorPSDEField(), bTryMode);
            }
            if (this.getIconPSDEField() != null) {
                this.iconPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getIconPSDEField(), bTryMode);
            }
            if (this.getContentPSDEField() != null) {
                this.contentPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getContentPSDEField(), bTryMode);
            }
            if (this.getBeginTimePSDEField() != null) {
                this.beginPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getBeginTimePSDEField(), bTryMode);
            }
            if (this.getEndTimePSDEField() != null) {
                this.endPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getEndTimePSDEField(), bTryMode);
            }
            if (this.getColorPSDEField() != null) {
                this.colorPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getColorPSDEField(), bTryMode);
            }
            if (this.getBKColorPSDEField() != null) {
                this.bkcolorPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getBKColorPSDEField(), bTryMode);
            }
            if (this.getTipsPSDEField() != null) {
                this.tipsPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTipsPSDEField(), bTryMode);
            }
            if (this.getTagPSDEField() != null) {
                this.tagPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTagPSDEField(), bTryMode);
            }
            if (this.getTag2PSDEField() != null) {
                this.tag2PSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTag2PSDEField(), bTryMode);
            }
            if (this.getLevelPSDEField() != null) {
                this.levelPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getLevelPSDEField(), bTryMode);
            }
            if (this.getClsPSDEField() != null) {
                this.clsPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getClsPSDEField(), bTryMode);
            }
            if (this.getDataPSDEField() != null) {
                this.dataPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getDataPSDEField(), bTryMode);
            }
            if (this.getData2PSDEField() != null) {
                this.data2PSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getData2PSDEField(), bTryMode);
            }
            if (this.getLinkPSDEField() != null) {
                this.linkPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getLinkPSDEField(), bTryMode);
            }
            this.psAppDEFieldList = new ArrayList<IPSAppDEField>();
            LinkedHashMap<String, IPSAppDEField> psAppDEFieldMap = new LinkedHashMap<String, IPSAppDEField>();
            if (this.getIdPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getIdPSAppDEField().getName(), this.getIdPSAppDEField());
            }
            if (this.getTextPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getTextPSAppDEField().getName(), this.getTextPSAppDEField());
            }
            if (this.getIconPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getIconPSAppDEField().getName(), this.getIconPSAppDEField());
            }
            if (this.getContentPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getContentPSAppDEField().getName(), this.getContentPSAppDEField());
            }
            if (this.getBeginTimePSAppDEField() != null) {
                psAppDEFieldMap.put(this.getBeginTimePSAppDEField().getName(), this.getBeginTimePSAppDEField());
            }
            if (this.getEndTimePSAppDEField() != null) {
                psAppDEFieldMap.put(this.getEndTimePSAppDEField().getName(), this.getEndTimePSAppDEField());
            }
            if (this.getColorPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getColorPSAppDEField().getName(), this.getColorPSAppDEField());
            }
            if (this.getBKColorPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getBKColorPSAppDEField().getName(), this.getBKColorPSAppDEField());
            }
            if (this.getTipsPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getTipsPSAppDEField().getName(), this.getTipsPSAppDEField());
            }
            if (this.getTagPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getTagPSAppDEField().getName(), this.getTagPSAppDEField());
            }
            if (this.getTag2PSAppDEField() != null) {
                psAppDEFieldMap.put(this.getTag2PSAppDEField().getName(), this.getTag2PSAppDEField());
            }
            if (this.getLevelPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getLevelPSAppDEField().getName(), this.getLevelPSAppDEField());
            }
            if (this.getClsPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getClsPSAppDEField().getName(), this.getClsPSAppDEField());
            }
            if (this.getDataPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getDataPSAppDEField().getName(), this.getDataPSAppDEField());
            }
            if (this.getData2PSAppDEField() != null) {
                psAppDEFieldMap.put(this.getData2PSAppDEField().getName(), this.getData2PSAppDEField());
            }
            if (this.getLinkPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getLinkPSAppDEField().getName(), this.getLinkPSAppDEField());
            }
            this.psAppDEFieldList.addAll(psAppDEFieldMap.values());
            Collections.sort(this.psAppDEFieldList, new Comparator<IPSAppDEField>(){

                @Override
                public int compare(IPSAppDEField o1, IPSAppDEField o2) {
                    return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                }
            });
            if (this.getCreatePSDEAction() != null) {
                this.createPSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getCreatePSDEAction(), bTryMode);
            }
            if (this.getUpdatePSDEAction() != null) {
                this.updatePSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getUpdatePSDEAction(), bTryMode);
            }
            if (this.getRemovePSDEAction() != null) {
                this.removePSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getRemovePSDEAction(), bTryMode);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSSysCalendar().getPSAppView().getPSApplication() != null ? this.getPSSysCalendar().getPSAppView().getPSApplication().getPSSysPFPlugin(this.psSysCalendarItem.getPSSYSPFPLUGINID(), "CONTROLITEM", this.getPSSysCalendar().getControlType(), "ITEM") : this.getPSSysCalendar().getPSAppView().getPSSystem().getPSSysPFPlugin(this.psSysCalendarItem.getPSSYSPFPLUGINID());
            this.getPSSysCalendar().getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
        }
        if (this.getPSSysPFPlugin() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSAppView().getPSPFStyle().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSSysCalendar().getPSAppView().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSSysCalendar().getPSAppView(), (Object)this.getPSSysCalendar(), (Object)this);
            }
        }
        if (!this.psSysCalendarItem.isMAXSIZENull()) {
            this.nMaxSize = this.psSysCalendarItem.getMAXSIZE();
            if (this.nMaxSize <= 0) {
                this.nMaxSize = -1;
            }
        }
        this.onPreparePSSysCalendarItemDataItems();
        ArrayList<PSSysCalendarItemRV> psSysCalendarItemRVList = this.psSysCalendarItem.getPSSysCalendarItemRVs(false);
        if (psSysCalendarItemRVList != null) {
            if (this.psSysCalendarItemRVList == null) {
                this.psSysCalendarItemRVList = new ArrayList();
            }
            for (PSSysCalendarItemRV psSysCalendarItemRV : psSysCalendarItemRVList) {
                PSSysCalendarItemRVImpl iPSSysCalendarItemRV = new PSSysCalendarItemRVImpl();
                iPSSysCalendarItemRV.init(this.getDAGlobalHelper(), this, psSysCalendarItemRV);
                this.psSysCalendarItemRVList.add(iPSSysCalendarItemRV);
            }
            for (IPSSysCalendarItemRV iPSSysCalendarItemRV : this.psSysCalendarItemRVList) {
                String strViewRefMode = iPSSysCalendarItemRV.getName();
                IPSAppViewRef iPSAppViewRef = this.getPSAppViewRef(strViewRefMode, true);
                if (iPSAppViewRef != null) continue;
                String strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSSysCalendar().getPSAppView().getPSApplication().getId(), (String)iPSSysCalendarItemRV.getPSDEViewBaseId());
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", iPSSysCalendarItemRV.getPSDEViewBaseId());
                psAppViewRef.setParamValue("TRYMODE", true);
                psAppViewRef.setVIEWPARAMS(iPSSysCalendarItemRV.getViewParam());
                this.registerPSAppViewRef(psAppViewRef);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysCalendarItem.getPSDETOOLBARID())) {
            if (this.getPSDataEntity() != null && this.isEnablePrint() && this.getPSDataEntity().hasPSDEPrint()) {
                this.iPSDEPrint = this.getPSDataEntity().getDefaultPSDEPrint();
            }
            try {
                PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
                psDEViewCtrl.setPSDEVIEWCTRLNAME("cm");
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("CONTEXTMENU");
                psDEViewCtrl.setPSDETOOLBARID(this.psSysCalendarItem.getPSDETOOLBARID());
                psDEViewCtrl.setPSDETOOLBARNAME(this.psSysCalendarItem.getPSDETOOLBARNAME());
                PSDEContextMenuParamImpl psDEContextMenuParamImpl = new PSDEContextMenuParamImpl();
                psDEContextMenuParamImpl.setOwner(this);
                psDEContextMenuParamImpl.init(this.getDAGlobalHelper(), null, psDEViewCtrl);
                this.iPSDEContextMenu = (IPSDEContextMenu)this.getPSSysCalendar().registerPSControl("cm", "CONTEXTMENU", psDEContextMenuParamImpl);
                Iterator<IPSDEContextMenuItem> psDEContextMenuItems = this.iPSDEContextMenu.getPSDEContextMenuItems();
                if (psDEContextMenuItems != null) {
                    while (psDEContextMenuItems.hasNext()) {
                        IPSDEContextMenuItem iPSDEContextMenuItem = psDEContextMenuItems.next();
                        if (!(iPSDEContextMenuItem instanceof IPSDECMUIActionItem) || ((IPSDECMUIActionItem)iPSDEContextMenuItem).getActionLevel() != 200) continue;
                        this.defaultPSAppViewUIAction = ((IPSDECMUIActionItem)iPSDEContextMenuItem).getPSAppViewUIAction();
                        if (this.defaultPSAppViewUIAction != null) break;
                    }
                }
                if (this.getPSSysCalendar().isEnableUIModelEx() && this.defaultPSAppViewUIAction != null) {
                    this.defaultPSUIAction = this.defaultPSAppViewUIAction.getPSUIAction();
                    this.defaultPSAppViewUIAction = null;
                }
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format((String)"\u6ce8\u518c\u4e0a\u4e0b\u6587\u83dc\u5355\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            }
        }
        if (this.isPrepareDefaultPSAppViewLogics() && this.getPSAppViewRefs() != null) {
            BuiltinPSAppUIOpenDataLogicImpl defaultPSAppViewOpenDataLogicImpl;
            PSAppViewLogicImpl psAppViewLogicImpl;
            PSAppViewLogic psAppViewLogic;
            PSSysViewLogic psSysViewLogic;
            String strNewDataTag = StringHelper.format((String)"%1$s_%2$s", (Object)this.getItemType(), (Object)"newdata").toLowerCase();
            String strEditDataTag = StringHelper.format((String)"%1$s_%2$s", (Object)this.getItemType(), (Object)"editdata").toLowerCase();
            String strOpenDataTag = StringHelper.format((String)"%1$s_%2$s", (Object)this.getItemType(), (Object)"opendata").toLowerCase();
            if (this.isEnableNewData() && this.getPSSysCalendar().getPSAppViewLogic(strNewDataTag, true) == null) {
                BuiltinPSAppUINewDataLogicImpl defaultPSAppViewNewDataLogicImpl = new BuiltinPSAppUINewDataLogicImpl();
                psSysViewLogic = new PSSysViewLogic();
                psSysViewLogic.setPSSYSVIEWLOGICID("APP_NEWDATA");
                psSysViewLogic.setPSSYSVIEWLOGICNAME("\u65b0\u5efa\u6570\u636e");
                defaultPSAppViewNewDataLogicImpl.init(this.getDAGlobalHelper(), this, psSysViewLogic);
                psAppViewLogic = new PSAppViewLogic();
                psAppViewLogic.setPSAPPVIEWLOGICID(strNewDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICNAME(strNewDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
                psAppViewLogicImpl = new PSAppViewLogicImpl();
                psAppViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSSysCalendar(), psAppViewLogic, defaultPSAppViewNewDataLogicImpl);
                this.getPSSysCalendar().registerPSAppViewLogic(psAppViewLogicImpl);
            }
            if (this.isEnableEditData() && this.getPSSysCalendar().getPSAppViewLogic(strEditDataTag, true) == null) {
                defaultPSAppViewOpenDataLogicImpl = new BuiltinPSAppUIOpenDataLogicImpl();
                psSysViewLogic = new PSSysViewLogic();
                psSysViewLogic.setPSSYSVIEWLOGICID("APP_OPENDATA");
                psSysViewLogic.setPSSYSVIEWLOGICNAME("\u7f16\u8f91\u6570\u636e");
                defaultPSAppViewOpenDataLogicImpl.init(this.getDAGlobalHelper(), this, psSysViewLogic, true);
                psAppViewLogic = new PSAppViewLogic();
                psAppViewLogic.setPSAPPVIEWLOGICID(strEditDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICNAME(strEditDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
                psAppViewLogicImpl = new PSAppViewLogicImpl();
                psAppViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSSysCalendar(), psAppViewLogic, defaultPSAppViewOpenDataLogicImpl);
                this.getPSSysCalendar().registerPSAppViewLogic(psAppViewLogicImpl);
            }
            if ((this.isEnableEditData() || this.isEnableViewData()) && this.getPSSysCalendar().getPSAppViewLogic(strOpenDataTag, true) == null) {
                defaultPSAppViewOpenDataLogicImpl = new BuiltinPSAppUIOpenDataLogicImpl();
                psSysViewLogic = new PSSysViewLogic();
                psSysViewLogic.setPSSYSVIEWLOGICID("APP_OPENDATA");
                psSysViewLogic.setPSSYSVIEWLOGICNAME("\u6253\u5f00\u6570\u636e");
                defaultPSAppViewOpenDataLogicImpl.init(this.getDAGlobalHelper(), this, psSysViewLogic, false);
                psAppViewLogic = new PSAppViewLogic();
                psAppViewLogic.setPSAPPVIEWLOGICID(strOpenDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICNAME(strOpenDataTag);
                psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
                psAppViewLogicImpl = new PSAppViewLogicImpl();
                psAppViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSSysCalendar(), psAppViewLogic, defaultPSAppViewOpenDataLogicImpl);
                this.getPSSysCalendar().registerPSAppViewLogic(psAppViewLogicImpl);
            }
        }
        super.onInit();
        this.onPreparePSLayoutPanel();
        this.initNavParams(this.psSysCalendarItem);
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getPSLayoutPanel() != null) {
            this.getPSLayoutPanel().check();
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u65e5\u5386\u90e8\u4ef6")
    public IPSSysCalendar getPSSysCalendar() {
        return this.iPSSysCalendar;
    }

    protected void setPSSysCalendar(IPSSysCalendar iPSSysCalendar) {
        this.iPSSysCalendar = iPSSysCalendar;
    }

    @Override
    public String getCreatePSDEActionName() {
        return this.strCreatePSDEActionName;
    }

    public void setCreatePSDEActionName(String strCreatePSDEActionName) {
        this.strCreatePSDEActionName = strCreatePSDEActionName;
    }

    @Override
    public String getCreatePSDEOPPrivName() {
        return this.strCreatePSDEOPPrivName;
    }

    public void setCreatePSDEOPPrivName(String strCreatePSDEOPPrivName) {
        this.strCreatePSDEOPPrivName = strCreatePSDEOPPrivName;
    }

    @Override
    public String getUpdatePSDEActionName() {
        return this.strUpdatePSDEActionName;
    }

    public void setUpdatePSDEActionName(String strUpdatePSDEActionName) {
        this.strUpdatePSDEActionName = strUpdatePSDEActionName;
    }

    @Override
    public String getUpdatePSDEOPPrivName() {
        return this.strUpdatePSDEOPPrivName;
    }

    public void setUpdatePSDEOPPrivName(String strUpdatePSDEOPPrivName) {
        this.strUpdatePSDEOPPrivName = strUpdatePSDEOPPrivName;
    }

    @Override
    public String getRemovePSDEActionName() {
        return this.strRemovePSDEActionName;
    }

    public void setRemovePSDEActionName(String strRemovePSDEActionName) {
        this.strRemovePSDEActionName = strRemovePSDEActionName;
    }

    @Override
    public String getRemovePSDEOPPrivName() {
        return this.strRemovePSDEOPPrivName;
    }

    public void setRemovePSDEOPPrivName(String strRemovePSDEOPPrivName) {
        this.strRemovePSDEOPPrivName = strRemovePSDEOPPrivName;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected boolean isEnableViewActions() {
        return this.bEnableViewActions;
    }

    protected long getViewActions() {
        return this.nViewActions;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysCalendar.getPSSysModelInstId();
    }

    @Override
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bc6", hideempty=true, fields={"ITEMTYPE"})
    public String getItemType() {
        return this.psSysCalendarItem.getITEMTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u83dc\u5355\u5bf9\u8c61", modelcls="SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu", modeltype="PSDECONTEXTMENU", child=true, fields={"PSDETOOLBARID"})
    public IPSDEContextMenu getPSDEContextMenu() {
        return this.iPSDEContextMenu;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.getPSDEContextMenu() != null) {
            this.getPSDEContextMenu().fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public boolean isReadOnly() {
        return true;
    }

    @Override
    public boolean isEnableNewData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 1L) > 0L;
        }
        return this.isEnableNewDataDefault();
    }

    @Override
    public boolean isEnableEditData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 2L) > 0L;
        }
        return this.isEnableEditDataDefault();
    }

    @Override
    public boolean isEnableRemoveData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 8L) > 0L;
        }
        return this.isEnableRemoveDataDefault();
    }

    @Override
    public boolean isEnablePrint() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x80L) > 0L;
        }
        return this.isEnablePrintDefault();
    }

    @Override
    public boolean isEnableCopy() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x10L) > 0L;
        }
        return this.isEnableNewData();
    }

    protected boolean isEnableEditDataDefault() {
        return this.bEnableEditDataDefault;
    }

    protected void setEnableEditDataDefault(boolean bEnableEditDataDefault) {
        this.bEnableEditDataDefault = bEnableEditDataDefault;
    }

    protected boolean isEnableNewDataDefault() {
        return this.bEnableNewDataDefault;
    }

    protected void setEnableNewDataDefault(boolean bEnableNewDataDefault) {
        this.bEnableNewDataDefault = bEnableNewDataDefault;
    }

    protected boolean isEnableRemoveDataDefault() {
        return this.bEnableRemoveDataDefault;
    }

    protected void setEnableRemoveDataDefault(boolean bEnableRemoveDataDefault) {
        this.bEnableRemoveDataDefault = bEnableRemoveDataDefault;
    }

    @Override
    public boolean isEnableStartWF() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x800L) > 0L;
        }
        return this.isEnableStartWFDefault();
    }

    protected boolean isEnableStartWFDefault() {
        return false;
    }

    protected boolean isEnablePrintDefault() {
        return this.bEnablePrintDefault;
    }

    protected void setEnablePrintDefault(boolean bEnablePrintDefault) {
        this.bEnablePrintDefault = bEnablePrintDefault;
    }

    @Override
    public IPSDEPrint getPSDEPrint() {
        return this.iPSDEPrint;
    }

    @Override
    public boolean isPickupMode() {
        return false;
    }

    @Override
    public String getNewDataMode() {
        return this.strNewDataMode;
    }

    @Override
    public String getEditDataMode() {
        return this.strEditDataMode;
    }

    @Override
    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    @Override
    public boolean isEnableBatchAdd() {
        if (!this.isEnableNewData()) {
            return false;
        }
        return this.bEnableBatchAdd;
    }

    @Override
    public boolean isBatchAddOnly() {
        return this.bBatchAddOnly;
    }

    @Override
    public boolean isEnableViewData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 4L) > 0L;
        }
        return !this.isEnableEditData();
    }

    @Override
    public boolean isEnableImport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x400L) > 0L;
        }
        return false;
    }

    @Override
    public boolean isEnableExport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x40L) > 0L;
        }
        return false;
    }

    @Override
    public boolean isEnableFilter() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x100L) > 0L;
        }
        return this.isEnableSearch();
    }

    @Override
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    @Override
    public boolean isEnableSearch() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getNamePSLanguageRes() {
        return this.namePSLanguageRes;
    }

    @Override
    public String getIconPath() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePath();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5feb\u901f\u5efa\u7acb")
    public boolean isEnableQuickCreate() {
        return StringHelper.compare((String)this.getNewDataMode(), (String)"WIZARD", (boolean)true) == 0;
    }

    protected void onPreparePSSysCalendarItemDataItems() throws Exception {
        if (this.psSysCalendarItemDataItemList != null) {
            this.psSysCalendarItemDataItemList.clear();
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6a21\u578b\u5bf9\u8c61")
    public String getModelObj() {
        return this.psSysCalendarItem.getMODELOBJ();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysCalendar().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSSYSCALENDARITEM";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysCalendar().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    public String getDEName() {
        return this.getPSDataEntity().getName();
    }

    public String getDEDataSetName() {
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getCodeName();
        }
        return null;
    }

    @Override
    public String getIdField() {
        if (this.getIdPSDEField() != null) {
            return this.getIdPSDEField().getName();
        }
        return null;
    }

    @Override
    public String getTextField() {
        if (this.getTextPSDEField() != null) {
            return this.getTextPSDEField().getName();
        }
        return null;
    }

    @Override
    public String getIconField() {
        if (this.getIconPSDEField() != null) {
            return this.getIconPSDEField().getName();
        }
        return null;
    }

    public String getCreateDEActionName() {
        if (this.getCreatePSDEAction() == null) {
            return null;
        }
        return this.getCreatePSDEAction().getName();
    }

    @Override
    public String getCreateDataAccessAction() {
        if (this.getCreatePSDEOPPriv() == null) {
            return null;
        }
        return this.getCreatePSDEOPPriv().getName();
    }

    public String getUpdateDEActionName() {
        if (this.getUpdatePSDEAction() == null) {
            return null;
        }
        return this.getUpdatePSDEAction().getName();
    }

    @Override
    public String getUpdateDataAccessAction() {
        if (this.getUpdatePSDEOPPriv() == null) {
            return null;
        }
        return this.getUpdatePSDEOPPriv().getName();
    }

    public String getRemoveDEActionName() {
        if (this.getRemovePSDEAction() == null) {
            return null;
        }
        return this.getRemovePSDEAction().getName();
    }

    @Override
    public String getRemoveDataAccessAction() {
        if (this.getRemovePSDEOPPriv() == null) {
            return null;
        }
        return this.getRemovePSDEOPPriv().getName();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5efa\u7acb\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getCreatePSDEAction() {
        return this.createPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u8981\u6c42\u64cd\u4f5c\u6807\u8bc6", fields={"CREATEPSDEOPPRIVID"})
    public IPSDEOPPriv getCreatePSDEOPPriv() {
        return this.createPSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u66f4\u65b0\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getUpdatePSDEAction() {
        return this.updatePSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u8981\u6c42\u64cd\u4f5c\u6807\u8bc6", fields={"UPDATEPSDEOPPRIVID"})
    public IPSDEOPPriv getUpdatePSDEOPPriv() {
        return this.updatePSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5220\u9664\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getRemovePSDEAction() {
        return this.removePSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u8981\u6c42\u64cd\u4f5c\u6807\u8bc6", fields={"REMOVEPSDEOPPRIVID"})
    public IPSDEOPPriv getRemovePSDEOPPriv() {
        return this.removePSDEOPPriv;
    }

    public String getActiveDataDELogicId() {
        if (this.getActiveDataPSDELogic() == null) {
            return null;
        }
        return this.getActiveDataPSDELogic().getId();
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u8f6c\u6362\u903b\u8f91")
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bc6\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getIdPSDEField() {
        return this.idPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6587\u672c\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getTextPSDEField() {
        return this.textPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u56fe\u6807\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getIconPSDEField() {
        return this.iconPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u52a0\u8f7d\u9879\u6570")
    public int getMaxSize() {
        return this.nMaxSize;
    }

    public Iterator<ICalendarItemDataItem> getCalendarItemDataItems() {
        return null;
    }

    @Override
    public Iterator<IPSCalendarItemDataItem> getPSCalendarItemDataItems() {
        return null;
    }

    public ICalendarItemDataItem getCalendarItemDataItem(String strName) throws Exception {
        return null;
    }

    public ICalendarModel getCalendarModel() {
        return null;
    }

    public void fillFetchResult(ICalendarItemFetchContext iCalendarItemFetchContext, ArrayList<ICalendarItem> calendarItemList, IDataTable dt) throws Exception {
    }

    @Override
    public String getTipsField() {
        if (this.getTipsPSDEField() != null) {
            return this.getTipsPSDEField().getName();
        }
        return null;
    }

    @Override
    public String getContentField() {
        if (this.getContentPSDEField() != null) {
            return this.getContentPSDEField().getName();
        }
        return null;
    }

    @Override
    public String getBeginTimeField() {
        if (this.getBeginTimePSDEField() != null) {
            return this.getBeginTimePSDEField().getName();
        }
        return null;
    }

    @Override
    public String getEndTimeField() {
        if (this.getEndTimePSDEField() != null) {
            return this.getEndTimePSDEField().getName();
        }
        return null;
    }

    @Override
    public String getColorField() {
        if (this.getColorPSDEField() != null) {
            return this.getColorPSDEField().getName();
        }
        return null;
    }

    @Override
    public String getBKColorField() {
        if (this.getBKColorPSDEField() != null) {
            return this.getBKColorPSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getTipsPSDEField() {
        return this.tipsPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getContentPSDEField() {
        return this.contentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u65f6\u95f4\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getBeginTimePSDEField() {
        return this.beginPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u65f6\u95f4\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getEndTimePSDEField() {
        return this.endPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u989c\u8272\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getColorPSDEField() {
        return this.colorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u80cc\u666f\u989c\u8272\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getBKColorPSDEField() {
        return this.bkcolorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6587\u672c\u989c\u8272", fields={"COLOR"})
    public String getColor() {
        return this.psSysCalendarItem.getCOLOR();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u80cc\u666f\u989c\u8272", fields={"BKCOLOR"})
    public String getBKColor() {
        return this.psSysCalendarItem.getBKCOLOR();
    }

    @Override
    @PSModelRTMeta(description="\u65e5\u5386\u9879\u5f15\u7528\u89c6\u56fe")
    public Iterator<IPSSysCalendarItemRV> getPSSysCalendarItemRVs() {
        if (this.psSysCalendarItemRVList != null) {
            return this.psSysCalendarItemRVList.iterator();
        }
        return null;
    }

    public void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
    }

    public ICalendarItem getCalendarItem(IDataObject iDataObject, boolean bUpdate) throws Exception {
        return null;
    }

    @Override
    public String getActionAfterNewDataWizard() {
        return "DEFAULT";
    }

    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception {
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getADPSDEDQConditions();
        }
        return null;
    }

    public IPSAppViewRef registerPSAppViewRef(PSAppViewRef psAppViewRef) throws Exception {
        if (this.psAppViewRefMap == null) {
            this.psAppViewRefMap = new LinkedHashMap<String, IPSAppViewRef>();
        }
        PSAppViewRefImpl iPSAppViewRef = new PSAppViewRefImpl();
        iPSAppViewRef.init(this.getDAGlobalHelper(), this, psAppViewRef);
        this.psAppViewRefMap.put(psAppViewRef.getPSAPPVIEWREFNAME().toUpperCase(), iPSAppViewRef);
        return iPSAppViewRef;
    }

    @Override
    public IPSAppViewRef getPSAppViewRef(String strRefMode, boolean bTry) throws Exception {
        IPSAppViewRef iPSAppViewRef = null;
        if (this.psAppViewRefMap != null) {
            iPSAppViewRef = this.psAppViewRefMap.get(strRefMode.toUpperCase());
        }
        if (iPSAppViewRef == null) {
            if (bTry) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u6811\u8282\u70b9[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u89c6\u56fe[%2$s]", (Object)this.getName(), (Object)strRefMode));
        }
        return iPSAppViewRef;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bf9\u8c61\u5f15\u7528")
    public Iterator<IPSAppViewRef> getPSAppViewRefs() {
        if (this.psAppViewRefMap == null) {
            return null;
        }
        return this.psAppViewRefMap.values().iterator();
    }

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs(String strRefMode) throws Exception {
        if (this.psAppViewRefMap == null) {
            return null;
        }
        strRefMode = strRefMode.toUpperCase();
        ArrayList<IPSAppViewRef> psAppViewRefList = new ArrayList<IPSAppViewRef>();
        for (String strKey : this.psAppViewRefMap.keySet()) {
            IPSAppViewRef iPSAppViewRef;
            if (strKey.indexOf(strRefMode) != 0 || (iPSAppViewRef = this.psAppViewRefMap.get(strKey)) == null || iPSAppViewRef.getRefPSAppView() == null) continue;
            psAppViewRefList.add(iPSAppViewRef);
        }
        if (psAppViewRefList.size() == 0) {
            return null;
        }
        return psAppViewRefList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getTagPSDEField() {
        return this.tagPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0\u503c2\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getTag2PSDEField() {
        return this.tag2PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7ea7\u522b\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getLevelPSDEField() {
        return this.levelPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getDataPSDEField() {
        return this.dataPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u503c2\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getData2PSDEField() {
        return this.data2PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getLinkPSDEField() {
        return this.linkPSDEField;
    }

    @Override
    public String getLevelField() {
        if (this.getLevelPSDEField() != null) {
            return this.getLevelPSDEField().getName();
        }
        return null;
    }

    @Override
    public String getNavDataType() {
        return this.getItemType();
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSSysCalendar();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"TIPSPSDEFID"})
    public IPSAppDEField getTipsPSAppDEField() {
        return this.tipsPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"CONTENTPSDEFID"})
    public IPSAppDEField getContentPSAppDEField() {
        return this.contentPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u65f6\u95f4\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"BEGINPSDEFID"})
    public IPSAppDEField getBeginTimePSAppDEField() {
        return this.beginPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u65f6\u95f4\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"ENDPSDEFID"})
    public IPSAppDEField getEndTimePSAppDEField() {
        return this.endPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u989c\u8272\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"COLORPSDEFID"})
    public IPSAppDEField getColorPSAppDEField() {
        return this.colorPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u80cc\u666f\u989c\u8272\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"BKCOLORPSDEFID"})
    public IPSAppDEField getBKColorPSAppDEField() {
        return this.bkcolorPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bc6\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"KEYPSDEFID"})
    public IPSAppDEField getIdPSAppDEField() {
        return this.idPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6587\u672c\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"TEXTPSDEFID"})
    public IPSAppDEField getTextPSAppDEField() {
        return this.textPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u56fe\u6807\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"ICONPSDEFID"})
    public IPSAppDEField getIconPSAppDEField() {
        return this.iconPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"TAGPSDEFID"})
    public IPSAppDEField getTagPSAppDEField() {
        return this.tagPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0\u503c2\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"TAG2PSDEFID"})
    public IPSAppDEField getTag2PSAppDEField() {
        return this.tag2PSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7ea7\u522b\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"LEVELPSDEFID"})
    public IPSAppDEField getLevelPSAppDEField() {
        return this.levelPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, from="IPSAppDataEntity", fields={"PSDEDSID"})
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5c5e\u6027\u96c6\u5408", hideempty=true)
    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception {
        if (this.psAppDEFieldList == null || this.psAppDEFieldList.size() == 0) {
            return null;
        }
        return this.psAppDEFieldList.iterator();
    }

    @Override
    public String getLogicName() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    protected void onPreparePSLayoutPanel() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSSysLayoutPanelId())) {
            String strPanelName = StringHelper.format((String)"%1$slayoutpanel", (Object)this.getItemType().toLowerCase());
            if (this.getPSSysCalendar().isRegisterPSLayoutPanel()) {
                PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
                psSysPanelParamImpl.setPSSysPanelId(this.getPSSysLayoutPanelId());
                IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("PANEL");
                IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
                iPSControl.init(this.getDAGlobalHelper(), this.getPSSysCalendar(), strPanelName, psSysPanelParamImpl);
                this.iPSSysLayoutPanel = (IPSSysLayoutPanel)iPSControl;
                this.getPSSysCalendar().registerPSLayoutPanel(this.iPSSysLayoutPanel);
            } else {
                PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
                psSysPanelParamImpl.setPSSysPanelId(this.getPSSysLayoutPanelId());
                IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("VIEWLAYOUTPANEL");
                IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
                iPSControl.init(this.getDAGlobalHelper(), this.getPSSysCalendar().getPSControlContainer(), strPanelName, psSysPanelParamImpl);
                this.iPSSysLayoutPanel = (IPSSysLayoutPanel)iPSControl;
            }
        }
    }

    protected String getPSSysLayoutPanelId() {
        return this.psSysCalendarItem.getPSSYSVIEWPANELID();
    }

    @Override
    public IPSSysLayoutPanel getPSSysLayoutPanel() {
        return this.iPSSysLayoutPanel;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u5e03\u5c40\u9762\u677f", child=true, fields={"PSSYSVIEWPANELID"})
    public IPSLayoutPanel getPSLayoutPanel() {
        return this.getPSSysLayoutPanel();
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u6570\u636e\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSAppDataEntity", fields={"CREATEPSDEACTIONID"})
    public IPSAppDEAction getCreatePSAppDEAction() {
        return this.createPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u6570\u636e\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSAppDataEntity", fields={"UPDATEPSDEACTIONID"})
    public IPSAppDEAction getUpdatePSAppDEAction() {
        return this.updatePSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6570\u636e\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSAppDataEntity", fields={"REMOVEPSDEACTIONID"})
    public IPSAppDEAction getRemovePSAppDEAction() {
        return this.removePSAppDEAction;
    }

    @Override
    public String getFullModelName() {
        if (this.getOwnedPSControl() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getOwnedPSControl().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    protected boolean isPrepareDefaultPSAppViewLogics() {
        return this.getPSSysCalendar().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    @PSModelRTMeta(description="\u65e5\u5386\u9879\u9ed8\u8ba4\u884c\u4e3a", dumpref=true, ignorert=3, doc="\u53d6\u51fa\u4e0a\u4e0b\u6587\u83dc\u5355{@link #getPSDEContextMenu}\u4e2d\u9996\u4e2a\u884c\u4e3a\u7ea7\u522b{@link net.ibizsys.model.control.toolbar.IPSDECMUIActionItem#getActionLevel}\u4e3a[{@link net.ibizsys.model.PSModelEnums.UIActionLevel#OFTEN}]\u7684\u884c\u4e3a\u9879")
    public IPSAppViewUIAction getDefaultPSUIAction() {
        return this.defaultPSAppViewUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u65e5\u5386\u9879\u9ed8\u8ba4\u884c\u4e3a", dumpref=true)
    public IPSUIAction getPSUIAction() {
        return this.defaultPSUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u5185\u7f6e\u6837\u5f0f", codelist="FormDetailStyle", fields={"ITEMSTYLE"})
    public String getItemStyle() {
        String strItemStyle = this.psSysCalendarItem.getITEMSTYLE();
        if (StringHelper.isNullOrEmpty((String)strItemStyle)) {
            return "DEFAULT";
        }
        return strItemStyle;
    }

    @Override
    public String getModelRefId() {
        return this.getItemType();
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u754c\u9762\u6837\u5f0f\u8868")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", ignoredumpvalues="false", fields={"EDITMODE"})
    public boolean isEnableEdit() {
        return this.bEditable;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6837\u5f0f\u8868\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getClsPSDEField() {
        return this.clsPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6837\u5f0f\u8868\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"CLSPSDEFID"})
    public IPSAppDEField getClsPSAppDEField() {
        return this.clsPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"DATAPSDEFID"})
    public IPSAppDEField getDataPSAppDEField() {
        return this.dataPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u503c2\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"DATA2PSDEFID"})
    public IPSAppDEField getData2PSAppDEField() {
        return this.data2PSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"LINKPSDEFID"})
    public IPSAppDEField getLinkPSAppDEField() {
        return this.linkPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u67e5\u8be2\u6761\u4ef6", fields={"CUSTOMCOND"})
    public String getCustomCond() {
        return this.psSysCalendarItem.getCUSTOMCOND();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868", fields={"DYNACLASS"})
    public String getDynaClass() {
        return this.psSysCalendarItem.getDYNACLASS();
    }
}

