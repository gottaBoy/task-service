/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynaview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="87d8599997ce9323cd2bba43278b4135",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DSDYNAVIEWID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DSDYNAVIEWNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DSDynaViewDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DSDynaViewDefaultACModelBase() {
        super();

        this.initAnnotation(DSDynaViewDefaultACModelBase.class);
    }

}