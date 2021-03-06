package me.aerclient.implementation.module.modules.world;

import com.darkmagician6.eventapi.EventTarget;
import me.aerclient.injection.events.client.EventValueChanged;
import me.aerclient.implementation.module.base.Category;
import me.aerclient.implementation.module.base.Module;
import me.aerclient.config.valuesystem.NumberValue;
import me.aerclient.implementation.utils.world.TimerUtil;

public class Timer extends Module {

    private NumberValue<Float> speed = new NumberValue<>("Speed", 1.0F, 1F, 10.0F, false);
    private TimerUtil.Timer timer = new TimerUtil.Timer();

    public Timer() {
        super("Timer", Category.WORLD, "Changes client tick speed (TPS)");
    }


    @Override
    public void onEnable(){
        minecraft.timer = new net.minecraft.util.Timer(speed.getValue()*20);
    }

    @EventTarget
    public void onValueUpdate(EventValueChanged event) {
        if(timer.delay(150)) {
            minecraft.timer = new net.minecraft.util.Timer(speed.getValue() * 20);
            timer.reset();
        }
    }

    @Override
    public void onDisable(){
        minecraft.timer = new net.minecraft.util.Timer(20.0F);
    }

}
