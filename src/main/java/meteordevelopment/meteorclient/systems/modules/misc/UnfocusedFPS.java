/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.systems.modules.misc;

import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;

public class UnfocusedFPS extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    public final Setting<Integer> fps = sgGeneral.add(new IntSetting.Builder()
        .name("target-fps")
        .description("The FPS limit when the window is not focused.")
        .defaultValue(1)
        .min(1)
        .sliderRange(1, 30)
        .build()
    );

    public UnfocusedFPS() {
        super(Categories.Misc, "unfocused-fps", "Limits FPS when the game window is not focused to reduce CPU usage.");
    }
}
