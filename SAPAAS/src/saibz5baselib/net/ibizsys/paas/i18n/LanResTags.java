package net.ibizsys.paas.i18n;

/**
 * 语言资源标识集合
 * @author Administrator
 *
 */
public class LanResTags {
	
	
	/**
	 * 标准数据类型，整形
	 */
	public final static String  COMMON_DATATYPE_INTEGER= "COMMON.DATATYPE.INTEGER";
	
	
	/**
	 * 标准数据类型，数值
	 */
	public final static String  COMMON_DATATYPE_DECIMAL = "COMMON.DATATYPE.DECIMAL";
	
	
	/**
	 * 标准数据类型，时间
	 */
	public final static String  COMMON_DATATYPE_TIME = "COMMON.DATATYPE.TIME";
	
	/**
	 * 标准数据类型，日期
	 */
	public final static String  COMMON_DATATYPE_DATE = "COMMON.DATATYPE.DATE";
	
	
	/**
	 * 标准数据类型，日期时间
	 */
	public final static String  COMMON_DATATYPE_DATETIME = "COMMON.DATATYPE.DATETIME";
	
	/**
	 * 标准数据类型，字符型
	 */
	public final static String  COMMON_DATATYPE_CHAR = "COMMON.DATATYPE.CHAR";
	
	
	/**
	 * 标准数据类型，数据流型
	 */
	public final static String  COMMON_DATATYPE_BINARY = "COMMON.DATATYPE.BINARY";
	
	
	/**
	 * 标准数据类型，未知
	 */
	public final static String  COMMON_DATATYPE_UNKNOWN = "COMMON.DATATYPE.UNKNOWN";
	
	
	
	
	/**
	 * 表单基本错误，表单项不允许为空，带1个参数:表单项名称
	 */
	public final static String  ERROR_STD_FORM_NOTALLOWEMPTY= "ERROR.STD.FORM.NOTALLOWEMPTY";
	
	
	/**
	 * 表单基本错误，表单项值错误,带1个参数:表单项名称
	 */
	public final static String  ERROR_STD_FORM_INVALIDVALUE= "ERROR.STD.FORM.INVALIDVALUE";
	
	/**
	 * 表单基本错误，表单项值错误,带2个参数:表单项名称，规则信息
	 */
	public final static String  ERROR_STD_FORM_INVALIDVALUE2= "ERROR.STD.FORM.INVALIDVALUE2";
	
	
	/**
	 * 表单基本错误，表单项值数据类型错误 ，带2个参数：表单项名称，数据类型
	 */
	public final static String  ERROR_STD_FORM_INVALIDDATATYPE= "ERROR.STD.FORM.INVALIDDATATYPE";
	
	
	/**
	 * 表单基本错误，表单项值输入长度限制，带2个参数：表单项名称，输入长度
	 */
	public final static String  ERROR_STD_FORM_MAXLENGTHEXCEED= "ERROR.STD.FORM.MAXLENGTHEXCEED";
	
	
	/**
	 * 数据库基本错误，字段不能为空值
	 */
	public final static String  ERROR_STD_DB_NOTALLOWEMPTY= "ERROR.STD.DB.NOTALLOWEMPTY";
	
	
	/**
	 * 数据库基本错误，字段出现重复值（全局出现重复值）
	 */
	public final static String  ERROR_STD_DB_DUPLICATEDATA= "ERROR.STD.DB.DUPLICATEDATA";
	
	
	/**
	 * 数据库基本错误，字段出现重复值（在某个范围中）
	 */
	public final static String  ERROR_STD_DB_DUPLICATEDATA2= "ERROR.STD.DB.DUPLICATEDATA2";
	
	
	/**
	 * 数据库基本错误，无效的数据
	 */
	public final static String  ERROR_STD_DB_INVALIDDATA= "ERROR.STD.DB.INVALIDDATA";
	
	
	/**
	 * 3.0 框架基本错误，无法获取指定实体辅助对象
	 */
	public final static String ERROR_STD_SRFDA_CANNOTFINDDEHELPER = "ERROR.STD.SRFDA.CANNOTFINDDEHELPER";
	
	
	/**
	 * 3.0 框架基本错误，无法获取指定实体数据操作对象
	 */
	public final static String ERROR_STD_SRFDA_CANNOTFINDDEDATACTRL = "ERROR.STD.SRFDA.CANNOTFINDDEDATACTRL";
	
	
	/**
	 * 3.0 框架基本错误，无法获取索引实体的索引属性
	 */
	public final static String ERROR_STD_SRFDA_CANNOTFINDINDEXDEF = "ERROR.STD.SRFDA.CANNOTFINDINDEXDEF";
	
	
	/**
	 * 表单处理逻辑信息，新建未保存数据
	 */
	public final static String  CTRL_FORMAH_UNSAVENEWDATA = "CTRL.FORMAH.UNSAVENEWDATA";
	
