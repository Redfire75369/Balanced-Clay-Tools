/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package mods.redfire.balancedclaytools.tools;

import com.google.common.collect.Multimap;
import mods.redfire.balancedclaytools.BalancedClayTools;
import mods.redfire.balancedclaytools.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static mods.redfire.balancedclaytools.Utilities.filterMultimap;
import static net.minecraft.item.ItemTier.DIAMOND;

public class ClayShovel extends ShovelItem {
	public ClayShovel() {
		super(DIAMOND, 0, 0.0F, new Properties().durability(0).tab(BalancedClayTools.TAB_CLAY_TOOLS));
	}

	@Override
	public boolean mineBlock(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull BlockState state, @Nonnull BlockPos pos, @Nonnull LivingEntity entity) {
		Utilities.onBlockDestroyed(stack, world, stack, pos, entity);
		return true;
	}

	@Override
	public boolean isRepairable(@Nonnull ItemStack stack) {
		return false;
	}

	@Override
	public boolean isEnchantable(@Nonnull ItemStack stack) {
		return false;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return false;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		return Utilities.onLeftClickEntity(stack, player, entity);
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}

	@Override
	public boolean isFoil(@Nonnull ItemStack stack) {
		return true;
	}

	@Override
	public int getItemEnchantability(ItemStack stack) {
		return 0;
	}

	@Override
	public boolean hurtEnemy(@Nonnull ItemStack stack, @Nonnull LivingEntity target, @Nonnull LivingEntity attacker) {
		return false;
	}

	@Nonnull
	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@Nonnull EquipmentSlotType equipmentSlot) {
		return filterMultimap(super.getDefaultAttributeModifiers(equipmentSlot));
	}

	@Override
	public void appendHoverText(@Nonnull ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
		tooltip.add(new TranslationTextComponent("item.balancedclaytools.clay_tool.tooltip"));
	}
}
