/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;



import net.ibizsys.paas.service.ServiceGlobal;

/**
 * 实体[WXAccessToken] 服务对象
 */
@Component
public class WXAccessTokenService extends WXAccessTokenServiceBase {

    private static final Log log = LogFactory.getLog(WXAccessTokenService.class);
    public WXAccessTokenService () {
        super();

    }

}