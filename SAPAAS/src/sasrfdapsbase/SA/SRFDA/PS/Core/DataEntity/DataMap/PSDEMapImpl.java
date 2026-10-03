/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMap;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapAction;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapField;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapActionImpl;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapDataQueryImpl;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapDataSetImpl;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapDetailImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSysRefDE;
import SA.SRFDA.PS.Data.PSDEMap;
import SA.SRFDA.PS.Data.PSDEMapAction;
import SA.SRFDA.PS.Data.PSDEMapDataQuery;
import SA.SRFDA.PS.Data.PSDEMapDataSet;
import SA.SRFDA.PS.Data.PSDEMapDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMapImpl
extends PSDataEntityObjectImpl
implements IPSDEMap,
IPSAppDEMap,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEMapImpl.class);
    protected PSDEMap psDEMap;
    protected List<PSDEMapDetailImpl> psDEMapDetailList = new ArrayList<PSDEMapDetailImpl>();
    protected List<PSDEMapActionImpl> psDEMapActionList = new ArrayList<PSDEMapActionImpl>();
    protected List<IPSDEMapDataQuery> psDEMapDataQueryList = new ArrayList<IPSDEMapDataQuery>();
    protected List<PSDEMapDataSetImpl> psDEMapDataSetList = new ArrayList<PSDEMapDataSetImpl>();
    protected String strCodeName = "";
    protected IPSSysRef iPSSysRef = null;
    protected IPSSysRefDE dstPSSysRefDE = null;
    private IPSDataEntity dstPSDataEntity = null;
    private boolean bAutoDEFieldMap = false;
    private boolean bAutoDEActionMap = false;
    private boolean bAutoDEDataQueryMap = false;
    private boolean bAutoDEDataSetMap = false;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private boolean bValid = true;
    private Properties mapParams = null;
    private int nLogicHolder = 1;
    private IPSAppDataEntity iPSAppDataEntity = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, PSDEMap psDEMap) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.init(iDAGlobalHelper, this.iPSAppDataEntity.getPSDataEntity(), psDEMap);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEMap psDEMap) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEMap = psDEMap;
            this.setId(psDEMap.getPSDEMAPID());
            this.setName(psDEMap.getPSDEMAPNAME());
            this.setPSObjectData(this.psDEMap);
            this.strCodeName = this.psDEMap.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysRefId())) {
                this.iPSSysRef = this.getPSDataEntity().getPSSystem().getPSSysRef(this.getPSSysRefId());
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getDstPSSysRefDEId())) {
                    this.dstPSSysRefDE = this.iPSSysRef.getPSSysRefDE(this.getDstPSSysRefDEId(), false);
                }
            } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEMap.getDSTPSDEID())) {
                this.dstPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity2(psDEMap.getDSTPSDEID());
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getMapTarget(), (String)"SYSCUR", (boolean)true) == 0 && this.getDstPSDE() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6620\u5c04\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61");
            }
            if (!this.psDEMap.isAUTODEFIELDMAPNull()) {
                this.bAutoDEFieldMap = this.psDEMap.getAUTODEFIELDMAP();
            }
            if (!this.psDEMap.isAUTODEACTIONMAPNull()) {
                this.bAutoDEActionMap = this.psDEMap.getAUTODEACTIONMAP();
            }
            if (!this.psDEMap.isAUTODEDQMAPNull()) {
                this.bAutoDEDataQueryMap = this.psDEMap.getAUTODEDQMAP();
            }
            if (!this.psDEMap.isAUTODEDSMAPNull()) {
                this.bAutoDEDataSetMap = this.psDEMap.getAUTODEDSMAP();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEMap.getPROPERTYMAP())) {
                this.mapParams = PropertiesHelper.load((String)this.psDEMap.getPROPERTYMAP());
            }
            if (!this.psDEMap.isVALIDFLAGNull()) {
                this.bValid = this.psDEMap.getVALIDFLAG();
            }
            if (!this.psDEMap.isLOGICHOLDERNull()) {
                this.nLogicHolder = this.psDEMap.getLOGICHOLDER();
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEMap.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEMap.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
        this.onPreparePSDEMapDetails();
    }

    protected void onPreparePSDEMapDetails() throws Exception {
        this.psDEMapDetailList.clear();
        this.psDEMapActionList.clear();
        this.psDEMapDataQueryList.clear();
        this.psDEMapDataSetList.clear();
        Vector<PSDEMapDetail> psDEMapDetailList = new Vector<PSDEMapDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDEMapDetails(this.getId(), psDEMapDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u6620\u5c04\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, String> psDEMapDetailMap = new HashMap<String, String>();
        HashMap<String, String> srcPSDEMapDetailMap = new HashMap<String, String>();
        for (PSDEMapDetail psDEMapDetail : psDEMapDetailList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEMapDetail.getSRCPSDEFNAME())) {
                srcPSDEMapDetailMap.put(psDEMapDetail.getSRCPSDEFNAME().toUpperCase(), "");
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEMapDetail.getDSTFIELDNAME())) {
                psDEMapDetailMap.put(psDEMapDetail.getDSTFIELDNAME().toUpperCase(), "");
            }
            if (!psDEMapDetail.isVALIDFLAGNull() && !psDEMapDetail.getVALIDFLAG()) continue;
            PSDEMapDetailImpl iPSDEMapDetail = new PSDEMapDetailImpl();
            iPSDEMapDetail.init(this.getDAGlobalHelper(), this, psDEMapDetail);
            this.psDEMapDetailList.add(iPSDEMapDetail);
        }
        if (this.isAutoDEFieldMap() && this.getDstPSDE() != null) {
            Vector<PSDEMapDetail> psDEMapDetailList2 = new Vector<PSDEMapDetail>();
            Iterator<IPSDEField> psDEFields = this.getDstPSDE().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    PSDEMapDetail psDEMapDetail;
                    IPSDEField iPSDEField = psDEFields.next();
                    if (psDEMapDetailMap.containsKey(iPSDEField.getName().toUpperCase())) continue;
                    if (iPSDEField.isKeyDEField() && this.getPSDataEntity().getKeyPSDEField() != null && !srcPSDEMapDetailMap.containsKey(this.getPSDataEntity().getKeyPSDEField().getName())) {
                        psDEMapDetail = new PSDEMapDetail();
                        psDEMapDetail.setPSDEMAPDETAILID(KeyValueHelper.genUniqueId((String)this.getPSDataEntity().getKeyPSDEField().getId(), (String)iPSDEField.getId()));
                        psDEMapDetail.setPSDEMAPDETAILNAME(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s ==> %2$s", (Object)this.getPSDataEntity().getKeyPSDEField().getName(), (Object)iPSDEField.getName()));
                        psDEMapDetail.setSRCTYPE("FIELD");
                        psDEMapDetail.setSRCPSDEFID(this.getPSDataEntity().getKeyPSDEField().getId());
                        psDEMapDetail.setSRCPSDEFNAME(this.getPSDataEntity().getKeyPSDEField().getName());
                        psDEMapDetail.setDSTFIELDNAME(iPSDEField.getName());
                        psDEMapDetailList2.add(psDEMapDetail);
                        continue;
                    }
                    if (iPSDEField.isMajorDEField() && this.getPSDataEntity().getMajorPSDEField() != null && !srcPSDEMapDetailMap.containsKey(this.getPSDataEntity().getMajorPSDEField().getName())) {
                        psDEMapDetail = new PSDEMapDetail();
                        psDEMapDetail.setPSDEMAPDETAILID(KeyValueHelper.genUniqueId((String)this.getPSDataEntity().getMajorPSDEField().getId(), (String)iPSDEField.getId()));
                        psDEMapDetail.setPSDEMAPDETAILNAME(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s ==> %2$s", (Object)this.getPSDataEntity().getMajorPSDEField().getName(), (Object)iPSDEField.getName()));
                        psDEMapDetail.setSRCTYPE("FIELD");
                        psDEMapDetail.setSRCPSDEFID(this.getPSDataEntity().getMajorPSDEField().getId());
                        psDEMapDetail.setSRCPSDEFNAME(this.getPSDataEntity().getMajorPSDEField().getName());
                        psDEMapDetail.setDSTFIELDNAME(iPSDEField.getName());
                        psDEMapDetailList2.add(psDEMapDetail);
                        continue;
                    }
                    IPSDEField srcPSDEField = this.getPSDataEntity().getPSDEField(iPSDEField.getName(), true);
                    if (srcPSDEField == null || srcPSDEMapDetailMap.containsKey(srcPSDEField.getName())) continue;
                    PSDEMapDetail psDEMapDetail2 = new PSDEMapDetail();
                    psDEMapDetail2.setPSDEMAPDETAILID(KeyValueHelper.genUniqueId((String)srcPSDEField.getId(), (String)iPSDEField.getId()));
                    psDEMapDetail2.setPSDEMAPDETAILNAME(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s ==> %2$s", (Object)srcPSDEField.getName(), (Object)iPSDEField.getName()));
                    psDEMapDetail2.setSRCTYPE("FIELD");
                    psDEMapDetail2.setSRCPSDEFID(srcPSDEField.getId());
                    psDEMapDetail2.setSRCPSDEFNAME(srcPSDEField.getName());
                    psDEMapDetail2.setDSTFIELDNAME(iPSDEField.getName());
                    psDEMapDetailList2.add(psDEMapDetail2);
                }
            }
            for (PSDEMapDetail psDEMapDetail : psDEMapDetailList2) {
                psDEMapDetail.set("AUTOMODEL", 1);
                PSDEMapDetailImpl iPSDEMapDetail = new PSDEMapDetailImpl();
                iPSDEMapDetail.init(this.getDAGlobalHelper(), this, psDEMapDetail);
                this.psDEMapDetailList.add(iPSDEMapDetail);
            }
        }
        Vector<PSDEMapAction> psDEMapActionList = new Vector<PSDEMapAction>();
        callResult = this.getPSModelHelper().getPSDEMapActions(this.getId(), psDEMapActionList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u6620\u5c04\u884c\u4e3a\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, String> psDEMapActionMap = new HashMap<String, String>();
        for (PSDEMapAction psDEMapAction : psDEMapActionList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEMapAction.getDSTPSDEACTIONID())) {
                psDEMapActionMap.put(psDEMapAction.getDSTPSDEACTIONID(), "");
            }
            if (!psDEMapAction.isVALIDFLAGNull() && !psDEMapAction.getVALIDFLAG()) continue;
            PSDEMapActionImpl iPSDEMapAction = new PSDEMapActionImpl();
            iPSDEMapAction.init(this.getDAGlobalHelper(), this, psDEMapAction);
            this.psDEMapActionList.add(iPSDEMapAction);
        }
        if (this.isAutoDEActionMap() && this.getDstPSDE() != null) {
            Vector<PSDEMapAction> psDEMapActionList2 = new Vector<PSDEMapAction>();
            Iterator<IPSDEAction> psDEActions = this.getDstPSDE().getAllPSDEActions();
            if (psDEActions != null) {
                while (psDEActions.hasNext()) {
                    IPSDEAction srcPSDEAction;
                    IPSDEAction iPSDEAction = psDEActions.next();
                    if (psDEMapActionMap.containsKey(iPSDEAction.getId()) || (srcPSDEAction = this.getPSDataEntity().getPSDEAction(iPSDEAction.getName(), true)) == null) continue;
                    PSDEMapAction psDEMapAction = new PSDEMapAction();
                    psDEMapAction.setPSDEMAPACTIONID(KeyValueHelper.genUniqueId((String)srcPSDEAction.getId(), (String)iPSDEAction.getId()));
                    psDEMapAction.setPSDEMAPACTIONNAME(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s ==> %2$s", (Object)srcPSDEAction.getName(), (Object)iPSDEAction.getName()));
                    psDEMapAction.setPSDEACTIONID(srcPSDEAction.getId());
                    psDEMapAction.setPSDEACTIONNAME(srcPSDEAction.getName());
                    psDEMapAction.setDSTPSDEACTIONID(iPSDEAction.getId());
                    psDEMapAction.setDSTPSDEACTIONNAME(iPSDEAction.getName());
                    psDEMapActionList2.add(psDEMapAction);
                }
            }
            for (PSDEMapAction psDEMapAction : psDEMapActionList2) {
                psDEMapAction.set("AUTOMODEL", 1);
                PSDEMapActionImpl iPSDEMapAction = new PSDEMapActionImpl();
                iPSDEMapAction.init(this.getDAGlobalHelper(), this, psDEMapAction);
                this.psDEMapActionList.add(iPSDEMapAction);
            }
        }
        if (this.getPSAppDataEntity() == null) {
            Vector<PSDEMapDataQuery> psDEMapDataQueryList = new Vector<PSDEMapDataQuery>();
            callResult = this.getPSModelHelper().getPSDEMapDataQueries(this.getId(), psDEMapDataQueryList);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u6620\u5c04\u67e5\u8be2\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, String> psDEMapDataQueryMap = new HashMap<String, String>();
            for (PSDEMapDataQuery psDEMapDataQuery : psDEMapDataQueryList) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEMapDataQuery.getDSTPSDEDATAQUERYID())) {
                    psDEMapDataQueryMap.put(psDEMapDataQuery.getDSTPSDEDATAQUERYID(), "");
                }
                if (!psDEMapDataQuery.isVALIDFLAGNull() && !psDEMapDataQuery.getVALIDFLAG()) continue;
                PSDEMapDataQueryImpl iPSDEMapDataQuery = new PSDEMapDataQueryImpl();
                iPSDEMapDataQuery.init(this.getDAGlobalHelper(), this, psDEMapDataQuery);
                this.psDEMapDataQueryList.add(iPSDEMapDataQuery);
            }
            if (this.isAutoDEDataQueryMap() && this.getDstPSDE() != null) {
                Vector<PSDEMapDataQuery> psDEMapDataQueryList2 = new Vector<PSDEMapDataQuery>();
                Iterator<IPSDEDataQuery> psDEDataQuerys = this.getDstPSDE().getAllPSDEDataQueries();
                if (psDEDataQuerys != null) {
                    while (psDEDataQuerys.hasNext()) {
                        IPSDEDataQuery srcPSDEDataQuery;
                        IPSDEDataQuery iPSDEDataQuery = psDEDataQuerys.next();
                        if (psDEMapDataQueryMap.containsKey(iPSDEDataQuery.getId()) || (srcPSDEDataQuery = this.getPSDataEntity().getPSDEDataQuery(iPSDEDataQuery.getName(), true)) == null) continue;
                        PSDEMapDataQuery psDEMapDataQuery = new PSDEMapDataQuery();
                        psDEMapDataQuery.setPSDEMAPDQID(KeyValueHelper.genUniqueId((String)srcPSDEDataQuery.getId(), (String)iPSDEDataQuery.getId()));
                        psDEMapDataQuery.setPSDEMAPDQNAME(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s ==> %2$s", (Object)srcPSDEDataQuery.getName(), (Object)iPSDEDataQuery.getName()));
                        psDEMapDataQuery.setPSDEDATAQUERYID(srcPSDEDataQuery.getId());
                        psDEMapDataQuery.setPSDEDATAQUERYNAME(srcPSDEDataQuery.getName());
                        psDEMapDataQuery.setDSTPSDEDATAQUERYID(iPSDEDataQuery.getId());
                        psDEMapDataQuery.setDSTPSDEDATAQUERYNAME(iPSDEDataQuery.getName());
                        psDEMapDataQueryList2.add(psDEMapDataQuery);
                    }
                }
                for (PSDEMapDataQuery psDEMapDataQuery : psDEMapDataQueryList2) {
                    psDEMapDataQuery.set("AUTOMODEL", 1);
                    PSDEMapDataQueryImpl iPSDEMapDataQuery = new PSDEMapDataQueryImpl();
                    iPSDEMapDataQuery.init(this.getDAGlobalHelper(), this, psDEMapDataQuery);
                    this.psDEMapDataQueryList.add(iPSDEMapDataQuery);
                }
            }
        }
        Vector<PSDEMapDataSet> psDEMapDataSetList = new Vector<PSDEMapDataSet>();
        callResult = this.getPSModelHelper().getPSDEMapDataSets(this.getId(), psDEMapDataSetList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u6620\u5c04\u6570\u636e\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, String> psDEMapDataSetMap = new HashMap<String, String>();
        for (PSDEMapDataSet psDEMapDataSet : psDEMapDataSetList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEMapDataSet.getDSTPSDEDATASETID())) {
                psDEMapDataSetMap.put(psDEMapDataSet.getDSTPSDEDATASETID(), "");
            }
            if (!psDEMapDataSet.isVALIDFLAGNull() && !psDEMapDataSet.getVALIDFLAG()) continue;
            PSDEMapDataSetImpl iPSDEMapDataSet = new PSDEMapDataSetImpl();
            iPSDEMapDataSet.init(this.getDAGlobalHelper(), this, psDEMapDataSet);
            this.psDEMapDataSetList.add(iPSDEMapDataSet);
        }
        if (this.isAutoDEDataSetMap() && this.getDstPSDE() != null) {
            Vector<PSDEMapDataSet> psDEMapDataSetList2 = new Vector<PSDEMapDataSet>();
            Iterator<IPSDEDataSet> psDEDataSets = this.getDstPSDE().getAllPSDEDataSets();
            if (psDEDataSets != null) {
                while (psDEDataSets.hasNext()) {
                    IPSDEDataSet srcPSDEDataSet;
                    IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                    if (psDEMapDataSetMap.containsKey(iPSDEDataSet.getId()) || (srcPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(iPSDEDataSet.getName(), true)) == null) continue;
                    PSDEMapDataSet psDEMapDataSet = new PSDEMapDataSet();
                    psDEMapDataSet.setPSDEMAPDSID(KeyValueHelper.genUniqueId((String)srcPSDEDataSet.getId(), (String)iPSDEDataSet.getId()));
                    psDEMapDataSet.setPSDEMAPDSNAME(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s ==> %2$s", (Object)srcPSDEDataSet.getName(), (Object)iPSDEDataSet.getName()));
                    psDEMapDataSet.setPSDEDATASETID(srcPSDEDataSet.getId());
                    psDEMapDataSet.setPSDEDATASETNAME(srcPSDEDataSet.getName());
                    psDEMapDataSet.setDSTPSDEDATASETID(iPSDEDataSet.getId());
                    psDEMapDataSet.setDSTPSDEDATASETNAME(iPSDEDataSet.getName());
                    psDEMapDataSetList2.add(psDEMapDataSet);
                }
            }
            for (PSDEMapDataSet psDEMapDataSet : psDEMapDataSetList2) {
                psDEMapDataSet.set("AUTOMODEL", 1);
                PSDEMapDataSetImpl iPSDEMapDataSet = new PSDEMapDataSetImpl();
                iPSDEMapDataSet.init(this.getDAGlobalHelper(), this, psDEMapDataSet);
                this.psDEMapDataSetList.add(iPSDEMapDataSet);
            }
        }
    }

    @Override
    public Iterator<IPSDEMapField> getPSDEMapDetails() {
        return PSDEMapImpl.<IPSDEMapField>upcastIterator(this.psDEMapDetailList.iterator());
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u5c5e\u6027\u96c6\u5408", child=true, ignorepf=true, group="\u903b\u8f91", order=230)
    public Iterator<IPSDEMapField> getPSDEMapFields() {
        if (this.getPSAppDataEntity() != null) {
            return null;
        }
        return PSDEMapImpl.<IPSDEMapField>upcastIterator(this.psDEMapDetailList.iterator());
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u884c\u4e3a\u96c6\u5408", child=true, ignorepf=true, group="\u903b\u8f91", order=232)
    public Iterator<IPSDEMapAction> getPSDEMapActions() {
        if (this.getPSAppDataEntity() != null) {
            return null;
        }
        return PSDEMapImpl.<IPSDEMapAction>upcastIterator(this.psDEMapActionList.iterator());
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u67e5\u8be2\u96c6\u5408", child=true, ignorepf=true, group="\u903b\u8f91", order=234)
    public Iterator<IPSDEMapDataQuery> getPSDEMapDataQueries() {
        if (this.getPSAppDataEntity() != null) {
            return null;
        }
        return this.psDEMapDataQueryList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u6570\u636e\u96c6\u96c6\u5408", child=true, ignorepf=true, group="\u903b\u8f91", order=236)
    public Iterator<IPSDEMapDataSet> getPSDEMapDataSets() {
        if (this.getPSAppDataEntity() != null) {
            return null;
        }
        return PSDEMapImpl.<IPSDEMapDataSet>upcastIterator(this.psDEMapDataSetList.iterator());
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u5c5e\u6027\u96c6\u5408", child=true, ignorepf=true, group="\u903b\u8f91", order=230)
    public Iterator<? extends IPSAppDEMapField> getPSAppDEMapFields() {
        if (this.getPSAppDataEntity() != null) {
            return this.psDEMapDetailList.iterator();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u884c\u4e3a\u96c6\u5408", child=true, ignorepf=true, group="\u903b\u8f91", order=232)
    public Iterator<? extends IPSAppDEMapAction> getPSAppDEMapActions() {
        if (this.getPSAppDataEntity() != null) {
            return this.psDEMapActionList.iterator();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u6570\u636e\u96c6\u96c6\u5408", child=true, ignorepf=true, group="\u903b\u8f91", order=236)
    public Iterator<? extends IPSAppDEMapDataSet> getPSAppDEMapDataSets() {
        if (this.getPSAppDataEntity() != null) {
            return this.psDEMapDataSetList.iterator();
        }
        return null;
    }

    private static <T> Iterator<T> upcastIterator(final Iterator<? extends T> source) {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return source.hasNext();
            }

            @Override
            public T next() {
                return source.next();
            }

            @Override
            public void remove() {
                source.remove();
            }
        };
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
    public String getMapTarget() {
        return this.psDEMap.getMAPTARGET();
    }

    @Override
    public String getPSSysRefId() {
        return this.psDEMap.getPSSYSREFID();
    }

    @Override
    public String getDstPSSysRefDEId() {
        return this.psDEMap.getDSTPSSYSREFDEID();
    }

    @Override
    public IPSSysRef getPSSysRef() {
        return this.iPSSysRef;
    }

    @Override
    public IPSSysRefDE getDstPSSysRefDE() {
        return this.dstPSSysRefDE;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psDEMap.getLOGICNAME();
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEMAP";
        }
        return "PSDEMAP";
    }

    @Override
    public boolean testMapGroup(String strGroup) {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, group="\u57fa\u672c", order=110, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDE() {
        return this.dstPSDataEntity;
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u5c5e\u6027\u6620\u5c04", dump=false)
    public boolean isAutoDEFieldMap() {
        return this.bAutoDEFieldMap;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u884c\u4e3a\u6620\u5c04", dump=false)
    public boolean isAutoDEActionMap() {
        return this.bAutoDEActionMap;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u6570\u636e\u67e5\u8be2\u6620\u5c04", dump=false)
    public boolean isAutoDEDataQueryMap() {
        return this.bAutoDEDataQueryMap;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u6570\u636e\u96c6\u5408\u6620\u5c04", dump=false)
    public boolean isAutoDEDataSetMap() {
        return this.bAutoDEDataSetMap;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDataEntity().getPSSystem());
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u52a8\u6001\u53c2\u6570", hideempty=true, ignorepf=true)
    public Properties getMapParams() {
        return this.mapParams;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u9ed8\u8ba4\u6620\u5c04\u6a21\u5f0f", hideempty=true, ignorepf=true, codelist="DEMapObjectMapMode", ignoredumpvalues="DEFAULT", dump=false)
    public String getMapMode() {
        return this.psDEMap.getMAPMODE();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true", fields={"VALIDFLAG"})
    public boolean isValid() {
        return this.bValid;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getLogicHolder() {
        return this.nLogicHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", ignoredumpvalues="true", ignorepf=true)
    public boolean isEnableBackend() {
        return (this.getLogicHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", ignoredumpvalues="false", ignorepf=true)
    public boolean isEnableFront() {
        return (this.getLogicHolder() & 2) == 2;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5e94\u7528\u5b9e\u4f53", dumpref=true)
    public IPSAppDataEntity getDstPSAppDataEntity() {
        if (this.getDstPSDE() == null) {
            return null;
        }
        if (this.getPSAppDataEntity() != null) {
            try {
                return this.getPSAppDataEntity().getPSApplication().getPSAppDataEntity(this.getDstPSDE(), true);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return null;
    }
}
