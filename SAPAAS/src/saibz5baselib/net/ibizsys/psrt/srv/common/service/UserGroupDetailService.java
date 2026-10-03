/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.service;


import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.UserGroupDetail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * 实体[UserGroupDetail] 服务对象
 */
@Component
public class UserGroupDetailService extends UserGroupDetailServiceBase {

    private static final Log log = LogFactory.getLog(UserGroupDetailService.class);
    public UserGroupDetailService () {
        super();

    }
    
    @Override
    protected void onBeforeCreate(UserGroupDetail et) throws Exception {
    	if(!StringHelper.isNullOrEmpty(et.getUserObjectName())){
    		et.setUserGroupDetailName(et.getUserObjectName());
    	}
    	super.onBeforeCreate(et);
    }

}