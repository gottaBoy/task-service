/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userdictcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="c41d9a5508a558b5ccc8a091c5e249b1",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="USERDICTCATID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="USERDICTCATNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class UserDictCatDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public UserDictCatDefaultACModelBase() {
        super();

        this.initAnnotation(UserDictCatDefaultACModelBase.class);
    }

}