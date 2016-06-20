package joshie.harvest.items;

import joshie.harvest.api.core.ICreativeSorted;
import joshie.harvest.core.HFTab;
import joshie.harvest.core.util.base.ItemHFBaseMeta;
import joshie.harvest.core.util.generic.Text;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import static net.minecraft.util.text.TextFormatting.*;

public class ItemGeneral extends ItemHFBaseMeta implements ICreativeSorted {
    public static final int BLUE_FEATHER = 0;
    public static final int JUNK_ORE = 1;
    public static final int COPPER_ORE = 2;
    public static final int SILVER_ORE = 3;
    public static final int GOLD_ORE = 4;
    public static final int MYSTRIL_ORE = 5;
    public static final int MYTHIC_STONE = 6;

    @Override
    public int getMetaCount() {
        return 22;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getName(stack);
    }

    @Override
    public String getName(ItemStack stack) {
        switch (stack.getItemDamage()) {
            case BLUE_FEATHER:
                return "feather_blue";
            case JUNK_ORE:
                return "ore_junk";
            case COPPER_ORE:
                return "ore_copper";
            case SILVER_ORE:
                return "ore_silver";
            case GOLD_ORE:
                return "ore_gold";
            case MYSTRIL_ORE:
                return "ore_mystril";
            case MYTHIC_STONE:
                return "stone_mythic";
            default:
                return "invalid";
        }
    }

    @Override
    public boolean isValidTab(CreativeTabs tab, int meta) {
        switch (meta) {
            case BLUE_FEATHER:
                return tab == HFTab.TOWN;
            case JUNK_ORE:
            case COPPER_ORE:
            case SILVER_ORE:
            case GOLD_ORE:
            case MYSTRIL_ORE:
            case MYTHIC_STONE:
                return tab == HFTab.MINING;
            default:
                return false;
        }
    }





    @Override
    public int getSortValue(ItemStack stack) {
        if (stack.getItemDamage() == BLUE_FEATHER) return 1;
        if (stack.getItemDamage() >= JUNK_ORE && stack.getItemDamage() <= MYTHIC_STONE) {
            return 10 + stack.getItemDamage();
        }

        return 102;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        switch (stack.getItemDamage()) {
            case BLUE_FEATHER:
                return AQUA + super.getItemStackDisplayName(stack);
            case MYTHIC_STONE:
                return GREEN + super.getItemStackDisplayName(stack);
            default:
                return WHITE + super.getItemStackDisplayName(stack);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean flag) {
        if (stack.getItemDamage() == MYTHIC_STONE)
            list.add(Text.translate("tooltip.mythic_stone"));
    }
}