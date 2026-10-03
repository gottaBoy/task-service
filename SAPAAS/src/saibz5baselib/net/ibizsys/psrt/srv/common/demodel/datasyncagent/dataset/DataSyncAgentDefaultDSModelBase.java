/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncagent.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="eca73ee23612ec7a94bc4d8f40f3c5dc",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="DD1326DD-0A81-4D3C-BB7C-E3F1CEDC95FE",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class DataSyncAgentDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public DataSyncAgentDefaultDSModelBase() {
        super();

        this.initAnnotation(DataSyncAgentDefaultDSModelBase.class);
    }




}