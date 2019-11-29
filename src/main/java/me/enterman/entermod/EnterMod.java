package me.enterman.entermod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

@Mod(modid = EnterMod.MODID, name = EnterMod.NAME, version = EnterMod.VERSION)
public class EnterMod
{
    public static final String MODID = "entermod";
    public static final String NAME = "My Utils";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> ev)
    {
        Item comprCore = new Item();
        comprCore.setRegistryName("comprcore");
        ItemStack comprCoreStack = new ItemStack(comprCore);
        // Register Creative Tab
        CreativeTabs tab = new CreativeTabs("entertab") {
            @Override
            public ItemStack getTabIconItem() {
                return comprCoreStack;
            }
            @Override
            public boolean hasSearchBar(){return true;}
        };
        comprCore.setCreativeTab(CreativeTabs.MISC);
        // Register Compressive Core
        ForgeRegistries.ITEMS.registerAll(comprCore);
        comprCore.setMaxStackSize(8);
    }
}
