package net.ibizsys.psop.zookeeper;

/**
 * �û�����������ӿ�
 * @author Administrator
 *
 */
public  interface IPSUserKeeper extends IPSObjectKeeper
{
	/**
	 * ��¼�û�
	 * @param paramString1
	 * @param paramString2
	 */
	void loginUser(String paramString1, String paramString2) throws Exception;
 
	/**
	 * ע���û�
	 * @param paramString1
	 * @param paramString2
	 * @throws Exception
	 */
	void logoutUser(String paramString1, String paramString2) throws Exception;


	/**
	 * �����û�
	 * @param paramString1
	 * @param paramString2
	 * @return
	 * @throws Exception
	 */
	boolean activeUser(String paramString1, String paramString2) throws Exception;

}