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
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysModelGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysModelGroupImpl
extends PSSystemObjectImpl
implements IPSSysModelGroup {
    private static final Log log = LogFactory.getLog(PSSysModelGroupImpl.class);
    protected PSSysModelGroup psSysModelGroup = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysModelGroup psSysModelGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysModelGroup = psSysModelGroup;
            this.setId(this.psSysModelGroup.getPSSYSMODELGROUPID());
            this.setName(this.psSysModelGroup.getPSSYSMODELGROUPNAME());
            this.setPSObjectData(this.psSysModelGroup);
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psSysModelGroup.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSMODELGROUP";
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb0", fields={"GROUPTAG"})
    public String getGroupTag() {
        return this.psSysModelGroup.getGROUPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb02", fields={"GROUPTAG2"})
    public String getGroupTag2() {
        return this.psSysModelGroup.getGROUPTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb03", fields={"GROUPTAG3"})
    public String getGroupTag3() {
        return this.psSysModelGroup.getGROUPTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb04", fields={"GROUPTAG4"})
    public String getGroupTag4() {
        return this.psSysModelGroup.getGROUPTAG4();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        return KeyValueHelper.genUniqueId((String)this.getPSSystem().getDeployId(), (String)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757\u96c6\u5408", group="\u57fa\u672c", order=130)
    public Iterator<IPSSystemModule> getPSSystemModules() throws Exception {
        ArrayList<IPSSystemModule> list = new ArrayList<IPSSystemModule>();
        Iterator<IPSSystemModule> psSystemModules = this.getPSSystem().getAllPSSystemModules();
        if (psSystemModules != null) {
            while (psSystemModules.hasNext()) {
                IPSSystemModule iPSSystemModule = psSystemModules.next();
                if (iPSSystemModule.getPSSysModelGroup() == null || StringHelper.compare((String)iPSSystemModule.getPSSysModelGroup().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                list.add(iPSSystemModule);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u8fd0\u884c\u65f6\u7ec4\u4ef6\u4ed3\u5e93\u914d\u7f6e", dump=false)
    public String getSFRTObjectRepo() {
        return this.psSysModelGroup.getSFRTOBJECTREPO();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u8fd0\u884c\u65f6\u7ec4\u4ef6\u4ed3\u5e93\u914d\u7f6e", dump=false)
    public String getPFRTObjectRepo() {
        return this.psSysModelGroup.getPFRTOBJECTREPO();
    }

    @Override
    @PSModelRTMeta(description="\u5305\u4ee3\u7801\u540d\u79f0", hideempty2=true, fields={"PKGCODENAME"})
    public String getPKGCodeName() {
        return this.psSysModelGroup.getPKGCODENAME();
    }

    @Override
    @PSModelRTMeta(description="DTO\u4ee3\u7801\u6807\u8bc6\u683c\u5f0f\u5316", dump=false)
    public String getDTOCodeNameFormat() {
        if (!StringHelper.isNullOrEmpty((String)this.psSysModelGroup.getDTOFORMAT())) {
            return this.psSysModelGroup.getDTOFORMAT();
        }
        return this.getPSSystem().getDTOCodeNameFormat();
    }

    @Override
    @PSModelRTMeta(description="API\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f", codelist="CodeNameMode", fields={"CODENAMEMODE"}, dump=false)
    public String getAPICodeNameMode() {
        return this.psSysModelGroup.getCODENAMEMODE();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528PQL", dump=false, ignoredumpvalues="false", fields={"ENABLEPQL"})
    public boolean isEnablePQL() {
        if (!this.psSysModelGroup.isENABLEPQLNull()) {
            return this.psSysModelGroup.getENABLEPQL();
        }
        return this.getPSSystem().isEnablePQL();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u7c7b\u578b", fields={"RUNTIMETYPE"})
    public String getRuntimeType() {
        return this.psSysModelGroup.getRUNTIMETYPE();
    }
}

