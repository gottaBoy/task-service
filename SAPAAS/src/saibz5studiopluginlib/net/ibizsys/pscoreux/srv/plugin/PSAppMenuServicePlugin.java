package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;

public class PSAppMenuServicePlugin extends ServicePluginBase {
	
	private static final Log log = LogFactory.getLog(PSAppMenuServicePlugin.class);
	
	@Override
	public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam)
			throws Exception {

		if(nActionPos == IPlugin.ACTIONPOS_ENTER) {
			if(this.getSessionFactory() == null) {
				this.setSessionFactory(iService.getSessionFactory());
			}
			//获取PSAPPMENU新的实体以及旧实体的ID
			String psAppMenuOldId = (String) objParam;
			PSAppMenu psAppMenuNew = (PSAppMenu) iEntity;
			
			//初始化service
			PSAppMenuService psAppMenuService = (PSAppMenuService) ServiceGlobal.getService(PSAppMenuService.class, iService.getSessionFactory());
			PSAppMenuItemService psAppMenuItemService = (PSAppMenuItemService) ServiceGlobal.getService(PSAppMenuItemService.class, iService.getSessionFactory());
			
			//查询出旧实体内的内容
			PSAppMenu psAppMenuOld = new PSAppMenu();
			psAppMenuOld.setPSAppMenuId(psAppMenuOldId);
			if(psAppMenuService.select(psAppMenuOld, true)) {
				//若旧的菜单和新的菜单所属系统应用相同则跳过
				if(StringHelper.compare(psAppMenuNew.getPSSysAppId(), psAppMenuOld.getPSSysAppId(),false)!=0) {
					//在本次拷贝中新建应用功能
					Map<String,PSAppFunc> psAppFuncMap = new HashMap<String,PSAppFunc>();
					//在本次拷贝中新建的应用模块
					Map<String,PSAppModule> psAppModuleMap = new HashMap<String,PSAppModule>();
					
					//查询新的应用菜单的菜单项
					ArrayList<PSAppMenuItem> psAppMenuItemNewList = psAppMenuItemService.selectByPSAppMenu(psAppMenuNew);
					//当新的应用菜单下存在菜单项时，拷贝新的应用菜单下的菜单项的关联应用功能信息。
					if(psAppMenuItemNewList!=null && psAppMenuItemNewList.size() > 0) {
						for (PSAppMenuItem psAppMenuItem : psAppMenuItemNewList) {
							PSAppMenuItem psAppMenuItemNow = this.appMenuItemAssociationCreateOperation(iService, psAppMenuNew, psAppMenuItem, psAppFuncMap, psAppModuleMap);
							psAppMenuItemService.update(psAppMenuItemNow);
						}
					} 
					//当新的应用菜单下不存在菜单项时，拷贝旧的应用菜单下的菜单项和其关联应用功能信息。
					else {
						//查询需要拷贝的应用菜单项
						ArrayList<PSAppMenuItem> psAppMenuItemList = psAppMenuItemService.selectByPSAppMenu(psAppMenuOld);
						//顶级需要拷贝的应用菜单项
						ArrayList<PSAppMenuItem> psAppMenuItemTopLevelList = new ArrayList<PSAppMenuItem>();
						for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
							if(StringHelper.isNullOrEmpty(psAppMenuItem.getPPSAppMenuItemId())) {
								psAppMenuItemTopLevelList.add(psAppMenuItem);
							}
						}
						
						for (PSAppMenuItem psAppMenuItemCurrent : psAppMenuItemTopLevelList) {
							//获取子菜单集合
							ArrayList<PSAppMenuItem> menuitmeList = psAppMenuItemService.selectByPPSAppMenuItem(psAppMenuItemCurrent);
							PSAppMenuItem psAppMenuItemTop = this.appMenuItemAssociationCreateOperation(iService, psAppMenuNew, psAppMenuItemCurrent, psAppFuncMap, psAppModuleMap);
							psAppMenuItemTop.resetPSAppMenuItemId();
							psAppMenuItemTop.setPSSysAppId(psAppMenuNew.getPSSysAppId());
							psAppMenuItemService.create(psAppMenuItemTop);
							if(menuitmeList.size() > 0) {
								this.appMenuItmeOperation(iService, psAppMenuNew, psAppMenuItemTop, menuitmeList, psAppFuncMap, psAppModuleMap);
							}
						}
					}
				}
			} else {
				throw new Exception("实体不存在，无效的拷贝源主键："+objParam);
			}
			return PluginActionResult.Replace;
		}
		return super.doCopyDetails(iService, nActionPos, iEntity, objParam);
	}
	
	/**
	 * 创建子菜单项
	 * @param iService
	 * @param psAppMenuNew 新的应用菜单
	 * @param fatherAppMenuItem 新的父级菜单项
	 * @param menuitmeList 需要拷贝的子菜单项集合
	 * @param psAppFuncMap 此次拷贝的应用功能集合
	 * @param psAppModuleMap 此次拷贝的应用模块集合
	 * @throws Exception
	 */
	private void appMenuItmeOperation(IService iService,PSAppMenu psAppMenuNew,PSAppMenuItem fatherAppMenuItem,ArrayList<PSAppMenuItem> menuitmeList,Map<String,PSAppFunc> psAppFuncMap,Map<String,PSAppModule> psAppModuleMap) throws Exception {
		PSAppMenuItemService psAppMenuItemService = (PSAppMenuItemService) ServiceGlobal.getService(PSAppMenuItemService.class, iService.getSessionFactory());
		for (PSAppMenuItem psAppMenuItem : menuitmeList) {
			//获取子菜单集合
			ArrayList<PSAppMenuItem> menuitmeListItem = psAppMenuItemService.selectByPPSAppMenuItem(psAppMenuItem);
			PSAppMenuItem psAppMenuItemNow = this.appMenuItemAssociationCreateOperation(iService, psAppMenuNew, psAppMenuItem, psAppFuncMap, psAppModuleMap);
			psAppMenuItemNow.setPPSAppMenuItemId(fatherAppMenuItem.getPSAppMenuItemId());
			psAppMenuItemNow.setPPSAppMenuItemName(fatherAppMenuItem.getPSAppMenuItemName());
			psAppMenuItemNow.resetPSAppMenuItemId();
			psAppMenuItemNow.setPSSysAppId(psAppMenuNew.getPSSysAppId());
			psAppMenuItemService.create(psAppMenuItemNow);
			if(menuitmeListItem.size() > 0) {
				this.appMenuItmeOperation(iService, psAppMenuNew, psAppMenuItemNow, menuitmeListItem, psAppFuncMap, psAppModuleMap);
			}
		}
	}
	
	/**
	 * 查询需要拷贝的菜单项关系，并拷贝填充
	 * @param iService
	 * @param psAppMenuNew 新的应用菜单
	 * @param psAppMenuItemCurrent 当前需要拷贝的菜单项
	 * @param psAppFuncMap 此次拷贝的应用功能集合
	 * @param psAppModuleMap 此次拷贝的应用模块集合
	 * @return
	 * @throws Exception
	 */
	private PSAppMenuItem appMenuItemAssociationCreateOperation(IService iService,PSAppMenu psAppMenuNew,PSAppMenuItem psAppMenuItemCurrent,Map<String,PSAppFunc> psAppFuncMap,Map<String,PSAppModule> psAppModuleMap) throws Exception {
		PSAppFuncService psAppFuncService = (PSAppFuncService) ServiceGlobal.getService(PSAppFuncService.class, iService.getSessionFactory());
		PSAppViewService<PSAppView> psAppViewService = (PSAppViewService) ServiceGlobal.getService(PSAppViewService.class, iService.getSessionFactory());
		//是否存在应用功能
		if(!StringHelper.isNullOrEmpty(psAppMenuItemCurrent.getPSAppFuncId())) {
			//查询需要拷贝的应用功能
			PSAppFunc psAppFunc = new PSAppFunc();
			psAppFunc.setPSAppFuncId(psAppMenuItemCurrent.getPSAppFuncId());
			
			if(psAppFuncService.select(psAppFunc, true)) {
				//判断是否已经创建过应用功能
				if(!psAppFuncMap.containsKey(psAppFunc.getPSAppFuncId())) {
					String psAppFuncOldId = psAppFunc.getPSAppFuncId();
					//获取应用视图
					PSAppView psAppView = new PSAppView();
					psAppView.setPSAppViewId(psAppFunc.getPSAppViewId());
					if(psAppViewService.select(psAppView, true)) {
						//拼接应用视图ID
						String strValue = this.reckonAppViewId(psAppMenuNew.getPSSysAppId(), psAppView.getPSDEViewBaseId());
						//获取应用视图类型
						String appViewType = psAppView.getPSAppViewType();
						//System.out.println("当前拷贝应用视图类型："+appViewType);
						PSAppView psAppViewItem = new PSAppView();
						psAppViewItem.setPSAppViewId(strValue);
						if(psAppViewService.get(psAppViewItem, true)) {
							psAppFunc.setPSAppViewId(psAppViewItem.getPSAppViewId());
							psAppFunc.setPSAppViewName(psAppViewItem.getPSAppViewName());
						} else {
							psAppViewItem.setPSAppViewId(psAppView.getPSAppViewId());
							switch (appViewType) {
							case "APPDEVIEW":
								PSAppDEView psAppDEView = this.appDEViewOperation(strValue, psAppMenuNew, psAppViewItem, psAppModuleMap);
								psAppFunc.setPSAppViewId(psAppDEView.getPSAppViewId());
								psAppFunc.setPSAppViewName(psAppDEView.getPSAppViewName());
								break;
							case "APPPORTALVIEW":
								PSAppPortalView psAppPortalView = this.appPortalViewOperation(strValue, psAppMenuNew, psAppViewItem, psAppModuleMap);
								psAppFunc.setPSAppViewId(psAppPortalView.getPSAppViewId());
								psAppFunc.setPSAppViewName(psAppPortalView.getPSAppViewName());
								break;
							case "APPINDEXVIEW":
								PSAppIndexView psAppIndexView = this.appIndexViewOperation(strValue, psAppMenuNew, psAppViewItem, psAppModuleMap);
								psAppFunc.setPSAppViewId(psAppIndexView.getPSAppViewId());
								psAppFunc.setPSAppViewName(psAppIndexView.getPSAppViewName());
								break;
							default:
								throw new Exception("实体PSAppView主键："+psAppView.getPSAppViewId()+"，视图类型识别出错，非(APPDEVIEW,APPPORTALVIEW,APPINDEXVIEW)已确认三个类型中任何一个,无法处理拷贝。");
							}
						}
					}
					//创建新的应用功能
					psAppFunc.resetPSAppFuncId();
					psAppFunc.setPSSysAppId(psAppMenuNew.getPSSysAppId());
					psAppFunc.setPSSysAppName(psAppMenuNew.getPSSysAppName());
					psAppFuncService.create(psAppFunc);
					//将新建的应用功能放入map中
					psAppFuncMap.put(psAppFuncOldId, psAppFunc);
					//将新建的应用功能放入应用菜单项中
					psAppMenuItemCurrent.setPSAppFuncId(psAppFunc.getPSAppFuncId());
					psAppMenuItemCurrent.setPSAppFuncName(psAppFunc.getPSAppFuncName());
				} else {
					//已存在时获取map中对象值使用
					PSAppFunc psAppFuncCurrent = psAppFuncMap.get(psAppFunc.getPSAppFuncId());
					//将已存在的应用功能放入到应用菜单项中
					psAppMenuItemCurrent.setPSAppFuncId(psAppFuncCurrent.getPSAppFuncId());
					psAppMenuItemCurrent.setPSAppFuncName(psAppFuncCurrent.getPSAppFuncName());
				}
			} else {
				throw new Exception("实体PSAppMenuItem主键："+psAppMenuItemCurrent.getPSAppMenuItemId()+"，关联实体PSAppFunc实体主键："+psAppMenuItemCurrent.getPSAppFuncId()+"查询信息不存在，无法拷贝。");
			}
		}
		psAppMenuItemCurrent.setPSAppMenuId(psAppMenuNew.getPSAppMenuId());
		psAppMenuItemCurrent.setPSAppMenuName(psAppMenuNew.getPSAppMenuName());
		return psAppMenuItemCurrent;
	}
	
	/**
	 * 拷贝应用实体视图
	 * @param id 将要新建的首页视图ID
	 * @param psAppMenuNew 新的应用菜单
	 * @param psAppViewItem 当前需要拷贝的应用视图
	 * @param psAppModuleMap 本次拷贝的应用模块Map集合
	 * @return
	 * @throws Exception
	 */
	private PSAppDEView appDEViewOperation(String id,PSAppMenu psAppMenuNew,PSAppView psAppViewItem,Map<String,PSAppModule> psAppModuleMap) throws Exception {
		PSAppDEViewService psAppDEViewService = (PSAppDEViewService) ServiceGlobal.getService(PSAppDEViewService.class, this.getSessionFactory());
		PSAppDEView psAppDEView = new PSAppDEView();
		psAppDEView.setPSAppDEViewId(psAppViewItem.getPSAppViewId());
		if(psAppDEViewService.get(psAppDEView,true)) {
			PSAppModule psAppModule = new PSAppModule();
			//获取应用模块
			if(!psAppModuleMap.containsKey(psAppDEView.getPSAppModuleId())) {
				psAppModule = this.appModuleOperation(psAppMenuNew, psAppDEView.getPSAppModuleId(), psAppViewItem.getPSAppViewId(), psAppModuleMap);
			} else {
				psAppModule = psAppModuleMap.get(psAppDEView.getPSAppModuleId());
			}
			psAppDEView.setPSAppModuleId(psAppModule.getPSAppModuleId());
			psAppDEView.setPSAppModuleName(psAppModule.getPSAppModuleName());
			psAppDEView.setPSAppDEViewId(id);
			psAppDEView.setPSSysAppId(psAppMenuNew.getPSSysAppId());
			psAppDEView.setPSSysAppName(psAppMenuNew.getPSSysAppName());
			psAppDEViewService.create(psAppDEView);
		} else {
			throw new Exception("实体PSAppView主键："+psAppViewItem.getPSAppViewId()+"，关联实体PSAppDEView实体主键："+psAppViewItem.getPSAppViewId()+"查询信息不存在，无法拷贝。");
		}
		return psAppDEView;
	}
	
	/**
	 * 拷贝应用门户视图
	 * @param id 将要新建的首页视图ID
	 * @param psAppMenuNew 新的应用菜单
	 * @param psAppViewItem 当前需要拷贝的应用视图
	 * @param psAppModuleMap 本次拷贝的应用模块Map集合
	 * @return
	 * @throws Exception
	 */
	private PSAppPortalView appPortalViewOperation(String id,PSAppMenu psAppMenuNew,PSAppView psAppViewItem,Map<String,PSAppModule> psAppModuleMap) throws Exception {
		PSAppPortalViewService psAppPortalViewService = (PSAppPortalViewService) ServiceGlobal.getService(PSAppPortalViewService.class, this.getSessionFactory());
		PSAppPortalView psAppPortalView = new PSAppPortalView();
		psAppPortalView.setPSAppPortalViewId(psAppViewItem.getPSAppViewId());
		if(psAppPortalViewService.get(psAppPortalView, true)) {
			PSAppModule psAppModule = new PSAppModule();
			//获取应用模块
			if(!psAppModuleMap.containsKey(psAppPortalView.getPSAppModuleId())) {
				psAppModule = this.appModuleOperation(psAppMenuNew, psAppPortalView.getPSAppModuleId(), psAppViewItem.getPSAppViewId(), psAppModuleMap);
			} else {
				psAppModule = psAppModuleMap.get(psAppPortalView.getPSAppModuleId());
			}
			psAppPortalView.setPSAppModuleId(psAppModule.getPSAppModuleId());
			psAppPortalView.setPSAppModuleName(psAppModule.getPSAppModuleName());
			psAppPortalView.setPSAppPortalViewId(id);
			psAppPortalView.setPSSysAppId(psAppMenuNew.getPSSysAppId());
			psAppPortalView.setPSSysAppName(psAppMenuNew.getPSSysAppName());
			psAppPortalViewService.create(psAppPortalView);
		} else {
			throw new Exception("实体PSAppView主键："+psAppViewItem.getPSAppViewId()+"，关联实体PSAppPortalView实体主键："+psAppViewItem.getPSAppViewId()+"查询信息不存在，无法拷贝。");
		}
		return psAppPortalView;
	}
	
	/**
	 * 拷贝应用首页视图
	 * @param sessionFactory
	 * @param id 将要新建的首页视图ID
	 * @param psAppMenuNew 新的应用菜单
	 * @param psAppViewItem 当前需要拷贝的应用视图
	 * @param psAppModuleMap 本次拷贝的应用模块Map集合
	 * @return
	 * @throws Exception
	 */
	private PSAppIndexView appIndexViewOperation(String id,PSAppMenu psAppMenuNew,PSAppView psAppViewItem,Map<String,PSAppModule> psAppModuleMap) throws Exception {
		PSAppIndexViewService psAppIndexViewService = (PSAppIndexViewService) ServiceGlobal.getService(PSAppIndexViewService.class, this.getSessionFactory());
		PSAppViewService<PSAppView> psAppViewService = (PSAppViewService<PSAppView>) ServiceGlobal.getService(PSAppViewService.class, this.getSessionFactory());
		PSAppIndexView psAppIndexView = new PSAppIndexView();
		psAppIndexView.setPSAppIndexViewId(psAppViewItem.getPSAppViewId());
		if(psAppIndexViewService.get(psAppIndexView, true)) {
			PSAppModule psAppModule = new PSAppModule();
			//判断默认视图是否选择
			if(!StringHelper.isNullOrEmpty(psAppIndexView.getDefPSAppViewId())) {
				PSAppView psAppView = new PSAppView();
				psAppView.setPSAppViewId(psAppIndexView.getDefPSAppViewId());
				if(psAppViewService.get(psAppView, true)) {
					//拼接应用视图ID
					String strValue = this.reckonAppViewId(psAppMenuNew.getPSSysAppId(), psAppView.getPSDEViewBaseId());
					PSAppView psAppView2 = new PSAppView();
					psAppView2.setPSAppViewId(strValue);
					if(psAppViewService.get(psAppView2, true)) {
						psAppIndexView.setPSAppViewId(psAppView2.getPSAppViewId());
						psAppIndexView.setPSAppViewName(psAppView2.getPSAppViewName());
					} else {
						switch (psAppView.getPSAppViewType()) {
						case "APPDEVIEW":
							PSAppDEView psAppDEView = this.appDEViewOperation(strValue, psAppMenuNew, psAppViewItem, psAppModuleMap);
							psAppIndexView.setDefPSAppViewId(psAppDEView.getPSAppViewId());
							psAppIndexView.setDefPSAppViewName(psAppDEView.getPSAppViewName());
							break;
						case "APPPORTALVIEW":
							PSAppPortalView psAppPortalView = this.appPortalViewOperation(strValue,psAppMenuNew,psAppView,psAppModuleMap);
							psAppIndexView.setDefPSAppViewId(psAppPortalView.getPSAppViewId());
							psAppIndexView.setDefPSAppViewName(psAppPortalView.getPSAppViewName());
							break;
						default:
							throw new Exception("实体PSAppView主键："+psAppView.getPSAppViewId()+"，视图类型识别出错，非(APPDEVIEW,APPPORTALVIEW)已确认三个类型中任何一个,无法处理拷贝。");
						}
					}
				} else {
					throw new Exception("实体PSAppIndexView主键："+psAppViewItem.getPSAppViewId()+"，关联实体PSAppView实体主键："+psAppIndexView.getDefPSAppViewId()+"查询信息不存在，无法拷贝。");
				}
			}
			//获取应用模块
			if(!psAppModuleMap.containsKey(psAppIndexView.getPSAppModuleId())) {
				psAppModule = this.appModuleOperation(psAppMenuNew, psAppIndexView.getPSAppModuleId(), psAppViewItem.getPSAppViewId(), psAppModuleMap);
			} else {
				psAppModule = psAppModuleMap.get(psAppIndexView.getPSAppModuleId());
			}
			psAppIndexView.setPSAppModuleId(psAppModule.getPSAppModuleId());
			psAppIndexView.setPSAppModuleName(psAppModule.getPSAppModuleName());
			psAppIndexView.setPSAppIndexViewId(id);
			psAppIndexView.setPSSysAppId(psAppMenuNew.getPSSysAppId());
			psAppIndexView.setPSSysAppName(psAppMenuNew.getPSSysAppName());
			psAppIndexView.setPSAppMenuId(psAppMenuNew.getPSAppMenuId());
			psAppIndexView.setPSAppMenuName(psAppMenuNew.getPSAppMenuName());
			psAppIndexViewService.create(psAppIndexView);
		} else {
			throw new Exception("实体PSAppView主键："+psAppViewItem.getPSAppViewId()+"，关联实体PSAppIndexView实体主键："+psAppViewItem.getPSAppViewId()+"查询信息不存在，无法拷贝。");
		}
		return psAppIndexView;
	}
	
	/**
	 * 拷贝应用模型
	 * @param sessionFactory
	 * @param psAppMenuNew 此次拷贝的应用菜单
	 * @param psAppModuleOldId 拷贝源的ID
	 * @param psAppviewId 
	 * @param psAppModuleMap 此次拷贝过的应用模型
	 * @return
	 * @throws Exception
	 */
	private PSAppModule appModuleOperation(PSAppMenu psAppMenuNew,String psAppModuleOldId ,String psAppviewId,Map<String,PSAppModule> psAppModuleMap) throws Exception {
		PSAppModuleService psAppModuleService = (PSAppModuleService) ServiceGlobal.getService(PSAppModuleService.class, this.getSessionFactory());
		PSAppModule psAppModule = new PSAppModule();
		psAppModule.setPSAppModuleId(psAppModuleOldId);
		if(psAppModuleService.get(psAppModule, true)) {
			psAppModule.resetPSAppModuleId();
			psAppModule.setPSSysAppId(psAppMenuNew.getPSSysAppId());
			psAppModule.setPSSysAppName(psAppMenuNew.getPSSysAppName());
			psAppModuleService.create(psAppModule);
			psAppModuleMap.put(psAppModuleOldId, psAppModule);
		} else {
			throw new Exception("实体PSAppView主键："+psAppviewId+"，关联实体PSAppModule实体主键："+psAppModuleOldId+"查询信息不存在，无法拷贝。");
		}
		return psAppModule;
	}
	
	/**
	 * 
	 * @param psSysAppId 系统应用ID
	 * @param psDEViewBaseId 实体视图ID
	 */
	private String reckonAppViewId(String psSysAppId,String psDEViewBaseId) {
		StringBuilderEx sb  = new StringBuilderEx();
		//属性 PSSysAppId - 云系统应用
		Object objPSSysAppId = psSysAppId;
		if(objPSSysAppId==null)
			objPSSysAppId = "__EMTPY__";
		sb.append("%1$s", objPSSysAppId);
		//属性 PSDEViewBaseId - 云实体视图
		sb.append("||"); 
		Object objPSDEViewBaseId = psDEViewBaseId;
		if(objPSDEViewBaseId==null)
			objPSDEViewBaseId = "__EMTPY__";
		sb.append("%1$s", objPSDEViewBaseId);
		return KeyValueHelper.genUniqueId(sb.toString());
	}
}