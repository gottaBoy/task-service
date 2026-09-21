/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupTextDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFGroupDetailImpl;
import SA.SRFDA.PS.Core.DEField.PSDEFGroupDetailImpl2;
import SA.SRFDA.PS.Core.DEField.PSDEFGroupDetailImpl3;
import SA.SRFDA.PS.Core.DEField.PSDEFGroupDetailImpl4;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Data.PSDEFGroup;
import SA.SRFDA.PS.Data.PSDEFGroupDetail;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFGroupImpl
extends PSDataEntityObjectImpl
implements IPSDEFGroup {
    private static final Log log = LogFactory.getLog(PSDEFGroupImpl.class);
    protected PSDEFGroup psDEFGroup = null;
    protected ArrayList<IPSDEField> psDEFieldList = new ArrayList();
    protected ArrayList<IPSDEFGroupDetail> psDEFGroupDetailList = new ArrayList();
    private String strCodeName = "";
    private String strGroupType = "FIELDS";
    private int nOrderValue = 99999;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEFGroup psDEFGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEFGroup = psDEFGroup;
            this.setId(this.psDEFGroup.getPSDEFGROUPID());
            this.setName(this.psDEFGroup.getPSDEFGROUPNAME());
            this.setPSObjectData(this.psDEFGroup);
            this.strCodeName = this.psDEFGroup.getCODENAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFGroup.getGROUPTYPE())) {
                this.strGroupType = this.psDEFGroup.getGROUPTYPE();
            }
            if (!this.psDEFGroup.isORDERVALUENull()) {
                this.nOrderValue = this.psDEFGroup.getORDERVALUE();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupType(), (String)"FORMITEMS", (boolean)false) == 0) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFGroup.getPSDEFORMID())) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5c5e\u6027\u7ec4\u7c7b\u578b\u4e3a\u3010\u8868\u5355\u9879\u3011\u4f46\u6ca1\u6709\u6307\u5b9a\u76f8\u5e94\u7684\u5b9e\u4f53\u7f16\u8f91\u8868\u5355"));
                }
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupType(), (String)"GRIDCOLUMNS", (boolean)false) == 0 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFGroup.getPSDEGRIDID())) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5c5e\u6027\u7ec4\u7c7b\u578b\u4e3a\u3010\u8868\u683c\u5217\u3011\u4f46\u6ca1\u6709\u6307\u5b9a\u76f8\u5e94\u7684\u5b9e\u4f53\u8868\u683c"));
            }
            this.onInit();
        }
        catch (Exception ex) {
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
        String strPSSysSFPluginId = this.psDEFGroup.getPSSYSSFPLUGINID();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
        this.onPreparePSDEFields();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u7c7b\u578b", codelist="DEFGroupType", group="\u57fa\u672c", order=125)
    public String getGroupType() {
        return this.strGroupType;
    }

    protected void onPreparePSDEFields() throws Exception {
        PSObjectImpl iPSDEFGroupDetail;
        IPSDEField iPSDEField3;
        Iterator<IPSDEField> psDEFields;
        Object iPSDEFGroupDetail2;
        PSObjectImpl iPSDEFGroupDetail3;
        IPSDEField pickupPSDEField;
        ArrayList<IPSDEFGroupDetail> psDEFGroupDetailList2;
        LinkedHashMap<String, BaseDataEntity> defieldMap;
        CallResult callResult;
        this.psDEFieldList.clear();
        this.psDEFGroupDetailList.clear();
        LinkedHashMap<String, IPSDEField> psDEFieldMap = null;
        Vector<PSDEFGroupDetail> psDEFGroupDetailList = new Vector<PSDEFGroupDetail>();
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupType(), (String)"FIELDS", (boolean)false) == 0) {
            CallResult callResult2 = this.getPSModelHelper().getPSDEFGroupDetails(this.getId(), psDEFGroupDetailList);
            if (callResult2.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult2.getErrorInfo()));
            }
            for (PSDEFGroupDetail psDEFGroupDetail : psDEFGroupDetailList) {
                if (!psDEFGroupDetail.isVALIDFLAGNull() && !psDEFGroupDetail.getVALIDFLAG()) continue;
                PSDEFGroupDetailImpl iPSDEFGroupDetail32 = new PSDEFGroupDetailImpl();
                iPSDEFGroupDetail32.init(this.getDAGlobalHelper(), this, psDEFGroupDetail);
                this.psDEFGroupDetailList.add(iPSDEFGroupDetail32);
                if (iPSDEFGroupDetail32.getPSDEField() == null) continue;
                this.psDEFieldList.add(iPSDEFGroupDetail32.getPSDEField());
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupType(), (String)"FORMITEMS", (boolean)false) == 0) {
            Vector<PSDEFormDetail> psDEFormDetailList = new Vector<PSDEFormDetail>();
            callResult = this.getPSModelHelper().getPSDEFGroupItems(this.getId(), psDEFormDetailList);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u7ec4\u8868\u5355\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
            defieldMap = new LinkedHashMap<String, BaseDataEntity>();
            LinkedHashMap<String, Object> psDEFGroupDetailImpl2Map = new LinkedHashMap<String, Object>();
            for (PSDEFormDetail psDEFormDetail : psDEFormDetailList) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEFormDetail.getDETAILTYPE(), (String)"FORMITEM", (boolean)false) != 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPSDEFID()) || defieldMap.containsKey(psDEFormDetail.getPSDEFID())) continue;
                defieldMap.put(psDEFormDetail.getPSDEFID(), psDEFormDetail);
                PSDEFGroupDetailImpl2 iPSDEFGroupDetail22 = new PSDEFGroupDetailImpl2();
                iPSDEFGroupDetail22.init(this.getDAGlobalHelper(), this, psDEFormDetail);
                this.psDEFGroupDetailList.add(iPSDEFGroupDetail22);
                if (iPSDEFGroupDetail22.getPSDEField() != null) {
                    this.psDEFieldList.add(iPSDEFGroupDetail22.getPSDEField());
                }
                psDEFGroupDetailImpl2Map.put(psDEFormDetail.getPSDEFID(), iPSDEFGroupDetail22);
            }
            psDEFGroupDetailList2 = new ArrayList<IPSDEFGroupDetail>();
            psDEFGroupDetailList2.addAll(this.psDEFGroupDetailList);
            for (IPSDEFGroupDetail iPSDEFGroupDetail4 : psDEFGroupDetailList2) {
                PSDEFGroupDetailImpl2 psDEFGroupDetailImpl2;
                PSDEFormDetail psDEFormDetail;
                IPSDEField iPSDEField2 = iPSDEFGroupDetail4.getPSDEField();
                if (iPSDEField2 == null) continue;
                if (iPSDEField2.isInheritDEField()) {
                    if (!(((IPSLinkDEField)iPSDEField2).getRelatedPSDEField() instanceof IPSPickupTextDEField)) continue;
                    pickupPSDEField = ((IPSPickupTextDEField)((IPSLinkDEField)iPSDEField2).getRelatedPSDEField()).getPSPickupDEField();
                    pickupPSDEField = this.getPSDataEntity().getPSDEField(pickupPSDEField.getName(), true);
                    if (pickupPSDEField == null) continue;
                    if (!defieldMap.containsKey(pickupPSDEField.getId())) {
                        defieldMap.put(pickupPSDEField.getId(), null);
                        psDEFormDetail = new PSDEFormDetail();
                        psDEFormDetail.setPSDEFORMDETAILID(pickupPSDEField.getId());
                        psDEFormDetail.setPSDEFORMDETAILNAME(pickupPSDEField.getName());
                        psDEFormDetail.setCAPTION(iPSDEFGroupDetail4.getLogicName());
                        psDEFormDetail.setMEMO(iPSDEFGroupDetail4.getMemo());
                        psDEFormDetail.setPSDEFID(pickupPSDEField.getId());
                        psDEFormDetail.setPSDEFNAME(pickupPSDEField.getName());
                        psDEFormDetail.setDETAILTYPE("FORMITEM");
                        iPSDEFGroupDetail3 = new PSDEFGroupDetailImpl2();
                        ((PSDEFGroupDetailImpl2)iPSDEFGroupDetail3).init(this.getDAGlobalHelper(), this, psDEFormDetail);
                        this.psDEFGroupDetailList.add((IPSDEFGroupDetail)((Object)iPSDEFGroupDetail3));
                        this.psDEFieldList.add(pickupPSDEField);
                        continue;
                    }
                    psDEFGroupDetailImpl2 = (PSDEFGroupDetailImpl2)psDEFGroupDetailImpl2Map.get(pickupPSDEField.getId());
                    psDEFGroupDetailImpl2.setPickupTextPSDEFGroupDetail(iPSDEFGroupDetail4);
                    continue;
                }
                if (!(iPSDEField2 instanceof IPSPickupTextDEField)) continue;
                pickupPSDEField = ((IPSPickupTextDEField)iPSDEField2).getPSPickupDEField();
                if (!defieldMap.containsKey(pickupPSDEField.getId())) {
                    defieldMap.put(pickupPSDEField.getId(), null);
                    psDEFormDetail = new PSDEFormDetail();
                    psDEFormDetail.setPSDEFORMDETAILID(pickupPSDEField.getId());
                    psDEFormDetail.setPSDEFORMDETAILNAME(pickupPSDEField.getName());
                    psDEFormDetail.setCAPTION(iPSDEFGroupDetail4.getLogicName());
                    psDEFormDetail.setMEMO(iPSDEFGroupDetail4.getMemo());
                    psDEFormDetail.setPSDEFID(pickupPSDEField.getId());
                    psDEFormDetail.setPSDEFNAME(pickupPSDEField.getName());
                    psDEFormDetail.setDETAILTYPE("FORMITEM");
                    iPSDEFGroupDetail3 = new PSDEFGroupDetailImpl2();
                    ((PSDEFGroupDetailImpl2)iPSDEFGroupDetail3).init(this.getDAGlobalHelper(), this, psDEFormDetail);
                    this.psDEFGroupDetailList.add((IPSDEFGroupDetail)((Object)iPSDEFGroupDetail3));
                    this.psDEFieldList.add(pickupPSDEField);
                    continue;
                }
                psDEFGroupDetailImpl2 = (PSDEFGroupDetailImpl2)psDEFGroupDetailImpl2Map.get(pickupPSDEField.getId());
                psDEFGroupDetailImpl2.setPickupTextPSDEFGroupDetail(iPSDEFGroupDetail4);
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupType(), (String)"GRIDCOLUMNS", (boolean)false) == 0) {
            Vector<PSDEGridColumn> psDEGridColumnList = new Vector<PSDEGridColumn>();
            callResult = this.getPSModelHelper().getPSDEFGroupColumns(this.getId(), psDEGridColumnList);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u7ec4\u8868\u683c\u5217\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
            defieldMap = new LinkedHashMap();
            LinkedHashMap<String, Object> psDEFGroupDetailImpl4Map = new LinkedHashMap<String, Object>();
            for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEGridColumn.getGRIDCOLTYPE(), (String)"DEFGRIDCOLUMN", (boolean)false) != 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEGridColumn.getPSDEFID()) || defieldMap.containsKey(psDEGridColumn.getPSDEFID())) continue;
                defieldMap.put(psDEGridColumn.getPSDEFID(), psDEGridColumn);
                iPSDEFGroupDetail2 = new PSDEFGroupDetailImpl4();
                ((PSDEFGroupDetailImpl4)iPSDEFGroupDetail2).init(this.getDAGlobalHelper(), this, psDEGridColumn);
                this.psDEFGroupDetailList.add((IPSDEFGroupDetail)iPSDEFGroupDetail2);
                if (((PSDEFGroupDetailImpl4)iPSDEFGroupDetail2).getPSDEField() != null) {
                    this.psDEFieldList.add(((PSDEFGroupDetailImpl4)iPSDEFGroupDetail2).getPSDEField());
                }
                psDEFGroupDetailImpl4Map.put(psDEGridColumn.getPSDEFID(), iPSDEFGroupDetail2);
            }
            psDEFGroupDetailList2 = new ArrayList();
            psDEFGroupDetailList2.addAll(this.psDEFGroupDetailList);
            for (IPSDEFGroupDetail iPSDEFGroupDetail5 : psDEFGroupDetailList2) {
                PSDEFGroupDetailImpl4 psDEFGroupDetailImpl4;
                PSDEGridColumn psDEGridColumn;
                IPSDEField iPSDEField2 = iPSDEFGroupDetail5.getPSDEField();
                if (iPSDEField2 == null) continue;
                if (iPSDEField2.isInheritDEField()) {
                    if (!(((IPSLinkDEField)iPSDEField2).getRelatedPSDEField() instanceof IPSPickupTextDEField)) continue;
                    pickupPSDEField = ((IPSPickupTextDEField)((IPSLinkDEField)iPSDEField2).getRelatedPSDEField()).getPSPickupDEField();
                    pickupPSDEField = this.getPSDataEntity().getPSDEField(pickupPSDEField.getName(), true);
                    if (pickupPSDEField == null) continue;
                    if (!defieldMap.containsKey(pickupPSDEField.getId())) {
                        defieldMap.put(pickupPSDEField.getId(), null);
                        psDEGridColumn = new PSDEGridColumn();
                        psDEGridColumn.setPSDEGRIDCOLID(pickupPSDEField.getId());
                        psDEGridColumn.setPSDEGRIDCOLNAME(pickupPSDEField.getName());
                        psDEGridColumn.setCAPTION(iPSDEFGroupDetail5.getLogicName());
                        psDEGridColumn.setMEMO(iPSDEFGroupDetail5.getMemo());
                        psDEGridColumn.setPSDEFID(pickupPSDEField.getId());
                        psDEGridColumn.setPSDEFNAME(pickupPSDEField.getName());
                        psDEGridColumn.setGRIDCOLTYPE("DEFGRIDCOLUMN");
                        iPSDEFGroupDetail3 = new PSDEFGroupDetailImpl4();
                        ((PSDEFGroupDetailImpl4)iPSDEFGroupDetail3).init(this.getDAGlobalHelper(), this, psDEGridColumn);
                        this.psDEFGroupDetailList.add((IPSDEFGroupDetail)((Object)iPSDEFGroupDetail3));
                        this.psDEFieldList.add(pickupPSDEField);
                        continue;
                    }
                    psDEFGroupDetailImpl4 = (PSDEFGroupDetailImpl4)psDEFGroupDetailImpl4Map.get(pickupPSDEField.getId());
                    psDEFGroupDetailImpl4.setPickupTextPSDEFGroupDetail(iPSDEFGroupDetail5);
                    continue;
                }
                if (!(iPSDEField2 instanceof IPSPickupTextDEField)) continue;
                pickupPSDEField = ((IPSPickupTextDEField)iPSDEField2).getPSPickupDEField();
                if (!defieldMap.containsKey(pickupPSDEField.getId())) {
                    defieldMap.put(pickupPSDEField.getId(), null);
                    psDEGridColumn = new PSDEGridColumn();
                    psDEGridColumn.setPSDEGRIDCOLID(pickupPSDEField.getId());
                    psDEGridColumn.setPSDEGRIDCOLNAME(pickupPSDEField.getName());
                    psDEGridColumn.setCAPTION(iPSDEFGroupDetail5.getLogicName());
                    psDEGridColumn.setMEMO(iPSDEFGroupDetail5.getMemo());
                    psDEGridColumn.setPSDEFID(pickupPSDEField.getId());
                    psDEGridColumn.setPSDEFNAME(pickupPSDEField.getName());
                    psDEGridColumn.setGRIDCOLTYPE("DEFGRIDCOLUMN");
                    iPSDEFGroupDetail3 = new PSDEFGroupDetailImpl4();
                    ((PSDEFGroupDetailImpl4)iPSDEFGroupDetail3).init(this.getDAGlobalHelper(), this, psDEGridColumn);
                    this.psDEFGroupDetailList.add((IPSDEFGroupDetail)((Object)iPSDEFGroupDetail3));
                    this.psDEFieldList.add(pickupPSDEField);
                    continue;
                }
                psDEFGroupDetailImpl4 = (PSDEFGroupDetailImpl4)psDEFGroupDetailImpl4Map.get(pickupPSDEField.getId());
                psDEFGroupDetailImpl4.setPickupTextPSDEFGroupDetail(iPSDEFGroupDetail5);
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupType(), (String)"BASEFIELDS", (boolean)false) == 0) {
            Iterator<IPSDEOPPriv> psDEOPPrivs;
            Iterator<IPSDERBase> psDERBases;
            Iterator<IPSDEWF> psDEWFs;
            psDEFieldMap = new LinkedHashMap<String, IPSDEField>();
            psDEFields = this.getPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSDEField iPSDEField4 = psDEFields.next();
                    if (iPSDEField4.isKeyDEField() || iPSDEField4.isUniTagField() || iPSDEField4.isMajorDEField() || iPSDEField4.isKeyNameDEField() || iPSDEField4.isMultiFormDEField() || iPSDEField4.isIndexTypeDEField()) {
                        psDEFieldMap.put(iPSDEField4.getId(), iPSDEField4);
                        continue;
                    }
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEField4.getPredefinedType())) continue;
                    psDEFieldMap.put(iPSDEField4.getId(), iPSDEField4);
                }
            }
            if ((psDEFields = this.getPSDataEntity().getMainStatePSDEFields()) != null) {
                while (psDEFields.hasNext()) {
                    iPSDEField3 = psDEFields.next();
                    psDEFieldMap.put(iPSDEField3.getId(), iPSDEField3);
                }
            }
            if ((psDEFields = this.getPSDataEntity().getUnionKeyValuePSDEFields()) != null) {
                while (psDEFields.hasNext()) {
                    iPSDEField3 = psDEFields.next();
                    psDEFieldMap.put(iPSDEField3.getId(), iPSDEField3);
                }
            }
            if (this.getPSDataEntity().getLogicValidPSDEField() != null) {
                psDEFieldMap.put(this.getPSDataEntity().getLogicValidPSDEField().getId(), this.getPSDataEntity().getLogicValidPSDEField());
            }
            if ((psDEWFs = this.getPSDataEntity().getAllPSDEWFs()) != null) {
                while (psDEWFs.hasNext()) {
                    IPSDEWF iPSDEWF = psDEWFs.next();
                    if (iPSDEWF.getUDStatePSDEField() != null) {
                        psDEFieldMap.put(iPSDEWF.getUDStatePSDEField().getId(), iPSDEWF.getUDStatePSDEField());
                    }
                    if (iPSDEWF.getWFStepPSDEField() == null) continue;
                    psDEFieldMap.put(iPSDEWF.getWFStepPSDEField().getId(), iPSDEWF.getWFStepPSDEField());
                }
            }
            if ((psDERBases = this.getPSDataEntity().getMinorPSDERs()) != null) {
                while (psDERBases.hasNext()) {
                    IPSDER1N iPSDER1N;
                    IPSDERBase iPSDERBase = psDERBases.next();
                    if (!(iPSDERBase instanceof IPSDER1N) || ((iPSDER1N = (IPSDER1N)iPSDERBase).getMasterRS() & 4) != 4) continue;
                    psDEFieldMap.put(iPSDER1N.getPSPickupDEField().getId(), iPSDER1N.getPSPickupDEField());
                }
            }
            if ((psDEOPPrivs = this.getPSDataEntity().getAllPSDEOPPrivs()) != null) {
                while (psDEOPPrivs.hasNext()) {
                    IPSDEOPPriv iPSDEOPPriv = psDEOPPrivs.next();
                    if (iPSDEOPPriv.getMapPSDER1N() == null || SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEOPPriv.getMapPSDER1N().getMinorPSDataEntity().getId(), (String)this.getPSDataEntity().getId(), (boolean)false) != 0) continue;
                    psDEFieldMap.put(iPSDEOPPriv.getMapPSDER1N().getPSPickupDEField().getId(), iPSDEOPPriv.getMapPSDER1N().getPSPickupDEField());
                }
            }
            for (IPSDEField iPSDEField3 : psDEFieldMap.values()) {
                iPSDEFGroupDetail2 = new PSDEFGroupDetailImpl3();
                ((PSDEFGroupDetailImpl3)iPSDEFGroupDetail2).init(this.getDAGlobalHelper(), this, iPSDEField3);
                this.psDEFGroupDetailList.add((IPSDEFGroupDetail)iPSDEFGroupDetail2);
                if (((PSDEFGroupDetailImpl3)iPSDEFGroupDetail2).getPSDEField() == null) continue;
                this.psDEFieldList.add(((PSDEFGroupDetailImpl3)iPSDEFGroupDetail2).getPSDEField());
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getGroupType(), (String)"AUDITFIELDS", (boolean)false) == 0) {
            psDEFieldMap = new LinkedHashMap();
            psDEFields = this.getPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    iPSDEField3 = psDEFields.next();
                    if (!iPSDEField3.isEnableAudit()) continue;
                    psDEFieldMap.put(iPSDEField3.getId(), iPSDEField3);
                }
            }
            for (IPSDEField iPSDEField3 : psDEFieldMap.values()) {
                iPSDEFGroupDetail = new PSDEFGroupDetailImpl3();
                ((PSDEFGroupDetailImpl3)iPSDEFGroupDetail).init(this.getDAGlobalHelper(), this, iPSDEField3);
                this.psDEFGroupDetailList.add((IPSDEFGroupDetail)((Object)iPSDEFGroupDetail));
                if (((PSDEFGroupDetailImpl3)iPSDEFGroupDetail).getPSDEField() == null) continue;
                this.psDEFieldList.add(((PSDEFGroupDetailImpl3)iPSDEFGroupDetail).getPSDEField());
            }
        }
        if (psDEFieldMap != null) {
            CallResult callResult2 = this.getPSModelHelper().getPSDEFGroupDetails(this.getId(), psDEFGroupDetailList);
            if (callResult2.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult2.getErrorInfo()));
            }
            for (PSDEFGroupDetail psDEFGroupDetail : psDEFGroupDetailList) {
                if (!psDEFGroupDetail.isVALIDFLAGNull() && !psDEFGroupDetail.getVALIDFLAG() || psDEFieldMap.containsKey(psDEFGroupDetail.getPSDEFID())) continue;
                iPSDEFGroupDetail = new PSDEFGroupDetailImpl();
                ((PSDEFGroupDetailImpl)iPSDEFGroupDetail).init(this.getDAGlobalHelper(), this, psDEFGroupDetail);
                this.psDEFGroupDetailList.add((IPSDEFGroupDetail)((Object)iPSDEFGroupDetail));
                if (((PSDEFGroupDetailImpl)iPSDEFGroupDetail).getPSDEField() == null) continue;
                this.psDEFieldList.add(((PSDEFGroupDetailImpl)iPSDEFGroupDetail).getPSDEField());
            }
        }
        PSModelUtil.sort(this.psDEFGroupDetailList);
        PSModelUtil.sort(this.psDEFieldList);
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u96c6\u5408")
    public Iterator<IPSDEField> getPSDEFields() {
        if (this.psDEFieldList == null || this.psDEFieldList.size() == 0) {
            return null;
        }
        return this.psDEFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSDEFGroupDetail> getPSDEFGroupDetails() {
        if (this.psDEFGroupDetailList == null || this.psDEFGroupDetailList.size() == 0) {
            return null;
        }
        return this.psDEFGroupDetailList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDEFGROUP";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDEFGroup.getCODENAME2();
    }

    @Override
    public boolean contains(String strPSDEFieldName) {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDEFieldName)) {
            return false;
        }
        if (this.psDEFieldList == null || this.psDEFieldList.size() == 0) {
            return false;
        }
        for (IPSDEField iPSDEField : this.psDEFieldList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEField.getId(), (String)strPSDEFieldName, (boolean)false) == 0) {
                return true;
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEField.getName(), (String)strPSDEFieldName, (boolean)true) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(IPSDEField iPSDEField2) {
        if (iPSDEField2 == null) {
            return false;
        }
        if (this.psDEFieldList == null || this.psDEFieldList.size() == 0) {
            return false;
        }
        for (IPSDEField iPSDEField : this.psDEFieldList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEField.getId(), (String)iPSDEField2.getId(), (boolean)false) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    public IPSDEFGroupDetail getPSDEFGroupDetail(String strPSDEFIdOrName, boolean bTryMode) throws Exception {
        for (IPSDEFGroupDetail iPSDEFGroupDetail : this.psDEFGroupDetailList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFGroupDetail.getPSDEField().getId(), (String)strPSDEFIdOrName, (boolean)false) == 0) {
                return iPSDEFGroupDetail;
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFGroupDetail.getPSDEField().getName(), (String)strPSDEFIdOrName, (boolean)true) != 0) continue;
            return iPSDEFGroupDetail;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458[%1$s]", (Object)strPSDEFIdOrName));
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6a21\u5f0f", hideempty2=true, codelist="DEFGroupLogicMode", fields={"LOGICMODE"})
    public String getLogicMode() {
        return this.psDEFGroup.getLOGICMODE();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb0", fields={"GROUPTAG"})
    public String getGroupTag() {
        return this.psDEFGroup.getGROUPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb02", fields={"GROUPTAG2"})
    public String getGroupTag2() {
        return this.psDEFGroup.getGROUPTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u6570", hideempty2=true, fields={"LOGICPARAM"})
    public String getLogicParam() {
        return this.psDEFGroup.getLOGICPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65702", hideempty2=true, fields={"LOGICPARAM2"})
    public String getLogicParam2() {
        return this.psDEFGroup.getLOGICPARAM2();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="DTO\u4ee3\u7801\u6807\u8bc6", dump=false, fields={"DTOCODENAME"})
    public String getDTOCodeName() {
        return this.psDEFGroup.getDTOCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }
}

