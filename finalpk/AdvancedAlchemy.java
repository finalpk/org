package org.finalpk;

import org.finalpk.common.ServerProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = AdvancedAlchemy.MODID, version = AdvancedAlchemy.VERSION, name = "Advanced Alchemy")
public class AdvancedAlchemy {
    public static final String MODID = "AdvancedAlchemy";
    public static final String VERSION = "0.1a";
    
    @SidedProxy(clientSide = "org.finalpk.common.ClientProxy", serverSide = "org.finalpk.common.ServerProxy")
    public static ServerProxy proxy;

    @EventHandler
    public void PreLoad(FMLInitializationEvent event) {
        proxy.registerItems();
        proxy.registerBlocks();
    	proxy.registerRenderThings();
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void PostLoad(FMLInitializationEvent event) {
    	
    }
}

