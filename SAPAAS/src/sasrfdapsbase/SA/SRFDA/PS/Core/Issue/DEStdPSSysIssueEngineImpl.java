/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue
 */
package SA.SRFDA.PS.Core.Issue;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERInherit;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Issue.PSSysIssueEngineImplBase;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue;

public class DEStdPSSysIssueEngineImpl
extends PSSysIssueEngineImplBase {
    @Override
    public void checkPSSystem(IPSSystem iPSSystem) throws Exception {
        Iterator<IPSDataEntity> psDataEntities = iPSSystem.getAllPSDataEntities();
        while (psDataEntities.hasNext()) {
            this.checkPSDataEntity(iPSSystem, psDataEntities.next());
        }
    }

    @Override
    public int getCheckLevel() {
        return 0;
    }

    protected void checkPSDataEntity(IPSSystem iPSSystem, IPSDataEntity iPSDataEntity) throws Exception {
        Iterator<IPSDERBase> psDERs;
        IPSDEField iPSDEField;
        PSSysIssue psSysIssue;
        if (iPSDataEntity.getKeyPSDEField() == null) {
            psSysIssue = new PSSysIssue();
            psSysIssue.setPSSysIssueTypeId("1000001");
            psSysIssue.setObjType("PSDATAENTITY");
            psSysIssue.setPSObjId(iPSDataEntity.getId());
            psSysIssue.setPSObjName(iPSDataEntity.getName());
            this.logPSSysIssue(psSysIssue, iPSSystem, iPSDataEntity, null);
        }
        if (iPSDataEntity.getMajorPSDEField() == null && !iPSDataEntity.isExistingModel() && iPSDataEntity.getPSSubSysServiceAPIDE() == null) {
            psSysIssue = new PSSysIssue();
            psSysIssue.setPSSysIssueTypeId("1000002");
            psSysIssue.setObjType("PSDATAENTITY");
            psSysIssue.setPSObjId(iPSDataEntity.getId());
            psSysIssue.setPSObjName(iPSDataEntity.getName());
            this.logPSSysIssue(psSysIssue, iPSSystem, iPSDataEntity, null);
        }
        if (iPSDataEntity.isLogicValid() && (iPSDEField = iPSDataEntity.getPSDEFieldByPDT("LOGICVALID", true)) == null) {
            PSSysIssue psSysIssue2 = new PSSysIssue();
            psSysIssue2.setPSSysIssueTypeId("1000003");
            psSysIssue2.setObjType("PSDATAENTITY");
            psSysIssue2.setPSObjId(iPSDataEntity.getId());
            psSysIssue2.setPSObjName(iPSDataEntity.getName());
            this.logPSSysIssue(psSysIssue2, iPSSystem, iPSDataEntity, null);
        }
        if (!StringHelper.isNullOrEmpty((String)iPSDataEntity.getIndexDEType()) && iPSDataEntity.getIndexTypePSDEField() == null) {
            psSysIssue = new PSSysIssue();
            psSysIssue.setPSSysIssueTypeId("1000004");
            psSysIssue.setObjType("PSDATAENTITY");
            psSysIssue.setPSObjId(iPSDataEntity.getId());
            psSysIssue.setPSObjName(iPSDataEntity.getName());
            this.logPSSysIssue(psSysIssue, iPSSystem, iPSDataEntity, null);
        }
        if (iPSDataEntity.isEnableMultiForm() && iPSDataEntity.getFormTypePSDEField() == null) {
            psSysIssue = new PSSysIssue();
            psSysIssue.setPSSysIssueTypeId("1000005");
            psSysIssue.setObjType("PSDATAENTITY");
            psSysIssue.setPSObjId(iPSDataEntity.getId());
            psSysIssue.setPSObjName(iPSDataEntity.getName());
            this.logPSSysIssue(psSysIssue, iPSSystem, iPSDataEntity, null);
        }
        if ((psDERs = iPSDataEntity.getPSDERs(false)) != null) {
            PSSysIssue psSysIssue3;
            int nInheritCount = 0;
            int nAttachedAcc = 0;
            while (psDERs.hasNext()) {
                IPSDERCustom iPSDERCustom;
                IPSDERBase iPSDER = psDERs.next();
                if (iPSDER instanceof IPSDERInherit) {
                    IPSDERInherit iPSDERInherit = (IPSDERInherit)iPSDER;
                    if (!iPSDERInherit.isSingleInherit()) continue;
                    ++nInheritCount;
                    continue;
                }
                if (iPSDER instanceof IPSDER1N) {
                    IPSPickupDEField iPSDEField2;
                    IPSDER1N iPSDER1N = (IPSDER1N)iPSDER;
                    if ((iPSDER1N.getMasterRS() & 4) > 0) {
                        ++nAttachedAcc;
                    }
                    if ((iPSDEField2 = iPSDataEntity.getPSPickupDEField(iPSDER.getId())) != null) continue;
                    PSSysIssue psSysIssue4 = new PSSysIssue();
                    psSysIssue4.setPSSysIssueTypeId("1000006");
                    psSysIssue4.setObjType("PSDER");
                    psSysIssue4.setPSObjId(iPSDER.getId());
                    psSysIssue4.setPSObjName(iPSDER.getName());
                    this.logPSSysIssue(psSysIssue4, iPSSystem, iPSDataEntity, null);
                    continue;
                }
                if (!(iPSDER instanceof IPSDERCustom) || !"DER1N".equals((iPSDERCustom = (IPSDERCustom)iPSDER).getDERSubType()) && !"DER11".equals(iPSDERCustom.getDERSubType()) || (iPSDERCustom.getMasterRS() & 4) <= 0) continue;
                ++nAttachedAcc;
            }
            if (nInheritCount >= 2) {
                psSysIssue3 = new PSSysIssue();
                psSysIssue3.setPSSysIssueTypeId("1000007");
                psSysIssue3.setObjType("PSDATAENTITY");
                psSysIssue3.setPSObjId(iPSDataEntity.getId());
                psSysIssue3.setPSObjName(iPSDataEntity.getName());
                this.logPSSysIssue(psSysIssue3, iPSSystem, iPSDataEntity, null);
            }
            if (iPSDataEntity.getDataAccCtrlMode() == 2 && nAttachedAcc == 0 && iPSDataEntity.getDEType() != 4) {
                psSysIssue3 = new PSSysIssue();
                psSysIssue3.setPSSysIssueTypeId("1000009");
                psSysIssue3.setObjType("PSDATAENTITY");
                psSysIssue3.setPSObjId(iPSDataEntity.getId());
                psSysIssue3.setPSObjName(iPSDataEntity.getName());
                this.logPSSysIssue(psSysIssue3, iPSSystem, iPSDataEntity, null);
            }
        }
        if (iPSDataEntity.hasPSDEViewBase()) {
            Iterator<IPSDEField> psDEFields = iPSDataEntity.getPSDEFields();
            while (psDEFields.hasNext()) {
                IPSDEField iPSDEField3 = psDEFields.next();
                try {
                    iPSDEField3.getPSDEFUIMode("DEFAULT");
                }
                catch (Exception ex) {
                    PSSysIssue psSysIssue5 = new PSSysIssue();
                    psSysIssue5.setPSSysIssueTypeId("1000011");
                    psSysIssue5.setObjType("PSDEFIELD");
                    psSysIssue5.setPSObjId(iPSDEField3.getId());
                    psSysIssue5.setPSObjName(iPSDEField3.getName());
                    this.logPSSysIssue(psSysIssue5, iPSSystem, iPSDataEntity, null);
                }
            }
        }
    }
}

