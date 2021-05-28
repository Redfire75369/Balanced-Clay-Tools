package mods.redfire.balancedclaytools;

import mods.redfire.balancedclaytools.tools.ClayAxe;
import mods.redfire.balancedclaytools.tools.ClayPickaxe;
import mods.redfire.balancedclaytools.tools.ClayShovel;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BalancedClayTools.MODID);

	public static final RegistryObject<Item> CLAY_AXE = ITEMS.register("clay_axe", ClayAxe::new);
	public static final RegistryObject<Item> CLAY_PICKAXE = ITEMS.register("clay_pickaxe", ClayPickaxe::new);
	public static final RegistryObject<Item> CLAY_SHOVEL = ITEMS.register("clay_shovel", ClayShovel::new);

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}
