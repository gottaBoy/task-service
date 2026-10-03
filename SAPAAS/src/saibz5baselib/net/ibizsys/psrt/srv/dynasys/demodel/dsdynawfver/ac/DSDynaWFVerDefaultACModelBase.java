/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynawfver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="da1ebfa0f1777e651b33c7e1df73c4ec",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DSDYNAWFVERID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DSDYNAWFVERNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DSDynaWFVerDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DSDynaWFVerDefaultACModelBase() {
        super();

        this.initAnnotation(DSDynaWFVerDefaultACModelBase.class);
    }

}