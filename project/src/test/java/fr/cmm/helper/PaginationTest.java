package fr.cmm.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by pomme on 18/12/2015.
 */
public class PaginationTest {
    @Test
    public void getPageCountWhenCountIsMultipleOfPageSize() {
        Pagination countMultipleSize = new Pagination();
        countMultipleSize.setCount(20);
        countMultipleSize.setPageSize(10);
        assertEquals(2, countMultipleSize.getPageCount());
    }

    @Test
    public void getPageCountWhenCountIsNotMultipleOfPageSize() {
        Pagination countNotMultipleSize = new Pagination();
        countNotMultipleSize.setCount(1);
        countNotMultipleSize.setPageSize(0);
        assertEquals(0, countNotMultipleSize.getPageCount());
    }

    @Test
    public void getPages(){
        Pagination pagination = new Pagination();
        pagination.setCount(200);
        pagination.setPageSize(10);
        pagination.setPageIndex(1);

        assertEquals(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), pagination.getPages());
    }

    @Test
    public void getPagesWithLessThanTenPages(){
        Pagination pagination = new Pagination();
        pagination.setCount(50);
        pagination.setPageSize(10);
        pagination.setPageIndex(1);

        assertEquals(asList(1, 2, 3, 4, 5), pagination.getPages());
    }

    @Test
    public void getPagesWithPageIndex(){
        Pagination pagination = new Pagination();
        pagination.setCount(20);
        pagination.setPageSize(1);
        pagination.setPageIndex(12);

        assertEquals(asList(8, 9, 10, 11, 12, 13, 14, 15, 16, 17), pagination.getPages());
    }

}