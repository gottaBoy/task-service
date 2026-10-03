package net.ibizsys.paas.security;

import java.util.ArrayList;

import net.ibizsys.paas.core.IDEDataRange;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;

/**
 * 用户角色管理对象接口
 * 
 * @author lionlau
 *
 */
public interface IUserRoleMgr {
	/**
	 * 初始化
	 * 
	 * @param strCurUserId
	 * @throws Exception
	 */
	void init(IWebContext iWebContext) throws Exception;

	/**
	 * 获取当前用户标识
	 * 
	 * @return
	 */
	String getUserId();

	/**
	 * 获取当前组织
	 * 
	 * @return
	 */
	Org getOrg() throws Exception;

	/**
	 * 获取当前组织部门
	 * 
	 * @return
	 */
	OrgSector getOrgSector() throws Exception;

	/**
	 * 获取用户数据对象能力
	 * 
	 * @param strDEId
	 * @param strAction
	 * @return
	 */
	ArrayList<UserRoleData> getUserRoleDatas(String strDEId, String strAction) throws Exception;

	// /**
	// * 获取用户
	// *
	// * @param strDEId
	// * @param strAction
	// * @param userRoleDatas
	// * @return
	// */
	// CallResult GetUserRoleData(String strDEId, String strAction, Vector<UserRoleData> userRoleDatas);
	//
	/**
	 * 获取用户角色资源能力
	 * 
	 * @param strResType
	 * @param strResId
	 * @return
	 */
	boolean testUserRoleUniRes(String strResType, String strResId) throws Exception;

	/**
	 * 判断用户访问数据能力
	 * 
	 * @param iDEModel
	 * @param dataEntity
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	boolean testUserRoleDataAction(IDataEntityModel iDEModel, IEntity dataEntity, String strAction) throws Exception;

	/**
	 * 判断用户访问数据能力
	 * 
	 * @param strDEId
	 * @param dataEntity
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	boolean testUserRoleDataAction(String strDEId, IEntity dataEntity, String strAction) throws Exception;

	//
	// /**
	// * 获取当前用户拥有的所有角色
	// *
	// * @param userRoles
	// * @return
	// */
	// boolean GetUserRoles(Vector<UserRole> userRoles);
	//
	/**
	 * 判断用户角色是否允许访问实体属性
	 * 
	 * @param strDEName
	 * @param strField
	 * @return
	 */
	int testUserRoleDEField(String strDEName, String strField) throws Exception;

	/**
	 * 获取数据能力条件
	 * 
	 * @param iService
	 * @param userRoleData
	 * @return
	 * @throws Exception
	 */
	String getUserRoleDataCond(IService iService, UserRoleData userRoleData) throws Exception;

	/**
	 * 获取数据能力条件
	 * 
	 * @param iService
	 * @param userRoleData
	 * @param iDEDataSetFetchContext
	 * @return
	 * @throws Exception
	 */
	String getUserRoleDataCond(IService iService, UserRoleData userRoleData, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception;

	/**
	 * 获取数据能力条件
	 * 
	 * @param iService
	 * @param iDEDataRange
	 * @return
	 * @throws Exception
	 */
	String getDEDataRangeCond(IService iService, IDEDataRange iDEDataRange) throws Exception;

	/**
	 * 获取数据能力条件
	 * 
	 * @param iService
	 * @param iDEDataRange
	 * @param iDEDataSetFetchContext
	 * @return
	 * @throws Exception
	 */
	String getDEDataRangeCond(IService iService, IDEDataRange iDEDataRange, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception;

}