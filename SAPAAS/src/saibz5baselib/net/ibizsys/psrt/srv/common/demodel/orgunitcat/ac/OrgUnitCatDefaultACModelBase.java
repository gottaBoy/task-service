/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orgunitcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="37c7b65732fb7013db7c970d1262e849",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="ORGUNITCATID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="ORGUNITCATNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class OrgUnitCatDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public OrgUnitCatDefaultACModelBase() {
        super();

        this.initAnnotation(OrgUnitCatDefaultACModelBase.class);
    }

}