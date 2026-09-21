/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util.CLI;

import SA.SRFDA.PS.Core.Util.CLI.PSStudioCLIHelperBase;
import SA.SRFDA.PS.Data.PSTaskServerCmd;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Map;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import org.hibernate.SessionFactory;

public class PSDevSlnCLIHelper
extends PSStudioCLIHelperBase {
    public static final String CMD_DEVSLN_CREATE = "devsln_create";
    public static final String CMD_DEVSLN_UPDATE = "devsln_update";
    public static final String CMD_DEVSLN_ASSIGNWORKSPACE = "devsln_assignworkspace";

    @Override
    protected void registerDefault() {
        this.registerDCCmdDataItems(CMD_DEVSLN_CREATE, new PSStudioCLIHelperBase.CLIDataItem[]{new PSStudioCLIHelperBase.CLIDataItem(this, "codename", "CODENAME", true, null), new PSStudioCLIHelperBase.CLIDataItem(this, "name", "PSDEVSLNNAME", true, null), new PSStudioCLIHelperBase.CLIDataItem(this, "memo", "MEMO", false, null)});
        this.registerDCCmdDataItems(CMD_DEVSLN_ASSIGNWORKSPACE, new PSStudioCLIHelperBase.CLIDataItem[]{new PSStudioCLIHelperBase.CLIDataItem(this, "workspace", "PSDCWORKSPACEID", true, null)});
        this.registerSlnCmdDataItems(CMD_DEVSLN_UPDATE, new PSStudioCLIHelperBase.CLIDataItem[]{new PSStudioCLIHelperBase.CLIDataItem(this, "name", "PSDEVSLNNAME", true, null), new PSStudioCLIHelperBase.CLIDataItem(this, "memo", "MEMO", false, null)});
        super.registerDefault();
    }

    @Override
    protected void onExecute(String strCmd, Map<String, Object> paramMap, ObjectNode objectNode, PSTaskServerCmd psTaskServerCmd) throws Exception {
        if (CMD_DEVSLN_CREATE.equals(strCmd)) {
            PSDevSln psDevSln = new PSDevSln();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                psDevSln.set(entry.getKey(), entry.getValue());
            }
            psDevSln.setPSDevCenterId(psTaskServerCmd.getPSDEVCENTERID());
            psDevSln.setPSDevCenterName(psTaskServerCmd.getPSDEVCENTERNAME());
            PSDevSlnService psDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            try {
                psDevSlnService.create((IEntity)psDevSln);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u5efa\u7acb\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            return;
        }
        if (CMD_DEVSLN_ASSIGNWORKSPACE.equals(strCmd)) {
            this.onAssignWorkspace(paramMap, objectNode, psTaskServerCmd);
            return;
        }
        super.onExecute(strCmd, paramMap, objectNode, psTaskServerCmd);
    }

    protected void onAssignWorkspace(Map<String, Object> paramMap, ObjectNode objectNode, PSTaskServerCmd psTaskServerCmd) throws Exception {
        String strPSDCWorkspaceName = (String)paramMap.get("PSDCWORKSPACEID");
        PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
        PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        try {
            psDCWorkspace.setPSDevCenterId(psTaskServerCmd.getPSDEVCENTERID());
            psDCWorkspace.setPSDCWorkspaceId(strPSDCWorkspaceName);
            if (!psDCWorkspaceService.select((IEntity)psDCWorkspace, true)) {
                psDCWorkspace.reset();
                psDCWorkspace.setPSDevCenterId(psTaskServerCmd.getPSDEVCENTERID());
                psDCWorkspace.setPSDCWorkspaceName(strPSDCWorkspaceName);
                if (!psDCWorkspaceService.select((IEntity)psDCWorkspace, true)) {
                    throw new Exception("\u6570\u636e\u4e0d\u5b58\u5728");
                }
            }
        }
        catch (Exception ex) {
            throw new Exception(String.format("\u83b7\u53d6\u751f\u4ea7\u7ebf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strPSDCWorkspaceName, ex.getMessage()));
        }
        try {
            PSDCWorkspace psDCWorkspace2 = new PSDCWorkspace();
            psDCWorkspace2.setPSDCWorkspaceId(psDCWorkspace.getPSDCWorkspaceId());
            psDCWorkspace2.setPSDevSlnId(psTaskServerCmd.getPSDEVSLNID());
            psDCWorkspace2.setPSDevSlnName(psTaskServerCmd.getPSDEVSLNNAME());
            psDCWorkspaceService.assign(psDCWorkspace2);
        }
        catch (Exception ex) {
            throw new Exception(String.format("\u5206\u914d\u751f\u4ea7\u7ebf[%1$s]\u5230\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strPSDCWorkspaceName, ex.getMessage()));
        }
    }
}

