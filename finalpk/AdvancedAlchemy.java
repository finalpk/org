package org.finalpk;

import org.finalpk.Items.Chalk;

import net.minecraft.util.RegistryNamespaced;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameData;

@Mod(modid = AdvancedAlchemy.MODID, version = AdvancedAlchemy.VERSION)
public class AdvancedAlchemy {
    public static final String MODID = "Advanced Alchemy";
    public static final String VERSION = "0.1a";
    
    public static final RegistryNamespaced itemRegistry = GameData.itemRegistry;
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        itemRegistry.addObject(4000, "coal", (new Chalk()).setUnlocalizedName("chalk").setTextureName("chalk"));
    }
}

