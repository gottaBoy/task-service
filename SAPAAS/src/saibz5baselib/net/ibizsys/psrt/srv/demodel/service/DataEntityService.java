/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.demodel.service;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.common.entity.UserRoleDataAction;
import net.ibizsys.psrt.srv.common.service.UserRoleDataActionService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataService;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class DataEntityService
extends DataEntityServiceBase {
    protected static String[] readOnlyActions = new String[]{"READ"};
    protected static String[] readWriteActions = new String[]{"READ", "CREATE", "UPDATE", "DELETE", "WFSTART"};
    protected static int URD_ALL = 0;
    protected static int URD_ORG = 1;
    protected static int URD_SECTOR = 2;
    protected static int URD_USER = 3;
    protected static int UDR_DR_CUR = 1;
    protected static int UDR_DR_SUP = 2;
    protected static int UDR_DR_SUB = 4;
    protected static int UDR_ACTION_READONLY = 1;
    protected static int UDR_ACTION_READWRITE = 2;
    private static final Log log = LogFactory.getLog(DataEntityService.class);

    @Override
    protected void onInitAll(DataEntity dataEntity) throws Exception {
        this.initUserRoleData(dataEntity);
    }

    @Override
    protected void onInitUserRoleData(DataEntity dataEntity) throws Exception {
        if (!dataEntity.isFullEntity()) {
            this.get(dataEntity);
        }
        this.addUserRoleData(dataEntity, "ALL_R", "[%1$s]\u5168\u90e8\u6570\u636e[\u53ea\u8bfb]", URD_ALL, 0, UDR_ACTION_READONLY);
        this.addUserRoleData(dataEntity, "ALL_RW", "[%1$s]\u5168\u90e8\u6570\u636e[\u8bfb\u5199]", URD_ALL, 0, UDR_ACTION_READWRITE);
        this.addUserRoleData(dataEntity, "CURORG_R", "[%1$s]\u5f53\u524d\u673a\u6784[\u53ea\u8bfb]", URD_ORG, UDR_DR_CUR, UDR_ACTION_READONLY);
        this.addUserRoleData(dataEntity, "CURORG_RW", "[%1$s]\u5f53\u524d\u673a\u6784[\u8bfb\u5199]", URD_ORG, UDR_DR_CUR, UDR_ACTION_READWRITE);
        this.addUserRoleData(dataEntity, "SUBORG_R", "[%1$s]\u4e0b\u7ea7\u673a\u6784[\u53ea\u8bfb]", URD_ORG, UDR_DR_SUB, UDR_ACTION_READONLY);
        this.addUserRoleData(dataEntity, "SUBORG_RW", "[%1$s]\u4e0b\u7ea7\u673a\u6784[\u8bfb\u5199]", URD_ORG, UDR_DR_SUB, UDR_ACTION_READWRITE);
        this.addUserRoleData(dataEntity, "CURSEC_R", "[%1$s]\u5f53\u524d\u90e8\u95e8[\u53ea\u8bfb]", URD_SECTOR, UDR_DR_CUR, UDR_ACTION_READONLY);
        this.addUserRoleData(dataEntity, "CURSEC_RW", "[%1$s]\u5f53\u524d\u90e8\u95e8[\u8bfb\u5199]", URD_SECTOR, UDR_DR_CUR, UDR_ACTION_READWRITE);
        this.addUserRoleData(dataEntity, "SUBSEC_R", "[%1$s]\u4e0b\u7ea7\u90e8\u95e8[\u53ea\u8bfb]", URD_SECTOR, UDR_DR_SUB, UDR_ACTION_READONLY);
        this.addUserRoleData(dataEntity, "SUBSEC_RW", "[%1$s]\u4e0b\u7ea7\u90e8\u95e8[\u8bfb\u5199]", URD_SECTOR, UDR_DR_SUB, UDR_ACTION_READWRITE);
        this.addUserRoleData(dataEntity, "CURUSER_RW", "[%1$s]\u5f53\u524d\u7528\u6237[\u8bfb\u5199]", URD_USER, UDR_DR_CUR, UDR_ACTION_READWRITE);
    }

    protected void addUserRoleData(DataEntity dataEntity, String strURDId, String strURDName, int nURD, int nURDDR, int nURDAction) throws Exception {
        UserRoleDataService userRoleDataService = (UserRoleDataService)ServiceGlobal.getService(UserRoleDataService.class);
        UserRoleDataActionService userRoleDataActionService = (UserRoleDataActionService)ServiceGlobal.getService(UserRoleDataActionService.class);
        UserRoleData userRoleData = new UserRoleData();
        userRoleData.setDEId(dataEntity.getDEId());
        userRoleData.setUserRoleDataId(KeyValueHelper.genUniqueId(dataEntity.getDEId(), strURDId));
        if (userRoleDataService.checkKey(userRoleData) == 0) {
            userRoleData.setUserRoleDataName(StringHelper.format(strURDName, dataEntity.getDELogicName()));
            if (nURD == URD_ALL) {
                userRoleData.setIsAllData(1);
            } else if (nURD == URD_ORG) {
                userRoleData.setOrgDR(nURDDR);
                userRoleData.setIsAllData(0);
            } else if (nURD == URD_SECTOR) {
                userRoleData.setSecDR(nURDDR);
                userRoleData.setIsAllData(0);
            } else if (nURD == URD_USER) {
                userRoleData.setUserDR(nURDDR);
                userRoleData.setIsAllData(0);
            } else {
                return;
            }
            userRoleData.setUDVersion(1);
            userRoleData.setDEName(dataEntity.getDEName());
            userRoleDataService.create(userRoleData, false);
            String[] actions = null;
            if (nURDAction == UDR_ACTION_READONLY) {
                actions = readOnlyActions;
            } else if (nURDAction == UDR_ACTION_READWRITE) {
                actions = readWriteActions;
            } else {
                return;
            }
            String[] stringArray = actions;
            int n = actions.length;
            int n2 = 0;
            while (n2 < n) {
                String strAction = stringArray[n2];
                UserRoleDataAction userRoleDataAction = new UserRoleDataAction();
                userRoleDataAction.setIsAllow(1);
                userRoleDataAction.setUserRoleDataId(userRoleData.getUserRoleDataId());
                userRoleDataAction.setUserRoleDataName(userRoleData.getUserRoleDataName());
                userRoleDataAction.setUserRoleDataActionName(strAction);
                userRoleDataActionService.create(userRoleDataAction, false);
                ++n2;
            }
        }
    }
}

