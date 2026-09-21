/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.common.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSecUser;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.UserGroup;
import net.ibizsys.psrt.srv.common.entity.UserGroupDetail;
import net.ibizsys.psrt.srv.common.service.OrgSecUserService;
import net.ibizsys.psrt.srv.common.service.OrgSectorService;
import net.ibizsys.psrt.srv.common.service.OrgServiceBase;
import net.ibizsys.psrt.srv.common.service.UserGroupDetailService;
import net.ibizsys.psrt.srv.common.service.UserGroupService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class OrgService
extends OrgServiceBase {
    private static final Log log = LogFactory.getLog(OrgService.class);

    @Override
    protected void onInitAll(Org org) throws Exception {
        this.initUserObject(org);
    }

    @Override
    protected void onInitUserObject(Org org) throws Exception {
        if (!org.isFullEntity()) {
            this.get(org);
        }
        UserGroupService userGroupService = (UserGroupService)ServiceGlobal.getService(UserGroupService.class);
        UserGroupDetailService userGroupDetailService = (UserGroupDetailService)ServiceGlobal.getService(UserGroupDetailService.class);
        UserGroup userGroup = new UserGroup();
        userGroup.setUserGroupId(org.getOrgId());
        if (userGroupService.checkKey(userGroup) == 0) {
            userGroup.setUserGroupName(StringHelper.format("[\u673a\u6784]%1$s", org.getOrgName()));
            userGroup.setSubType("ORG");
            userGroupService.create(userGroup);
        }
        OrgSectorService orgSectorService = (OrgSectorService)ServiceGlobal.getService(OrgSectorService.class);
        ArrayList<OrgSector> orgSectors = orgSectorService.selectByOrg(org);
        for (OrgSector orgSector : orgSectors) {
            UserGroup userGroup2 = new UserGroup();
            userGroup2.setUserGroupId(orgSector.getOrgSectorId());
            if (userGroupService.checkKey(userGroup2) != 0) continue;
            userGroup2.setUserGroupName(StringHelper.format("[\u90e8\u95e8]%1$s", orgSector.getOrgSectorName()));
            userGroup2.setSubType("SECTOR");
            userGroupService.create(userGroup2);
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("USERDATA", org.getOrgId());
        userGroupDetailService.remove(selectCond, true);
        for (OrgSector orgSector : orgSectors) {
            UserGroupDetail userGroupDetail = new UserGroupDetail();
            if (StringHelper.isNullOrEmpty(orgSector.getPOrgSectorId())) {
                userGroupDetail.setUserGroupId(orgSector.getOrgId());
                userGroupDetail.setUserObjectId(orgSector.getOrgSectorId());
            } else {
                userGroupDetail.setUserGroupId(orgSector.getPOrgSectorId());
                userGroupDetail.setUserObjectId(orgSector.getOrgSectorId());
            }
            userGroupDetail.setUserGroupDetailId(KeyValueHelper.genUniqueId(userGroupDetail.getUserGroupId(), userGroupDetail.getUserObjectId()));
            if (StringHelper.isNullOrEmpty(orgSector.getPOrgSectorId())) {
                userGroupDetail.setUserGroupDetailName(StringHelper.format("%1$s\\%2$s", orgSector.getOrgName(), orgSector.getOrgSectorName()));
            } else {
                userGroupDetail.setUserGroupDetailName(StringHelper.format("%1$s\\%2$s", orgSector.getPOrgSectorName(), orgSector.getOrgSectorName()));
            }
            userGroupDetail.setUserData(orgSector.getOrgId());
            userGroupDetailService.create(userGroupDetail);
        }
        HashMap<String, UserGroup> secUserTypeUserGroupMap = new HashMap<String, UserGroup>();
        OrgSecUserService orgSecUserService = (OrgSecUserService)ServiceGlobal.getService(OrgSecUserService.class);
        ArrayList<OrgSecUser> orgSecUserList = orgSecUserService.selectByOrg(org);
        for (OrgSecUser orgSecUser : orgSecUserList) {
            if (StringHelper.isNullOrEmpty(orgSecUser.getOrgSecUserTypeId())) continue;
            UserGroup userGroup3 = new UserGroup();
            userGroup3.setUserGroupId(KeyValueHelper.genUniqueId(orgSecUser.getOrgSectorId(), orgSecUser.getOrgSecUserTypeId()));
            if (secUserTypeUserGroupMap.containsKey(userGroup3.getUserGroupId())) continue;
            if (userGroupService.checkKey(userGroup3) == 0) {
                userGroup3.setUserGroupName(StringHelper.format("%1$s\\%2$s", orgSecUser.getOrgSectorName(), orgSecUser.getOrgSecUserTypeName()));
                userGroup3.setUserData(orgSecUser.getOrgSectorId());
                userGroup3.setUserData2(orgSecUser.getOrgSecUserTypeId());
                userGroup3.setSubType("ORGSECUSERTYPE");
                userGroupService.create(userGroup3);
            }
            secUserTypeUserGroupMap.put(userGroup3.getUserGroupId(), userGroup3);
            UserGroupDetail userGroupDetail = new UserGroupDetail();
            userGroupDetail.setUserGroupId(orgSecUser.getOrgSectorId());
            userGroupDetail.setUserObjectId(userGroup3.getUserGroupId());
            userGroupDetail.setUserGroupDetailId(KeyValueHelper.genUniqueId(userGroupDetail.getUserGroupId(), userGroupDetail.getUserObjectId()));
            userGroupDetail.setUserGroupDetailName(StringHelper.format("%1$s\\%2$s", orgSecUser.getOrgSectorName(), orgSecUser.getOrgSecUserTypeName()));
            userGroupDetail.setUserData(orgSecUser.getOrgId());
            userGroupDetailService.create(userGroupDetail);
        }
        for (OrgSecUser orgSecUser : orgSecUserList) {
            UserGroupDetail userGroupDetail = new UserGroupDetail();
            if (StringHelper.isNullOrEmpty(orgSecUser.getOrgSecUserTypeId())) {
                userGroupDetail.setUserGroupId(orgSecUser.getOrgSectorId());
            } else {
                userGroupDetail.setUserGroupId(KeyValueHelper.genUniqueId(orgSecUser.getOrgSectorId(), orgSecUser.getOrgSecUserTypeId()));
            }
            userGroupDetail.setUserObjectId(orgSecUser.getOrgUserId());
            userGroupDetail.setUserGroupDetailId(KeyValueHelper.genUniqueId(userGroupDetail.getUserGroupId(), userGroupDetail.getUserObjectId()));
            userGroupDetail.setUserGroupDetailName(StringHelper.format("[\u90e8\u95e8\u4eba\u5458]%1$s\\%2$s", orgSecUser.getOrgSectorName(), orgSecUser.getOrgUserName()));
            userGroupDetail.setUserData(orgSecUser.getOrgId());
            userGroupDetailService.create(userGroupDetail);
        }
    }
}

