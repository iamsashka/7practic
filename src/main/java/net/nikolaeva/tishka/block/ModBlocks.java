package net.nikolaeva.tishka.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nikolaeva.tishka.Item.ModItems;
import net.nikolaeva.tishka.tishka;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, tishka.MOD_ID);

    public static final RegistryObject<Block> KAKOITO_BLOCK = registryBlock("kakoito_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CYBER_WALL = registryBlock("cyber_wall",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NEON_LIGHT = registryBlock("neon_light",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METAL_FLOOR = registryBlock("metal_floor",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()));

    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturns = BLOCKS.register(name,block);
        registryBlockItem(name, toReturns, CreativeModeTab.TAB_MISC);
        return toReturns;
    }

    public static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}