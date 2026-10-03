/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orgsecusertype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="576dd33b28a3ee34ba68561c68aa93b3",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="ORGSECUSERTYPEID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="ORGSECUSERTYPENAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class OrgSecUserTypeDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public OrgSecUserTypeDefaultACModelBase() {
        super();

        this.initAnnotation(OrgSecUserTypeDefaultACModelBase.class);
    }

}