/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstep.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="aa16d05a90245cec51dc8a2fb7f63fdb",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="AA5AE176-2F5B-4651-A48F-4AC799C44D82",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFStepDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFStepDefaultDSModelBase() {
        super();

        this.initAnnotation(WFStepDefaultDSModelBase.class);
    }




}