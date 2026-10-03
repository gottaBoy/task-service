package net.ibizsys.paas.sysmodel;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.demodel.IDataEntityModel;

/**
 * 系统运行模型接口
 * 
 * @author lionlau
 *
 */
public interface ISystemRuntime extends ISystemModel {
	
	/**
	 * 获取数据库适配器
	 * 
	 * @return
	 */
	IDBDialect getDBDialect();

	/**
	 * 获取会话工厂
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory();

	/**
	 * 获取数据库适配器2
	 * 
	 * @return
	 */
	IDBDialect getDBDialect2();

	/**
	 * 获取会话工厂2
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory2();

	/**
	 * 获取数据库适配器3
	 * 
	 * @return
	 */
	IDBDialect getDBDialect3();

	/**
	 * 获取会话工厂3
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory3();

	/**
	 * 获取数据库适配器4
	 * 
	 * @return
	 */
	IDBDialect getDBDialect4();

	/**
	 * 获取会话工厂4
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory4();

	/**
	 * 获取数据库适配器5
	 * 
	 * @return
	 */
	IDBDialect getDBDialect5();
	
	/**
	 * 获取会话工厂5
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory5();
	
	
	/**
	 * 获取数据库适配器6
	 * 
	 * @return
	 */
	IDBDialect getDBDialect6();
	
	/**
	 * 获取会话工厂6
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory6();
	
	
	/**
	 * 获取数据库适配器7
	 * 
	 * @return
	 */
	IDBDialect getDBDialect7();
	
	/**
	 * 获取会话工厂7
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory7();
	
	
	/**
	 * 获取数据库适配器8
	 * 
	 * @return
	 */
	IDBDialect getDBDialect8();
	
	/**
	 * 获取会话工厂8
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory8();
	
	/**
	 * 获取数据库适配器9
	 * 
	 * @return
	 */
	IDBDialect getDBDialect9();
	
	/**
	 * 获取会话工厂9
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory9();
	
	
	/**
	 * 获取数据库适配器10
	 * 
	 * @return
	 */
	IDBDialect getDBDialect10();
	
	/**
	 * 获取会话工厂10
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory10();
	
	
	/**
	 * 获取数据库适配器11
	 * 
	 * @return
	 */
	IDBDialect getDBDialect11();
	
	/**
	 * 获取会话工厂11
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory11();
	
	/**
	 * 获取数据库适配器12
	 * 
	 * @return
	 */
	IDBDialect getDBDialect12();
	
	/**
	 * 获取会话工厂12
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory12();
	
	
	/**
	 * 获取指定数据源
	 * 
	 * @param strDSLink
	 * @return
	 */
	IDBDialect getDBDialect(String strDSLink);
	
	
	



	/**
	 * 获取指定会话工厂
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory(String strDSLink);

	/**
	 * 安装运行时数据
	 */
	void installRTDatas() throws Exception;

	/**
	 * 获取系统运用本地语言
	 * 
	 * @return
	 */
	String getLocalization();

	/**
	 * 建立对象
	 * 
	 * @param strObjectType
	 * @return
	 * @throws Exception
	 */
	Object createObject(String strObjectType) throws Exception;
	
	
	
	/**
	 * 获取实际的会话工厂
	 * @return
	 */
	SessionFactory getRealSessionFactory(IDataEntityModel iDataEntityModel,SessionFactory sessionFactory);
	
	
	
	/**
	 * 获取服务API客户端标识
	 * @return
	 */
	String getServiceAPIClientId();
	
	
	/**
	 * 是否使用服务接口
	 * @return
	 */
	boolean isUseServiceAPI();
	
	/**
	 * 获取指定实体是否使用服务接口
	 * @param iDataEntityModel
	 * @return
	 */
	boolean isDEUseServiceAPI(IDataEntityModel iDataEntityModel);
	
	/**
	 * 获取系统使用的服务接口客户端对象
	 * @return
	 * @throws Exception
	 */
	IServiceAPIClientModel getServiceAPIClientModel()throws Exception ;
	
	
	
	/**
	 * 获取部署系统模块标识
	 * @return
	 */
	String getModuleId();
}
