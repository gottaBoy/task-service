/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst
 *  net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService
 *  net.ibizsys.pscore.srv.util.PSStudioEnvHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.PSDevSlnSysImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDevSlnSys;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInstRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import net.ibizsys.pscore.srv.util.PSStudioEnvHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysDynaInstImpl
extends PSObjectImpl
implements IPSDevSlnSysDynaInst {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstImpl.class);
    private PSDevSlnSysDynaInst psDevSlnSysDynaInst = null;
    private SA.SRFDA.PS.Data.PSDevSlnSysDepInst psDevSlnSysDepInst = null;
    private IPSDevSlnSys iPSDevSlnSys = null;
    private String strInstType = "DEFAULT";
    private PSDevSlnSys psDevSlnSys = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDevSlnSysDynaInst psDevSlnSysDynaInst) throws Exception {
        this.psDevSlnSysDynaInst = psDevSlnSysDynaInst;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID());
        this.setName(psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTNAME());
        this.setPSObjectData(this.psDevSlnSysDynaInst);
        this.strInstType = this.psDevSlnSysDynaInst.getINSTTYPE();
        if (StringHelper.isNullOrEmpty((String)this.strInstType)) {
            this.strInstType = "DEFAULT";
        }
        if (!"DEFAULT".equals(this.getInstType()) && !"MODULE".equals(this.getInstType())) {
            throw new Exception(String.format("\u52a8\u6001\u5b9e\u4f8b\u7c7b\u578b\u4e0d\u6b63\u786e\uff0c\u5f53\u524d\u4ec5\u652f\u6301\u9ed8\u8ba4\u5b9e\u4f8b\u53ca\u6a21\u5757\u526f\u672c\u5b9e\u4f8b", new Object[0]));
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        String strModelPath;
        net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst psDevSlnSysDynaInst2;
        PSDevSlnSysDynaInstService psDevSlnSysDynaInstService;
        String strModelPath2;
        if (StringHelper.isNullOrEmpty((String)this.psDevSlnSysDynaInst.getPSDEVSLNSYSDEPINSTID())) {
            throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u90e8\u7f72\u5b9e\u4f8b", new Object[0]));
        }
        SA.SRFDA.PS.Data.PSDevSlnSysDepInst psDevSlnSysDepInst = new SA.SRFDA.PS.Data.PSDevSlnSysDepInst();
        CallResult callResult = this.getPSModelHelper(null).getPSDevSlnSysDepInst(this.psDevSlnSysDynaInst.getPSDEVSLNSYSDEPINSTID(), psDevSlnSysDepInst);
        if (callResult.isError()) {
            throw new Exception(String.format("\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u90e8\u7f72\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", this.psDevSlnSysDynaInst.getPSDEVSLNSYSDEPINSTID(), callResult.getErrorInfo()));
        }
        this.psDevSlnSysDepInst = psDevSlnSysDepInst;
        if (StringHelper.isNullOrEmpty((String)this.psDevSlnSysDepInst.getPSDEVSLNSYSID())) {
            throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf", new Object[0]));
        }
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        callResult = this.getPSModelHelper(null).getPSDevSlnSys(this.psDevSlnSysDepInst.getPSDEVSLNSYSID(), psDevSlnSys);
        if (callResult.isError()) {
            throw new Exception(String.format("\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", this.psDevSlnSysDepInst.getPSDEVSLNSYSID(), callResult.getErrorInfo()));
        }
        PSDevSlnSysDynaInst psDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        this.psDevSlnSysDynaInst.CopyTo(psDevSlnSysDynaInst, false);
        if (StringHelper.isNullOrEmpty((String)psDevSlnSysDynaInst.getSYSMODELPATH())) {
            PSDevSlnSysDepInst psDevSlnSysDepInst2 = new PSDevSlnSysDepInst();
            psDevSlnSysDepInst2.setPSDevSlnSysDepInstId(this.psDevSlnSysDepInst.getPSDEVSLNSYSDEPINSTID());
            PSDevSlnSysDepInstService psDevSlnSysDepInstService = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psDevSlnSysDepInstService.checkOutModel(psDevSlnSysDepInst2);
            strModelPath2 = String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDepInstFolder(), File.separator, psDevSlnSysDepInst2.getPSDevSlnSysDepInstId());
            psDevSlnSysDynaInst.setSYSMODELPATH(strModelPath2);
        }
        if (StringHelper.isNullOrEmpty((String)psDevSlnSysDynaInst.getINSTMODELPATH())) {
            net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst psDevSlnSysDynaInst22 = new net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst();
            psDevSlnSysDynaInst22.setPSDevSlnSysDynaInstId(this.psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID());
            psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psDevSlnSysDynaInstService.checkOutModel(psDevSlnSysDynaInst22);
            strModelPath2 = String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, psDevSlnSysDynaInst22.getPSDevSlnSysDynaInstId());
            psDevSlnSysDynaInst.setINSTMODELPATH(strModelPath2);
        }
        Vector<PSDevSlnSysDynaInstRef> psDevSlnSysDynaInstRefs = new Vector<PSDevSlnSysDynaInstRef>();
        callResult = this.getPSModelHelper(null).getPSDevSlnSysDynaInstRefs(this.getId(), psDevSlnSysDynaInstRefs);
        if (callResult.isOk() && psDevSlnSysDynaInstRefs.size() > 0) {
            psDevSlnSysDynaInst.getPSDevSlnSysDynaInstRefList(true).clear();
            psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            for (PSDevSlnSysDynaInstRef psDevSlnSysDynaInstRef : psDevSlnSysDynaInstRefs) {
                psDevSlnSysDynaInst2 = new net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst();
                psDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(psDevSlnSysDynaInstRef.getREFPSDEVSLNSYSDYNAINSTID());
                if (!psDevSlnSysDynaInstService.get(psDevSlnSysDynaInst2, true)) {
                    throw new Exception(String.format("\u65e0\u6cd5\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef", psDevSlnSysDynaInstRef.getREFPSDEVSLNSYSDYNAINSTID()));
                }
                strModelPath = psDevSlnSysDynaInst2.getInstModelPath();
                if (StringHelper.isNullOrEmpty((String)strModelPath)) {
                    psDevSlnSysDynaInstService.checkOutModel(psDevSlnSysDynaInst2);
                    strModelPath = String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, psDevSlnSysDynaInst2.getPSDevSlnSysDynaInstId());
                }
                psDevSlnSysDynaInstRef.setINSTMODELPATH(strModelPath);
                psDevSlnSysDynaInst.getPSDevSlnSysDynaInstRefList(true).add(psDevSlnSysDynaInstRef);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDevSlnSysDynaInst.getPPSDEVSLNSYSDYNAINSTID())) {
            if (StringHelper.isNullOrEmpty((String)psDevSlnSysDynaInst.getPINSTMODELPATH())) {
                net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst psDevSlnSysDynaInst23 = new net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst();
                psDevSlnSysDynaInst23.setPSDevSlnSysDynaInstId(this.psDevSlnSysDynaInst.getPPSDEVSLNSYSDYNAINSTID());
                PSDevSlnSysDynaInstService psDevSlnSysDynaInstService2 = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psDevSlnSysDynaInstService2.checkOutModel(psDevSlnSysDynaInst23);
                String strModelPath3 = String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, psDevSlnSysDynaInst23.getPSDevSlnSysDynaInstId());
                psDevSlnSysDynaInst.setPINSTMODELPATH(strModelPath3);
            }
            psDevSlnSysDynaInstRefs.clear();
            callResult = this.getPSModelHelper(null).getPSDevSlnSysDynaInstRefs(this.psDevSlnSysDynaInst.getPPSDEVSLNSYSDYNAINSTID(), psDevSlnSysDynaInstRefs);
            if (callResult.isOk() && psDevSlnSysDynaInstRefs.size() > 0) {
                psDevSlnSysDynaInst.getPPSDevSlnSysDynaInstRefList(true).clear();
                psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                for (PSDevSlnSysDynaInstRef psDevSlnSysDynaInstRef : psDevSlnSysDynaInstRefs) {
                    psDevSlnSysDynaInst2 = new net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst();
                    psDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(psDevSlnSysDynaInstRef.getREFPSDEVSLNSYSDYNAINSTID());
                    if (!psDevSlnSysDynaInstService.get(psDevSlnSysDynaInst2, true)) {
                        throw new Exception(String.format("\u65e0\u6cd5\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef", psDevSlnSysDynaInstRef.getREFPSDEVSLNSYSDYNAINSTID()));
                    }
                    strModelPath = psDevSlnSysDynaInst2.getInstModelPath();
                    if (StringHelper.isNullOrEmpty((String)strModelPath)) {
                        psDevSlnSysDynaInstService.checkOutModel(psDevSlnSysDynaInst2);
                        strModelPath = String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, psDevSlnSysDynaInst2.getPSDevSlnSysDynaInstId());
                    }
                    psDevSlnSysDynaInstRef.setINSTMODELPATH(strModelPath);
                    psDevSlnSysDynaInst.getPPSDevSlnSysDynaInstRefList(true).add(psDevSlnSysDynaInstRef);
                }
            }
        }
        PSDevSlnSysImpl psDevSlnSysImpl = new PSDevSlnSysImpl();
        psDevSlnSysImpl.init(this.getDAGlobalHelper(), psDevSlnSys, psDevSlnSysDynaInst, psDevSlnSysDepInst);
        this.iPSDevSlnSys = psDevSlnSysImpl;
        this.psDevSlnSys = psDevSlnSys;
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.psDevSlnSysDepInst == null || StringHelper.isNullOrEmpty((String)this.psDevSlnSysDepInst.getPSSYSMODELINSTID())) {
            if (this.psDevSlnSys != null) {
                return this.psDevSlnSys.getPSSYSMODELINSTID();
            }
            return null;
        }
        return this.psDevSlnSysDepInst.getPSSYSMODELINSTID();
    }

    @Override
    public IPSDevSlnSys getPSDevSlnSys() {
        return this.iPSDevSlnSys;
    }

    @Override
    public String getInstType() {
        return this.strInstType;
    }

    @Override
    public int getInstState() {
        return this.psDevSlnSysDynaInst.getINSTSTATE();
    }

    @Override
    public String getInstTag() {
        return this.psDevSlnSysDynaInst.getINSTTAG();
    }

    @Override
    public String getInstTag2() {
        return this.psDevSlnSysDynaInst.getINSTTAG2();
    }

    @Override
    public String getInstTag3() {
        return this.psDevSlnSysDynaInst.getINSTTAG3();
    }

    @Override
    public String getInstTag4() {
        return this.psDevSlnSysDynaInst.getINSTTAG4();
    }

    @Override
    public String getPSDevCenterId() {
        return this.psDevSlnSysDynaInst.getPSDEVCENTERID();
    }

    @Override
    public String getPPSDevSlnSysDynaInstId() {
        return this.psDevSlnSysDynaInst.getPPSDEVSLNSYSDYNAINSTID();
    }

    @Override
    public String getPSDevSlnId() {
        return this.psDevSlnSysDynaInst.getPSDEVSLNID();
    }
}
