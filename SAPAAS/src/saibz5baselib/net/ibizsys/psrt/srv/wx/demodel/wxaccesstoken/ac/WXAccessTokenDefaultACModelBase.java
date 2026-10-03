/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxaccesstoken.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="7c0817a9156329b7eed4a878988f31cc",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WXACCESSTOKENID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WXACCESSTOKENNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WXAccessTokenDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WXAccessTokenDefaultACModelBase() {
        super();

        this.initAnnotation(WXAccessTokenDefaultACModelBase.class);
    }

}