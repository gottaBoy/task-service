/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterRuntime;
import SA.SRFDA.PS.Core.DevCenter.IPSDevUserRuntime;
import SA.SRFDA.PS.Core.DevCenter.PSDevUserImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Robot.IPSDCRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Core.Robot.PSDCRobotGlobalModel;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import SA.SRFDA.PS.Data.PSDevCenter;
import SA.SRFDA.PS.Data.PSDevUser;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevCenterImpl
extends PSObjectImpl
implements IPSDevCenter,
IPSDevCenterRuntime {
    private static final Log log = LogFactory.getLog(PSDevCenterImpl.class);
    protected PSDevCenter psDevCenter = null;
    protected HashMap<String, IPSDevUserRuntime> psDevUserRuntimeMap = new HashMap();
    private int nMaxActiveUserCount = 100;
    private int nActiveUserCount = 0;
    private ArrayList<IPSDevUserRuntime> psDevUserRuntimeList = new ArrayList();
    private PSDCRobotGlobalModel psDCRobotGlobalModel = new PSDCRobotGlobalModel();
    private boolean bUseRobot = false;
    private long nLastRobotChgTime = 0L;
    private long nLastMobTDChgTime = 0L;
    private long nLastMobCertChgTime = 0L;
    private net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter psDevCenter2 = null;
    private int nDCLevel = 200;
    private String strDCType = "DEVCENTER";
    private String strDomainName = null;
    private String strRootFolder = null;
    private long nLastActiveTime = 0L;
    private boolean bUseWorkspace = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDevCenter psDevCenter) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevCenter = psDevCenter;
        this.setId(this.psDevCenter.getPSDEVCENTERID());
        this.setName(this.psDevCenter.getPSDEVCENTERNAME());
        this.setPSObjectData(this.psDevCenter);
        this.active();
        if (!this.psDevCenter.isMAXACTIVEUSERCNTNull()) {
            this.nMaxActiveUserCount = this.psDevCenter.getMAXACTIVEUSERCNT();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDevCenter.getDCTYPE())) {
            this.strDCType = this.psDevCenter.getDCTYPE();
        }
        if (!this.psDevCenter.isDCLEVELNull()) {
            this.nDCLevel = this.psDevCenter.getDCLEVEL();
        }
        this.strDomainName = this.psDevCenter.getDOMAINNAME();
        this.strRootFolder = StringHelper.format((String)"%1$s%2$s%3$s", (Object)this.getPSModelStorage().getPSTaskServerEnv().getCodeFolder(), (Object)File.separator, (Object)this.strDomainName);
        File footFolder = new File(this.strRootFolder);
        footFolder.mkdirs();
        this.strRootFolder = footFolder.getPath();
        this.psDevCenter2 = PSCoreEntityKeeperGlobal.getCurrent(null).getPSDevCenter(this.getId());
        if (this.psDevCenter2.getRobotChgTime() != null) {
            this.nLastRobotChgTime = this.psDevCenter2.getRobotChgTime().getTime();
        }
        if (this.psDevCenter2.getMobCertChgTime() != null) {
            this.nLastMobCertChgTime = this.psDevCenter2.getMobCertChgTime().getTime();
        }
        if (this.psDevCenter2.getMobTDChgTime() != null) {
            this.nLastMobTDChgTime = this.psDevCenter2.getMobTDChgTime().getTime();
        }
        this.psDCRobotGlobalModel.Init(iDAGlobalHelper, this);
        boolean bl = this.bUseRobot = this.psDCRobotGlobalModel.getAllModelHelperCount() > 0;
        if (!this.bUseRobot && this.nDCLevel < 200) {
            this.bUseRobot = true;
        }
        if (!this.psDevCenter.isENABLEWORKSPACENull()) {
            this.bUseWorkspace = this.psDevCenter.getENABLEWORKSPACE();
        }
        if (this.isUseWorkspace()) {
            this.bUseRobot = false;
        }
        this.onInit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDevUserRuntime loginUser(String strPSDevUserId, String strSessionId, String strRemoteAddr) throws Exception {
        this.active();
        IPSDevUserRuntime iPSDevUserRuntime = null;
        HashMap<String, IPSDevUserRuntime> hashMap = this.psDevUserRuntimeMap;
        synchronized (hashMap) {
            iPSDevUserRuntime = this.psDevUserRuntimeMap.get(strPSDevUserId);
        }
        if (iPSDevUserRuntime == null) {
            iPSDevUserRuntime = this.createPSDevUserRuntime(strPSDevUserId);
            hashMap = this.psDevUserRuntimeMap;
            synchronized (hashMap) {
                if (!this.psDevUserRuntimeMap.containsKey(iPSDevUserRuntime.getId())) {
                    this.psDevUserRuntimeMap.put(iPSDevUserRuntime.getId(), iPSDevUserRuntime);
                } else {
                    iPSDevUserRuntime = this.psDevUserRuntimeMap.get(strPSDevUserId);
                }
            }
        }
        iPSDevUserRuntime.login(strSessionId, strRemoteAddr);
        this.checkActiveUserLimit();
        return iPSDevUserRuntime;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDevUserRuntime logoutUser(String strPSDevUserId, String strSessionId, String strRemoteAddr) throws Exception {
        this.active();
        IPSDevUserRuntime iPSDevUserRuntime = null;
        HashMap<String, IPSDevUserRuntime> hashMap = this.psDevUserRuntimeMap;
        synchronized (hashMap) {
            iPSDevUserRuntime = this.psDevUserRuntimeMap.get(strPSDevUserId);
            if (iPSDevUserRuntime != null && StringHelper.compare((String)iPSDevUserRuntime.getActiveSessionId(), (String)strSessionId, (boolean)false) != 0) {
                iPSDevUserRuntime = null;
            }
        }
        if (iPSDevUserRuntime != null) {
            iPSDevUserRuntime.logout(strRemoteAddr);
            this.checkActiveUserLimit();
        }
        return iPSDevUserRuntime;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDevUserRuntime activeUser(String strPSDevUserId, String strSessionId, String strRemoteAddr, String strInfo, String strUserData) throws Exception {
        this.active();
        IPSDevUserRuntime iPSDevUserRuntime = null;
        HashMap<String, IPSDevUserRuntime> hashMap = this.psDevUserRuntimeMap;
        synchronized (hashMap) {
            iPSDevUserRuntime = this.psDevUserRuntimeMap.get(strPSDevUserId);
            if (iPSDevUserRuntime != null && StringHelper.compare((String)iPSDevUserRuntime.getActiveSessionId(), (String)strSessionId, (boolean)false) != 0) {
                throw new Exception("\u5f53\u524d\u7528\u6237\u5df2\u7ecf\u88ab\u6ce8\u9500");
            }
        }
        if (iPSDevUserRuntime == null) {
            iPSDevUserRuntime = this.loginUser(strPSDevUserId, strSessionId, strRemoteAddr);
        }
        if (iPSDevUserRuntime != null) {
            iPSDevUserRuntime.active(strSessionId, strRemoteAddr, strInfo, strUserData);
        }
        return iPSDevUserRuntime;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected IPSDevUserRuntime createPSDevUserRuntime(String strPSDevUserId) throws Exception {
        PSDevUser psDevUser = new PSDevUser();
        CallResult callResult = this.getPSModelHelper(this.getPSSysModelInstId()).getPSDevUser(strPSDevUserId, psDevUser);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5f00\u53d1\u7528\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        PSDevUserImpl psDevUserImpl = new PSDevUserImpl();
        psDevUserImpl.init(this.getDAGlobalHelper(), this, psDevUser);
        return psDevUserImpl;
    }

    @Override
    public int getMaxActiveUserCount() {
        return this.nMaxActiveUserCount;
    }

    protected void removeOldestPSDevUserRuntime(int nCount) throws Exception {
    }

    @Override
    public void reload() throws Exception {
        CallResult callResult = this.getPSModelHelper().getPSDevCenter(this.getId(), this.psDevCenter);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3[%1$s]\u53d1\u751f\u9519\u8bef,%1$s", (Object)this.getId(), (Object)callResult.getErrorInfo()));
        }
        this.nMaxActiveUserCount = !this.psDevCenter.isMAXACTIVEUSERCNTNull() ? this.psDevCenter.getMAXACTIVEUSERCNT() : 100;
        this.checkActiveUserLimit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected int checkActiveUserLimit() throws Exception {
        this.active();
        HashMap<String, IPSDevUserRuntime> hashMap = this.psDevUserRuntimeMap;
        synchronized (hashMap) {
            this.psDevUserRuntimeList.clear();
            for (IPSDevUserRuntime iPSDevUserRuntime : this.psDevUserRuntimeMap.values()) {
                if (!iPSDevUserRuntime.isActive()) continue;
                ++this.nActiveUserCount;
                this.psDevUserRuntimeList.add(iPSDevUserRuntime);
            }
            int nRemoveCount = this.psDevUserRuntimeList.size() - this.getMaxActiveUserCount();
            if (nRemoveCount > 0) {
                Collections.sort(this.psDevUserRuntimeList, new Comparator<IPSDevUserRuntime>(){

                    @Override
                    public int compare(IPSDevUserRuntime arg0, IPSDevUserRuntime arg1) {
                        int nRet = (int)(arg0.getLastActiveTime() - arg1.getLastActiveTime());
                        if (nRet == 0) {
                            return 0;
                        }
                        if (nRet > 0) {
                            return 1;
                        }
                        return -1;
                    }
                });
                while (nRemoveCount > 0) {
                    IPSDevUserRuntime iPSDevUserRuntime = this.psDevUserRuntimeList.remove(0);
                    iPSDevUserRuntime.logout("");
                    --nRemoveCount;
                }
            }
            this.nActiveUserCount = this.psDevUserRuntimeList.size();
            return this.nActiveUserCount;
        }
    }

    @Override
    public int getActiveUserCount() {
        return this.nActiveUserCount;
    }

    @Override
    public boolean isUseRobot() {
        return this.bUseRobot;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDCRobot getPSDCRobot(String strPSDCRobotId) throws Exception {
        this.active();
        this.checkPSDCRobotGlobalModel();
        PSDCRobotGlobalModel pSDCRobotGlobalModel = this.psDCRobotGlobalModel;
        synchronized (pSDCRobotGlobalModel) {
            return (IPSDCRobot)this.psDCRobotGlobalModel.FindModelHelper(strPSDCRobotId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSDCRobot(String strPSDCRobotId) {
        this.active();
        PSDCRobotGlobalModel pSDCRobotGlobalModel = this.psDCRobotGlobalModel;
        synchronized (pSDCRobotGlobalModel) {
            this.psDCRobotGlobalModel.ResetModel(strPSDCRobotId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public PSRobotResult getValidPSDCRobot(IPSRobotWork iPSRobotWork) throws Exception {
        this.active();
        this.checkPSDCRobotGlobalModel();
        PSDCRobotGlobalModel pSDCRobotGlobalModel = this.psDCRobotGlobalModel;
        synchronized (pSDCRobotGlobalModel) {
            return this.psDCRobotGlobalModel.getValidPSDCRobot(iPSRobotWork);
        }
    }

    @Override
    public boolean isValid() {
        try {
            this.active();
            this.psDevCenter2 = PSCoreEntityKeeperGlobal.getCurrent(null).getPSDevCenter(this.getId());
            return this.psDevCenter2.getValidFlag() != null && this.psDevCenter2.getValidFlag() == 1;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void checkPSDCRobotGlobalModel() throws Exception {
        this.psDevCenter2 = PSCoreEntityKeeperGlobal.getCurrent(null).getPSDevCenter(this.getId());
        if (this.psDevCenter2.getRobotChgTime() != null && this.psDevCenter2.getRobotChgTime().getTime() != this.nLastRobotChgTime) {
            this.nLastRobotChgTime = this.psDevCenter2.getRobotChgTime().getTime();
            PSDCRobotGlobalModel pSDCRobotGlobalModel = this.psDCRobotGlobalModel;
            synchronized (pSDCRobotGlobalModel) {
                this.psDCRobotGlobalModel.ResetAll();
                this.psDCRobotGlobalModel.getAllModelHelpers();
            }
        }
    }

    @Override
    public int getDCLevel() {
        return this.nDCLevel;
    }

    @Override
    public String getDCType() {
        return this.strDCType;
    }

    @Override
    public String getDomainName() {
        return this.strDomainName;
    }

    @Override
    public String getRootFolder() {
        return this.strRootFolder;
    }

    @Override
    public long getLastActiveTime() {
        return this.nLastActiveTime;
    }

    @Override
    public void active() {
        this.nLastActiveTime = System.currentTimeMillis();
    }

    @Override
    public boolean isUseWorkspace() {
        return this.bUseWorkspace;
    }
}

