/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orguserlevel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="e6c870c62a861cfd5593212fa41d6f88",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="ORGUSERLEVELID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="ORGUSERLEVELNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class OrgUserLevelDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public OrgUserLevelDefaultACModelBase() {
        super();

        this.initAnnotation(OrgUserLevelDefaultACModelBase.class);
    }

}