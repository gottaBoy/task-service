/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtask.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="f8d12641ce30b874fa6c58f749b0bb73",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="ED7E4322-9554-499E-B32B-0F13A8EB8507",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class TSSDTaskDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public TSSDTaskDefaultDSModelBase() {
        super();

        this.initAnnotation(TSSDTaskDefaultDSModelBase.class);
    }




}