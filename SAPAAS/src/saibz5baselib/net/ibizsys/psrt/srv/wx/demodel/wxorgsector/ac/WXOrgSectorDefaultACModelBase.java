/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxorgsector.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="2b5ee3ad72f76d2cb7d12f8c5f31b817",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WXORGSECTORID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WXORGSECTORNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WXOrgSectorDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WXOrgSectorDefaultACModelBase() {
        super();

        this.initAnnotation(WXOrgSectorDefaultACModelBase.class);
    }

}