package org.example;

import java.util.Date;


class TimeSlot {
    private Date startTime;
    private Date endTime;

    public TimeSlot(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}