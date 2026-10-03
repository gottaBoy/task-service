/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.loginaccount.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="5ae7d9610693e638cd1064cf7c9126f8",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="LOGINACCOUNTID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="LOGINACCOUNTNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class LoginAccountDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public LoginAccountDefaultACModelBase() {
        super();

        this.initAnnotation(LoginAccountDefaultACModelBase.class);
    }

}