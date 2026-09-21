/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Qualifier
 */
package net.ibizsys.psrt.srv;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.DER;
import net.ibizsys.paas.core.DERs;
import net.ibizsys.paas.core.PluginList;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.sysmodel.SystemModelBase;
import net.ibizsys.paas.sysmodel.util.RegExValueRuleModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.codelist.AllOrgCodeListModel;
import net.ibizsys.psrt.srv.codelist.AuditDEActionCodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList105CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList19CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList20CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList24CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList25CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList50CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList56CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList58CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList59CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList5CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList71CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList80CodeListModel;
import net.ibizsys.psrt.srv.codelist.CodeList97CodeListModel;
import net.ibizsys.psrt.srv.codelist.DEDataChgLogTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.DEFieldAccModeCodeListModel;
import net.ibizsys.psrt.srv.codelist.DEIndexModeCodeListModel;
import net.ibizsys.psrt.srv.codelist.DEPrintFuncCodeListModel;
import net.ibizsys.psrt.srv.codelist.DETableSpaceCodeListModel;
import net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel;
import net.ibizsys.psrt.srv.codelist.DataSyncAgentTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.DataSyncInAgentCodeListModel;
import net.ibizsys.psrt.srv.codelist.DataSyncOutAgentCodeListModel;
import net.ibizsys.psrt.srv.codelist.DynaViewTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.MsgContentTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.MsgImportanceLevelCodeListModel;
import net.ibizsys.psrt.srv.codelist.MsgTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.PVLayoutModeCodeListModel;
import net.ibizsys.psrt.srv.codelist.PVPartTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.ServiceContainerCodeListModel;
import net.ibizsys.psrt.srv.codelist.ServiceRunStateCodeListModel;
import net.ibizsys.psrt.srv.codelist.ServiceStartModeCodeListModel;
import net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel;
import net.ibizsys.psrt.srv.codelist.SystemFuncCodeListModel;
import net.ibizsys.psrt.srv.codelist.SystemTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSDayCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSDayTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSHourCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSMinuteCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSMinuteTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSMonthCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSMonthDayTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSMonthTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSMonthWeekTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSPolicyTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSSecondCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSSecondTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.TSWeekCodeListModel;
import net.ibizsys.psrt.srv.codelist.URDBCDRCodeListModel;
import net.ibizsys.psrt.srv.codelist.URDOrgDRCodeListModel;
import net.ibizsys.psrt.srv.codelist.URDSecDRCodeListModel;
import net.ibizsys.psrt.srv.codelist.URDUserDRCodeListModel;
import net.ibizsys.psrt.srv.codelist.UniResTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.UserRoleTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.WFConfigStateCodeListModel;
import net.ibizsys.psrt.srv.codelist.WFConfigTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.WFGotoStepActorCodeListModel;
import net.ibizsys.psrt.srv.codelist.WFGotoStepCodeListModel;
import net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel;
import net.ibizsys.psrt.srv.codelist.WXEntAppTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel;
import net.ibizsys.psrt.srv.codelist.YesNoCodeListModel;
import net.ibizsys.psrt.srv.common.dao.CodeItemDAO;
import net.ibizsys.psrt.srv.common.dao.CodeListDAO;
import net.ibizsys.psrt.srv.common.dao.DALogDAO;
import net.ibizsys.psrt.srv.common.dao.DEDataChg2DAO;
import net.ibizsys.psrt.srv.common.dao.DEDataChgDAO;
import net.ibizsys.psrt.srv.common.dao.DEDataChgDispDAO;
import net.ibizsys.psrt.srv.common.dao.DataAuditDAO;
import net.ibizsys.psrt.srv.common.dao.DataAuditDetailDAO;
import net.ibizsys.psrt.srv.common.dao.DataSyncAgentDAO;
import net.ibizsys.psrt.srv.common.dao.DataSyncIn2DAO;
import net.ibizsys.psrt.srv.common.dao.DataSyncInDAO;
import net.ibizsys.psrt.srv.common.dao.DataSyncOut2DAO;
import net.ibizsys.psrt.srv.common.dao.DataSyncOutDAO;
import net.ibizsys.psrt.srv.common.dao.FileDAO;
import net.ibizsys.psrt.srv.common.dao.LoginAccountDAO;
import net.ibizsys.psrt.srv.common.dao.LoginLogDAO;
import net.ibizsys.psrt.srv.common.dao.MsgAccountDAO;
import net.ibizsys.psrt.srv.common.dao.MsgAccountDetailDAO;
import net.ibizsys.psrt.srv.common.dao.MsgSendQueueDAO;
import net.ibizsys.psrt.srv.common.dao.MsgSendQueueHisDAO;
import net.ibizsys.psrt.srv.common.dao.MsgTemplateDAO;
import net.ibizsys.psrt.srv.common.dao.OrgDAO;
import net.ibizsys.psrt.srv.common.dao.OrgSecUserDAO;
import net.ibizsys.psrt.srv.common.dao.OrgSecUserTypeDAO;
import net.ibizsys.psrt.srv.common.dao.OrgSectorDAO;
import net.ibizsys.psrt.srv.common.dao.OrgTypeDAO;
import net.ibizsys.psrt.srv.common.dao.OrgUnitCatDAO;
import net.ibizsys.psrt.srv.common.dao.OrgUserDAO;
import net.ibizsys.psrt.srv.common.dao.OrgUserLevelDAO;
import net.ibizsys.psrt.srv.common.dao.PPModelDAO;
import net.ibizsys.psrt.srv.common.dao.PVPartDAO;
import net.ibizsys.psrt.srv.common.dao.PortalPageDAO;
import net.ibizsys.psrt.srv.common.dao.RegistryDAO;
import net.ibizsys.psrt.srv.common.dao.ServiceDAO;
import net.ibizsys.psrt.srv.common.dao.SysAdminDAO;
import net.ibizsys.psrt.srv.common.dao.SysAdminFuncDAO;
import net.ibizsys.psrt.srv.common.dao.SystemDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDEngineDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDGroupDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDGroupDetailDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDItemDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDPolicyDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDPolicyOwnerDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDTaskDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDTaskLogDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDTaskPolicyDAO;
import net.ibizsys.psrt.srv.common.dao.TSSDTaskTypeDAO;
import net.ibizsys.psrt.srv.common.dao.UniResDAO;
import net.ibizsys.psrt.srv.common.dao.UserDAO;
import net.ibizsys.psrt.srv.common.dao.UserDGThemeDAO;
import net.ibizsys.psrt.srv.common.dao.UserDictCatDAO;
import net.ibizsys.psrt.srv.common.dao.UserDictDAO;
import net.ibizsys.psrt.srv.common.dao.UserDictItemDAO;
import net.ibizsys.psrt.srv.common.dao.UserGroupDAO;
import net.ibizsys.psrt.srv.common.dao.UserGroupDetailDAO;
import net.ibizsys.psrt.srv.common.dao.UserObjectDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldsDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleDataActionDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleDataDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleDataDetailDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleDatasDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleDetailDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleResDAO;
import net.ibizsys.psrt.srv.common.dao.UserRoleTypeDAO;
import net.ibizsys.psrt.srv.common.demodel.CodeItemDEModel;
import net.ibizsys.psrt.srv.common.demodel.CodeListDEModel;
import net.ibizsys.psrt.srv.common.demodel.DALogDEModel;
import net.ibizsys.psrt.srv.common.demodel.DEDataChg2DEModel;
import net.ibizsys.psrt.srv.common.demodel.DEDataChgDEModel;
import net.ibizsys.psrt.srv.common.demodel.DEDataChgDispDEModel;
import net.ibizsys.psrt.srv.common.demodel.DataAuditDEModel;
import net.ibizsys.psrt.srv.common.demodel.DataAuditDetailDEModel;
import net.ibizsys.psrt.srv.common.demodel.DataSyncAgentDEModel;
import net.ibizsys.psrt.srv.common.demodel.DataSyncIn2DEModel;
import net.ibizsys.psrt.srv.common.demodel.DataSyncInDEModel;
import net.ibizsys.psrt.srv.common.demodel.DataSyncOut2DEModel;
import net.ibizsys.psrt.srv.common.demodel.DataSyncOutDEModel;
import net.ibizsys.psrt.srv.common.demodel.FileDEModel;
import net.ibizsys.psrt.srv.common.demodel.LoginAccountDEModel;
import net.ibizsys.psrt.srv.common.demodel.LoginLogDEModel;
import net.ibizsys.psrt.srv.common.demodel.MsgAccountDEModel;
import net.ibizsys.psrt.srv.common.demodel.MsgAccountDetailDEModel;
import net.ibizsys.psrt.srv.common.demodel.MsgSendQueueDEModel;
import net.ibizsys.psrt.srv.common.demodel.MsgSendQueueHisDEModel;
import net.ibizsys.psrt.srv.common.demodel.MsgTemplateDEModel;
import net.ibizsys.psrt.srv.common.demodel.OrgDEModel;
import net.ibizsys.psrt.srv.common.demodel.OrgSecUserDEModel;
import net.ibizsys.psrt.srv.common.demodel.OrgSecUserTypeDEModel;
import net.ibizsys.psrt.srv.common.demodel.OrgSectorDEModel;
import net.ibizsys.psrt.srv.common.demodel.OrgTypeDEModel;
import net.ibizsys.psrt.srv.common.demodel.OrgUnitCatDEModel;
import net.ibizsys.psrt.srv.common.demodel.OrgUserDEModel;
import net.ibizsys.psrt.srv.common.demodel.OrgUserLevelDEModel;
import net.ibizsys.psrt.srv.common.demodel.PPModelDEModel;
import net.ibizsys.psrt.srv.common.demodel.PVPartDEModel;
import net.ibizsys.psrt.srv.common.demodel.PortalPageDEModel;
import net.ibizsys.psrt.srv.common.demodel.RegistryDEModel;
import net.ibizsys.psrt.srv.common.demodel.ServiceDEModel;
import net.ibizsys.psrt.srv.common.demodel.SysAdminDEModel;
import net.ibizsys.psrt.srv.common.demodel.SysAdminFuncDEModel;
import net.ibizsys.psrt.srv.common.demodel.SystemDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDEngineDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDGroupDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDGroupDetailDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDItemDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDPolicyDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDPolicyOwnerDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDTaskDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDTaskLogDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDTaskPolicyDEModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDTaskTypeDEModel;
import net.ibizsys.psrt.srv.common.demodel.UniResDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserDGThemeDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserDictCatDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserDictDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserDictItemDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserGroupDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserGroupDetailDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserObjectDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldsDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDataActionDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDataDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDataDetailDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDatasDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDetailDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleResDEModel;
import net.ibizsys.psrt.srv.common.demodel.UserRoleTypeDEModel;
import net.ibizsys.psrt.srv.common.service.CodeItemService;
import net.ibizsys.psrt.srv.common.service.CodeListService;
import net.ibizsys.psrt.srv.common.service.DALogService;
import net.ibizsys.psrt.srv.common.service.DEDataChg2Service;
import net.ibizsys.psrt.srv.common.service.DEDataChgDispService;
import net.ibizsys.psrt.srv.common.service.DEDataChgService;
import net.ibizsys.psrt.srv.common.service.DataAuditDetailService;
import net.ibizsys.psrt.srv.common.service.DataAuditService;
import net.ibizsys.psrt.srv.common.service.DataSyncAgentService;
import net.ibizsys.psrt.srv.common.service.DataSyncIn2Service;
import net.ibizsys.psrt.srv.common.service.DataSyncInService;
import net.ibizsys.psrt.srv.common.service.DataSyncOut2Service;
import net.ibizsys.psrt.srv.common.service.DataSyncOutService;
import net.ibizsys.psrt.srv.common.service.FileService;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.LoginLogService;
import net.ibizsys.psrt.srv.common.service.MsgAccountDetailService;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueHisService;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueService;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;
import net.ibizsys.psrt.srv.common.service.OrgSecUserService;
import net.ibizsys.psrt.srv.common.service.OrgSecUserTypeService;
import net.ibizsys.psrt.srv.common.service.OrgSectorService;
import net.ibizsys.psrt.srv.common.service.OrgService;
import net.ibizsys.psrt.srv.common.service.OrgTypeService;
import net.ibizsys.psrt.srv.common.service.OrgUnitCatService;
import net.ibizsys.psrt.srv.common.service.OrgUserLevelService;
import net.ibizsys.psrt.srv.common.service.OrgUserService;
import net.ibizsys.psrt.srv.common.service.PPModelService;
import net.ibizsys.psrt.srv.common.service.PVPartService;
import net.ibizsys.psrt.srv.common.service.PortalPageService;
import net.ibizsys.psrt.srv.common.service.RegistryService;
import net.ibizsys.psrt.srv.common.service.ServiceService;
import net.ibizsys.psrt.srv.common.service.SysAdminFuncService;
import net.ibizsys.psrt.srv.common.service.SysAdminService;
import net.ibizsys.psrt.srv.common.service.SystemService;
import net.ibizsys.psrt.srv.common.service.TSSDEngineService;
import net.ibizsys.psrt.srv.common.service.TSSDGroupDetailService;
import net.ibizsys.psrt.srv.common.service.TSSDGroupService;
import net.ibizsys.psrt.srv.common.service.TSSDItemService;
import net.ibizsys.psrt.srv.common.service.TSSDPolicyOwnerService;
import net.ibizsys.psrt.srv.common.service.TSSDPolicyService;
import net.ibizsys.psrt.srv.common.service.TSSDTaskLogService;
import net.ibizsys.psrt.srv.common.service.TSSDTaskPolicyService;
import net.ibizsys.psrt.srv.common.service.TSSDTaskService;
import net.ibizsys.psrt.srv.common.service.TSSDTaskTypeService;
import net.ibizsys.psrt.srv.common.service.UniResService;
import net.ibizsys.psrt.srv.common.service.UserDGThemeService;
import net.ibizsys.psrt.srv.common.service.UserDictCatService;
import net.ibizsys.psrt.srv.common.service.UserDictItemService;
import net.ibizsys.psrt.srv.common.service.UserDictService;
import net.ibizsys.psrt.srv.common.service.UserGroupDetailService;
import net.ibizsys.psrt.srv.common.service.UserGroupService;
import net.ibizsys.psrt.srv.common.service.UserObjectServiceProxy;
import net.ibizsys.psrt.srv.common.service.UserRoleDEFieldService;
import net.ibizsys.psrt.srv.common.service.UserRoleDEFieldsService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataActionService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataDetailService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataService;
import net.ibizsys.psrt.srv.common.service.UserRoleDatasService;
import net.ibizsys.psrt.srv.common.service.UserRoleDetailService;
import net.ibizsys.psrt.srv.common.service.UserRoleResService;
import net.ibizsys.psrt.srv.common.service.UserRoleService;
import net.ibizsys.psrt.srv.common.service.UserRoleTypeService;
import net.ibizsys.psrt.srv.common.service.UserService;
import net.ibizsys.psrt.srv.demodel.dao.DataEntityDAO;
import net.ibizsys.psrt.srv.demodel.dao.QueryModelDAO;
import net.ibizsys.psrt.srv.demodel.demodel.DataEntityDEModel;
import net.ibizsys.psrt.srv.demodel.demodel.QueryModelDEModel;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.ibizsys.psrt.srv.demodel.service.QueryModelService;
import net.ibizsys.psrt.srv.dynasys.dao.DSDynaCodeListDAO;
import net.ibizsys.psrt.srv.dynasys.dao.DSDynaViewDAO;
import net.ibizsys.psrt.srv.dynasys.dao.DSDynaViewInstDAO;
import net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFDAO;
import net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFVerDAO;
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaCodeListDEModel;
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaViewDEModel;
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaViewInstDEModel;
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFDEModel;
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFVerDEModel;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaCodeListService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService;
import net.ibizsys.psrt.srv.wf.dao.WFActionDAO;
import net.ibizsys.psrt.srv.wf.dao.WFActorDAO;
import net.ibizsys.psrt.srv.wf.dao.WFAppSettingDAO;
import net.ibizsys.psrt.srv.wf.dao.WFAssistWorkDAO;
import net.ibizsys.psrt.srv.wf.dao.WFCustomProcessDAO;
import net.ibizsys.psrt.srv.wf.dao.WFDynamicUserDAO;
import net.ibizsys.psrt.srv.wf.dao.WFIAActionDAO;
import net.ibizsys.psrt.srv.wf.dao.WFInstanceDAO;
import net.ibizsys.psrt.srv.wf.dao.WFReminderDAO;
import net.ibizsys.psrt.srv.wf.dao.WFStepActorDAO;
import net.ibizsys.psrt.srv.wf.dao.WFStepDAO;
import net.ibizsys.psrt.srv.wf.dao.WFStepDataDAO;
import net.ibizsys.psrt.srv.wf.dao.WFStepInstDAO;
import net.ibizsys.psrt.srv.wf.dao.WFSystemUserDAO;
import net.ibizsys.psrt.srv.wf.dao.WFTmpStepActorDAO;
import net.ibizsys.psrt.srv.wf.dao.WFUCPolicyDAO;
import net.ibizsys.psrt.srv.wf.dao.WFUIWizardDAO;
import net.ibizsys.psrt.srv.wf.dao.WFUserAssistDAO;
import net.ibizsys.psrt.srv.wf.dao.WFUserCandidateDAO;
import net.ibizsys.psrt.srv.wf.dao.WFUserDAO;
import net.ibizsys.psrt.srv.wf.dao.WFUserGroupDAO;
import net.ibizsys.psrt.srv.wf.dao.WFUserGroupDetailDAO;
import net.ibizsys.psrt.srv.wf.dao.WFVersionDAO;
import net.ibizsys.psrt.srv.wf.dao.WFWorkList2DAO;
import net.ibizsys.psrt.srv.wf.dao.WFWorkListDAO;
import net.ibizsys.psrt.srv.wf.dao.WFWorkflowDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFActionDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFActorDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFAppSettingDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFAssistWorkDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFCustomProcessDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFDynamicUserDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFIAActionDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFInstanceDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFReminderDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFStepDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFStepInstDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFSystemUserDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFTmpStepActorDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFUCPolicyDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFUIWizardDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFUserAssistDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFUserCandidateDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFUserDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFUserGroupDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFUserGroupDetailDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFVersionDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFWorkList2DEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFWorkListDEModel;
import net.ibizsys.psrt.srv.wf.demodel.WFWorkflowDEModel;
import net.ibizsys.psrt.srv.wf.service.WFActionService;
import net.ibizsys.psrt.srv.wf.service.WFActorService;
import net.ibizsys.psrt.srv.wf.service.WFAppSettingService;
import net.ibizsys.psrt.srv.wf.service.WFAssistWorkService;
import net.ibizsys.psrt.srv.wf.service.WFCustomProcessService;
import net.ibizsys.psrt.srv.wf.service.WFDynamicUserService;
import net.ibizsys.psrt.srv.wf.service.WFIAActionService;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFReminderService;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.psrt.srv.wf.service.WFStepInstService;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.psrt.srv.wf.service.WFSystemUserService;
import net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFUCPolicyService;
import net.ibizsys.psrt.srv.wf.service.WFUIWizardService;
import net.ibizsys.psrt.srv.wf.service.WFUserAssistService;
import net.ibizsys.psrt.srv.wf.service.WFUserCandidateService;
import net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService;
import net.ibizsys.psrt.srv.wf.service.WFUserGroupService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.ibizsys.psrt.srv.wf.service.WFVersionService;
import net.ibizsys.psrt.srv.wf.service.WFWorkList2Service;
import net.ibizsys.psrt.srv.wf.service.WFWorkListService;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.ibizsys.psrt.srv.wx.dao.WXAccessTokenDAO;
import net.ibizsys.psrt.srv.wx.dao.WXAccountDAO;
import net.ibizsys.psrt.srv.wx.dao.WXEntAppDAO;
import net.ibizsys.psrt.srv.wx.dao.WXMediaDAO;
import net.ibizsys.psrt.srv.wx.dao.WXMessageDAO;
import net.ibizsys.psrt.srv.wx.dao.WXOrgSectorDAO;
import net.ibizsys.psrt.srv.wx.demodel.WXAccessTokenDEModel;
import net.ibizsys.psrt.srv.wx.demodel.WXAccountDEModel;
import net.ibizsys.psrt.srv.wx.demodel.WXEntAppDEModel;
import net.ibizsys.psrt.srv.wx.demodel.WXMediaDEModel;
import net.ibizsys.psrt.srv.wx.demodel.WXMessageDEModel;
import net.ibizsys.psrt.srv.wx.demodel.WXOrgSectorDEModel;
import net.ibizsys.psrt.srv.wx.service.WXAccessTokenService;
import net.ibizsys.psrt.srv.wx.service.WXAccountService;
import net.ibizsys.psrt.srv.wx.service.WXEntAppService;
import net.ibizsys.psrt.srv.wx.service.WXMediaService;
import net.ibizsys.psrt.srv.wx.service.WXMessageService;
import net.ibizsys.psrt.srv.wx.service.WXOrgSectorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@DERs(value={@DER(id="1656e926f11b26fc5332306b52592366", name="DER1N_CODEITEM_CODEITEM_PCODEITEMID", type="DER1N", majordeid="60a039b41c39edc7ff965f1c0958232d", minordeid="60a039b41c39edc7ff965f1c0958232d", majordename="CODEITEM", minordename="CODEITEM", masterrs=0, pickupdefname="PCODEITEMID"), @DER(id="fc0a850d89848ac4bd8af35ad839c288", name="DER1N_CODEITEM_CODELIST_CODELISTID", type="DER1N", majordeid="85317205b415aa6af990684ca7704515", minordeid="60a039b41c39edc7ff965f1c0958232d", majordename="CODELIST", minordename="CODEITEM", masterrs=0, pickupdefname="CODELISTID"), @DER(id="b78b4cc48da463c059424a26efec842c", name="DER1N_CODELIST_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="85317205b415aa6af990684ca7704515", majordename="DATAENTITY", minordename="CODELIST", masterrs=0, pickupdefname="DEID"), @DER(id="2c440711be83754e5250c0394b03dbb9", name="DER1N_DATAAUDITDETAIL_DATAAUDIT_DATAAUDITID", type="DER1N", majordeid="326125ce130f4bec558c9778daef045c", minordeid="7d9fefe4909e0cfffcb467129475b02d", majordename="DATAAUDIT", minordename="DATAAUDITDETAIL", masterrs=0, pickupdefname="DATAAUDITID"), @DER(id="c11fec2d7398bbfae41f4b5d1639079d", name="DER1N_DATAENTITY_DATAENTITY_DER11DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", majordename="DATAENTITY", minordename="DATAENTITY", masterrs=0, pickupdefname="DER11DEID"), @DER(id="a55673f3c26f1de111eeb547dbb40a6e", name="DER1N_DATAENTITY_QUERYMODEL_ACQUERYMODELID", type="DER1N", majordeid="ee650aec5d0df3c9880100dc57441146", minordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", majordename="QUERYMODEL", minordename="DATAENTITY", masterrs=0, pickupdefname="ACQUERYMODELID"), @DER(id="a1149c0cf281cf46f0ae70d7d1921522", name="DER1N_DATASYNCIN2_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="04c87ff6cdac6dd390613dbc44f3c51d", majordename="DATAENTITY", minordename="DATASYNCIN2", masterrs=0, pickupdefname="DEID"), @DER(id="1e2d9fdba388047e02ad8b2e4cb8ea39", name="DER1N_DATASYNCIN_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="3621f160a6392fc07fea086d691daa0d", majordename="DATAENTITY", minordename="DATASYNCIN", masterrs=0, pickupdefname="DEID"), @DER(id="a7ca173df623eafe0993ef8c1cb7ce56", name="DER1N_DATASYNCOUT2_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="1cecb3d95febd748a2daf8e9c86a8ec5", majordename="DATAENTITY", minordename="DATASYNCOUT2", masterrs=0, pickupdefname="DEID"), @DER(id="1bee3d42cc35ae68e2c216fd3450ace8", name="DER1N_DATASYNCOUT_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="c8381accf6c7621d57757a4955ddb504", majordename="DATAENTITY", minordename="DATASYNCOUT", masterrs=0, pickupdefname="DEID"), @DER(id="3cae02ebc5bd30e35ddae8d16a3cd0c2", name="DER1N_DEDATACHG2_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="2be4c985b8c11e06783904ce4e9d8b90", majordename="DATAENTITY", minordename="DEDATACHG2", masterrs=0, pickupdefname="DEID"), @DER(id="dd5f14db2aeccd0eed9324a65fac48de", name="DER1N_DEDATACHG_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="b46bdd8836d4e93bad690042e23ff374", majordename="DATAENTITY", minordename="DEDATACHG", masterrs=0, pickupdefname="DEID"), @DER(id="c7f4b6bab443a687f9d6a4a0652775e4", name="DER1N_DSDYNAVIEWINST_DSDYNAVIEW_DSDYNAVIEWID", type="DER1N", majordeid="87d8599997ce9323cd2bba43278b4135", minordeid="455ba35d2ea0b7be6e2035f54ff60f5b", majordename="DSDYNAVIEW", minordename="DSDYNAVIEWINST", masterrs=0, pickupdefname="DSDYNAVIEWID"), @DER(id="2c3f7e899a996bc416cec3c73769220b", name="DER1N_DSDYNAWFVER_DSDYNAWF_DSDYNAWFID", type="DER1N", majordeid="94ed000542e335afa0722bc1cbfdf279", minordeid="da1ebfa0f1777e651b33c7e1df73c4ec", majordename="DSDYNAWF", minordename="DSDYNAWFVER", masterrs=1, pickupdefname="DSDYNAWFID"), @DER(id="df7f1d11355a8a1723875d8d43aa137a", name="DER1N_LOGINACCOUNT_USER_USERID", type="DER1N", majordeid="f4552a6291c79e3934263b31b83aec33", minordeid="5ae7d9610693e638cd1064cf7c9126f8", majordename="USER", minordename="LOGINACCOUNT", masterrs=0, pickupdefname="USERID"), @DER(id="112ac206b9d83aa2e07750365aad59cb", name="DER1N_LOGINLOG_LOGINACCOUNT_LOGINACCOUNTID", type="DER1N", majordeid="5ae7d9610693e638cd1064cf7c9126f8", minordeid="7628b30c66aaeab68c9aec1aed3f7e21", majordename="LOGINACCOUNT", minordename="LOGINLOG", masterrs=0, pickupdefname="LOGINACCOUNTID"), @DER(id="6baea83229dbeddb3df2b5fc71adcb5b", name="DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID", type="DER1N", majordeid="7ce656616f83e08ed4aeba648bb0a30b", minordeid="b0a62e77dcb2ca3226353cea1c370b79", majordename="MSGACCOUNT", minordename="MSGACCOUNTDETAIL", masterrs=7, pickupdefname="MAJORMSGACCOUNTID"), @DER(id="2768f18f1b00ae87fd75c3a5f275cb02", name="DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID", type="DER1N", majordeid="7ce656616f83e08ed4aeba648bb0a30b", minordeid="b0a62e77dcb2ca3226353cea1c370b79", majordename="MSGACCOUNT", minordename="MSGACCOUNTDETAIL", masterrs=0, pickupdefname="MINORMSGACCOUNTID"), @DER(id="de59ed9eb9b555bc06e35224c3ae6c2b", name="DER1N_MSGTEMPLATE_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="e2c5b96d6cb0389900da130bc4545add", majordename="DATAENTITY", minordename="MSGTEMPLATE", masterrs=0, pickupdefname="DEID"), @DER(id="4985d3434f612c5d23ae9fa4b434e3eb", name="DER1N_ORGSECTOR_ORGSECTOR_PORGSECTORID", type="DER1N", majordeid="63061bfdafbbd213fc0ce66d3f26419e", minordeid="63061bfdafbbd213fc0ce66d3f26419e", majordename="ORGSECTOR", minordename="ORGSECTOR", masterrs=0, pickupdefname="PORGSECTORID"), @DER(id="4ac954e7df5461621e1996c284eeae39", name="DER1N_ORGSECTOR_ORGSECTOR_REPORGSECTORID", type="DER1N", majordeid="63061bfdafbbd213fc0ce66d3f26419e", minordeid="63061bfdafbbd213fc0ce66d3f26419e", majordename="ORGSECTOR", minordename="ORGSECTOR", masterrs=0, pickupdefname="REPORGSECTORID"), @DER(id="9b73d0648c9cd83f5c4413a7503de665", name="DER1N_ORGSECTOR_ORG_ORGID", type="DER1N", majordeid="e3e158d75b7bc6f589686b6e1beb966c", minordeid="63061bfdafbbd213fc0ce66d3f26419e", majordename="ORG", minordename="ORGSECTOR", masterrs=0, pickupdefname="ORGID"), @DER(id="039739dbaf58acdf0e2282f988acc319", name="DER1N_ORGSECUSER_ORGSECTOR_ORGSECTORID", type="DER1N", majordeid="63061bfdafbbd213fc0ce66d3f26419e", minordeid="a29184750c477cf3910fc2179179dccc", majordename="ORGSECTOR", minordename="ORGSECUSER", masterrs=0, pickupdefname="ORGSECTORID"), @DER(id="3fb9f4803139d36c71baa9b5d1fc673f", name="DER1N_ORGSECUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID", type="DER1N", majordeid="576dd33b28a3ee34ba68561c68aa93b3", minordeid="a29184750c477cf3910fc2179179dccc", majordename="ORGSECUSERTYPE", minordename="ORGSECUSER", masterrs=0, pickupdefname="ORGSECUSERTYPEID"), @DER(id="698edb9b7d3933dffd677d0af5da9d6c", name="DER1N_ORGSECUSER_ORGUSER_ORGUSERID", type="DER1N", majordeid="1f9576cdcc6a949230c7669182c73648", minordeid="a29184750c477cf3910fc2179179dccc", majordename="ORGUSER", minordename="ORGSECUSER", masterrs=0, pickupdefname="ORGUSERID"), @DER(id="b1568c2ef7918c4690bffc8cc39a8327", name="DER1N_ORGSECUSER_ORG_ORGID", type="DER1N", majordeid="e3e158d75b7bc6f589686b6e1beb966c", minordeid="a29184750c477cf3910fc2179179dccc", majordename="ORG", minordename="ORGSECUSER", masterrs=0, pickupdefname="ORGID"), @DER(id="c64c576f22b1072cdecf2c043cf9106b", name="DER1N_ORGUSER_ORGSECTOR_ORGSECTORID", type="DER1N", majordeid="63061bfdafbbd213fc0ce66d3f26419e", minordeid="1f9576cdcc6a949230c7669182c73648", majordename="ORGSECTOR", minordename="ORGUSER", masterrs=0, pickupdefname="ORGSECTORID"), @DER(id="eda174cf10516278ae0cf592e6ed9943", name="DER1N_ORGUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID", type="DER1N", majordeid="576dd33b28a3ee34ba68561c68aa93b3", minordeid="1f9576cdcc6a949230c7669182c73648", majordename="ORGSECUSERTYPE", minordename="ORGUSER", masterrs=0, pickupdefname="ORGSECUSERTYPEID"), @DER(id="d4fa384409c56f68322a2f0cab46cd75", name="DER1N_ORGUSER_ORGUSERLEVEL_ORGUSERLEVELID", type="DER1N", majordeid="e6c870c62a861cfd5593212fa41d6f88", minordeid="1f9576cdcc6a949230c7669182c73648", majordename="ORGUSERLEVEL", minordename="ORGUSER", masterrs=0, pickupdefname="ORGUSERLEVELID"), @DER(id="7ef88aac275d3d363f5981c8f53b9988", name="DER1N_ORGUSER_ORG_ORGID", type="DER1N", majordeid="e3e158d75b7bc6f589686b6e1beb966c", minordeid="1f9576cdcc6a949230c7669182c73648", majordename="ORG", minordename="ORGUSER", masterrs=0, pickupdefname="ORGID"), @DER(id="4572de06ad701dd628e9960bc055113e", name="DER1N_ORG_ORG_PORGID", type="DER1N", majordeid="e3e158d75b7bc6f589686b6e1beb966c", minordeid="e3e158d75b7bc6f589686b6e1beb966c", majordename="ORG", minordename="ORG", masterrs=0, pickupdefname="PORGID"), @DER(id="9147ed7184373dfae772ea5db9afa2ec", name="DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID", type="DER1N", majordeid="f63040021720d1401ec2014d30b02bb6", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PORTALPAGE", minordename="PPMODEL", masterrs=0, pickupdefname="PORTALPAGEID"), @DER(id="1FA00E9F-A266-433E-8C95-9AA615F10D35", name="DER1N_PPMODEL_PVPART_C1PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="C1PVPARTID"), @DER(id="D848A57B-A529-482F-AC73-977043C3FDAC", name="DER1N_PPMODEL_PVPART_C2PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="C2PVPARTID"), @DER(id="F3FE8428-161F-4FFE-B2C9-78418B5ED714", name="DER1N_PPMODEL_PVPART_C3PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="C3PVPARTID"), @DER(id="BA8ECEB3-7D9A-496D-B667-4FA9377EAE61", name="DER1N_PPMODEL_PVPART_C4PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="C4PVPARTID"), @DER(id="77D64820-2DC9-4828-87F7-2B3D20F78C2D", name="DER1N_PPMODEL_PVPART_L1PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="L1PVPARTID"), @DER(id="CD16E202-1010-4C47-BBED-77DED600D88F", name="DER1N_PPMODEL_PVPART_L2PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="L2PVPARTID"), @DER(id="0546BC6D-55EF-4035-A387-9ADDC5BAE305", name="DER1N_PPMODEL_PVPART_L3PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="L3PVPARTID"), @DER(id="44B29146-69C1-4ADF-841D-287AD281BB1B", name="DER1N_PPMODEL_PVPART_L4PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="L4PVPARTID"), @DER(id="168133AE-E7F2-4ECA-AEE7-6024461A186F", name="DER1N_PPMODEL_PVPART_R1PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="R1PVPARTID"), @DER(id="90A67CD5-A745-49F6-B5A0-5761278A8C49", name="DER1N_PPMODEL_PVPART_R2PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="R2PVPARTID"), @DER(id="F28672F2-1292-47FA-8AE4-172B90EE2DC3", name="DER1N_PPMODEL_PVPART_R3PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="R3PVPARTID"), @DER(id="6245CA0A-5D44-4C18-99EF-2831C221858C", name="DER1N_PPMODEL_PVPART_R4PVPARTID", type="DER1N", majordeid="d1ce1f760d77192f620b4f6b9d7769f8", minordeid="14ad5675b58882f0e61ba3caabcf6f5e", majordename="PVPART", minordename="PPMODEL", masterrs=0, pickupdefname="R4PVPARTID"), @DER(id="33f0a71e7c35aa4cd878d0c74f49c934", name="DER1N_PVPART_PORTALPAGE_PORTALPAGEID", type="DER1N", majordeid="f63040021720d1401ec2014d30b02bb6", minordeid="d1ce1f760d77192f620b4f6b9d7769f8", majordename="PORTALPAGE", minordename="PVPART", masterrs=1, pickupdefname="PORTALPAGEID"), @DER(id="11a7fc0706213efb7c5b035a8f044d14", name="DER1N_QUERYMODEL_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="ee650aec5d0df3c9880100dc57441146", majordename="DATAENTITY", minordename="QUERYMODEL", masterrs=0, pickupdefname="DEID"), @DER(id="e615bf186441877722a351ba6ece7d3f", name="DER1N_SYSADMINFUNC_SYSADMIN_SYSADMINID", type="DER1N", majordeid="089885ec20e095e248e78d49d3153815", minordeid="2e71859d8147cd788d815a3371f9ebd6", majordename="SYSADMIN", minordename="SYSADMINFUNC", masterrs=0, pickupdefname="SYSADMINID"), @DER(id="9e1bd95d49cd30bbe25f4afea9267142", name="DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID", type="DER1N", majordeid="f37da71b9c7217fb86634c135e6fb7e0", minordeid="e8b6c72b7a73a98f68bf91b812d46c31", majordename="TSSDGROUP", minordename="TSSDGROUPDETAIL", masterrs=0, pickupdefname="TSSDGROUPID"), @DER(id="8124434e843cf1f08d5fb07d2d54e9e7", name="DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID", type="DER1N", majordeid="7923f282cb5da8b2419d53cb6fc6e9a7", minordeid="e8b6c72b7a73a98f68bf91b812d46c31", majordename="TSSDITEM", minordename="TSSDGROUPDETAIL", masterrs=0, pickupdefname="TSSDITEMID"), @DER(id="7e6e292c4bc8b87e33c746ce352b90f0", name="DER1N_TSSDTASKLOG_TSSDTASK_TSSDTASKID", type="DER1N", majordeid="f8d12641ce30b874fa6c58f749b0bb73", minordeid="5d9604bc9220d47f935650303d154680", majordename="TSSDTASK", minordename="TSSDTASKLOG", masterrs=0, pickupdefname="TSSDTASKID"), @DER(id="319ae648b35fee410962855bf6d8332b", name="DER1N_TSSDTASKPOLICY_TSSDPOLICY_TSSDPOLICYID", type="DER1N", majordeid="0af0cc46519139106341b4cbfe9b89e7", minordeid="7fbddaf527849efd537411955e65800d", majordename="TSSDPOLICY", minordename="TSSDTASKPOLICY", masterrs=0, pickupdefname="TSSDPOLICYID"), @DER(id="102d9f722bdf57754c150d249c253fe2", name="DER1N_TSSDTASKPOLICY_TSSDTASK_TSSDTASKID", type="DER1N", majordeid="f8d12641ce30b874fa6c58f749b0bb73", minordeid="7fbddaf527849efd537411955e65800d", majordename="TSSDTASK", minordename="TSSDTASKPOLICY", masterrs=5, pickupdefname="TSSDTASKID"), @DER(id="2490b25836227a105fd744484250651d", name="DER1N_TSSDTASK_TSSDENGINE_TSSDENGINEID", type="DER1N", majordeid="e4da63c72c04866163e5a74ca984d13f", minordeid="f8d12641ce30b874fa6c58f749b0bb73", majordename="TSSDENGINE", minordename="TSSDTASK", masterrs=0, pickupdefname="TSSDENGINEID"), @DER(id="816a3c9fc6c7c768566a343f30a9e5ad", name="DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID", type="DER1N", majordeid="c41d9a5508a558b5ccc8a091c5e249b1", minordeid="4d49318ec5a12e0a9e36d79e45c641f2", majordename="USERDICTCAT", minordename="USERDICTITEM", masterrs=0, pickupdefname="USERDICTCATID"), @DER(id="45ea033c1c140b803db8112b9b345def", name="DER1N_USERDICTITEM_USERDICT_USERDICTID", type="DER1N", majordeid="de0f12cf67b20fb12eb5454093998c74", minordeid="4d49318ec5a12e0a9e36d79e45c641f2", majordename="USERDICT", minordename="USERDICTITEM", masterrs=5, pickupdefname="USERDICTID"), @DER(id="a33d43efdb58f6910c5cbca43cc22930", name="DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID", type="DER1N", majordeid="5eba267a2d34c0c5dc686961a48f62d1", minordeid="404bf990bacdba520e82d9603063c3dd", majordename="USERGROUP", minordename="USERGROUPDETAIL", masterrs=3, pickupdefname="USERGROUPID"), @DER(id="d2216828da19ff602cfdbb816d921f48", name="DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID", type="DER1N", majordeid="318a3649ecafa3b934925a0231207d09", minordeid="404bf990bacdba520e82d9603063c3dd", majordename="USEROBJECT", minordename="USERGROUPDETAIL", masterrs=3, pickupdefname="USEROBJECTID"), @DER(id="14815ab047b405f1703f66aa10b011f0", name="DER1N_USERROLEDATAACTION_USERROLEDATA_USERROLEDATAID", type="DER1N", majordeid="c4125399a698dc5f8acca6dc8b38b353", minordeid="0cc63f54de2a15b9a7db47ff805af49a", majordename="USERROLEDATA", minordename="USERROLEDATAACTION", masterrs=1, pickupdefname="USERROLEDATAID"), @DER(id="c13286609770010aadf50b74b6039785", name="DER1N_USERROLEDATADETAIL_QUERYMODEL_QUERYMODELID", type="DER1N", majordeid="ee650aec5d0df3c9880100dc57441146", minordeid="a54fc7fa42e8260cab1cb33393e222b1", majordename="QUERYMODEL", minordename="USERROLEDATADETAIL", masterrs=3, pickupdefname="QUERYMODELID"), @DER(id="f4161eb5fbed839ac5979824062f5ec0", name="DER1N_USERROLEDATADETAIL_USERROLEDATA_USERROLEDATAID", type="DER1N", majordeid="c4125399a698dc5f8acca6dc8b38b353", minordeid="a54fc7fa42e8260cab1cb33393e222b1", majordename="USERROLEDATA", minordename="USERROLEDATADETAIL", masterrs=7, pickupdefname="USERROLEDATAID"), @DER(id="bce5036d19290a1d1f71e80e076e1ad6", name="DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID", type="DER1N", majordeid="c4125399a698dc5f8acca6dc8b38b353", minordeid="b2af03b3659b89cfbfc6f8932ff1b61f", majordename="USERROLEDATA", minordename="USERROLEDATAS", masterrs=7, pickupdefname="USERROLEDATAID"), @DER(id="009216e13b6229bf1af5bb2063006b3f", name="DER1N_USERROLEDATAS_USERROLE_USERROLEID", type="DER1N", majordeid="1e40618663977c439800bf56d8ac4390", minordeid="b2af03b3659b89cfbfc6f8932ff1b61f", majordename="USERROLE", minordename="USERROLEDATAS", masterrs=7, pickupdefname="USERROLEID"), @DER(id="632e7bf4b3451ef4f33e536cb11e58bc", name="DER1N_USERROLEDATA_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="c4125399a698dc5f8acca6dc8b38b353", majordename="DATAENTITY", minordename="USERROLEDATA", masterrs=1, pickupdefname="DEID"), @DER(id="8073CCE8-085F-438D-A69F-7B519E115ABF", name="DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID", type="DER1N", majordeid="63061bfdafbbd213fc0ce66d3f26419e", minordeid="c4125399a698dc5f8acca6dc8b38b353", majordename="ORGSECTOR", minordename="USERROLEDATA", masterrs=0, pickupdefname="DSTORGSECTORID"), @DER(id="418AF732-99EB-4853-87E7-2F1D98022A03", name="DER1N_USERROLEDATA_ORG_DSTORGID", type="DER1N", majordeid="e3e158d75b7bc6f589686b6e1beb966c", minordeid="c4125399a698dc5f8acca6dc8b38b353", majordename="ORG", minordename="USERROLEDATA", masterrs=0, pickupdefname="DSTORGID"), @DER(id="1a468bb598fd7359388e092714af54a1", name="DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID", type="DER1N", majordeid="10d6c2ea8dda8754dcde1bceab9704c5", minordeid="c95a8972b0f72a140d65e057a002144a", majordename="USERROLEDEFIELD", minordename="USERROLEDEFIELDS", masterrs=3, pickupdefname="USERROLEDEFIELDID"), @DER(id="ea0eaa76b1fe9fef40baea2da6ec5716", name="DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID", type="DER1N", majordeid="1e40618663977c439800bf56d8ac4390", minordeid="c95a8972b0f72a140d65e057a002144a", majordename="USERROLE", minordename="USERROLEDEFIELDS", masterrs=3, pickupdefname="USERROLEID"), @DER(id="eb751ef3ced5b2f39136c706a1cf8ac5", name="DER1N_USERROLEDEFIELD_DATAENTITY_DEID", type="DER1N", majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2", minordeid="10d6c2ea8dda8754dcde1bceab9704c5", majordename="DATAENTITY", minordename="USERROLEDEFIELD", masterrs=0, pickupdefname="DEID"), @DER(id="c5889a1d7a44fb5e162dba1377ba8dc1", name="DER1N_USERROLEDETAIL_USEROBJECT_USEROBJECTID", type="DER1N", majordeid="318a3649ecafa3b934925a0231207d09", minordeid="a6ba8b8895f3f2438f9e9ef761ccb29c", majordename="USEROBJECT", minordename="USERROLEDETAIL", masterrs=7, pickupdefname="USEROBJECTID"), @DER(id="94ab233ca60b50ab4e8bed7281b09fc7", name="DER1N_USERROLEDETAIL_USERROLE_USERROLEID", type="DER1N", majordeid="1e40618663977c439800bf56d8ac4390", minordeid="a6ba8b8895f3f2438f9e9ef761ccb29c", majordename="USERROLE", minordename="USERROLEDETAIL", masterrs=7, pickupdefname="USERROLEID"), @DER(id="7855e1ce00f0ec5b85f9912bd786a59d", name="DER1N_USERROLERES_UNIRES_UNIRESID", type="DER1N", majordeid="88d390ffbdb76f146f608c669729d81d", minordeid="ee84bfb6e336a62bdcd671895549aebe", majordename="UNIRES", minordename="USERROLERES", masterrs=3, pickupdefname="UNIRESID"), @DER(id="3fabb41f1c288768eb38179ce4375b1c", name="DER1N_USERROLERES_USERROLE_USERROLEID", type="DER1N", majordeid="1e40618663977c439800bf56d8ac4390", minordeid="ee84bfb6e336a62bdcd671895549aebe", majordename="USERROLE", minordename="USERROLERES", masterrs=7, pickupdefname="USERROLEID"), @DER(id="5f482026eec8d0778d155d7945fe9e3e", name="DER1N_WFACTION_WFWORKFLOW_WFWORKFLOWID", type="DER1N", majordeid="0166e9c016bf57201ba996cba3a67a45", minordeid="50811730d38a8bd964a31a05331bc214", majordename="WFWORKFLOW", minordename="WFACTION", masterrs=0, pickupdefname="WFWORKFLOWID"), @DER(id="CF68E169-CAF0-4B3E-A0BD-5D625C248B91", name="DER1N_WFAPPSETTING_MSGTEMPLATE_REMINDMSGTEMPID", type="DER1N", majordeid="e2c5b96d6cb0389900da130bc4545add", minordeid="598b85c09bc9375e762590d2ab97552c", majordename="MSGTEMPLATE", minordename="WFAPPSETTING", masterrs=0, pickupdefname="REMINDMSGTEMPID"), @DER(id="5f68ca9cf3fef51ccc62327d94d904d6", name="DER1N_WFASSISTWORK_WFINSTANCE_WFINSTANCEID", type="DER1N", majordeid="0211d06b901d7948d2394149b7d0d96e", minordeid="80bc47afe28e23ebfb7aea12fdbc1acd", majordename="WFINSTANCE", minordename="WFASSISTWORK", masterrs=0, pickupdefname="WFINSTANCEID"), @DER(id="4e27fa512548502bb53180923b46257e", name="DER1N_WFASSISTWORK_WFSTEPACTOR_WFSTEPACTORID", type="DER1N", majordeid="3860c42c755f4097c4dfe7d806b185bc", minordeid="80bc47afe28e23ebfb7aea12fdbc1acd", majordename="WFSTEPACTOR", minordename="WFASSISTWORK", masterrs=0, pickupdefname="WFSTEPACTORID"), @DER(id="756f259ec2f765f2556894f2575d8284", name="DER1N_WFASSISTWORK_WFWORKFLOW_WFWORKFLOWID", type="DER1N", majordeid="0166e9c016bf57201ba996cba3a67a45", minordeid="80bc47afe28e23ebfb7aea12fdbc1acd", majordename="WFWORKFLOW", minordename="WFASSISTWORK", masterrs=0, pickupdefname="WFWORKFLOWID"), @DER(id="8de4cf4868586b92e9e7da5466952329", name="DER1N_WFIAACTION_WFSTEP_WFSTEPID", type="DER1N", majordeid="aa16d05a90245cec51dc8a2fb7f63fdb", minordeid="e1ba3122fd9af91ae76dd18bf015669a", majordename="WFSTEP", minordename="WFIAACTION", masterrs=0, pickupdefname="WFSTEPID"), @DER(id="320BB681-03BC-4218-87F8-E425B288AE97", name="DER1N_WFINSTANCE_ORG_ORGID", type="DER1N", majordeid="e3e158d75b7bc6f589686b6e1beb966c", minordeid="0211d06b901d7948d2394149b7d0d96e", majordename="ORG", minordename="WFINSTANCE", masterrs=0, pickupdefname="ORGID"), @DER(id="0e24814e3d1572e3f06d4f36c7c5de9f", name="DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID", type="DER1N", majordeid="0211d06b901d7948d2394149b7d0d96e", minordeid="0211d06b901d7948d2394149b7d0d96e", majordename="WFINSTANCE", minordename="WFINSTANCE", masterrs=0, pickupdefname="PWFINSTANCEID"), @DER(id="8097c1878cf34b7d5a2618d26684dcb5", name="DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID", type="DER1N", majordeid="0166e9c016bf57201ba996cba3a67a45", minordeid="0211d06b901d7948d2394149b7d0d96e", majordename="WFWORKFLOW", minordename="WFINSTANCE", masterrs=0, pickupdefname="WFWORKFLOWID"), @DER(id="2112baeba2c7f01d9862c28344770bb3", name="DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID", type="DER1N", majordeid="3860c42c755f4097c4dfe7d806b185bc", minordeid="352ff0280b4d127a400f4262d6ebfded", majordename="WFSTEPACTOR", minordename="WFREMINDER", masterrs=0, pickupdefname="WFSTEPACTORID"), @DER(id="a0a110c3f3c7328f10e027bc9cbad882", name="DER1N_WFREMINDER_WFUSER_WFUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="352ff0280b4d127a400f4262d6ebfded", majordename="WFUSER", minordename="WFREMINDER", masterrs=0, pickupdefname="WFUSERID"), @DER(id="df958687a02982a4cd68af51ad5732ef", name="DER1N_WFSTEPACTOR_WFSTEP_WFSTEPID", type="DER1N", majordeid="aa16d05a90245cec51dc8a2fb7f63fdb", minordeid="3860c42c755f4097c4dfe7d806b185bc", majordename="WFSTEP", minordename="WFSTEPACTOR", masterrs=0, pickupdefname="WFSTEPID"), @DER(id="005C8C79-8C7E-4A68-A7C3-1E8E0D09FCC4", name="DER1N_WFSTEPACTOR_WFUSER_ORIGINALWFUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="3860c42c755f4097c4dfe7d806b185bc", majordename="WFUSER", minordename="WFSTEPACTOR", masterrs=0, pickupdefname="ORIGINALWFUSERID"), @DER(id="616cb82677f494e69eebd92deec244f9", name="DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID", type="DER1N", majordeid="0211d06b901d7948d2394149b7d0d96e", minordeid="095ff4eab83529a1b8f093180a7ef3fa", majordename="WFINSTANCE", minordename="WFSTEPDATA", masterrs=0, pickupdefname="WFINSTANCEID"), @DER(id="5f80942fa364725bebae0ba7029344f7", name="DER1N_WFSTEPDATA_WFSTEP_WFSTEPID", type="DER1N", majordeid="aa16d05a90245cec51dc8a2fb7f63fdb", minordeid="095ff4eab83529a1b8f093180a7ef3fa", majordename="WFSTEP", minordename="WFSTEPDATA", masterrs=0, pickupdefname="WFSTEPID"), @DER(id="62982D23-52D6-46B4-86A3-A35358D31E3D", name="DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="095ff4eab83529a1b8f093180a7ef3fa", majordename="WFUSER", minordename="WFSTEPDATA", masterrs=0, pickupdefname="ORIGINALWFUSERID"), @DER(id="3072ea9cfb909379f3b4fb234d646e45", name="DER1N_WFSTEPINST_WFINSTANCE_WFINSTANCEID", type="DER1N", majordeid="0211d06b901d7948d2394149b7d0d96e", minordeid="707f76a538be385bf4bf65a2b1125003", majordename="WFINSTANCE", minordename="WFSTEPINST", masterrs=0, pickupdefname="WFINSTANCEID"), @DER(id="ad2f6511189748f7d19fb8e45781e988", name="DER1N_WFSTEPINST_WFSTEP_WFSTEPID", type="DER1N", majordeid="aa16d05a90245cec51dc8a2fb7f63fdb", minordeid="707f76a538be385bf4bf65a2b1125003", majordename="WFSTEP", minordename="WFSTEPINST", masterrs=0, pickupdefname="WFSTEPID"), @DER(id="ed32886f9f70deccef8b87f2f5dafab5", name="DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID", type="DER1N", majordeid="0211d06b901d7948d2394149b7d0d96e", minordeid="aa16d05a90245cec51dc8a2fb7f63fdb", majordename="WFINSTANCE", minordename="WFSTEP", masterrs=0, pickupdefname="WFINSTANCEID"), @DER(id="ab31530b21b9769706f6a2fbeeb9f9a7", name="DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID", type="DER1N", majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7", minordeid="0e976da1c2895bf2e955f90554c10b15", majordename="WFACTOR", minordename="WFTMPSTEPACTOR", masterrs=0, pickupdefname="WFACTORID"), @DER(id="c63d3e12576fa39727d412500b8987f4", name="DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID", type="DER1N", majordeid="aa16d05a90245cec51dc8a2fb7f63fdb", minordeid="0e976da1c2895bf2e955f90554c10b15", majordename="WFSTEP", minordename="WFTMPSTEPACTOR", masterrs=0, pickupdefname="PREVWFSTEPID"), @DER(id="75e6cc0f9a99dfa020b0520a0f76f28d", name="DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="fa6ff2a161c8371f494e170dde6ddb53", majordename="WFUSER", minordename="WFUCPOLICY", masterrs=5, pickupdefname="MAJORWFUSERID"), @DER(id="cdeb6924e468218750aa54ffd43fbe91", name="DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="fa6ff2a161c8371f494e170dde6ddb53", majordename="WFUSER", minordename="WFUCPOLICY", masterrs=0, pickupdefname="MINORWFUSERID"), @DER(id="69c0793b95a21868e494577c5fc3cd5c", name="DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="c0a02fe821e07837af3333a49fb08b30", majordename="WFUSER", minordename="WFUSERASSIST", masterrs=0, pickupdefname="WFMAJORUSERID"), @DER(id="748c7e4b9050643eca7dafc43e9ed0fd", name="DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="c0a02fe821e07837af3333a49fb08b30", majordename="WFUSER", minordename="WFUSERASSIST", masterrs=0, pickupdefname="WFMINORUSERID"), @DER(id="ddc14d8f88d17c3a4c3caddf78a99357", name="DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID", type="DER1N", majordeid="0166e9c016bf57201ba996cba3a67a45", minordeid="c0a02fe821e07837af3333a49fb08b30", majordename="WFWORKFLOW", minordename="WFUSERASSIST", masterrs=0, pickupdefname="WFWORKFLOWID"), @DER(id="48824f5e6e0527d348c27233c8541df7", name="DER1N_WFUSERCANDIDATE_WFUSER_WFMAJORUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="9f2a5bbda357d70344cb5debd7d05c71", majordename="WFUSER", minordename="WFUSERCANDIDATE", masterrs=0, pickupdefname="WFMAJORUSERID"), @DER(id="8d9808ac3dd5b5d89db44f2a2a3da1c4", name="DER1N_WFUSERCANDIDATE_WFUSER_WFMINORUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="9f2a5bbda357d70344cb5debd7d05c71", majordename="WFUSER", minordename="WFUSERCANDIDATE", masterrs=0, pickupdefname="WFMINORUSERID"), @DER(id="3394c2a890c8f95f5864a8656ec0423a", name="DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID", type="DER1N", majordeid="e64a576e41250c73ac1f51c15d6631e2", minordeid="0b60b3e6ed35cc656ceecb6fac698e6e", majordename="WFUSERGROUP", minordename="WFUSERGROUPDETAIL", masterrs=3, pickupdefname="WFUSERGROUPID"), @DER(id="376e40d56e10ff46457f47a8dd066db0", name="DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="0b60b3e6ed35cc656ceecb6fac698e6e", majordename="WFUSER", minordename="WFUSERGROUPDETAIL", masterrs=3, pickupdefname="WFUSERID"), @DER(id="062f9bbb6348d5a732fc7152835525d8", name="DER1N_WFWFVERSION_WFWORKFLOW_WFWFID", type="DER1N", majordeid="0166e9c016bf57201ba996cba3a67a45", minordeid="f0abca40127ddf436270635ba0e3c135", majordename="WFWORKFLOW", minordename="WFWFVERSION", masterrs=0, pickupdefname="WFWFID"), @DER(id="0780B21E-BFC7-44A1-934D-21FF0F7834A5", name="DER1N_WFWORKFLOW_MSGTEMPLATE_REMINDMSGTEMPLID", type="DER1N", majordeid="e2c5b96d6cb0389900da130bc4545add", minordeid="0166e9c016bf57201ba996cba3a67a45", majordename="MSGTEMPLATE", minordename="WFWORKFLOW", masterrs=0, pickupdefname="REMINDMSGTEMPLID"), @DER(id="8F946D79-D3FA-41EC-B8D4-3F4C84606912", name="DER1N_WFWORKLIST2_WFINSTANCE_WFINSTANCEID", type="DER1N", majordeid="0211d06b901d7948d2394149b7d0d96e", minordeid="e888ed9d1cfcb38ac15cceaa4130b162", majordename="WFINSTANCE", minordename="WFWORKLIST2", masterrs=0, pickupdefname="WFINSTANCEID"), @DER(id="667736E8-E0DE-4FEA-96CF-2EF9E04DB7A8", name="DER1N_WFWORKLIST2_WFUSER_ORIGINALWFUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="e888ed9d1cfcb38ac15cceaa4130b162", majordename="WFUSER", minordename="WFWORKLIST2", masterrs=0, pickupdefname="ORIGINALWFUSERID"), @DER(id="802abef14e1abf4be1f76c09383c19de", name="DER1N_WFWORKLIST_WFINSTANCE_WFINSTANCEID", type="DER1N", majordeid="0211d06b901d7948d2394149b7d0d96e", minordeid="c93ef4408352303441d2f73e0e4990a2", majordename="WFINSTANCE", minordename="WFWORKLIST", masterrs=0, pickupdefname="WFINSTANCEID"), @DER(id="A764D6F8-DCD8-4670-AE22-6984474CDD1C", name="DER1N_WFWORKLIST_WFUSER_ORIGINALWFUSERID", type="DER1N", majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", minordeid="c93ef4408352303441d2f73e0e4990a2", majordename="WFUSER", minordename="WFWORKLIST", masterrs=0, pickupdefname="ORIGINALWFUSERID"), @DER(id="4a1aa49749e2057269bba6a500bd0ab7", name="DER1N_WXACCESSTOKEN_WXACCOUNT_WXACCOUNTID", type="DER1N", majordeid="a807f4b43d86fbcad55c58e4621a8c80", minordeid="7c0817a9156329b7eed4a878988f31cc", majordename="WXACCOUNT", minordename="WXACCESSTOKEN", masterrs=0, pickupdefname="WXACCOUNTID"), @DER(id="c66aa6aa9829065286380810811d4993", name="DER1N_WXACCOUNT_ORG_ORGID", type="DER1N", majordeid="e3e158d75b7bc6f589686b6e1beb966c", minordeid="a807f4b43d86fbcad55c58e4621a8c80", majordename="ORG", minordename="WXACCOUNT", masterrs=0, pickupdefname="ORGID"), @DER(id="0c3183f54dde288ca2faaa5a2a72d5e9", name="DER1N_WXENTAPP_WXACCOUNT_WXACCOUNTID", type="DER1N", majordeid="a807f4b43d86fbcad55c58e4621a8c80", minordeid="aeb4861b6d65eff3ef2098ddd7a0d4f5", majordename="WXACCOUNT", minordename="WXENTAPP", masterrs=0, pickupdefname="WXACCOUNTID"), @DER(id="4aa536c534ffdc4cb313289b449291da", name="DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID", type="DER1N", majordeid="a807f4b43d86fbcad55c58e4621a8c80", minordeid="6e265a32be682141a452a8832bc78530", majordename="WXACCOUNT", minordename="WXMEDIA", masterrs=0, pickupdefname="WXACCOUNTID"), @DER(id="2e9be8bfb53a6e12b1fe91a6d96081b1", name="DER1N_WXMEDIA_WXENTAPP_WXENTAPPID", type="DER1N", majordeid="aeb4861b6d65eff3ef2098ddd7a0d4f5", minordeid="6e265a32be682141a452a8832bc78530", majordename="WXENTAPP", minordename="WXMEDIA", masterrs=0, pickupdefname="WXENTAPPID"), @DER(id="e489a0c18fefe28b35f154f7c63eaa3a", name="DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID", type="DER1N", majordeid="a807f4b43d86fbcad55c58e4621a8c80", minordeid="657d40a805a0f204934829160a198bb7", majordename="WXACCOUNT", minordename="WXMESSAGE", masterrs=0, pickupdefname="WXACCOUNTID"), @DER(id="033908d98baf605c5f0136b12140a381", name="DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID", type="DER1N", majordeid="aeb4861b6d65eff3ef2098ddd7a0d4f5", minordeid="657d40a805a0f204934829160a198bb7", majordename="WXENTAPP", minordename="WXMESSAGE", masterrs=0, pickupdefname="WXENTAPPID"), @DER(id="a318a4042da740195b6afdebe4047f25", name="DER1N_WXORGSECTOR_ORGSECTOR_ORGSECTORID", type="DER1N", majordeid="63061bfdafbbd213fc0ce66d3f26419e", minordeid="2b5ee3ad72f76d2cb7d12f8c5f31b817", majordename="ORGSECTOR", minordename="WXORGSECTOR", masterrs=0, pickupdefname="ORGSECTORID"), @DER(id="3d51e9b7863df17d47d50c73a21a1413", name="DER1N_WXORGSECTOR_WXACCOUNT_WXACCOUNTID", type="DER1N", majordeid="a807f4b43d86fbcad55c58e4621a8c80", minordeid="2b5ee3ad72f76d2cb7d12f8c5f31b817", majordename="WXACCOUNT", minordename="WXORGSECTOR", masterrs=0, pickupdefname="WXACCOUNTID"), @DER(id="a7f689243bc823d7aea798e6c7f3b7a6", name="DERINDEX_WFDYNAMICUSER_WFACTOR", type="DERINDEX", majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7", minordeid="733170434261be84089d353a6a231373", majordename="WFACTOR", minordename="WFDYNAMICUSER", indexvalue="DYNAMICUSER"), @DER(id="239b3eb687da5f9fc4c32559bb8b12c9", name="DERINDEX_WFSYSTEMUSER_WFACTOR", type="DERINDEX", majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7", minordeid="3d6fd9746bb1acf4b6af87da05f6a646", majordename="WFACTOR", minordename="WFSYSTEMUSER", indexvalue="SYSTEMUSER"), @DER(id="da7e61a04a493ac3a5de582c1cf7ff21", name="DERINDEX_WFUSERGROUP_WFACTOR", type="DERINDEX", majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7", minordeid="e64a576e41250c73ac1f51c15d6631e2", majordename="WFACTOR", minordename="WFUSERGROUP", indexvalue="USERGROUP"), @DER(id="b66d862165d2dc4ced13946380ee8910", name="DERINDEX_WFUSER_WFACTOR", type="DERINDEX", majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7", minordeid="ef2c7b349c855e594aa4fe0cb7ad8b48", majordename="WFACTOR", minordename="WFUSER", indexvalue="USER"), @DER(id="c0558f7368a6a1a9ec5fbb5c8de6a8b9", name="DERINHERIT_USERGROUP_USEROBJECT", type="DERINHERIT", majordeid="318a3649ecafa3b934925a0231207d09", minordeid="5eba267a2d34c0c5dc686961a48f62d1", majordename="USEROBJECT", minordename="USERGROUP", indexvalue="USERGROUP"), @DER(id="403d507e89bbf1c6ec3c33e4bed9df17", name="DERINHERIT_USER_USEROBJECT", type="DERINHERIT", majordeid="318a3649ecafa3b934925a0231207d09", minordeid="f4552a6291c79e3934263b31b83aec33", majordename="USEROBJECT", minordename="USER", indexvalue="USER")})
public abstract class PSRuntimeSysModelBase
extends SystemModelBase {
    private static final Log log = LogFactory.getLog(PSRuntimeSysModelBase.class);
    public static final String DER1N_CODEITEM_CODEITEM_PCODEITEMID = "DER1N_CODEITEM_CODEITEM_PCODEITEMID";
    public static final String DER1N_CODEITEM_CODELIST_CODELISTID = "DER1N_CODEITEM_CODELIST_CODELISTID";
    public static final String DER1N_CODELIST_DATAENTITY_DEID = "DER1N_CODELIST_DATAENTITY_DEID";
    public static final String DER1N_DATAAUDITDETAIL_DATAAUDIT_DATAAUDITID = "DER1N_DATAAUDITDETAIL_DATAAUDIT_DATAAUDITID";
    public static final String DER1N_DATAENTITY_DATAENTITY_DER11DEID = "DER1N_DATAENTITY_DATAENTITY_DER11DEID";
    public static final String DER1N_DATAENTITY_QUERYMODEL_ACQUERYMODELID = "DER1N_DATAENTITY_QUERYMODEL_ACQUERYMODELID";
    public static final String DER1N_DATASYNCIN2_DATAENTITY_DEID = "DER1N_DATASYNCIN2_DATAENTITY_DEID";
    public static final String DER1N_DATASYNCIN_DATAENTITY_DEID = "DER1N_DATASYNCIN_DATAENTITY_DEID";
    public static final String DER1N_DATASYNCOUT2_DATAENTITY_DEID = "DER1N_DATASYNCOUT2_DATAENTITY_DEID";
    public static final String DER1N_DATASYNCOUT_DATAENTITY_DEID = "DER1N_DATASYNCOUT_DATAENTITY_DEID";
    public static final String DER1N_DEDATACHG2_DATAENTITY_DEID = "DER1N_DEDATACHG2_DATAENTITY_DEID";
    public static final String DER1N_DEDATACHG_DATAENTITY_DEID = "DER1N_DEDATACHG_DATAENTITY_DEID";
    public static final String DER1N_DSDYNAVIEWINST_DSDYNAVIEW_DSDYNAVIEWID = "DER1N_DSDYNAVIEWINST_DSDYNAVIEW_DSDYNAVIEWID";
    public static final String DER1N_DSDYNAWFVER_DSDYNAWF_DSDYNAWFID = "DER1N_DSDYNAWFVER_DSDYNAWF_DSDYNAWFID";
    public static final String DER1N_LOGINACCOUNT_USER_USERID = "DER1N_LOGINACCOUNT_USER_USERID";
    public static final String DER1N_LOGINLOG_LOGINACCOUNT_LOGINACCOUNTID = "DER1N_LOGINLOG_LOGINACCOUNT_LOGINACCOUNTID";
    public static final String DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID = "DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID";
    public static final String DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID = "DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID";
    public static final String DER1N_MSGTEMPLATE_DATAENTITY_DEID = "DER1N_MSGTEMPLATE_DATAENTITY_DEID";
    public static final String DER1N_ORGSECTOR_ORGSECTOR_PORGSECTORID = "DER1N_ORGSECTOR_ORGSECTOR_PORGSECTORID";
    public static final String DER1N_ORGSECTOR_ORGSECTOR_REPORGSECTORID = "DER1N_ORGSECTOR_ORGSECTOR_REPORGSECTORID";
    public static final String DER1N_ORGSECTOR_ORG_ORGID = "DER1N_ORGSECTOR_ORG_ORGID";
    public static final String DER1N_ORGSECUSER_ORGSECTOR_ORGSECTORID = "DER1N_ORGSECUSER_ORGSECTOR_ORGSECTORID";
    public static final String DER1N_ORGSECUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID = "DER1N_ORGSECUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID";
    public static final String DER1N_ORGSECUSER_ORGUSER_ORGUSERID = "DER1N_ORGSECUSER_ORGUSER_ORGUSERID";
    public static final String DER1N_ORGSECUSER_ORG_ORGID = "DER1N_ORGSECUSER_ORG_ORGID";
    public static final String DER1N_ORGUSER_ORGSECTOR_ORGSECTORID = "DER1N_ORGUSER_ORGSECTOR_ORGSECTORID";
    public static final String DER1N_ORGUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID = "DER1N_ORGUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID";
    public static final String DER1N_ORGUSER_ORGUSERLEVEL_ORGUSERLEVELID = "DER1N_ORGUSER_ORGUSERLEVEL_ORGUSERLEVELID";
    public static final String DER1N_ORGUSER_ORG_ORGID = "DER1N_ORGUSER_ORG_ORGID";
    public static final String DER1N_ORG_ORG_PORGID = "DER1N_ORG_ORG_PORGID";
    public static final String DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID = "DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID";
    public static final String DER1N_PPMODEL_PVPART_C1PVPARTID = "DER1N_PPMODEL_PVPART_C1PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_C2PVPARTID = "DER1N_PPMODEL_PVPART_C2PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_C3PVPARTID = "DER1N_PPMODEL_PVPART_C3PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_C4PVPARTID = "DER1N_PPMODEL_PVPART_C4PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_L1PVPARTID = "DER1N_PPMODEL_PVPART_L1PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_L2PVPARTID = "DER1N_PPMODEL_PVPART_L2PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_L3PVPARTID = "DER1N_PPMODEL_PVPART_L3PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_L4PVPARTID = "DER1N_PPMODEL_PVPART_L4PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_R1PVPARTID = "DER1N_PPMODEL_PVPART_R1PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_R2PVPARTID = "DER1N_PPMODEL_PVPART_R2PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_R3PVPARTID = "DER1N_PPMODEL_PVPART_R3PVPARTID";
    public static final String DER1N_PPMODEL_PVPART_R4PVPARTID = "DER1N_PPMODEL_PVPART_R4PVPARTID";
    public static final String DER1N_PVPART_PORTALPAGE_PORTALPAGEID = "DER1N_PVPART_PORTALPAGE_PORTALPAGEID";
    public static final String DER1N_QUERYMODEL_DATAENTITY_DEID = "DER1N_QUERYMODEL_DATAENTITY_DEID";
    public static final String DER1N_SYSADMINFUNC_SYSADMIN_SYSADMINID = "DER1N_SYSADMINFUNC_SYSADMIN_SYSADMINID";
    public static final String DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID = "DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID";
    public static final String DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID = "DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID";
    public static final String DER1N_TSSDTASKLOG_TSSDTASK_TSSDTASKID = "DER1N_TSSDTASKLOG_TSSDTASK_TSSDTASKID";
    public static final String DER1N_TSSDTASKPOLICY_TSSDPOLICY_TSSDPOLICYID = "DER1N_TSSDTASKPOLICY_TSSDPOLICY_TSSDPOLICYID";
    public static final String DER1N_TSSDTASKPOLICY_TSSDTASK_TSSDTASKID = "DER1N_TSSDTASKPOLICY_TSSDTASK_TSSDTASKID";
    public static final String DER1N_TSSDTASK_TSSDENGINE_TSSDENGINEID = "DER1N_TSSDTASK_TSSDENGINE_TSSDENGINEID";
    public static final String DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID = "DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID";
    public static final String DER1N_USERDICTITEM_USERDICT_USERDICTID = "DER1N_USERDICTITEM_USERDICT_USERDICTID";
    public static final String DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID = "DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID";
    public static final String DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID = "DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID";
    public static final String DER1N_USERROLEDATAACTION_USERROLEDATA_USERROLEDATAID = "DER1N_USERROLEDATAACTION_USERROLEDATA_USERROLEDATAID";
    public static final String DER1N_USERROLEDATADETAIL_QUERYMODEL_QUERYMODELID = "DER1N_USERROLEDATADETAIL_QUERYMODEL_QUERYMODELID";
    public static final String DER1N_USERROLEDATADETAIL_USERROLEDATA_USERROLEDATAID = "DER1N_USERROLEDATADETAIL_USERROLEDATA_USERROLEDATAID";
    public static final String DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID = "DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID";
    public static final String DER1N_USERROLEDATAS_USERROLE_USERROLEID = "DER1N_USERROLEDATAS_USERROLE_USERROLEID";
    public static final String DER1N_USERROLEDATA_DATAENTITY_DEID = "DER1N_USERROLEDATA_DATAENTITY_DEID";
    public static final String DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID = "DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID";
    public static final String DER1N_USERROLEDATA_ORG_DSTORGID = "DER1N_USERROLEDATA_ORG_DSTORGID";
    public static final String DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID = "DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID";
    public static final String DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID = "DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID";
    public static final String DER1N_USERROLEDEFIELD_DATAENTITY_DEID = "DER1N_USERROLEDEFIELD_DATAENTITY_DEID";
    public static final String DER1N_USERROLEDETAIL_USEROBJECT_USEROBJECTID = "DER1N_USERROLEDETAIL_USEROBJECT_USEROBJECTID";
    public static final String DER1N_USERROLEDETAIL_USERROLE_USERROLEID = "DER1N_USERROLEDETAIL_USERROLE_USERROLEID";
    public static final String DER1N_USERROLERES_UNIRES_UNIRESID = "DER1N_USERROLERES_UNIRES_UNIRESID";
    public static final String DER1N_USERROLERES_USERROLE_USERROLEID = "DER1N_USERROLERES_USERROLE_USERROLEID";
    public static final String DER1N_WFACTION_WFWORKFLOW_WFWORKFLOWID = "DER1N_WFACTION_WFWORKFLOW_WFWORKFLOWID";
    public static final String DER1N_WFAPPSETTING_MSGTEMPLATE_REMINDMSGTEMPID = "DER1N_WFAPPSETTING_MSGTEMPLATE_REMINDMSGTEMPID";
    public static final String DER1N_WFASSISTWORK_WFINSTANCE_WFINSTANCEID = "DER1N_WFASSISTWORK_WFINSTANCE_WFINSTANCEID";
    public static final String DER1N_WFASSISTWORK_WFSTEPACTOR_WFSTEPACTORID = "DER1N_WFASSISTWORK_WFSTEPACTOR_WFSTEPACTORID";
    public static final String DER1N_WFASSISTWORK_WFWORKFLOW_WFWORKFLOWID = "DER1N_WFASSISTWORK_WFWORKFLOW_WFWORKFLOWID";
    public static final String DER1N_WFIAACTION_WFSTEP_WFSTEPID = "DER1N_WFIAACTION_WFSTEP_WFSTEPID";
    public static final String DER1N_WFINSTANCE_ORG_ORGID = "DER1N_WFINSTANCE_ORG_ORGID";
    public static final String DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID = "DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID";
    public static final String DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID = "DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID";
    public static final String DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID = "DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID";
    public static final String DER1N_WFREMINDER_WFUSER_WFUSERID = "DER1N_WFREMINDER_WFUSER_WFUSERID";
    public static final String DER1N_WFSTEPACTOR_WFSTEP_WFSTEPID = "DER1N_WFSTEPACTOR_WFSTEP_WFSTEPID";
    public static final String DER1N_WFSTEPACTOR_WFUSER_ORIGINALWFUSERID = "DER1N_WFSTEPACTOR_WFUSER_ORIGINALWFUSERID";
    public static final String DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID = "DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID";
    public static final String DER1N_WFSTEPDATA_WFSTEP_WFSTEPID = "DER1N_WFSTEPDATA_WFSTEP_WFSTEPID";
    public static final String DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID = "DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID";
    public static final String DER1N_WFSTEPINST_WFINSTANCE_WFINSTANCEID = "DER1N_WFSTEPINST_WFINSTANCE_WFINSTANCEID";
    public static final String DER1N_WFSTEPINST_WFSTEP_WFSTEPID = "DER1N_WFSTEPINST_WFSTEP_WFSTEPID";
    public static final String DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID = "DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID";
    public static final String DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID = "DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID";
    public static final String DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID = "DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID";
    public static final String DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID = "DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID";
    public static final String DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID = "DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID";
    public static final String DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID = "DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID";
    public static final String DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID = "DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID";
    public static final String DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID = "DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID";
    public static final String DER1N_WFUSERCANDIDATE_WFUSER_WFMAJORUSERID = "DER1N_WFUSERCANDIDATE_WFUSER_WFMAJORUSERID";
    public static final String DER1N_WFUSERCANDIDATE_WFUSER_WFMINORUSERID = "DER1N_WFUSERCANDIDATE_WFUSER_WFMINORUSERID";
    public static final String DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID = "DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID";
    public static final String DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID = "DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID";
    public static final String DER1N_WFWFVERSION_WFWORKFLOW_WFWFID = "DER1N_WFWFVERSION_WFWORKFLOW_WFWFID";
    public static final String DER1N_WFWORKFLOW_MSGTEMPLATE_REMINDMSGTEMPLID = "DER1N_WFWORKFLOW_MSGTEMPLATE_REMINDMSGTEMPLID";
    public static final String DER1N_WFWORKLIST2_WFINSTANCE_WFINSTANCEID = "DER1N_WFWORKLIST2_WFINSTANCE_WFINSTANCEID";
    public static final String DER1N_WFWORKLIST2_WFUSER_ORIGINALWFUSERID = "DER1N_WFWORKLIST2_WFUSER_ORIGINALWFUSERID";
    public static final String DER1N_WFWORKLIST_WFINSTANCE_WFINSTANCEID = "DER1N_WFWORKLIST_WFINSTANCE_WFINSTANCEID";
    public static final String DER1N_WFWORKLIST_WFUSER_ORIGINALWFUSERID = "DER1N_WFWORKLIST_WFUSER_ORIGINALWFUSERID";
    public static final String DER1N_WXACCESSTOKEN_WXACCOUNT_WXACCOUNTID = "DER1N_WXACCESSTOKEN_WXACCOUNT_WXACCOUNTID";
    public static final String DER1N_WXACCOUNT_ORG_ORGID = "DER1N_WXACCOUNT_ORG_ORGID";
    public static final String DER1N_WXENTAPP_WXACCOUNT_WXACCOUNTID = "DER1N_WXENTAPP_WXACCOUNT_WXACCOUNTID";
    public static final String DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID = "DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID";
    public static final String DER1N_WXMEDIA_WXENTAPP_WXENTAPPID = "DER1N_WXMEDIA_WXENTAPP_WXENTAPPID";
    public static final String DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID = "DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID";
    public static final String DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID = "DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID";
    public static final String DER1N_WXORGSECTOR_ORGSECTOR_ORGSECTORID = "DER1N_WXORGSECTOR_ORGSECTOR_ORGSECTORID";
    public static final String DER1N_WXORGSECTOR_WXACCOUNT_WXACCOUNTID = "DER1N_WXORGSECTOR_WXACCOUNT_WXACCOUNTID";
    public static final String DERINDEX_WFDYNAMICUSER_WFACTOR = "DERINDEX_WFDYNAMICUSER_WFACTOR";
    public static final String DERINDEX_WFSYSTEMUSER_WFACTOR = "DERINDEX_WFSYSTEMUSER_WFACTOR";
    public static final String DERINDEX_WFUSERGROUP_WFACTOR = "DERINDEX_WFUSERGROUP_WFACTOR";
    public static final String DERINDEX_WFUSER_WFACTOR = "DERINDEX_WFUSER_WFACTOR";
    public static final String DERINHERIT_USERGROUP_USEROBJECT = "DERINHERIT_USERGROUP_USEROBJECT";
    public static final String DERINHERIT_USER_USEROBJECT = "DERINHERIT_USER_USEROBJECT";
    public static final String SYSTEM = "SYSTEM";
    public static final String WFUSERCANDIDATE = "WFUSERCANDIDATE";
    public static final String UNIRES = "UNIRES";
    public static final String DSDYNAVIEWINST = "DSDYNAVIEWINST";
    public static final String DSDYNACODELIST = "DSDYNACODELIST";
    public static final String DEDATACHG2 = "DEDATACHG2";
    public static final String WFSTEPDATA = "WFSTEPDATA";
    public static final String SYSADMIN = "SYSADMIN";
    public static final String WXENTAPP = "WXENTAPP";
    public static final String USERROLEDATADETAIL = "USERROLEDATADETAIL";
    public static final String DEDATACHGDISP = "DEDATACHGDISP";
    public static final String TSSDTASKTYPE = "TSSDTASKTYPE";
    public static final String PVPART = "PVPART";
    public static final String DATAAUDIT = "DATAAUDIT";
    public static final String WFWORKLIST = "WFWORKLIST";
    public static final String USERROLERES = "USERROLERES";
    public static final String REGISTRY = "REGISTRY";
    public static final String USERROLE = "USERROLE";
    public static final String TSSDTASKPOLICY = "TSSDTASKPOLICY";
    public static final String TSSDPOLICYOWNER = "TSSDPOLICYOWNER";
    public static final String USERROLEDEFIELD = "USERROLEDEFIELD";
    public static final String TSSDGROUP = "TSSDGROUP";
    public static final String DSDYNAVIEW = "DSDYNAVIEW";
    public static final String WFUSERGROUPDETAIL = "WFUSERGROUPDETAIL";
    public static final String WFCUSTOMPROCESS = "WFCUSTOMPROCESS";
    public static final String USERDICTCAT = "USERDICTCAT";
    public static final String TSSDITEM = "TSSDITEM";
    public static final String LOGINLOG = "LOGINLOG";
    public static final String SYSADMINFUNC = "SYSADMINFUNC";
    public static final String TSSDTASK = "TSSDTASK";
    public static final String WFUSERASSIST = "WFUSERASSIST";
    public static final String WFIAACTION = "WFIAACTION";
    public static final String WXACCESSTOKEN = "WXACCESSTOKEN";
    public static final String USERROLEDATAACTION = "USERROLEDATAACTION";
    public static final String ORGTYPE = "ORGTYPE";
    public static final String DALOG = "DALOG";
    public static final String USERDGTHEME = "USERDGTHEME";
    public static final String USERROLEDATAS = "USERROLEDATAS";
    public static final String ORGSECTOR = "ORGSECTOR";
    public static final String MSGSENDQUEUE = "MSGSENDQUEUE";
    public static final String WFASSISTWORK = "WFASSISTWORK";
    public static final String QUERYMODEL = "QUERYMODEL";
    public static final String USERROLEDETAIL = "USERROLEDETAIL";
    public static final String USERROLEDATA = "USERROLEDATA";
    public static final String WFWORKFLOW = "WFWORKFLOW";
    public static final String USERROLEDEFIELDS = "USERROLEDEFIELDS";
    public static final String MSGSENDQUEUEHIS = "MSGSENDQUEUEHIS";
    public static final String DATASYNCIN2 = "DATASYNCIN2";
    public static final String DATAAUDITDETAIL = "DATAAUDITDETAIL";
    public static final String TSSDPOLICY = "TSSDPOLICY";
    public static final String WFACTOR = "WFACTOR";
    public static final String CODELIST = "CODELIST";
    public static final String MSGTEMPLATE = "MSGTEMPLATE";
    public static final String USERROLETYPE = "USERROLETYPE";
    public static final String USERDICTITEM = "USERDICTITEM";
    public static final String WXACCOUNT = "WXACCOUNT";
    public static final String DATASYNCIN = "DATASYNCIN";
    public static final String CODEITEM = "CODEITEM";
    public static final String TSSDENGINE = "TSSDENGINE";
    public static final String WFUCPOLICY = "WFUCPOLICY";
    public static final String WFSTEPACTOR = "WFSTEPACTOR";
    public static final String WFACTION = "WFACTION";
    public static final String WFUIWIZARD = "WFUIWIZARD";
    public static final String WFSTEP = "WFSTEP";
    public static final String USERGROUPDETAIL = "USERGROUPDETAIL";
    public static final String DSDYNAWF = "DSDYNAWF";
    public static final String WFAPPSETTING = "WFAPPSETTING";
    public static final String WXORGSECTOR = "WXORGSECTOR";
    public static final String DATASYNCOUT2 = "DATASYNCOUT2";
    public static final String WXMEDIA = "WXMEDIA";
    public static final String WFSYSTEMUSER = "WFSYSTEMUSER";
    public static final String SERVICE = "SERVICE";
    public static final String MSGACCOUNTDETAIL = "MSGACCOUNTDETAIL";
    public static final String WFWFVERSION = "WFWFVERSION";
    public static final String USERDICT = "USERDICT";
    public static final String DEDATACHG = "DEDATACHG";
    public static final String PORTALPAGE = "PORTALPAGE";
    public static final String LOGINACCOUNT = "LOGINACCOUNT";
    public static final String USER = "USER";
    public static final String ORGUNITCAT = "ORGUNITCAT";
    public static final String DSDYNAWFVER = "DSDYNAWFVER";
    public static final String ORGSECUSER = "ORGSECUSER";
    public static final String TSSDGROUPDETAIL = "TSSDGROUPDETAIL";
    public static final String ORGUSERLEVEL = "ORGUSERLEVEL";
    public static final String FILE = "FILE";
    public static final String WFDYNAMICUSER = "WFDYNAMICUSER";
    public static final String PPMODEL = "PPMODEL";
    public static final String TSSDTASKLOG = "TSSDTASKLOG";
    public static final String WFUSER = "WFUSER";
    public static final String DATASYNCOUT = "DATASYNCOUT";
    public static final String USERGROUP = "USERGROUP";
    public static final String USEROBJECT = "USEROBJECT";
    public static final String WFTMPSTEPACTOR = "WFTMPSTEPACTOR";
    public static final String WFWORKLIST2 = "WFWORKLIST2";
    public static final String DATAENTITY = "DATAENTITY";
    public static final String MSGACCOUNT = "MSGACCOUNT";
    public static final String DATASYNCAGENT = "DATASYNCAGENT";
    public static final String WFINSTANCE = "WFINSTANCE";
    public static final String WXMESSAGE = "WXMESSAGE";
    public static final String WFUSERGROUP = "WFUSERGROUP";
    public static final String ORGUSER = "ORGUSER";
    public static final String ORGSECUSERTYPE = "ORGSECUSERTYPE";
    public static final String WFREMINDER = "WFREMINDER";
    public static final String WFSTEPINST = "WFSTEPINST";
    public static final String ORG = "ORG";
    @Autowired(required=false)
    @Qualifier(value="dbDialectPSRuntime")
    private IDBDialect dbDialectPSRuntime;
    @Autowired(required=false)
    @Qualifier(value="sessionFactoryPSRuntime")
    private SessionFactory sessionFactoryPSRuntime;
    @Autowired(required=false)
    @Qualifier(value="pSRuntimePlugins")
    private PluginList pSRuntimePlugins;
    @Autowired(required=false)
    @Qualifier(value="pSRuntimeServiceAPIClientId")
    private String pSRuntimeServiceAPIClientId;

    public PSRuntimeSysModelBase() throws Exception {
        this.setId("2C40DFCD-0DF5-47BF-91A5-C45F810B0001");
        this.setName("PSRuntime");
        SysModelGlobal.registerSystem("net.ibizsys.psrt.srv.PSRuntimeSysModel", this);
        this.initAnnotation(PSRuntimeSysModelBase.class);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        super.postConstruct();
        this.prepareCodeLists();
        this.prepareSysCounters();
        this.prepareSysValueRules();
        this.prepareDataEntities();
        this.prepareSystemUserRoles();
        this.prepareDTSQueues();
        this.prepareUniStates();
        this.prepareServiceAPIClients();
        this.prepareDEFInputTipSets();
        this.prepareViewMsgs();
        this.prepareViewMsgGroups();
        this.prepareWXAccounts();
        this.prepareWorkflows();
        this.prepareBASchemes();
        this.prepareSysUtils();
        this.installPlugins(this.getPSRuntimePlugins());
    }

    public void install() throws Exception {
        super.postConstruct();
        this.prepareCodeLists();
        this.prepareSysCounters();
        this.prepareSysValueRules();
        this.prepareDataEntities();
        this.prepareDAOs();
        this.prepareServices();
        this.prepareSystemUserRoles();
        this.prepareDTSQueues();
        this.prepareUniStates();
        this.prepareServiceAPIClients();
        this.prepareDEFInputTipSets();
        this.prepareViewMsgs();
        this.prepareViewMsgGroups();
        this.prepareWXAccounts();
        this.prepareWorkflows();
        this.prepareBASchemes();
        this.prepareSysUtils();
        this.installPlugins(this.getPSRuntimePlugins());
    }

    public void setDBDialectPSRuntime(IDBDialect dbDialectPSRuntime) {
        this.dbDialectPSRuntime = dbDialectPSRuntime;
    }

    public IDBDialect getDBDialectPSRuntime() {
        return this.dbDialectPSRuntime;
    }

    public void setSessionFactoryPSRuntime(SessionFactory sessionFactoryPSRuntime) {
        this.sessionFactoryPSRuntime = sessionFactoryPSRuntime;
    }

    public SessionFactory getSessionFactoryPSRuntime() {
        return this.sessionFactoryPSRuntime;
    }

    @Override
    public SessionFactory getSessionFactory() {
        if (this.getSessionFactoryPSRuntime() == null) {
            return super.getSessionFactory();
        }
        return this.getSessionFactoryPSRuntime();
    }

    @Override
    public IDBDialect getDBDialect() {
        if (this.getDBDialectPSRuntime() == null) {
            return super.getDBDialect();
        }
        return this.getDBDialectPSRuntime();
    }

    protected void prepareCodeLists() {
        new UserRoleTypeCodeListModel();
        new WFConfigStateCodeListModel();
        new UniResTypeCodeListModel();
        new TSSecondCodeListModel();
        new CodeList105CodeListModel();
        new SystemFuncCodeListModel();
        new ServiceStartModeCodeListModel();
        new CodeList24CodeListModel();
        new DEFieldAccModeCodeListModel();
        new TSHourCodeListModel();
        new SysOperatorCodeListModel();
        new WXMsgTypeCodeListModel();
        new WXEntAppTypeCodeListModel();
        new DataSyncAgentTypeCodeListModel();
        new TSMonthWeekTypeCodeListModel();
        new MsgContentTypeCodeListModel();
        new TSDayCodeListModel();
        new ServiceRunStateCodeListModel();
        new MsgTypeCodeListModel();
        new URDUserDRCodeListModel();
        new TSDayTypeCodeListModel();
        new CodeList5CodeListModel();
        new URDSecDRCodeListModel();
        new PVLayoutModeCodeListModel();
        new CodeList25CodeListModel();
        new CodeList58CodeListModel();
        new CodeList20CodeListModel();
        new WFGotoStepCodeListModel();
        new TSMonthCodeListModel();
        new CodeList19CodeListModel();
        new DETableSpaceCodeListModel();
        new TSMinuteCodeListModel();
        new ServiceContainerCodeListModel();
        new TSWeekCodeListModel();
        new TSMonthDayTypeCodeListModel();
        new DataSyncOutAgentCodeListModel();
        new CodeList80CodeListModel();
        new TSMinuteTypeCodeListModel();
        new CodeList71CodeListModel();
        new WFGotoStepActorCodeListModel();
        new PVPartTypeCodeListModel();
        new DEDataChgLogTypeCodeListModel();
        new DEIndexModeCodeListModel();
        new URDBCDRCodeListModel();
        new MsgImportanceLevelCodeListModel();
        new URDOrgDRCodeListModel();
        new CodeList50CodeListModel();
        new DataChangeEventCodeListModel();
        new YesNoCodeListModel();
        new CodeList59CodeListModel();
        new WFActorTypeCodeListModel();
        new TSMonthTypeCodeListModel();
        new DynaViewTypeCodeListModel();
        new AuditDEActionCodeListModel();
        new DEPrintFuncCodeListModel();
        new TSSecondTypeCodeListModel();
        new WFConfigTypeCodeListModel();
        new AllOrgCodeListModel();
        new DataSyncInAgentCodeListModel();
        new TSPolicyTypeCodeListModel();
        new SystemTypeCodeListModel();
        new CodeList56CodeListModel();
        new CodeList97CodeListModel();
        new WFUCPolicyStateCodeListModel();
    }

    protected void prepareDEFInputTipSets() {
    }

    protected void prepareViewMsgs() {
    }

    protected void prepareViewMsgGroups() {
    }

    protected void prepareUniStates() {
    }

    protected void prepareSystemUserRoles() {
    }

    protected void prepareDTSQueues() {
    }

    protected void prepareServiceAPIClients() {
    }

    protected void prepareSysCounters() {
    }

    protected void prepareSysValueRules() {
        try {
            RegExValueRuleModel valueRuleModel0 = new RegExValueRuleModel();
            valueRuleModel0.setExpression("(-?\\d+)(\\.\\d+)?");
            valueRuleModel0.setId("01bc1646c58b34db649ab16c4b8d5e60");
            valueRuleModel0.setName("\u6d6e\u70b9\u6570");
            valueRuleModel0.init(this);
            this.registerSystemValueRuleModel(valueRuleModel0);
            RegExValueRuleModel valueRuleModel1 = new RegExValueRuleModel();
            valueRuleModel1.setExpression("[0-9]*[1-9][0-9]*");
            valueRuleModel1.setId("0d13b22cb1bf499a6ceea57a92bedef8");
            valueRuleModel1.setName("\u6b63\u6574\u6570");
            valueRuleModel1.init(this);
            this.registerSystemValueRuleModel(valueRuleModel1);
            RegExValueRuleModel valueRuleModel2 = new RegExValueRuleModel();
            valueRuleModel2.setExpression("[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+");
            valueRuleModel2.setId("0ea99d804f06a71115c5a62bc28b3527");
            valueRuleModel2.setName("email\u5730\u5740");
            valueRuleModel2.init(this);
            this.registerSystemValueRuleModel(valueRuleModel2);
            RegExValueRuleModel valueRuleModel3 = new RegExValueRuleModel();
            valueRuleModel3.setExpression("\\d+");
            valueRuleModel3.setId("3268e77dd7a4a4b05530bebec4f46c50");
            valueRuleModel3.setName("\u975e\u8d1f\u6574\u6570\uff08\u6b63\u6574\u6570 + 0\uff09");
            valueRuleModel3.init(this);
            this.registerSystemValueRuleModel(valueRuleModel3);
            RegExValueRuleModel valueRuleModel4 = new RegExValueRuleModel();
            valueRuleModel4.setExpression("[A-Za-z0-9]+");
            valueRuleModel4.setId("6e404aa8db594e2f28a5852a7cdad0e8");
            valueRuleModel4.setName("\u7531\u6570\u5b57\u548c26\u4e2a\u82f1\u6587\u5b57\u6bcd\u7ec4\u6210\u7684\u5b57\u7b26\u4e32");
            valueRuleModel4.init(this);
            this.registerSystemValueRuleModel(valueRuleModel4);
            RegExValueRuleModel valueRuleModel5 = new RegExValueRuleModel();
            valueRuleModel5.setExpression("[A-Z]+");
            valueRuleModel5.setId("8016fd5dea62b7ca19148a61e566b9d3");
            valueRuleModel5.setName("\u753126\u4e2a\u82f1\u6587\u5b57\u6bcd\u7684\u5927\u5199\u7ec4\u6210\u7684\u5b57\u7b26\u4e32");
            valueRuleModel5.init(this);
            this.registerSystemValueRuleModel(valueRuleModel5);
            RegExValueRuleModel valueRuleModel6 = new RegExValueRuleModel();
            valueRuleModel6.setExpression("\\w+");
            valueRuleModel6.setId("84edfd10899f07328ee6438ffacf8143");
            valueRuleModel6.setName("\u7531\u6570\u5b57\u300126\u4e2a\u82f1\u6587\u5b57\u6bcd\u6216\u8005\u4e0b\u5212\u7ebf\u7ec4\u6210\u7684\u5b57\u7b26\u4e32");
            valueRuleModel6.init(this);
            this.registerSystemValueRuleModel(valueRuleModel6);
            RegExValueRuleModel valueRuleModel7 = new RegExValueRuleModel();
            valueRuleModel7.setExpression("((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))+");
            valueRuleModel7.setId("8a59008054e727cb36eb10e6b864d900");
            valueRuleModel7.setName("\u975e\u6b63\u6d6e\u70b9\u6570\uff08\u8d1f\u6d6e\u70b9\u6570 + 0\uff09");
            valueRuleModel7.init(this);
            this.registerSystemValueRuleModel(valueRuleModel7);
            RegExValueRuleModel valueRuleModel8 = new RegExValueRuleModel();
            valueRuleModel8.setExpression("[a-zA-Z_$][a-zA-Z0-9_$]*");
            valueRuleModel8.setId("97841f956bba437825ae258442aeb496");
            valueRuleModel8.setName("\u4ee3\u7801\u540d\u79f0");
            valueRuleModel8.init(this);
            this.registerSystemValueRuleModel(valueRuleModel8);
            RegExValueRuleModel valueRuleModel9 = new RegExValueRuleModel();
            valueRuleModel9.setExpression("((-\\d+)|(0+))+");
            valueRuleModel9.setId("97e9883ae7e261976a128b79c60d6871");
            valueRuleModel9.setName("\u975e\u6b63\u6574\u6570\uff08\u8d1f\u6574\u6570 + 0\uff09");
            valueRuleModel9.init(this);
            this.registerSystemValueRuleModel(valueRuleModel9);
            RegExValueRuleModel valueRuleModel10 = new RegExValueRuleModel();
            valueRuleModel10.setExpression("(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))+");
            valueRuleModel10.setId("9c5f80f095330c696cec98766e567bce");
            valueRuleModel10.setName("\u6b63\u6d6e\u70b9\u6570");
            valueRuleModel10.init(this);
            this.registerSystemValueRuleModel(valueRuleModel10);
            RegExValueRuleModel valueRuleModel11 = new RegExValueRuleModel();
            valueRuleModel11.setExpression("-?\\d+");
            valueRuleModel11.setId("a8804f3a519c547bfb7a2d76bc4b0c1d");
            valueRuleModel11.setName("\u6574\u6570");
            valueRuleModel11.init(this);
            this.registerSystemValueRuleModel(valueRuleModel11);
            RegExValueRuleModel valueRuleModel12 = new RegExValueRuleModel();
            valueRuleModel12.setExpression("[A-Za-z]+");
            valueRuleModel12.setId("b436b7b8f20944fe85a0450feb9b6144");
            valueRuleModel12.setName("\u753126\u4e2a\u82f1\u6587\u5b57\u6bcd\u7ec4\u6210\u7684\u5b57\u7b26\u4e32");
            valueRuleModel12.init(this);
            this.registerSystemValueRuleModel(valueRuleModel12);
            RegExValueRuleModel valueRuleModel13 = new RegExValueRuleModel();
            valueRuleModel13.setExpression("[a-z]+");
            valueRuleModel13.setId("b7228b9943dc4d881c722406dda53537");
            valueRuleModel13.setName("\u753126\u4e2a\u82f1\u6587\u5b57\u6bcd\u7684\u5c0f\u5199\u7ec4\u6210\u7684\u5b57\u7b26\u4e32");
            valueRuleModel13.init(this);
            this.registerSystemValueRuleModel(valueRuleModel13);
            RegExValueRuleModel valueRuleModel14 = new RegExValueRuleModel();
            valueRuleModel14.setExpression("-[0-9]*[1-9][0-9]*");
            valueRuleModel14.setId("c146a1ccac246c50ef999f17e8bf4c38");
            valueRuleModel14.setName("\u8d1f\u6574\u6570");
            valueRuleModel14.init(this);
            this.registerSystemValueRuleModel(valueRuleModel14);
            RegExValueRuleModel valueRuleModel15 = new RegExValueRuleModel();
            valueRuleModel15.setExpression("(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))+");
            valueRuleModel15.setId("c6aaa542c20b9ecf01c6f1087922b9c4");
            valueRuleModel15.setName("\u8d1f\u6d6e\u70b9\u6570");
            valueRuleModel15.init(this);
            this.registerSystemValueRuleModel(valueRuleModel15);
            RegExValueRuleModel valueRuleModel16 = new RegExValueRuleModel();
            valueRuleModel16.setExpression("[^\\\\\\/\\:\\*\\?\\\"\\<\\>\\|]+(\\[^\\\\\\/\\:\\*\\?\\\"\\<\\>\\|]+)*");
            valueRuleModel16.setId("dc01ec15e5c043ac869c18a5d93dfbd8");
            valueRuleModel16.setName("\u6587\u4ef6\u540d\u79f0");
            valueRuleModel16.init(this);
            this.registerSystemValueRuleModel(valueRuleModel16);
            RegExValueRuleModel valueRuleModel17 = new RegExValueRuleModel();
            valueRuleModel17.setExpression("\\d+(\\.\\d+)?");
            valueRuleModel17.setId("f8290b8fc83f51573a4c02112463363c");
            valueRuleModel17.setName("\u975e\u8d1f\u6d6e\u70b9\u6570\uff08\u6b63\u6d6e\u70b9\u6570 + 0\uff09");
            valueRuleModel17.init(this);
            this.registerSystemValueRuleModel(valueRuleModel17);
            RegExValueRuleModel valueRuleModel18 = new RegExValueRuleModel();
            valueRuleModel18.setExpression("[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?");
            valueRuleModel18.setId("fb7e8feea11f2c49e548e3a43f9a64d8");
            valueRuleModel18.setName("URL");
            valueRuleModel18.init(this);
            this.registerSystemValueRuleModel(valueRuleModel18);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u521d\u59cb\u5316\u7cfb\u7edf\u503c\u89c4\u5219\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
        }
    }

    protected void prepareDataEntities() throws Exception {
        new SystemDEModel();
        new WFUserCandidateDEModel();
        new UniResDEModel();
        new DSDynaViewInstDEModel();
        new DSDynaCodeListDEModel();
        new DEDataChg2DEModel();
        new WFStepDataDEModel();
        new SysAdminDEModel();
        new WXEntAppDEModel();
        new UserRoleDataDetailDEModel();
        new DEDataChgDispDEModel();
        new TSSDTaskTypeDEModel();
        new PVPartDEModel();
        new DataAuditDEModel();
        new WFWorkListDEModel();
        new UserRoleResDEModel();
        new RegistryDEModel();
        new UserRoleDEModel();
        new TSSDTaskPolicyDEModel();
        new TSSDPolicyOwnerDEModel();
        new UserRoleDEFieldDEModel();
        new TSSDGroupDEModel();
        new DSDynaViewDEModel();
        new WFUserGroupDetailDEModel();
        new WFCustomProcessDEModel();
        new UserDictCatDEModel();
        new TSSDItemDEModel();
        new LoginLogDEModel();
        new SysAdminFuncDEModel();
        new TSSDTaskDEModel();
        new WFUserAssistDEModel();
        new WFIAActionDEModel();
        new WXAccessTokenDEModel();
        new UserRoleDataActionDEModel();
        new OrgTypeDEModel();
        new DALogDEModel();
        new UserDGThemeDEModel();
        new UserRoleDatasDEModel();
        new OrgSectorDEModel();
        new MsgSendQueueDEModel();
        new WFAssistWorkDEModel();
        new QueryModelDEModel();
        new UserRoleDetailDEModel();
        new UserRoleDataDEModel();
        new WFWorkflowDEModel();
        new UserRoleDEFieldsDEModel();
        new MsgSendQueueHisDEModel();
        new DataSyncIn2DEModel();
        new DataAuditDetailDEModel();
        new TSSDPolicyDEModel();
        new WFActorDEModel();
        new CodeListDEModel();
        new MsgTemplateDEModel();
        new UserRoleTypeDEModel();
        new UserDictItemDEModel();
        new WXAccountDEModel();
        new DataSyncInDEModel();
        new CodeItemDEModel();
        new TSSDEngineDEModel();
        new WFUCPolicyDEModel();
        new WFStepActorDEModel();
        new WFActionDEModel();
        new WFUIWizardDEModel();
        new WFStepDEModel();
        new UserGroupDetailDEModel();
        new DSDynaWFDEModel();
        new WFAppSettingDEModel();
        new WXOrgSectorDEModel();
        new DataSyncOut2DEModel();
        new WXMediaDEModel();
        new WFSystemUserDEModel();
        new ServiceDEModel();
        new MsgAccountDetailDEModel();
        new WFVersionDEModel();
        new UserDictDEModel();
        new DEDataChgDEModel();
        new PortalPageDEModel();
        new LoginAccountDEModel();
        new UserDEModel();
        new OrgUnitCatDEModel();
        new DSDynaWFVerDEModel();
        new OrgSecUserDEModel();
        new TSSDGroupDetailDEModel();
        new OrgUserLevelDEModel();
        new FileDEModel();
        new WFDynamicUserDEModel();
        new PPModelDEModel();
        new TSSDTaskLogDEModel();
        new WFUserDEModel();
        new DataSyncOutDEModel();
        new UserGroupDEModel();
        new UserObjectDEModel();
        new WFTmpStepActorDEModel();
        new WFWorkList2DEModel();
        new DataEntityDEModel();
        new MsgAccountDEModel();
        new DataSyncAgentDEModel();
        new WFInstanceDEModel();
        new WXMessageDEModel();
        new WFUserGroupDEModel();
        new OrgUserDEModel();
        new OrgSecUserTypeDEModel();
        new WFReminderDEModel();
        new WFStepInstDEModel();
        new OrgDEModel();
    }

    protected void prepareServices() throws Exception {
        SystemService service0 = new SystemService();
        service0.postConstruct();
        WFUserCandidateService service1 = new WFUserCandidateService();
        service1.postConstruct();
        UniResService service2 = new UniResService();
        service2.postConstruct();
        DSDynaViewInstService service3 = new DSDynaViewInstService();
        service3.postConstruct();
        DSDynaCodeListService service4 = new DSDynaCodeListService();
        service4.postConstruct();
        DEDataChg2Service service5 = new DEDataChg2Service();
        service5.postConstruct();
        WFStepDataService service6 = new WFStepDataService();
        service6.postConstruct();
        SysAdminService service7 = new SysAdminService();
        service7.postConstruct();
        WXEntAppService service8 = new WXEntAppService();
        service8.postConstruct();
        UserRoleDataDetailService service9 = new UserRoleDataDetailService();
        service9.postConstruct();
        DEDataChgDispService service10 = new DEDataChgDispService();
        service10.postConstruct();
        TSSDTaskTypeService service11 = new TSSDTaskTypeService();
        service11.postConstruct();
        PVPartService service12 = new PVPartService();
        service12.postConstruct();
        DataAuditService service13 = new DataAuditService();
        service13.postConstruct();
        WFWorkListService service14 = new WFWorkListService();
        service14.postConstruct();
        UserRoleResService service15 = new UserRoleResService();
        service15.postConstruct();
        RegistryService service16 = new RegistryService();
        service16.postConstruct();
        UserRoleService service17 = new UserRoleService();
        service17.postConstruct();
        TSSDTaskPolicyService service18 = new TSSDTaskPolicyService();
        service18.postConstruct();
        TSSDPolicyOwnerService service19 = new TSSDPolicyOwnerService();
        service19.postConstruct();
        UserRoleDEFieldService service20 = new UserRoleDEFieldService();
        service20.postConstruct();
        TSSDGroupService service21 = new TSSDGroupService();
        service21.postConstruct();
        DSDynaViewService service22 = new DSDynaViewService();
        service22.postConstruct();
        WFUserGroupDetailService service23 = new WFUserGroupDetailService();
        service23.postConstruct();
        WFCustomProcessService service24 = new WFCustomProcessService();
        service24.postConstruct();
        UserDictCatService service25 = new UserDictCatService();
        service25.postConstruct();
        TSSDItemService service26 = new TSSDItemService();
        service26.postConstruct();
        LoginLogService service27 = new LoginLogService();
        service27.postConstruct();
        SysAdminFuncService service28 = new SysAdminFuncService();
        service28.postConstruct();
        TSSDTaskService service29 = new TSSDTaskService();
        service29.postConstruct();
        WFUserAssistService service30 = new WFUserAssistService();
        service30.postConstruct();
        WFIAActionService service31 = new WFIAActionService();
        service31.postConstruct();
        WXAccessTokenService service32 = new WXAccessTokenService();
        service32.postConstruct();
        UserRoleDataActionService service33 = new UserRoleDataActionService();
        service33.postConstruct();
        OrgTypeService service34 = new OrgTypeService();
        service34.postConstruct();
        DALogService service35 = new DALogService();
        service35.postConstruct();
        UserDGThemeService service36 = new UserDGThemeService();
        service36.postConstruct();
        UserRoleDatasService service37 = new UserRoleDatasService();
        service37.postConstruct();
        OrgSectorService service38 = new OrgSectorService();
        service38.postConstruct();
        MsgSendQueueService service39 = new MsgSendQueueService();
        service39.postConstruct();
        WFAssistWorkService service40 = new WFAssistWorkService();
        service40.postConstruct();
        QueryModelService service41 = new QueryModelService();
        service41.postConstruct();
        UserRoleDetailService service42 = new UserRoleDetailService();
        service42.postConstruct();
        UserRoleDataService service43 = new UserRoleDataService();
        service43.postConstruct();
        WFWorkflowService service44 = new WFWorkflowService();
        service44.postConstruct();
        UserRoleDEFieldsService service45 = new UserRoleDEFieldsService();
        service45.postConstruct();
        MsgSendQueueHisService service46 = new MsgSendQueueHisService();
        service46.postConstruct();
        DataSyncIn2Service service47 = new DataSyncIn2Service();
        service47.postConstruct();
        DataAuditDetailService service48 = new DataAuditDetailService();
        service48.postConstruct();
        TSSDPolicyService service49 = new TSSDPolicyService();
        service49.postConstruct();
        WFActorService service50 = new WFActorService();
        service50.postConstruct();
        CodeListService service51 = new CodeListService();
        service51.postConstruct();
        MsgTemplateService service52 = new MsgTemplateService();
        service52.postConstruct();
        UserRoleTypeService service53 = new UserRoleTypeService();
        service53.postConstruct();
        UserDictItemService service54 = new UserDictItemService();
        service54.postConstruct();
        WXAccountService service55 = new WXAccountService();
        service55.postConstruct();
        DataSyncInService service56 = new DataSyncInService();
        service56.postConstruct();
        CodeItemService service57 = new CodeItemService();
        service57.postConstruct();
        TSSDEngineService service58 = new TSSDEngineService();
        service58.postConstruct();
        WFUCPolicyService service59 = new WFUCPolicyService();
        service59.postConstruct();
        WFStepActorService service60 = new WFStepActorService();
        service60.postConstruct();
        WFActionService service61 = new WFActionService();
        service61.postConstruct();
        WFUIWizardService service62 = new WFUIWizardService();
        service62.postConstruct();
        WFStepService service63 = new WFStepService();
        service63.postConstruct();
        UserGroupDetailService service64 = new UserGroupDetailService();
        service64.postConstruct();
        DSDynaWFService service65 = new DSDynaWFService();
        service65.postConstruct();
        WFAppSettingService service66 = new WFAppSettingService();
        service66.postConstruct();
        WXOrgSectorService service67 = new WXOrgSectorService();
        service67.postConstruct();
        DataSyncOut2Service service68 = new DataSyncOut2Service();
        service68.postConstruct();
        WXMediaService service69 = new WXMediaService();
        service69.postConstruct();
        WFSystemUserService service70 = new WFSystemUserService();
        service70.postConstruct();
        ServiceService service71 = new ServiceService();
        service71.postConstruct();
        MsgAccountDetailService service72 = new MsgAccountDetailService();
        service72.postConstruct();
        WFVersionService service73 = new WFVersionService();
        service73.postConstruct();
        UserDictService service74 = new UserDictService();
        service74.postConstruct();
        DEDataChgService service75 = new DEDataChgService();
        service75.postConstruct();
        PortalPageService service76 = new PortalPageService();
        service76.postConstruct();
        LoginAccountService service77 = new LoginAccountService();
        service77.postConstruct();
        UserService service78 = new UserService();
        service78.postConstruct();
        OrgUnitCatService service79 = new OrgUnitCatService();
        service79.postConstruct();
        DSDynaWFVerService service80 = new DSDynaWFVerService();
        service80.postConstruct();
        OrgSecUserService service81 = new OrgSecUserService();
        service81.postConstruct();
        TSSDGroupDetailService service82 = new TSSDGroupDetailService();
        service82.postConstruct();
        OrgUserLevelService service83 = new OrgUserLevelService();
        service83.postConstruct();
        FileService service84 = new FileService();
        service84.postConstruct();
        WFDynamicUserService service85 = new WFDynamicUserService();
        service85.postConstruct();
        PPModelService service86 = new PPModelService();
        service86.postConstruct();
        TSSDTaskLogService service87 = new TSSDTaskLogService();
        service87.postConstruct();
        WFUserService service88 = new WFUserService();
        service88.postConstruct();
        DataSyncOutService service89 = new DataSyncOutService();
        service89.postConstruct();
        UserGroupService service90 = new UserGroupService();
        service90.postConstruct();
        UserObjectServiceProxy service91 = new UserObjectServiceProxy();
        service91.postConstruct();
        WFTmpStepActorService service92 = new WFTmpStepActorService();
        service92.postConstruct();
        WFWorkList2Service service93 = new WFWorkList2Service();
        service93.postConstruct();
        DataEntityService service94 = new DataEntityService();
        service94.postConstruct();
        MsgAccountService service95 = new MsgAccountService();
        service95.postConstruct();
        DataSyncAgentService service96 = new DataSyncAgentService();
        service96.postConstruct();
        WFInstanceService service97 = new WFInstanceService();
        service97.postConstruct();
        WXMessageService service98 = new WXMessageService();
        service98.postConstruct();
        WFUserGroupService service99 = new WFUserGroupService();
        service99.postConstruct();
        OrgUserService service100 = new OrgUserService();
        service100.postConstruct();
        OrgSecUserTypeService service101 = new OrgSecUserTypeService();
        service101.postConstruct();
        WFReminderService service102 = new WFReminderService();
        service102.postConstruct();
        WFStepInstService service103 = new WFStepInstService();
        service103.postConstruct();
        OrgService service104 = new OrgService();
        service104.postConstruct();
    }

    protected void prepareDAOs() throws Exception {
        SystemDAO dao0 = new SystemDAO();
        dao0.postConstruct();
        WFUserCandidateDAO dao1 = new WFUserCandidateDAO();
        dao1.postConstruct();
        UniResDAO dao2 = new UniResDAO();
        dao2.postConstruct();
        DSDynaViewInstDAO dao3 = new DSDynaViewInstDAO();
        dao3.postConstruct();
        DSDynaCodeListDAO dao4 = new DSDynaCodeListDAO();
        dao4.postConstruct();
        DEDataChg2DAO dao5 = new DEDataChg2DAO();
        dao5.postConstruct();
        WFStepDataDAO dao6 = new WFStepDataDAO();
        dao6.postConstruct();
        SysAdminDAO dao7 = new SysAdminDAO();
        dao7.postConstruct();
        WXEntAppDAO dao8 = new WXEntAppDAO();
        dao8.postConstruct();
        UserRoleDataDetailDAO dao9 = new UserRoleDataDetailDAO();
        dao9.postConstruct();
        DEDataChgDispDAO dao10 = new DEDataChgDispDAO();
        dao10.postConstruct();
        TSSDTaskTypeDAO dao11 = new TSSDTaskTypeDAO();
        dao11.postConstruct();
        PVPartDAO dao12 = new PVPartDAO();
        dao12.postConstruct();
        DataAuditDAO dao13 = new DataAuditDAO();
        dao13.postConstruct();
        WFWorkListDAO dao14 = new WFWorkListDAO();
        dao14.postConstruct();
        UserRoleResDAO dao15 = new UserRoleResDAO();
        dao15.postConstruct();
        RegistryDAO dao16 = new RegistryDAO();
        dao16.postConstruct();
        UserRoleDAO dao17 = new UserRoleDAO();
        dao17.postConstruct();
        TSSDTaskPolicyDAO dao18 = new TSSDTaskPolicyDAO();
        dao18.postConstruct();
        TSSDPolicyOwnerDAO dao19 = new TSSDPolicyOwnerDAO();
        dao19.postConstruct();
        UserRoleDEFieldDAO dao20 = new UserRoleDEFieldDAO();
        dao20.postConstruct();
        TSSDGroupDAO dao21 = new TSSDGroupDAO();
        dao21.postConstruct();
        DSDynaViewDAO dao22 = new DSDynaViewDAO();
        dao22.postConstruct();
        WFUserGroupDetailDAO dao23 = new WFUserGroupDetailDAO();
        dao23.postConstruct();
        WFCustomProcessDAO dao24 = new WFCustomProcessDAO();
        dao24.postConstruct();
        UserDictCatDAO dao25 = new UserDictCatDAO();
        dao25.postConstruct();
        TSSDItemDAO dao26 = new TSSDItemDAO();
        dao26.postConstruct();
        LoginLogDAO dao27 = new LoginLogDAO();
        dao27.postConstruct();
        SysAdminFuncDAO dao28 = new SysAdminFuncDAO();
        dao28.postConstruct();
        TSSDTaskDAO dao29 = new TSSDTaskDAO();
        dao29.postConstruct();
        WFUserAssistDAO dao30 = new WFUserAssistDAO();
        dao30.postConstruct();
        WFIAActionDAO dao31 = new WFIAActionDAO();
        dao31.postConstruct();
        WXAccessTokenDAO dao32 = new WXAccessTokenDAO();
        dao32.postConstruct();
        UserRoleDataActionDAO dao33 = new UserRoleDataActionDAO();
        dao33.postConstruct();
        OrgTypeDAO dao34 = new OrgTypeDAO();
        dao34.postConstruct();
        DALogDAO dao35 = new DALogDAO();
        dao35.postConstruct();
        UserDGThemeDAO dao36 = new UserDGThemeDAO();
        dao36.postConstruct();
        UserRoleDatasDAO dao37 = new UserRoleDatasDAO();
        dao37.postConstruct();
        OrgSectorDAO dao38 = new OrgSectorDAO();
        dao38.postConstruct();
        MsgSendQueueDAO dao39 = new MsgSendQueueDAO();
        dao39.postConstruct();
        WFAssistWorkDAO dao40 = new WFAssistWorkDAO();
        dao40.postConstruct();
        QueryModelDAO dao41 = new QueryModelDAO();
        dao41.postConstruct();
        UserRoleDetailDAO dao42 = new UserRoleDetailDAO();
        dao42.postConstruct();
        UserRoleDataDAO dao43 = new UserRoleDataDAO();
        dao43.postConstruct();
        WFWorkflowDAO dao44 = new WFWorkflowDAO();
        dao44.postConstruct();
        UserRoleDEFieldsDAO dao45 = new UserRoleDEFieldsDAO();
        dao45.postConstruct();
        MsgSendQueueHisDAO dao46 = new MsgSendQueueHisDAO();
        dao46.postConstruct();
        DataSyncIn2DAO dao47 = new DataSyncIn2DAO();
        dao47.postConstruct();
        DataAuditDetailDAO dao48 = new DataAuditDetailDAO();
        dao48.postConstruct();
        TSSDPolicyDAO dao49 = new TSSDPolicyDAO();
        dao49.postConstruct();
        WFActorDAO dao50 = new WFActorDAO();
        dao50.postConstruct();
        CodeListDAO dao51 = new CodeListDAO();
        dao51.postConstruct();
        MsgTemplateDAO dao52 = new MsgTemplateDAO();
        dao52.postConstruct();
        UserRoleTypeDAO dao53 = new UserRoleTypeDAO();
        dao53.postConstruct();
        UserDictItemDAO dao54 = new UserDictItemDAO();
        dao54.postConstruct();
        WXAccountDAO dao55 = new WXAccountDAO();
        dao55.postConstruct();
        DataSyncInDAO dao56 = new DataSyncInDAO();
        dao56.postConstruct();
        CodeItemDAO dao57 = new CodeItemDAO();
        dao57.postConstruct();
        TSSDEngineDAO dao58 = new TSSDEngineDAO();
        dao58.postConstruct();
        WFUCPolicyDAO dao59 = new WFUCPolicyDAO();
        dao59.postConstruct();
        WFStepActorDAO dao60 = new WFStepActorDAO();
        dao60.postConstruct();
        WFActionDAO dao61 = new WFActionDAO();
        dao61.postConstruct();
        WFUIWizardDAO dao62 = new WFUIWizardDAO();
        dao62.postConstruct();
        WFStepDAO dao63 = new WFStepDAO();
        dao63.postConstruct();
        UserGroupDetailDAO dao64 = new UserGroupDetailDAO();
        dao64.postConstruct();
        DSDynaWFDAO dao65 = new DSDynaWFDAO();
        dao65.postConstruct();
        WFAppSettingDAO dao66 = new WFAppSettingDAO();
        dao66.postConstruct();
        WXOrgSectorDAO dao67 = new WXOrgSectorDAO();
        dao67.postConstruct();
        DataSyncOut2DAO dao68 = new DataSyncOut2DAO();
        dao68.postConstruct();
        WXMediaDAO dao69 = new WXMediaDAO();
        dao69.postConstruct();
        WFSystemUserDAO dao70 = new WFSystemUserDAO();
        dao70.postConstruct();
        ServiceDAO dao71 = new ServiceDAO();
        dao71.postConstruct();
        MsgAccountDetailDAO dao72 = new MsgAccountDetailDAO();
        dao72.postConstruct();
        WFVersionDAO dao73 = new WFVersionDAO();
        dao73.postConstruct();
        UserDictDAO dao74 = new UserDictDAO();
        dao74.postConstruct();
        DEDataChgDAO dao75 = new DEDataChgDAO();
        dao75.postConstruct();
        PortalPageDAO dao76 = new PortalPageDAO();
        dao76.postConstruct();
        LoginAccountDAO dao77 = new LoginAccountDAO();
        dao77.postConstruct();
        UserDAO dao78 = new UserDAO();
        dao78.postConstruct();
        OrgUnitCatDAO dao79 = new OrgUnitCatDAO();
        dao79.postConstruct();
        DSDynaWFVerDAO dao80 = new DSDynaWFVerDAO();
        dao80.postConstruct();
        OrgSecUserDAO dao81 = new OrgSecUserDAO();
        dao81.postConstruct();
        TSSDGroupDetailDAO dao82 = new TSSDGroupDetailDAO();
        dao82.postConstruct();
        OrgUserLevelDAO dao83 = new OrgUserLevelDAO();
        dao83.postConstruct();
        FileDAO dao84 = new FileDAO();
        dao84.postConstruct();
        WFDynamicUserDAO dao85 = new WFDynamicUserDAO();
        dao85.postConstruct();
        PPModelDAO dao86 = new PPModelDAO();
        dao86.postConstruct();
        TSSDTaskLogDAO dao87 = new TSSDTaskLogDAO();
        dao87.postConstruct();
        WFUserDAO dao88 = new WFUserDAO();
        dao88.postConstruct();
        DataSyncOutDAO dao89 = new DataSyncOutDAO();
        dao89.postConstruct();
        UserGroupDAO dao90 = new UserGroupDAO();
        dao90.postConstruct();
        UserObjectDAO dao91 = new UserObjectDAO();
        dao91.postConstruct();
        WFTmpStepActorDAO dao92 = new WFTmpStepActorDAO();
        dao92.postConstruct();
        WFWorkList2DAO dao93 = new WFWorkList2DAO();
        dao93.postConstruct();
        DataEntityDAO dao94 = new DataEntityDAO();
        dao94.postConstruct();
        MsgAccountDAO dao95 = new MsgAccountDAO();
        dao95.postConstruct();
        DataSyncAgentDAO dao96 = new DataSyncAgentDAO();
        dao96.postConstruct();
        WFInstanceDAO dao97 = new WFInstanceDAO();
        dao97.postConstruct();
        WXMessageDAO dao98 = new WXMessageDAO();
        dao98.postConstruct();
        WFUserGroupDAO dao99 = new WFUserGroupDAO();
        dao99.postConstruct();
        OrgUserDAO dao100 = new OrgUserDAO();
        dao100.postConstruct();
        OrgSecUserTypeDAO dao101 = new OrgSecUserTypeDAO();
        dao101.postConstruct();
        WFReminderDAO dao102 = new WFReminderDAO();
        dao102.postConstruct();
        WFStepInstDAO dao103 = new WFStepInstDAO();
        dao103.postConstruct();
        OrgDAO dao104 = new OrgDAO();
        dao104.postConstruct();
    }

    protected void prepareWorkflows() throws Exception {
    }

    protected void prepareBASchemes() throws Exception {
    }

    protected void prepareWXAccounts() throws Exception {
    }

    @Override
    protected void onInstallRTDatas() throws Exception {
        super.onInstallRTDatas();
        UserDictCatService userDictCatService = (UserDictCatService)ServiceGlobal.getService(UserDictCatService.class);
        UserDictService userDictService = (UserDictService)ServiceGlobal.getService(UserDictService.class);
        UniResService uniResService = (UniResService)ServiceGlobal.getService(UniResService.class);
        MsgTemplateService msgTemplateService = (MsgTemplateService)ServiceGlobal.getService(MsgTemplateService.class);
        ServiceService serviceService = (ServiceService)ServiceGlobal.getService(ServiceService.class);
        WFAppSettingService wfAppSettingService = (WFAppSettingService)ServiceGlobal.getService(WFAppSettingService.class);
        DataSyncAgentService dataSyncAgentService = (DataSyncAgentService)ServiceGlobal.getService(DataSyncAgentService.class);
        WXAccountService wxAccountService = (WXAccountService)ServiceGlobal.getService(WXAccountService.class);
        WXEntAppService wxEntAppService = (WXEntAppService)ServiceGlobal.getService(WXEntAppService.class);
        this.onInstallRTDatas_DataEntity();
    }

    protected void onInstallRTDatas_DataEntity() throws Exception {
        this.onInstallRTDatas_DataEntity_DEModel();
        this.onInstallRTDatas_DataEntity_DynaSys();
        this.onInstallRTDatas_DataEntity_WX();
        this.onInstallRTDatas_DataEntity_WF();
        this.onInstallRTDatas_DataEntity_Common();
    }

    protected void onInstallRTDatas_DataEntity_DEModel() throws Exception {
        DataEntityService dataEntityService = (DataEntityService)ServiceGlobal.getService(DataEntityService.class);
        QueryModelService queryModelService = (QueryModelService)ServiceGlobal.getService(QueryModelService.class);
        DataEntity dataEntity = new DataEntity();
        dataEntity.setDEId("ee650aec5d0df3c9880100dc57441146");
        dataEntity.setDEName(QUERYMODEL);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5b9e\u4f53\u67e5\u8be2\u6a21\u578b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("0cbbb4ccda4e86a9e6f16ed5f3a171c2");
        dataEntity.setDEName(DATAENTITY);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5b9e\u4f53");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
    }

    protected void onInstallRTDatas_DataEntity_DynaSys() throws Exception {
        DataEntityService dataEntityService = (DataEntityService)ServiceGlobal.getService(DataEntityService.class);
        QueryModelService queryModelService = (QueryModelService)ServiceGlobal.getService(QueryModelService.class);
        DataEntity dataEntity = new DataEntity();
        dataEntity.setDEId("455ba35d2ea0b7be6e2035f54ff60f5b");
        dataEntity.setDEName(DSDYNAVIEWINST);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u52a8\u6001\u89c6\u56fe\u5b9e\u4f8b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("7a90be048da1f8e71d2f8f74e8703c05");
        dataEntity.setDEName(DSDYNACODELIST);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u52a8\u6001\u4ee3\u7801\u8868");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("87d8599997ce9323cd2bba43278b4135");
        dataEntity.setDEName(DSDYNAVIEW);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u52a8\u6001\u89c6\u56fe");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("94ed000542e335afa0722bc1cbfdf279");
        dataEntity.setDEName(DSDYNAWF);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u52a8\u6001\u5de5\u4f5c\u6d41");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("da1ebfa0f1777e651b33c7e1df73c4ec");
        dataEntity.setDEName(DSDYNAWFVER);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u52a8\u6001\u5de5\u4f5c\u6d41\u7248\u672c");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
    }

    protected void onInstallRTDatas_DataEntity_WX() throws Exception {
        DataEntityService dataEntityService = (DataEntityService)ServiceGlobal.getService(DataEntityService.class);
        QueryModelService queryModelService = (QueryModelService)ServiceGlobal.getService(QueryModelService.class);
        DataEntity dataEntity = new DataEntity();
        dataEntity.setDEId("aeb4861b6d65eff3ef2098ddd7a0d4f5");
        dataEntity.setDEName(WXENTAPP);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("7c0817a9156329b7eed4a878988f31cc");
        dataEntity.setDEName(WXACCESSTOKEN);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5fae\u4fe1\u8bbf\u95ee\u7968\u636e");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("a807f4b43d86fbcad55c58e4621a8c80");
        dataEntity.setDEName(WXACCOUNT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5fae\u4fe1\u516c\u4f17\u53f7");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("2b5ee3ad72f76d2cb7d12f8c5f31b817");
        dataEntity.setDEName(WXORGSECTOR);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5fae\u4fe1\u90e8\u95e8");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("6e265a32be682141a452a8832bc78530");
        dataEntity.setDEName(WXMEDIA);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5fae\u4fe1\u591a\u5a92\u4f53\u5185\u5bb9");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("657d40a805a0f204934829160a198bb7");
        dataEntity.setDEName(WXMESSAGE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5fae\u4fe1\u6d88\u606f");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
    }

    protected void onInstallRTDatas_DataEntity_WF() throws Exception {
        DataEntityService dataEntityService = (DataEntityService)ServiceGlobal.getService(DataEntityService.class);
        QueryModelService queryModelService = (QueryModelService)ServiceGlobal.getService(QueryModelService.class);
        DataEntity dataEntity = new DataEntity();
        dataEntity.setDEId("9f2a5bbda357d70344cb5debd7d05c71");
        dataEntity.setDEName(WFUSERCANDIDATE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u7528\u6237\u5019\u9009\u8005");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("095ff4eab83529a1b8f093180a7ef3fa");
        dataEntity.setDEName(WFSTEPDATA);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u6570\u636e");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("c93ef4408352303441d2f73e0e4990a2");
        dataEntity.setDEName(WFWORKLIST);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u5de5\u4f5c\u5217\u8868");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("0b60b3e6ed35cc656ceecb6fac698e6e");
        dataEntity.setDEName(WFUSERGROUPDETAIL);
        dataEntity.setDEType(3);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u7528\u6237\u7ec4\u6210\u5458");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("4b334725c65c703dfa12a6ed7103a9da");
        dataEntity.setDEName(WFCUSTOMPROCESS);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u9884\u5b9a\u4e49\u5904\u7406");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("c0a02fe821e07837af3333a49fb08b30");
        dataEntity.setDEName(WFUSERASSIST);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u7528\u6237\u4ee3\u529e");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("e1ba3122fd9af91ae76dd18bf015669a");
        dataEntity.setDEName(WFIAACTION);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("80bc47afe28e23ebfb7aea12fdbc1acd");
        dataEntity.setDEName(WFASSISTWORK);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u4ee3\u529e\u5de5\u4f5c");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("0166e9c016bf57201ba996cba3a67a45");
        dataEntity.setDEName(WFWORKFLOW);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(1);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u914d\u7f6e");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("a532b2dae4eeecca638c9a8e1b7e3fa7");
        dataEntity.setDEName(WFACTOR);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u64cd\u4f5c\u8005");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("fa6ff2a161c8371f494e170dde6ddb53");
        dataEntity.setDEName(WFUCPOLICY);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u5019\u9009\u7528\u6237\u7b56\u7565");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("3860c42c755f4097c4dfe7d806b185bc");
        dataEntity.setDEName(WFSTEPACTOR);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u64cd\u4f5c\u8005");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("50811730d38a8bd964a31a05331bc214");
        dataEntity.setDEName(WFACTION);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u7528\u6237\u64cd\u4f5c");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("6ad51695d5686e6ed1738d36b5a6b1a2");
        dataEntity.setDEName(WFUIWIZARD);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u64cd\u4f5c\u754c\u9762");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("aa16d05a90245cec51dc8a2fb7f63fdb");
        dataEntity.setDEName(WFSTEP);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("598b85c09bc9375e762590d2ab97552c");
        dataEntity.setDEName(WFAPPSETTING);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u7cfb\u7edf\u8bbe\u5b9a");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("3d6fd9746bb1acf4b6af87da05f6a646");
        dataEntity.setDEName(WFSYSTEMUSER);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u7cfb\u7edf\u7528\u6237");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("f0abca40127ddf436270635ba0e3c135");
        dataEntity.setDEName(WFWFVERSION);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u914d\u7f6e\u7248\u672c");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("733170434261be84089d353a6a231373");
        dataEntity.setDEName(WFDYNAMICUSER);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("ef2c7b349c855e594aa4fe0cb7ad8b48");
        dataEntity.setDEName(WFUSER);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u7528\u6237");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("0e976da1c2895bf2e955f90554c10b15");
        dataEntity.setDEName(WFTMPSTEPACTOR);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u64cd\u4f5c\u8005\uff08\u4e34\u65f6\uff09");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("e888ed9d1cfcb38ac15cceaa4130b162");
        dataEntity.setDEName(WFWORKLIST2);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u5de5\u4f5c\u5217\u88682");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("0211d06b901d7948d2394149b7d0d96e");
        dataEntity.setDEName(WFINSTANCE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(1);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u5b9e\u4f8b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("e64a576e41250c73ac1f51c15d6631e2");
        dataEntity.setDEName(WFUSERGROUP);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u7528\u6237\u7ec4");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("352ff0280b4d127a400f4262d6ebfded");
        dataEntity.setDEName(WFREMINDER);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u5de5\u4f5c\u50ac\u529e");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("707f76a538be385bf4bf65a2b1125003");
        dataEntity.setDEName(WFSTEPINST);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u5b50\u5b9e\u4f8b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
    }

    protected void onInstallRTDatas_DataEntity_Common() throws Exception {
        DataEntityService dataEntityService = (DataEntityService)ServiceGlobal.getService(DataEntityService.class);
        QueryModelService queryModelService = (QueryModelService)ServiceGlobal.getService(QueryModelService.class);
        DataEntity dataEntity = new DataEntity();
        dataEntity.setDEId("df93b04c07324dc3f4ae6aa109e612d1");
        dataEntity.setDEName(SYSTEM);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7cfb\u7edf");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("88d390ffbdb76f146f608c669729d81d");
        dataEntity.setDEName(UNIRES);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7edf\u4e00\u8d44\u6e90");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("2be4c985b8c11e06783904ce4e9d8b90");
        dataEntity.setDEName(DEDATACHG2);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\uff08\u5df2\u5904\u7406\uff09");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("089885ec20e095e248e78d49d3153815");
        dataEntity.setDEName(SYSADMIN);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7cfb\u7edf\u7ba1\u7406\u6a21\u5757");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("a54fc7fa42e8260cab1cb33393e222b1");
        dataEntity.setDEName(USERROLEDATADETAIL);
        dataEntity.setDEType(3);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6570\u636e\u5bf9\u8c61\u80fd\u529b\u660e\u7ec6");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("54b64fbcfb4f415664d56327f7a2c210");
        dataEntity.setDEName(DEDATACHGDISP);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u6d3e\u53d1\u5f15\u64ce");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("43332c6488824ab95b327d64b4f23a1b");
        dataEntity.setDEName(TSSDTASKTYPE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4efb\u52a1\u8c03\u5ea6\u4efb\u52a1\u7c7b\u578b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("d1ce1f760d77192f620b4f6b9d7769f8");
        dataEntity.setDEName(PVPART);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("326125ce130f4bec558c9778daef045c");
        dataEntity.setDEName(DATAAUDIT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6570\u636e\u5ba1\u8ba1");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("ee84bfb6e336a62bdcd671895549aebe");
        dataEntity.setDEName(USERROLERES);
        dataEntity.setDEType(3);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u89d2\u8272\u8d44\u6e90\u80fd\u529b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("6f29424570cf5cb552950326c000e031");
        dataEntity.setDEName(REGISTRY);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6ce8\u518c\u8868");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("1e40618663977c439800bf56d8ac4390");
        dataEntity.setDEName(USERROLE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u89d2\u8272");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("7fbddaf527849efd537411955e65800d");
        dataEntity.setDEName(TSSDTASKPOLICY);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u8c03\u5ea6\u4efb\u52a1\u9879\u7b56\u7565");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("f19ecba385e1fe480789956e5f638b78");
        dataEntity.setDEName(TSSDPOLICYOWNER);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u6240\u6709\u8005");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("10d6c2ea8dda8754dcde1bceab9704c5");
        dataEntity.setDEName(USERROLEDEFIELD);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u89d2\u8272\u5b9e\u4f53\u5c5e\u6027\u8bbf\u95ee");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("f37da71b9c7217fb86634c135e6fb7e0");
        dataEntity.setDEName(TSSDGROUP);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u7ec4");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("c41d9a5508a558b5ccc8a091c5e249b1");
        dataEntity.setDEName(USERDICTCAT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u8bcd\u6761\u7c7b\u522b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("7923f282cb5da8b2419d53cb6fc6e9a7");
        dataEntity.setDEName(TSSDITEM);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u9879");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("7628b30c66aaeab68c9aec1aed3f7e21");
        dataEntity.setDEName(LOGINLOG);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5e10\u6237\u4f7f\u7528\u8bb0\u5f55");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("2e71859d8147cd788d815a3371f9ebd6");
        dataEntity.setDEName(SYSADMINFUNC);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7cfb\u7edf\u7ba1\u7406\u529f\u80fd");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("f8d12641ce30b874fa6c58f749b0bb73");
        dataEntity.setDEName(TSSDTASK);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4efb\u52a1\u8c03\u5ea6\u4efb\u52a1\u9879");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("0cc63f54de2a15b9a7db47ff805af49a");
        dataEntity.setDEName(USERROLEDATAACTION);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u89d2\u8272\u6570\u636e\u64cd\u4f5c");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("3bb1f0b62e66ff93dc5929eb8794751a");
        dataEntity.setDEName(ORGTYPE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7ec4\u7ec7\u7c7b\u578b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("4f42003f518ff9e8ba0c1d582a3b70d5");
        dataEntity.setDEName(DALOG);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("DA\u65e5\u5fd7");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("dfe988181f007801f103fd18e8a5661b");
        dataEntity.setDEName(USERDGTHEME);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u8868\u683c\u81ea\u5b9a\u4e49");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("b2af03b3659b89cfbfc6f8932ff1b61f");
        dataEntity.setDEName(USERROLEDATAS);
        dataEntity.setDEType(3);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u89d2\u8272\u6570\u636e\u80fd\u529b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("63061bfdafbbd213fc0ce66d3f26419e");
        dataEntity.setDEName(ORGSECTOR);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7ec4\u7ec7\u90e8\u95e8");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("323db6416464fc80757753d4f3666854");
        dataEntity.setDEName(MSGSENDQUEUE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6d88\u606f\u53d1\u9001\u961f\u5217");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("a6ba8b8895f3f2438f9e9ef761ccb29c");
        dataEntity.setDEName(USERROLEDETAIL);
        dataEntity.setDEType(3);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u89d2\u8272\u6210\u5458");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("c4125399a698dc5f8acca6dc8b38b353");
        dataEntity.setDEName(USERROLEDATA);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6570\u636e\u5bf9\u8c61\u80fd\u529b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("c95a8972b0f72a140d65e057a002144a");
        dataEntity.setDEName(USERROLEDEFIELDS);
        dataEntity.setDEType(3);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u89d2\u8272\u76f8\u5173\u5b9e\u4f53\u5c5e\u6027\u8bbf\u95ee\u63a7\u5236");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("6f417c7c7a003110acbb270429717f0f");
        dataEntity.setDEName(MSGSENDQUEUEHIS);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6d88\u606f\u53d1\u9001\u961f\u5217\uff08\u5386\u53f2\uff09");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("04c87ff6cdac6dd390613dbc44f3c51d");
        dataEntity.setDEName(DATASYNCIN2);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6570\u636e\u540c\u6b65\u63a5\u6536\u961f\u52172");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("7d9fefe4909e0cfffcb467129475b02d");
        dataEntity.setDEName(DATAAUDITDETAIL);
        dataEntity.setDEType(2);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6570\u636e\u5ba1\u8ba1\u660e\u7ec6");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("0af0cc46519139106341b4cbfe9b89e7");
        dataEntity.setDEName(TSSDPOLICY);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4efb\u52a1\u65f6\u523b\u7b56\u7565");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("85317205b415aa6af990684ca7704515");
        dataEntity.setDEName(CODELIST);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4ee3\u7801\u8868");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("e2c5b96d6cb0389900da130bc4545add");
        dataEntity.setDEName(MSGTEMPLATE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(1);
        dataEntity.setDELogicName("\u6d88\u606f\u6a21\u677f");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("f5d60d6bd8ba7928bbe13fed42ae606a");
        dataEntity.setDEName(USERROLETYPE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u89d2\u8272\u7c7b\u578b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("4d49318ec5a12e0a9e36d79e45c641f2");
        dataEntity.setDEName(USERDICTITEM);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u8bcd\u6761");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("3621f160a6392fc07fea086d691daa0d");
        dataEntity.setDEName(DATASYNCIN);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6570\u636e\u540c\u6b65\u63a5\u6536\u961f\u5217");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("60a039b41c39edc7ff965f1c0958232d");
        dataEntity.setDEName(CODEITEM);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4ee3\u7801\u9879");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("e4da63c72c04866163e5a74ca984d13f");
        dataEntity.setDEName(TSSDENGINE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4efb\u52a1\u8c03\u5ea6\u5f15\u64ce");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("404bf990bacdba520e82d9603063c3dd");
        dataEntity.setDEName(USERGROUPDETAIL);
        dataEntity.setDEType(3);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u7ec4\u6210\u5458");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("1cecb3d95febd748a2daf8e9c86a8ec5");
        dataEntity.setDEName(DATASYNCOUT2);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6570\u636e\u540c\u6b65\u53d1\u9001\u961f\u52172");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("08903b770bfabc9dbb8e95f19a74ed65");
        dataEntity.setDEName(SERVICE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u670d\u52a1");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("b0a62e77dcb2ca3226353cea1c370b79");
        dataEntity.setDEName(MSGACCOUNTDETAIL);
        dataEntity.setDEType(2);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7ec4\u6d88\u606f\u8d26\u6237\u660e\u7ec6");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("de0f12cf67b20fb12eb5454093998c74");
        dataEntity.setDEName(USERDICT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7528\u6237\u8bcd\u5178");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("b46bdd8836d4e93bad690042e23ff374");
        dataEntity.setDEName(DEDATACHG);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u5b9e\u4f53\u6570\u636e\u53d8\u66f4");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("f63040021720d1401ec2014d30b02bb6");
        dataEntity.setDEName(PORTALPAGE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u95e8\u6237\u9875\u9762");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("5ae7d9610693e638cd1064cf7c9126f8");
        dataEntity.setDEName(LOGINACCOUNT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u767b\u5f55\u5e10\u6237");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("f4552a6291c79e3934263b31b83aec33");
        dataEntity.setDEName(USER);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(1);
        dataEntity.setDELogicName("\u7528\u6237");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("37c7b65732fb7013db7c970d1262e849");
        dataEntity.setDEName(ORGUNITCAT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7ec4\u7ec7\u5355\u5143\u7c7b\u522b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("a29184750c477cf3910fc2179179dccc");
        dataEntity.setDEName(ORGSECUSER);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7ec4\u7ec7\u90e8\u95e8\u4eba\u5458");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("e8b6c72b7a73a98f68bf91b812d46c31");
        dataEntity.setDEName(TSSDGROUPDETAIL);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u7ec4\u660e\u7ec6");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("e6c870c62a861cfd5593212fa41d6f88");
        dataEntity.setDEName(ORGUSERLEVEL);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7ec4\u7ec7\u4eba\u5458\u7ea7\u522b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("1c1b5758a629c73a4e148d5328a921fd");
        dataEntity.setDEName(FILE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(1);
        dataEntity.setDELogicName("\u6587\u4ef6");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("14ad5675b58882f0e61ba3caabcf6f5e");
        dataEntity.setDEName(PPMODEL);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u95e8\u6237\u9875\u9762\u6a21\u578b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("5d9604bc9220d47f935650303d154680");
        dataEntity.setDEName(TSSDTASKLOG);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u4efb\u52a1\u8c03\u5ea6\u65e5\u5fd7");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("c8381accf6c7621d57757a4955ddb504");
        dataEntity.setDEName(DATASYNCOUT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u6570\u636e\u540c\u6b65\u53d1\u9001\u961f\u5217");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("5eba267a2d34c0c5dc686961a48f62d1");
        dataEntity.setDEName(USERGROUP);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(1);
        dataEntity.setDELogicName("\u7528\u6237\u7ec4");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("318a3649ecafa3b934925a0231207d09");
        dataEntity.setDEName(USEROBJECT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(1);
        dataEntity.setDELogicName("\u7528\u6237\u5bf9\u8c61");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("7ce656616f83e08ed4aeba648bb0a30b");
        dataEntity.setDEName(MSGACCOUNT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(1);
        dataEntity.setDELogicName("\u6d88\u606f\u8d26\u6237");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("eca73ee23612ec7a94bc4d8f40f3c5dc");
        dataEntity.setDEName(DATASYNCAGENT);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(1);
        dataEntity.setDELogicName("\u6570\u636e\u540c\u6b65\u4ee3\u7406");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("1f9576cdcc6a949230c7669182c73648");
        dataEntity.setDEName(ORGUSER);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7ec4\u7ec7\u4eba\u5458");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("576dd33b28a3ee34ba68561c68aa93b3");
        dataEntity.setDEName(ORGSECUSERTYPE);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u90e8\u95e8\u4eba\u5458\u5173\u7cfb\u7c7b\u578b");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
        dataEntity = new DataEntity();
        dataEntity.setDEId("e3e158d75b7bc6f589686b6e1beb966c");
        dataEntity.setDEName(ORG);
        dataEntity.setDEType(1);
        dataEntity.setIsLogicValid(0);
        dataEntity.setDELogicName("\u7ec4\u7ec7\u673a\u6784");
        dataEntity.setDEVersion(1);
        if (dataEntityService.checkKey(dataEntity) == 0) {
            dataEntityService.create(dataEntity, false);
            ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]\u5b89\u88c5[%2$s][%3$s]\r\n", this.getName(), dataEntityService.getDEModel().getLogicName(), dataEntityService.getDEModel().getDataInfo(dataEntity)));
        }
    }

    public PluginList getPSRuntimePlugins() {
        return this.pSRuntimePlugins;
    }

    @Override
    public String getServiceAPIClientId() {
        return this.pSRuntimeServiceAPIClientId;
    }

    protected void prepareSysUtils() {
    }
}

