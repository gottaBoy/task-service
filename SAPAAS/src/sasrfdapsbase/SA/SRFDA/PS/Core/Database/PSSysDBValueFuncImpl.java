/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFuncCode;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDBValueFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysDBValueFuncImpl
extends PSSystemObjectImpl
implements IPSSysDBValueFunc {
    private static final Log log = LogFactory.getLog(PSSysDBValueFuncImpl.class);
    protected PSSysDBValueFunc psSysDBValueFunc = null;
    protected String strDBVFType = null;
    protected String strCodeName = null;
    private String strOutputValueFormat = "%1$s";
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysDBValueFunc psSysDBValueFunc) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysDBValueFunc = psSysDBValueFunc;
            this.setId(this.psSysDBValueFunc.getPSSYSDBVFID());
            this.setName(this.psSysDBValueFunc.getPSSYSDBVFNAME());
            this.setPSObjectData(this.psSysDBValueFunc);
            this.strDBVFType = this.psSysDBValueFunc.getVFTYPE();
            this.strCodeName = this.psSysDBValueFunc.getCODENAME();
            if (!StringHelper.isNullOrEmpty((String)this.psSysDBValueFunc.getOUTPUTVALUEFORMAT())) {
                this.strOutputValueFormat = this.psSysDBValueFunc.getOUTPUTVALUEFORMAT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDBValueFunc.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysDBValueFunc.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDBValueFunc.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysDBValueFunc.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
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
    @PSModelRTMeta(description="\u8f93\u5165\u503c\u6570\u636e\u5e93\u7c7b\u578b", codelist="StdDataType")
    public int getInputStdDataType() {
        return this.psSysDBValueFunc.getINPUTSTDDATATYPE();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u503c\u6570\u636e\u5e93\u7c7b\u578b", codelist="StdDataType")
    public int getOutputStdDataType() {
        return this.psSysDBValueFunc.getOUTPUTSTDDATATYPE();
    }

    @Override
    public IPSSysDBValueFuncCode getFuncCode(String strDBType) throws Exception {
        return null;
    }

    @Override
    public String getModelType() {
        return "PSSYSDBVF";
    }

    @Override
    @PSModelRTMeta(description="\u51fd\u6570\u7c7b\u578b", codelist="SysDBVFType", group="\u57fa\u672c", order=125)
    public String getDBValueFuncType() {
        return this.strDBVFType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u503c\u683c\u5f0f\u5316")
    public String getOutputValueFormat() {
        return this.strOutputValueFormat;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u51fd\u6570\u6807\u8bb0", group="\u57fa\u672c", order=130)
    public String getValueFuncTag() {
        return this.psSysDBValueFunc.getVFTAG();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u51fd\u6570\u6807\u8bb02", group="\u57fa\u672c", order=131)
    public String getValueFuncTag2() {
        return this.psSysDBValueFunc.getVFTAG2();
    }
}

