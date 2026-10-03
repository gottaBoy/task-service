/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfreminder.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="352ff0280b4d127a400f4262d6ebfded",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="548A4C67-01EF-472F-B095-FB46063B074D",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFReminderDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFReminderDefaultDSModelBase() {
        super();

        this.initAnnotation(WFReminderDefaultDSModelBase.class);
    }




}