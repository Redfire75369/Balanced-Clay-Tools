package mods.redfire.balancedclaytools.setup;

import mods.redfire.balancedclaytools.BalancedClayTools;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BalancedClayTools.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
	public static void init(final FMLClientSetupEvent event) {}

	@SubscribeEvent
	public void onTooltipPre(RenderTooltipEvent.Pre event) {
		Item item = event.getStack().getItem();
		if (item.getRegistryName().getNamespace().equals(BalancedClayTools.MODID)) {
			event.setMaxWidth(200);
		}
	}
}
