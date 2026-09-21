/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysLogic;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDEActionLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionLogicImpl
extends PSObjectImpl
implements IPSDEActionLogic {
    private static final Log log = LogFactory.getLog(PSDEActionLogicImpl.class);
    protected IPSDEAction iPSDEAction;
    protected PSDEActionLogic psDEActionLogic;
    private boolean bInternalLogic = true;
    private boolean bValid = true;
    private boolean bCloneParam = false;
    private boolean bIgnoreException = false;
    private int nActionLogicType = 1;
    private boolean bPrepareLast = false;
    private int nPrepareLastMode = 0;
    private int nLogicHolder = 1;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private Properties logicParams = null;
    private IPSDEField iPSDEField = null;
    private int nDataSyncEvent = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEAction iPSDEAction, PSDEActionLogic psDEActionLogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEAction = iPSDEAction;
            this.psDEActionLogic = psDEActionLogic;
            this.setId(this.psDEActionLogic.getPSDEACTIONLOGICID());
            this.setName(this.psDEActionLogic.getPSDEACTIONLOGICNAME());
            this.setPSObjectData(this.psDEActionLogic);
            if (!this.psDEActionLogic.isINTERNALLOGICNull()) {
                this.nActionLogicType = this.psDEActionLogic.getINTERNALLOGIC();
                boolean bl = this.bInternalLogic = this.nActionLogicType == 1;
            }
            if (!this.psDEActionLogic.isVALIDFLAGNull()) {
                this.bValid = this.psDEActionLogic.getVALIDFLAG();
            }
            if (!this.psDEActionLogic.isCLONEPARAMFLAGNull()) {
                this.bCloneParam = this.psDEActionLogic.getCLONEPARAMFLAG();
            }
            if (!this.psDEActionLogic.isIGNOREEXCEPTIONNull()) {
                this.bIgnoreException = this.psDEActionLogic.getIGNOREEXCEPTION();
            }
            if (!this.psDEActionLogic.isPREPARELASTNull()) {
                this.nPrepareLastMode = this.psDEActionLogic.getPREPARELAST();
                boolean bl = this.bPrepareLast = this.nPrepareLastMode != 0;
            }
            if (!this.getPSDEAction().isEnableBackend() && this.getPSDEAction().isEnableFront()) {
                this.nLogicHolder = 2;
            }
            if (!this.psDEActionLogic.isLOGICHOLDERNull()) {
                this.nLogicHolder = this.psDEActionLogic.getLOGICHOLDER();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPROPERTYMAP())) {
                this.logicParams = PropertiesHelper.load((String)this.psDEActionLogic.getPROPERTYMAP());
            }
            if (!this.getPSDEAction().isEnableBackend() && (this.nLogicHolder & 1) == 1) {
                this.nLogicHolder ^= 1;
            }
            if (!this.getPSDEAction().isEnableFront() && (this.nLogicHolder & 2) == 2) {
                this.nLogicHolder ^= 2;
            }
            if (this.getActionLogicType() == 3) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDENOTIFYID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u89e6\u53d1\u5b9e\u4f53\u901a\u77e5");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
            }
            if (this.getActionLogicType() == 3) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDENOTIFYID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u89e6\u53d1\u5b9e\u4f53\u901a\u77e5");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
            }
            if (this.getActionLogicType() == 5) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDEDATASYNCID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u89e6\u53d1\u5b9e\u4f53\u540c\u6b65");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
                if (!this.psDEActionLogic.isDATASYNCEVENTNull() && this.psDEActionLogic.getDATASYNCEVENT() > 0) {
                    this.nDataSyncEvent = this.psDEActionLogic.getDATASYNCEVENT();
                }
            }
            if (this.getActionLogicType() == 50) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDEFVALUERULEID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
            }
            if (this.getActionLogicType() == 4 || this.getActionLogicType() == 51 || this.getActionLogicType() == 52) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDEMAINSTATEID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76f8\u5173\u5b9e\u4f53\u4e3b\u72b6\u6001");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
            }
            if (this.getActionLogicType() == 6 || this.getActionLogicType() == 53 || this.getActionLogicType() == 54) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getMAJORPSDERID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u4e3b\u5173\u7cfb");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
            }
            if (this.getActionLogicType() == 7 || this.getActionLogicType() == 55 || this.getActionLogicType() == 56) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53");
                }
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEDATASETID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u6570\u636e\u96c6");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
            }
            if (this.getActionLogicType() == 6 || this.getActionLogicType() == 7) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53");
                }
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEACTIONID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u884c\u4e3a");
                }
            }
            if (this.getActionLogicType() == 11) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53");
                }
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDELOGICID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u903b\u8f91");
                }
            }
            if (this.getActionLogicType() == 8) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSSYSDELOGICNODEID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u903b\u8f91");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
            }
            if (this.getActionLogicType() == 10) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSSYSSEQUENCEID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u503c\u5e8f\u5217");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
            }
            if (this.getActionLogicType() == 9) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSSYSTRANSLATORID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u503c\u8f6c\u6362\u5668");
                }
                if ((this.nLogicHolder & 2) == 2) {
                    this.nLogicHolder ^= 2;
                }
            }
            if (this.getActionLogicType() == 10 || this.getActionLogicType() == 9) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDEFID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u5c5e\u6027");
                }
                this.iPSDEField = this.getPSDataEntity().getPSDEField(this.psDEActionLogic.getPSDEFID());
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
        if (!StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEActionLogic.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDataEntity().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDataEntity().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61")
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    public IPSDataEntity getPSDataEntity() {
        return this.getPSDEAction().getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u6a21\u5f0f", codelist="DEActionLogicAttachMode", fields={"ATTACHMODE"})
    public String getAttachMode() {
        return this.psDEActionLogic.getATTACHMODE();
    }

    @Override
    public String getPSDELogicId() {
        return this.psDEActionLogic.getPSDELOGICID();
    }

    @Override
    public String getPSDELogicName() {
        return this.psDEActionLogic.getPSDELOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u903b\u8f91", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDELOGICID"})
    public IPSDELogic getPSDELogic() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSDELogicId())) {
            return null;
        }
        return this.iPSDEAction.getPSDataEntity().getPSDELogic(this.getPSDELogicId());
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEAction.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u90e8\u903b\u8f91", doc="\u53c2\u8003{@#link #getActionLogicType}")
    public boolean isInternalLogic() {
        return this.bInternalLogic;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53", dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDE() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEID())) {
            return null;
        }
        return this.iPSDEAction.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDEActionLogic.getDSTPSDEID());
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u884c\u4e3a", dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDEMust().getPSDEAction", fields={"DSTPSDEACTIONID"})
    public IPSDEAction getDstPSDEAction() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEACTIONID())) {
            return null;
        }
        if (this.getDstPSDE() == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53");
        }
        return this.getDstPSDE().getPSDEAction(this.psDEActionLogic.getDSTPSDEACTIONID());
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u903b\u8f91", dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDEMust().getPSDELogic", fields={"DSTPSDELOGICID"})
    public IPSDELogic getDstPSDELogic() throws Exception {
        if (this.getActionLogicType() != 11) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDELOGICID())) {
            return null;
        }
        if (this.getDstPSDE() == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53");
        }
        return this.getDstPSDE().getPSDELogic(this.psDEActionLogic.getDSTPSDELOGICID());
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true", fields={"VALIDFLAG"})
    public boolean isValid() {
        return this.bValid;
    }

    @Override
    @PSModelRTMeta(description="\u514b\u9686\u4f20\u5165\u53c2\u6570", ignoredumpvalues="false", fields={"CLONEPARAMFLAG"})
    public boolean isCloneParam() {
        return this.bCloneParam;
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u5f02\u5e38", ignoredumpvalues="false", fields={"IGNOREEXCEPTION"})
    public boolean isIgnoreException() {
        return this.bIgnoreException;
    }

    @Override
    public int check() throws Exception {
        this.getPSDELogic();
        this.getDstPSDE();
        this.getDstPSDEAction();
        this.getDstPSDEDataSet();
        this.getMajorPSDER();
        this.getPSDEDataSync();
        this.getPSDEFValueRule();
        this.getPSDEMainState();
        this.getPSDENotify();
        this.getPSSysLogic();
        this.getPSSysSequence();
        this.getPSSysTranslator();
        return super.check();
    }

    @Override
    public String getModelType() {
        return "PSDEACTIONLOGIC";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEAction().getPSDataEntity().getPSSystem());
    }

    @Override
    public BaseDataEntity getModelData() {
        return this.getPSObjectData();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u903b\u8f91\u7c7b\u578b", codelist="DEActionLogicType", fields={"INTERNALLOGIC"})
    public int getActionLogicType() {
        return this.nActionLogicType;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.psDEActionLogic.getCUSTOMCODE();
    }

    @Override
    @PSModelRTMeta(description="\u51c6\u5907\u64cd\u4f5c\u4e4b\u524d\u6570\u636e", ignoredumpvalues="false", ignorepf=true)
    public boolean isPrepareLast() {
        if (!this.bPrepareLast && this.isEnableBackend()) {
            try {
                IPSDELogic iPSDELogic = this.getPSDELogic();
                if (iPSDELogic != null && iPSDELogic.isEnableBackend()) {
                    return iPSDELogic.isPrepareLast();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.bPrepareLast;
    }

    @Override
    @PSModelRTMeta(description="\u51c6\u5907\u64cd\u4f5c\u4e4b\u524d\u6570\u636e\u6a21\u5f0f", ignoredumpvalues="0", codelist="DEActionPrepareLastMode", ignorepf=true, fields={"PREPARELAST"})
    public int getPrepareLastMode() {
        if (this.isPrepareLast() && this.nPrepareLastMode == 0) {
            return 1;
        }
        return this.nPrepareLastMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u901a\u77e5", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"PSDENOTIFYID"})
    public IPSDENotify getPSDENotify() throws Exception {
        if (this.getActionLogicType() != 3) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDENOTIFYID())) {
            return null;
        }
        return this.iPSDEAction.getPSDataEntity().getPSDENotify(this.psDEActionLogic.getPSDENOTIFYID());
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getLogicHolder() {
        return this.nLogicHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", ignoredumpvalues="true", fields={"LOGICHOLDER"})
    public boolean isEnableBackend() {
        return (this.getLogicHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", dump=false)
    public boolean isEnableFront() {
        return (this.getLogicHolder() & 2) == 2;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"PSDEMAINSTATEID"})
    public IPSDEMainState getPSDEMainState() throws Exception {
        if (!(this.getActionLogicType() != 4 && this.getActionLogicType() != 51 && this.getActionLogicType() != 52 || StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDEMAINSTATEID()))) {
            return this.getPSDataEntity().getPSDEMainState(this.psDEActionLogic.getPSDEMAINSTATEID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u5bf9\u8c61", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"PSDEFID"})
    public IPSDEField getPSDEField() throws Exception {
        if (this.iPSDEField != null) {
            return this.iPSDEField;
        }
        if (this.getPSDEFValueRule() != null) {
            return this.getPSDEFValueRule().getPSDEField();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219", dumpref=true, ignorepf=true, from="__self__", from_method="getPSDEFieldMust().getPSDEFValueRule", fields={"PSDEFVALUERULEID"})
    public IPSDEFValueRule getPSDEFValueRule() throws Exception {
        if (this.getActionLogicType() == 50 && !StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDEFVALUERULEID())) {
            return this.getPSDataEntity().getPSDEFValueRule(this.psDEActionLogic.getPSDEFVALUERULEID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u540c\u6b65", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"PSDEDATASYNCID"})
    public IPSDEDataSync getPSDEDataSync() throws Exception {
        if (this.getActionLogicType() == 5 && !StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSDEDATASYNCID())) {
            return this.getPSDataEntity().getPSDEDataSync(this.psDEActionLogic.getPSDEDATASYNCID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u540c\u6b65\u4e8b\u4ef6", codelist="DataSyncInformType", fields={"DATASYNCEVENT"}, ignoredumpvalues="0")
    public int getDataSyncEvent() {
        return this.nDataSyncEvent;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDEMust().getPSDEDataSet", fields={"DSTPSDEDATASETID"})
    public IPSDEDataSet getDstPSDEDataSet() throws Exception {
        if (this.getActionLogicType() == 7 || this.getActionLogicType() == 55 || this.getActionLogicType() == 56) {
            if (this.getDstPSDE() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53");
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getDSTPSDEDATASETID())) {
                return this.getDstPSDE().getPSDEDataSet(this.psDEActionLogic.getDSTPSDEDATASETID());
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u63a7\u5173\u7cfb", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", from_method="getMajorPSDERBase", fields={"MAJORPSDERID"})
    public IPSDERBase getMajorPSDER() throws Exception {
        if (!(this.getActionLogicType() != 6 && this.getActionLogicType() != 53 && this.getActionLogicType() != 54 || StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getMAJORPSDERID()))) {
            return this.getPSDataEntity().getPSDER(true, this.psDEActionLogic.getMAJORPSDERID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u9884\u7f6e\u903b\u8f91", hideempty=true, ignorepf=true, dumpref=true, fields={"PSSYSDELOGICNODEID"})
    public IPSSysLogic getPSSysLogic() throws Exception {
        if (this.getActionLogicType() == 8 && !StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSSYSDELOGICNODEID())) {
            return this.getPSDataEntity().getPSSystem().getPSSysLogic(this.psDEActionLogic.getPSSYSDELOGICNODEID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u5e8f\u5217", hideempty=true, ignorepf=true, dumpref=true, fields={"PSSYSSEQUENCEID"})
    public IPSSysSequence getPSSysSequence() throws Exception {
        if (this.getActionLogicType() == 10 && !StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSSYSSEQUENCEID())) {
            return this.getPSDataEntity().getPSSystem().getPSSysSequence(this.psDEActionLogic.getPSSYSSEQUENCEID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u8f6c\u6362\u5668", hideempty=true, ignorepf=true, dumpref=true, fields={"PSSYSTRANSLATORID"})
    public IPSSysTranslator getPSSysTranslator() throws Exception {
        if (this.getActionLogicType() == 9 && !StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getPSSYSTRANSLATORID())) {
            return this.getPSDataEntity().getPSSystem().getPSSysTranslator(this.psDEActionLogic.getPSSYSTRANSLATORID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9519\u8bef\u4ee3\u7801", ignoredumpvalues="0", fields={"ERRORCODE"}, ignorepf=true)
    public int getErrorCode() {
        if (this.getActionLogicType() >= 50 && !this.psDEActionLogic.isERRORCODENull()) {
            return this.psDEActionLogic.getERRORCODE();
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u5e38\u5bf9\u8c61", fields={"EXCEPTIONOBJ"}, ignorepf=true)
    public String getExceptionObj() {
        if (this.getActionLogicType() >= 50) {
            return this.psDEActionLogic.getEXCEPTIONOBJ();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9519\u8bef\u4fe1\u606f", fields={"ERRORMSG"}, ignorepf=true)
    public String getErrorInfo() {
        if (this.getActionLogicType() >= 50) {
            return this.psDEActionLogic.getERRORMSG();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9519\u8bef\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"ERRORPSLANRESID"}, ignorepf=true)
    public IPSLanguageRes getErrorInfoPSLanguageRes() throws Exception {
        if (this.getActionLogicType() >= 50 && !StringHelper.isNullOrEmpty((String)this.psDEActionLogic.getERRORPSLANRESID())) {
            return this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEActionLogic.getERRORPSLANRESID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u903b\u8f91\u52a8\u6001\u53c2\u6570", hideempty=true, ignorepf=true, fields={"PROPERTYMAP"})
    public Properties getLogicParams() {
        return this.logicParams;
    }
}

