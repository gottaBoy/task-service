/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.service;


import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.UserRoleDEFields;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * 实体[UserRoleDEFields] 服务对象
 */
@Component
public class UserRoleDEFieldsService extends UserRoleDEFieldsServiceBase {

    private static final Log log = LogFactory.getLog(UserRoleDEFieldsService.class);
    public UserRoleDEFieldsService () {
        super();

    }
    
    @Override
    protected void onBeforeCreate(UserRoleDEFields et) throws Exception {
    	if(StringHelper.isNullOrEmpty(et.getUserRoleDEFieldsName()) && et.getUserRoleDEField() != null){
    		et.setUserRoleDEFieldsName(et.getUserRoleDEField().getUserRoleDEFieldName());
    	}
    	super.onBeforeCreate(et);
    }


}