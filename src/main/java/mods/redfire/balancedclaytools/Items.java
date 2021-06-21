/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package mods.redfire.balancedclaytools;

import mods.redfire.balancedclaytools.tools.*;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static mods.redfire.balancedclaytools.BalancedClayTools.MODID;

public class Items {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	public static final RegistryObject<Item> CLAY_AXE = ITEMS.register("clay_axe", ClayAxe::new);
	public static final RegistryObject<Item> CLAY_HOE = ITEMS.register("clay_hoe", ClayHoe::new);
	public static final RegistryObject<Item> CLAY_PICKAXE = ITEMS.register("clay_pickaxe", ClayPickaxe::new);
	public static final RegistryObject<Item> CLAY_SHEARS = ITEMS.register("clay_shears", ClayShears::new);
	public static final RegistryObject<Item> CLAY_SHOVEL = ITEMS.register("clay_shovel", ClayShovel::new);
	public static final RegistryObject<Item> CLAY_SWORD = ITEMS.register("clay_sword", ClaySword::new);

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}
