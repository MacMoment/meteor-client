/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.mixin;

import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.render.Fullbright;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.world.LightType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldRenderer.BrightnessGetter.class)
public interface BrightnessGetterMixin {

    @ModifyVariable(method = "method_68890", at = @At(value = "STORE"), ordinal = 0)
    private static int getLightmapCoordinatesModifySkyLight(int sky) {
        Fullbright fullbright = Modules.get().get(Fullbright.class);
        return fullbright != null ? Math.max(fullbright.getLuminance(LightType.SKY), sky) : sky;
    }

    @ModifyVariable(method = "method_68890", at = @At(value = "STORE"), ordinal = 1)
    private static int getLightmapCoordinatesModifyBlockLight(int sky) {
        Fullbright fullbright = Modules.get().get(Fullbright.class);
        return fullbright != null ? Math.max(fullbright.getLuminance(LightType.BLOCK), sky) : sky;
    }
}
