/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package mods.redfire.balancedclaytools.tools;

import com.google.common.collect.Multimap;
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
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static mods.redfire.balancedclaytools.BalancedClayTools.TAB_CLAY_TOOLS;
import static mods.redfire.balancedclaytools.Utilities.filterMultimap;
import static net.minecraft.item.ItemTier.DIAMOND;

public class ClayHoe extends HoeItem {
	public ClayHoe() {
		super(DIAMOND, 0, 0.0F, new Properties().durability(0).tab(TAB_CLAY_TOOLS));
	}

	@SuppressWarnings("deprecation")
	@Nonnull
	@Override
	public ActionResultType useOn(@Nonnull ItemUseContext ctx) {
		World world = ctx.getLevel();
		BlockPos blockpos = ctx.getClickedPos();
		int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(ctx);
		if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
		if (ctx.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockpos.above())) {
			BlockState blockstate = world.getBlockState(blockpos).getToolModifiedState(world, blockpos, ctx.getPlayer(), ctx.getItemInHand(), net.minecraftforge.common.ToolType.HOE);
			if (blockstate != null) {
				PlayerEntity playerentity = ctx.getPlayer();
				world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				if (!world.isClientSide) {
					world.setBlock(blockpos, blockstate, 11);
				}
				return ActionResultType.sidedSuccess(world.isClientSide);
			}
		}

		return ActionResultType.PASS;
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
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@Nonnull EquipmentSlotType slot) {
		return filterMultimap(super.getDefaultAttributeModifiers(slot));
	}

	@Override
	public void appendHoverText(@Nonnull ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
		tooltip.add(new TranslationTextComponent("item.balancedclaytools.clay_tool.tooltip").withStyle(TextFormatting.DARK_GRAY));
	}
}
