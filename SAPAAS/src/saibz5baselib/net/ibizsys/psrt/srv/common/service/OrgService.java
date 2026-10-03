package net.ibizsys.psrt.srv.common.service;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSecUser;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.UserGroup;
import net.ibizsys.psrt.srv.common.entity.UserGroupDetail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

//@Service
//@Transactional
@Component
/**
 * 组织机构 服务操作对象
 * 
 */
public class OrgService extends OrgServiceBase
{

	private static final Log log = LogFactory.getLog(OrgService.class);

	public OrgService()
	{
		super();

	}

	@Override
	protected void onInitAll(Org org) throws Exception
	{
		initUserObject(org);
	}

	@Override
	protected void onInitUserObject(Org org) throws Exception
	{
		// 初始化用户对象
		if (!org.isFullEntity())
			this.get(org);
		
		UserGroupService userGroupService = (UserGroupService) ServiceGlobal.getService(UserGroupService.class);
		UserGroupDetailService userGroupDetailService = (UserGroupDetailService) ServiceGlobal.getService(UserGroupDetailService.class);

		if (true)
		{
			UserGroup userGroup = new UserGroup();
			userGroup.setUserGroupId(org.getOrgId());
			if (userGroupService.checkKey(userGroup) == IService.CHECKKEYSTATE_OK)
			{
				userGroup.setUserGroupName(StringHelper.format("[机构]%1$s", org.getOrgName()));
				userGroup.setSubType("ORG");
				userGroupService.create(userGroup);
			}
		}

		// 查出所有的部门
		OrgSectorService orgSectorService = (OrgSectorService) ServiceGlobal.getService(OrgSectorService.class);
		ArrayList<OrgSector> orgSectors = orgSectorService.selectByOrg(org);
		for (OrgSector orgSector : orgSectors)
		{
			UserGroup userGroup = new UserGroup();
			userGroup.setUserGroupId(orgSector.getOrgSectorId());
			if (userGroupService.checkKey(userGroup) == IService.CHECKKEYSTATE_OK)
			{
				userGroup.setUserGroupName(StringHelper.format("[部门]%1$s", orgSector.getOrgSectorName()));
				userGroup.setSubType("SECTOR");
				userGroupService.create(userGroup);
			}
		}

		// 移除所有关系
		SelectCond selectCond = new SelectCond();
		selectCond.set(UserGroupDetail.FIELD_USERDATA, org.getOrgId());
		userGroupDetailService.remove(selectCond, true);

		// 建立部门关系
		for (OrgSector orgSector : orgSectors)
		{
			UserGroupDetail userGroupDetail = new UserGroupDetail();
			if (StringHelper.isNullOrEmpty(orgSector.getPOrgSectorId()))
			{
				userGroupDetail.setUserGroupId(orgSector.getOrgId());
				userGroupDetail.setUserObjectId(orgSector.getOrgSectorId());
			}
			else
			{
				userGroupDetail.setUserGroupId(orgSector.getPOrgSectorId());
				userGroupDetail.setUserObjectId(orgSector.getOrgSectorId());
			}

			userGroupDetail.setUserGroupDetailId(KeyValueHelper.genUniqueId(userGroupDetail.getUserGroupId(), userGroupDetail.getUserObjectId()));
			// if(userGroupDetailService.checkKey(userGroupDetail) ==
			// IService.CHECKKEYSTATE_OK)
			if (true)
			{
				if (StringHelper.isNullOrEmpty(orgSector.getPOrgSectorId()))
				{
					userGroupDetail.setUserGroupDetailName(StringHelper.format("%1$s\\%2$s", orgSector.getOrgName(), orgSector.getOrgSectorName()));
				}
				else
				{
					userGroupDetail.setUserGroupDetailName(StringHelper.format("%1$s\\%2$s", orgSector.getPOrgSectorName(), orgSector.getOrgSectorName()));
				}
				userGroupDetail.setUserData(orgSector.getOrgId());
				userGroupDetailService.create(userGroupDetail);
			}
		}

		// 用户岗位
		HashMap<String, UserGroup> secUserTypeUserGroupMap = new HashMap<String, UserGroup>();

		// 建立部门人员关系
		OrgSecUserService orgSecUserService = (OrgSecUserService) ServiceGlobal.getService(OrgSecUserService.class);
		ArrayList<OrgSecUser> orgSecUserList = orgSecUserService.selectByOrg(org);
		// 建立部门岗位用户组
		for (OrgSecUser orgSecUser : orgSecUserList)
		{
			if (StringHelper.isNullOrEmpty(orgSecUser.getOrgSecUserTypeId()))
				continue;

			UserGroup userGroup = new UserGroup();
			userGroup.setUserGroupId(KeyValueHelper.genUniqueId(orgSecUser.getOrgSectorId(), orgSecUser.getOrgSecUserTypeId()));
			if (secUserTypeUserGroupMap.containsKey(userGroup.getUserGroupId()))
				continue;
			if (userGroupService.checkKey(userGroup) == IService.CHECKKEYSTATE_OK)
			{
				userGroup.setUserGroupName(StringHelper.format("%1$s\\%2$s", orgSecUser.getOrgSectorName(), orgSecUser.getOrgSecUserTypeName()));
				userGroup.setUserData(orgSecUser.getOrgSectorId());
				userGroup.setUserData2(orgSecUser.getOrgSecUserTypeId());
				userGroup.setSubType("ORGSECUSERTYPE");
				userGroupService.create(userGroup);
			}
			secUserTypeUserGroupMap.put(userGroup.getUserGroupId(), userGroup);

			// 做关系
			UserGroupDetail userGroupDetail = new UserGroupDetail();
			userGroupDetail.setUserGroupId(orgSecUser.getOrgSectorId());
			userGroupDetail.setUserObjectId(userGroup.getUserGroupId());
			userGroupDetail.setUserGroupDetailId(KeyValueHelper.genUniqueId(userGroupDetail.getUserGroupId(), userGroupDetail.getUserObjectId()));
			if (true)
			{
				userGroupDetail.setUserGroupDetailName(StringHelper.format("%1$s\\%2$s", orgSecUser.getOrgSectorName(), orgSecUser.getOrgSecUserTypeName()));
				userGroupDetail.setUserData(orgSecUser.getOrgId());
				userGroupDetailService.create(userGroupDetail);
			}

		}

		for (OrgSecUser orgSecUser : orgSecUserList)
		{
			UserGroupDetail userGroupDetail = new UserGroupDetail();
			if (StringHelper.isNullOrEmpty(orgSecUser.getOrgSecUserTypeId()))
			{
				// 做部门人员关系
				userGroupDetail.setUserGroupId(orgSecUser.getOrgSectorId());
			}
			else
			{
				// 直接做部门角色人员关系
				userGroupDetail.setUserGroupId(KeyValueHelper.genUniqueId(orgSecUser.getOrgSectorId(), orgSecUser.getOrgSecUserTypeId()));
			}
			userGroupDetail.setUserObjectId(orgSecUser.getOrgUserId());
			userGroupDetail.setUserGroupDetailId(KeyValueHelper.genUniqueId(userGroupDetail.getUserGroupId(), userGroupDetail.getUserObjectId()));
			if (true)
			{
				userGroupDetail.setUserGroupDetailName(StringHelper.format("[部门人员]%1$s\\%2$s", orgSecUser.getOrgSectorName(), orgSecUser.getOrgUserName()));
				userGroupDetail.setUserData(orgSecUser.getOrgId());
				userGroupDetailService.create(userGroupDetail);
			}
		}
	}
}