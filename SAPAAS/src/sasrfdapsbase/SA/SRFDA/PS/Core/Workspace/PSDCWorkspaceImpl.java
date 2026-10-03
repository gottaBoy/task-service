/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceSum
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceSumService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Workspace;

import SA.SRFDA.PS.Core.PSActionLimitException;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Robot.IPSRobotWorkType;
import SA.SRFDA.PS.Core.Util.PSDevSlnSysHelper;
import SA.SRFDA.PS.Core.Workspace.IPSDCWorkspace;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspaceType;
import SA.SRFDA.PS.Core.Workspace.PSWorkspacePeriod;
import SA.SRFDA.PS.Data.PSDCWorkspace;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceSum;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceSumService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDCWorkspaceImpl
extends PSObjectImpl
implements IPSDCWorkspace {
    private final String _S1 = "MFwwDQYJKoZIhvcNAQ";
    private final String _S2 = "EBBQADSwAwSAJBAK6ioJMxbkWnZU8NG";
    private final String _S6 = "TcvCbNOd3NrrFKDbS";
    private final String _S7 = "ocWQQr+R4/MRznOksA";
    private final String _S3 = "DA4XtrmKer6Ro/8cYcHf17";
    private final String _S4 = "QUlyb3tJvh3cUCAwEAAQ==";
    private final String _ERR = "\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u65e0\u6548";
    private final String _ERR2 = "\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u5df2\u4f7f\u7528";
    public static final String TAG_TOTALPSMODEL = "TOTALPSMODEL";
    public static final String TAG_TOTALFILECOUNT = "TOTALFILECOUNT";
    public static final String TAG_TOTALFILESIZE = "TOTALFILESIZE";
    public static final String TAG_FILESIZE = "FILESIZE";
    public static final String TAG_WORKINGDAYS = "WORKINGDAYS";
    public static final String TAG_HOLIDAYS = "HOLIDAYS";
    public static final String TAG_WORKINGDAYPERIODS = "WORKINGDAYPERIODS";
    public static final String TAG_HOLIDAYSPERIODS = "HOLIDAYSPERIODS";
    private static Map<String, String> SUMGROUPMAP = new HashMap<String, String>();
    private static Map<String, String> SUMGROUPNAMEMAP = new HashMap<String, String>();
    private static Map<String, String> REALTASKMAP = new HashMap<String, String>();
    private static final Log log;
    protected PSDCWorkspace psDCWorkspace = null;
    private IPSWorkspaceType iPSWorkspaceType = null;
    private int nTotalPSModelCount = 0;
    private int nFileSizeLimit = -1;
    private int nTotalFileSizeLimit = -1;
    private int nTotalFileCountLimit = -1;
    private Timestamp expiredTime = null;
    private Timestamp curExpiredTime = null;
    private Timestamp curActiveTime = null;
    private String strPSWorkspaceId = null;
    private int nWorkspaceLevel = -1;
    private int nResState = 20;
    private int nResPos = 1;

    static {
        SUMGROUPMAP.put("D", "%1$tY-%1$tm-%1$td");
        SUMGROUPMAP.put("M", "%1$tY-%1$tm");
        SUMGROUPMAP.put("Y", "%1$tY");
        SUMGROUPMAP.put("H", "%1$tY-%1$tm-%1$td %1$tH");
        SUMGROUPNAMEMAP.put("D", "\u6bcf\u5929");
        SUMGROUPNAMEMAP.put("M", "\u6bcf\u6708");
        SUMGROUPNAMEMAP.put("Y", "\u6bcf\u6708");
        SUMGROUPNAMEMAP.put("H", "\u6bcf\u5c0f\u65f6");
        REALTASKMAP.put("SYSBKTASK|STARTUPEX", "SYSBKTASK|STARTUPAS");
        REALTASKMAP.put("SYSBKTASK|STARTUPEX", "SYSBKTASK|STARTUPEX2");
        REALTASKMAP.put("SYSBKTASK|STARTUPEX", "SYSBKTASK|STARTUPEX3");
        REALTASKMAP.put("SYSBKTASK|STARTUPEX", "SYSBKTASK|STARTUPEX4");
        REALTASKMAP.put("SYSBKTASK|STARTUPEX", "SYSBKTASK|STARTUPEX5");
        REALTASKMAP.put("SYSBKTASK|STARTUPEX", "SYSBKTASK|STARTUPEX6");
        REALTASKMAP.put("SYSBKTASK|STARTUPEX", "SYSBKTASK|STARTUPEX7");
        REALTASKMAP.put("SYSBKTASK|STARTUPEX", "SYSBKTASK|STARTUPEX8");
        log = LogFactory.getLog(PSDCWorkspaceImpl.class);
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCWorkspace psDCWorkspace) throws Exception {
        PSTemplHelper.assertNotBusy();
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCWorkspace = psDCWorkspace;
        this.setId(psDCWorkspace.getPSDCWORKSPACEID());
        this.setName(psDCWorkspace.getPSDCWORKSPACENAME());
        this.setPSObjectData(this.psDCWorkspace);
        this.strPSWorkspaceId = this.psDCWorkspace.getPSWORKSPACEID();
        this.reloadPSDCWorkspace();
        this.onInit();
    }

    private void reloadPSDCWorkspace() throws Exception {
        String strWorkspaceType;
        if (!PSDevSlnSysHelper.isCloudMode()) {
            PSCoreSysServiceBase.isCloudMode();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWorkspaceType = this.psDCWorkspace.getWORKSPACETYPE()))) {
            this.iPSWorkspaceType = this.getPSModelStorage().getPSWorkspaceType(strWorkspaceType, true);
            if (this.iPSWorkspaceType == null && !this.psDCWorkspace.isWORKSPACELEVELNull()) {
                this.nWorkspaceLevel = this.psDCWorkspace.getWORKSPACELEVEL();
                strWorkspaceType = StringHelper.Format((String)"%1$s__%2$s", (Object)strWorkspaceType, (Object)this.psDCWorkspace.getWORKSPACELEVEL());
                this.iPSWorkspaceType = this.getPSModelStorage().getPSWorkspaceType(strWorkspaceType, true);
            }
        }
        if (this.iPSWorkspaceType == null) {
            throw new Exception("\u751f\u4ea7\u7ebf\u7c7b\u578b\u65e0\u6548");
        }
        if (this.psDCWorkspace.getEXPIREDTIME() != null) {
            this.expiredTime = new Timestamp(this.psDCWorkspace.getEXPIREDTIME().getTime());
        }
        if (this.psDCWorkspace.getCURACTIVETIME() != null) {
            this.curActiveTime = new Timestamp(this.psDCWorkspace.getCURACTIVETIME().getTime());
        }
        if (this.psDCWorkspace.getCUREXPIREDTIME() != null) {
            this.curExpiredTime = new Timestamp(this.psDCWorkspace.getCUREXPIREDTIME().getTime());
        }
        this.nResState = this.psDCWorkspace.getRESSTATE();
        this.nTotalPSModelCount = this.getPSModelLimit(TAG_TOTALPSMODEL);
        this.nFileSizeLimit = this.iPSWorkspaceType.getUserParam(TAG_FILESIZE, this.nFileSizeLimit);
        this.nTotalFileSizeLimit = this.iPSWorkspaceType.getUserParam(TAG_TOTALFILESIZE, this.nTotalFileSizeLimit);
        this.nTotalFileCountLimit = this.iPSWorkspaceType.getUserParam(TAG_TOTALFILECOUNT, this.nTotalFileCountLimit);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getModelType() {
        return "PSDCWORKSPACE";
    }

    @Override
    public int getPSModelLimit(String strModel) {
        return this.iPSWorkspaceType.getPSModelLimit(strModel);
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u6a21\u578b\u9879\u6570\u91cf")
    public int getTotalPSModelLimit() {
        return this.nTotalPSModelCount;
    }

    @Override
    public Iterator<String> getPSModelLimitNames() {
        return this.iPSWorkspaceType.getPSModelLimitNames();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u6587\u4ef6\u5927\u5c0f\u9650\u5236")
    public int getFileSizeLimit() {
        return this.nFileSizeLimit;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u7a7a\u95f4\u9650\u5236")
    public int getTotalFileSizeLimit() {
        return this.nTotalFileSizeLimit;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u6587\u4ef6\u6570\u91cf\u9650\u5236")
    public int getTotalFileCountLimit() {
        return this.nTotalFileCountLimit;
    }

    @Override
    public Timestamp getExpiredTime() {
        return this.expiredTime;
    }

    @Override
    public Timestamp getCurExpiredTime() {
        return this.curExpiredTime;
    }

    @Override
    public Timestamp getCurActiveTime() {
        return this.curActiveTime;
    }

    @Override
    public String getPSDevCenterId() {
        return this.psDCWorkspace.getPSDEVCENTERID();
    }

    @Override
    public String getPSDevSlnId() {
        return this.psDCWorkspace.getPSDEVSLNID();
    }

    @Override
    public String getPSDevSlnSysId() {
        return this.psDCWorkspace.getPSDEVSLNSYSID();
    }

    @Override
    public boolean testAction(String strActionCat, String strActionType, int nAmount, boolean bTryMode) throws Exception {
        Date curDate = new Date(System.currentTimeMillis());
        String strAction = StringHelper.Format((String)"%1$s|%2$s", (Object)strActionCat, (Object)strActionType);
        String strAction2 = REALTASKMAP.get(strAction);
        if (StringHelper.IsNullOrEmpty((String)strAction2)) {
            strAction2 = strAction;
        }
        String strActionName = "";
        IPSRobotWorkType iPSRobotWorkType = this.getPSModelStorage().getPSRobotWorkType(strAction, true);
        strActionName = iPSRobotWorkType != null ? iPSRobotWorkType.getName() : "\u672a\u77e5\u4f5c\u4e1a";
        String strPSWorkspaceId2 = this.strPSWorkspaceId;
        IPSWorkspaceType iPSWorkspaceType2 = this.iPSWorkspaceType;
        int nAmount2 = nAmount;
        PSWorkspaceSumService psWorkspaceSumService = (PSWorkspaceSumService)ServiceGlobal.getService(PSWorkspaceSumService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        for (Map.Entry<String, String> entry : SUMGROUPMAP.entrySet()) {
            int nLimit;
            String strTag = strAction2;
            if (!StringHelper.IsNullOrEmpty((String)entry.getKey())) {
                strTag = StringHelper.Format((String)"%1$s.%2$s", (Object)strTag, (Object)entry.getKey());
            }
            if ((nLimit = iPSWorkspaceType2.getUserParam(strTag, -1)) == -1) continue;
            String strSumTag = StringHelper.Format((String)entry.getValue(), (Object)curDate);
            PSWorkspaceSum psWorkspaceSum = new PSWorkspaceSum();
            psWorkspaceSum.setPSWorkspaceId(strPSWorkspaceId2);
            psWorkspaceSum.setSumType(strAction2);
            psWorkspaceSum.setSumTag(strSumTag);
            psWorkspaceSum.setSumTag2(null);
            psWorkspaceSum.setPSDCWorkspaceId(this.getId());
            psWorkspaceSumService.fillEntityKeyValue(psWorkspaceSum);
            if (!psWorkspaceSumService.get(psWorkspaceSum, true) || DataObject.getIntegerValue((Object)psWorkspaceSum.getValue(), (Integer)0) + nAmount2 <= nLimit) continue;
            if (bTryMode) {
                return false;
            }
            String strErrorInfo = StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%5$s]%2$s\u5141\u8bb8[%1$s]\u6570\u91cf[%3$s]\uff0c\u5f53\u524d\u6570\u91cf[%4$s]", (Object)strActionName, (Object)SUMGROUPNAMEMAP.get(entry.getKey()), (Object)nLimit, (Object)psWorkspaceSum.getValue(), (Object)this.getName());
            throw new PSActionLimitException(strAction2, nLimit, strErrorInfo);
        }
        return true;
    }

    @Override
    public void logAction(String strActionCat, String strActionType, String strActionTag, int nAmount) {
        final Date curDate = new Date(System.currentTimeMillis());
        String strAction = StringHelper.Format((String)"%1$s|%2$s", (Object)strActionCat, (Object)strActionType);
        String strAction2 = REALTASKMAP.get(strAction);
        if (StringHelper.IsNullOrEmpty((String)strAction2)) {
            strAction2 = strAction;
        }
        try {
            int nExp = 0;
            IPSRobotWorkType iPSRobotWorkType = this.getPSModelStorage().getPSRobotWorkType(strAction, true);
            if (iPSRobotWorkType != null) {
                nExp = iPSRobotWorkType.getEnergy() / 10;
            }
            if (nExp == 0) {
                nExp = 20;
            }
            final PSWorkspaceSumService psWorkspaceSumService = (PSWorkspaceSumService)ServiceGlobal.getService(PSWorkspaceSumService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            final PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            final String strPSWorkspaceId2 = this.strPSWorkspaceId;
            final int nExp2 = nExp;
            final String strAction3 = strAction2;
            final String strWorkspaceType2 = this.psDCWorkspace.getWORKSPACETYPE();
            final PSDCWorkspace psDCWorkspace2 = this.psDCWorkspace;
            final IPSWorkspaceType iPSWorkspaceType2 = this.iPSWorkspaceType;
            final int nAmount2 = nAmount;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    for (Map.Entry entry : SUMGROUPMAP.entrySet()) {
                        int nLimit;
                        String strTag = strAction3;
                        if (!StringHelper.IsNullOrEmpty((String)((String)entry.getKey()))) {
                            strTag = StringHelper.Format((String)"%1$s.%2$s", (Object)strTag, entry.getKey());
                        }
                        if ((nLimit = iPSWorkspaceType2.getUserParam(strTag, -1)) == -1) continue;
                        String strSumTag = StringHelper.Format((String)((String)entry.getValue()), (Object)curDate);
                        PSWorkspaceSum psWorkspaceSum = new PSWorkspaceSum();
                        psWorkspaceSum.setPSWorkspaceId(strPSWorkspaceId2);
                        psWorkspaceSum.setSumType(strAction3);
                        psWorkspaceSum.setSumTag(strSumTag);
                        psWorkspaceSum.setSumTag2(null);
                        psWorkspaceSum.setPSDCWorkspaceId(PSDCWorkspaceImpl.this.getId());
                        psWorkspaceSumService.fillEntityKeyValue(psWorkspaceSum);
                        int nTotal = nAmount2;
                        if (psWorkspaceSumService.get(psWorkspaceSum, true)) {
                            psWorkspaceSum.setValue(Integer.valueOf(nTotal += DataObject.getIntegerValue((Object)psWorkspaceSum.getValue(), (Integer)0).intValue()));
                            psWorkspaceSumService.update(psWorkspaceSum, false);
                            continue;
                        }
                        psWorkspaceSum.setPSWorkspaceName(PSDCWorkspaceImpl.this.getName());
                        psWorkspaceSum.setPSWorkspaceSumName(StringHelper.Format((String)"%1$s[%2$s][%3$s]", (Object)PSDCWorkspaceImpl.this.getName(), (Object)strAction3, (Object)strSumTag));
                        psWorkspaceSum.setValue(Integer.valueOf(nTotal));
                        psWorkspaceSumService.create(psWorkspaceSum, false);
                    }
                    PSWorkspace psWorkspace = new PSWorkspace();
                    psWorkspace.setPSWorkspaceId(strPSWorkspaceId2);
                    if (psWorkspaceService.get(psWorkspace, true)) {
                        long nTotal = (long)nExp2 + DataObject.getLongValue((Object)psWorkspace.getExp(), (Long)0L);
                        psWorkspace.reset();
                        psWorkspace.setPSWorkspaceId(strPSWorkspaceId2);
                        psWorkspace.setExp(Double.valueOf(Double.parseDouble(Long.toString(nTotal))));
                        boolean bUpdateLevel = false;
                        if (PSDCWorkspaceImpl.this.getWorkspaceLevel() > 0) {
                            String strWorkspaceType = StringHelper.Format((String)"%1$s__%2$s", (Object)strWorkspaceType2, (Object)(PSDCWorkspaceImpl.this.getWorkspaceLevel() + 1));
                            IPSWorkspaceType iPSWorkspaceType = PSDCWorkspaceImpl.this.getPSModelStorage().getPSWorkspaceType(strWorkspaceType, true);
                            if (iPSWorkspaceType != null && iPSWorkspaceType.getExp() > 0L && nTotal > iPSWorkspaceType.getExp()) {
                                psWorkspace.setWorkspaceLevel(Integer.valueOf(PSDCWorkspaceImpl.this.getWorkspaceLevel() + 1));
                                bUpdateLevel = true;
                            }
                        }
                        psWorkspaceService.update(psWorkspace);
                        if (bUpdateLevel) {
                            psDCWorkspace2.setWORKSPACELEVEL(psWorkspace.getWorkspaceLevel());
                            PSDCWorkspaceImpl.this.reloadPSDCWorkspace();
                        }
                    }
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u8bb0\u5f55\u751f\u4ea7\u7ebf\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    public int getWorkspaceLevel() {
        return this.nWorkspaceLevel;
    }

    @Override
    public Iterator<String> getEntities() {
        return this.iPSWorkspaceType.getEntities();
    }

    @Override
    public PSWorkspaceSum getAction(String strActionCat, String strActionType, String strActionTag) {
        return null;
    }

    @Override
    public boolean isBMode() {
        return this.iPSWorkspaceType.isBMode();
    }

    @Override
    public boolean isCMode() {
        return this.iPSWorkspaceType.isCMode();
    }

    @Override
    public boolean isTMode() {
        return this.iPSWorkspaceType.isTMode();
    }

    @Override
    public PSWorkspacePeriod calcPSWorkspacePeriod(Timestamp calcTime, boolean bNextValid) throws Exception {
        if (this.getResState() != 20) {
            throw new Exception(StringHelper.Format((String)"\u751f\u4ea7\u7ebf\u72b6\u6001\u672a\u5904\u4e8e[\u6b63\u5e38]\u72b6\u6001"));
        }
        if (calcTime == null) {
            calcTime = new Timestamp(System.currentTimeMillis());
        }
        if (this.isBMode()) {
            if (this.getExpiredTime() != null && this.getExpiredTime().getTime() < calcTime.getTime()) {
                return null;
            }
            PSWorkspacePeriod psWorkspacePeriod = new PSWorkspacePeriod();
            psWorkspacePeriod.setNextMode(false);
            psWorkspacePeriod.setBeginTime(calcTime);
            psWorkspacePeriod.setEndTime(this.getExpiredTime());
            return psWorkspacePeriod;
        }
        if (this.isTMode()) {
            if (this.getExpiredTime() != null) {
                if (this.getExpiredTime().getTime() < calcTime.getTime()) {
                    return null;
                }
                PSWorkspacePeriod psWorkspacePeriod = new PSWorkspacePeriod();
                psWorkspacePeriod.setNextMode(false);
                psWorkspacePeriod.setBeginTime(calcTime);
                psWorkspacePeriod.setEndTime(this.getExpiredTime());
                return psWorkspacePeriod;
            }
            return null;
        }
        if (this.isCMode()) {
            return this.iPSWorkspaceType.calcPSWorkspacePeriod(calcTime, bNextValid);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u751f\u4ea7\u7ebf\u7c7b\u578b"));
    }

    public String getWorkspaceMode() {
        return this.iPSWorkspaceType.getWorkspaceMode();
    }

    @Override
    public int getResState() {
        return this.nResState;
    }

    @Override
    public int getResPos() {
        return this.nResPos;
    }

    @Override
    public String getResCfgFilePath() {
        return null;
    }

    @Override
    public boolean isLocalRes() {
        return this.getResPos() == 1;
    }
}
