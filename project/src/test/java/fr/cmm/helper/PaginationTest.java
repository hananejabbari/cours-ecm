package fr.cmm.helper;

import org.junit.Test;

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

}