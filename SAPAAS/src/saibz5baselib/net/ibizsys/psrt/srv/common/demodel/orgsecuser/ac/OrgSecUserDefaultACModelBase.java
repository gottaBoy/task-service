/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orgsecuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="a29184750c477cf3910fc2179179dccc",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="ORGSECUSERID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="ORGSECUSERNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class OrgSecUserDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public OrgSecUserDefaultACModelBase() {
        super();

        this.initAnnotation(OrgSecUserDefaultACModelBase.class);
    }

}