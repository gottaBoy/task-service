/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfuser.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="ef2c7b349c855e594aa4fe0cb7ad8b48",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="A8AEA90E-7DDF-4AA6-BB89-D1C0BE931E79",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFUserDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFUserDefaultDSModelBase() {
        super();

        this.initAnnotation(WFUserDefaultDSModelBase.class);
    }




}