/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.dataexport.IPSDEDataExport
 *  net.ibizsys.model.dataentity.dr.IPSDEDRGroup
 *  net.ibizsys.model.dataentity.dr.IPSDEDRItem
 *  net.ibizsys.model.dataentity.dr.IPSDEDataRelation
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.IPSLinkDEField
 *  net.ibizsys.model.dataentity.field.IPSPickupDEField
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainState
 *  net.ibizsys.model.dataentity.print.IPSDEPrint
 *  net.ibizsys.model.dataentity.priv.IPSDEOPPriv
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup
 *  net.ibizsys.model.dataentity.util.IPSDEUtil
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.model.der.IPSDER11
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.model.der.IPSDERBase
 *  net.ibizsys.model.der.IPSDERIndex
 *  net.ibizsys.model.der.IPSDERInherit
 *  net.ibizsys.model.der.IPSDERMultiInherit
 *  net.ibizsys.model.der.IPSDERNN
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.model.sys.IPSSystemModule
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDEACMode
 *  net.ibizsys.paas.core.IDEAction
 *  net.ibizsys.paas.core.IDEActionWizard
 *  net.ibizsys.paas.core.IDEActionWizardGroup
 *  net.ibizsys.paas.core.IDEBATable
 *  net.ibizsys.paas.core.IDEDBConfig
 *  net.ibizsys.paas.core.IDEDataExport
 *  net.ibizsys.paas.core.IDEDataImport
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataSet
 *  net.ibizsys.paas.core.IDEDataSync
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDELogic
 *  net.ibizsys.paas.core.IDEMainState
 *  net.ibizsys.paas.core.IDEOPPrivRole
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.core.IDERIndex
 *  net.ibizsys.paas.core.IDEUIAction
 *  net.ibizsys.paas.core.IDEUniState
 *  net.ibizsys.paas.core.IDEUserRole
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.data.ISimpleDataObject
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.control.ajax.PSAjaxControlHandlerGlobalModel;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.dataentity.PSDataEntityException;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ac.PSDEACModeGlobalModel;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.action.PSDEActionGlobalModel;
import net.ibizsys.model.dataentity.dataexport.IPSDEDataExport;
import net.ibizsys.model.dataentity.der.MajorPSDERGlobalModel;
import net.ibizsys.model.dataentity.der.MinorPSDERGlobalModel;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;
import net.ibizsys.model.dataentity.dr.PSDEDRGlobalModel;
import net.ibizsys.model.dataentity.dr.PSDEDRGroupGlobalModel;
import net.ibizsys.model.dataentity.dr.PSDEDRItemGlobalModel;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.ds.PSDEDataQueryGlobalModel;
import net.ibizsys.model.dataentity.ds.PSDEDataSetGlobalModel;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSDEFieldRuntime;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.dataentity.field.IPSLinkDEField;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.PSDELogicGlobalModel;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.mainstate.PSDEMainStateGlobalModel;
import net.ibizsys.model.dataentity.print.IPSDEPrint;
import net.ibizsys.model.dataentity.print.PSDEPrintGlobalModel;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionGlobalModel;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionGroupGlobalModel;
import net.ibizsys.model.dataentity.util.IPSDEUtil;
import net.ibizsys.model.dataentity.util.PSDEUtilGlobalModel;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.dataentity.wf.PSDEWFGlobalModel;
import net.ibizsys.model.der.IPSDER11;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.der.IPSDERIndex;
import net.ibizsys.model.der.IPSDERInherit;
import net.ibizsys.model.der.IPSDERMultiInherit;
import net.ibizsys.model.der.IPSDERNN;
import net.ibizsys.model.der.PSDERNNImpl;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSDEACMode;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSDEPrint;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSDataEntity;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.sys.IPSSystemModule;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEAction;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IDEActionWizardGroup;
import net.ibizsys.paas.core.IDEBATable;
import net.ibizsys.paas.core.IDEDBConfig;
import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSync;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDELogic;
import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IDEOPPrivRole;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.core.IDEUniState;
import net.ibizsys.paas.core.IDEUserRole;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDataEntityImpl
extends PSSystemObjectImpl
implements IPSDataEntity,
IPSDataEntityRuntime {
    private static final Log log = LogFactory.getLog(PSDataEntityImpl.class);
    public static final String CODETYPE_SUBSYS = "SUBSYS_";
    protected ArrayList<IPSDEField> defHelpers;
    protected ArrayList<IDEField> deFieldList;
    protected Hashtable<String, IPSDEField> defHelperMap;
    protected Hashtable<String, IPSDEField> defHelperMapByName;
    protected Hashtable<String, String> preDefineFields = null;
    protected PSDataEntity psDataEntity = null;
    private IPSDEField keyDEField = null;
    private IPSDEField uniTagDEField = null;
    private IPSDEField majorDEField = null;
    private IPSDEField indexTypeDEField = null;
    private IPSDEField formTypeDEField = null;
    private IPSDEField updateDateDEField = null;
    private IPSDEField orgUnitIdDEField = null;
    protected PSDEUIActionGlobalModel psDEUIActionGlobalModel = new PSDEUIActionGlobalModel();
    protected PSDEUIActionGroupGlobalModel psDEUIActionGroupGlobalModel = new PSDEUIActionGroupGlobalModel();
    protected MajorPSDERGlobalModel majorPSDERGlobalModel = new MajorPSDERGlobalModel();
    protected MinorPSDERGlobalModel minorPSDERGlobalModel = new MinorPSDERGlobalModel();
    protected PSDEDataQueryGlobalModel psDEDataQueryGlobalModel = new PSDEDataQueryGlobalModel();
    protected PSDEDataSetGlobalModel psDEDataSetGlobalModel = new PSDEDataSetGlobalModel();
    protected PSAjaxControlHandlerGlobalModel psAjaxControlHandlerGlobalModel = new PSAjaxControlHandlerGlobalModel();
    protected PSDEActionGlobalModel psDEActionGlobalModel = new PSDEActionGlobalModel();
    protected PSDELogicGlobalModel psDELogicGlobalModel = new PSDELogicGlobalModel();
    protected PSDEACModeGlobalModel psDEACModeGlobalModel = new PSDEACModeGlobalModel();
    protected PSDEDRGlobalModel psDEDataRelationGlobalModel = new PSDEDRGlobalModel();
    protected PSDEDRGroupGlobalModel psDEDRGroupGlobalModel = new PSDEDRGroupGlobalModel();
    protected PSDEDRItemGlobalModel psDEDRItemGlobalModel = new PSDEDRItemGlobalModel();
    protected PSDEWFGlobalModel psDEWFGlobalModel = new PSDEWFGlobalModel();
    protected PSDEMainStateGlobalModel psDEMainStateGlobalModel = new PSDEMainStateGlobalModel();
    protected PSDEPrintGlobalModel psDEPrintGlobalModel = new PSDEPrintGlobalModel();
    protected PSDEUtilGlobalModel psDEUtilGlobalModel = new PSDEUtilGlobalModel();
    protected IPSSystemModule iPSSystemModule = null;
    protected String strCodeName = "";
    protected String strIndexDEType = "";
    protected boolean bEnableMultiForm = false;
    protected String strDSLink = "DEFAULT";
    protected String strDBTableSpaceId = "";
    protected boolean bEnableMultiDS = false;
    protected boolean bEnableOrgModel = false;
    protected boolean bExistingModel = false;
    protected String strXmlTagName = null;
    protected String strPSSubSysServiceAPIId = "";
    protected ArrayList<IPSDEField> unionKeyValueFieldList = new ArrayList();
    protected ArrayList<IPSDEField> mainStateFieldList = new ArrayList();
    protected ArrayList<IPSDataEntity> masterPSDataEntityList = new ArrayList();
    protected TreeMap<String, PSDEViewBase> predefineDEViewMap = new TreeMap();
    protected ArrayList<PSDEViewBase> psDEViewBaseList = new ArrayList();
    protected IPSDERNN iPSDERNN = null;
    private boolean bInit = false;
    private Properties classOrPkgNameMap = null;
    private boolean bSubSysDE = false;
    private HashMap<String, IPSDEFValueRule> psDEFValueRuleMap = new HashMap();
    private ArrayList<IPSDEFValueRule> psDEFValueRuleList = new ArrayList();
    private IPSDEWF defaultPSDEWF = null;
    private int nDataAccCtrlMode = 1;
    private int nAuditMode = 0;
    private IPSSysImage iPSSysImage = null;
    private int nDynamicMode = 0;
    private PSDEACMode defaultPSDEACModeData = null;
    private PSDEPrint defaultPSDEPrintData = null;
    private boolean bDefaultDEActionTestUnit = true;
    private int nDataChangeLogMode = 0;
    private boolean bVirtual = false;
    private int nVirtualMode = 0;
    private boolean bNoViewMode = false;
    private int nStorageMode = 1;
    private String strLogicValidValue = "";
    private String strLogicInvalidValue = "";
    private boolean bLogicValid = false;
    private String strLNLanResTag = "";
    private IPSLanguageRes lnPSLanguageRes = null;
    private boolean bSortByName = true;
    private boolean bSortByCreateDate = true;
    private boolean bSortByName_PDT = true;
    private boolean bSortByCreateDate_PDT = true;
    private boolean bSortPDT = false;
    private int nEnableViewLevel = 0;
    private boolean bEnableEntityCache = false;
    private int nEntityCacheTimeout = -1;
    private int nMaxEntityCacheCount = -1;
    private int nDataImpExpMode = 3;
    private int nModelImpExpMode = 3;
    private int nServiceAPIMode = 0;
    private String strServiceCodeName = null;
    private boolean bEnableSADEAction = true;
    private boolean bEnableSASelect = true;
    private boolean bEnableSADEDataSet = true;
    private int nEnableUIActions = 0;
    private int nDataAccCtrlArch = 1;
    public static final String[] SDPDTVIEWS = new String[]{"EDITVIEW", "WFEDITVIEW"};
    private int nModelVersion = 0;
    private String strPSDynaDETemplId = "";

    @Override
    public void setInitParam(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSDataEntity psDataEntity) {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSSystem(iPSSystem);
        this.psDataEntity = psDataEntity;
        this.setId(this.psDataEntity.getPSDATAENTITYID());
        this.setName(this.psDataEntity.getPSDATAENTITYNAME());
        this.setVersion(this.psDataEntity.getMODELVER());
        this.setPSObjectData(this.psDataEntity);
        this.strCodeName = this.psDataEntity.getCODENAME();
        if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.psDataEntity.getPSDATAENTITYNAME().toLowerCase();
        }
        if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
            this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
        }
        this.strXmlTagName = this.strCodeName.toUpperCase();
        this.strIndexDEType = this.psDataEntity.getINDEXDETYPE();
        if (!StringHelper.isNullOrEmpty((String)this.getIndexDEType())) {
            this.bDefaultDEActionTestUnit = false;
        }
        if (!this.psDataEntity.isTESTCASEFLAGNull()) {
            this.bDefaultDEActionTestUnit = this.psDataEntity.getTESTCASEFLAG();
        }
        if (!this.psDataEntity.isENAMULTIFORMNull()) {
            this.bEnableMultiForm = this.psDataEntity.getENAMULTIFORM();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getDSLINK())) {
            this.strDSLink = this.psDataEntity.getDSLINK();
        }
        this.strDBTableSpaceId = this.psDataEntity.getDBTABSPACE();
        if (!this.psDataEntity.isENABLEMULTIDSNull()) {
            this.bEnableMultiDS = this.psDataEntity.getENABLEMULTIDS();
        }
        if (!this.psDataEntity.isEXISTINGMODELNull()) {
            this.bExistingModel = this.psDataEntity.getEXISTINGMODEL();
        }
        if (!this.psDataEntity.isENABLEORGMODELNull()) {
            this.bEnableOrgModel = this.psDataEntity.getENABLEORGMODEL();
        }
        if (!this.psDataEntity.isDATAACCMODENull()) {
            this.nDataAccCtrlMode = this.psDataEntity.getDATAACCMODE();
        }
        if (!this.psDataEntity.isAUDITMODENull()) {
            this.nAuditMode = this.psDataEntity.getAUDITMODE();
        }
        if (!this.psDataEntity.isDYNAMICMODENull()) {
            this.nDynamicMode = this.psDataEntity.getDYNAMICMODE();
        }
        if (!this.psDataEntity.isDATACHGLOGMODENull()) {
            this.nDataChangeLogMode = this.psDataEntity.getDATACHGLOGMODE();
        }
        if (!this.psDataEntity.isVIRTUALFLAGNull()) {
            this.nVirtualMode = this.psDataEntity.getParamIntValue("VIRTUALFLAG", 0);
            if (this.nVirtualMode > 0) {
                this.bVirtual = true;
            }
        }
        this.bNoViewMode = !this.psDataEntity.isNOVIEWMODENull() ? this.psDataEntity.getNOVIEWMODE() : iPSSystem.isNoViewMode();
        if (!this.psDataEntity.isSTORAGEMODENull()) {
            this.nStorageMode = this.psDataEntity.getSTORAGEMODE();
        }
        if (!this.psDataEntity.isVIEWLEVELNull()) {
            this.nEnableViewLevel = this.psDataEntity.getVIEWLEVEL();
        }
        if (!this.psDataEntity.isENABLEENTITYCACHENull()) {
            this.bEnableEntityCache = this.psDataEntity.getENABLEENTITYCACHE();
        }
        if (!this.psDataEntity.isENTITYCACHETIMEOUTNull()) {
            this.nEntityCacheTimeout = this.psDataEntity.getENTITYCACHETIMEOUT();
        }
        if (!this.psDataEntity.isMAXENTITYCACHECNTNull()) {
            this.nMaxEntityCacheCount = this.psDataEntity.getMAXENTITYCACHECNT();
        }
        if (!this.psDataEntity.isDATAIMPEXPFLAGNull()) {
            this.nDataImpExpMode = this.psDataEntity.getDATAIMPEXPFLAG();
        }
        if (!this.psDataEntity.isMODELIMPEXPFLAGNull()) {
            this.nModelImpExpMode = this.psDataEntity.getMODELIMPEXPFLAG();
        }
        this.nServiceAPIMode = !this.psDataEntity.isSERVICEAPIFLAGNull() ? this.psDataEntity.getSERVICEAPIFLAG() : this.getPSSystemSetting().getServiceAPIMode();
        this.strServiceCodeName = StringHelper.isNullOrEmpty((String)this.psDataEntity.getSERVICECODENAME()) ? this.getCodeName() : this.psDataEntity.getSERVICECODENAME();
        if (!this.psDataEntity.isENABLEDEACTIONNull()) {
            this.bEnableSADEAction = this.psDataEntity.getENABLEDEACTION();
        }
        if (!this.psDataEntity.isENABLESELECTNull()) {
            this.bEnableSASelect = this.psDataEntity.getENABLESELECT();
        }
        if (!this.psDataEntity.isENABLEDEDATASETNull()) {
            this.bEnableSADEDataSet = this.psDataEntity.getENABLEDEDATASET();
        }
        if (!this.psDataEntity.isUSERACTIONNull()) {
            int nUIAction = this.psDataEntity.getUSERACTION();
            if ((nUIAction & 1) == 0) {
                this.nEnableUIActions |= 1;
            }
            if ((nUIAction & 2) == 0) {
                this.nEnableUIActions |= 2;
            }
            if ((nUIAction & 4) == 0) {
                this.nEnableUIActions |= 4;
            }
            if ((nUIAction & 8) == 0) {
                this.nEnableUIActions |= 8;
            }
        } else {
            this.nEnableUIActions = 15;
        }
        this.strPSSubSysServiceAPIId = this.psDataEntity.getPSSUBSYSSERVICEAPIID();
        this.bLogicValid = this.psDataEntity.getLOGICVALID();
        if (this.bLogicValid) {
            this.strLogicValidValue = this.psDataEntity.getLOGICVALIDVALUE();
            if (!StringHelper.isNullOrEmpty((String)this.strLogicValidValue)) {
                this.strLogicInvalidValue = this.psDataEntity.getLOGICINVALIDVALUE();
                if (StringHelper.isNullOrEmpty((String)this.strLogicInvalidValue)) {
                    this.strLogicValidValue = "";
                }
            }
        }
        this.bSortByName = StringHelper.compare((String)this.getPSSystemSetting().getDEFieldSortMode(), (String)"NAME", (boolean)false) == 0;
        this.bSortByCreateDate = StringHelper.compare((String)this.getPSSystemSetting().getDEFieldSortMode(), (String)"CREATEDATE", (boolean)false) == 0;
        boolean bl = this.bSortByName_PDT = StringHelper.compare((String)this.getPSSystemSetting().getDEFieldSortMode(), (String)"NAME_PDT", (boolean)false) == 0;
        if (this.bSortByName_PDT) {
            this.bSortByName = true;
            this.bSortPDT = true;
        }
        boolean bl2 = this.bSortByCreateDate_PDT = StringHelper.compare((String)this.getPSSystemSetting().getDEFieldSortMode(), (String)"CREATEDATE_PDT", (boolean)false) == 0;
        if (this.bSortByCreateDate_PDT) {
            this.bSortByCreateDate = true;
            this.bSortPDT = true;
        }
        this.nDataAccCtrlArch = !this.psDataEntity.isACCCTRLARCHNull() ? this.psDataEntity.getACCCTRLARCH() : this.getPSSystemSetting().getDataAccCtrlArch();
        this.strPSDynaDETemplId = this.psDataEntity.getPSDYNADETEMPLID();
        try {
            this.psDEUIActionGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEUIActionGroupGlobalModel.init(this.getPSModelStorageContext(), this);
            this.majorPSDERGlobalModel.init(this.getPSModelStorageContext(), this);
            this.minorPSDERGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEDataQueryGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEDataSetGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psAjaxControlHandlerGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDELogicGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEActionGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEACModeGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEDataRelationGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEDRGroupGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEDRItemGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEWFGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEMainStateGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEPrintGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEUtilGlobalModel.init(this.getPSModelStorageContext(), this);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.bInit = false;
    }

    @Override
    public void init() throws Exception {
        if (this.bInit) {
            return;
        }
        try {
            this.bInit = true;
            this.classOrPkgNameMap = PropertiesHelper.load((String)this.psDataEntity.getBASECLSPARAMS());
            if (!this.psDataEntity.isSUBSYSDENull()) {
                this.bSubSysDE = this.psDataEntity.getSUBSYSDE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psDataEntity.getPSSYSIMAGEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDataEntity.getLNPSLANRESID())) {
                this.lnPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psDataEntity.getLNPSLANRESID());
            }
            Vector<PSDEField> defields = new Vector<PSDEField>();
            CallResult callResult = this.getPSModelQueryHelper().getPSDEFieldsNoSort(this.getId(), defields);
            if (callResult == null || callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\u9519\u8bef");
            }
            PSDEField indexTypePSDEField = null;
            PSDEField formTypePSDEField = null;
            for (PSDEField defield : defields) {
                if (defield.getINDEXTYPE()) {
                    if (indexTypePSDEField == null) {
                        indexTypePSDEField = defield;
                    } else {
                        throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u7ecf\u5b58\u5728\u7d22\u5f15\u7c7b\u578b\u5c5e\u6027[%2$s]\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49[%3$s]", (Object)this.getName(), (Object)indexTypePSDEField.getPSDEFIELDNAME(), (Object)defield.getPSDEFIELDNAME()));
                    }
                }
                if (!defield.getMULTIFORMFIELD()) continue;
                if (formTypePSDEField == null) {
                    formTypePSDEField = defield;
                    continue;
                }
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u7ecf\u5b58\u5728\u8868\u5355\u7c7b\u578b\u5c5e\u6027[%2$s]\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49[%3$s]", (Object)this.getName(), (Object)formTypePSDEField.getPSDEFIELDNAME(), (Object)defield.getPSDEFIELDNAME()));
            }
            Vector<PSDEViewBase> psDEViewBaseList = new Vector<PSDEViewBase>();
            callResult = this.getPSModelQueryHelper().getPSDEViews(this.getId(), psDEViewBaseList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u89c6\u56fe\u96c6\u5408\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
            }
            this.psDEViewBaseList.addAll(psDEViewBaseList);
            psDEViewBaseList = new Vector();
            callResult = this.getPSModelQueryHelper().getPSDEPredefinedViews(this.getId(), psDEViewBaseList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u9884\u7f6e\u89c6\u56fe\u96c6\u5408\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
            }
            for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
                String strPDViewType = psDEViewBase.getPREDEFINEVIEWTYPE();
                if (!StringHelper.isNullOrEmpty((String)psDEViewBase.getPDVTPARAM())) {
                    strPDViewType = String.valueOf(strPDViewType) + StringHelper.format((String)":%1$s", (Object)psDEViewBase.getPDVTPARAM());
                }
                if (this.predefineDEViewMap.containsKey(strPDViewType)) {
                    throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u5b58\u5728\u9884\u7f6e\u89c6\u56fe\u7c7b\u578b[%2$s]\uff0c\u65e0\u6cd5\u91cd\u590d\u6ce8\u518c", (Object)this.getName(), (Object)strPDViewType));
                }
                this.predefineDEViewMap.put(strPDViewType, psDEViewBase);
            }
            Vector<PSDEACMode> psDEACModeList = new Vector<PSDEACMode>();
            callResult = this.getPSModelQueryHelper().getPSDEACModes(this.getId(), psDEACModeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSDEACMode psDEACMode : psDEACModeList) {
                if (psDEACMode.isDEFAULTMODENull() || !psDEACMode.getDEFAULTMODE()) continue;
                this.defaultPSDEACModeData = psDEACMode;
                break;
            }
            Vector<PSDEPrint> psDEPrintList = new Vector<PSDEPrint>();
            callResult = this.getPSModelQueryHelper().getPSDEPrints(this.getId(), psDEPrintList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6253\u5370\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSDEPrint psDEPrint : psDEPrintList) {
                if (this.defaultPSDEPrintData != null && !psDEPrint.getDEFAULTMODE()) continue;
                this.defaultPSDEPrintData = psDEPrint;
                break;
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    public boolean isInit() {
        return this.bInit;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public synchronized boolean preparePSDEFields(boolean bReset) throws Exception {
        if (bReset) {
            this.defHelpers = null;
            this.defHelperMap = null;
            this.defHelperMapByName = null;
            this.preDefineFields = null;
            this.deFieldList = null;
            this.psDEFValueRuleMap.clear();
            this.psDEFValueRuleList.clear();
        }
        return this.preparePSDEFields();
    }

    private final synchronized boolean preparePSDEFields() throws Exception {
        if (this.defHelpers != null && this.defHelperMap != null && this.defHelperMapByName != null && this.preDefineFields != null) {
            return true;
        }
        long nStartTick = new Date().getTime();
        log.debug((Object)StringHelper.format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u5c5e\u6027\u5f00\u59cb", (Object)this.getName()));
        this.onBeforePreparePSDEFields();
        try {
            IPSDEField iPSDEField;
            String strKey;
            this.keyDEField = null;
            this.majorDEField = null;
            this.indexTypeDEField = null;
            this.uniTagDEField = null;
            this.formTypeDEField = null;
            this.psDEFValueRuleMap.clear();
            this.psDEFValueRuleList.clear();
            Vector<PSDEField> defields2 = new Vector<PSDEField>();
            CallResult callResult = this.getPSModelQueryHelper().getPSDEFieldsNoSort(this.getId(), defields2);
            if (callResult == null || callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\u9519\u8bef");
            }
            Vector<PSDEField> defields = new Vector<PSDEField>();
            for (PSDEField psDEField : defields2) {
                if (psDEField.getParamIntValue("VALIDFLAG", 1) != 1) continue;
                defields.add(psDEField);
            }
            HashMap<String, PSDEField> psDEFieldMap = new HashMap<String, PSDEField>();
            for (PSDEField psDEField : defields) {
                psDEFieldMap.put(psDEField.getPSDEFIELDID(), psDEField);
            }
            Vector<PSDEFUIMode> psDEFUIModeList = new Vector<PSDEFUIMode>();
            callResult = this.getPSModelQueryHelper().getPSDEFUIModesByDataEntity(this.getId(), psDEFUIModeList);
            if (callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e\u9519\u8bef");
            }
            for (PSDEFUIMode psDEFUIMode : psDEFUIModeList) {
                Object psDEField = (PSDEField)((Object)psDEFieldMap.get(psDEFUIMode.getPSDEFID()));
                if (psDEField == null) continue;
                psDEField.getPSDEFUIModes(true).add(psDEFUIMode);
            }
            Vector<PSDEFSearchMode> psDEFSearchModeList = new Vector<PSDEFSearchMode>();
            callResult = this.getPSModelQueryHelper().getPSDEFSearchModesByDataEntity(this.getId(), psDEFSearchModeList);
            if (callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u9519\u8bef");
            }
            for (PSDEFSearchMode psDEFSearchMode : psDEFSearchModeList) {
                Object psDEField = (PSDEField)((Object)psDEFieldMap.get(psDEFSearchMode.getPSDEFID()));
                if (psDEField == null) continue;
                psDEField.getPSDEFSearchModes(true).add(psDEFSearchMode);
            }
            Vector<PSDEFValueRule> psDEFValueRuleList = new Vector<PSDEFValueRule>();
            callResult = this.getPSModelQueryHelper().getPSDEFValueRulesByDataEntity(this.getId(), psDEFValueRuleList);
            if (callResult.getRetCode() != 0) {
                throw new Exception("\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u8bef");
            }
            for (Object psDEFValueRule : psDEFValueRuleList) {
                PSDEField psDEField = (PSDEField)((Object)psDEFieldMap.get(psDEFValueRule.getPSDEFID()));
                if (psDEField == null) continue;
                psDEField.getPSDEFValueRules(true).add((PSDEFValueRule)((Object)psDEFValueRule));
            }
            Vector<PSDEField> normaldefields = new Vector<PSDEField>();
            Vector<PSDEField> pickupdefields = new Vector<PSDEField>();
            Vector<PSDEField> pickupdatadefields = new Vector<PSDEField>();
            for (PSDEField deField : defields) {
                int nDEFType = deField.getDEFTYPE();
                if (nDEFType == 2) {
                    normaldefields.add(deField);
                    continue;
                }
                String strDataType = deField.getPSDATATYPEID();
                if (StringHelper.compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
                    pickupdatadefields.add(deField);
                    continue;
                }
                if (StringHelper.compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0) {
                    pickupdefields.add(deField);
                    continue;
                }
                normaldefields.add(deField);
            }
            this.defHelpers = new ArrayList();
            this.deFieldList = new ArrayList();
            this.defHelperMap = new Hashtable();
            this.defHelperMapByName = new Hashtable();
            this.preDefineFields = new Hashtable();
            this.preDefineFields.put("CREATEMAN", "CREATEMAN");
            this.preDefineFields.put("CREATEMANNAME", "CREATEMANNAME");
            this.preDefineFields.put("CREATEDATE", "CREATEDATE");
            this.preDefineFields.put("UPDATEMAN", "UPDATEMAN");
            this.preDefineFields.put("UPDATEMANNAME", "UPDATEMANNAME");
            this.preDefineFields.put("UPDATEDATE", "UPDATEDATE");
            if (this.isLogicValid()) {
                this.preDefineFields.put("LOGICVALID", "ENABLE");
            }
            this.preDefineFields.put("ORGID", "ORGID");
            this.preDefineFields.put("ORGSECTORID", "ORGSECTORID");
            this.preDefineFields.put("ORGNAME", "ORGNAME");
            this.preDefineFields.put("ORGSECTORNAME", "ORGSECTORNAME");
            for (PSDEField deField : normaldefields) {
                IPSDEField iDEField = this.createPSDEField(deField);
                if (iDEField == null) continue;
                this.defHelpers.add(iDEField);
                this.defHelperMap.put(deField.getPSDEFIELDID().toUpperCase(), iDEField);
                this.defHelperMapByName.put(deField.getPSDEFIELDNAME().toUpperCase(), iDEField);
            }
            for (PSDEField deField : pickupdatadefields) {
                IPSDEField iDEField = this.createPSDEField(deField);
                if (iDEField == null) continue;
                this.defHelpers.add(iDEField);
                this.defHelperMap.put(deField.getPSDEFIELDID().toUpperCase(), iDEField);
                this.defHelperMapByName.put(deField.getPSDEFIELDNAME().toUpperCase(), iDEField);
            }
            for (PSDEField deField : pickupdefields) {
                IPSDEField iDEField = this.createPSDEField(deField);
                if (iDEField == null) continue;
                this.defHelpers.add(iDEField);
                this.defHelperMap.put(deField.getPSDEFIELDID().toUpperCase(), iDEField);
                this.defHelperMapByName.put(deField.getPSDEFIELDNAME().toUpperCase(), iDEField);
            }
            HashMap<String, IPSDEField> unionKeyValueMap = new HashMap<String, IPSDEField>();
            HashMap<String, IPSDEField> mainStateFieldMap = new HashMap<String, IPSDEField>();
            for (IPSDEField iDEField : this.defHelpers) {
                if (((IPSDEFieldRuntime)iDEField).isInit()) continue;
                try {
                    ((IPSDEFieldRuntime)iDEField).init();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            for (IPSDEField iDEField : this.defHelpers) {
                if (((IPSDEFieldRuntime)iDEField).isInit()) continue;
                try {
                    ((IPSDEFieldRuntime)iDEField).init();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            for (IPSDEField iDEField : this.defHelpers) {
                this.deFieldList.add((IDEField)iDEField);
                if (!((IPSDEFieldRuntime)iDEField).isInit()) {
                    try {
                        ((IPSDEFieldRuntime)iDEField).init();
                    }
                    catch (Exception ex) {
                        throw new Exception(StringHelper.format((String)"\u521d\u59cb\u5316\u5c5e\u6027[%1$s][%2$s]\u5931\u8d25\uff0c\u539f\u56e0\uff1a%3$s", (Object)this.getName(), (Object)iDEField.getName(), (Object)ex.getMessage()), ex);
                    }
                }
                if (iDEField.isKeyDEField()) {
                    this.keyDEField = iDEField;
                }
                if (iDEField.isUniTagField()) {
                    if (!DataTypeHelper.isStringDataType((int)iDEField.getStdDataType())) {
                        throw new Exception(StringHelper.format((String)"[%1$s]\u552f\u4e00\u4e1a\u52a1\u6807\u8bb0\u5c5e\u6027[%2$s]\u5fc5\u987b\u4e3a[\u5b57\u7b26\u4e32]", (Object)this.getName(), (Object)iDEField.getName()));
                    }
                    this.uniTagDEField = iDEField;
                }
                if (iDEField.isMajorDEField()) {
                    this.majorDEField = iDEField;
                }
                if (!StringHelper.isNullOrEmpty((String)iDEField.getUnionKeyValue()) && !iDEField.isKeyDEField()) {
                    unionKeyValueMap.put(iDEField.getUnionKeyValue(), iDEField);
                }
                if (!StringHelper.isNullOrEmpty((String)iDEField.getDEMSFieldMode())) {
                    mainStateFieldMap.put(iDEField.getDEMSFieldMode(), iDEField);
                }
                if (iDEField.isIndexTypeDEField()) {
                    if (this.indexTypeDEField != null) {
                        throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u7ecf\u5b58\u5728\u7d22\u5f15\u7c7b\u578b\u5c5e\u6027[%2$s]\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49[%3$s]", (Object)this.getName(), (Object)this.indexTypeDEField.getName(), (Object)iDEField.getName()));
                    }
                    this.indexTypeDEField = iDEField;
                }
                if (iDEField.isFormTypeDEField()) {
                    if (this.formTypeDEField != null) {
                        throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5df2\u7ecf\u5b58\u5728\u8868\u5355\u7c7b\u578b\u5c5e\u6027[%2$s]\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49[%3$s]", (Object)this.getName(), (Object)this.formTypeDEField.getName(), (Object)iDEField.getName()));
                    }
                    this.formTypeDEField = iDEField;
                }
                if (this.isExistingModel()) {
                    if (StringHelper.isNullOrEmpty((String)((IPSDEFieldRuntime)iDEField).getPSDEFieldData().getPREDEFINETYPE()) || StringHelper.compare((String)((IPSDEFieldRuntime)iDEField).getPSDEFieldData().getPREDEFINETYPE(), (String)"NONE", (boolean)true) == 0) continue;
                    this.preDefineFields.put(((IPSDEFieldRuntime)iDEField).getPSDEFieldData().getPREDEFINETYPE(), iDEField.getName());
                    if (StringHelper.compare((String)((IPSDEFieldRuntime)iDEField).getPSDEFieldData().getPREDEFINETYPE(), (String)"UPDATEDATE", (boolean)true) != 0) continue;
                    this.updateDateDEField = iDEField;
                    continue;
                }
                if (StringHelper.compare((String)((IPSDEFieldRuntime)iDEField).getPSDEFieldData().getPREDEFINETYPE(), (String)"NONE", (boolean)true) == 0) continue;
                if (!StringHelper.isNullOrEmpty((String)((IPSDEFieldRuntime)iDEField).getPSDEFieldData().getPREDEFINETYPE())) {
                    this.preDefineFields.put(((IPSDEFieldRuntime)iDEField).getPSDEFieldData().getPREDEFINETYPE(), iDEField.getName());
                }
                if (StringHelper.compare((String)"UPDATEDATE", (String)iDEField.getName(), (boolean)true) != 0) continue;
                this.updateDateDEField = iDEField;
            }
            for (String strPreDefineType : this.preDefineFields.keySet()) {
                String strField = this.preDefineFields.get(strPreDefineType);
                IPSDEField iPSDEField2 = this.defHelperMapByName.get(strField.toUpperCase());
                if (iPSDEField2 == null) continue;
                if (StringHelper.compare((String)iPSDEField2.getPreDefinedType(), (String)"NONE", (boolean)true) != 0) {
                    ((IPSDEFieldRuntime)iPSDEField2).setPreDefinedType(strPreDefineType);
                    continue;
                }
                this.preDefineFields.put(strPreDefineType, "");
            }
            this.unionKeyValueFieldList.clear();
            int i = 1;
            while (i < 9) {
                strKey = StringHelper.format((String)"KEY%1$s", (Object)i);
                iPSDEField = (IPSDEField)unionKeyValueMap.get(strKey);
                if (iPSDEField != null) {
                    this.unionKeyValueFieldList.add(iPSDEField);
                }
                ++i;
            }
            this.mainStateFieldList.clear();
            i = 1;
            while (i < 3) {
                strKey = StringHelper.format((String)"STATE%1$s", (Object)i);
                iPSDEField = (IPSDEField)mainStateFieldMap.get(strKey);
                if (iPSDEField != null) {
                    this.mainStateFieldList.add(iPSDEField);
                }
                ++i;
            }
            if (this.keyDEField == null) {
                log.warn((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b58\u5728\u952e\u503c\u5c5e\u6027\uff0c\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef!", (Object)this.getFullName()));
            }
            if (this.majorDEField == null) {
                log.warn((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b58\u5728\u4e3b\u6587\u672c\u5c5e\u6027\uff0c\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef!", (Object)this.getFullName()));
            }
            Collections.sort(this.defHelpers, new Comparator<IPSDEField>(){

                @Override
                public int compare(IPSDEField arg0, IPSDEField arg1) {
                    int nValue = arg0.getOrderValue() - arg1.getOrderValue();
                    if (nValue == 0) {
                        if (PSDataEntityImpl.this.bSortPDT && (nValue = PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg0) - PSDataEntityImpl.this.getPSDEFieldPDTOrder(arg1)) != 0) {
                            return nValue;
                        }
                        if (PSDataEntityImpl.this.bSortByName) {
                            return arg0.getName().compareTo(arg1.getName());
                        }
                        if (PSDataEntityImpl.this.bSortByCreateDate) {
                            return (int)(arg0.getCreateTime() - arg1.getCreateTime());
                        }
                    }
                    return nValue;
                }
            });
            for (IPSDEField iPSDEField3 : this.defHelpers) {
                Iterator psDEFValueRules = iPSDEField3.getAllPSDEFValueRules();
                if (psDEFValueRules == null) continue;
                while (psDEFValueRules.hasNext()) {
                    IPSDEFValueRule iPSDEFValueRule = (IPSDEFValueRule)psDEFValueRules.next();
                    this.psDEFValueRuleMap.put(iPSDEFValueRule.getId(), iPSDEFValueRule);
                    this.psDEFValueRuleList.add(iPSDEFValueRule);
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)"\u51c6\u5907\u5b9e\u4f53\u5c5e\u6027\u5931\u8d25", (Throwable)ex);
            return false;
        }
        log.debug((Object)StringHelper.format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u5c5e\u6027\u7ed3\u675f\uff0c\u8017\u65f6[%2$s]", (Object)this.getName(), (Object)(new Date().getTime() - nStartTick)));
        return this.onAfterPreparePSDEFields();
    }

    protected int getPSDEFieldPDTOrder(IPSDEField iPSDEField) {
        if (iPSDEField.isKeyDEField()) {
            return 10;
        }
        if (iPSDEField.isMajorDEField()) {
            return 20;
        }
        if (iPSDEField.isIndexTypeDEField()) {
            return 30;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"LOGICVALID", (boolean)false) == 0) {
            return 50;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"CREATEMAN", (boolean)false) == 0) {
            return 60;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"CREATEMANNAME", (boolean)false) == 0) {
            return 65;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"CREATEDATE", (boolean)false) == 0) {
            return 70;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"UPDATEMAN", (boolean)false) == 0) {
            return 80;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"UPDATEMANNAME", (boolean)false) == 0) {
            return 85;
        }
        if (StringHelper.compare((String)iPSDEField.getPreDefinedType(), (String)"UPDATEDATE", (boolean)false) == 0) {
            return 90;
        }
        return 1000;
    }

    protected void onBeforePreparePSDEFields() throws Exception {
    }

    protected boolean onAfterPreparePSDEFields() throws Exception {
        return true;
    }

    public synchronized Iterator<IPSDEField> getPSDEFields() throws Exception {
        this.preparePSDEFields();
        return this.defHelpers.iterator();
    }

    public IPSDEField getPSDEField(String strDEFieldName, boolean bTryMode) throws Exception {
        IPSDEField iPSDEField = this.internalGetPSDEField(strDEFieldName, bTryMode);
        if (iPSDEField != null && !((IPSDEFieldRuntime)iPSDEField).isInit()) {
            ((IPSDEFieldRuntime)iPSDEField).init();
        }
        return iPSDEField;
    }

    protected IPSDEField internalGetPSDEField(String strDEFieldName, boolean bTryMode) throws Exception {
        strDEFieldName = strDEFieldName.toUpperCase();
        this.preparePSDEFields();
        IPSDEField iPSDEField = this.defHelperMapByName.get(strDEFieldName);
        if (iPSDEField != null) {
            return iPSDEField;
        }
        iPSDEField = this.defHelperMap.get(strDEFieldName);
        if (iPSDEField != null) {
            return iPSDEField;
        }
        if (bTryMode) {
            return null;
        }
        throw PSDataEntityException.create(this, 20000, strDEFieldName);
    }

    protected IPSDEField createPSDEField(PSDEField psDEField) throws Exception {
        IPSDEFieldType iPSDEFieldType = ((IPSSystemRuntime)this.getPSSystem()).getPSDEFieldTypeByDEField(psDEField);
        if (iPSDEFieldType == null) {
            log.error((Object)StringHelper.format((String)"\u5c5e\u6027[%1$s]\u65e0\u6cd5\u83b7\u53d6\u5bf9\u5e94\u7684\u7c7b\u578b\u5bf9\u8c61", (Object)psDEField.getPSDEFIELDNAME()));
            return null;
        }
        IPSDEField iPSDEField = iPSDEFieldType.createPSDEField(psDEField);
        ((IPSDEFieldRuntime)iPSDEField).setInitParam(this.getPSModelStorageContext(), this, iPSDEFieldType, psDEField);
        return iPSDEField;
    }

    public String getFullName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSystem().getName(), (Object)this.getName());
    }

    public Iterator<IDEField> getDEFields() throws Exception {
        return this.deFieldList.iterator();
    }

    public IDEField getDEField(String strDEFieldName, boolean bTryMode) throws Exception {
        return this.getPSDEField(strDEFieldName, bTryMode);
    }

    @PSModelRTMeta(description="\u8868\u540d\u79f0")
    public String getTableName() {
        return this.psDataEntity.getTABLENAME();
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u540d\u79f0")
    public String getViewName() {
        return this.psDataEntity.getVIEWNAME();
    }

    @PSModelRTMeta(description="\u542f\u7528\u903b\u8f91\u6709\u6548")
    public boolean isLogicValid() {
        return this.bLogicValid;
    }

    public Object getLogicValidValue(boolean bValid) {
        if (StringHelper.isNullOrEmpty((String)this.strLogicValidValue)) {
            return bValid ? 1 : 0;
        }
        try {
            if (this.getLogicValidPSDEField() != null) {
                return ((IPSDEFieldRuntime)this.getLogicValidPSDEField()).getDEFValue(this.getLogicValidStringValue(bValid));
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8ba1\u7b97\u903b\u8f91\u6709\u6548\u6807\u8bc6\u503c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
        }
        return null;
    }

    public String getLogicValidStringValue(boolean bValid) {
        if (StringHelper.isNullOrEmpty((String)this.strLogicValidValue)) {
            return bValid ? "1" : "0";
        }
        return bValid ? this.strLogicValidValue : this.strLogicInvalidValue;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u6709\u6548\u503c", hideempty2=true)
    public String getValidLogicValue() {
        if (!this.isLogicValid()) {
            return null;
        }
        return this.getLogicValidStringValue(true);
    }

    @PSModelRTMeta(description="\u903b\u8f91\u65e0\u6548\u503c", hideempty2=true)
    public String getInvalidLogicValue() {
        if (!this.isLogicValid()) {
            return null;
        }
        return this.getLogicValidStringValue(false);
    }

    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027")
    public IPSDEField getKeyPSDEField() {
        return this.keyDEField;
    }

    @PSModelRTMeta(description="\u4e3b\u4fe1\u606f\u5c5e\u6027")
    public IPSDEField getMajorPSDEField() {
        return this.majorDEField;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u6709\u6548\u5c5e\u6027", hideempty2=true)
    public IPSDEField getLogicValidPSDEField() throws Exception {
        return this.getPSDEFieldByPDT("LOGICVALID", true);
    }

    public IPSPickupDEField getPSPickupDEField(String strPSDERId) throws Exception {
        Iterator<IPSDEField> deFields = this.getPSDEFields();
        while (deFields.hasNext()) {
            IPSPickupDEField iPSPickupDEField;
            IPSDEField iPSDEField = deFields.next();
            if (!iPSDEField.isLinkDEField() || StringHelper.compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0 || StringHelper.compare((String)(iPSPickupDEField = (IPSPickupDEField)iPSDEField).getDERId(), (String)strPSDERId, (boolean)true) != 0) continue;
            return iPSPickupDEField;
        }
        return null;
    }

    @PSModelRTMeta(description="\u7ee7\u627f\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getInheritPSDataEntity() throws Exception {
        if (this.getPSDERInherit() != null) {
            return this.getPSDERInherit().getMajorPSDataEntity();
        }
        return null;
    }

    @PSModelRTMeta(description="\u7ee7\u627f\u5173\u7cfb\u5bf9\u8c61", hideempty=true)
    public IPSDERInherit getPSDERInherit() throws Exception {
        return this.minorPSDERGlobalModel.getPSDERInherit();
    }

    public IPSDEField getPSDEFieldByPDT(String strPreDefineType, boolean bTryMode) throws Exception {
        String strName = this.preDefineFields.get(strPreDefineType);
        if (StringHelper.isNullOrEmpty((String)strName)) {
            if (!bTryMode) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u627e\u5230\u9884\u5b9a\u4e49\u7c7b\u578b[%1$s]", (Object)strPreDefineType));
            }
            return null;
        }
        return this.getPSDEField(strName, bTryMode);
    }

    public IPSDEUIAction getPSDEUIAction(String strDEUIActionId) throws Exception {
        IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)this.psDEUIActionGlobalModel.findModelHelper(strDEUIActionId, true);
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        iPSDEUIAction = this.getPSSystem().getPSDEUIAction(strDEUIActionId, true);
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        return (IPSDEUIAction)this.psDEUIActionGlobalModel.findModelHelper(strDEUIActionId, false);
    }

    public IPSDEUIAction getPSDEUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
        IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)this.psDEUIActionGlobalModel.findModelHelper(strDEUIActionId, true);
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        iPSDEUIAction = this.getPSSystem().getPSDEUIAction(strDEUIActionId, true);
        if (iPSDEUIAction != null) {
            return iPSDEUIAction;
        }
        if (!bTryMode) {
            return (IPSDEUIAction)this.psDEUIActionGlobalModel.findModelHelper(strDEUIActionId, bTryMode);
        }
        return iPSDEUIAction;
    }

    public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId) throws Exception {
        IPSDEUIActionGroup iPSDEUIActionGroup = this.getPSSystem().getPSDEUIActionGroup(strDEUIActionGroupId, true);
        if (iPSDEUIActionGroup != null) {
            return iPSDEUIActionGroup;
        }
        return (IPSDEUIActionGroup)this.psDEUIActionGroupGlobalModel.findModelHelper(strDEUIActionGroupId);
    }

    public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
        IPSDEUIActionGroup iPSDEUIActionGroup = this.getPSSystem().getPSDEUIActionGroup(strDEUIActionGroupId, true);
        if (iPSDEUIActionGroup != null) {
            return iPSDEUIActionGroup;
        }
        return (IPSDEUIActionGroup)this.psDEUIActionGroupGlobalModel.findModelHelper(strDEUIActionGroupId, bTryMode);
    }

    public IPSDERBase getPSDER(boolean bMajor, String strPSDERId) throws Exception {
        if (bMajor) {
            return (IPSDERBase)this.majorPSDERGlobalModel.findModelHelper(strPSDERId);
        }
        return (IPSDERBase)this.minorPSDERGlobalModel.findModelHelper(strPSDERId);
    }

    public Iterator<IPSDERBase> getPSDERs(boolean bMajor) {
        if (bMajor) {
            return this.majorPSDERGlobalModel.getPSDERs();
        }
        return this.minorPSDERGlobalModel.getPSDERs();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u5173\u7cfb\u96c6\u5408")
    public Iterator<IPSDERBase> getMajorPSDERs() {
        return this.getPSDERs(true);
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u4ece\u5173\u7cfb\u96c6\u5408")
    public Iterator<IPSDERBase> getMinorPSDERs() {
        return this.getPSDERs(false);
    }

    /*
     * Unable to fully structure code
     */
    public Iterator<IPSDER1N> getPSDER1Ns(boolean bMajor, boolean bRemoveOrder) {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(bMajor);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N)) continue;
            psDER1NList.add((IPSDER1N)iPSDERBase);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (bRemoveOrder && psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    return o1.getRemoveOrder() - o2.getRemoveOrder();
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    public Iterator<IPSDER1N> getPSDER1Ns(boolean bMajor) {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(bMajor);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N)) continue;
            psDER1NList.add((IPSDER1N)iPSDERBase);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    @PSModelRTMeta(description="\u5173\u8054\u5220\u96641:N\u5173\u7cfb\u96c6\u5408")
    public Iterator<IPSDER1N> getRemovePSDER1Ns() {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(true);
        if (psDERBases != null) ** GOTO lbl10
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N)) continue;
            iPSDER1N = (IPSDER1N)iPSDERBase;
            psDER1NList.add(iPSDER1N);
lbl10:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl11:
        // 1 sources

        if (psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    return o1.getRemoveOrder() - o2.getRemoveOrder();
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    @PSModelRTMeta(description="\u5173\u8054\u514b\u96861:N\u5173\u7cfb\u96c6\u5408")
    public Iterator<IPSDER1N> getClonePSDER1Ns() {
        psDER1NList = new ArrayList<IPSDER1N>();
        psDERBases = this.getPSDERs(true);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDER1N) || (iPSDER1N = (IPSDER1N)iPSDERBase).getCloneOrder() < 0) continue;
            psDER1NList.add(iPSDER1N);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDER1NList.size() > 0) {
            Collections.sort(psDER1NList, new Comparator<IPSDER1N>(){

                @Override
                public int compare(IPSDER1N o1, IPSDER1N o2) {
                    return o1.getCloneOrder() - o2.getCloneOrder();
                }
            });
        }
        if (psDER1NList.size() == 0) {
            return null;
        }
        return psDER1NList.iterator();
    }

    /*
     * Unable to fully structure code
     */
    public Iterator<IPSDERIndex> getPSDERIndexs(boolean bMajor) {
        psDERIndexList = new ArrayList<IPSDERIndex>();
        psDERBases = this.getPSDERs(bMajor);
        if (psDERBases != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDERBase = psDERBases.next();
            if (!(iPSDERBase instanceof IPSDERIndex)) continue;
            psDERIndexList.add((IPSDERIndex)iPSDERBase);
lbl9:
            // 3 sources

            ** while (psDERBases.hasNext())
        }
lbl10:
        // 1 sources

        if (psDERIndexList.size() == 0) {
            return null;
        }
        return psDERIndexList.iterator();
    }

    public IDERBase getDER(boolean bMajor, String strDERId) throws Exception {
        return this.getPSDER(bMajor, strDERId);
    }

    public Iterator<IDERBase> getDERs(boolean bMajor) {
        if (bMajor) {
            return this.majorPSDERGlobalModel.getDERs();
        }
        return this.minorPSDERGlobalModel.getDERs();
    }

    public IPSDERBase getPSDER(boolean bMajor, String strPSDERId, boolean bTryMode) throws Exception {
        if (bMajor) {
            return (IPSDERBase)this.majorPSDERGlobalModel.findModelHelper(strPSDERId, bTryMode);
        }
        return (IPSDERBase)this.minorPSDERGlobalModel.findModelHelper(strPSDERId, bTryMode);
    }

    @PSModelRTMeta(description="1:1\u5173\u7cfb\u96c6\u5408")
    public Iterator<IPSDER11> getPSDER11s() throws Exception {
        return this.majorPSDERGlobalModel.getPSDER11s();
    }

    public String getUserTable() {
        return "";
    }

    public IPSDEField getPSDEField(String strDEFieldName) throws Exception {
        return this.getPSDEField(strDEFieldName, false);
    }

    public IDEDataSet getDEDataSet(String strDEDataSetId) throws Exception {
        return this.getPSDEDataSet(strDEDataSetId);
    }

    public IPSDEDataQuery getPSDEDataQuery(String strDEDataQueryId) throws Exception {
        return (IPSDEDataQuery)this.psDEDataQueryGlobalModel.findModelHelper(strDEDataQueryId);
    }

    public IPSDEDataSet getPSDEDataSet(String strDEDataSetId) throws Exception {
        return (IPSDEDataSet)this.psDEDataSetGlobalModel.findModelHelper(strDEDataSetId);
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u96c6\u5408")
    public Iterator<IPSDEDataSet> getAllPSDEDataSets() throws Exception {
        return this.psDEDataSetGlobalModel.getAllModelHelpers();
    }

    @Override
    public ISystem getSystem() {
        return this.getPSSystem();
    }

    public IDEField getKeyDEField() {
        return this.getKeyPSDEField();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psDataEntity.getLOGICNAME();
    }

    @Override
    public PSACHandler getPSAjaxControlHandlerData(String strAjaxControlHandlerId) throws Exception {
        PSACHandler psACHandler = this.getPSSystemRuntime().getPSAjaxControlHandlerData(strAjaxControlHandlerId, true);
        if (psACHandler != null) {
            return psACHandler;
        }
        psACHandler = (PSACHandler)((Object)this.psAjaxControlHandlerGlobalModel.findModel(strAjaxControlHandlerId));
        if (psACHandler == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strAjaxControlHandlerId));
        }
        return psACHandler;
    }

    public IDEAction getDEAction(String strDEActionId) throws Exception {
        return this.getPSDEAction(strDEActionId);
    }

    public IPSDEAction getPSDEAction(String strDEActionId) throws Exception {
        return (IPSDEAction)this.psDEActionGlobalModel.findModelHelper(strDEActionId);
    }

    public IPSDEAction getPSDEAction(String strDEActionId, boolean bTryMode) throws Exception {
        return (IPSDEAction)this.psDEActionGlobalModel.findModelHelper(strDEActionId, bTryMode);
    }

    public IDataObject createDataObject() throws Exception {
        return new DataObject();
    }

    @PSModelRTMeta(description="\u7d22\u5f15\u7c7b\u578b\u5c5e\u6027", hideempty=true)
    public IPSDEField getIndexTypePSDEField() {
        return this.indexTypeDEField;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u81ea\u52a8\u586b\u5145\u6a21\u5f0f\u96c6\u5408")
    public Iterator<IPSDEACMode> getAllPSDEACModes() throws Exception {
        return this.psDEACModeGlobalModel.getAllModelHelpers();
    }

    public IPSDEACMode getPSDEACMode(String strDEACModeId) throws Exception {
        return (IPSDEACMode)this.psDEACModeGlobalModel.findModelHelper(strDEACModeId);
    }

    public IDEACMode getDEACMode(String strACModeName) throws Exception {
        return this.getPSDEACMode(strACModeName);
    }

    public IDEACMode getDefaultDEACMode() throws Exception {
        if (this.getDefaultPSDEACModeData() != null) {
            return this.getPSDEACMode(this.getDefaultPSDEACModeData().getPSDEACMODEID());
        }
        return this.getPSDEACMode("DEFAULT");
    }

    @Override
    public PSDEACMode getDefaultPSDEACModeData() {
        return this.defaultPSDEACModeData;
    }

    public IPSDEDataRelation getPSDEDataRelation(String strDEDataRelationId) throws Exception {
        return (IPSDEDataRelation)this.psDEDataRelationGlobalModel.findModelHelper(strDEDataRelationId);
    }

    public IPSDEDRGroup getPSDEDRGroup(String strDEDRGroupId) throws Exception {
        return (IPSDEDRGroup)this.psDEDRGroupGlobalModel.findModelHelper(strDEDRGroupId);
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u96c6\u5408")
    public Iterator<IPSDEDataQuery> getAllPSDEDataQueries() throws Exception {
        return this.psDEDataQueryGlobalModel.getAllModelHelpers();
    }

    public IDEDataQuery getDEDataQuery(String strDEDataQueryId) throws Exception {
        return (IDEDataQuery)this.psDEDataQueryGlobalModel.findModelHelper(strDEDataQueryId);
    }

    public IPSDEDRItem getPSDEDRItem(String strDEDRItemId) throws Exception {
        return (IPSDEDRItem)this.psDEDRItemGlobalModel.findModelHelper(strDEDRItemId);
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    public IDEDataSet getDEDataSet(String strName, boolean bTry) throws Exception {
        return (IDEDataSet)this.psDEDataSetGlobalModel.findModelHelper(strName, bTry);
    }

    public IDEField getMajorDEField() {
        return this.getMajorPSDEField();
    }

    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u5bf9\u8c61\u96c6\u5408", hideempty=true)
    public Iterator<IPSDataEntity> getAllMasterPSDataEntities() throws Exception {
        if (this.masterPSDataEntityList == null || this.masterPSDataEntityList.size() == 0) {
            return null;
        }
        return this.masterPSDataEntityList.iterator();
    }

    @PSModelRTMeta(description="\u8054\u5408\u952e\u503c\u5c5e\u6027\u96c6\u5408", hideempty=true)
    public Iterator<IPSDEField> getUnionKeyValuePSDEFields() {
        if (this.unionKeyValueFieldList == null || this.unionKeyValueFieldList.size() == 0) {
            return null;
        }
        return this.unionKeyValueFieldList.iterator();
    }

    public Iterator<IPSDEField> getDEMainStateDEFields() {
        if (this.mainStateFieldList == null || this.mainStateFieldList.size() == 0) {
            return null;
        }
        return this.mainStateFieldList.iterator();
    }

    public Iterator<IPSDEField> getPSDEFieldsByDER(String strDERId) throws Exception {
        ArrayList<IPSLinkDEField> psDEFieldList = new ArrayList<IPSLinkDEField>();
        Iterator<IPSDEField> deFields = this.getPSDEFields();
        while (deFields.hasNext()) {
            IPSLinkDEField iPSLinkDEField;
            IPSDEField iPSDEField = deFields.next();
            if (!iPSDEField.isLinkDEField() || StringHelper.compare((String)(iPSLinkDEField = (IPSLinkDEField)iPSDEField).getDERId(), (String)strDERId, (boolean)true) != 0) continue;
            psDEFieldList.add(iPSLinkDEField);
        }
        if (psDEFieldList == null || psDEFieldList.size() == 0) {
            return null;
        }
        return psDEFieldList.iterator();
    }

    @PSModelRTMeta(description="\u7d22\u5f15\u5b9e\u4f53\u7c7b\u578b", hideempty2=true)
    public String getIndexDEType() {
        return this.strIndexDEType;
    }

    public String getLogicName(String strLanguage) {
        return this.psDataEntity.getLOGICNAME();
    }

    public IPSDELogic getPSDELogic(String strDELogicId) throws Exception {
        return (IPSDELogic)this.psDELogicGlobalModel.findModelHelper(strDELogicId);
    }

    public IDELogic getDELogic(String strDELogicId) throws Exception {
        return this.getPSDELogic(strDELogicId);
    }

    @PSModelRTMeta(description="\u652f\u6301\u4e34\u65f6\u6570\u636e")
    public boolean isEnableTempData() {
        return this.psDataEntity.getENATEMPDATA();
    }

    public IDEUIAction getDEUIAction(String strDEUIActionId) throws Exception {
        return this.getPSDEUIAction(strDEUIActionId);
    }

    @PSModelRTMeta(description="\u652f\u6301\u591a\u8868\u5355")
    public boolean isEnableMultiForm() {
        return this.bEnableMultiForm;
    }

    @PSModelRTMeta(description="\u8868\u5355\u7c7b\u578b\u5c5e\u6027", hideempty=true)
    public IPSDEField getFormTypePSDEField() {
        return this.formTypeDEField;
    }

    @Override
    public PSDEViewBase getPSDEViewDataByPDT(String strPreDefineType, boolean bTryMode) throws Exception {
        PSDEViewBase psDEViewBase = this.predefineDEViewMap.get(strPreDefineType);
        if (psDEViewBase == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u9884\u7f6e\u89c6\u56fe[%1$s]", (Object)strPreDefineType));
        }
        return psDEViewBase;
    }

    @Override
    public PSDEViewBase getPSDEViewDataByPDT(String strPreDefineType, String strPDTParam, boolean bTryMode) throws Exception {
        PSDEViewBase psDEViewBase;
        String strPDViewType = strPreDefineType;
        if (!StringHelper.isNullOrEmpty((String)strPDTParam)) {
            strPDViewType = String.valueOf(strPDViewType) + StringHelper.format((String)":%1$s", (Object)strPDTParam.toUpperCase());
        }
        if ((psDEViewBase = this.predefineDEViewMap.get(strPDViewType)) == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u9884\u7f6e\u89c6\u56fe[%1$s]", (Object)strPDViewType));
        }
        return psDEViewBase;
    }

    @Override
    public PSDEViewBase getPSDEViewDataByPDT(String strPreDefineType, String strPDTParamPre, String strPDTParam, boolean bTryMode) throws Exception {
        PSDEViewBase psDEViewBase;
        if (!StringHelper.isNullOrEmpty((String)strPDTParamPre) && !StringHelper.isNullOrEmpty((String)strPDTParam) && (psDEViewBase = this.getPSDEViewDataByPDT(strPreDefineType, String.valueOf(strPDTParamPre) + strPDTParam, true)) != null) {
            return psDEViewBase;
        }
        return this.getPSDEViewDataByPDT(strPreDefineType, strPDTParam, bTryMode);
    }

    @Override
    public Iterator<PSDEViewBase> getPSDEViewDatasByPDT(String strPreDefineType) throws Exception {
        strPreDefineType = strPreDefineType.toUpperCase();
        String strPreDefineType2 = String.valueOf(strPreDefineType) + ":";
        ArrayList<PSDEViewBase> psDEViewBaseList = new ArrayList<PSDEViewBase>();
        for (String strKey : this.predefineDEViewMap.keySet()) {
            if (StringHelper.compare((String)strKey, (String)strPreDefineType, (boolean)true) == 0) {
                psDEViewBaseList.add(this.predefineDEViewMap.get(strKey));
                continue;
            }
            if (strKey.indexOf(strPreDefineType2) != 0) continue;
            psDEViewBaseList.add(this.predefineDEViewMap.get(strKey));
        }
        return psDEViewBaseList.iterator();
    }

    @Override
    public Iterator<PSDEViewBase> getAllPSDEViewDatas() {
        return this.psDEViewBaseList.iterator();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u7c7b\u578b", codelist="DEType")
    public int getDEType() {
        return this.psDataEntity.getDETYPE();
    }

    @PSModelRTMeta(description="\u5173\u7cfb\u5b9e\u4f53N:N\u5173\u7cfb", hideempty=true, name="getPSDERNN")
    public IPSDERNN getPSDERNN2() throws Exception {
        if (this.iPSDERNN != null) {
            return this.iPSDERNN;
        }
        if (this.getDEType() != 3) {
            return null;
        }
        IPSDER1N[] list = new IPSDER1N[2];
        int nIndex = 0;
        Iterator<IPSDER1N> psDER1Ns = this.getPSDER1Ns(false);
        if (psDER1Ns != null) {
            while (psDER1Ns.hasNext()) {
                IPSDER1N iPSDER1N = psDER1Ns.next();
                if ((iPSDER1N.getMasterRS() & 2) <= 0) continue;
                list[nIndex] = iPSDER1N;
                if (++nIndex == 2) break;
            }
        }
        if (nIndex != 2) {
            throw new Exception(StringHelper.format((String)"\u5173\u7cfb\u5b9e\u4f53[%1$s]\u5fc5\u987b\u5b9a\u4e492\u4e2aN:N\u5173\u7cfb", (Object)this.getName()));
        }
        this.iPSDERNN = new PSDERNNImpl(list);
        return this.iPSDERNN;
    }

    public IPSDERNN getPSDERNN() throws Exception {
        if (this.iPSDERNN != null) {
            return this.iPSDERNN;
        }
        if (this.getDEType() != 3) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u7c7b\u578b\u4e0d\u662f\u5173\u7cfb\u5b9e\u4f53", (Object)this.getName()));
        }
        IPSDER1N[] list = new IPSDER1N[2];
        int nIndex = 0;
        Iterator<IPSDER1N> psDER1Ns = this.getPSDER1Ns(false);
        if (psDER1Ns != null) {
            while (psDER1Ns.hasNext()) {
                IPSDER1N iPSDER1N = psDER1Ns.next();
                if ((iPSDER1N.getMasterRS() & 2) <= 0) continue;
                list[nIndex] = iPSDER1N;
                if (++nIndex == 2) break;
            }
        }
        if (nIndex != 2) {
            throw new Exception(StringHelper.format((String)"\u5173\u7cfb\u5b9e\u4f53[%1$s]\u5fc5\u987b\u5b9a\u4e492\u4e2aN:N\u5173\u7cfb", (Object)this.getName()));
        }
        this.iPSDERNN = new PSDERNNImpl(list);
        return this.iPSDERNN;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u96c6\u5408")
    public Iterator<IPSDEWF> getAllPSDEWFs() throws Exception {
        return this.psDEWFGlobalModel.getAllModelHelpers();
    }

    public IPSDEWF getPSDEWF(String strWFDEId) throws Exception {
        return (IPSDEWF)this.psDEWFGlobalModel.findModelHelper(strWFDEId);
    }

    public IDEWF getDEWF(String strDEWFId) throws Exception {
        return this.getPSDEWF(strDEWFId);
    }

    @PSModelRTMeta(description="\u6709\u5b9e\u4f53\u5de5\u4f5c\u6d41")
    public boolean hasPSDEWF() throws Exception {
        Iterator<IPSDEWF> psWFDEs = this.getAllPSDEWFs();
        return psWFDEs != null && psWFDEs.hasNext();
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u5de5\u4f5c\u6d41")
    public IPSDEWF getDefaultPSDEWF() throws Exception {
        if (this.defaultPSDEWF != null) {
            return this.defaultPSDEWF;
        }
        Iterator<IPSDEWF> psWFDEs = this.getAllPSDEWFs();
        if (psWFDEs != null) {
            while (psWFDEs.hasNext()) {
                IPSDEWF iPSDEWF = psWFDEs.next();
                if (!iPSDEWF.isDefaultMode()) continue;
                this.defaultPSDEWF = iPSDEWF;
                return this.defaultPSDEWF;
            }
        }
        return null;
    }

    public IDEField getLogicValidDEField() {
        try {
            return this.getLogicValidPSDEField();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u6570\u636e\u6e90", codelist="SysDeployDBMode")
    public String getDSLink() {
        return this.strDSLink;
    }

    @PSModelRTMeta(description="\u540c\u65f6\u652f\u6301\u591a\u6570\u636e\u6e90")
    public boolean isEnableMultiDS() {
        return this.bEnableMultiDS;
    }

    public IPSDEOPPriv getPSDEOPPriv(String strDEOPPrivId) throws Exception {
        return this.getPSSystem().getPSDEOPPriv(strDEOPPrivId);
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u96c6\u5408")
    public Iterator<IPSDEMainState> getAllPSDEMainStates() throws Exception {
        return this.psDEMainStateGlobalModel.getAllModelHelpers();
    }

    public IPSDEMainState getPSDEMainState(String strDEMainStateId) throws Exception {
        return (IPSDEMainState)this.psDEMainStateGlobalModel.findModelHelper(strDEMainStateId);
    }

    public IPSDEMainState getPSDEMainState(String strDEMainStateId, boolean bTryMode) throws Exception {
        return (IPSDEMainState)this.psDEMainStateGlobalModel.findModelHelper(strDEMainStateId, bTryMode);
    }

    public boolean isExistingModel() {
        return this.bExistingModel;
    }

    @PSModelRTMeta(description="\u9644\u52a0\u7ec4\u7ec7\u6a21\u578b")
    public boolean isEnableOrgModel() {
        return this.bEnableOrgModel;
    }

    public IDEMainState getDEMainState(ISimpleDataObject iSimpleDataObject) throws Exception {
        return null;
    }

    public IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId) throws Exception {
        IPSDEFValueRule iPSDEFValueRule = this.psDEFValueRuleMap.get(strPSDEFValueRuleId);
        if (iPSDEFValueRule == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u503c\u89c4\u5219[%2$s]", (Object)this.getName(), (Object)strPSDEFValueRuleId));
        }
        return iPSDEFValueRule;
    }

    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219\u96c6\u5408")
    public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception {
        return this.psDEFValueRuleList.iterator();
    }

    public boolean isEnableDEMainState() {
        return this.mainStateFieldList != null && this.mainStateFieldList.size() != 0;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u65b9\u5f0f", codelist="DEDataAccCtrlMode")
    public int getDataAccCtrlMode() {
        return this.nDataAccCtrlMode;
    }

    @PSModelRTMeta(description="\u5ba1\u8ba1\u6a21\u5f0f", codelist="DEDataAuditMode")
    public int getAuditMode() {
        return this.nAuditMode;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u6807\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public void checkDataEntity() throws Exception {
        this.onCheckDataEntity();
    }

    protected void onCheckDataEntity() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getIndexDEType()) && this.getIndexTypePSDEField() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u7d22\u5f15/\u7ee7\u627f\u6a21\u5f0f\uff0c\u4f46\u672a\u5b9a\u4e49\u7d22\u5f15\u5c5e\u6027", (Object)this.getName()));
        }
        if (!StringHelper.isNullOrEmpty((String)this.getIndexDEType()) && this.getIndexTypePSDEField().getPSCodeList() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u7d22\u5f15/\u7ee7\u627f\u6a21\u5f0f\uff0c\u4f46\u672a\u5b9a\u4e49\u7d22\u5f15\u5c5e\u6027\u7684\u4ee3\u7801\u8868", (Object)this.getName()));
        }
        if (this.isEnableMultiForm() && this.getFormTypePSDEField() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u591a\u8868\u5355\u6a21\u5f0f\uff0c\u4f46\u672a\u5b9a\u4e49\u8868\u5355\u8bc6\u522b\u5c5e\u6027", (Object)this.getName()));
        }
        if (this.isEnableMultiForm() && this.getFormTypePSDEField().getPSCodeList() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u591a\u8868\u5355\u6a21\u5f0f\uff0c\u4f46\u672a\u5b9a\u4e49\u8868\u5355\u8bc6\u522b\u5c5e\u6027\u7684\u4ee3\u7801\u8868", (Object)this.getName()));
        }
        if (this.getVirtualMode() == 2 && this.getInheritPSDataEntity() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5b9a\u4e49\u4e86\u7ee7\u627f\u865a\u62df\u6a21\u5f0f\uff0c\u4f46\u672a\u6307\u5b9a\u7ee7\u627f\u5b9e\u4f53", (Object)this.getName()));
        }
        if (this.getInheritPSDataEntity() != null && this.getInheritPSDataEntity().getIndexTypePSDEField() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u7ee7\u627f\u5b9e\u4f53\u672a\u5b9a\u4e49\u7d22\u5f15\u5c5e\u6027", (Object)this.getName()));
        }
        if (this.getDEType() == 3) {
            this.getPSDERNN();
        }
    }

    @Override
    public Iterator<String> getPDTViewNames() {
        if (this.predefineDEViewMap.size() == 0) {
            return null;
        }
        return this.predefineDEViewMap.keySet().iterator();
    }

    public String getPSDEViewIdByPDT(String strPDTName) throws Exception {
        return this.getPSDEViewDataByPDT(strPDTName, false).getPSDEVIEWBASEID();
    }

    @Override
    public ArrayList<PSDEViewBase> getSDPSDEViewDataList(boolean bIncWFView) throws Exception {
        ArrayList<PSDEViewBase> list = new ArrayList<PSDEViewBase>();
        Iterator<IPSDERIndex> psDERIndexs = this.getPSDERIndexs(true);
        if (psDERIndexs != null) {
            while (psDERIndexs.hasNext()) {
                IPSDERIndex iPSDERIndex = psDERIndexs.next();
                IPSDataEntity minorPSDataEntity = this.getPSSystem().getPSDataEntity(iPSDERIndex.getMinorPSDEId());
                list.addAll(((IPSDataEntityRuntime)minorPSDataEntity).getSDPSDEViewDataList(bIncWFView));
            }
        } else {
            String[] stringArray = SDPDTVIEWS;
            int n = SDPDTVIEWS.length;
            int n2 = 0;
            while (n2 < n) {
                Iterator<PSDEViewBase> psDEViewBases;
                String strPDTType = stringArray[n2];
                if ((bIncWFView || StringHelper.compare((String)strPDTType, (String)"WFEDITVIEW", (boolean)false) != 0) && (psDEViewBases = this.getPSDEViewDatasByPDT(strPDTType)) != null) {
                    while (psDEViewBases.hasNext()) {
                        list.add(psDEViewBases.next());
                    }
                }
                ++n2;
            }
        }
        return list;
    }

    public IDERIndex getDERIndex(boolean bMajor, String strIndexValue) throws Exception {
        Iterator<IDERBase> derBases = this.getDERs(bMajor);
        if (derBases != null) {
            while (derBases.hasNext()) {
                IDERIndex iDERIndex;
                IDERBase iDERBase = derBases.next();
                if (!(iDERBase instanceof IDERIndex) || StringHelper.compare((String)(iDERIndex = (IDERIndex)iDERBase).getTypeValue(), (String)strIndexValue, (boolean)true) != 0) continue;
                return iDERIndex;
            }
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7c7b\u578b\u503c[%2$s]\u7d22\u5f15\u5173\u7cfb[%3$s]", (Object)this.getName(), (Object)strIndexValue, (Object)bMajor));
    }

    public IDataEntity getInheritDataEntity() throws Exception {
        return this.getInheritPSDataEntity();
    }

    public int getDynamicMode() {
        return this.nDynamicMode;
    }

    protected void setDynamicMode(int nDynamicMode) {
        this.nDynamicMode = nDynamicMode;
    }

    public String getMapDEOPPrivTag(String strDEOPPrivTag, String strDERName) {
        return null;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6253\u5370\u96c6\u5408")
    public Iterator<IPSDEPrint> getAllPSDEPrints() throws Exception {
        return this.psDEPrintGlobalModel.getAllModelHelpers();
    }

    public IPSDEPrint getPSDEPrint(String strDEPrintId) throws Exception {
        return (IPSDEPrint)this.psDEPrintGlobalModel.findModelHelper(strDEPrintId);
    }

    public IPSDEPrint getPSDEPrint(String strDEPrintId, boolean bTryMode) throws Exception {
        return (IPSDEPrint)this.psDEPrintGlobalModel.findModelHelper(strDEPrintId, bTryMode);
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6253\u5370")
    public IPSDEPrint getDefaultPSDEPrint() throws Exception {
        if (this.getDefaultPSDEPrintData() != null) {
            return this.getPSDEPrint(this.getDefaultPSDEPrintData().getPSDEPRINTID());
        }
        return this.getPSDEPrint("DEFAULT");
    }

    public PSDEPrint getDefaultPSDEPrintData() {
        return this.defaultPSDEPrintData;
    }

    @PSModelRTMeta(description="\u662f\u5426\u6709\u5b9e\u4f53\u6253\u5370")
    public boolean hasPSDEPrint() throws Exception {
        return this.defaultPSDEPrintData != null;
    }

    protected int calcDynamicMode() throws Exception {
        return 0;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u53d8\u5316\u65e5\u5fd7\u6a21\u5f0f", codelist="DEDataChgLogMode")
    public int getDataChangeLogMode() {
        return this.nDataChangeLogMode;
    }

    public Iterator<IDEDataSync> getDEDataSyncs(boolean bIn) {
        return null;
    }

    @PSModelRTMeta(description="\u5b9e\u4f531:1\u5173\u7cfb", hideempty=true)
    public IPSDER11 getPSDER11() throws Exception {
        return this.minorPSDERGlobalModel.getPSDER11();
    }

    @PSModelRTMeta(description="\u865a\u62df\u5b9e\u4f53")
    public boolean isVirtual() {
        return this.bVirtual;
    }

    public Iterator<IPSDERMultiInherit> getPSDERMultiInherits(boolean bMajor) throws Exception {
        if (bMajor) {
            return this.majorPSDERGlobalModel.getPSDERMultiInherits();
        }
        return this.minorPSDERGlobalModel.getPSDERMultiInherits();
    }

    @PSModelRTMeta(description="\u65e0\u89c6\u56fe\u6a21\u5f0f")
    public boolean isNoViewMode() {
        return this.bNoViewMode;
    }

    public IDEDataQuery getDefaultDEDataQuery() {
        return this.psDEDataQueryGlobalModel.getDefaultPSDEDataQuery();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5b58\u50a8\u6a21\u5f0f", codelist="DEStorageType")
    public int getStorageMode() {
        return this.nStorageMode;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u96c6\u5408")
    public Iterator<IPSDEDataExport> getAllPSDEDataExports() throws Exception {
        return null;
    }

    public IPSDEDataExport getPSDEDataExport(String strDEDataExportId) throws Exception {
        return null;
    }

    public IPSDEDataExport getPSDEDataExport(String strDEDataExportId, boolean bTryMode) throws Exception {
        return null;
    }

    public String getLNLanResTag() {
        if (this.getLNPSLanguageRes() == null) {
            return this.strLNLanResTag;
        }
        return this.getLNPSLanguageRes().getLanResTag();
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        return this.lnPSLanguageRes;
    }

    public IDEBATable getDEBATable(String strDEBATableId) throws Exception {
        return null;
    }

    public Iterator<IDEBATable> getDEBATables() {
        return null;
    }

    @Override
    public int check() throws Exception {
        this.psDEACModeGlobalModel.checkAll();
        this.psDEDataSetGlobalModel.checkAll();
        this.psDELogicGlobalModel.checkAll();
        this.psDEActionGlobalModel.checkAll();
        this.psDEDRGroupGlobalModel.checkAll();
        this.psDEDRItemGlobalModel.checkAll();
        this.psDEWFGlobalModel.checkAll();
        this.psDEUIActionGlobalModel.checkAll();
        this.psDEMainStateGlobalModel.checkAll();
        this.psDEPrintGlobalModel.checkAll();
        this.psDEDataRelationGlobalModel.checkAll();
        Iterator<IPSDEField> psDEFields = this.getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            ((IPSDEFieldRuntime)iPSDEField).check();
        }
        return super.check();
    }

    @PSModelRTMeta(description="\u89c6\u56fe2\u540d\u79f0", hideempty2=true)
    public String getView2Name() {
        return this.psDataEntity.getVIEWNAME2();
    }

    @PSModelRTMeta(description="\u89c6\u56fe3\u540d\u79f0", hideempty2=true)
    public String getView3Name() {
        return this.psDataEntity.getVIEWNAME3();
    }

    @PSModelRTMeta(description="\u89c6\u56fe4\u540d\u79f0", hideempty2=true)
    public String getView4Name() {
        return this.psDataEntity.getVIEWNAME4();
    }

    public IDEDataQuery getViewDEDataQuery(int nViewLevel) {
        return this.psDEDataQueryGlobalModel.getDefaultPSDEDataQuery();
    }

    public IDEUniState getDEUniState(String strDEUniStateId) throws Exception {
        return null;
    }

    public Iterator<IDEUniState> getDEUniStates() {
        return null;
    }

    public IDEUniState getDefaultDEUniState() {
        return null;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u5bfc\u51fa\u6a21\u5f0f", codelist="DEDataImpExpMode")
    public int getDataImpExpMode() {
        return this.nDataImpExpMode;
    }

    public IDEField getUniTagDEField() {
        if (this.uniTagDEField != null) {
            return this.uniTagDEField;
        }
        if (DataTypeHelper.isStringDataType((int)this.getKeyDEField().getStdDataType())) {
            return this.getKeyDEField();
        }
        return null;
    }

    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u5ba2\u6237\u7aef\u6807\u8bc6")
    public String getServiceAPIClientId() {
        return this.strPSSubSysServiceAPIId;
    }

    @PSModelRTMeta(description="\u670d\u52a1\u4ee3\u7801\u540d\u79f0")
    public String getServiceCodeName() {
        return this.strServiceCodeName;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u652f\u6301\u754c\u9762\u884c\u4e3a", codelist="DEUserUIAbility2")
    public int getEnableUIActions() {
        return this.nEnableUIActions;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb", codelist="AccCtrlArch")
    public int getDataAccCtrlArch() {
        return this.nDataAccCtrlArch;
    }

    public IDEUserRole getDEUserRole(String strDEUserRoleId) throws Exception {
        return null;
    }

    public Iterator<IDEUserRole> getDEUserRoles() {
        return null;
    }

    public Iterator<IDEOPPrivRole> getDEOPPrivRoles(String strDEOPrivTag) {
        return null;
    }

    public IPSDEUtil getPSDEUtil(String strDEUtilId, boolean bTryMode) throws Exception {
        IPSDEUtil iPSDEUtil = (IPSDEUtil)this.psDEUtilGlobalModel.findModelHelper(strDEUtilId, true);
        if (iPSDEUtil != null) {
            return iPSDEUtil;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u529f\u80fd\u914d\u7f6e[%1$s]", (Object)strDEUtilId));
    }

    public boolean hasDEWF() {
        try {
            return this.hasPSDEWF();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    @PSModelRTMeta(description="\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<IPSDEField> getAllPSDEFields() throws Exception {
        return this.getPSDEFields();
    }

    public boolean isEnableDynaStorage() {
        try {
            return this.getPSDEUtil("DYNASTORAGE", true) != null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    public int getVirtualMode() {
        return this.nVirtualMode;
    }

    public int getVersion() {
        return this.nModelVersion;
    }

    protected void setVersion(int nModelVersion) {
        this.nModelVersion = nModelVersion;
    }

    public IDEDataImport getDEDataImport(String strDEDataImportId) throws Exception {
        return null;
    }

    public IDEDataExport getDEDataExport(String strDEDataExportId) throws Exception {
        return null;
    }

    public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception {
        return null;
    }

    public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId, boolean bTryMode) throws Exception {
        return null;
    }

    public IDEActionWizard getDEActionWizard(String strDEActionWizardId) throws Exception {
        return null;
    }

    public String getDefaultDEDTSQueueId() {
        return null;
    }

    public IDEDBConfig getDEDBConfig(String strDBType) throws Exception {
        return null;
    }

    public IDEDataImport getDefaultDEDataImport() {
        return null;
    }

    public String getPSDynaDETemplId() {
        return this.strPSDynaDETemplId;
    }
}

