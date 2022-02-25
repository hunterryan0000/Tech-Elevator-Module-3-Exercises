package com.techelevator.dao;

import com.techelevator.model.Task;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JdbcTaskDaoTest extends BaseDaoTests {

    private JdbcTaskDao dao;

    @Before
    public void setup() {
        dao = new JdbcTaskDao(dataSource);
    }

    @Test
    public void getTask_returns_correctly_for_id() {
        // TODO
        Assert.fail();
    }

    @Test
    public void getTask_returns_null_when_id_not_found() {
        // TODO
        Assert.fail();
    }

    @Test
    public void getAllTasks_returns_all() {
        // TODO
        Assert.fail();
    }

    @Test
    public void created_task_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void updated_task_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void deleted_task_cant_be_retrieved() {
        Assert.fail();
    }

    private void assertTasksMatch(Task expected, Task actual) {
        Assert.assertEquals("Task id does not match", expected.getId(), actual.getId());
        Assert.assertEquals("Task description does not match", expected.getDescription(),
                actual.getDescription());
    }
}
