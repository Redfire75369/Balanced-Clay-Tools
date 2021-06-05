/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package mods.redfire.balancedclaytools;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class Utilities {
	private static final Random random = new Random();

	public static void onBlockDestroyed(ItemStack stack, World world, ItemStack stack1, BlockPos pos, LivingEntity entity) {
		if (random.nextInt(500000) == 2 && !world.isClientSide) {
			ItemEntity entityItem = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(Items.CLAY_BALL));
			world.addFreshEntity(entityItem);
		}
	}

	public static boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		if (entity instanceof CreeperEntity && !player.level.isClientSide) {
			player.getCommandSenderWorld().playSound(player, entity.position().x, entity.position().y, entity.position().z, SoundEvents.CREEPER_PRIMED, SoundCategory.HOSTILE, 1.0F, 0.5F);
		}
		return true;
	}

	public static Multimap<Attribute, AttributeModifier> filterMultimap(Multimap<Attribute, AttributeModifier> map) {
		Multimap<Attribute, AttributeModifier> multimap = ArrayListMultimap.create();
		map.forEach((attribute, modifier) -> {
			if (attribute != Attributes.ATTACK_DAMAGE && attribute != Attributes.ATTACK_SPEED) {
				multimap.put(attribute, modifier);
			}
		});
		return multimap;
	}
}
