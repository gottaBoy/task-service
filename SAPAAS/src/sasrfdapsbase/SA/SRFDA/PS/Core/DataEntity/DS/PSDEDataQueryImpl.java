/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataQueryCode
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQFieldCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQMain;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryReturn;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQMainImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryCodeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryInputImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryReturnImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Data.PSDEDataQuery;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFDA.PS.Data.PSDEDataQueryJoin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryImpl
extends PSDataEntityObjectImpl
implements IPSDEDataQuery,
IPSRESTfulAPI,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEDataQueryImpl.class);
    protected PSDEDataQuery psDEDataQuery = null;
    protected Map<String, IPSDEDQEngine> psDEDQEngineMap = new LinkedHashMap<String, IPSDEDQEngine>();
    protected IPSDEDQMain iPSDEDQMain = null;
    protected PSDEDataQueryCodeGlobalModel psDEDataQueryCodeGlobalModel = new PSDEDataQueryCodeGlobalModel();
    private String strCodeName = "";
    private boolean bCustomCode = false;
    private boolean bPrivQuery = false;
    private int nExtendMode = 0;
    private String strLogicName = "";
    private boolean bDefaultMode = false;
    private int nViewLevel = -1;
    private boolean bPubFlag = false;
    private String strRequestPath = null;
    private String strRequestMethod = "POST";
    private boolean bQueryFromView = false;
    private ArrayList<IPSDEDQJoin> allPSDEDQJoinList = null;
    private ArrayList<IPSDEDQCondition> allPSDEDQConditionList = null;
    private ArrayList<IPSDEDQCondition> adPSDEDQConditionList = null;
    private int nOrderValue = 99999;
    private IPSDEFGroup iPSDEFGroup = null;
    private IPSDEDataQueryInput iPSDEDataQueryInput = null;
    private IPSDEDataQueryReturn iPSDEDataQueryReturn = null;
    private boolean bEnablePQL = false;
    private boolean bEnablePQLDefined = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity majorPSDataEntity, PSDEDataQuery psDEDataQuery) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(majorPSDataEntity);
            this.psDEDataQuery = psDEDataQuery;
            this.setId(this.psDEDataQuery.getPSDEDATAQUERYID());
            this.setName(this.psDEDataQuery.getPSDEDATAQUERYNAME());
            this.setPSObjectData(this.psDEDataQuery);
            this.psDEDataQueryCodeGlobalModel.Init(iDAGlobalHelper, this);
            this.strCodeName = this.psDEDataQuery.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEDataQuery.getPSDEDATAQUERYNAME().toLowerCase();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || majorPSDataEntity != null && majorPSDataEntity.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!this.psDEDataQuery.isCUSTOMMODENull()) {
                this.bCustomCode = this.psDEDataQuery.getCUSTOMMODE();
            }
            if (!this.psDEDataQuery.isPRIVMODENull()) {
                this.bPrivQuery = this.psDEDataQuery.getPRIVMODE();
            }
            if (!this.psDEDataQuery.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEDataQuery.getEXTENDMODE();
            }
            if (!this.psDEDataQuery.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psDEDataQuery.getDEFAULTMODE();
            }
            this.strLogicName = this.psDEDataQuery.getLOGICNAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLogicName)) {
                this.strLogicName = this.getName();
            }
            if (!this.psDEDataQuery.isVIEWCOLLEVELNull()) {
                this.nViewLevel = this.psDEDataQuery.getVIEWCOLLEVEL();
            }
            if (this.getViewLevel() == 100) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataQuery.getPSDEFGROUPID())) {
                    this.iPSDEFGroup = this.getPSDataEntity().getPSDEFGroup(this.psDEDataQuery.getPSDEFGROUPID());
                }
                if (this.getPSDEFGroup() == null) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u672a\u6307\u5b9a\u9009\u62e9\u5217\u76f8\u5e94\u7684\u5c5e\u6027\u7ec4\u5bf9\u8c61"));
                }
            }
            if (!this.psDEDataQuery.isQUERYVIEWFLAGNull()) {
                this.bQueryFromView = this.psDEDataQuery.getQUERYVIEWFLAG();
            }
            if (!this.psDEDataQuery.isPUBMODENull()) {
                this.bPubFlag = this.psDEDataQuery.getPUBMODE();
            }
            if (!this.psDEDataQuery.isORDERVALUENull() && this.psDEDataQuery.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDEDataQuery.getORDERVALUE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataQuery.getREQUESTPATH())) {
                this.strRequestPath = this.psDEDataQuery.getREQUESTPATH();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataQuery.getREQUESTMETHOD())) {
                this.strRequestMethod = this.psDEDataQuery.getREQUESTMETHOD();
            }
            if (!this.psDEDataQuery.isENABLEPQLNull()) {
                this.bEnablePQL = this.psDEDataQuery.getENABLEPQL();
                this.bEnablePQLDefined = true;
            } else {
                this.bEnablePQL = this.getPSDataEntity().isEnablePQL();
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
        super.onInit();
        this.onPreparePSDEDataQueryJoins();
        this.iPSDEDataQueryInput = this.createPSDEDataQueryInput();
        this.iPSDEDataQueryReturn = this.createPSDEDataQueryReturn();
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.createPSDEDataQueryInput() != null) {
            this.createPSDEDataQueryInput().check();
        }
        if (this.getPSDEDataQueryReturn() != null) {
            this.getPSDEDataQueryReturn().check();
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    protected void onPreparePSDEDataQueryJoins() throws Exception {
        this.iPSDEDQMain = null;
        this.allPSDEDQJoinList = null;
        this.allPSDEDQConditionList = null;
        Vector<PSDEDataQueryJoin> psDEDataQueryJoinList = new Vector<PSDEDataQueryJoin>();
        CallResult callResult = this.getPSModelHelper().getPSDEDataQueryJoins(this.getId(), psDEDataQueryJoinList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8fde\u63a5\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDEDataQueryCond> psDEDataQueryCondList = new Vector<PSDEDataQueryCond>();
        callResult = this.getPSModelHelper().getPSDEDataQueryConds(this.getId(), psDEDataQueryCondList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8fde\u63a5\u6761\u4ef6\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, PSDEDataQueryJoin> psDEDataQueryJoinMap = new LinkedHashMap<String, PSDEDataQueryJoin>();
        for (PSDEDataQueryJoin psDEDataQueryJoin : psDEDataQueryJoinList) {
            psDEDataQueryJoinMap.put(psDEDataQueryJoin.getPSDEDQJOINID(), psDEDataQueryJoin);
        }
        LinkedHashMap<String, PSDEDataQueryCond> psDEDataQueryCondMap = new LinkedHashMap<String, PSDEDataQueryCond>();
        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
            psDEDataQueryCondMap.put(psDEDataQueryCond.getPSDEDQCONDID(), psDEDataQueryCond);
        }
        boolean bAppendInheritTypeCond = false;
        if (this.getPSDataEntity().getInheritPSDataEntity() != null && this.getPSDataEntity().getInheritPSDataEntity().getIndexTypePSDEField() != null && this.getPSDataEntity().getInheritPSDataEntity().isEnableSQLStorage() && this.getPSDataEntity().isEnableSQLStorage() && SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSDataEntity().getTableName(), (String)this.getPSDataEntity().getInheritPSDataEntity().getTableName(), (boolean)true) == 0) {
            bAppendInheritTypeCond = true;
        }
        for (PSDEDataQueryJoin psDEDataQueryJoin : psDEDataQueryJoinList) {
            IPSDEField indexTypePSDEField;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEDataQueryJoin.getPPSDEDQJOINID())) {
                PSDEDataQueryJoin parentPSDEDataQueryJoin = (PSDEDataQueryJoin)((Object)psDEDataQueryJoinMap.get(psDEDataQueryJoin.getPPSDEDQJOINID()));
                if (parentPSDEDataQueryJoin != null) {
                    parentPSDEDataQueryJoin.getChildPSDEDataQueryJoins(true).add(psDEDataQueryJoin);
                    continue;
                }
                this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u8fde\u63a5[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDEDataQueryJoin.getPPSDEDQJOINID()));
                continue;
            }
            if (!bAppendInheritTypeCond || (indexTypePSDEField = this.getPSDataEntity().getPSDEField(this.getPSDataEntity().getInheritPSDataEntity().getIndexTypePSDEField().getName(), true)) == null) continue;
            PSDEDataQueryCond psDEDataQueryCond = new PSDEDataQueryCond();
            psDEDataQueryCond.setPSDEDQCONDID(String.valueOf(psDEDataQueryJoin.getPSDEDQJOINID()) + "_INHERIT");
            psDEDataQueryCond.setPSDEDQCONDNAME(SA.SRFramework.Utility.StringHelper.Format((String)"\u7ee7\u627f\u7c7b\u578b\u503c\u9ed8\u8ba4\u6761\u4ef6"));
            psDEDataQueryCond.setPSDEFID(indexTypePSDEField.getId());
            psDEDataQueryCond.setPSDEFNAME(indexTypePSDEField.getName());
            psDEDataQueryCond.setCONDTYPE("SINGLE");
            psDEDataQueryCond.setPSDBVALUEOPID("EQ");
            psDEDataQueryCond.setPSDBVALUEOPNAME("\u7b49\u4e8e(=)");
            psDEDataQueryCond.setCONDVALUE(this.getPSDataEntity().getPSDERInherit().getTypeValue());
            psDEDataQueryJoin.getPSDEDataQueryConds(true).add(psDEDataQueryCond);
        }
        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
            if (this.bEnablePQL) break;
            if (SA.SRFramework.Utility.StringHelper.Compare((String)"CUSTOM", (String)psDEDataQueryCond.getCONDTYPE(), (boolean)true) == 0) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)"PQL", (String)psDEDataQueryCond.getCUSTOMTYPE(), (boolean)true) != 0) continue;
                this.bEnablePQL = true;
                break;
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)"SINGLE", (String)psDEDataQueryCond.getCONDTYPE(), (boolean)true) != 0 || SA.SRFramework.Utility.StringHelper.Compare((String)"PQL", (String)psDEDataQueryCond.getPSVARTYPEID(), (boolean)true) != 0) continue;
            this.bEnablePQL = true;
            break;
        }
        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEDataQueryCond.getPPSDEDQCONDID())) continue;
            PSDEDataQueryCond parentPSDEDataQueryCond = (PSDEDataQueryCond)((Object)psDEDataQueryCondMap.get(psDEDataQueryCond.getPPSDEDQCONDID()));
            if (parentPSDEDataQueryCond != null) {
                parentPSDEDataQueryCond.getChildPSDEDataQueryConds(true).add(psDEDataQueryCond);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u67e5\u8be2\u6761\u4ef6[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDEDataQueryCond.getPPSDEDQCONDID()));
        }
        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEDataQueryCond.getPPSDEDQCONDID())) continue;
            PSDEDataQueryJoin psDEDataQueryJoin = (PSDEDataQueryJoin)((Object)psDEDataQueryJoinMap.get(psDEDataQueryCond.getPSDEDQJOINID()));
            if (psDEDataQueryJoin != null) {
                psDEDataQueryJoin.getPSDEDataQueryConds(true).add(psDEDataQueryCond);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u8fde\u63a5[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDEDataQueryCond.getPSDEDQJOINID()));
        }
        for (PSDEDataQueryJoin psDEDataQueryJoin : psDEDataQueryJoinList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEDataQueryJoin.getPPSDEDQJOINID())) continue;
            this.iPSDEDQMain = new PSDEDQMainImpl();
            this.iPSDEDQMain.init(this.getDAGlobalHelper(), this, null, psDEDataQueryJoin);
            break;
        }
        if (this.iPSDEDQMain == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2[%1$s][%2$s]\u6ca1\u6709\u5b9a\u4e49\u4e3b\u67e5\u8be2", (Object)this.getPSDataEntity().getName(), (Object)this.getName()));
        }
        this.fillAllPSDEDQjoin(this.iPSDEDQMain);
    }

    protected void fillAllPSDEDQjoin(IPSDEDQJoin iPSDEDQJoin) throws Exception {
        Iterator<IPSDEDQJoin> psDEDQJoins;
        if (this.allPSDEDQJoinList == null) {
            this.allPSDEDQJoinList = new ArrayList();
        }
        this.allPSDEDQJoinList.add(iPSDEDQJoin);
        if (iPSDEDQJoin.getPSDEDQGroupCondition() != null) {
            this.fillAllPSDEDQCondition(iPSDEDQJoin.getPSDEDQGroupCondition());
        }
        if ((psDEDQJoins = iPSDEDQJoin.getChildPSDEDQJoins()) != null) {
            while (psDEDQJoins.hasNext()) {
                this.fillAllPSDEDQjoin(psDEDQJoins.next());
            }
        }
    }

    protected void fillAllPSDEDQCondition(IPSDEDQCondition iPSDEDQCondition) throws Exception {
        IPSDEDQGroupCondition iPSDEDQGroupCondition;
        Iterator<IPSDEDQCondition> psDEDQConditions;
        IPSDEDQFieldCondition iPSDEDQFieldCondition;
        if (this.allPSDEDQConditionList == null) {
            this.allPSDEDQConditionList = new ArrayList();
        }
        this.allPSDEDQConditionList.add(iPSDEDQCondition);
        if (iPSDEDQCondition instanceof IPSDEDQFieldCondition && SA.SRFramework.Utility.StringHelper.Compare((String)(iPSDEDQFieldCondition = (IPSDEDQFieldCondition)iPSDEDQCondition).getPSVARTypeId(), (String)"DATACONTEXT", (boolean)false) == 0) {
            if (this.adPSDEDQConditionList == null) {
                this.adPSDEDQConditionList = new ArrayList();
            }
            this.adPSDEDQConditionList.add(iPSDEDQFieldCondition);
        }
        if (iPSDEDQCondition instanceof IPSDEDQGroupCondition && (psDEDQConditions = (iPSDEDQGroupCondition = (IPSDEDQGroupCondition)iPSDEDQCondition).getPSDEDQConditions()) != null) {
            while (psDEDQConditions.hasNext()) {
                this.fillAllPSDEDQCondition(psDEDQConditions.next());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u4e3b\u8868\u5bf9\u8c61", child=true, ignorepf=true)
    public IPSDEDQMain getPSDEDQMain() {
        return this.iPSDEDQMain;
    }

    @Override
    public IPSDEDataQueryCode getPSDEDataQueryCode(String strDBType) throws Exception {
        String strPSDEDQCodeId = Helper.GenUniqueId((String)this.getId(), (String)strDBType);
        return (IPSDEDataQueryCode)this.psDEDataQueryCodeGlobalModel.FindModelHelper(strPSDEDQCodeId);
    }

    @Override
    public IPSDEDataQueryCode getPSDEDataQueryCode(String strDBType, boolean bTryMode) throws Exception {
        String strPSDEDQCodeId = Helper.GenUniqueId((String)this.getId(), (String)strDBType);
        return (IPSDEDataQueryCode)this.psDEDataQueryCodeGlobalModel.FindModelHelper(strPSDEDQCodeId, bTryMode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDEDQEngine getPSDEDQEngine(String strDBType) throws Exception {
        IPSDEDQEngine iPSDEDQEngine;
        Map<String, IPSDEDQEngine> map = this.psDEDQEngineMap;
        synchronized (map) {
            iPSDEDQEngine = this.psDEDQEngineMap.get(strDBType);
            if (iPSDEDQEngine != null) {
                return iPSDEDQEngine;
            }
        }
        try {
            IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(strDBType);
            iPSDEDQEngine = iPSDBType.createPSDEDQEngine();
            iPSDEDQEngine.init(this.getDAGlobalHelper(), iPSDBType, this.getPSDataEntity());
            iPSDEDQEngine.compile(this.getPSDEDQMain());
            Map<String, IPSDEDQEngine> map2 = this.psDEDQEngineMap;
            synchronized (map2) {
                this.psDEDQEngineMap.put(strDBType, iPSDEDQEngine);
            }
            return iPSDEDQEngine;
        }
        catch (Exception ex) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u7f16\u8bd1\u5b9e\u4f53\u6570\u636e\u67e5\u8be2[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getFullModelName(), (Object)ex.getMessage()), ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u4ee3\u7801\u96c6\u5408", child=true, dumpref=true, rtdump=2, ignorepf=true, dynamodelmode=4, group="\u903b\u8f91", order=220)
    public Iterator<IPSDEDataQueryCode> getAllPSDEDataQueryCodes() throws Exception {
        return this.psDEDataQueryCodeGlobalModel.getAllModelHelpers();
    }

    public IDEDataQueryCode getDEDataQueryCode(String strDBType) throws Exception {
        return this.getPSDEDataQueryCode(strDBType);
    }

    @Override
    public void loadAll() throws Exception {
        Iterator<IPSDEDataQueryCode> psDEDataQueryCodes = this.getAllPSDEDataQueryCodes();
        while (psDEDataQueryCodes.hasNext()) {
            IPSDEDataQueryCode iPSDEDataQueryCode = psDEDataQueryCodes.next();
            iPSDEDataQueryCode.loadAll();
        }
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u67e5\u8be2", ignoredumpvalues="false", fields={"CUSTOMMODE"})
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u6743\u9650\u4f7f\u7528\u67e5\u8be2", ignoredumpvalues="false")
    public boolean isPrivQuery() {
        return this.bPrivQuery;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u6269\u5c55", codelist="DEExtendMode", ignoredumpvalues="0")
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    public String getModelType() {
        return "PSDEDATAQUERY";
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u9ed8\u8ba4\u67e5\u8be2", ignoredumpvalues="false", fields={"DEFAULTMODE"})
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u9009\u62e9\u5217\u7ea7\u522b", codelist="DEDataQueryColLevel3", ignoredumpvalues="-1", group="\u57fa\u672c", order=125, fields={"VIEWCOLLEVEL"})
    public int getViewLevel() {
        return this.nViewLevel;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53d1\u5e03\u670d\u52a1", ignoredumpvalues="false")
    public boolean isPubServiceDefault() {
        return this.bPubFlag;
    }

    @Override
    public IPSRESTfulAPI getPSRESTfulAPI() {
        return this;
    }

    @Override
    public String getRequestPath() {
        return this.strRequestPath;
    }

    @Override
    public String getRequestMethod() {
        return this.strRequestMethod;
    }

    @Override
    public Iterator<IPSDEDQJoin> getAllPSDEDQJoins() {
        if (this.allPSDEDQJoinList == null || this.allPSDEDQJoinList.size() == 0) {
            return null;
        }
        return this.allPSDEDQJoinList.iterator();
    }

    @Override
    public Iterator<IPSDEDQCondition> getAllPSDEDQConditions() {
        if (this.allPSDEDQConditionList == null || this.allPSDEDQConditionList.size() == 0) {
            return null;
        }
        return this.allPSDEDQConditionList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u89c6\u56fe\u67e5\u8be2", ignoredumpvalues="false", fields={"QUERYVIEWFLAG"})
    public boolean isQueryFromView() {
        return this.bQueryFromView;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u6570\u636e\u6761\u4ef6", outputdoc="false")
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() {
        if (this.adPSDEDQConditionList == null || this.adPSDEDQConditionList.size() == 0) {
            return null;
        }
        return this.adPSDEDQConditionList.iterator();
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDEFGROUPID"})
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u7c7b\u578b", codelist="DEFGroupType", doc="\u6765\u81ea{@link #getPSDEFGroup}\u7684\u7c7b\u578b")
    public String getDEFGroupType() {
        if (this.getPSDEFGroup() != null) {
            return this.getPSDEFGroup().getGroupType();
        }
        return null;
    }

    protected IPSDEDataQueryInput createPSDEDataQueryInput() throws Exception {
        PSDEDataQueryInputImpl psDEDataQueryInputImpl = new PSDEDataQueryInputImpl();
        psDEDataQueryInputImpl.init(this.getDAGlobalHelper(), this);
        return psDEDataQueryInputImpl;
    }

    protected IPSDEDataQueryReturn createPSDEDataQueryReturn() throws Exception {
        PSDEDataQueryReturnImpl psDEDataQueryReturnImpl = new PSDEDataQueryReturnImpl();
        psDEDataQueryReturnImpl.init(this.getDAGlobalHelper(), this);
        return psDEDataQueryReturnImpl;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8f93\u5165\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u903b\u8f91", order=215)
    public IPSDEDataQueryInput getPSDEDataQueryInput() {
        return this.iPSDEDataQueryInput;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8fd4\u56de\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u903b\u8f91", order=216)
    public IPSDEDataQueryReturn getPSDEDataQueryReturn() {
        return this.iPSDEDataQueryReturn;
    }

    @Override
    public int getOption() {
        return 0;
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528PQL", ignoredumpvalues="false", ignorepf=true, fields={"ENABLEPQL"})
    public boolean isEnablePQL() {
        return this.bEnablePQL;
    }
}

