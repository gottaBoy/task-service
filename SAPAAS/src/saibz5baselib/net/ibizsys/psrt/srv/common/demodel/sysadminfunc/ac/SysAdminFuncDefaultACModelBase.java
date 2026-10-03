/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.sysadminfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="2e71859d8147cd788d815a3371f9ebd6",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="SYSADMINFUNCID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="SYSADMINFUNCNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class SysAdminFuncDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public SysAdminFuncDefaultACModelBase() {
        super();

        this.initAnnotation(SysAdminFuncDefaultACModelBase.class);
    }

}