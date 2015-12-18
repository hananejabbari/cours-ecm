package fr.cmm.helper;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


public class Pagination {
    // 1 based page index
    private int pageIndex;

    protected int pageSize;

    private long count;

    public int getPreviousPageIndex() {
        return isFirstPage() ? pageIndex : pageIndex - 1;
    }

    public int getNextPageIndex() {
        return isLastPage() ? pageIndex : pageIndex + 1;
    }

    public boolean isFirstPage() {
        return pageIndex == 1;
    }

    public boolean isLastPage() {
        return pageIndex * pageSize >= count;
    }

    public int getPageCount() {
        if (pageSize == 0)
            return 0;
        else if (count % pageSize == 0) {
            return (int) count / pageSize;
        } else {
            return (int) (1 + count / pageSize);
        }
    }

    public List<Integer> getPages() {
        List<Integer> result = new ArrayList<>();

        int start = pageIndex - 9;
        int end = pageIndex + 9;

        if (start < 1) {
            start = 1;
        }

        if (end > getPageCount()) {
            end = getPageCount();
        }

        while (end - start >= 10) {
            int distanceFromStart = pageIndex - start;
            int distanceFromEnd = end - pageIndex;

            if (distanceFromEnd > distanceFromStart) {
                end -= 1;
            } else {
                start += 1;
            }
        }

        for (int i = start; i <= end; i++) {
            result.add(i);
        }

        return result;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
