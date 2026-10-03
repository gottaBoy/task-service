package net.ibizsys.paas.security;

/**
 * 权限能力
 * 
 * @author Administrator
 *
 */
public class PrivilegeAbilities {

	/**
	 * 无任何能力
	 */
	public final static int NONE = 0;

	/**
	 * 读数据的能力
	 */
	public final static int READ = 1;

	/**
	 * 更新数据的能力(包括读数据能力)
	 */
	public final static int UPDATE = 2 | READ;

	/**
	 * 建立数据的能力(包括读数据能力)
	 */
	public final static int CREATE = 4 | READ;

	/**
	 * 删除数据的能力(包括读数据能力)
	 */
	public final static int REMOVE = 8 | READ;

	/**
	 * 审批数据的能力(包括读及更新数据能力)
	 */
	public final static int APPROVE = 16 | READ | UPDATE;

	/**
	 * 列行为，读取
	 */
	public final static String COLUMNACTION_READ = "READ";
}
