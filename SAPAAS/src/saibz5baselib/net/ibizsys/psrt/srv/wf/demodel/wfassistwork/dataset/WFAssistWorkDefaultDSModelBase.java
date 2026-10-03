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

@DEDataSet(id="80bc47afe28e23ebfb7aea12fdbc1acd",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="5C697418-9E5C-478F-9D8C-22168E18A358",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFAssistWorkDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFAssistWorkDefaultDSModelBase() {
        super();

        this.initAnnotation(WFAssistWorkDefaultDSModelBase.class);
    }




}