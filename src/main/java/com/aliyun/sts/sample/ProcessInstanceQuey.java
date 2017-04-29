package com.aliyun.sts.sample;

import org.activiti.engine.runtime.ProcessInstance;
import java.util.List;

/**
 * Created by liujianhui on 17/2/13.
 */
public class ProcessInstanceQuey extends ProcessEngineTest {

    public static void main(String[] args) {

    }

    public void runtimeDataQuery() {
        List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey("onboarding").list();
        for (ProcessInstance loopProcessInstance : processInstanceList) {

        }
    }

}
