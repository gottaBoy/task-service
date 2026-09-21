/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.UML.IPSUMLObject;
import SA.SRFDA.PS.Data.PSSysUserCaseRS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUseCaseRSImpl
extends PSSystemObjectImpl
implements IPSSysUseCaseRS {
    private static final Log log = LogFactory.getLog(PSSysUseCaseRSImpl.class);
    protected PSSysUserCaseRS psSysUserCaseRS = null;
    private IPSSysActor fromPSSysActor = null;
    private IPSSysUseCase fromPSSysUseCase = null;
    private IPSSysActor toPSSysActor = null;
    private IPSSysUseCase toPSSysUseCase = null;
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysUserCaseRS psSysUserCaseRS) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysUserCaseRS = psSysUserCaseRS;
            this.setId(this.psSysUserCaseRS.getPSSYSUSERCASERSID());
            this.setName(this.psSysUserCaseRS.getPSSYSUSERCASERSNAME());
            this.setPSObjectData(this.psSysUserCaseRS);
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserCaseRS.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysUserCaseRS.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserCaseRS.getPPSSYSACTORID())) {
                this.fromPSSysActor = this.getPSSystem().getPSSysActor(this.psSysUserCaseRS.getPPSSYSACTORID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserCaseRS.getPSSYSACTORID())) {
                this.toPSSysActor = this.getPSSystem().getPSSysActor(this.psSysUserCaseRS.getPSSYSACTORID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserCaseRS.getPPSSYSUSERCASEID())) {
                this.fromPSSysUseCase = this.getPSSystem().getPSSysUseCase(this.psSysUserCaseRS.getPPSSYSUSERCASEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserCaseRS.getPSSYSUSERCASEID())) {
                this.toPSSysUseCase = this.getPSSystem().getPSSysUseCase(this.psSysUserCaseRS.getPSSYSUSERCASEID());
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
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u64cd\u4f5c\u8005", hideempty=true, dumpref=true)
    public IPSSysActor getToPSSysActor() {
        return this.toPSSysActor;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u7528\u4f8b", hideempty=true, dumpref=true)
    public IPSSysUseCase getToPSSysUseCase() {
        return this.toPSSysUseCase;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6a21\u5f0f", codelist="UseCaseRSMode")
    public String getRSMode() {
        return this.psSysUserCaseRS.getRSMODE();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u7c7b\u578b", codelist="UseCaseRSType")
    public String getRSType() {
        return this.psSysUserCaseRS.getRSTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u64cd\u4f5c\u8005", hideempty=true, dumpref=true)
    public IPSSysActor getFromPSSysActor() {
        return this.fromPSSysActor;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u7528\u4f8b", hideempty=true, dumpref=true)
    public IPSSysUseCase getFromPSSysUseCase() {
        return this.fromPSSysUseCase;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5bf9\u8c61", hideempty=true)
    public IPSUMLObject getFromPSUMLObject() {
        if (this.getFromPSSysActor() != null) {
            return this.getFromPSSysActor();
        }
        if (this.getFromPSSysUseCase() != null) {
            return this.getFromPSSysUseCase();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5bf9\u8c61", hideempty=true)
    public IPSUMLObject getToPSUMLObject() {
        if (this.getToPSSysActor() != null) {
            return this.getToPSSysActor();
        }
        if (this.getToPSSysUseCase() != null) {
            return this.getToPSSysUseCase();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", hideempty=true)
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.psSysUserCaseRS.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public String getContent() {
        return this.psSysUserCaseRS.getCONTENT();
    }

    @Override
    public String getModelType() {
        return "PSSYSUSECASERS";
    }
}

