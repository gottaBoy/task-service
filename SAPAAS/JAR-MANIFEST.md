 # SAPAAS 代码生成引擎 JAR 清单

 task7 镜像 Tomcat webapp `SAPAAS` 的 `WEB-INF/lib` 共 212 个 JAR，其中 59 个自研、153 个第三方。

 ## 自研 JAR（59 个，已全部反编译）

 按 SRF 框架分层组织：

 ### saibz5* — iBiz5 模型与基础设施（16 个）

 | JAR | 大小 | Java 文件 | 说明 |
 |---|---|---|---|
| saibz5studiolib.jar | 43MB | 16,167 | 建模工作室引擎核心 (21,947 类) |
 | saibz5baselib.jar | 9.8MB | 3,125 | 基础库 (XML转换、工具) |
 | saibz5modelbase.jar | 5.3MB | 1,400 | 模型基础 (PSModelService) |
 | saibz5modelprolib.jar | 1.7MB | 913 | 模型 Pro (ZooKeeper 等) |
 | saibz5modelpublib.jar | 1.0MB | 477 | 模型 Pub (Vue3 AppPFHelper) |
 | saibz5dynaprolib.jar | 453K | 264 | 动态工作流 Pro |
 | saibz5modellib.jar | 444K | 413 | 模型库 (WF UIAction) |
 | saibz5wflib.jar | 407K | 141 | 工作流库 |
 | saibz5dblib.jar | 316K | 67 | DB 库 (SQLite 函数) |
 | saibz5dynamiclib.jar | 310K | 145 | 动态工作流 |
 | saibz5jquerylib.jar | 120K | 49 | jQuery/ECharts 库 |
 | saibz5wxlib.jar | 96K | 24 | 微信库 (WXMenu) |
 | saibz5studiopluginlib.jar | 40K | 9 | Studio 插件 (WFDE ServicePlugin) |
 | saibz5paaslib.jar | 45K | 15 | PaaS 库 (ZooKeeper) |
 | saibz5uaclib.jar | 36K | 10 | UAC 用户访问控制 (TicketValidation) |
 | saibz5portallib.jar | 25K | 8 | Portal 库 (HeadFuncServlet) |

 ### sasrfda* — SRF 数据访问层（37 个）

 SRF = SA Runtime Framework。SRFDA = SRF Data Access，按功能拆分：

 | JAR | 大小 | Java 文件 | 说明 |
 |---|---|---|---|
 | sasrfdapsbase.jar | 12MB | 5,424 | PS 基础（最大的非 studio JAR） |
 | sasrfex_2_1.jar | 1.4MB | 713 | SRF Ex 前端框架 2.1 |
 | sasrfda.jar | 1.3MB | 684 | SRFDA 核心 |
 | sasrfdaweb.jar | 1.2MB | 426 | Web 层 (TreePanelModel) |
 | sasrfdapsjquery.jar | 929K | 562 | PS jQuery 视图 |
 | sasrf.jar | 548K | 364 | SRF 核心框架 (Zip/XML) |
 | sasrfdabi.jar | 349K | 189 | BI 报表 (BIReportExViewModel) |
 | sasrfdawf.jar | 339K | 99 | 工作流 Web |
 | sasrfdand.jar | 169K | 106 | ND (NDMainViewModel) |
 | sasrfdaeai.jar | 227K | 136 | EAI 集成 (EAIDesignerConfig) |
 | sasrfdarep.jar | 201K | 58 | 报表 (ReportFrameViewModel) |
 | satm.jar | 295K | 193 | TM 工具管理 (TMToolViewModel) |
 | saim.jar | 280K | 127 | IM 即时通讯 (IMUserSessionHelper) |
 | sawf.jar | 170K | 83 | WF 工作流 |
 | sasrfdamsg.jar | 112K | 37 | MSG 消息 (MessageViewModel) |
 | sasrfdapsmysql5.jar | 115K | 40 | PS MySQL5 |
 | sasrfdaext.jar | 104K | 43 | 扩展 (FormPublishCodeHandler) |
 | sasrfdauac.jar | 104K | 62 | UAC 用户访问 |
 | sawt.jar | 97K | 51 | WT Web 工具 (WTServlet) |
 | sasrfdamp.jar | 87K | 41 | Mobile (MobileAppConfigPage) |
 | sasrfdapsresmgr.jar | 84K | 24 | 资源管理 (PSSSHAPIBase) |
 | sasrfdaws.jar | 83K | 59 | WS WebService (WSListViewPage) |
 | sasrfdapsextjs5.jar | 77K | 53 | PS ExtJS5 |
 | sasrfdais.jar | 70K | 31 | IS 搜索 (SearchResultViewModel) |
 | sasrfdamssql.jar | 68K | 27 | MSSQL 数据库适配 |
 | sasrfdaora.jar | 68K | 24 | Oracle 数据库适配 |
 | sasrfdamysql.jar | 67K | 29 | MySQL 数据库适配 |
 | sasrfdapsfr7.jar | 64K | 46 | PS FR7 (FR7ViewController) |
 | sasrfdacal.jar | 62K | 26 | 日历 (CalendarViewModel) |
 | sasrfdabr.jar | 52K | 27 | BR 业务规则 (SRFBRService) |
 | sasrfdats.jar | 50K | 25 | TS 数据 (DATSDataCtrlEx) |
 | sasrfdakpi.jar | 39K | 19 | KPI 指标 (SRFKPIService) |
 | sasrfdabi2.jar | 41K | 8 | BI 2 |
 | salicserverlib.jar | 18K | 7 | 许可证服务 (UploadSRFLicPage) |
 | sasrfdapsoracle.jar | 16K | 5 | PS Oracle |
 | sasrfdapsdb2.jar | 13K | 4 | PS DB2 |
 | sasrfdampbase.jar | 8.4K | 5 | Mobile 基础 |
 | sasrfda2.jar | 3.8K | 3 | SRFDA 2 |
 | sasrfexweb.jar | 4.1K | 1 | SRF Ex Web |
 | sasrfeai.jar | 341B | 0 | 空 JAR（仅 MANIFEST） |
 | saim7.jar | 6.1K | 3 | IM7 |

 ### 其他（2 个）

 | JAR | 大小 | Java 文件 | 说明 |
 |---|---|---|---|
 | saibz5studiolib.jar | 43MB | 14,397+ | （见上方 saibz5* 表） |
 | sasrfdapsibiz5.jar | 416K | 304 | PS iBiz5 (PSIBiz5WebAppLog4JPublisher) |

 ## 第三方 JAR（153 个，未反编译）

 开源依赖，可从 Maven Central 获取。主要类别：

 - Web: freemarker, groovy-all-1.5.5, jackson-*, jersey-*, httpclient-*
 - ORM: hibernate-core/ehcache/entitymanager 4.3.8, c3p0, jandex
 - 工具: commons-* (beanutils, lang, io, collections, compress, math3, net, pool), guava, guice
 - 分布式: curator-client/framework/recipes 2.7.1 (ZooKeeper), avro
 - 安全: apacheds-kerberos, bcprov-jdk16
 - 报表: jasperreports-3.5.3, flexmark-* (Markdown)
 - 其他: ehcache, dom4j, gson, javassist, jaxb-*

 ## 反编译统计

 | 类别 | JAR 数 | Java 文件数 |
 |---|---|---|
| saibz5* (iBiz5) | 16 | 7,364 + studiolib(16,167) = 23,531 |
| sasrfda* (SRF) | 42 | 9,937 |
| sasrfdapsibiz5 | 1 | 304 |
| **合计自研** | **59** | **33,468** |
 | 第三方 | 153 | 未反编译 |
 | WEB-INF/classes | — | 3 (WebDBCallerHelper, WebContext, HttpModule) |

 studiolib (21,947 类) 已用 8GB 堆全部反编译完成，16,167 个 .java 文件。
