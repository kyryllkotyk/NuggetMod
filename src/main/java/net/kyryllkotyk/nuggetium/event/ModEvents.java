package net.kyryllkotyk.nuggetium.event;

import net.kyryllkotyk.nuggetium.item.custom.ModBowItem;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.kyryllkotyk.nuggetium.Nuggetium;

@Mod.EventBusSubscriber(modid = Nuggetium.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onArrowHit(ProjectileImpactEvent event) {
        if (event.getProjectile() instanceof AbstractArrow arrow
                && event.getRayTraceResult().getType() == HitResult.Type.ENTITY) {
            EntityHitResult hitResult = (EntityHitResult) event.getRayTraceResult();
            ModBowItem.onArrowHit(arrow, hitResult.getEntity());
        }
    }
}