	/**
	 * 表单处理逻辑信息，数据保存成功
	 */
	public final static String  CTRL_FORMAH_DATASAVEDSUCCESSFULLY = "CTRL.FORMAH.DATASAVEDSUCCESSFULLY";
	
	/**
	 * 表单处理逻辑信息，数据保存失败，带一个参数，可放入失败原因
	 */
	public final static String  CTRL_FORMAH_DATASAVEFAILED = "CTRL.FORMAH.DATASAVEFAILED";
	
	
	/**
	 * 表单处理逻辑信息，表单没有传递键值
	 */
	public final static String  CTRL_FORMAH_NOTSPECIFYKEY = "CTRL.FORMAH.NOTSPECIFYKEY";
	
	
	/**
	 * 表单处理逻辑信息，表单值输入错误
	 */
	public final static String  CTRL_FORMAH_INPUTERROR = "CTRL.FORMAH.INPUTERROR";
	
	
	/**
	 * 表单处理逻辑信息，表单值输入错误，支持附加一个错误参数
	 */
	public final static String  CTRL_FORMAH_INPUTERROR2 = "CTRL.FORMAH.INPUTERROR2";
	
	
	
	/**
	 * 表单处理逻辑信息，数据主键错误
	 */
	public final static String  CTRL_FORMAH_DATAKEYERROR = "CTRL.FORMAH.DATAKEYERROR";
	
	/**
	 * 表单处理逻辑信息，数据已经被删除
	 */
	public final static String  CTRL_FORMAH_DATAALREADYREMOVED = "CTRL.FORMAH.DATAALREADYREMOVED";
	
	
	
	/**
	 * 标准错误[SYS.ACCESSDENY]
	 */
	public final static String  ERROR_STD_SYS_ACCESSDENY = "ERROR.STD.SYS.ACCESSDENY";
	
	/**
	 * 标准错误[SYS.DATANOTMATCH]
	 */
	public final static String  ERROR_STD_SYS_DATANOTMATCH = "ERROR.STD.SYS.DATANOTMATCH";
	
	/**
	 * 标准错误[SYS.USERCONFIRM]
	 */
	public final static String  ERROR_STD_SYS_USERCONFIRM = "ERROR.STD.SYS.USERCONFIRM";
	
	
	/**
	 * 标准错误[SYS.DELETEREJECT]
	 */
	public final static String 	ERROR_STD_SYS_DELETEREJECT = "ERROR.STD.SYS.DELETEREJECT";
	
		
	/**
	 * 标准错误[SYS.DUPLICATEDATA]
	 */
	public final static String 	ERROR_STD_SYS_DUPLICATEDATA = "ERROR.STD.SYS.DUPLICATEDATA";
				
	
	/**
	 * 标准错误[SYS.DUPLICATEKEY]
	 */
	public final static String 	ERROR_STD_SYS_DUPLICATEKEY = "ERROR.STD.SYS.DUPLICATEKEY";
				
				
	/**
	 * 标准错误[SYS.INPUTERROR]
	 */
	public final static String 	ERROR_STD_SYS_INPUTERROR = "ERROR.STD.SYS.INPUTERROR";
		
	/**
	 * 标准错误[SYS.INTERNALERROR]
	 */
	public final static String 	ERROR_STD_SYS_INTERNALERROR = "ERROR.STD.SYS.INTERNALERROR";
			
				
	/**
	 * 标准错误[SYS.INVALIDDATA]
	 */
	public final static String 	ERROR_STD_SYS_INVALIDDATA = "ERROR.STD.SYS.INVALIDDATA";
	
	/**
	 * 标准错误[SYS.INVALIDDATAKEYS]
	 */
	public final static String 	ERROR_STD_SYS_INVALIDDATAKEYS = "ERROR.STD.SYS.INVALIDDATAKEYS";
				
				
	/**
	 * 标准错误[SYS.LOGICERROR]
	 */
	public final static String 	ERROR_STD_SYS_LOGICERROR = "ERROR.STD.SYS.LOGICERROR";
				
				
	/**
	 * 标准错误[SYS.NOTIMPL]
	 */
	public final static String 	ERROR_STD_SYS_NOTIMPL = "ERROR.STD.SYS.NOTIMPL";
				
	
	/**
	 * 标准错误[SYS.UNKNOWNERROR]
	 */
	public final static String 	ERROR_STD_SYS_UNKNOWNERROR = "ERROR.STD.SYS.UNKNOWNERROR";
	
	
	
	/**
	 * 标准错误[SYS.UNKNOWNUSERERROR]
	 */
	public final static String 	ERROR_STD_SYS_UNKNOWNUSERERROR = "ERROR.STD.SYS.UNKNOWNUSERERROR";
	
}
