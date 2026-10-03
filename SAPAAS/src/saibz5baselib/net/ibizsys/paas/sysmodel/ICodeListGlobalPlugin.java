package net.ibizsys.paas.sysmodel;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.codelist.ICodeList;

/**
 * 代码表全局对象存储插件
 * @author Administrator
 *
 */
public interface ICodeListGlobalPlugin {
	
	/**
	 * 注册代码表
	 * 
	 * @param strCodeListClsType
	 * @param iCodeList
	 */
	void registerCodeList(String strCodeListClsType, ICodeListModel iCodeList);

	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @return
	 * @throws Exception
	 */
	ICodeList getCodeList(Class cls) throws Exception;
	
	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @return
	 * @throws Exception
	 */
	ICodeList getCodeList(String strCodeListClsType) throws Exception ;

	/**
	 * 获取代码表对象
	 * 
	 * @param cls
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	ICodeList getCodeList(Class cls, SessionFactory sessionFactory) throws Exception;

	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	ICodeList getCodeList(String strCodeListClsType, SessionFactory sessionFactory) throws Exception ;

	

	/**
	 * 获取系统全部码表对象
	 * 
	 * @return
	 */
	 java.util.Iterator<ICodeList> getAllCodelists() ;
	 
	 
	 
	 /**
		 * 获取代码表对象
		 * 
		 * @param strCodeListClsType
		 * @param bTryMode  尝试模式
		 * @return
		 * @throws Exception
		 */
		ICodeList getCodeList(Class cls,boolean bTryMode) throws Exception;
		
		/**
		 * 获取代码表对象
		 * 
		 * @param strCodeListClsType
		 * @param bTryMode  尝试模式
		 * @return
		 * @throws Exception
		 */
		ICodeList getCodeList(String strCodeListClsType,boolean bTryMode) throws Exception ;

		/**
		 * 获取代码表对象
		 * 
		 * @param cls
		 * @param sessionFactory
		 * @param bTryMode  尝试模式
		 * @return
		 * @throws Exception
		 */
		ICodeList getCodeList(Class cls, SessionFactory sessionFactory,boolean bTryMode) throws Exception;

		/**
		 * 获取代码表对象
		 * 
		 * @param strCodeListClsType
		 * @param sessionFactory
		 * @param bTryMode  尝试模式
		 * @return
		 * @throws Exception
		 */
		ICodeList getCodeList(String strCodeListClsType, SessionFactory sessionFactory,boolean bTryMode) throws Exception ;
}
