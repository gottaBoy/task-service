/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldRuntime;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethod;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIDEFieldImpl;
import SA.SRFDA.PS.Data.PSSubSysSADE;
import SA.SRFDA.PS.Data.PSSubSysSADEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSubSysServiceAPIDEImpl
extends PSObjectImpl
implements IPSSubSysServiceAPIDE,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDEImpl.class);
    protected PSSubSysSADE psSubSysSADE = null;
    private IPSSubSysServiceAPI iPSSubSysServiceAPI = null;
    private ArrayList<IPSSubSysServiceAPIDERS> majorPSSubSysServiceAPIDERSList = null;
    private ArrayList<IPSSubSysServiceAPIDERS> minorPSSubSysServiceAPIDERSList = null;
    protected ArrayList<IPSSubSysServiceAPIDEField> psSubSysServiceAPIDEFieldList = new ArrayList();
    protected Map<String, IPSSubSysServiceAPIDEField> psSubSysServiceAPIDEFieldMap = new LinkedHashMap<String, IPSSubSysServiceAPIDEField>();
    private Map<Integer, ArrayList<IPSSubSysServiceAPIDERS>> psSubSysSADERSPathMap = null;
    private List<IPSSubSysServiceAPIDEMethod> psSubSysServiceAPIDEMethodList = null;
    private int nAPIMode = 1;
    private IPSSubSysServiceAPIDEField keyPSSubSysServiceAPIDEField = null;
    private IPSSubSysServiceAPIDEField majorPSSubSysServiceAPIDEField = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private String strCodeName = null;
    private String strServiceParam = null;
    private String strServiceParam2 = null;
    private Properties serviceParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPI iPSSubSysServiceAPI, PSSubSysSADE psSubSysSADE) throws Exception {
        try {
            IPSDataEntity iPSDataEntity;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSubSysServiceAPI(iPSSubSysServiceAPI);
            this.psSubSysSADE = psSubSysSADE;
            this.setId(this.psSubSysSADE.getPSSUBSYSSADEID());
            this.setName(this.psSubSysSADE.getPSSUBSYSSADENAME());
            this.setPSObjectData(this.psSubSysSADE);
            this.strCodeName = this.psSubSysSADE.getCODENAME();
            if (this.isAutoModel() && (iPSDataEntity = this.getPSSubSysServiceAPI().getPSSystem().getPSDataEntity2(this.getId())) != null) {
                this.strCodeName = this.getPSSubSysServiceAPI().getAPICodeName(null, iPSDataEntity.getServiceCodeName(), null);
            }
            if (!this.psSubSysSADE.isMAJORFLAGNull()) {
                this.nAPIMode = this.psSubSysSADE.getMAJORFLAG();
            }
            this.strServiceParam = this.psSubSysSADE.getSERVICEPARAM();
            this.strServiceParam2 = this.psSubSysSADE.getSERVICEPARAM2();
            this.serviceParams = PropertiesHelper.load((String)this.psSubSysSADE.getSERVICEPARAMS());
            if (!StringHelper.IsNullOrEmpty((String)this.psSubSysSADE.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSubSysServiceAPI().getPSSystem().getPSSysSFPlugin(this.psSubSysSADE.getPSSYSSFPLUGINID());
            } else if (!StringHelper.IsNullOrEmpty((String)iPSSubSysServiceAPI.getDEPSSysSFPluginId())) {
                this.iPSSysSFPlugin = this.getPSSubSysServiceAPI().getPSSystem().getPSSysSFPlugin(iPSSubSysServiceAPI.getDEPSSysSFPluginId());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSubSysServiceAPI().getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSubSysServiceAPI().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.Format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.Format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSSubSysServiceAPIDEFields();
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSubSysSADERSPathCount();
        int nCount = 0;
        Iterator<? extends IPSSubSysServiceAPIDEMethod> psSubSysServiceAPIDEMethods = this.getPSSubSysServiceAPIDEMethods();
        if (psSubSysServiceAPIDEMethods != null) {
            while (psSubSysServiceAPIDEMethods.hasNext()) {
                IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = psSubSysServiceAPIDEMethods.next();
                nCount += iPSSubSysServiceAPIDEMethod.check();
            }
        }
        return nCount += super.onCheck();
    }

    protected void onPreparePSSubSysServiceAPIDEFields() throws Exception {
        CallResult callResult;
        this.psSubSysServiceAPIDEFieldList.clear();
        this.psSubSysServiceAPIDEFieldMap.clear();
        Vector<PSSubSysSADEField> psSubSysSADEFieldList = new Vector<PSSubSysSADEField>();
        if (!this.isAutoModel() && (callResult = this.getPSModelHelper().getPSSubSysSADEFields(this.getId(), psSubSysSADEFieldList)).isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psSubSysSADEFieldList.size() == 0) {
            Iterator<IPSDEField> psDEFields;
            IPSDataEntity iPSDataEntity = null;
            if (this.isAutoModel()) {
                iPSDataEntity = this.getPSSubSysServiceAPI().getPSSystem().getPSDataEntity2(this.getId());
            } else if (StringHelper.Compare((String)this.getPSSystemUtil().getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
                Iterator<IPSDataEntity> psDataEntities = this.getPSSubSysServiceAPI().getPSSystem().getAllPSDataEntities();
                while (psDataEntities.hasNext()) {
                    IPSDataEntity iPSDataEntity2 = psDataEntities.next();
                    if (StringHelper.Compare((String)iPSDataEntity2.getPSSubSysSADEId(), (String)this.getId(), (boolean)false) != 0) continue;
                    iPSDataEntity = iPSDataEntity2;
                    break;
                }
                if (iPSDataEntity == null) {
                    iPSDataEntity = this.getPSSubSysServiceAPI().getPSSystem().getPSDataEntity2(this.getName(), true);
                }
            }
            if (iPSDataEntity != null && (psDEFields = iPSDataEntity.getAllPSDEFields()) != null) {
                while (psDEFields.hasNext()) {
                    IPSDEField iPSDEField = psDEFields.next();
                    PSSubSysSADEField psSubSysSADEField = new PSSubSysSADEField();
                    psSubSysSADEField.setPSSUBSYSSADEFIELDID(iPSDEField.getId());
                    psSubSysSADEField.setPSSUBSYSSADEFIELDNAME(iPSDEField.getName());
                    psSubSysSADEField.setALLOWEMPTY(iPSDEField.isAllowEmpty());
                    psSubSysSADEField.setCODENAME(iPSDEField.getServiceCodeName());
                    psSubSysSADEField.setSTDDATATYPE(iPSDEField.getStdDataType());
                    psSubSysSADEField.setLENGTH(iPSDEField.getLength());
                    psSubSysSADEField.setPRECISION2(iPSDEField.getPrecision());
                    if (iPSDEField.getPSCodeList() != null) {
                        psSubSysSADEField.setPSCODELISTID(iPSDEField.getPSCodeList().getId());
                    }
                    psSubSysSADEField.setLOGICNAME(iPSDEField.getLogicName());
                    psSubSysSADEField.setMAJORFIELD(iPSDEField.isMajorDEField());
                    psSubSysSADEField.setPKEY(iPSDEField.isKeyDEField() ? 1 : 0);
                    psSubSysSADEField.setORDERVALUE(iPSDEField.getOrderValue());
                    psSubSysSADEField.setVALIDFLAG(true);
                    psSubSysSADEField.setPSSUBSYSSADEID(this.getId());
                    psSubSysSADEField.setPSSUBSYSSADENAME(this.getName());
                    psSubSysSADEField.set("AUTOMODEL", 1);
                    PSSubSysServiceAPIDEFieldImpl psSubSysServiceAPIDEFieldImpl = new PSSubSysServiceAPIDEFieldImpl();
                    psSubSysServiceAPIDEFieldImpl.init(this.getDAGlobalHelper(), this, psSubSysSADEField);
                    this.psSubSysServiceAPIDEFieldList.add(psSubSysServiceAPIDEFieldImpl);
                    if (!(iPSDEField instanceof IPSDEFieldRuntime)) continue;
                    ((IPSDEFieldRuntime)((Object)iPSDEField)).setPSSubSysServiceAPIDEField(psSubSysServiceAPIDEFieldImpl);
                }
            }
        } else {
            for (PSSubSysSADEField psSubSysSADEField : psSubSysSADEFieldList) {
                PSSubSysServiceAPIDEFieldImpl psSubSysServiceAPIDEFieldImpl = new PSSubSysServiceAPIDEFieldImpl();
                psSubSysServiceAPIDEFieldImpl.init(this.getDAGlobalHelper(), this, psSubSysSADEField);
                this.psSubSysServiceAPIDEFieldList.add(psSubSysServiceAPIDEFieldImpl);
            }
        }
        for (IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField : this.psSubSysServiceAPIDEFieldList) {
            this.psSubSysServiceAPIDEFieldMap.put(iPSSubSysServiceAPIDEField.getId(), iPSSubSysServiceAPIDEField);
            this.psSubSysServiceAPIDEFieldMap.put(iPSSubSysServiceAPIDEField.getName(), iPSSubSysServiceAPIDEField);
            if (iPSSubSysServiceAPIDEField.isKeyDEField()) {
                this.keyPSSubSysServiceAPIDEField = iPSSubSysServiceAPIDEField;
            }
            if (!iPSSubSysServiceAPIDEField.isMajorDEField()) continue;
            this.majorPSSubSysServiceAPIDEField = iPSSubSysServiceAPIDEField;
        }
    }

    protected void setPSSubSysServiceAPI(IPSSubSysServiceAPI iPSSubSysServiceAPI) {
        this.iPSSubSysServiceAPI = iPSSubSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3")
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() {
        return this.iPSSubSysServiceAPI;
    }

    @Override
    public String getModelType() {
        return "PSSUBSYSSADE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSSubSysServiceAPI().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSubSysServiceAPI().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u63a5\u53e3", ignoredumpvalues="false", doc="\u7b49\u540c{@link #getAPIMode}\u8fd4\u56de\u4e3b\u63a5\u53e3(1)")
    public boolean isMajor() {
        return this.nAPIMode == 1;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSubSysServiceAPI().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02\uff08\u590d\u6570\uff09", hideempty2=true)
    public String getCodeName2() {
        return this.psSubSysSADE.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psSubSysSADE.getLOGICNAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysServiceAPI().getPSSysModelInstId();
    }

    @Override
    public Iterator<IPSSubSysServiceAPIDERS> getPSSubSysServiceAPIDERSs(boolean bMajor) {
        Iterator<IPSSubSysServiceAPIDERS> psSubSysSADERSs;
        block10: {
            psSubSysSADERSs = this.getPSSubSysServiceAPI().getAllPSSubSysServiceAPIDERSs();
            if (psSubSysSADERSs != null) break block10;
            return null;
        }
        try {
            if (bMajor) {
                if (this.majorPSSubSysServiceAPIDERSList == null) {
                    ArrayList<IPSSubSysServiceAPIDERS> list = new ArrayList<IPSSubSysServiceAPIDERS>();
                    while (psSubSysSADERSs.hasNext()) {
                        IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = psSubSysSADERSs.next();
                        if (StringHelper.Compare((String)iPSSubSysServiceAPIDERS.getPPSSubSysSADEId(), (String)this.getId(), (boolean)true) != 0) continue;
                        list.add(iPSSubSysServiceAPIDERS);
                    }
                    if (this.majorPSSubSysServiceAPIDERSList == null) {
                        this.majorPSSubSysServiceAPIDERSList = list;
                    }
                }
                return this.majorPSSubSysServiceAPIDERSList.iterator();
            }
            if (this.minorPSSubSysServiceAPIDERSList == null) {
                ArrayList<IPSSubSysServiceAPIDERS> list = new ArrayList<IPSSubSysServiceAPIDERS>();
                while (psSubSysSADERSs.hasNext()) {
                    IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = psSubSysSADERSs.next();
                    if (StringHelper.Compare((String)iPSSubSysServiceAPIDERS.getCPSSubSysSADEId(), (String)this.getId(), (boolean)true) != 0) continue;
                    list.add(iPSSubSysServiceAPIDERS);
                }
                if (this.minorPSSubSysServiceAPIDERSList == null) {
                    this.minorPSSubSysServiceAPIDERSList = list;
                }
            }
            return this.minorPSSubSysServiceAPIDERSList.iterator();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u96c6\u5408")
    public Iterator<IPSSubSysServiceAPIDERS> getPSSubSysServiceAPIDERSs() {
        return this.getPSSubSysServiceAPIDERSs(true);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<IPSSubSysServiceAPIDEField> getPSSubSysServiceAPIDEFields() {
        return this.psSubSysServiceAPIDEFieldList.iterator();
    }

    @Override
    public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField(String strPSDEFieldId) throws Exception {
        return this.getPSSubSysServiceAPIDEField(strPSDEFieldId, false);
    }

    @Override
    public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField(String strPSDEFieldId, boolean bTryMode) throws Exception {
        IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField = this.psSubSysServiceAPIDEFieldMap.get(strPSDEFieldId);
        if (iPSSubSysServiceAPIDEField != null || bTryMode) {
            return iPSSubSysServiceAPIDEField;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5916\u90e8\u63a5\u53e3\u5c5e\u6027[%1$s]", (Object)strPSDEFieldId));
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84\u6570\u91cf", dump=false)
    public int getPSSubSysSADERSPathCount() throws Exception {
        this.preparePSSubSysSADERSPaths();
        if (this.psSubSysSADERSPathMap == null) {
            return 0;
        }
        return this.psSubSysSADERSPathMap.size();
    }

    @Override
    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath(int nPathIndex) throws Exception {
        this.preparePSSubSysSADERSPaths();
        if (this.psSubSysSADERSPathMap == null) {
            return null;
        }
        ArrayList<IPSSubSysServiceAPIDERS> list = this.psSubSysSADERSPathMap.get(nPathIndex);
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    protected synchronized void preparePSSubSysSADERSPaths() throws Exception {
        var1_1 = this;
        synchronized (var1_1) {
            if (this.psSubSysSADERSPathMap != null) {
                return;
            }
            this.psSubSysSADERSPathMap = new LinkedHashMap<Integer, ArrayList<IPSSubSysServiceAPIDERS>>();
            if (this.isNested()) {
                return;
            }
            psSubSysSADERSs = this.getPSSubSysServiceAPIDERSs(false);
            if (psSubSysSADERSs != null) ** GOTO lbl19
            return;
lbl-1000:
            // 1 sources

            {
                iPSSubSysSADERS = psSubSysSADERSs.next();
                if (StringHelper.Compare((String)iPSSubSysSADERS.getPPSSubSysSADEId(), (String)iPSSubSysSADERS.getCPSSubSysSADEId(), (boolean)false) == 0) continue;
                list = new ArrayList<IPSSubSysServiceAPIDERS>();
                nIndex = this.psSubSysSADERSPathMap.size();
                this.psSubSysSADERSPathMap.put(nIndex, list);
                this.fillPSSubSysSADERSPath(iPSSubSysSADERS, list);
lbl19:
                // 3 sources

                ** while (psSubSysSADERSs.hasNext())
            }
lbl20:
            // 1 sources

            if (this.psSubSysSADERSPathMap.size() > 1) {
                list = new ArrayList<ArrayList<IPSSubSysServiceAPIDERS>>();
                list.addAll(this.psSubSysSADERSPathMap.values());
                Collections.sort(list, new Comparator<ArrayList<IPSSubSysServiceAPIDERS>>(){

                    @Override
                    public int compare(ArrayList<IPSSubSysServiceAPIDERS> arg0, ArrayList<IPSSubSysServiceAPIDERS> arg1) {
                        if (arg0.size() != arg1.size()) {
                            return Integer.valueOf(arg0.size()).compareTo(arg1.size());
                        }
                        int i = 0;
                        while (i < arg0.size()) {
                            int nRet = arg0.get(i).getName().compareTo(arg1.get(i).getName());
                            if (nRet != 0) {
                                return nRet;
                            }
                            ++i;
                        }
                        return 0;
                    }
                });
                this.psSubSysSADERSPathMap.clear();
                i = 0;
                while (i < list.size()) {
                    this.psSubSysSADERSPathMap.put(i, (ArrayList)list.get(i));
                    ++i;
                }
            }
        }
    }

    protected synchronized void fillPSSubSysSADERSPath(IPSSubSysServiceAPIDERS iPSSubSysSADERS, ArrayList<IPSSubSysServiceAPIDERS> list) throws Exception {
        for (IPSSubSysServiceAPIDERS tempPSSubSysSADERS : list) {
            if (StringHelper.Compare((String)iPSSubSysSADERS.getId(), (String)tempPSSubSysSADERS.getId(), (boolean)false) != 0) continue;
            throw new Exception(StringHelper.Format((String)"\u5b50\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53[%1$s]\u5b58\u5728\u9012\u5f52\u5f15\u7528\u5173\u7cfb[%2$s]", (Object)this.getName(), (Object)iPSSubSysSADERS.getName()));
        }
        list.add(0, iPSSubSysSADERS);
        Iterator<IPSSubSysServiceAPIDERS> majorList = iPSSubSysSADERS.getMajorPSSubSysServiceAPIDE().getPSSubSysServiceAPIDERSs(false);
        if (majorList == null) {
            return;
        }
        ArrayList<IPSSubSysServiceAPIDERS> srcList = new ArrayList<IPSSubSysServiceAPIDERS>();
        srcList.addAll(list);
        int nIndex = 0;
        while (majorList.hasNext()) {
            int nIndex2;
            ArrayList<IPSSubSysServiceAPIDERS> list2;
            IPSSubSysServiceAPIDERS tempPSSubSysSADERS = majorList.next();
            if (StringHelper.Compare((String)tempPSSubSysSADERS.getPPSSubSysSADEId(), (String)tempPSSubSysSADERS.getCPSSubSysSADEId(), (boolean)false) == 0) continue;
            if (nIndex == 0) {
                if (iPSSubSysSADERS.getMajorPSSubSysServiceAPIDE().isMajor()) {
                    list2 = new ArrayList();
                    list2.addAll(srcList);
                    nIndex2 = this.psSubSysSADERSPathMap.size();
                    this.psSubSysSADERSPathMap.put(nIndex2, list2);
                }
                this.fillPSSubSysSADERSPath(tempPSSubSysSADERS, list);
            } else {
                list2 = new ArrayList<IPSSubSysServiceAPIDERS>();
                list2.addAll(srcList);
                nIndex2 = this.psSubSysSADERSPathMap.size();
                this.psSubSysSADERSPathMap.put(nIndex2, list2);
                this.fillPSSubSysSADERSPath(tempPSSubSysSADERS, list2);
            }
            ++nIndex;
        }
    }

    @Override
    public IPSSubSysServiceAPIDERS getPSSubSysSADERSPathFirst(int nPathIndex) throws Exception {
        this.preparePSSubSysSADERSPaths();
        if (this.psSubSysSADERSPathMap == null) {
            return null;
        }
        ArrayList<IPSSubSysServiceAPIDERS> list = this.psSubSysSADERSPathMap.get(nPathIndex);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public IPSSubSysServiceAPIDERS getPSSubSysSADERSPathLast(int nPathIndex) throws Exception {
        this.preparePSSubSysSADERSPaths();
        if (this.psSubSysSADERSPathMap == null) {
            return null;
        }
        ArrayList<IPSSubSysServiceAPIDERS> list = this.psSubSysSADERSPathMap.get(nPathIndex);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[0]", hideempty=true, dump=false, outputdoc="false")
    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath0() throws Exception {
        return this.getPSSubSysSADERSPath(0);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[1]", hideempty=true, dump=false, outputdoc="false")
    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath1() throws Exception {
        return this.getPSSubSysSADERSPath(1);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[2]", hideempty=true, dump=false, outputdoc="false")
    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath2() throws Exception {
        return this.getPSSubSysSADERSPath(2);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[3]", hideempty=true, dump=false, outputdoc="false")
    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath3() throws Exception {
        return this.getPSSubSysSADERSPath(3);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[4]", hideempty=true, dump=false, outputdoc="false")
    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath4() throws Exception {
        return this.getPSSubSysSADERSPath(4);
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u96c6\u5408", child=true)
    public Iterator<? extends IPSSubSysServiceAPIDEMethod> getPSSubSysServiceAPIDEMethods() throws Exception {
        if (this.psSubSysServiceAPIDEMethodList != null) {
            return this.psSubSysServiceAPIDEMethodList.iterator();
        }
        ArrayList<IPSSubSysServiceAPIDEMethod> list = new ArrayList<IPSSubSysServiceAPIDEMethod>();
        Iterator<IPSSubSysServiceAPIMethod> psSubSysServiceAPIMethods = this.getPSSubSysServiceAPI().getAllPSSubSysServiceAPIMethods();
        if (psSubSysServiceAPIMethods != null) {
            while (psSubSysServiceAPIMethods.hasNext()) {
                IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod;
                IPSSubSysServiceAPIMethod iPSSubSysServiceAPIMethod = psSubSysServiceAPIMethods.next();
                if (!(iPSSubSysServiceAPIMethod instanceof IPSSubSysServiceAPIDEMethod) || (iPSSubSysServiceAPIDEMethod = (IPSSubSysServiceAPIDEMethod)iPSSubSysServiceAPIMethod).getPSSubSysServiceAPIDE() == null || StringHelper.Compare((String)iPSSubSysServiceAPIDEMethod.getPSSubSysServiceAPIDE().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                list.add(iPSSubSysServiceAPIDEMethod);
            }
        }
        if (this.psSubSysServiceAPIDEMethodList == null) {
            this.psSubSysServiceAPIDEMethodList = list;
        }
        return this.psSubSysServiceAPIDEMethodList.iterator();
    }

    @Override
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod(String strPSSubSysServiceAPIDEMethodId, boolean bTryMode) throws Exception {
        IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = null;
        Iterator<? extends IPSSubSysServiceAPIDEMethod> methods = this.getPSSubSysServiceAPIDEMethods();
        if (methods != null) {
            while (methods.hasNext()) {
                IPSSubSysServiceAPIDEMethod srcPSSubSysServiceAPIDEMethod = methods.next();
                if (StringHelper.Compare((String)srcPSSubSysServiceAPIDEMethod.getId(), (String)strPSSubSysServiceAPIDEMethodId, (boolean)false) != 0) continue;
                iPSSubSysServiceAPIDEMethod = srcPSSubSysServiceAPIDEMethod;
                break;
            }
        }
        if (iPSSubSysServiceAPIDEMethod != null || bTryMode) {
            return iPSSubSysServiceAPIDEMethod;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf\u5b9e\u4f53\u65b9\u6cd5[%1$s]", (Object)strPSSubSysServiceAPIDEMethodId));
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u6a21\u5f0f", codelist="DESAMode", fields={"MAJORFLAG"})
    public int getAPIMode() {
        return this.nAPIMode;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6210\u5458", ignoredumpvalues="false", doc="\u7b49\u540c{@link #getAPIMode}\u8fd4\u56de\u6570\u636e\u4f20\u8f93\u5bf9\u8c61\uff08DTO\uff09\u5d4c\u5957\u6210\u5458(9)")
    public boolean isNested() {
        return this.nAPIMode == 9;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6807\u8bb0", hideempty2=true, fields={"DETAG"})
    public String getDETag() {
        return this.psSubSysSADE.getDETAG();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6807\u8bb02", hideempty2=true, fields={"DETAG2"})
    public String getDETag2() {
        return this.psSubSysSADE.getDETAG2();
    }

    @Override
    public IPSSubSysServiceAPIDEField getKeyPSSubSysServiceAPIDEField() {
        return this.keyPSSubSysServiceAPIDEField;
    }

    @Override
    public IPSSubSysServiceAPIDEField getMajorPSSubSysServiceAPIDEField() {
        return this.majorPSSubSysServiceAPIDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027")
    public IPSSubSysServiceAPIDEField getKeyDEField() {
        return this.getKeyPSSubSysServiceAPIDEField();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u4fe1\u606f\u5c5e\u6027")
    public IPSSubSysServiceAPIDEField getMajorDEField() {
        return this.getMajorPSSubSysServiceAPIDEField();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSubSysServiceAPI();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSubSysServiceAPI();
    }

    @Override
    public int getOrderValue() {
        if (!this.psSubSysSADE.isORDERVALUENull() && this.psSubSysSADE.getORDERVALUE() >= 0) {
            return this.psSubSysSADE.getORDERVALUE();
        }
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8c03\u7528\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"METHODCODE"})
    public String getMethodScriptCode() {
        return this.psSubSysSADE.getMETHODCODE();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u6570", fields={"SERVICEPARAM"})
    public String getServiceParam() {
        return this.strServiceParam;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65702", fields={"SERVICEPARAM2"})
    public String getServiceParam2() {
        return this.strServiceParam2;
    }

    public Properties getServiceParams() {
        return this.serviceParams;
    }
}

