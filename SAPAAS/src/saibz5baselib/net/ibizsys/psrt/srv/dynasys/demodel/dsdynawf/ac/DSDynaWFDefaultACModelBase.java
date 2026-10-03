/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynawf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="94ed000542e335afa0722bc1cbfdf279",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DSDYNAWFID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DSDYNAWFNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DSDynaWFDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DSDynaWFDefaultACModelBase() {
        super();

        this.initAnnotation(DSDynaWFDefaultACModelBase.class);
    }

}