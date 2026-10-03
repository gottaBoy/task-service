package net.ibizsys.psrt.srv.common.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

//@Service
//@Transactional
@Component
/**
 * 用户词条类别 服务操作对象
 * 
 */
public class UserDictCatService extends UserDictCatServiceBase
{

	private static String USERDICTCAT = "USERDICTCAT";

	private static String USERDICTCAT_USER = "USER";

	private static final Log log = LogFactory.getLog(UserDictCatService.class);

	public UserDictCatService()
	{
		super();

	}

	/**
	 * 用户用户词条分类代码表标示
	 * @param strUserDictCatId
	 * @return
	 */
	public static String calcUserDictCatCodeListId(String strUserDictCatId)
	{
		// 获取代码表标示
		String strId = net.ibizsys.paas.util.KeyValueHelper.genUniqueId(USERDICTCAT, USERDICTCAT_USER, strUserDictCatId);
		return strId;

	}
}