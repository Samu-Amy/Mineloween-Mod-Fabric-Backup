package net.samu.mineloween.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CHOCOLATE = new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.15f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100), 0.15f).build();
}
