package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_components.alarm.Alarm;
import ru.sbt.mipt.oop.home_components.alarm.AlarmOnAlertState;

public class InvokeAlertAlarmCommand implements Command {
    private SmartHome smartHome;

    public InvokeAlertAlarmCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {
        Alarm alarm = smartHome.getAlarm();
        if (alarm == null) {
            return false;
        }
        smartHome.getAlarm().setState(new AlarmOnAlertState(alarm));
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.INVOKE_ALERT_ALARM;
    }
}