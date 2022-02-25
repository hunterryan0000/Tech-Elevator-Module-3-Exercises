package com.techelevator.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import com.techelevator.model.Category;


public class JdbcCategoryDaoTest  extends BaseDaoTests {

    private JdbcCategoryDao categoryDao;

    @Before
    public void setup() {
        categoryDao = new JdbcCategoryDao(dataSource);
    }

    @Test
    public void getCategory_correct_for_id() {
        // TODO
        Assert.fail();
    }

    @Test
    public void getCategory_returns_null_when_id_not_found() {
        // TODO
        Assert.fail();
    }

    @Test
    public void getCategories_returns_all() {
        // TODO
        Assert.fail();
    }

    private void assertCategoriesMatch(Category expected, Category actual) {
        Assert.assertEquals("Category id does not match", expected.getId(), actual.getId());
        Assert.assertEquals("Category name does not match", expected.getName(), actual.getName());
    }
}
