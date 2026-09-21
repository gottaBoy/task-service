/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util.CLI;

import SA.SRFDA.PS.Core.Util.CLI.PSStudioCLIHelperBase;
import SA.SRFDA.PS.Data.PSTaskServerCmd;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import org.hibernate.SessionFactory;

public class PSDevTemplCLIHelper
extends PSStudioCLIHelperBase {
    public static final String CMD_DEVTEMPL_CREATEPF = "devtempl_createpf";
    public static final String CMD_DEVTEMPL_CREATESF = "devtempl_createsf";
    public static final String CMD_DEVTEMPL_UPDATE = "devtempl_update";
    public static final String CMD_DEVTEMPL_PUBLISH = "devtempl_publish";
    public static final String CMD_DEVTEMPL_UPDATEREPO = "devtempl_updaterepo";

    @Override
    protected void registerDefault() {
        this.registerSlnCmdDataItems(CMD_DEVTEMPL_CREATEPF, new PSStudioCLIHelperBase.CLIDataItem[]{new PSStudioCLIHelperBase.CLIDataItem(this, "unitag", "PSDEVSLNTEMPLNAME", true, null), new PSStudioCLIHelperBase.CLIDataItem(this, "pf", "PSPFID", true, null), new PSStudioCLIHelperBase.CLIDataItem(this, "name", "LOGICNAME", false, null), new PSStudioCLIHelperBase.CLIDataItem(this, "memo", "MEMO", false, null), new PSStudioCLIHelperBase.CLIDataItem(this, null, "TEMPLTYPE", false, null, "PSPF")});
        this.registerSlnCmdDataItems(CMD_DEVTEMPL_CREATESF, new PSStudioCLIHelperBase.CLIDataItem[]{new PSStudioCLIHelperBase.CLIDataItem(this, "unitag", "PSDEVSLNTEMPLNAME", true, null), new PSStudioCLIHelperBase.CLIDataItem(this, "sf", "PSSFID", true, null), new PSStudioCLIHelperBase.CLIDataItem(this, "name", "LOGICNAME", false, null), new PSStudioCLIHelperBase.CLIDataItem(this, "memo", "MEMO", false, null), new PSStudioCLIHelperBase.CLIDataItem(this, null, "TEMPLTYPE", false, null, "PSSF")});
        this.registerTemplCmdDataItems(CMD_DEVTEMPL_PUBLISH, new PSStudioCLIHelperBase.CLIDataItem[0]);
        this.registerTemplCmdDataItems(CMD_DEVTEMPL_UPDATEREPO, new PSStudioCLIHelperBase.CLIDataItem[]{new PSStudioCLIHelperBase.CLIDataItem(this, null, "SVNTYPE", false, null, "GIT"), new PSStudioCLIHelperBase.CLIDataItem(this, "repo", "GITREPO", false, null, "GITEE"), new PSStudioCLIHelperBase.CLIDataItem(this, "url", "GITPATH", true, null), new PSStudioCLIHelperBase.CLIDataItem(this, "memo", "MEMO", false, null)});
        super.registerDefault();
    }

    @Override
    protected void onExecute(String strCmd, Map<String, Object> paramMap, ObjectNode objectNode, PSTaskServerCmd psTaskServerCmd) throws Exception {
        if (CMD_DEVTEMPL_CREATEPF.equals(strCmd) || CMD_DEVTEMPL_CREATESF.equals(strCmd)) {
            PSDevSlnTempl psDevSlnTempl = new PSDevSlnTempl();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                psDevSlnTempl.set(entry.getKey(), entry.getValue());
            }
            psDevSlnTempl.setPSDevCenterId(psTaskServerCmd.getPSDEVCENTERID());
            psDevSlnTempl.setPSDevCenterName(psTaskServerCmd.getPSDEVCENTERNAME());
            psDevSlnTempl.setPSDevSlnId(psTaskServerCmd.getPSDEVSLNID());
            psDevSlnTempl.setPSDevSlnName(psTaskServerCmd.getPSDEVSLNNAME());
            try {
                PSDevSlnTemplService psDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psDevSlnTemplService.create((IEntity)psDevSlnTempl);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u5efa\u7acb\u5f00\u53d1\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            return;
        }
        if (CMD_DEVTEMPL_PUBLISH.equals(strCmd)) {
            PSDevSlnTempl psDevSlnTempl = new PSDevSlnTempl();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                psDevSlnTempl.set(entry.getKey(), entry.getValue());
            }
            psDevSlnTempl.setPSDevSlnTemplId(psTaskServerCmd.getPSDEVSLNTEMPLID());
            try {
                PSDevSlnTemplService psDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psDevSlnTemplService.pubTempl(psDevSlnTempl);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u53d1\u5e03\u5f00\u53d1\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            return;
        }
        if (CMD_DEVTEMPL_UPDATEREPO.equals(strCmd)) {
            boolean bNew;
            int nResPos;
            PSDevSlnTempl psDevSlnTempl = new PSDevSlnTempl();
            psDevSlnTempl.setPSDevSlnTemplId(psTaskServerCmd.getPSDEVSLNTEMPLID());
            PSDevSlnTemplService psDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevCenterSVNService psDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            try {
                psDevSlnTemplService.get((IEntity)psDevSlnTempl);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u83b7\u53d6\u5f00\u53d1\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            PSDevCenterSVN psDevCenterSVN = psDevSlnTempl.getPSDevCenterSVN();
            if (psDevCenterSVN != null && (nResPos = DataObject.getIntegerValue((Object)psDevCenterSVN.getResPos(), (Integer)1).intValue()) != 2) {
                psDevCenterSVN = null;
            }
            boolean bl = bNew = psDevCenterSVN == null;
            if (psDevCenterSVN == null) {
                psDevCenterSVN = new PSDevCenterSVN();
                psDevCenterSVN.setPSDevCenterId(psTaskServerCmd.getPSDEVCENTERID());
                if (CMD_DEVTEMPL_UPDATEREPO.equals(strCmd)) {
                    psDevCenterSVN.setPSDevCenterSVNName(String.format("\u5f00\u53d1\u6a21\u677f[%1$s]\u4ee3\u7801\u4ed3\u5e93", psDevSlnTempl.getPSDevSlnTemplName()));
                }
                psDevCenterSVN.setResPos(Integer.valueOf(2));
                psDevCenterSVN.setRefFlag(Integer.valueOf(1));
                psDevCenterSVN.setResState(Integer.valueOf(20));
            }
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                psDevCenterSVN.set(entry.getKey(), entry.getValue());
            }
            try {
                if (bNew) {
                    psDevCenterSVNService.create((IEntity)psDevCenterSVN);
                } else {
                    psDevCenterSVNService.update((IEntity)psDevCenterSVN);
                }
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u66f4\u65b0\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            try {
                psDevSlnTempl.setPSDevCenterSVNId(psDevCenterSVN.getPSDevCenterSVNId());
                psDevSlnTemplService.update(psDevSlnTempl, false);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u66f4\u65b0\u5f00\u53d1\u6a21\u677f\u4ed3\u5e93\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            return;
        }
        super.onExecute(strCmd, paramMap, objectNode, psTaskServerCmd);
    }
}

