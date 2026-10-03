/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfassistwork.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="3C379E87-7996-444C-9BA4-A9D437A58F01",name="CurUserAssistWork",queries= {
    @DEDataSetQuery(queryid="8664F623-FF9B-42A5-8E56-EEFE09023E56",queryname="CurUserAssistWork")
})

/**
 *  实体数据集合[当前用户代办工作]模型基类
 */
public abstract class WFAssistWorkCurUserAssistWorkDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFAssistWorkCurUserAssistWorkDSModelBase() {
        super();

        this.initAnnotation(WFAssistWorkCurUserAssistWorkDSModelBase.class);
    }




}