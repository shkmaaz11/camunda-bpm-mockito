package org.camunda.bpm.extension.mockito.delegate;

import org.camunda.bpm.engine.ProcessEngineServices;
import org.camunda.bpm.engine.variable.impl.value.AbstractTypedValue;
import org.camunda.bpm.engine.variable.type.ValueType;
import org.camunda.bpm.extension.mockito.CamundaMockito;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class DelegateCaseVariableInstanceFakeTest {

  private final DelegateCaseVariableInstanceFake fake = CamundaMockito.delegateCaseVariableInstanceFake();

  private final DelegateCaseExecutionFake caseExecution = CamundaMockito.delegateCaseExecutionFake();
  private final ProcessEngineServices processEngineServices = mock(ProcessEngineServices.class);

  @Test
  public void withFields() {
    fake
      .withActivityInstanceId("activityInstanceId")
      .withCaseExecutionId("caseExecutionId")
      .withCaseInstanceId("caseInstanceId")
      .withEventName("eventName")
      .withErrorMessage("errorMessage")
      .withExecutionId("executionId")
      .withId("id")
      .withName("name")
      .withProcessEngineServices(processEngineServices)
      .withProcessInstanceId("processInstanceId")
      .withSourceExecution(caseExecution)
      .withTaskId("taskId")
      .withTenantId("tenantId")
      .withTypedName("typedName");

    assertThat(fake.getActivityInstanceId()).isEqualTo("activityInstanceId");
    assertThat(fake.getCaseExecutionId()).isEqualTo("caseExecutionId");
    assertThat(fake.getCaseInstanceId()).isEqualTo("caseInstanceId");
    assertThat(fake.getEventName()).isEqualTo("eventName");
    assertThat(fake.getErrorMessage()).isEqualTo("errorMessage");
    assertThat(fake.getExecutionId()).isEqualTo("executionId");
    assertThat(fake.getId()).isEqualTo("id");
    assertThat(fake.getName()).isEqualTo("name");
    assertThat(fake.getProcessEngineServices()).isEqualTo(processEngineServices);
    assertThat(fake.getProcessInstanceId()).isEqualTo("processInstanceId");
    assertThat(fake.getSourceExecution()).isEqualTo(caseExecution);
    assertThat(fake.getTaskId()).isEqualTo("taskId");
    assertThat(fake.getTenantId()).isEqualTo("tenantId");
    assertThat(fake.getTypeName()).isEqualTo("typedName");
  }

  @Test
  public void withTypedValue() {
    fake.withValue(new AbstractTypedValue<>("foo", ValueType.STRING));

    assertThat(fake.getTypedValue().getType()).isEqualTo(ValueType.STRING);
    assertThat(fake.getTypedValue().getValue()).isEqualTo("foo");
  }

  @Test
  public void withValue_undefined() {
    fake.withValue(1L);

    assertThat(fake.getTypedValue().getValue()).isEqualTo(1L);
    assertThat(fake.getTypedValue().getType()).isNull();
  }
}
