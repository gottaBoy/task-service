/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDEFieldDiffItem
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffItem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffItemService
 *  net.ibizsys.pscore.srv.util.PSDCInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.IPSModelDiffActionContext;
import SA.SRFDA.PS.Core.IPSModelDiffable;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDevSysDiffRep;
import java.util.ArrayList;
import net.ibizsys.paas.data.IDEFieldDiffItem;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffItemService;
import net.ibizsys.pscore.srv.util.PSDCInstGlobal;
import org.hibernate.SessionFactory;

public class PSModelDiffActionContextImpl
implements IPSModelDiffActionContext {
    private String strPSSysModelInstId = null;
    private String strPSDCInstId = null;
    private PSDevSysDiffRep psDevSysDiffRep = null;
    private PSDevSysDiffItemService psDevSysDiffItemService = null;
    private String strPSDevSysDiffRepId = null;
    private String strPSDevSysDiffRepName = null;

    public PSModelDiffActionContextImpl(PSDevSysDiffRep psDevSysDiffRep) throws Exception {
        this.strPSSysModelInstId = psDevSysDiffRep.getParamStringValue("PSSYSMODELINSTID", "");
        this.strPSDCInstId = psDevSysDiffRep.getParamStringValue("PSDCINSTID", "");
        this.psDevSysDiffRep = psDevSysDiffRep;
        this.psDevSysDiffItemService = (PSDevSysDiffItemService)ServiceGlobal.getService(PSDevSysDiffItemService.class, (SessionFactory)PSDCInstGlobal.getSessionFactory((String)this.strPSDCInstId));
        this.strPSDevSysDiffRepId = this.psDevSysDiffRep.getPSDEVSYSDIFFREPID();
        this.strPSDevSysDiffRepName = this.psDevSysDiffRep.getPSDEVSYSDIFFREPNAME();
    }

    @Override
    public void addDiffItem(SA.SRFDA.PS.Data.PSDevSysDiffItem psDevSysDiffItem, IPSModelDiffable iPSModelDiffable, ArrayList<IDEFieldDiffItem> deFieldDiffItemList) throws Exception {
        PSDevSysDiffItem psDevSysDiffItem2 = new PSDevSysDiffItem();
        if (psDevSysDiffItem != null) {
            PSDEDataCtrl.convertEntity2(psDevSysDiffItem, (IEntity)psDevSysDiffItem2);
        } else if (deFieldDiffItemList != null && deFieldDiffItemList.size() > 0) {
            psDevSysDiffItem2.setDiffType("NOTMATCH");
        }
        psDevSysDiffItem2.setPSDevSysDiffRepId(this.strPSDevSysDiffRepId);
        psDevSysDiffItem2.setPSDevSysDiffRepName(this.strPSDevSysDiffRepName);
        if (psDevSysDiffItem2.getSyncAction() == null) {
            psDevSysDiffItem2.setSyncAction("NONE");
        }
        if (iPSModelDiffable != null) {
            IPSApplicationObject iPSApplicationObject;
            IPSApplication iPSApplication;
            IPSDataEntityObject iPSDataEntityObject;
            IPSDataEntity iPSDataEntity;
            if (psDevSysDiffItem2.getObjType() == null) {
                psDevSysDiffItem2.setObjType(iPSModelDiffable.getModelType());
            }
            if (psDevSysDiffItem2.getPSObjId() == null) {
                psDevSysDiffItem2.setPSObjId(iPSModelDiffable.getId());
            }
            if (psDevSysDiffItem2.getPSObjName() == null) {
                psDevSysDiffItem2.setPSObjName(iPSModelDiffable.getName());
            }
            if (psDevSysDiffItem2.getPSDEId() == null && iPSModelDiffable instanceof IPSDataEntityObject && (iPSDataEntity = (iPSDataEntityObject = (IPSDataEntityObject)((Object)iPSModelDiffable)).getPSDataEntity()) != null) {
                psDevSysDiffItem2.setPSDEId(iPSDataEntity.getId());
                psDevSysDiffItem2.setPSDEName(iPSDataEntity.getName());
            }
            if (psDevSysDiffItem2.getPSSysAppId() == null && iPSModelDiffable instanceof IPSApplicationObject && (iPSApplication = (iPSApplicationObject = (IPSApplicationObject)((Object)iPSModelDiffable)).getPSApplication()) != null) {
                psDevSysDiffItem2.setPSSysAppId(iPSApplication.getId());
                psDevSysDiffItem2.setPSSysAppName(iPSApplication.getName());
            }
        }
        if (deFieldDiffItemList != null && deFieldDiffItemList.size() > 0) {
            boolean bFirst = true;
            StringBuilderEx info = new StringBuilderEx();
            for (IDEFieldDiffItem iDEFieldDiffItem : deFieldDiffItemList) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    info.append("\r\n");
                }
                if (iDEFieldDiffItem.getDEField() != null) {
                    String strAuditInfoFormat = iDEFieldDiffItem.getDEField().getAuditInfoFormat();
                    info.append(strAuditInfoFormat, (Object)iDEFieldDiffItem.getDEField().getLogicName(""), (Object)iDEFieldDiffItem.getOldText(), (Object)iDEFieldDiffItem.getNewText());
                    continue;
                }
                info.append(iDEFieldDiffItem.getDiffInfo());
            }
            String strInfo = info.toString();
            if (strInfo.length() > 2000) {
                strInfo = strInfo.substring(0, 1990);
                strInfo = String.valueOf(strInfo) + "...";
            }
            psDevSysDiffItem2.setMemo(strInfo);
        }
        this.psDevSysDiffItemService.create(psDevSysDiffItem2, false);
    }

    @Override
    public void addDiffItem(SA.SRFDA.PS.Data.PSDevSysDiffItem psDevSysDiffItem, IPSModelDiffable iPSModelDiffable) throws Exception {
        this.addDiffItem(psDevSysDiffItem, iPSModelDiffable, null);
    }
}
