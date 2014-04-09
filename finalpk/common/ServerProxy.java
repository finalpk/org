package org.finalpk.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.finalpk.CreativeTab;
import org.finalpk.Blocks.BlockChalk;
import org.finalpk.Items.ItemChalk;

import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {
	
	public static Item itemChalk;
	public static Block blockChalk;
    public static CreativeTabs tabAdvancedAlchemy = new CreativeTab("AdvancedAlchemy");

	public void registerRenderThings() {
		
	}
	
	public void registerItems() {
        itemChalk = new ItemChalk().setUnlocalizedName("Chalk");
        GameRegistry.registerItem(itemChalk, itemChalk.getUnlocalizedName());
	}
	
	public void registerBlocks() {
		blockChalk = new BlockChalk().setBlockName("blockChalk");
        GameRegistry.registerBlock(blockChalk, blockChalk.getUnlocalizedName());
	}
}
