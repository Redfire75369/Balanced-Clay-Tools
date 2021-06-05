/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package mods.redfire.balancedclaytools;

import mods.redfire.balancedclaytools.setup.ClientSetup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

@Mod(BalancedClayTools.MODID)
public class BalancedClayTools {
	public static final String MODID = "balancedclaytools";
	public static final Logger LOGGER = LogManager.getLogger();

	public static final ItemGroup TAB_CLAY_TOOLS = new ItemGroup("balancedclaytools") {
		@Nonnull
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.CLAY_PICKAXE.get());
		}
	};

	public BalancedClayTools() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		Items.register(bus);
		bus.addListener(ClientSetup::init);
	}
}
