package net.samu.mineloween.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.state.property.BooleanProperty;

public class ModScytheItem extends SwordItem {
    private static boolean is_dark;
    public ModScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, boolean is_dark) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.is_dark = is_dark;
    }

    // La falce normale permette di rigenerarsi tramite i danni fatti ai nemici dall'effetto veleno, la falce dark rigenera anche in base ai danni fatti sul colpo
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (is_dark) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 80, 2), attacker);
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80, 3));
        } else {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), attacker);
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1));
        }
        return super.postHit(stack, target, attacker);
    }
}
