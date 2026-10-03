/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.dedatachgdisp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="54b64fbcfb4f415664d56327f7a2c210",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DEDATACHGDISPID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DEDATACHGDISPNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DEDataChgDispDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DEDataChgDispDefaultACModelBase() {
        super();

        this.initAnnotation(DEDataChgDispDefaultACModelBase.class);
    }

}