/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSSysDEGroup;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;
import SA.SRFDA.PS.Core.Res.IPSSysUtilType;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSDEUtil;
import SA.SRFDA.PS.Data.PSSysUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUtilImpl
extends PSSystemObjectImpl
implements IPSSysUtil,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSSysUtilImpl.class);
    static final String UTILPARAM_TRYMODE = "TRYMODE";
    protected PSSysUtil psSysUtil = null;
    private String strUtilType = null;
    private String strUtilPSDEId = null;
    private String strUtilPSDE2Id = null;
    private String strUtilPSDE3Id = null;
    private String strUtilPSDE4Id = null;
    private String strUtilPSDE5Id = null;
    private String strUtilPSDE6Id = null;
    private String strUtilPSDE7Id = null;
    private String strUtilPSDE8Id = null;
    private String strUtilPSDE9Id = null;
    private String strUtilPSDE10Id = null;
    private String strUtilPSDE11Id = null;
    private String strUtilPSDE12Id = null;
    private String strUtilPSDE13Id = null;
    private String strUtilPSDE14Id = null;
    private String strUtilPSDE15Id = null;
    private String strUtilPSDE16Id = null;
    private String strUtilPSDE17Id = null;
    private String strUtilPSDE18Id = null;
    private String strUtilPSDE19Id = null;
    private String strUtilPSDE20Id = null;
    private String strUtilPSDEName = null;
    private String strUtilPSDE2Name = null;
    private String strUtilPSDE3Name = null;
    private String strUtilPSDE4Name = null;
    private String strUtilPSDE5Name = null;
    private String strUtilPSDE6Name = null;
    private String strUtilPSDE7Name = null;
    private String strUtilPSDE8Name = null;
    private String strUtilPSDE9Name = null;
    private String strUtilPSDE10Name = null;
    private String strUtilPSDE11Name = null;
    private String strUtilPSDE12Name = null;
    private String strUtilPSDE13Name = null;
    private String strUtilPSDE14Name = null;
    private String strUtilPSDE15Name = null;
    private String strUtilPSDE16Name = null;
    private String strUtilPSDE17Name = null;
    private String strUtilPSDE18Name = null;
    private String strUtilPSDE19Name = null;
    private String strUtilPSDE20Name = null;
    private IPSSysUtilType iPSSysUtilType = null;
    private String strUtilRTObj = null;
    private Map<String, String> utilRTParamMap = new LinkedHashMap<String, String>();
    private String strCodeName = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private Properties utilParams = null;
    private IPSSystemModule iPSSystemModule = null;
    private String strServicePath = null;
    private String strServiceParam = null;
    private String strServiceParam2 = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthClientSecret = null;
    private String strAuthAccessTokenUrl = null;
    private IPSSysModelGroup iPSSysModelGroup = null;
    private int nOrderValue = 99999;
    private boolean bTryMode = false;
    private IPSSysDEGroup iPSSysDEGroup;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysUtil psSysUtil) throws Exception {
        try {
            Iterator<String> keys;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysUtil = psSysUtil;
            this.setId(this.psSysUtil.getPSSYSUTILDEID());
            this.setName(this.psSysUtil.getPSSYSUTILDENAME());
            this.setPSObjectData(this.psSysUtil);
            this.strUtilType = this.psSysUtil.getUTILTYPE();
            this.iPSSysUtilType = this.getPSModelStorage().getPSSysUtilType(this.strUtilType);
            if (!StringHelper.isNullOrEmpty((String)this.psSysUtil.getPSSYSMODELGROUPID())) {
                this.iPSSysModelGroup = this.getPSSystem().getPSSysModelGroup(this.psSysUtil.getPSSYSMODELGROUPID());
            } else if (!StringHelper.isNullOrEmpty((String)this.psSysUtil.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysUtil.getPSMODULEID());
            }
            this.strUtilPSDEId = this.psSysUtil.getUTILPSDEID();
            this.strUtilPSDE2Id = this.psSysUtil.getUTILPSDE2ID();
            this.strUtilPSDE3Id = this.psSysUtil.getUTILPSDE3ID();
            this.strUtilPSDE4Id = this.psSysUtil.getUTILPSDE4ID();
            this.strUtilPSDE5Id = this.psSysUtil.getUTILPSDE5ID();
            this.strUtilPSDE6Id = this.psSysUtil.getUTILPSDE6ID();
            this.strUtilPSDE7Id = this.psSysUtil.getUTILPSDE7ID();
            this.strUtilPSDE8Id = this.psSysUtil.getUTILPSDE8ID();
            this.strUtilPSDE9Id = this.psSysUtil.getUTILPSDE9ID();
            this.strUtilPSDE10Id = this.psSysUtil.getUTILPSDE10ID();
            this.strUtilPSDE11Id = this.psSysUtil.getUTILPSDE11ID();
            this.strUtilPSDE12Id = this.psSysUtil.getUTILPSDE12ID();
            this.strUtilPSDE13Id = this.psSysUtil.getUTILPSDE13ID();
            this.strUtilPSDE14Id = this.psSysUtil.getUTILPSDE14ID();
            this.strUtilPSDE15Id = this.psSysUtil.getUTILPSDE15ID();
            this.strUtilPSDE16Id = this.psSysUtil.getUTILPSDE16ID();
            this.strUtilPSDE17Id = this.psSysUtil.getUTILPSDE17ID();
            this.strUtilPSDE18Id = this.psSysUtil.getUTILPSDE18ID();
            this.strUtilPSDE19Id = this.psSysUtil.getUTILPSDE19ID();
            this.strUtilPSDE20Id = this.psSysUtil.getUTILPSDE20ID();
            this.strUtilPSDEName = this.psSysUtil.getUTILPSDENAME();
            this.strUtilPSDE2Name = this.psSysUtil.getUTILPSDE2NAME();
            this.strUtilPSDE3Name = this.psSysUtil.getUTILPSDE3NAME();
            this.strUtilPSDE4Name = this.psSysUtil.getUTILPSDE4NAME();
            this.strUtilPSDE5Name = this.psSysUtil.getUTILPSDE5NAME();
            this.strUtilPSDE6Name = this.psSysUtil.getUTILPSDE6NAME();
            this.strUtilPSDE7Name = this.psSysUtil.getUTILPSDE7NAME();
            this.strUtilPSDE8Name = this.psSysUtil.getUTILPSDE8NAME();
            this.strUtilPSDE9Name = this.psSysUtil.getUTILPSDE9NAME();
            this.strUtilPSDE10Name = this.psSysUtil.getUTILPSDE10NAME();
            this.strUtilPSDE11Name = this.psSysUtil.getUTILPSDE11NAME();
            this.strUtilPSDE12Name = this.psSysUtil.getUTILPSDE12NAME();
            this.strUtilPSDE13Name = this.psSysUtil.getUTILPSDE13NAME();
            this.strUtilPSDE14Name = this.psSysUtil.getUTILPSDE14NAME();
            this.strUtilPSDE15Name = this.psSysUtil.getUTILPSDE15NAME();
            this.strUtilPSDE16Name = this.psSysUtil.getUTILPSDE16NAME();
            this.strUtilPSDE17Name = this.psSysUtil.getUTILPSDE17NAME();
            this.strUtilPSDE18Name = this.psSysUtil.getUTILPSDE18NAME();
            this.strUtilPSDE19Name = this.psSysUtil.getUTILPSDE19NAME();
            this.strUtilPSDE20Name = this.psSysUtil.getUTILPSDE20NAME();
            if (!StringHelper.isNullOrEmpty((String)this.psSysUtil.getUTILPARAMS())) {
                this.utilParams = SA.SRFramework.UtilityEx.PropertiesHelper.Load((String)this.psSysUtil.getUTILPARAMS());
            }
            if ((keys = this.getPSSysUtilType().getRTParamNames()) != null) {
                while (keys.hasNext()) {
                    String strKey = keys.next();
                    String strParam = this.getPSSysUtilType().getRTParamKey(strKey);
                    String strValue = SA.SRFramework.UtilityEx.PropertiesHelper.GetProperty((Properties)this.utilParams, (String)strParam);
                    if (StringHelper.isNullOrEmpty((String)strValue)) {
                        strValue = this.psSysUtil.getParamStringValue(strParam, "");
                    }
                    this.utilRTParamMap.put(strKey, strValue);
                }
            }
            this.strUtilRTObj = this.psSysUtil.getUTILOBJ();
            this.strCodeName = this.psSysUtil.getCODENAME();
            this.strAuthMode = this.psSysUtil.getAUTHMODE();
            this.strAuthAccessTokenUrl = this.psSysUtil.getAUTHACCESSTOKENURI();
            this.strAuthClientId = this.psSysUtil.getAUTHCLIENTID();
            this.strAuthClientSecret = this.psSysUtil.getAUTHCLIENTSECRET();
            this.strServicePath = this.psSysUtil.getSERVICEPATH();
            this.strServiceParam = this.psSysUtil.getSERVICEPARAM();
            this.strServiceParam2 = this.psSysUtil.getSERVICEPARAM2();
            if (!this.psSysUtil.isORDERVALUENull() && this.psSysUtil.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psSysUtil.getORDERVALUE();
            }
            this.bTryMode = PropertiesHelper.getProperty((Properties)this.getUtilParams(), (String)UTILPARAM_TRYMODE, (boolean)false);
            if (this.isRegToSys() && StringHelper.isNullOrEmpty((String)this.getCodeName())) {
                throw new Exception(StringHelper.format((String)StringHelper.format((String)"\u529f\u80fd[%1$s]]\u9700\u8981\u6ce8\u518c\u5230\u7cfb\u7edf\uff0c\u4f46\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u540d\u79f0", (Object)this.getName())));
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
        String strPSSysSFPluginId = this.psSysUtil.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysUtil.getPSDEGROUPID())) {
            this.iPSSysDEGroup = this.getPSSystem().getPSDEGroup(this.psSysUtil.getPSDEGROUPID());
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSubSysServiceAPI();
        this.getInPSSysDataSyncAgent();
        this.getOutPSSysDataSyncAgent();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSSYSUTILDE";
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7c7b\u578b", codelist="SysDEUtilType", group="\u57fa\u672c", order=125, fields={"UTILTYPE"})
    public String getUtilType() {
        return this.strUtilType;
    }

    @Override
    public String getUtilPSDEId() {
        return this.strUtilPSDEId;
    }

    @Override
    public String getUtilPSDE2Id() {
        return this.strUtilPSDE2Id;
    }

    @Override
    public String getUtilPSDE3Id() {
        return this.strUtilPSDE3Id;
    }

    @Override
    public String getUtilPSDE4Id() {
        return this.strUtilPSDE4Id;
    }

    @Override
    public String getUtilPSDE5Id() {
        return this.strUtilPSDE5Id;
    }

    @Override
    public String getUtilPSDE6Id() {
        return this.strUtilPSDE6Id;
    }

    @Override
    public String getUtilPSDE7Id() {
        return this.strUtilPSDE7Id;
    }

    @Override
    public String getUtilPSDE8Id() {
        return this.strUtilPSDE8Id;
    }

    @Override
    public String getUtilPSDE9Id() {
        return this.strUtilPSDE9Id;
    }

    @Override
    public String getUtilPSDE10Id() {
        return this.strUtilPSDE10Id;
    }

    @Override
    public String getUtilPSDE11Id() {
        return this.strUtilPSDE11Id;
    }

    @Override
    public String getUtilPSDE12Id() {
        return this.strUtilPSDE12Id;
    }

    @Override
    public String getUtilPSDE13Id() {
        return this.strUtilPSDE13Id;
    }

    @Override
    public String getUtilPSDE14Id() {
        return this.strUtilPSDE14Id;
    }

    @Override
    public String getUtilPSDE15Id() {
        return this.strUtilPSDE15Id;
    }

    @Override
    public String getUtilPSDE16Id() {
        return this.strUtilPSDE16Id;
    }

    @Override
    public String getUtilPSDE17Id() {
        return this.strUtilPSDE17Id;
    }

    @Override
    public String getUtilPSDE18Id() {
        return this.strUtilPSDE18Id;
    }

    @Override
    public String getUtilPSDE19Id() {
        return this.strUtilPSDE19Id;
    }

    @Override
    public String getUtilPSDE20Id() {
        return this.strUtilPSDE20Id;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f53\u540d\u79f0", hideempty2=true)
    public String getUtilPSDEName() {
        return this.strUtilPSDEName;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f532\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE2Name() {
        return this.strUtilPSDE2Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f533\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE3Name() {
        return this.strUtilPSDE3Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f534\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE4Name() {
        return this.strUtilPSDE4Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f535\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE5Name() {
        return this.strUtilPSDE5Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f536\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE6Name() {
        return this.strUtilPSDE6Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f537\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE7Name() {
        return this.strUtilPSDE7Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f538\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE8Name() {
        return this.strUtilPSDE8Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f539\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE9Name() {
        return this.strUtilPSDE9Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5310\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE10Name() {
        return this.strUtilPSDE10Name;
    }

    @Override
    public String getUtilPSDE11Name() {
        return this.strUtilPSDE11Name;
    }

    @Override
    public String getUtilPSDE12Name() {
        return this.strUtilPSDE12Name;
    }

    @Override
    public String getUtilPSDE13Name() {
        return this.strUtilPSDE13Name;
    }

    @Override
    public String getUtilPSDE14Name() {
        return this.strUtilPSDE14Name;
    }

    @Override
    public String getUtilPSDE15Name() {
        return this.strUtilPSDE15Name;
    }

    @Override
    public String getUtilPSDE16Name() {
        return this.strUtilPSDE16Name;
    }

    @Override
    public String getUtilPSDE17Name() {
        return this.strUtilPSDE17Name;
    }

    @Override
    public String getUtilPSDE18Name() {
        return this.strUtilPSDE18Name;
    }

    @Override
    public String getUtilPSDE19Name() {
        return this.strUtilPSDE19Name;
    }

    @Override
    public String getUtilPSDE20Name() {
        return this.strUtilPSDE20Name;
    }

    @Override
    public IPSSysUtilType getPSSysUtilType() {
        return this.iPSSysUtilType;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61\u540d\u79f0", hideempty2=true, fields={"UTILOBJ"})
    public String getRTObjectName() {
        return this.strUtilRTObj;
    }

    @Override
    public String getUtilRTObject(IPSSysSFPub iPSSysSFPub) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strUtilRTObj)) {
            String strObj;
            if (this.getPSSystem().getDynaSysMode() == 2 && !StringHelper.isNullOrEmpty((String)(strObj = this.getPSSysUtilType().getClassOrPkgName("DYNASYS", iPSSysSFPub, true)))) {
                return strObj;
            }
            return this.getPSSysUtilType().getClassOrPkgName("", iPSSysSFPub);
        }
        return this.strUtilRTObj;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u53c2\u6570\u96c6\u5408")
    public Iterator<String> getUtilRTParamNames() {
        return this.utilRTParamMap.keySet().iterator();
    }

    @Override
    public String getUtilRTParam(String strName) {
        return this.getUtilRTParam(strName, "");
    }

    @Override
    public String getUtilRTParam(String strName, String strDefault) {
        String strValue = this.utilRTParamMap.get(strName);
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return strDefault;
        }
        return strValue;
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u518c\u5230\u7cfb\u7edf")
    public boolean isRegToSys() {
        return this.getPSSysUtilType().isRegToSys();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEUtil psDEUtil) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public int getExtendMode() {
        throw new RuntimeException("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        throw new RuntimeException("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6807\u8bb0", hideempty=true, fields={"UTILTAG"})
    public String getUtilTag() {
        if (StringHelper.isNullOrEmpty((String)this.psSysUtil.getUTILTAG())) {
            return null;
        }
        return this.psSysUtil.getUTILTAG();
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6807\u8bb02", hideempty=true, fields={"UTILTAG2"})
    public String getUtilTag2() {
        if (StringHelper.isNullOrEmpty((String)this.psSysUtil.getUTILTAG2())) {
            return null;
        }
        return this.psSysUtil.getUTILTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f53", hideempty2=true, dumpref=true, fields={"UTILPSDEID"})
    public IPSDataEntity getUtilPSDE() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDEId())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDEId(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f532", hideempty2=true, dumpref=true, fields={"UTILPSDE2ID"})
    public IPSDataEntity getUtilPSDE2() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE2Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE2Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f533", hideempty2=true, dumpref=true, fields={"UTILPSDE3ID"})
    public IPSDataEntity getUtilPSDE3() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE3Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE3Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f534", hideempty2=true, dumpref=true, fields={"UTILPSDE4ID"})
    public IPSDataEntity getUtilPSDE4() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE4Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE4Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f535", hideempty2=true, dumpref=true, fields={"UTILPSDE5ID"})
    public IPSDataEntity getUtilPSDE5() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE5Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE5Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f536", hideempty2=true, dumpref=true, fields={"UTILPSDE6ID"})
    public IPSDataEntity getUtilPSDE6() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE6Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE6Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f537", hideempty2=true, dumpref=true, fields={"UTILPSDE7ID"})
    public IPSDataEntity getUtilPSDE7() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE7Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE7Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f538", hideempty2=true, dumpref=true, fields={"UTILPSDE8ID"})
    public IPSDataEntity getUtilPSDE8() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE8Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE8Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f539", hideempty2=true, dumpref=true, fields={"UTILPSDE9ID"})
    public IPSDataEntity getUtilPSDE9() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE9Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE9Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5310", hideempty2=true, dumpref=true, fields={"UTILPSDE10ID"})
    public IPSDataEntity getUtilPSDE10() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE10Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE10Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5311", hideempty2=true, dumpref=true, fields={"UTILPSDE11ID"})
    public IPSDataEntity getUtilPSDE11() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE11Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE11Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5312", hideempty2=true, dumpref=true, fields={"UTILPSDE12ID"})
    public IPSDataEntity getUtilPSDE12() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE12Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE12Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5313", hideempty2=true, dumpref=true, fields={"UTILPSDE13ID"})
    public IPSDataEntity getUtilPSDE13() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE13Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE13Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5314", hideempty2=true, dumpref=true, fields={"UTILPSDE14ID"})
    public IPSDataEntity getUtilPSDE14() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE14Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE14Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5315", hideempty2=true, dumpref=true, fields={"UTILPSDE15ID"})
    public IPSDataEntity getUtilPSDE15() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE15Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE15Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5316", hideempty2=true, dumpref=true, fields={"UTILPSDE16ID"})
    public IPSDataEntity getUtilPSDE16() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE16Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE16Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5317", hideempty2=true, dumpref=true, fields={"UTILPSDE17ID"})
    public IPSDataEntity getUtilPSDE17() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE17Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE17Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5318", hideempty2=true, dumpref=true, fields={"UTILPSDE18ID"})
    public IPSDataEntity getUtilPSDE18() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE18Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE18Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5319", hideempty2=true, dumpref=true, fields={"UTILPSDE19ID"})
    public IPSDataEntity getUtilPSDE19() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE19Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE19Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5320", hideempty2=true, dumpref=true, fields={"UTILPSDE20ID"})
    public IPSDataEntity getUtilPSDE20() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE20Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE20Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3", hideempty2=true, dumpref=true, fields={"PSSUBSYSSERVICEAPIID"})
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysUtil.getPSSUBSYSSERVICEAPIID())) {
            return null;
        }
        return this.getPSSystem().getPSSubSysServiceAPI(this.psSysUtil.getPSSUBSYSSERVICEAPIID());
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7ec4\u4ef6\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"UTILPARAMS"})
    public Properties getUtilParams() {
        return this.utilParams;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"INPSSYSDATASYNCAGENTID"})
    public IPSSysDataSyncAgent getInPSSysDataSyncAgent() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysUtil.getINPSSYSDATASYNCAGENTID())) {
            return null;
        }
        return this.getPSSystem().getPSSysDataSyncAgent(this.psSysUtil.getINPSSYSDATASYNCAGENTID());
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"OUTPSSYSDATASYNCAGENTID"})
    public IPSSysDataSyncAgent getOutPSSysDataSyncAgent() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysUtil.getOUTPSSYSDATASYNCAGENTID())) {
            return null;
        }
        return this.getPSSystem().getPSSysDataSyncAgent(this.psSysUtil.getOUTPSSYSDATASYNCAGENTID());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8d44\u6e90\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"PSSYSRESOURCEID"})
    public IPSSysResource getPSSysResource() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysUtil.getPSSYSRESOURCEID())) {
            return null;
        }
        return this.getPSSystem().getPSSysResource(this.psSysUtil.getPSSYSRESOURCEID());
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u7cfb\u7edf\u8d44\u6e90\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"OUTPSSYSRESOURCEID"})
    public IPSSysResource getOutPSSysResource() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysUtil.getOUTPSSYSRESOURCEID())) {
            return null;
        }
        return this.getPSSystem().getPSSysResource(this.psSysUtil.getOUTPSSYSRESOURCEID());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8def\u5f84", fields={"SERVICEPATH"})
    public String getServicePath() {
        return this.strServicePath;
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

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u6a21\u5f0f", codelist="APIAuthMode", fields={"AUTHMODE"})
    public String getAuthMode() {
        return this.strAuthMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1token\u8def\u5f84", fields={"AUTHACCESSTOKENURI"})
    public String getAuthAccessTokenUrl() {
        return this.strAuthAccessTokenUrl;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6", fields={"AUTHCLIENTID"})
    public String getAuthClientId() {
        return this.strAuthClientId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u7801", fields={"AUTHCLIENTSECRET"})
    public String getAuthClientSecret() {
        return this.strAuthClientSecret;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u6570", fields={"AUTHPARAM"})
    public String getAuthParam() {
        return this.psSysUtil.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSysUtil.getAUTHPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u578b\u7ec4", dumpref=true, dynamodelmode=4, fields={"PSSYSMODELGROUPID"})
    public IPSSysModelGroup getPSSysModelGroup() {
        return this.iPSSysModelGroup;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999", fields={"ORDERVALUE"})
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    protected String onGetDynaModelTag() {
        if (StringHelper.isNullOrEmpty((String)this.getCodeName())) {
            if (!StringHelper.isNullOrEmpty((String)this.getUtilTag())) {
                return this.getUtilTag();
            }
            return this.getUtilType();
        }
        return super.onGetDynaModelTag();
    }

    @Override
    @PSModelRTMeta(description="\u5c1d\u8bd5\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isTryMode() {
        return this.bTryMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u8d85\u65f6\u65f6\u957f", ignoredumpvalues="-1")
    public int getAuthTimeout() {
        return -1;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5b9e\u4f53\u7ec4", dumpref=true, fields={"PSDEGROUPID"})
    public IPSSysDEGroup getPSSysDEGroup() {
        return this.iPSSysDEGroup;
    }
}

