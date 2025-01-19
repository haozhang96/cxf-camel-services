package org.haozhang.services.utils;

import jakarta.annotation.Nonnull;
import lombok.Locked;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

public class Stopwatch extends StopWatch {
    public Stopwatch() {
        super();
    }

    public Stopwatch(String id) {
        super(id);
    }

    @Nonnull
    @Locked.Read
    @Override
    public String getId() {
        return super.getId();
    }

    @Locked.Write
    @Override
    public void setKeepTaskList(boolean keepTaskList) {
        super.setKeepTaskList(keepTaskList);
    }

    @Locked.Write
    @Override
    public void start() throws IllegalStateException {
        super.start();
    }

    @Locked.Write
    @Override
    public void start(String taskName) throws IllegalStateException {
        super.start(taskName);
    }

    @Locked.Write
    @Override
    public void stop() throws IllegalStateException {
        super.stop();
    }

    @Locked.Read
    @Override
    public boolean isRunning() {
        return super.isRunning();
    }

    @Locked.Read
    @Override
    public String currentTaskName() {
        return super.currentTaskName();
    }

    @Locked.Read
    @Override
    public TaskInfo lastTaskInfo() throws IllegalStateException {
        return super.lastTaskInfo();
    }

    @Override
    public TaskInfo getLastTaskInfo() throws IllegalStateException {
        return super.getLastTaskInfo();
    }

    @Override
    public String getLastTaskName() throws IllegalStateException {
        return super.getLastTaskName();
    }

    @Override
    public long getLastTaskTimeNanos() throws IllegalStateException {
        return super.getLastTaskTimeNanos();
    }

    @Override
    public long getLastTaskTimeMillis() throws IllegalStateException {
        return super.getLastTaskTimeMillis();
    }

    @Override
    public TaskInfo[] getTaskInfo() {
        return super.getTaskInfo();
    }

    @Override
    public int getTaskCount() {
        return super.getTaskCount();
    }

    @Override
    public long getTotalTimeNanos() {
        return super.getTotalTimeNanos();
    }

    @Override
    public long getTotalTimeMillis() {
        return super.getTotalTimeMillis();
    }

    @Override
    public double getTotalTimeSeconds() {
        return super.getTotalTimeSeconds();
    }

    @Override
    public double getTotalTime(TimeUnit timeUnit) {
        return super.getTotalTime(timeUnit);
    }

    @Override
    public String prettyPrint() {
        return super.prettyPrint();
    }

    @Override
    public String prettyPrint(TimeUnit timeUnit) {
        return super.prettyPrint(timeUnit);
    }

    @Override
    public String shortSummary() {
        return super.shortSummary();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
