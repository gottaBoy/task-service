/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2ManyDataDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDataDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupObjectDEField;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDER1NDEFieldMapImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERBaseImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.PS.Data.PSDERDEFMap;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDER1NImpl
extends PSDERBaseImpl
implements IPSDER1N {
    private static final Log log = LogFactory.getLog(PSDER1NImpl.class);
    private boolean bCloneRS = false;
    private int nMasterRS = 0;
    private boolean bExtRestrict = false;
    private boolean bExtRestrictDefined = false;
    private int nRemoveOrder = 0;
    private int nRemoveActionType = -1;
    private int nCloneOrder = -1;
    private int nTempDataOrder = -1;
    private int nMasterOrder = -1;
    private String strRefPickupPSDEViewId = "";
    private String strRefPickupPSDEViewName = "";
    private String strRefMPickupPSDEViewId = "";
    private String strRefMPickupPSDEViewName = "";
    private String strRefLinkPSDEViewId = "";
    private String strRefLinkPSDEViewName = "";
    private String strMobRefPickupPSDEViewId = "";
    private String strMobRefPickupPSDEViewName = "";
    private String strMobRefMPickupPSDEViewId = "";
    private String strMobRefMPickupPSDEViewName = "";
    private String strMobRefLinkPSDEViewId = "";
    private String strMobRefLinkPSDEViewName = "";
    private String strRefDEACModeId = "";
    private boolean bEnablePDEREQ = false;
    private IPSPickupDEField iPSPickupDEField = null;
    private int nExportModelOrder = -1;
    private int nSyncExportModelMode = 0;
    private boolean bEnableFKey = true;
    private String strFKeyName = "";
    private String strMinorXmlTagName = null;
    private ArrayList<IPSDER1NDEFieldMap> psDER1NDEFieldMapList = null;
    private Map<String, String> psDER1NDEFieldMapQueryMap = null;
    private IPSDER1NDEFieldMap countPSDER1NDEFieldMap = null;
    private String strPickupDEFName = null;
    private IPSDEDataSet refPSDEDataSet = null;
    private IPSDEFGroup refPSDEFGroup = null;
    private IPSDEACMode refPSDEACMode = null;
    private IPSDEField erMinorPSDEF = null;
    private IPSDEField erMajorPSDEF = null;
    private String strERMajorPSDEFId = null;
    private String strERMinorPSDEFId = null;
    private int nExportMajorModel = -1;
    private int nCustomExportOrder = -1;
    private int nCustomExportOrder2 = -1;
    private IPSOne2ManyDataDEField iPSOne2ManyDataDEField = null;
    private boolean bCalcPSOne2ManyDataDEField = false;
    private boolean bRecursiveRS = false;
    private IPSPickupObjectDEField iPSPickupObjectDEField = null;
    private boolean bCalcPSPickupObjectDEField = false;
    private boolean bEnableDEFieldWriteBackDefault = false;
    private boolean bIgnoreDEFieldRefreshDefault = false;
    private Boolean bEnableWriteBack = null;
    private IPSLanguageRes removeRejectMsgPSLanguageRes = null;
    private IPSDEDataSet nestedPSDEDataSet = null;

    @Override
    protected void onInit() throws Exception {
        PSDEACMode psDEACMode;
        PSDEViewBase linkPSDEViewBase;
        PSDEViewBase pickupPSDEViewBase;
        if (!this.psDER.isENADEFIELDWRITEBACKNull()) {
            this.bEnableDEFieldWriteBackDefault = this.psDER.getENADEFIELDWRITEBACK() == 1;
            this.bIgnoreDEFieldRefreshDefault = this.psDER.getENADEFIELDWRITEBACK() == 2;
        }
        this.strPickupDEFName = this.psDER.getDERFIELDNAME().toUpperCase();
        this.strCodeName = this.psDER.getCODENAME();
        if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.getPickupDEFName().toLowerCase();
            this.strCodeName = this.strCodeName.substring(0, this.strCodeName.length() - 2);
        }
        if (!(StringHelper.isNullOrEmpty((String)this.strCodeName) || this.getMajorPSDataEntity() != null && this.getMajorPSDataEntity().getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
            String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
            this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
        }
        if (!this.psDER.isMASTERRSNull()) {
            this.nMasterRS = this.psDER.getMASTERRS();
            if ((this.nMasterRS & 2) > 0) {
                this.nMasterRS |= 1;
            }
        }
        if ((this.getMasterRS() & 0x10) == 16) {
            if (StringHelper.compare((String)this.psDER.getMAJORPSDEID(), (String)this.psDER.getMINORPSDEID(), (boolean)false) == 0) {
                this.bRecursiveRS = true;
            } else {
                this.nMasterRS ^= 0x10;
                this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), StringHelper.format((String)"\u9012\u5f52\u5173\u7cfb\u4e3b\u4ece\u5b9e\u4f53\u5fc5\u987b\u4e00\u81f4\uff0c\u5ffd\u7565\u6b64\u914d\u7f6e"));
            }
        }
        if (!this.psDER.isENAEXTRANGENull()) {
            this.bExtRestrict = this.psDER.getENAEXTRANGE();
            this.bExtRestrictDefined = true;
        }
        if (!this.psDER.isREMOVEORDERNull()) {
            this.nRemoveOrder = this.psDER.getREMOVEORDER();
        }
        if (!this.psDER.isREMOVEACTIONTYPENull()) {
            this.nRemoveActionType = this.psDER.getREMOVEACTIONTYPE();
        }
        if (!this.psDER.isCLONEORDERVALUENull()) {
            this.nCloneOrder = this.psDER.getCLONEORDERVALUE();
        }
        if (!this.psDER.isENABLECLONENull()) {
            this.bCloneRS = this.psDER.getENABLECLONE();
        } else {
            boolean bl = this.bCloneRS = this.getCloneOrder() >= 0;
        }
        if (!this.psDER.isTEMPORDERVALUENull()) {
            this.nTempDataOrder = this.psDER.getTEMPORDERVALUE();
        }
        if (!this.psDER.isMASTERORDERVALUENull()) {
            this.nMasterOrder = this.psDER.getMASTERORDERVALUE();
            if (this.nMasterOrder >= 10) {
                this.nMasterRS |= 1;
            }
        } else if ((this.getMasterRS() & 1) == 1) {
            this.nMasterOrder = 100;
        }
        if (!this.psDER.isEXPORTMAJORMODELNull()) {
            this.nExportMajorModel = this.psDER.getEXPORTMAJORMODEL();
        }
        if (!this.psDER.isEXPORTMODELNull()) {
            this.nExportModelOrder = this.psDER.getEXPORTMODEL();
        }
        if (!this.psDER.isEXPORTSCOPENull()) {
            this.nCustomExportOrder = this.psDER.getEXPORTSCOPE();
        }
        if (!this.psDER.isEXPORTSCOPE2Null()) {
            this.nCustomExportOrder2 = this.psDER.getEXPORTSCOPE2();
        }
        if (!this.psDER.isSYNCEXPORTMODELNull()) {
            this.nSyncExportModelMode = this.psDER.getSYNCEXPORTMODEL();
        }
        this.bEnableFKey = this.getPSSystemSetting().isEnableDERFKey();
        if (this.getMajorPSDataEntity().getSaaSMode() != IPSDataEntity.SAASMODE_NOTSUPPORTED.intValue()) {
            this.bEnableFKey = false;
        } else if (!this.psDER.isFOREIGNKEYNull()) {
            this.bEnableFKey = this.psDER.getFOREIGNKEY();
        } else if ((this.getMajorPSDataEntity().getStorageMode() & 1) != 1 || (this.getMinorPSDataEntity().getStorageMode() & 1) != 1) {
            this.bEnableFKey = false;
        }
        this.strRefPickupPSDEViewId = this.psDER.getSDPSDEVIEWID();
        this.strRefPickupPSDEViewName = this.psDER.getSDPSDEVIEWNAME();
        if (StringHelper.isNullOrEmpty((String)this.strRefPickupPSDEViewId) && (pickupPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("PICKUPVIEW", true)) != null) {
            this.strRefPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
            this.strRefPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
        }
        this.strRefMPickupPSDEViewId = this.psDER.getMDPSDEVIEWID();
        this.strRefMPickupPSDEViewName = this.psDER.getMDPSDEVIEWNAME();
        if (StringHelper.isNullOrEmpty((String)this.strRefMPickupPSDEViewId) && (pickupPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MPICKUPVIEW", true)) != null) {
            this.strRefMPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
            this.strRefMPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
        }
        this.strRefLinkPSDEViewId = this.psDER.getLINKPSDEVIEWID();
        this.strRefLinkPSDEViewName = this.psDER.getLINKPSDEVIEWNAME();
        if (StringHelper.isNullOrEmpty((String)this.strRefLinkPSDEViewId)) {
            linkPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("REDIRECTVIEW", true);
            if (linkPSDEViewBase == null) {
                linkPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("EDITVIEW", true);
            }
            if (linkPSDEViewBase != null) {
                this.strRefLinkPSDEViewId = linkPSDEViewBase.getPSDEVIEWBASEID();
                this.strRefLinkPSDEViewName = linkPSDEViewBase.getPSDEVIEWBASENAME();
            }
        }
        this.strMobRefPickupPSDEViewId = this.psDER.getMOBSDPSDEVIEWID();
        this.strMobRefPickupPSDEViewName = this.psDER.getMOBSDPSDEVIEWNAME();
        if (StringHelper.isNullOrEmpty((String)this.strMobRefPickupPSDEViewId) && (pickupPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MOBPICKUPVIEW", true)) != null) {
            this.strMobRefPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
            this.strMobRefPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
        }
        this.strMobRefMPickupPSDEViewId = this.psDER.getMOBMDPSDEVIEWID();
        this.strMobRefMPickupPSDEViewName = this.psDER.getMOBMDPSDEVIEWNAME();
        if (StringHelper.isNullOrEmpty((String)this.strMobRefMPickupPSDEViewId) && (pickupPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MOBMPICKUPVIEW", true)) != null) {
            this.strMobRefMPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
            this.strMobRefMPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
        }
        this.strMobRefLinkPSDEViewId = this.psDER.getMOBLINKPSDEVIEWID();
        this.strMobRefLinkPSDEViewName = this.psDER.getMOBLINKPSDEVIEWNAME();
        if (StringHelper.isNullOrEmpty((String)this.strMobRefLinkPSDEViewId)) {
            linkPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MOBREDIRECTVIEW", true);
            if (linkPSDEViewBase == null) {
                linkPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MOBEDITVIEW", true);
            }
            if (linkPSDEViewBase != null) {
                this.strMobRefLinkPSDEViewId = linkPSDEViewBase.getPSDEVIEWBASEID();
                this.strMobRefLinkPSDEViewName = linkPSDEViewBase.getPSDEVIEWBASENAME();
            }
        }
        this.strRefDEACModeId = this.psDER.getPSDEACMODEID();
        if (StringHelper.isNullOrEmpty((String)this.strRefDEACModeId) && (psDEACMode = this.getMajorPSDataEntity().getDefaultPSDEACModeData()) != null) {
            this.strRefDEACModeId = psDEACMode.getPSDEACMODEID();
        }
        this.strMinorCodeName = this.psDER.getMINORCODENAME();
        if (!StringHelper.isNullOrEmpty((String)this.strMinorCodeName)) {
            this.strMinorXmlTagName = this.strMinorCodeName.toUpperCase();
        }
        if (!this.psDER.isENAPDEREQNull()) {
            this.bEnablePDEREQ = this.psDER.getENAPDEREQ();
            if (StringHelper.isNullOrEmpty((String)this.psDER.getMAJORPSDERID()) || StringHelper.isNullOrEmpty((String)this.psDER.getMINORPSDERID())) {
                this.bEnablePDEREQ = false;
            }
        }
        this.strFKeyName = this.psDER.getFKEYNAME();
        if (StringHelper.isNullOrEmpty((String)this.strFKeyName)) {
            IPSSysModelGroup iPSSysModelGroup = this.getMinorPSDataEntity().getPSSystemModule().getPSSysModelGroup();
            this.strFKeyName = iPSSysModelGroup == null ? StringHelper.format((String)"%1$s_%2$s", (Object)this.getMinorPSDataEntity().getName(), (Object)this.getPickupDEFName()).toUpperCase() : StringHelper.format((String)"%1$s_%2$s_%3$s", (Object)iPSSysModelGroup.getCodeName(), (Object)this.getMinorPSDataEntity().getName(), (Object)this.getPickupDEFName()).toUpperCase();
            this.strFKeyName = "F" + Helper.GenUniqueId((String)this.strFKeyName).toUpperCase();
        }
        if (StringHelper.length((String)this.strFKeyName) >= 18) {
            this.strFKeyName = this.strFKeyName.substring(0, 18);
        }
        this.strERMajorPSDEFId = this.psDER.getEXTMAJORPSDEFID();
        this.strERMinorPSDEFId = this.psDER.getEXTMINORPSDEFID();
        if (!StringHelper.isNullOrEmpty((String)this.psDER.getREMOVEREJECTPSLANRESID())) {
            this.removeRejectMsgPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psDER.getREMOVEREJECTPSLANRESID());
        }
        this.onPreparePSDER1NDEFieldMaps();
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getRefPSDEDataSet();
        return super.onCheck();
    }

    protected void onPreparePSDER1NDEFieldMaps() throws Exception {
        if (this.psDER1NDEFieldMapList != null) {
            this.psDER1NDEFieldMapList.clear();
        }
        if (this.psDER1NDEFieldMapQueryMap != null) {
            this.psDER1NDEFieldMapQueryMap.clear();
        }
        this.countPSDER1NDEFieldMap = null;
        Vector<PSDERDEFMap> psDER1NDEFieldMapList = new Vector<PSDERDEFMap>();
        CallResult callResult = this.getPSModelHelper().getPSDERDEFMaps(this.getId(), psDER1NDEFieldMapList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDER1NDEFieldMapList.size() == 0) {
            return;
        }
        if (this.psDER1NDEFieldMapList == null) {
            this.psDER1NDEFieldMapList = new ArrayList();
        }
        for (PSDERDEFMap psDERDEFMap : psDER1NDEFieldMapList) {
            PSDER1NDEFieldMapImpl iPSDER1NDEFieldMap = new PSDER1NDEFieldMapImpl();
            iPSDER1NDEFieldMap.init(this.getDAGlobalHelper(), this, psDERDEFMap);
            this.psDER1NDEFieldMapList.add(iPSDER1NDEFieldMap);
            if (StringHelper.compare((String)iPSDER1NDEFieldMap.getMapType(), (String)"COUNT", (boolean)true) != 0) continue;
            this.countPSDER1NDEFieldMap = iPSDER1NDEFieldMap;
        }
        Collections.sort(this.psDER1NDEFieldMapList, new Comparator<IPSDER1NDEFieldMap>(){

            @Override
            public int compare(IPSDER1NDEFieldMap o1, IPSDER1NDEFieldMap o2) {
                return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
            }
        });
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5c5e\u6027\u540d\u79f0", fields={"DERFIELDNAME"})
    public String getPickupDEFName() {
        return this.strPickupDEFName;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u514b\u9686", ignoredumpvalues="false", fields={"ENABLECLONE"})
    public boolean isCloneRS() {
        return this.bCloneRS;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u4ece\u5173\u7cfb\u7c7b\u578b", codelist="DER1NMasterRS", fields={"MASTERRS"})
    public int getMasterRS() {
        return this.nMasterRS;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u9644\u52a0\u7ea6\u675f", ignoredumpvalues="false", fields={"ENAEXTRANGE"})
    public boolean isEnableExtRestrict() {
        return this.bExtRestrict;
    }

    @Override
    public String getERMajorPSDEFId() {
        return this.strERMajorPSDEFId;
    }

    @Override
    public String getERMajorPSDEFName() throws Exception {
        if (this.getERMajorPSDEF() == null) {
            return "";
        }
        return this.getERMajorPSDEF().getName();
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u7ea6\u675f\u4e3b\u5c5e\u6027", hideempty2=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMajorPSDataEntityMust().getPSDEField", fields={"EXTMAJORPSDEFID"})
    public IPSDEField getERMajorPSDEF() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getERMajorPSDEFId())) {
            return null;
        }
        if (this.erMajorPSDEF == null) {
            this.erMajorPSDEF = this.getMajorPSDataEntity().getPSDEField(this.getERMajorPSDEFId());
        }
        return this.erMajorPSDEF;
    }

    @Override
    public String getERMinorPSDEFId() {
        return this.strERMinorPSDEFId;
    }

    @Override
    public String getERMinorPSDEFName() throws Exception {
        if (this.getERMinorPSDEF() == null) {
            return "";
        }
        return this.getERMinorPSDEF().getName();
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u7ea6\u675f\u4ece\u5c5e\u6027", hideempty2=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMinorPSDataEntityMust().getPSDEField", fields={"EXTMINORPSDEFID"})
    public IPSDEField getERMinorPSDEF() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getERMinorPSDEFId())) {
            return null;
        }
        if (this.erMinorPSDEF == null) {
            this.erMinorPSDEF = this.getMinorPSDataEntity().getPSDEField(this.getERMinorPSDEFId());
        }
        return this.erMinorPSDEF;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6b21\u5e8f", fields={"REMOVEORDER"})
    public int getRemoveOrder() {
        return this.nRemoveOrder;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u65b9\u5f0f", codelist="RemoveActionType", fields={"REMOVEACTIONTYPE"})
    public int getRemoveActionType() {
        return this.nRemoveActionType;
    }

    @Override
    public String getRefPSDEDataSetId() {
        return this.psDER.getPSDEDATASETID();
    }

    @Override
    public String getRefPSDEDataSetName() throws Exception {
        if (this.getRefPSDEDataSet() == null) {
            return "";
        }
        return this.getRefPSDEDataSet().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMajorPSDataEntityMust().getPSDEDataSet", fields={"PSDEDATASETID"})
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getRefPSDEDataSetId())) {
            return null;
        }
        if (this.refPSDEDataSet == null) {
            this.refPSDEDataSet = this.getMajorPSDataEntity().getPSDEDataSet(this.getRefPSDEDataSetId());
        }
        return this.refPSDEDataSet;
    }

    @Override
    public String getRefPSDEFGroupId() {
        return this.psDER.getPSDEFGROUPID();
    }

    @Override
    public String getRefPSDEFGroupName() throws Exception {
        if (this.getRefPSDEFGroup() == null) {
            return "";
        }
        return this.getRefPSDEFGroup().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5c5e\u6027\u7ec4", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMajorPSDataEntityMust().getPSDEFGroup", fields={"PSDEFGROUPID"})
    public IPSDEFGroup getRefPSDEFGroup() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getRefPSDEFGroupId())) {
            return null;
        }
        if (this.refPSDEFGroup == null) {
            this.refPSDEFGroup = this.getMajorPSDataEntity().getPSDEFGroup(this.getRefPSDEFGroupId());
        }
        return this.refPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5916\u952e", ignoredumpvalues="false", ignorepf=true, fields={"FOREIGNKEY"})
    public boolean isEnableFKey() {
        return this.bEnableFKey;
    }

    @Override
    @PSModelRTMeta(description="\u514b\u9686\u6b21\u5e8f", ignoredumpvalues="-1", fields={"CLONEORDERVALUE"})
    public int getCloneOrder() {
        return this.nCloneOrder;
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6b21\u5e8f", ignoredumpvalues="-1", fields={"TEMPORDERVALUE"})
    public int getTempDataOrder() {
        return this.nTempDataOrder;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        return this.strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        return this.strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        return this.strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        return this.strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        return this.strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        return this.strRefLinkPSDEViewName;
    }

    @Override
    public String getRefPSDEACModeId() {
        return this.strRefDEACModeId;
    }

    @Override
    public String getRefPSDEACModeName() throws Exception {
        if (this.getRefPSDEACMode() == null) {
            return "";
        }
        return this.getRefPSDEACMode().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", hideempty=true)
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getRefPSDEACModeId())) {
            return null;
        }
        if (this.refPSDEACMode == null) {
            this.refPSDEACMode = this.getMajorPSDataEntity().getPSDEACMode(this.getRefPSDEACModeId());
        }
        return this.refPSDEACMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7", ignoredumpvalues="false", fields={"ENAPDEREQ"})
    public boolean isEnablePDEREQ() {
        return this.bEnablePDEREQ;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u7236\u5173\u7cfb", hideempty2=true, dumpref=true, ignorepf=true, fields={"MAJORPSDERID"})
    public IPSDER1N getMajorPPSDER1N() throws Exception {
        if (!this.isEnablePDEREQ()) {
            return null;
        }
        return (IPSDER1N)this.getMajorPSDataEntity().getPSSystem().getPSDER(this.psDER.getMAJORPSDERID());
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u7236\u5173\u7cfb", hideempty2=true, dumpref=true, ignorepf=true, fields={"MINORPSDERID"})
    public IPSDER1N getMinorPPSDER1N() throws Exception {
        if (!this.isEnablePDEREQ()) {
            return null;
        }
        return (IPSDER1N)this.getMajorPSDataEntity().getPSSystem().getPSDER(this.psDER.getMINORPSDERID());
    }

    @Override
    @PSModelRTMeta(description="\u5916\u952e\u5c5e\u6027", dumpref=true, ignorepf=true)
    public IPSPickupDEField getPSPickupDEField() throws Exception {
        if (this.iPSPickupDEField == null) {
            this.iPSPickupDEField = this.getMinorPSDataEntity().getPSPickupDEField(this.getId());
        }
        if (this.iPSPickupDEField == null) {
            throw new Exception(String.format("1:N\u5173\u7cfb[%1$s]\u5916\u952e\u5c5e\u6027\u5bf9\u8c61\u65e0\u6548", this.getName()));
        }
        return this.iPSPickupDEField;
    }

    @Override
    public int getExportModelOrder() {
        return this.nExportModelOrder;
    }

    @Override
    public int getSyncExportModelMode() {
        return this.nSyncExportModelMode;
    }

    @Override
    @PSModelRTMeta(description="\u540c\u6b65\u6570\u636e\u6a21\u5f0f", ignorepf=true, ignoredumpvalues="0", codelist="DER1NSyncAction", fields={"SYNCEXPORTMODEL"})
    public int getSyncDataMode() {
        return this.nSyncExportModelMode;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u952e\u540d\u79f0", ignorepf=true, fields={"FKEYNAME"})
    public String getFKeyName() {
        return this.strFKeyName;
    }

    @Override
    public String getMinorXmlTagName() {
        return this.strMinorXmlTagName;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u96c6\u5408", hideempty2=true, child=true, ignorepf=true, group="\u903b\u8f91", order=220)
    public Iterator<IPSDER1NDEFieldMap> getPSDER1NDEFieldMaps() {
        if (this.psDER1NDEFieldMapList == null || this.psDER1NDEFieldMapList.size() == 0) {
            return null;
        }
        return this.psDER1NDEFieldMapList.iterator();
    }

    @Override
    public IPSDER1NDEFieldMap getCountPSDER1NDEFieldMap() {
        return this.countPSDER1NDEFieldMap;
    }

    @Override
    public Iterator<String> getPSDER1NDEFieldMapQueryNames() {
        if (this.psDER1NDEFieldMapList == null || this.psDER1NDEFieldMapList.size() == 0) {
            return null;
        }
        if (this.psDER1NDEFieldMapQueryMap == null) {
            LinkedHashMap<String, String> psDER1NDEFieldMapQueryMap = new LinkedHashMap<String, String>();
            for (IPSDER1NDEFieldMap iPSDER1NDEFieldMap : this.psDER1NDEFieldMapList) {
                try {
                    if (iPSDER1NDEFieldMap.getMinorPSDEDataQuery() != null) {
                        psDER1NDEFieldMapQueryMap.put(iPSDER1NDEFieldMap.getMinorPSDEDataQuery().getName(), "");
                        continue;
                    }
                    psDER1NDEFieldMapQueryMap.put("", "");
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
            if (this.psDER1NDEFieldMapQueryMap == null) {
                this.psDER1NDEFieldMapQueryMap = psDER1NDEFieldMapQueryMap;
            }
        }
        if (this.psDER1NDEFieldMapQueryMap.size() == 0) {
            return null;
        }
        return this.psDER1NDEFieldMapQueryMap.keySet().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u51fa\u5f15\u7528\u6570\u636e\u6a21\u5f0f", codelist="DERExportMajorModel", ignoredumpvalues="-1", fields={"EXPORTMAJORMODEL"})
    public int getExportMajorModel() {
        return this.nExportMajorModel;
    }

    @Override
    protected void onFillViewParentModeJO(JSONObject jo) {
        super.onFillViewParentModeJO(jo);
        if (!jo.has("SRFDER1NID".toLowerCase())) {
            jo.put("SRFDER1NID".toLowerCase(), (Object)this.getName());
        }
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u5bfc\u51fa\u6b21\u5e8f", ignoredumpvalues="-1", fields={"EXPORTSCOPE"})
    public int getCustomExportOrder() {
        return this.nCustomExportOrder;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u5bfc\u51fa\u6b21\u5e8f2", ignoredumpvalues="-1", fields={"EXPORTSCOPE2"})
    public int getCustomExportOrder2() {
        return this.nCustomExportOrder2;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u952e\u6587\u672c\u5c5e\u6027", hideempty=true, dumpref=true, ignorepf=true)
    public IPSLinkDEField getPSPickupTextDEField() throws Exception {
        if (this.getPSPickupDEField() != null) {
            return this.getPSPickupDEField().getPSPickupTextDEField();
        }
        return null;
    }

    @Override
    public int check() throws Exception {
        this.getPSDER1NDEFieldMapQueryNames();
        return super.check();
    }

    @Override
    @PSModelRTMeta(description="\u4e00\u5bf9\u591a\u5173\u7cfb\u6570\u636e\u5c5e\u6027", dumpref=true, ignorepf=true)
    public IPSOne2ManyDataDEField getPSOne2ManyDataDEField() throws Exception {
        if (this.iPSOne2ManyDataDEField == null && !this.bCalcPSOne2ManyDataDEField) {
            Iterator<IPSDEField> psDEFields = this.getMajorPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSOne2ManyDataDEField iPSOne2ManyDataDEField;
                    IPSDEField iPSDEField = psDEFields.next();
                    if (!(iPSDEField instanceof IPSOne2ManyDataDEField) || (iPSOne2ManyDataDEField = (IPSOne2ManyDataDEField)iPSDEField).getPSDER1N() == null || StringHelper.compare((String)iPSOne2ManyDataDEField.getPSDER1N().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    if (this.iPSOne2ManyDataDEField != null) break;
                    this.iPSOne2ManyDataDEField = iPSOne2ManyDataDEField;
                    break;
                }
            }
            this.bCalcPSOne2ManyDataDEField = true;
        }
        return this.iPSOne2ManyDataDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u64cd\u4f5c", ignoredumpvalues="false", doc="\u4e3b\u4ece\u5173\u7cfb{@link #getMasterRS}\u6307\u5b9a\u5d4c\u5957\u5f52\u5173\u7cfb")
    public boolean isNestedRS() {
        return (this.getMasterRS() & 8) == 8;
    }

    @Override
    @PSModelRTMeta(description="\u9012\u5f52\u5173\u7cfb", ignoredumpvalues="false", doc="\u4e3b\u4ece\u5173\u7cfb{@link #getMasterRS}\u6307\u5b9a\u9012\u5f52\u5173\u7cfb\uff08\u9700\u8981\u4e3b\u4ece\u5b9e\u4f53\u4e00\u81f4\uff09")
    public boolean isRecursiveRS() {
        return this.bRecursiveRS;
    }

    @Override
    public String getOriLinkPSDEViewId() {
        return this.psDER.getLINKPSDEVIEWID();
    }

    @Override
    public String getOriPickupPSDEViewId() {
        return this.psDER.getSDPSDEVIEWID();
    }

    @Override
    public String getOriMPickupPSDEViewId() {
        return this.psDER.getMDPSDEVIEWID();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u952e\u503c\u5bf9\u8c61\u5c5e\u6027")
    public IPSPickupObjectDEField getPSPickupObjectDEField() throws Exception {
        if (this.iPSPickupObjectDEField == null && !this.bCalcPSPickupObjectDEField) {
            Iterator<IPSDEField> psDEFields = this.getMinorPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSPickupObjectDEField iPSPickupObjectDEField;
                    IPSDEField iPSDEField = psDEFields.next();
                    if (!(iPSDEField instanceof IPSPickupObjectDEField) || StringHelper.compare((String)(iPSPickupObjectDEField = (IPSPickupObjectDEField)iPSDEField).getPSDER1N().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    if (this.iPSPickupObjectDEField != null) break;
                    this.iPSPickupObjectDEField = iPSPickupObjectDEField;
                    break;
                }
            }
            this.bCalcPSPickupObjectDEField = true;
        }
        return this.iPSPickupObjectDEField;
    }

    @Override
    public String getMobRefPickupPSDEViewId() {
        return this.strMobRefPickupPSDEViewId;
    }

    @Override
    public String getMobRefPickupPSDEViewName() {
        return this.strMobRefPickupPSDEViewName;
    }

    @Override
    public String getMobRefMPickupPSDEViewId() {
        return this.strMobRefMPickupPSDEViewId;
    }

    @Override
    public String getMobRefMPickupPSDEViewName() {
        return this.strMobRefMPickupPSDEViewName;
    }

    @Override
    public String getMobRefLinkPSDEViewId() {
        return this.strMobRefLinkPSDEViewId;
    }

    @Override
    public String getMobRefLinkPSDEViewName() {
        return this.strMobRefLinkPSDEViewName;
    }

    @Override
    public String getOriMobLinkPSDEViewId() {
        return this.psDER.getMOBLINKPSDEVIEWID();
    }

    @Override
    public String getOriMobPickupPSDEViewId() {
        return this.psDER.getMOBSDPSDEVIEWID();
    }

    @Override
    public String getOriMobMPickupPSDEViewId() {
        return this.psDER.getMOBMDPSDEVIEWID();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5c5e\u6027\u56de\u5199", ignoredumpvalues="false", doc="\u4ece\u5173\u7cfb\u5c5e\u6027\u4e2d\u8ba1\u7b97")
    public boolean isEnableDEFieldWriteBack() throws Exception {
        if (this.bEnableWriteBack == null) {
            Iterator<IPSDEField> psDEFields = this.getMinorPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSPickupDataDEField iPSPickupDataDEField;
                    IPSDEField iPSDEField = psDEFields.next();
                    if (!(iPSDEField instanceof IPSPickupDataDEField) || StringHelper.compare((String)(iPSPickupDataDEField = (IPSPickupDataDEField)iPSDEField).getDERId(), (String)this.getId(), (boolean)false) != 0 || !iPSPickupDataDEField.isEnableWriteBack()) continue;
                    this.bEnableWriteBack = true;
                    break;
                }
            }
            if (this.bEnableWriteBack == null) {
                this.bEnableWriteBack = false;
            }
        }
        return this.bEnableWriteBack;
    }

    @Override
    public boolean isEnableDEFieldWriteBackDefault() {
        return this.bEnableDEFieldWriteBackDefault || (this.getMasterRS() & 0x400) == 1024;
    }

    @Override
    public boolean isIngoreDEFieldRefreshDefault() {
        return this.bIgnoreDEFieldRefreshDefault;
    }

    @Override
    public String getModelRefId() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u63a7\u6b21\u5e8f", fields={"MASTERORDERVALUE"})
    public int getMasterOrder() {
        return this.nMasterOrder;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u62d2\u7edd\u6d88\u606f", fields={"REMOVEREJECTMSG"})
    public String getRemoveRejectMsg() {
        return this.psDER.getREMOVEREJECTMSG();
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u62d2\u7edd\u6d88\u606f\u8bed\u8a00\u8d44\u6e90", fields={"REMOVEREJECTPSLANRESID"})
    public IPSLanguageRes getRRMPSLanguageRes() {
        return this.removeRejectMsgPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u62d2\u7edd\u6d88\u606f\u8bed\u8a00\u6807\u8bb0")
    public String getRRMLanResTag() {
        if (this.getRRMPSLanguageRes() == null) {
            return "";
        }
        return this.getRRMPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u952e\u5c5e\u6027", staticcode="this.getPSPickupDEField()")
    public IPSDEField getPickupPSDEField() throws Exception {
        return this.getPSPickupDEField();
    }

    @Override
    public String getNestedPSDEDataSetId() {
        return this.psDER.getMINORPSDEDSID();
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6210\u5458\u6570\u636e\u96c6\u5bf9\u8c61", hideempty2=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMinorPSDataEntityMust().getPSDEDataSet", fields={"MINORPSDEDSID"})
    public IPSDEDataSet getNestedPSDEDataSet() throws Exception {
        if (this.nestedPSDEDataSet != null) {
            return this.nestedPSDEDataSet;
        }
        if (!StringHelper.isNullOrEmpty((String)this.getNestedPSDEDataSetId())) {
            this.nestedPSDEDataSet = this.getMinorPSDataEntity().getPSDEDataSet(this.getNestedPSDEDataSetId());
        }
        return this.nestedPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7269\u7406\u5316\u66f4\u65b0", ignoredumpvalues="false", fields={"UPDATEPHYSICALDEFIELD"})
    public boolean isEnablePhysicalDEFieldUpdate() {
        return this.psDER.getUPDATEPHYSICALDEFIELD();
    }
}

