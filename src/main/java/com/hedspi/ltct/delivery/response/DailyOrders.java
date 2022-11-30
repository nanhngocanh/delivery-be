package com.hedspi.ltct.delivery.response;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class DailyOrders {

    private long count;
    private LocalDate createAt;

    public DailyOrders(long count, LocalDate createAt) {
        this.count = count;
        this.createAt = createAt;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
