package net.ibizsys.paas.demodel;

import java.io.File;
import java.util.ArrayList;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEDataImportResult;
import net.ibizsys.paas.core.IModelBase3;

/**
 * 实体数据导入模型对象接口
 * @author Administrator
 *
 */
public interface IDEDataImportModel extends IDEDataImport,IModelBase3 {

	/**
	 * 文件类型：Excel
	 */
	final static String FILETYPE_EXCEL = "EXCEL";	
	
	/**
	 * 文件类型：Access
	 */
	final static String FILETYPE_ACCESS = "ACCESS";	
	
	/**
	 * 导入文件
	 * @param importFile
	 * @param strFileType
	 * @param errorFile
	 * @return
	 * @throws Exception
	 */
	boolean importFile(File importFile,String strFileType,ArrayList<IDEDataImportResult> resultList)throws Exception;
	
	
	/**
	 * 导入文件
	 * @param importFile
	 * @param strFileType
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	boolean importFile(File importFile,String strFileType,SessionFactory sessionFactory,ArrayList<IDEDataImportResult> resultList)throws Exception;
	
	
	/**
	 * 获取实体模型对象
	 * @return
	 */
	IDataEntityModel getDEModel();
}
