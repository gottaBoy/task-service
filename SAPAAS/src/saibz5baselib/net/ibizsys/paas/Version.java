package net.ibizsys.paas;

import net.ibizsys.paas.util.StringHelper;

/**
 * SA iBizSys5 J2EE Runtime 版本信息
 * @author Administrator
 * 
 * @version 5.0.23.8
 * (1) 增强表格代码表层次数据支持
 * 
 * @version 5.0.23.7
 * (1) 增强甘特部件，相关处理及视图代码有调整
 * 
 * @version 5.0.23.6
 * (1) 增强地图部件，相关处理及视图代码有调整
 * 
 * @version 5.0.23.5
 * (1) 增强树节点计数功能,相关代码有调整
 * 
 * @version 5.0.23.4
 * (1) net.ibizsys.paas.core.DataTypes.BIGDECIMAL 提供新的标准数据类型：大数值，功能与数值(DECIMAL)一致，细腻数据库处理区分（可按数值处理）
 * 
 * @version 5.0.23.3
 * (1) net.ibizsys.paas.core.IDataEntity 提供用户自定义存储模式定义
 * 
 * @version 5.0.23.2
 * (1) 支持设置使用登录名称作为当前操作者，net.ibizsys.paas.sysmodel.SysModelGlobal.setUseLoginNameAsOperator，相关代码有调整
 * (2) 修复一些BUG及功能微调  
 * 
 * @version 5.0.23.1
 * (1) 修复net.sf.json.JSONObject 导出null的问题
 * 
 * @version 5.0.23.0
 * (1) 运行包数据对象支持序列化
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.22.7
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.22.6
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.22.5
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.22.4
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.22.3
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.22.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.22.1
 * (1) 增强数据查询处理
 * 
 * @version 5.0.22.0
 * (1) 增强数据查询处理
 * 
 * @version 5.0.21.8
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.21.7
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.21.6
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.21.5
 * (1) 增强 net.ibizsys.paas.web.util.RemoteLoginServlet，登录成功后进一步填充组织信息，实现与常规登录相同流程
 * 
 * @version 5.0.21.4
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.21.3
 * (1) 修复一些BUG及功能微调
 *  
 * @version 5.0.21.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.21.1
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.21.0
 * (1) 增加 net.ibizsys.paas.sysmodel.util.IAppCustomizeUtil 系统应用自定义功能对象及相关实现，完成应用自定义功能（如菜单自定义）
 * (2) 增强 net.ibizsys.paas.ctrlmodel.AppMenuModelBase，支持应用菜单自定义
 * 
 * @version 5.0.20.22
 * (1) 增加 net.ibizsys.paas.controller.HtmlViewControllerBase Html视图控制器基类
 * 
 * @version 5.0.20.21
 * (1) 增加 net.ibizsys.pswf.controller.AppWFSendBackViewControllerBase 应用工作流回退操作视图等控制器基类
 * 
 * 
 * @version 5.0.20.20
 * (1) 增强 net.ibizsys.paas.service.ServiceBase，提供新的系统级别属性（SRFENTITYKEY），解决从临时数据创建真数据无法指定数据主建的问题 
 * (2) 增加 net.ibizsys.paas.controller.AppPanelViewControllerBase 应用面板视图控制器基类
 * 
 * @version 5.0.20.19
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.18
 * (1) 增强 net.ibizsys.paas.sysmodel.ISystemModel，增加 getDataEntityModels 方法，相关实现有调整
 * 
 * @version 5.0.20.17
 * (1) 增加 net.ibizsys.pswf.core.IWFEndProcessModel，相关实现有调整，支持定义工作流退出状态值
 * 
 * @version 5.0.20.16
 * (1) 增强 net.ibizsys.paas.dao.DAOBase，fetchDEDataSet 方法在外部不指定结果集合排序方向时使用结果集默认排序
 * (2) 增强 net.ibizsys.paas.ctrlmodel.FormModelBase，支持进一步输出权限控制表单项是否输出更新标记
 * 
 * @version 5.0.20.15
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.14
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.13
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.12
 * (1) 增强 net.ibizsys.paas.controller.RedirectViewControllerBase，支持请求视图行为  GETRDVIEWURL 直接返回跳转路径，用于独立页面级跳转
 * 
 * @version 5.0.20.11
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.10
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.9
 * (1) 修复一些BUG及功能微调
 *  
 * @version 5.0.20.8
 * (1) 增加 net.ibizsys.paas.controller.MobChartViewControllerBase 等控制器基类
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.7
 * (1) 增强 net.ibizsys.paas.appmodel.AppViewModel 对象
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.6
 * (1) 增加 net.ibizsys.pswf.controller.MobWFDataRedirectViewControllerBase 等控制器基类
 * (2) 修复一些BUG及功能微调
 *  
 * @version 5.0.20.5
 * (1) 增加应用功能视图相关的控制类
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.4
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.3
 * (1) 增加 net.ibizsys.paas.controller.AppUtilViewControllerBase 等应用功能视图控制器基类
 * (2) 增加 net.ibizsys.paas.sysmodel.ISystemUtil 对象，支持系统功能模块功能
 * (3) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.1
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.20.0
 * (1) 增强 扩展存储支持
 * 
 * @version 5.0.19.39
 * (1) 增强  net.ibizsys.paas.service.IService 接口，提供新的 create、update 方法
 * 
 * @version 5.0.19.38
 * (1) 增加 net.ibizsys.paas.appmodel.IAppModeModel，提供多应用模式功能支持，相关代码增强
 * (2) 增强 net.ibizsys.paas.data.DataObject.getIntegerValue 方法，支持从更多数据类型中取出整数值
 *  
 * @version 5.0.19.37
 * (1) 增强 net.ibizsys.paas.db.SelectContext,增加新的 addSelectField 方法方便建立选择字段
 * (2) 增强 net.ibizsys.paas.controller.IDynaViewController，增加 resetDynaViewControllerInsts 方法
 * 
 * @version 5.0.19.36
 * (1) 增加面板部件模型及后台处理对象 net.ibizsys.paas.ctrlmodel.PanelModelBase、net.ibizsys.paas.ctrlhandler.PanelHandlerBase
 * (2) 增强 net.ibizsys.paas.view.IUIAction，增加 isClosePopupView 是否关闭弹出视图属性，相关实现及处理对象有增强
 * 
 * @version 5.0.19.35
 * (1) 增强 net.ibizsys.paas.service.IService，增加新的 getDataSummary方法，用于获取数据的概要信息
 * (2) 增强 net.ibizsys.paas.ctrlhandler.TreeHandlerBase，支持获取树节点提示信息
 * (2) 增强 net.ibizsys.paas.ctrlhandler.GridHandlerBase，支持获取表格行提示信息
 * 
 * @version 5.0.19.34
 * (1) 增加面板视图相关控制器
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.33
 * (1) 增强 net.ibizsys.paas.service.ServiceBase，增加新的 getRemoveRejectMsg 方法，可将限制删除的数据传入
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.32
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.31
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.30
 * (1) 修复一些BUG及功能微调，解决JSONObject处理Json字符串的问题，net.ibizsys.paas.util.JSONObjectHelper，net.ibizsys.paas.data.DataObject 有调整
 *  
 * @version 5.0.19.29
 * (1) 增强 net.ibizsys.paas.sysmodel.ISystemModel ,增加全局登记异常方法 logException，相关实体服务代码、应用代码有调整
 * (2) 增加移动端日历视图控制器基类，net.ibizsys.paas.controller.MobCalendarViewControllerBase等
 *  
 * @version 5.0.19.28
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.27
 * (1) 增强 net.ibizsys.paas.api.RestServiceAPIClientModelBase，处理 GET 及 DELETE 操作时可以不指定主键
 * (2) 增强 net.ibizsys.paas.util.JSONObjectHelper，进一步处理Json字符串 （[],{}）被转为JSON对象的问题
 * (3) 调整 net.ibizsys.paas.demodel.DataEntityModelBase,方法 getServiceAPIActionTag 返回API标记都转为大写
 * (4) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.26
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.25
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.24
 * (1) 增强 net.ibizsys.paas.service.IService，提供返回范型的 select 方法
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.23
 * (1) 提供 日历视图 支持，增加了相应的部件模型对象，处理对象，日历视图控制器对象等
 * 
 * @version 5.0.19.22
 * (1) 增强 net.ibizsys.paas.data.IDataObject，增加 fillJSONObject 方法，支持设置是否只导出被修改的值 
 * (2) 修复一些BUG及功能微调
 *  
 * @version 5.0.19.21
 * (1) 增强 net.ibizsys.paas.ctrlmodel.ITreeNodeModel 等相关对象，支持树节点搜索能力
 * 
 * @version 5.0.19.20
 * (1) 增强 net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase，支持查询上下文逻辑计算
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.19
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.18
 * (1) 增强 属性数据库值模式（忽略）  net.ibizsys.paas.core.IDEField.DBVALUEMODE_IGNORE，设置为该模式的属性将不插入（更新）数据库
 * 
 * 
 * @version 5.0.19.17
 * (1) 增加 net.ibizsys.paas.sysmodel.ISystemPartModel 系统成员模型等相关对象
 * 
 * @version 5.0.19.16
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.15
 * (1) 增强 net.ibizsys.paas.service.IService 增强导出模型能力，支持无关联导出等
 *  
 * @version 5.0.19.14
 * (1) 增加 net.ibizsys.paas.control.tree.ITreeNodeDataItem 等树表格相关对象
 * 
 * @version 5.0.19.13
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.12
 * (1) 增强 net.ibizsys.paas.service.IService 增加 getServiceActionHelper 方法
 * 
 * @version 5.0.19.11
 * (1) 增强界面行为（UIAction）相关，支持获取运行时界面行为模型，完成诸如动态提示信息等功能
 * (2) 增强 net.ibizsys.paas.controller.ViewControllerBase，支持直接处理界面行为等相关异步请求
 * (3) 增强 net.ibizsys.paas.ctrlhandler.EditFormHandlerBase 等，支持加载界面行为运行时模型
 * (4) 增强 net.ibizsys.paas.appmodel.IAppPFHelper，增加 getAppViewTag 获取应用视图标记
 * 
 * 
 * @version 5.0.19.10
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.9
 * (1) 修复一些BUG及功能微调
 *  
 * @version 5.0.19.8
 * (1) 增强动态子系统运行实体 DSDYNAVIEW、DSDYNAVIEWINST，增加实体标识及实体工作流标识等属性
 * (2) 增加 net.ibizsys.pswf.core.DynaDEWFModelBase等，增强动态子系统，支持动态工作流选择不同的步骤视图
 * 
 * @version 5.0.19.7
 * (1) 增强加载应用数据功能，net.ibizsys.paas.appmodel.IApplicationModel等相关对象有调整
 * (2) 增加 net.ibizsys.pswf.core.WFDEDataSetRoleModelBase 对象，实现实体数据集流程角色功能
 * 
 * @version 5.0.19.6
 * (1) 增强 net.ibizsys.paas.sysmodel.DynamicCodeListModelBase，支持指定禁用值属性
 * (2) 增强 net.ibizsys.paas.demodel.CodeListDEDataSetModelBase，支持快速搜索
 * (3) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.5
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.4
 * (1) 增强 net.ibizsys.paas.service.ServiceBase，增加 fromDBFetchResult 方法，将传入数据集合结果对象转为为实体数据对象列表
 * .
 * @version 5.0.19.3
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.19.2
 * (1) 合入达梦，SQLite 数据库配器相关代码
 * 
 * @version 5.0.19.1
 * (1) 增加 net.ibizsys.paas.ctrlmodel.IDynaGridModel 接口及相关对象，支持动态表格能力
 * (2) 增加 net.ibizsys.paas.util.JSONStringEx 对象，解决JSONObject对象自动消除单引号、双引号问题 
 *
 * @version 5.0.19.0
 * (1) 合入HANA数据库适配器相关代码
 * 
 * @version 5.0.18.22
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.18.21
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.18.20
 * (1) 增强动态子系统相关能力
 * 
 * @version 5.0.18.19
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.18.18
 * (1) 修复一些BUG及功能微调
 * (2) 增加 net.ibizsys.pswf.core.IWFTimerEventProcessModel 接口及相关对象，支持工作流定时触发处理能力
 * 
 * @version 5.0.18.17
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.18.16
 * (1) 增强 net.ibizsys.paas.service.IService 接口，增加selectOne及selectTempOne方法，功能与原来select及selectTemp单项数据方法一致，使用起来更清晰
 * (2) 增强运行子系统，增加 DSDynaCodeList 实体等
 * 
 * @version 5.0.18.15
 * (1) 合入Vue前端应用相关基础代码
 *  
 * @version 5.0.18.14
 * (1) 增强 net.ibizsys.pswf.core.IWFProcSubWFModel，支持 getWFVerId 获取子流程版本
 * (2) 增强工作流系统支持嵌入流程指定版本功能
 * 
 * @version 5.0.18.13
 * (1) 增加 net.ibizsys.paas.core.IDEFDTColumn，net.ibizsys.paas.core.IDEDBConfig 接口，支持实体模型针对不同的数据库类型重新指定表、视图或列名称，相关的代码有调整
 * (2) 支持针对不同的数据库类型为实体、属性设置不同的表、视图及列名称
 * 
 * 
 * @version 5.0.18.12
 * (1)合入  net.ibizsys.paas.web.util.ExportFile2Servlet，net.ibizsys.paas.web.util.ExportFile2Servlet2 代码
 * 
 * @version 5.0.18.11
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.18.10
 * (1) 增强动态子系统相关能力
 * 
 * @version 5.0.18.9
 * (1) 增强 主键的数据库函数值产生模式 
 * (2) 修复 net.ibizsys.paas.core.DEDataSetCond 子条件导入导出问题
 * 
 * @version 5.0.18.8
 * (1) 合入 mysql、sqlserver、db2、oracle 运行数据结构文件
 * (2) 增强动态子系统相关对象
 * 
 * @version 5.0.18.7
 * (1) 增强  net.ibizsys.paas.entity.EntityBase 关于代理外部对象的功能，关键调整
 * 
 * @version 5.0.18.6
 * (1) 增强  net.ibizsys.paas.sysmodel.ISystemModel 接口，增加 installDBModel 方法，net.ibizsys.paas.util.SystemRTHelper 有调整
 * (2) 增强  net.ibizsys.paas.web.WebFilter，支持通过配置在系统启动时安装数据库模型
 *
 * 
 * @version 5.0.18.5
 * (1) 增强 net.ibizsys.paas.ctrlmodel.IDynaCtrlModel 接口，增加 isEnableDynaCtrl 方法
 * (2) 修复 net.ibizsys.pswf.ctrlhandler.WFActionFormHandlerBase 在处理多版本流程在某些场景可能触发的问题
 * 
 * @version 5.0.18.4
 * (1) 增加相关的应用功能（文件上传，下载等）Servlet
 * 
 * @version 5.0.18.3
 * (1) 添加密码过期处理功能
 * (2) 增强 net.ibizsys.paas.appmodel.IApplicationModel 接口，添加getAppFolder方法获取当前应用目录
 * (3) 针对动态子系统进行整体调整，视图控制器，部件模型，部件处理对象都进行增强
 * 
 * @version 5.0.18.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.18.1
 * (1) 增加属性数据库值模式相关处理
 * 
 * @version 5.0.18.0
 * (1) 添加动态子系统相关功能
 * 
 * @version 5.0.17.38
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.37
 * (1) 增强SessionFactory等相关功能，避免用户级锁表
 * 
 * @version 5.0.17.36
 * (1) 增加上下文操作人名称
 * 
 * @version 5.0.17.35
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.34
 * (1) 修复一些BUG及功能微调
 *
 * @version 5.0.17.33
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.32
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.31
 * (1) 修复修复微信企业号数据同步
 * 
 * @version 5.0.17.30
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.29
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.28
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.27
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.26
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.25
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.24
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.23
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.22
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.21
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.20
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.19
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.18
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.17
 * (1) 增强动态子系统相关
 * 
 * @version 5.0.17.16
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.15
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.14
 * (1) 增强 net.ibizsys.paas.demodel.IDataEntityModel，支持独立定义审计记录的实体，net.ibizsys.paas.security.DEDataAccMgr实现有增强
 * 
 * @version 5.0.17.13
 * (1) 增强 net.ibizsys.paas.ctrlmodel.GridModelBase，fillRowOutputDatas方法进一步输出非编辑项数据
 * 
 * @version 5.0.17.12
 * (1) 增强 net.ibizsys.paas.ctrlhandler.GridHandlerBase，提供loaddraftpaste行为，支持将前端拷贝的数据转为为表格的行数据 
 * 
 * @version 5.0.17.11
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.10
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.9
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.8
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.7
 * (1) 增加 net.ibizsys.paas.control.menu.IMenuItemFiller 菜单项填充器对象，支持菜单项动态填充能力
 * (2) 增强 net.ibizsys.paas.security.DEDataAccMgr，支持新的权限体系模式，如实体设置为无权限控制，则会立刻返回（有权限）
 * 
 * @version 5.0.17.6
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.5
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.4
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.3
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.1
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.17.0
 * (1) 正式提供服务接口等相关功能
 * 
 * @version 5.0.16.13
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.12
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.11
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.10
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.9
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.8
 * (1) 增强 net.ibizsys.paas.service.IService，增加convertPickupData方法，用于完成前端应用选择数据的转换
 * (2) 增加 net.ibizsys.paas.controller.IPickupViewController 接口，相应对象有增强
 * (3) 增加 net.ibizsys.pswf.controller.WFDataRedirectViewControllerBase，为实体数据提供通用视图重定向功能
 * 
 * @version 5.0.16.7
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.6
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.5
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.4
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.3
 * (1) 增强 net.ibizsys.psrt.srv.wf.demodel.WFWorkListDEModel，提供计算重定向系统全部工作流视图能力
 * 
 * @version 5.0.16.2
 * (1) 增强 net.ibizsys.paas.web.Page ，提供getCurrent、isShowAction方法
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.1
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.16.0
 * (1) 子系统升级，提供数值主键支持，并进一步为实体增加业务唯一识别属性，解决数值主键缺乏业务数据唯一性特征，联合主键中的hash值将放入业务唯一识别属性，
 *     检查主键重复或获取数据能使用主键或业务唯一识别属性
 * (2) 新增 net.ibizsys.paas.core.IModelBase3，支持在发布模板中将自定义属性设置到模型中，进一步增强运行环境扩展能力
 * (3) net.ibizsys.pswf.core.IWFProcessModel 增加 getThreadSN 方法，用于标记流程主线，方便前端进一步输出业务级别的流程跟踪图例
 * 
 * @version 5.0.15.17
 * (1) 增强工作流相关，合并历史更新 
 * 
 * @version 5.0.15.16
 * (1) net.ibizsys.paas.service.SessionFactorySession 增强 setLastEntity 方法，进一步传入SessionFactory 
 *  
 * @version 5.0.15.15
 * (1) net.ibizsys.paas.report.IPrintService 增强明细数据实体及数据集合，相关代码有调整
 * 
 * @version 5.0.15.14
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.15.13
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.15.12
 * (1) net.ibizsys.paas.security.DEDataAccMgr 增强，操作标识前缀为[SRFUR__]作为统一资源能力判断
 * (2) 修复一些BUG及功能微调
 * 
 * 
 * @version 5.0.15.11
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.15.10
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.15.9
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.15.8
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.15.7
 * (1) 修复一些BUG及功能微调
 *
 * @version 5.0.15.6
 * (1) net.ibizsys.paas.control.form.IFormItem 细化忽略输入值功能，增加 IGNOREINPUT_DISABLE_AND_NOTSETOUTPUT、IGNOREINPUT_UPDATE_AND_SETORIGIN等能力
 * (2) 修复一些BUG及功能微调
 * (3) net.ibizsys.paas.sysmodel.SystemModelBase 提供 noViewMode 配置注解，支持全局启用系统运行的无数据库视图模式
 * 
 * @version 5.0.15.5
 * (1) net.ibizsys.paas.control.form.IFormItem 添加 getWriteBackDEFMode 方法，提供定义表单项回写属性的能力，相关代码有调整
 * 
 * @version 5.0.15.4
 * (1) 门户部件添加表单及搜索表单类型，相关代码及功能有调整
 * 
 * @version 5.0.15.3
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.15.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.15.1
 * (1)net.ibizsys.paas.ctrlmodel.FormModelBase 、net.ibizsys.paas.ctrlmodel.GridModelBase功能调整，在获取输入值时，如果相应项为忽略输入，会尝试使用默认值替换
 * 
 * @version 5.0.15.0
 * (1) 运行子系统实体USER、WFUSER、CODELIST、CODEITEM增加备用字段
 * 
 * @version 5.0.14.7
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.14.6
 * (1) net.ibizsys.paas.controller.MobPickupMDViewControllerBase 等移动端视图控制器基类添加
 * 
 * 
 * @version 5.0.14.5
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.14.4
 * (1) net.ibizsys.paas.service.IService<ET extends IEntity> 提供直接获取缓存数据的getCache方法
 * 
 * 
 * @version 5.0.14.3
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.14.2
 * (1) 调整系统缓存及统一状态协同相关代码
 * 
 * @version 5.0.14.1
 * (1) 调整系统缓存及统一状态协同相关代码
 * 
 * @version 5.0.14.0
 * (1) 调整系统缓存及统一状态协同相关代码
 * 
 * @version 5.0.13.4
 * (1) net.ibizsys.paas.service.ServiceWorkHelper 服务作业辅助对象增加，为非Service代码提供IServiceWork执行能力，完成无上下文用户等系统级别程序调用。
 * 
 * @version 5.0.13.3
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.13.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.13.1
 * (1) net.ibizsys.paas.service.ServiceBase 支持忽略值规则检查能力，方便后台代码调用。（通过net.ibizsys.paas.entity.EntityBase.setIgnoreCheck设置调用参数）
 *  
 * @version 5.0.13.0
 * (1) net.ibizsys.psuac.web.TicketValidationFilter 有调整，必须使用cas-client-core-3.1.12
 * 
 * @version 5.0.12.15
 * (1) net.ibizsys.paas.appmodel.AppModelBase 调整setPFType方法实现
 *  
 * @version 5.0.12.14
 * (1) net.ibizsys.paas.sysmodel.util.ScriptValueRuleModel 系统脚本值规则检查对象增加
 * (2) net.ibizsys.paas.sysmodel.util.NumberRangeValueRuleModel 系统数据范围值规则检查对象增加
 * (3) net.ibizsys.paas.sysmodel.util.RegExValueRuleModel 系统正则式值规则检查对象增加
 *  
 * @version 5.0.12.13
 * (1) net.ibizsys.paas.sysmodel.ISystemValueRuleModel 系统值规则接口对象增加，提供系统级别的自定义值规则处理能力，相关代码进行调整
 * (1) net.ibizsys.paas.sysmodel.ISystemLogicModel 系统逻辑接口对象增加，提供系统级别的自定义逻辑处理能力，相关代码进行调整
 * 
 * @version 5.0.12.12
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.12.11
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.12.10
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.12.9
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.12.8
 * (1)修复一些BUG及功能微调
 *  
 * @version 5.0.12.7
 * (1) net.ibizsys.paas.service.IServicePlugin 增加isPrepareLastForUpdate、isPrepareLastForRemove方法，支持驱动Service对象准备操作之前的数据，相应的代码有调整
 * (2) net.ibizsys.paas.service.ServiceBase 中 update、remove方法在调用插件时会将上一次的数据放入额外参数中（如果有准备的话）
 * 
 * @version 5.0.12.6
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.12.5
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.12.4
 * (1)net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel 增加上下文数据转换逻辑 getActiveDataDELogicId，相应的接口实现及处理有调整
 * (2)net.ibizsys.paas.ctrlmodel.ITreeNodeModel 增加图标路径属性
 * 
 * @version 5.0.12.3
 * (1)修复一些BUG及功能微调
 * 
 * @version 5.0.12.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.12.1
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.12.0
 * (1) 整体调整线程锁机制
 * 
 * @version 5.0.11.11
 * (1) 增强数据库适配器能力，支持数据库函数
 * (2) 增加 PQGrid 绘制器插件  net.ibizsys.paas.web.jquery.render.GridPQGridRender
 *  
 * @version 5.0.11.10
 * (1) 增加视图模型异步请求结果对象 net.ibizsys.paas.web.ViewModelAjaxActionResult  
 * (2) 调整 net.ibizsys.paas.security.DEDataAccMgr ，在判断需要键值的操作标识时不再抛出异常，调整为访问拒绝
 * 
 * 
 * @version 5.0.11.9
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.11.8
 * (1) net.ibizsys.paas.security.DEDataAccMgr 调整，方便外部代码重写
 * 
 * @version 5.0.11.7
 * (1) net.ibizsys.paas.entity.EntityBase 方法 onCopyTo 有修改，会进一步判断是否设置目标数据为完整信息(markFullEntity)
 * (2) net.ibizsys.pswf.core.WFDEModelBase 方法 testDataInWF 有修改，会判断属性是否存在，不存在会尝试获取
 * (3) net.ibizsys.paas.demodel.DataEntityModelBase 方法 getDEMainStateTag 有修改，会判断主状态相关属性是否存在，不存在会尝试获取
 * (4) net.ibizsys.paas.security.DEDataAccMgr 优化获取数据对象完整信息的方式，提升性能
 * (5) net.ibizsys.paas.ctrlmodel.GridDataItemModel 方法 getValue 有修改，优先处理 IDataRow 对象
 * (6) net.ibizsys.paas.demodel.IDataEntityModel 添加方法：hasDEMainState、getDEMainStateDenyMsg，增强实体主状态相关功能
 * 
 * @version 5.0.11.6
 * (1) 增强实体主状态对象相关，net.ibizsys.paas.core.IDEMainState
 * 
 * @version 5.0.11.5
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.11.4
 * (1) 修复一些BUG及功能微调
 *   
 * @version 5.0.11.3
 * (1) 增加通用部件项后台处理对象 net.ibizsys.paas.ctrlhandler.CommonCtrlItemHandlerBase
 * 
 * @version 5.0.11.2
 * (1) 增强应用菜单Xml配置能力
 * (2) 修复一些BUG及功能微调  
 *  
 * @version 5.0.11.1
 * (1) 增强数据库值函数相关处理
 * (2) 修复一些BUG及功能微调 
 *  
 * @version 5.0.11.0
 * (1) 运行子系统升级，ORG、WFSTEP、WFSTEPDATA、WFWORKLIST、WFWORKFLOW、WFWFVERSION、MSGQUEUE等实体增加属性或代码表
 * 
 * @version 5.0.10.20
 * (1) 增强net.ibizsys.paas.ctrlhandler.EditFormHandlerBase 关于表单项提示信息的处理
 * (2) net.ibizsys.paas.sysmodel.SystemModelBase 增加属性输入提示集合的相关处理 
 * 
 * @version 5.0.10.19
 * (1) net.ibizsys.paas.service.ServiceBase 调整方法 doServiceWork、doServiceFetchWork 对异常的处理，抛出实际错误
 * (2) 修复一些BUG及功能微调 
 *  
 * @version 5.0.10.18
 * (1) net.ibizsys.paas.service.ServiceBase 调整方法 checkFieldDupRule 对值范围属性的处理，无值不再报错，而按照ISNULL 处理 
 * 
 * @version 5.0.10.17
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.10.16
 * (1) net.ibizsys.paas.service.IService 增加 selectEx、selectTempEx方法，增强数据查询调用能力
 * 
 * 
 * @version 5.0.10.15
 * (1) 修复一些BUG及功能微调
 
 * @version 5.0.10.14
 * (1) 微信子系统增强
 *   
 * @version 5.0.10.13
 * (1) 优化net.ibizsys.paas.service.ServiceGlobal、net.ibizsys.paas.dao.DAOGlobal在SessionFactory范畴的优化
 * (2) net.ibizsys.paas.appmodel.AppModelBase 实现org.springframework.context.ApplicationListener<ContextRefreshedEvent> 接口
 * 
 * @version 5.0.10.12
 * (1) net.ibizsys.paas.service.ServiceBase 增加会话工厂引用计数执行前后不一致检查
 * 
 * @version 5.0.10.11
 * (1) 修复一些BUG及功能微调
 *  
 * @version 5.0.10.10
 * (1) 增强视图消息相关功能
 * (2) 增强消息模板处理机制
 *   
 * @version 5.0.10.9
 * (1) 增强属性输入提示集合相关
 * (2) net.ibizsys.paas.service.IService 增加方法executeLogic,方便支持执行实体逻辑
 * (3) 增强视图消息相关功能
 * (4) 修复一些BUG及功能微调
 * 
 * @version 5.0.10.8
 * (1) net.ibizsys.paas.service.ServiceBase 修复临时数据的 copyDetails 触发方式 
 * 
 * @version 5.0.10.7
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.10.6
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.10.5
 * (1) 增强视图消息相关功能
 * 
 * @version 5.0.10.4
 * (1) net.ibizsys.paas.logic.ICondition 支持位与逻辑
 * (2) 修复一些BUG及功能微调
 * 
 * @version 5.0.10.3
 * (1) 增强视图消息相关功能
 * 
 * @version 5.0.10.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.10.1
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.10.0
 * (1) 实体支持多视图模式
 * 
 * @version 5.0.9.17
 * (1) 修复一些BUG及功能微调
 * 
 * * @version 5.0.9.16
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.9.15
 * (1) 修复一些BUG及功能微调
 *  
 * @version 5.0.9.14
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.9.13
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.9.12
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.9.11
 * (1) 关系数据库及大数据库都支持批量操作功能
 * 
 * @version 5.0.9.10
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.9.9
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.9.8
 * (1) 修复一些BUG及功能微调
 *   
 * @version 5.0.9.7
 * (1) 系统数据源支持到12个
 * (2) 属性联合主键支持到8个
 * 
 * @version 5.0.9.6
 * (1) 修改net.ibizsys.paas.service.ServiceBase 的 checkKey实现，解决虚拟主键的问题
 * 
 * @version 5.0.9.5
 * (1) 运行环境提供插件支持
 * 
 * @version 5.0.9.4
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.9.3
 * (1) 修复一些BUG及功能微调
 * 
 * * @version 5.0.9.2
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.9.1
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.9.0
 * (1) 大数据架构相关功能整体升级
 * 
 * @version 5.0.8.6
 * (1) net.ibizsys.paas.service.ServiceBase 添加递归检查方法checkFieldRecursionRule
 * 
 * 
 * @version 5.0.8.5
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.8.4
 * (1) 关系部件增强多语言支持
 * 
 * @version 5.0.8.3
 * (1) 工作流引擎增强多语言支持
 * 
 * @version 5.0.8.2
 * (1) 微信功能进行增强
 *  
 * @version 5.0.8.1
 * (1) 修复一些BUG及功能微调
 * (2) 微信功能进行增强
 * 
 * @version 5.0.8.0
 * (1) 正式支持多语言
 * 
 * @version 5.0.7.5
 * (1) 修复一些BUG及功能微调
 * 
 * @version 5.0.7.4
 * (1) net.ibizsys.paas.control.drctrl.IDRCtrlItem 增加了 getIconPathX、getIconClsX方法，用于支持不同显示大小的图片及样式，相关实现对象有调整
 * 
 * @version 5.0.7.3
 * (1) 增加Freemarker方法对象，net.ibizsys.paas.util.freemarker.CodeListMethod
 * 
 * @version 5.0.7.2
 * (1) 修改工作流表单处理对象net.ibizsys.pswf.ctrlhandler.WFEditFormHandlerBase 在处理临时数据权限判断问题 
 * 
 * @version 5.0.7.1
 * (1) 表单处理对象 net.ibizsys.paas.ctrlhandler.EditFormHandlerBase 在进行复制数据新建操作时，会进行新建模式的默认值填充（原来没有） 
 * 
 * @version 5.0.7.0
 * (1) 增加微信子系统
 * 
 * @version 5.0.6.4
 * (1) 修复net.ibizsys.paas.ctrlhandler.CtrlHandlerBase中getSimpleEntity在处理临时数据中返回空的问题，如存在正式数据会返回正式数据
 * 
 * @version 5.0.6.3 
 * (1) net.ibizsys.paas.appmodel.IApplicationModel  增加方法 testUserViewAccess ，视图控制器执行用户访问判断时先调用此方法，为外部程序提供统一的判断能力.
 * 
 * @version 5.0.6.2 
 * (1) 增强树部件相关能力，模型及处理对象都有调整
 * 
 * @version 5.0.6.1 
 * (1) net.ibizsys.paas.dao.IDAO 增加新的数据查询获取方法  fetchDEDataQuery(ISelectContext iSelectContext, boolean bTempMode)
 * (2) net.ibizsys.paas.service.ServiceBase 增强 select(ISelectCond iSelectCond2) 方法，支持直接调用数据查询
 * 
 * @version 5.0.6.0
 * (1) 增强视图向导及视图消息模块
 * 
 * @version 5.0.5.7
 * (1) net.ibizsys.paas.web.util.RemoteLoginServlet 在认证完成后，进一步调用WebContext.fillByLoginAccount填充用户信息
 * 
 * @version 5.0.5.6
 * (1) net.ibizsys.paas.service.IService 增强save方法，可进一步指定是否返回数据等
 * 
 * @version 5.0.5.5
 * (1) net.ibizsys.paas.service.ServiceBase 相关临时数据行为支持逻辑附加
 * (2) net.ibizsys.paas.sysmodel.CodeListGlobal 支持插件net.ibizsys.paas.sysmodel.ICodeListGlobalPlugin
 * (3) net.ibizsys.paas.controller.ViewControllerGlobal 支持插件net.ibizsys.paas.controller.IViewControllerGlobalPlugin
 * (4) net.ibizsys.paas.ctrlhandler.CounterGlobal 支持插件net.ibizsys.paas.ctrlhandler.ICounterGlobalPlugin 
 *
 * @version 5.0.5.4
 * (1) 一些功能微调
 * 
 * @version 5.0.5.3
 * (1) 表单项输入提示后台处理支持
 * 
 * @version 5.0.5.2
 * (1) 修复WebContext一些静态变量的命名错误
 * 
 * @version 5.0.5.1
 * (1) 修复部件界面行为在临时数据下检查权限的错误
 * 
 * @version 5.0.5.0
 * (1) 支持PPAS及PostgreSQL数据库
 * 
 * @version 5.0.4.25
 * (1) 修复后台界面行为判断用户权限出现的错误
 * 
 * @version 5.0.4.24
 * (1) 实体数据集合 net.ibizsys.paas.core.IDEDataSet 继承net.ibizsys.paas.core.IDEDataRange接口，增强数据范围定义能力
 * 
 * @version 5.0.4.23
 * (1) 修复表单及表格编辑器输出的代码表配置的错误
 *  
 * @version 5.0.4.22
 * (1) net.ibizsys.paas.ctrlmodel.IGridEditItemModel及net.ibizsys.paas.ctrlmodel.IFormItemModel增强获取输出的代码表配置模式 getOutputCodeListConfigMode，相应的实现类有修改。
 *
 * @version 5.0.4.21
 * (1) 增强net.ibizsys.paas.web.Page的createWebContext方法，如存在应用，则调用应用建立
 * 
 * @version 5.0.4.20
 * (1) 增强SQLite数据库支持
 * 
 * @version 5.0.4.19
 * (1) 修复数据导出的列权限控制问题
 * 
 * @version 5.0.4.18
 * (1) 工作流取消流程置空用户数据实例值
 * (2) 修复net.ibizsys.paas.db.impl.MSSQLDialectImpl获取当前时间的问题
 * 
 * @version 5.0.4.17
 * (1) 增强视图消息功能
 * (2) 增强数据导出功能，增加了net.ibizsys.paas.demodel.DEDataExportModelBase等相关对象，net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase等对象也做了相应调整
 * 
 * @version 5.0.4.16
 * (1) 实体模型添加存储模式定义
 * (2) 增强大数据功能，net.ibizsys.paas.service.ServiceBase等对象进行增强
 * 
 * @version 5.0.4.15
 * (1) 增强 net.ibizsys.paas.ctrlhandler.IEditFormHandler，添加loaddraftandcreate及loaddraftfromandcreate行为
 * 
 * @version 5.0.4.14
 * (1) 增强 net.ibizsys.paas.sysmodel.DynamicCodeListModelBase，添加PValue及DSCondition属性。
 * 
 * @version 5.0.4.13
 * (1)修复多项数据后台处理对象删除临时数据的权限检查问题
 * 
 * @version 5.0.4.12
 * (1)进一步细化无视图模式
 * 
 * @version 5.0.4.11
 * (1)net.ibizsys.paas.demodel.IDataEntityModel添加 getDEFieldConditionSql，用于支持实体模型重写字段查询条件的功能
 * (2)实体支持无视图模式，net.ibizsys.paas.core.IDataEntity、net.ibizsys.paas.core.IDEDataQuery 及相应处理进行调整。
 * 
 * @version 5.0.4.10
 * (1) net.ibizsys.paas.service.IService 增加 syncData 方法用于处理同步传入的数据，ServiceBase提供默认实现。
 * (2) 消息发送等后台作业服务修复启动计时器方式。
 * 
 * @version 5.0.4.9
 * (1) 增强数据同步功能
 * 
 * @version 5.0.4.8
 * (1) 修复联合键值属性更新的问题（实体主键为物理类型）
 * 
 * @version 5.0.4.7
 * (1) 代码表项 net.ibizsys.paas.codelist.ICodeItem 添加 isDisableSelect 属性，用于标识该项是否被禁止选择。 
 *
 * @version 5.0.4.6
 * (1) 修复虚拟主键的检查问题
 * 
 * @version 5.0.4.5
 * (1) 增强现有数据结构支持，对于现有多主键对象提供虚拟主键支持。
 * 
 * @version 5.0.4.4
 * (1) 系统模型基类 net.ibizsys.paas.sysmodel.SystemModelBase 增强，支持多数据源注入
 * 
 * @version 5.0.4.3
 * (1) 修复列表，表格，视图等数据项获取实体模型对象问题，从部件模型中获取实体模型，而非视图控制器
 * (2) 视图控制器添加 getDEDataAccessActions 方法，用于获取对于视图中对应实体的数据访问行为（用于下发权限控制）
 * (3) 调整 net.ibizsys.paas.ctrlmodel.GridDataItemModel，调整输出权限控制结果
 * (4) 修复浮点值校验，去除格式化后的逗号。
 * 
 * @version 5.0.4.2
 * (1) 树视图部件增强删除节点能力
 * 
 * @version 5.0.4.1
 * (1) net.ibizsys.paas.service.ServiceBase  增强数据集合值规则检查
 * (2) 进一步增强行编辑后台能力，添加自动填充等后台处理对象
 * 
 * @version 5.0.4.0
 * (1) 扩展相关运行实体保留字段
 * 
 * @version 5.0.3.9
 * (1) 工作流添加选择操作视图控制器
 * (2) 修复自定义部件后台处理对象
 * 
 * @version 5.0.3.8
 * (1) 增强JasperReport报表输出
 * (2) 增加向导面板、向导视图等相关功能
 * 
 * 
 * @version 5.0.3.7
 * (1) 增加1:1关系相关对象
 * (2) 增强部件项权限控制
 * 
 * @version 5.0.3.6
 * (1) 增加自定义部件相关对象
 * 
 * @version 5.0.3.5
 * (1) net.ibizsys.paas.util.JSONObjectHelper 添加新的put方法
 * 
 * 
 * @version 5.0.3.4
 * (1) 提供对JQuery R2的默认支持
 * (2) 修复工作流表格视图多项数据批操作（有弹出窗口）问题
 * 
 * @version 5.0.3.3
 * (1) 修复统一认证组件多服务器模式路径的问题
 * 
 * @version 5.0.3.2
 * (1) 调整工作流处理节点组条件，组逻辑在无任何子逻辑的情况下值为TRUE。
 * 
 * @version 5.0.3.1
 * (1) 调整工作流处理节点组条件，组逻辑在无任何子逻辑的情况下值为TRUE。
 * 
 * @version 5.0.3.0
 * (1) 编辑表单默认添加 srfsourcekey ，用于标注新建数据的来源（如果是复制）
 * (2) IService 增加copyDetails 方法，create 方法中，如传入参数中存在属性 srfsourcekey ,则会调用此方法进一步复制源数据的明细
 * 
 * @version 5.0.2.0
 * (1) 添加实体数据变更日志等实体
 * (2) 修复工作流处理节点组条件（OR）判断异常的问题
 * (3) 增加了数据变更派发相关功能
 * 
 * 
 * @version 5.0.1.103
 * (1) 完成视图更新面板后台处理对象  net.ibizsys.paas.ctrlhandler.UpdatePanelHandler
 * (2) 添加消息模板全局管理对象 net.ibizsys.psmsg.util.MsgTemplateGlobal
 * 
 * @version 5.0.1.102
 * (1) 添加系统间数据同步、定时任务调度等相关实体
 * (2) 修复获取多项代码表文本的错误
 * (3) 添加视图更新面板相关
 * 
 * @version 5.0.1.100
 * (1) 添加了表格行编辑能力
 */
public class Version
{
	public final static Integer MAJOR = 5;
	public final static Integer MINOR = 0;
	public final static Integer FUNC = 23;
	public final static Integer FIX = 8;
	public final static Integer DATE = 200403;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return StringHelper.format("%1$s.%2$s.%3$s.%4$s",MAJOR,MINOR,FUNC,FIX);
	}
	
	/**
	 * 输出版本字符串
	 * @return
	 */
	public static String toVersionString()
	{
		return StringHelper.format("%1$s.%2$s.%3$s.%4$s",MAJOR,MINOR,FUNC,FIX);
	}
}
