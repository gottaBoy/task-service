package net.ibizsys.paas.logic;

/**
 * 条件项接口
 * 
 * @author lionlau
 *
 */
public interface ICondition {
	
	/**
	 * 等于操作
	 */
	public final static String CONDOP_EQ = "EQ";

	/**
	 * 绝对等于（保留）
	 */
	public final static String CONDOP_ABSEQ = "ABSEQ";

	/**
	 * 大于操作
	 */
	public final static String CONDOP_GT = "GT";

	/**
	 * 大于等于操作
	 */
	public final static String CONDOP_GTANDEQ = "GTANDEQ";

	/**
	 * 小于操作
	 */
	public final static String CONDOP_LT = "LT";

	/**
	 * 小于等于操作
	 */
	public final static String CONDOP_LTANDEQ = "LTANDEQ";

	/**
	 * 不等于操作
	 */
	public final static String CONDOP_NOTEQ = "NOTEQ";

	/**
	 * 为空判断操作
	 */
	public final static String CONDOP_ISNULL = "ISNULL";

	/**
	 * 不为空判断操作
	 */
	public final static String CONDOP_ISNOTNULL = "ISNOTNULL";

	/**
	 * 文本包含
	 */
	public final static String CONDOP_USERLIKE = "USERLIKE";

	/**
	 * 文本包含
	 */
	public final static String CONDOP_LIKE = "LIKE";

	/**
	 * 文本左包含
	 */
	public final static String CONDOP_LEFTLIKE = "LEFTLIKE";

	/**
	 * 文本右包含
	 */
	public final static String CONDOP_RIGHTLIKE = "RIGHTLIKE";

	/**
	 * 空判断
	 */
	public final static String CONDOP_TESTNULL = "TESTNULL";

	/**
	 * 值包含在给定的范围中
	 */
	public final static String CONDOP_IN = "IN";

	/**
	 * 值不包含在给定的范围中
	 */
	public final static String CONDOP_NOTIN = "NOTIN";

	
	
	/**
	 * 指定数据的子数据
	 */
	public final static String CONDOP_CHILDOF = "CHILDOF";

	/**
	 * 指定数据的父数据
	 */
	public final static String CONDOP_PARENTOF = "PARENTOF";

	/**
	 * 组逻辑操作，或处理
	 */
	public final static String CONDOP_OR = "OR";

	/**
	 * 组逻辑操作，与处理
	 */
	public final static String CONDOP_AND = "AND";
	
	
	/**
	 * 组逻辑操作，位与处理
	 */
	public final static String CONDOP_BITAND = "BITAND";
	
	

	/**
	 * 组逻辑操作，或处理
	 */
	public final static String GROUPOP_OR = CONDOP_OR;

	/**
	 * 组逻辑操作，与处理
	 */
	public final static String GROUPOP_AND = CONDOP_AND;
	

	/**
	 * 获取条件操作
	 * 
	 * @return
	 */
	String getCondOp();

	/**
	 * 获取条件类型
	 * 
	 * @return
	 */
	String getCondType();
}
