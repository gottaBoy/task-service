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
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.WF.IPSWFWorkTime;
import SA.SRFDA.PS.Data.PSWFWorkTime;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSWFWorkTimeImpl
extends PSSystemObjectImpl
implements IPSWFWorkTime {
    private static final Log log = LogFactory.getLog(PSWFWorkTimeImpl.class);
    protected PSWFWorkTime psWFWorkTime;
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSWFWorkTime psWFWorkTime) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psWFWorkTime = psWFWorkTime;
            this.setId(this.psWFWorkTime.getPSWFWORKTIMEID());
            this.setName(this.psWFWorkTime.getPSWFWORKTIMENAME());
            this.setPSObjectData(this.psWFWorkTime);
            if (!StringHelper.isNullOrEmpty((String)this.psWFWorkTime.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psWFWorkTime.getPSMODULEID());
            }
            this.strCodeName = this.psWFWorkTime.getCODENAME();
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
    }

    @Override
    public String getLogicName() {
        return this.getName();
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
    @PSModelRTMeta(description="\u5de5\u4f5c\u65f6\u95f4\u6570\u636e", hideempty2=true, fields={"USERDATA"})
    public String getUserData() {
        return this.psWFWorkTime.getUSERDATA();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u65f6\u95f4\u6570\u636e2", hideempty2=true, fields={"USERDATA2"})
    public String getUserData2() {
        return this.psWFWorkTime.getUSERDATA2();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u65f6\u95f4\u7f16\u53f7", hideempty2=true, group="\u57fa\u672c", order=105, fields={"WFWORKTIMESN"})
    public String getWFWorkTimeSN() {
        return this.psWFWorkTime.getWFWORKTIMESN();
    }

    @Override
    public String getModelType() {
        return "PSWFWORKTIME";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, hideempty=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
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
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        String strRootDeployId = "";
        strRootDeployId = this.getPSSystemModule() != null ? this.getPSSystemModule().getDeployId() : this.getPSSystem().getDeployId();
        return KeyValueHelper.genUniqueId((String)strRootDeployId, (String)this.getCodeName());
    }
}

