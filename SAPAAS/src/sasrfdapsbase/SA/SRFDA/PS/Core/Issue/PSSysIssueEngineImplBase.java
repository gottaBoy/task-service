/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Issue;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.Issue.IPSSysIssueEngine;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSysIssueEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public abstract class PSSysIssueEngineImplBase
extends PSObjectImpl
implements IPSSysIssueEngine {
    public static final String E_1000001 = "1000001";
    public static final String E_1000002 = "1000002";
    public static final String E_1000003 = "1000003";
    public static final String E_1000004 = "1000004";
    public static final String E_1000005 = "1000005";
    public static final String E_1000006 = "1000006";
    public static final String E_1000007 = "1000007";
    public static final String E_1000008 = "1000008";
    public static final String E_1000009 = "1000009";
    public static final String E_1000010 = "1000010";
    public static final String E_1000011 = "1000011";
    private PSSysIssueEngine psSysIssueEngine = null;
    private static HashMap<String, String> issueMap = new HashMap();

    static {
        issueMap.put(E_1000001, "\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u4e3b\u952e\u5c5e\u6027");
        issueMap.put(E_1000002, "\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u4e3b\u6587\u672c\u5c5e\u6027");
        issueMap.put(E_1000003, "\u5b9e\u4f53\u542f\u7528\u903b\u8f91\u6709\u6548\uff0c\u6ca1\u6709\u5b9a\u4e49\u903b\u8f91\u6709\u6548\u5c5e\u6027");
        issueMap.put(E_1000004, "\u5b9e\u4f53\u542f\u7528\u7d22\u5f15\u6216\u7ee7\u627f\uff0c\u6ca1\u6709\u5b9a\u4e49\u7d22\u5f15\u5c5e\u6027");
        issueMap.put(E_1000005, "\u5b9e\u4f53\u542f\u7528\u591a\u8868\u5355\uff0c\u6ca1\u6709\u5b9a\u4e49\u591a\u8868\u5355\u5c5e\u6027");
        issueMap.put(E_1000006, "\u5b9e\u4f531:N\u5173\u7cfb\u6ca1\u6709\u5b9a\u4e49\u8fde\u63a5\u5c5e\u6027");
        issueMap.put(E_1000007, "\u5b9e\u4f53\u5b58\u5728\u591a\u4e2a\u7ee7\u627f\u5173\u7cfb\uff0c\u4e00\u4e2a\u5b9e\u4f53\u53ea\u80fd\u5b58\u5728\u4e00\u4e2a\u7ee7\u627f\u5173\u7cfb");
        issueMap.put(E_1000008, "\u5b9e\u4f53\u7ee7\u627f\u5173\u7cfb\u4e3b\u5b9e\u4f53\u7c7b\u578b\u4e0d\u662f\u7ee7\u627f\u4e3b\u5b9e\u4f53");
        issueMap.put(E_1000009, "\u5b9e\u4f53\u5b9a\u4e49\u6743\u9650\u53d7\u4e3b\u5b9e\u4f53\u63a7\u5236\uff0c\u5374\u6ca1\u6709\u57281:N\u5173\u7cfb\u4e2d\u5b9a\u4e49\u63a7\u5236\u5b9e\u4f53");
        issueMap.put(E_1000010, "\u5b9e\u4f53\u5b9a\u4e49\u4e3a\u5173\u7cfb\u5b9e\u4f53\uff0c\u5374\u6ca1\u6709\u5b9a\u4e492\u4e2a\u9644\u5c5e1:N\u5173\u7cfb");
        issueMap.put(E_1000011, "\u5b9e\u4f53\u5c5e\u6027\u6ca1\u6709\u5b9a\u4e49\u754c\u9762\u914d\u7f6e");
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSysIssueEngine psSysIssueEngine) throws Exception {
        this.psSysIssueEngine = psSysIssueEngine;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psSysIssueEngine.getPSSYSISSUEENGINEID());
        this.setName(psSysIssueEngine.getPSSYSISSUEENGINENAME());
        this.setPSObjectData(this.psSysIssueEngine);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected void logPSSysIssue(PSSysIssue psSysIssue, IPSSystem iPSSystem, IPSDataEntity iPSDataEntity, IPSApplication iPSApplication) throws Exception {
        String strIssueTypeName;
        psSysIssue.setPSSystemId(iPSSystem.getId());
        psSysIssue.setPSSystemName(iPSSystem.getName());
        psSysIssue.setPSDynaInstId(iPSSystem.getPSDynaInstId());
        if (iPSDataEntity != null) {
            psSysIssue.setPSDEId(iPSDataEntity.getId());
            psSysIssue.setPSDEName(iPSDataEntity.getName());
        }
        if (iPSApplication != null) {
            psSysIssue.setPSSysAppId(iPSApplication.getId());
            psSysIssue.setPSSysAppName(iPSApplication.getName());
        }
        if (StringHelper.isNullOrEmpty((String)(strIssueTypeName = issueMap.get(psSysIssue.getPSSysIssueTypeId())))) {
            strIssueTypeName = StringHelper.format((String)"\u672a\u77e5\u9519\u8bef\u4ee3\u7801[%1$s]", (Object)psSysIssue.getPSSysIssueTypeId());
        }
        psSysIssue.setPSSysIssueName(strIssueTypeName);
        PSSysIssueService psSysIssueService = (PSSysIssueService)ServiceGlobal.getService(PSSysIssueService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)((IPSSystemUtil)((Object)iPSSystem)).getRuntimePSSysModelInstId()));
        psSysIssueService.create((IEntity)psSysIssue, false);
        if (!StringHelper.isNullOrEmpty((String)iPSSystem.getPSDevSlnSysId()) && PSStudioConsoleHelper.getCurrent() != null) {
            StringBuilderEx sb = new StringBuilderEx();
            if (iPSDataEntity != null) {
                sb.append("[%1$s]", (Object)iPSDataEntity.getFullName());
            }
            sb.append(strIssueTypeName);
            String strContent = PSStudioConsoleHelper.getContent((String)StringHelper.format((String)"%1$s: %2$s", (Object)this.getName(), (Object)sb.toString()), (int)31, (int)-1, (int)0);
            PSStudioConsoleHelper.getCurrent().sendConsole(iPSSystem.getPSDevSlnSysId(), strContent, null);
        }
    }
}

