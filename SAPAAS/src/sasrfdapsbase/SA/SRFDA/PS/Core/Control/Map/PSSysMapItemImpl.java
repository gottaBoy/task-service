/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.control.map.IMapItem
 *  net.ibizsys.paas.control.map.IMapItemDataItem
 *  net.ibizsys.paas.ctrlhandler.IMapItemFetchContext
 *  net.ibizsys.paas.ctrlmodel.IMapModel
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Map;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.Map.IPSMapItemDataItem;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMap;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapItem;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapItemDataItem;
import SA.SRFDA.PS.Core.Control.PSControlItemImpl2;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
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
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSSysMapItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import net.ibizsys.paas.control.map.IMapItem;
import net.ibizsys.paas.control.map.IMapItemDataItem;
import net.ibizsys.paas.ctrlhandler.IMapItemFetchContext;
import net.ibizsys.paas.ctrlmodel.IMapModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysMapItemImpl
extends PSControlItemImpl2
implements IPSSysMapItem,
IPSControlXDataContainer {
    private static final Log log = LogFactory.getLog(PSSysMapItemImpl.class);
    private IPSSysMap iPSSysMap = null;
    protected PSSysMapItem psSysMapItem = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss iPSSysCss = null;
    private IPSDEContextMenu iPSDEContextMenu = null;
    private boolean bEnableViewActions = false;
    private long nViewActions = 0L;
    private boolean bEnableNewDataDefault = true;
    private boolean bEnableEditDataDefault = false;
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
    protected String strRemovePSDEActionName = "";
    protected String strRemovePSDEOPPrivName = "";
    private IPSLanguageRes namePSLanguageRes = null;
    private int nOrderValue = 99999;
    private ArrayList<IPSSysMapItemDataItem> psSysMapItemDataItemList = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEAction removePSDEAction = null;
    private IPSDEOPPriv removePSDEOPPriv = null;
    private IPSDELogic activeDataPSDELogic = null;
    private IPSDEField idPSDEField = null;
    private IPSDEField textPSDEField = null;
    private IPSDEField iconPSDEField = null;
    private IPSDEField contentPSDEField = null;
    private IPSDEField tipsPSDEField = null;
    private IPSDEField colorPSDEField = null;
    private IPSDEField bkcolorPSDEField = null;
    private IPSDEField orderValuePSDEField = null;
    private IPSDEField tagPSDEField = null;
    private IPSDEField tag2PSDEField = null;
    private IPSDEField latPSDEField = null;
    private IPSDEField longPSDEField = null;
    private IPSDEField altPSDEField = null;
    private IPSDEField groupPSDEField = null;
    private IPSDEField clsPSDEField = null;
    private IPSDEField dataPSDEField = null;
    private IPSDEField data2PSDEField = null;
    private IPSDEField timePSDEField = null;
    private IPSDEField shapeClsPSDEField = null;
    private IPSDEField linkPSDEField = null;
    private IPSAppDEField idPSAppDEField = null;
    private IPSAppDEField textPSAppDEField = null;
    private IPSAppDEField iconPSAppDEField = null;
    private IPSAppDEField contentPSAppDEField = null;
    private IPSAppDEField tipsPSAppDEField = null;
    private IPSAppDEField colorPSAppDEField = null;
    private IPSAppDEField bkcolorPSAppDEField = null;
    private IPSAppDEField groupPSAppDEField = null;
    private IPSAppDEField orderValuePSAppDEField = null;
    private IPSAppDEField tagPSAppDEField = null;
    private IPSAppDEField tag2PSAppDEField = null;
    private IPSAppDEField latPSAppDEField = null;
    private IPSAppDEField longPSAppDEField = null;
    private IPSAppDEField altPSAppDEField = null;
    private IPSAppDEField clsPSAppDEField = null;
    private IPSAppDEField dataPSAppDEField = null;
    private IPSAppDEField data2PSAppDEField = null;
    private IPSAppDEField timePSAppDEField = null;
    private IPSAppDEField shapeClsPSAppDEField = null;
    private IPSAppDEField linkPSAppDEField = null;
    private int nMaxSize = -1;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private IPSAppDEAction removePSAppDEAction = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private List<IPSAppDEField> psAppDEFieldList = null;
    private IPSSysCss shapePSSysCss = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysMap iPSSysMap, PSSysMapItem psSysMapItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysMap(iPSSysMap);
            this.psSysMapItem = psSysMapItem;
            this.setId(this.psSysMapItem.getPSSYSMAPITEMID());
            this.setName(this.psSysMapItem.getPSSYSMAPITEMNAME());
            this.setPSObjectData(this.psSysMapItem);
            if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getPSDEID())) {
                this.iPSDataEntity = this.getPSSysMap().getPSAppView().getPSSystem().getPSDataEntity2(this.psSysMapItem.getPSDEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getREMOVEPSDEACTIONNAME())) {
                this.bEnableRemoveDataDefault = true;
                this.strRemovePSDEActionName = this.psSysMapItem.getREMOVEPSDEACTIONNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getREMOVEPSDEOPPRIVNAME())) {
                this.strRemovePSDEOPPrivName = this.psSysMapItem.getREMOVEPSDEOPPRIVNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getNAMEPSLANRESID())) {
                this.namePSLanguageRes = this.getPSSysMap().getPSAppView().getPSApplication().getPSLanguageRes(this.psSysMapItem.getNAMEPSLANRESID());
            }
            if (!this.psSysMapItem.isORDERVALUENull()) {
                this.nOrderValue = this.psSysMapItem.getORDERVALUE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSysMap().getPSAppView().getPSSystem().getPSSysImage(this.psSysMapItem.getPSSYSIMAGEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSSysMap().getPSAppView().getPSSystem().getPSSysCss(this.psSysMapItem.getPSSYSCSSID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getSHAPEPSSYSCSSID())) {
                this.shapePSSysCss = this.getPSSysMap().getPSAppView().getPSSystem().getPSSysCss(this.psSysMapItem.getSHAPEPSSYSCSSID());
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
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u5730\u56fe[%1$s]\u9879[%2$s]\u6307\u5b9a\u5b9e\u4f53", (Object)this.getPSSysMap().getName(), (Object)this.getName()));
        }
        this.iPSAppDataEntity = this.getPSSysMap().getPSAppView().getPSApplication().getPSAppDataEntity(this.getItemType(), true);
        if (this.iPSAppDataEntity != null && StringHelper.compare((String)this.iPSAppDataEntity.getPSDataEntity().getId(), (String)this.getPSDataEntity().getId(), (boolean)false) != 0) {
            this.iPSAppDataEntity = null;
        }
        if (this.iPSAppDataEntity == null) {
            this.iPSAppDataEntity = this.getPSSysMap().getPSAppView().getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), true);
        }
        this.setEnableRemoveDataDefault(true);
        this.setEnableEditDataDefault(true);
        this.setEnablePrintDefault(this.getPSDataEntity().hasPSDEPrint());
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getPSDEDSID())) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psSysMapItem.getPSDEDSID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getREMOVEPSDEACTIONID())) {
            this.removePSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysMapItem.getREMOVEPSDEACTIONID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getREMOVEPSDEOPPRIVID())) {
            this.removePSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psSysMapItem.getREMOVEPSDEOPPRIVID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getPSDELOGICID())) {
            this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.psSysMapItem.getPSDELOGICID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getKEYPSDEFID())) {
            this.idPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getKEYPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getTEXTPSDEFID())) {
            this.textPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getTEXTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getICONPSDEFID())) {
            this.iconPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getICONPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getCONTENTPSDEFID())) {
            this.contentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getCONTENTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getTIPSPSDEFID())) {
            this.tipsPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getTIPSPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getLATPSDEFID())) {
            this.latPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getLATPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getLONGPSDEFID())) {
            this.longPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getLONGPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getALTPSDEFID())) {
            this.altPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getALTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getCOLORPSDEFID())) {
            this.colorPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getCOLORPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getBKCOLORPSDEFID())) {
            this.bkcolorPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getBKCOLORPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getORDERVALUEPSDEFID())) {
            this.orderValuePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getORDERVALUEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getGROUPPSDEFID())) {
            this.groupPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getGROUPPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getTAGPSDEFID())) {
            this.tagPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getTAGPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getTAG2PSDEFID())) {
            this.tag2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getTAG2PSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getCLSPSDEFID())) {
            this.clsPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getCLSPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getDATAPSDEFID())) {
            this.dataPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getDATAPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getDATA2PSDEFID())) {
            this.data2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getDATA2PSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getTIMEPSDEFID())) {
            this.timePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getTIMEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getSHAPECLSPSDEFID())) {
            this.shapeClsPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getSHAPECLSPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getLINKPSDEFID())) {
            this.linkPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMapItem.getLINKPSDEFID());
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
            if (this.getOrderValuePSDEField() != null) {
                this.orderValuePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getOrderValuePSDEField(), bTryMode);
            }
            if (this.getLongitudePSDEField() != null) {
                this.longPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getLongitudePSDEField(), bTryMode);
            }
            if (this.getLatitudePSDEField() != null) {
                this.latPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getLatitudePSDEField(), bTryMode);
            }
            if (this.getAltitudePSDEField() != null) {
                this.altPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getAltitudePSDEField(), bTryMode);
            }
            if (this.getGroupPSDEField() != null) {
                this.groupPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getGroupPSDEField(), bTryMode);
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
            if (this.getTimePSDEField() != null) {
                this.timePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTimePSDEField(), bTryMode);
            }
            if (this.getShapeClsPSDEField() != null) {
                this.shapeClsPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getShapeClsPSDEField(), bTryMode);
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
            if (this.getOrderValuePSAppDEField() != null) {
                psAppDEFieldMap.put(this.getOrderValuePSAppDEField().getName(), this.getOrderValuePSAppDEField());
            }
            if (this.getLongitudePSAppDEField() != null) {
                psAppDEFieldMap.put(this.getLongitudePSAppDEField().getName(), this.getLongitudePSAppDEField());
            }
            if (this.getLatitudePSAppDEField() != null) {
                psAppDEFieldMap.put(this.getLatitudePSAppDEField().getName(), this.getLatitudePSAppDEField());
            }
            if (this.getAltitudePSAppDEField() != null) {
                psAppDEFieldMap.put(this.getAltitudePSAppDEField().getName(), this.getAltitudePSAppDEField());
            }
            if (this.getGroupPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getGroupPSAppDEField().getName(), this.getGroupPSAppDEField());
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
            if (this.getTimePSAppDEField() != null) {
                psAppDEFieldMap.put(this.getTimePSAppDEField().getName(), this.getTimePSAppDEField());
            }
            if (this.getShapeClsPSAppDEField() != null) {
                psAppDEFieldMap.put(this.getShapeClsPSAppDEField().getName(), this.getShapeClsPSAppDEField());
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
            if (this.getRemovePSDEAction() != null) {
                this.removePSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getRemovePSDEAction(), bTryMode);
            }
        }
        if (!this.psSysMapItem.isMAXSIZENull()) {
            this.nMaxSize = this.psSysMapItem.getMAXSIZE();
            if (this.nMaxSize <= 0) {
                this.nMaxSize = -1;
            }
        }
        this.onPreparePSSysMapItemDataItems();
        if (!StringHelper.isNullOrEmpty((String)this.psSysMapItem.getPSDETOOLBARID())) {
            if (this.getPSDataEntity() != null && this.isEnablePrint() && this.getPSDataEntity().hasPSDEPrint()) {
                this.iPSDEPrint = this.getPSDataEntity().getDefaultPSDEPrint();
            }
            try {
                PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
                psDEViewCtrl.setPSDEVIEWCTRLNAME("cm");
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("CONTEXTMENU");
                psDEViewCtrl.setPSDETOOLBARID(this.psSysMapItem.getPSDETOOLBARID());
                psDEViewCtrl.setPSDETOOLBARNAME(this.psSysMapItem.getPSDETOOLBARNAME());
                PSDEContextMenuParamImpl psDEContextMenuParamImpl = new PSDEContextMenuParamImpl();
                psDEContextMenuParamImpl.setOwner(this);
                psDEContextMenuParamImpl.init(this.getDAGlobalHelper(), null, psDEViewCtrl);
                this.iPSDEContextMenu = (IPSDEContextMenu)this.getPSSysMap().registerPSControl("cm", "CONTEXTMENU", psDEContextMenuParamImpl);
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format((String)"\u6ce8\u518c\u4e0a\u4e0b\u6587\u83dc\u5355\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            }
        }
        super.onInit();
        this.initNavParams(this.psSysMapItem);
    }

    @Override
    @PSModelRTMeta(description="\u5730\u56fe\u90e8\u4ef6")
    public IPSSysMap getPSSysMap() {
        return this.iPSSysMap;
    }

    protected void setPSSysMap(IPSSysMap iPSSysMap) {
        this.iPSSysMap = iPSSysMap;
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
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7c7b\u578b", hideempty=true, fields={"ITEMTYPE"})
    public String getItemType() {
        return this.psSysMapItem.getITEMTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u56fe\u6807\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
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
    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90", fields={"NAMEPSLANRESID"})
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

    protected void onPreparePSSysMapItemDataItems() throws Exception {
        if (this.psSysMapItemDataItemList != null) {
            this.psSysMapItemDataItemList.clear();
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6a21\u578b\u5bf9\u8c61")
    public String getModelObj() {
        return this.psSysMapItem.getMODELOBJ();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysMap().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSSYSMAPITEM";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysMap().getModelId(), (Object)super.getModelId());
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
    @PSModelRTMeta(description="\u6700\u5927\u52a0\u8f7d\u9879\u6570", fields={"MAXSIZE"})
    public int getMaxSize() {
        return this.nMaxSize;
    }

    public Iterator<IMapItemDataItem> getMapItemDataItems() {
        return null;
    }

    @Override
    public Iterator<IPSMapItemDataItem> getPSMapItemDataItems() {
        return null;
    }

    public IMapItemDataItem getMapItemDataItem(String strName) throws Exception {
        return null;
    }

    public IMapModel getMapModel() {
        return null;
    }

    public void fillFetchResult(IMapItemFetchContext iMapItemFetchContext, ArrayList<IMapItem> calendarItemList, IDataTable dt) throws Exception {
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
        return this.psSysMapItem.getCOLOR();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u80cc\u666f\u989c\u8272", fields={"BKCOLOR"})
    public String getBKColor() {
        return this.psSysMapItem.getBKCOLOR();
    }

    public void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
    }

    public IMapItem getMapItem(IDataObject iDataObject, boolean bUpdate) throws Exception {
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

    @Override
    public IPSAppViewRef getPSAppViewRef(String strRefMode, boolean bTry) throws Exception {
        return null;
    }

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs() {
        return null;
    }

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs(String strRefModePrefix) throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u7ecf\u5ea6\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getLongitudePSDEField() {
        return this.longPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getLatitudePSDEField() {
        return this.latPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getAltitudePSDEField() {
        return this.altPSDEField;
    }

    @Override
    public String getLongitudeField() {
        if (this.getLongitudePSDEField() != null) {
            return this.getLongitudePSDEField().getName();
        }
        return null;
    }

    @Override
    public String getLatitudeField() {
        if (this.getLatitudePSDEField() != null) {
            return this.getLatitudePSDEField().getName();
        }
        return null;
    }

    @Override
    public String getAltitudeField() {
        if (this.getAltitudePSDEField() != null) {
            return this.getAltitudePSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getOrderValuePSDEField() {
        return this.orderValuePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getGroupPSDEField() {
        return this.groupPSDEField;
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
    @PSModelRTMeta(description="\u65f6\u95f4\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getTimePSDEField() {
        return this.timePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u5f62\u6837\u5f0f\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getShapeClsPSDEField() {
        return this.shapeClsPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8fb9\u6846\u989c\u8272", fields={"BORDERCOLOR"})
    public String getBorderColor() {
        return this.psSysMapItem.getBORDERCOLOR();
    }

    @Override
    @PSModelRTMeta(description="\u8fb9\u6846\u5bbd\u5ea6", fields={"BORDERWIDTH"})
    public int getBorderWidth() {
        return this.psSysMapItem.getBORDERWIDTH();
    }

    @Override
    @PSModelRTMeta(description="\u534a\u5f84", fields={"RADIUS"})
    public int getRadius() {
        return this.psSysMapItem.getRADIUS();
    }

    @Override
    public String getNavDataType() {
        return this.getItemType();
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSSysMap();
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
    @PSModelRTMeta(description="\u7ecf\u5ea6\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"LONGPSDEFID"})
    public IPSAppDEField getLongitudePSAppDEField() {
        return this.longPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"LATPSDEFID"})
    public IPSAppDEField getLatitudePSAppDEField() {
        return this.latPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"ALTPSDEFID"})
    public IPSAppDEField getAltitudePSAppDEField() {
        return this.altPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"ORDERVALUEPSDEFID"})
    public IPSAppDEField getOrderValuePSAppDEField() {
        return this.orderValuePSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"GROUPPSDEFID"})
    public IPSAppDEField getGroupPSAppDEField() {
        return this.groupPSAppDEField;
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
    @PSModelRTMeta(description="\u65f6\u95f4\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"TIMEPSDEFID"})
    public IPSAppDEField getTimePSAppDEField() {
        return this.timePSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u5f62\u6837\u5f0f\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"SHAPECLSPSDEFID"})
    public IPSAppDEField getShapeClsPSAppDEField() {
        return this.shapeClsPSAppDEField;
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
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, from="IPSAppDataEntity", fields={"PSDEDSID"})
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6570\u636e\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSAppDataEntity", fields={"REMOVEPSDEACTIONID"})
    public IPSAppDEAction getRemovePSAppDEAction() {
        return this.removePSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6837\u5f0f", codelist="MapItemStyle", fields={"ITEMSTYLE"})
    public String getItemStyle() {
        return this.psSysMapItem.getITEMSTYLE();
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
    @PSModelRTMeta(description="\u9879\u754c\u9762\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
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
    @PSModelRTMeta(description="\u94fe\u63a5\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getLinkPSDEField() {
        return this.linkPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"LINKPSDEFID"})
    public IPSAppDEField getLinkPSAppDEField() {
        return this.linkPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u67e5\u8be2\u6761\u4ef6", fields={"CUSTOMCOND"})
    public String getCustomCond() {
        return this.psSysMapItem.getCUSTOMCOND();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u5f62\u754c\u9762\u6837\u5f0f\u8868", fields={"SHAPEPSSYSCSSID"})
    public IPSSysCss getShapePSSysCss() {
        return this.shapePSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868", fields={"DYNACLASS"})
    public String getDynaClass() {
        return this.psSysMapItem.getDYNACLASS();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u5f62\u52a8\u6001\u6837\u5f0f\u8868", fields={"SHAPEDYNACLASS"})
    public String getShapeDynaClass() {
        return this.psSysMapItem.getSHAPEDYNACLASS();
    }
}

