/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.file.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="1c1b5758a629c73a4e148d5328a921fd",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="160D07ED-4D8E-4292-A60C-63F66CCFAE27",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class FileDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public FileDefaultDSModelBase() {
        super();

        this.initAnnotation(FileDefaultDSModelBase.class);
    }




}