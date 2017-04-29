package com.aliyun.sts.sample;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * Created by liujianhui on 17/2/13.
 */
public class ProcessEngineTest {

    protected ProcessEngine processEngine;

    protected RepositoryService repositoryService;

    protected RuntimeService runtimeService;

    public ProcessEngineTest() {
         ProcessEngineConfiguration processEngineConfiguration = org.activiti.engine.ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();

        String mysqlJdbcUrl = "jdbc:mysql://10.0.52.24:3306/activiti?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8";
        String mysqlUsername = "admin";
        String mysqlPasswd = "admin";

        // 链接数据的配置
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration
                .setJdbcUrl(mysqlJdbcUrl);
        processEngineConfiguration.setJdbcUsername(mysqlUsername);
        processEngineConfiguration.setJdbcPassword(mysqlPasswd);




    /*
     * public static final String DB_SCHEMA_UPDATE_FALSE = "false";
     * 不能自动创建表，需要表存在 public static final String DB_SCHEMA_UPDATE_CREATE_DROP
     * = "create-drop"; 先删除表再创建表 public static final String
     * DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
     */
        //如果表不存在，自动创建表
        processEngineConfiguration
                .setDatabaseSchemaUpdate(processEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 工作流的核心对象，ProcessEnginee对象
         processEngine = processEngineConfiguration.setProcessEngineName("liujianhui")
                .buildProcessEngine();
         repositoryService = processEngine.getRepositoryService();
        runtimeService = processEngine.getRuntimeService();
    }

    public void queryProcessDefination() {

        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionName().asc().list();
        for (ProcessDefinition loopProcessDefination : processDefinitionList) {
            System.out.println(loopProcessDefination.getKey() + "," + loopProcessDefination.getVersion());
        }
        System.out.println(processDefinitionList);
    }

    public static void main(String[] args) {
        ProcessEngineTest processEngineTest = new ProcessEngineTest();
        processEngineTest.queryProcessDefination();
        System.out.println(processEngineTest.repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("onboarding").list());
    }
}
