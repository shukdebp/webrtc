package com.pwc.r2p2.ui.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.history.HistoricTaskInstanceQuery;
import org.camunda.bpm.engine.task.TaskQuery;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pwc.r2p2.pojo.R2P2Task;
import com.pwc.r2p2.pojo.RequestDetails;

@Controller
@RequestMapping("/bpm")
public class BPMRestController implements ApplicationContextAware {

	private static final Logger log = LogManager.getLogger(BPMRestController.class.getName());

	private ApplicationContext applicationContext;

	@RequestMapping(value = "/fetchHistoryTask", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ServiceResponse fetchHistoryTask(@RequestBody RequestDetails requestDetails,
			HttpServletRequest request) {

		if (log.isDebugEnabled()) {
			log.debug("Start method: BPMRestController.fetchHistoryTask()");
		}

		ServiceResponse res = null;
		System.out.println("test");

		ProcessEngine processEngine = null;
		TaskService taskService = null;
		RuntimeService runtimeService = null;
		TaskQuery createTaskQuery = null;

		try {
			String tertiaryCategoryId = requestDetails.getTertiaryCategoryId();
			String requestId = requestDetails.getRequestId();
			String requester = requestDetails.getRequester();
			String taskName = requestDetails.getTaskName();
			
			processEngine = ProcessEngines.getDefaultProcessEngine();
			runtimeService = processEngine.getRuntimeService();
			ManagementService managementService = processEngine.getManagementService();
			taskService = processEngine.getTaskService();
			createTaskQuery = taskService.createTaskQuery();
			HistoryService historyService = processEngine.getHistoryService();
			HistoricTaskInstanceQuery finished = historyService.createHistoricTaskInstanceQuery().finished();
			// HistoricTaskInstanceQuery processInstanceBusinessKey =
			// finished.processInstanceBusinessKey("requestId");

			List<HistoricTaskInstance> historicProcessInstance = finished
					.processVariableValueEquals("requester", requester).taskName(taskName).list();

			ArrayList<R2P2Task> taskArr = new ArrayList<>();
			for (int i = 0; i < historicProcessInstance.size(); i++) {
				R2P2Task task = new R2P2Task();
				HistoricTaskInstance historicTaskInstance = historicProcessInstance.get(i);

				String id = historicTaskInstance.getId();
				String name = historicTaskInstance.getName();
				String assignee = historicTaskInstance.getAssignee();
				task.setId(id);
				task.setName(name);
				task.setAssignee(assignee);
				System.out.println(historicTaskInstance);
				System.out.println("Variable for this instance+++++++++++++");
				// List<HistoricVariableInstance> HistoricVariableInstance =
				// historyService
				// .createHistoricVariableInstanceQuery()
				// .processInstanceId(historicTaskInstance.getProcessInstanceId()).orderByVariableName().desc().list();
				String isJBR = historyService.createHistoricVariableInstanceQuery()
						.processInstanceId(historicTaskInstance.getProcessInstanceId()).variableName("isJBR")
						.singleResult().getValue().toString();
				String isNIS = historyService.createHistoricVariableInstanceQuery()
						.processInstanceId(historicTaskInstance.getProcessInstanceId()).variableName("isNIS")
						.singleResult().getValue().toString();
				String sortValue = historyService.createHistoricVariableInstanceQuery()
						.processInstanceId(historicTaskInstance.getProcessInstanceId()).variableName("sortValue")
						.singleResult().getValue().toString();

				task.setIsJBR(isJBR);
				task.setIsNIS(isNIS);
				task.setSortValue(sortValue);
				// for (int j = 0; j < HistoricVariableInstance.size(); j++) {
				// System.out.println(HistoricVariableInstance.get(j));
				// }

				taskArr.add(task);
			}
			Collections.sort(taskArr);

			System.out.println("Sorted:");
			for (int i = 0; i < taskArr.size(); i++) {
				R2P2Task task1 = new R2P2Task();
				task1 = (R2P2Task) taskArr.get(i);
				System.out.println(task1.getSortValue());
			}

			res = new ServiceResponse("success", null, taskArr);

		} catch (Exception e) {
			log.error("Exception occured during fetchHistoryTask -- ", e);
			res = new ServiceResponse("success", null, "Exception occured during fetchHistoryTask as "+ e.getMessage());
			e.printStackTrace();
		}

		if (log.isDebugEnabled()) {
			log.debug("End method: BPMRestController.fetchHistoryTask()");
		}

		return res;
	}

	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.applicationContext = appContext;

	}

	public ApplicationContext getApplicationContext() throws BeansException {
		return this.applicationContext;

	}

}